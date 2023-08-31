package university.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class ExaminationDetails extends JFrame implements ActionListener {
    JTextField search;
    JButton result, back;
    JTable table;

    ExaminationDetails() {
        getContentPane().setBackground(new Color(241, 252, 210));

        JLabel heading = new JLabel("Check Result");
        heading.setBounds(350, 15, 400, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        add(heading);

        search = new JTextField();
        search.setBounds(80, 90, 200, 30);
        search.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(search);

        result = new JButton("Result");
        result.setBounds(300, 90, 120, 30);
        result.setBackground(Color.BLACK);
        result.setForeground(Color.WHITE);
        result.addActionListener(this);
        add(result);

        back = new JButton("Back");
        back.setBounds(450, 90, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        table = new JTable();
        JScrollPane js = new JScrollPane(table);
        js.setBounds(0, 130, 1000, 300);
        add(js);

        try {
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row, 2).toString());
            }
        });

        setSize(1000, 500);
        this.setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ExaminationDetails();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == result) {
            setVisible(false);
            new Marks(search.getText());
        } else {
            setVisible(false);
        }
    }
}
