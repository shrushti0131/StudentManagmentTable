package StudentManagementProject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;

public class StudentManagementGUI extends JFrame {

    JTable table;
    DefaultTableModel model;

    public StudentManagementGUI() {

        setTitle("Student Information Management System");
        setSize(900, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] columns = {
                "USN", "NAME", "BRANCH",
                "SEM", "COLLEGE", "MARKS"
        };

        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);

        JButton btnLoad = new JButton("Load Student Data");

        btnLoad.addActionListener(e -> loadData());

        add(scrollPane, BorderLayout.CENTER);
        add(btnLoad, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void loadData() {

        model.setRowCount(0);

        try {
            BufferedReader br =
                    new BufferedReader(new FileReader("students.txt.txt"));

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                model.addRow(new Object[] {
                        data[0],
                        data[1],
                        data[2],
                        data[3],
                        data[4],
                        data[5]
                });
            }

            br.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error : " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new StudentManagementGUI();
    }
}