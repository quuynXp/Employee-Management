package employeeMVC;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeController {
    private EmployeeModel model;
    private EmployeeView view;

    public EmployeeController(EmployeeModel model, EmployeeView view) {
        this.model = model;
        this.view = view;

        view.getBtnAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.insertData(view.getTextID().getText(), view.getTextName().getText(), view.getTextAge().getText(), view.getTextCty().getText())) {
                    model.loadTableData(view.getTable());
                    view.getTextID().setText("");
                    view.getTextName().setText("");
                    view.getTextAge().setText("");
                    view.getTextCty().setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "ID đã tồn tại, vui lòng chọn ID khác");
                }
            }
        });

        view.getBtnDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.deleteData(view.getTextID().getText())) {
                    model.loadTableData(view.getTable());
                    view.getTextID().setText("");
                    view.getTextName().setText("");
                    view.getTextAge().setText("");
                    view.getTextCty().setText("");
                }
            }
        });

        view.getBtnUpdate().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.updateData(view.getTextID().getText(), view.getTextID().getText(), view.getTextName().getText(), view.getTextAge().getText(), view.getTextCty().getText())) {
                    model.loadTableData(view.getTable());
                }
            }
        });

        view.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = view.getTable().getSelectedRow();
                    if (selectedRow != -1) {
                        view.getTextID().setText(view.getTable().getValueAt(selectedRow, 0).toString());
                        view.getTextName().setText(view.getTable().getValueAt(selectedRow, 1).toString());
                        view.getTextAge().setText(view.getTable().getValueAt(selectedRow, 2).toString());
                        view.getTextCty().setText(view.getTable().getValueAt(selectedRow, 3).toString());
                    }
                }
            }
        });

        model.loadTableData(view.getTable());
    }
    
    public void close() {
        model.closeConnection();
    }

    public static void main(String[] args) {
        EmployeeModel model = new EmployeeModel();
        EmployeeView view = new EmployeeView();
        EmployeeController controller = new EmployeeController(model, view);

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                controller.close();
            }
        }));
    }
}
