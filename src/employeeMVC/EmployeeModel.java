package employeeMVC;

import java.sql.*;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EmployeeModel {
    private Connection connect;
    
    public EmployeeModel() {
        connectToDatabase();
    }

    public void connectToDatabase() {
        try {
            String url = "jdbc:mysql://127.0.0.1:3306/quanLyNhanVien";
            String user = "root";
            String password = "10092412";
            connect = DriverManager.getConnection(url, user, password);
            System.out.println("Kết nối thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (connect != null && !connect.isClosed()) {
                connect.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean insertData(String ID, String Name, String Age, String Cty) {
        String query = "INSERT INTO employees (Employee_ID, Name, Age, Cty) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connect.prepareStatement(query)) {
            stmt.setString(1, ID);
            stmt.setString(2, Name);
            stmt.setString(3, Age);
            stmt.setString(4, Cty);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateData(String prevID, String ID, String Name, String Age, String Cty) {
        String query = "UPDATE employees SET Employee_ID=?, Name=?, Age=?, Cty=? WHERE ID=?";
        try (PreparedStatement stmt = connect.prepareStatement(query)) {
            stmt.setString(1, ID);
            stmt.setString(2, Name);
            stmt.setString(3, Age);
            stmt.setString(4, Cty);
            stmt.setString(5, prevID);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteData(String ID) {
        String query = "DELETE FROM employees WHERE Employee_ID=?";
        try (PreparedStatement stmt = connect.prepareStatement(query)) {
            stmt.setString(1, ID);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void loadTableData(JTable table) {
        String query = "SELECT * FROM employees";
        try (Statement stmt = connect.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            int columnCount = rs.getMetaData().getColumnCount();
            Object[] columnNames = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                columnNames[i - 1] = rs.getMetaData().getColumnName(i);
            }

            rs.last();
            int rowCount = rs.getRow();
            rs.beforeFirst();
            Object[][] data = new Object[rowCount][columnCount];
            int row = 0;
            while (rs.next()) {
                for (int col = 1; col <= columnCount; col++) {
                    data[row][col - 1] = rs.getObject(col);
                }
                row++;
            }

            table.setModel(new DefaultTableModel(data, columnNames));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
