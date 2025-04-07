package employeeMVC;

import javax.swing.*;
import java.awt.*;

public class EmployeeView extends JFrame {
    private JTextField textID, textName, textAge, textCty;
    private JTable tb;
    private JButton btnAdd, btnUpdate, btnDelete;

    public EmployeeView() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("CRUD Operation Swing MySQL");
        getContentPane().setBackground(new Color(250, 250, 250));
        setLayout(null);
        setBounds(330, 150, 900, 450);

        JLabel header = new JLabel("Manager management");
        header.setBounds(5, 15, 200, 30);
        header.setForeground(Color.red);
        add(header);

        initializeFormPanel();
        initializeTablePanel();

        setVisible(true);
    }

    private void initializeFormPanel() {
        JPanel panelSystem = new JPanel();
        panelSystem.setBounds(10, 50, 400, 300);
        panelSystem.setLayout(null);
        panelSystem.setBorder(BorderFactory.createLineBorder(Color.black));
        add(panelSystem);

        JLabel labelID = new JLabel("ID");
        JLabel labelName = new JLabel("Name");
        JLabel labelAge = new JLabel("Age");
        JLabel labelCty = new JLabel("Cty");

        labelID.setBounds(20, 40, 50, 20);
        labelName.setBounds(20, 70, 50, 20);
        labelAge.setBounds(20, 100, 50, 20);
        labelCty.setBounds(20, 130, 50, 20);

        panelSystem.add(labelID);
        panelSystem.add(labelName);
        panelSystem.add(labelAge);
        panelSystem.add(labelCty);

        textID = new JTextField();
        textName = new JTextField();
        textAge = new JTextField();
        textCty = new JTextField();

        textID.setBounds(90, 40, 260, 20);
        textName.setBounds(90, 70, 260, 20);
        textAge.setBounds(90, 100, 260, 20);
        textCty.setBounds(90, 130, 260, 20);

        panelSystem.add(textID);
        panelSystem.add(textName);
        panelSystem.add(textAge);
        panelSystem.add(textCty);

        btnAdd = new JButton("Add");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");

        btnAdd.setBounds(90, 180, 80, 30);
        btnUpdate.setBounds(170, 180, 80, 30);
        btnDelete.setBounds(250, 180, 80, 30);

        panelSystem.add(btnAdd);
        panelSystem.add(btnUpdate);
        panelSystem.add(btnDelete);

        panelSystem.setVisible(true);
    }

    private void initializeTablePanel() {
        JPanel panelTable = new JPanel();
        panelTable.setBounds(430, 50, 450, 300);
        panelTable.setLayout(null);
        panelTable.setBorder(BorderFactory.createLineBorder(Color.black));
        add(panelTable);        

        tb = new JTable();
        tb.setBounds(0, 0, 445, 295);
        panelTable.add(tb);
    }

    public JTextField getTextID() {
        return textID;
    }

    public JTextField getTextName() {
        return textName;
    }

    public JTextField getTextAge() {
        return textAge;
    }

    public JTextField getTextCty() {
        return textCty;
    }

    public JTable getTable() {
        return tb;
    }

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public JButton getBtnUpdate() {
        return btnUpdate;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }
}
