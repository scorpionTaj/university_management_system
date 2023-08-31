package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class StudentFeeForm extends JFrame implements ActionListener {
    Choice Crollnumber;
    JLabel totalAmount;
    JButton pay, update, back;
    JComboBox courseBox, departmentBox, semesterBox;

    StudentFeeForm() {
        getContentPane().setBackground(new Color(210, 252, 251));

        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icon/fee.png"));
        Image img2 = img1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel img = new JLabel(img3);
        img.setBounds(570, 50, 500, 300);
        add(img);

        JLabel rollnumber = new JLabel("Select Roll Number");
        rollnumber.setBounds(40, 60, 150, 20);
        rollnumber.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(rollnumber);

        Crollnumber = new Choice();
        Crollnumber.setBounds(200, 60, 150, 20);
        add(Crollnumber);

        try {
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("select * from student");
            while (rs.next()) {
                Crollnumber.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel name = new JLabel("Name");
        name.setBounds(40, 100, 150, 20);
        name.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(name);

        JLabel textName = new JLabel();
        textName.setBounds(200, 100, 150, 20);
        textName.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(textName);

        JLabel fName = new JLabel("Father Name");
        fName.setBounds(40, 140, 150, 20);
        fName.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(fName);

        JLabel textFName = new JLabel();
        textFName.setBounds(200, 140, 150, 20);
        textFName.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(textFName);

        try {
            Conn c = new Conn();
            String Q = "select * from student where rollno = '" + Crollnumber.getSelectedItem() + "'";
            ResultSet rs = c.statement.executeQuery(Q);
            while (rs.next()) {
                textName.setText(rs.getString("name"));
                textFName.setText(rs.getString("fname"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Crollnumber.addItemListener((new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String Q = "select * from student where rollno = '" + Crollnumber.getSelectedItem() + "'";
                    ResultSet rs = c.statement.executeQuery(Q);
                    while (rs.next()) {
                        textName.setText(rs.getString("name"));
                        textFName.setText(rs.getString("fname"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }));

        JLabel Qualification = new JLabel("Course");
        Qualification.setBounds(40, 180, 150, 30);
        Qualification.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(Qualification);

        String[] course = {"DAI", "English", "Arabe", "French", "Math", "Networking", "GNU/Linux", "Windows/Windows Server", "Communication"};
        courseBox = new JComboBox<>(course);
        courseBox.setBounds(200, 180, 150, 20);
        courseBox.setBackground(Color.WHITE);
        add(courseBox);

        JLabel Department = new JLabel("Branch");
        Department.setBounds(40, 220, 150, 20);
        Department.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(Department);

        String[] department = {"SRI", "DSI"};
        departmentBox = new JComboBox<>(department);
        departmentBox.setBounds(200, 220, 150, 20);
        departmentBox.setBackground(Color.WHITE);
        add(departmentBox);

        JLabel textSemester = new JLabel("Semester");
        textSemester.setBounds(40, 260, 150, 20);
        textSemester.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(textSemester);

        String[] semester = {"Semester1", "Semester2", "Semester3", "Semester4"};
        semesterBox = new JComboBox<>(semester);
        semesterBox.setBounds(200, 260, 150, 20);
        add(semesterBox);

        JLabel total = new JLabel("Total Payable");
        total.setBounds(40, 300, 150, 20);
        total.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(total);

        totalAmount = new JLabel();
        totalAmount.setBounds(200, 300, 150, 20);
        totalAmount.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(totalAmount);

        update = new JButton("Update");
        update.setBounds(40, 340, 100, 30);
        update.addActionListener(this);
        add(update);

        pay = new JButton("Pay");
        pay.setBounds(150, 340, 100, 30);
        pay.addActionListener(this);
        add(pay);

        back = new JButton("Back");
        back.setBounds(260, 340, 100, 30);
        back.addActionListener(this);
        add(back);

        setSize(1000, 500);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new StudentFeeForm();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == update) {
            String course = (String) courseBox.getSelectedItem();
            String semester = (String) semesterBox.getSelectedItem();
            try {
                Conn c = new Conn();
                ResultSet rs = c.statement.executeQuery("select * from fee where course = '" + course + "'");
                while (rs.next()) {
                    totalAmount.setText(rs.getString(semester));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == pay) {
            String rollno = Crollnumber.getSelectedItem();
            String course = (String) courseBox.getSelectedItem();
            String semester = (String) semesterBox.getSelectedItem();
            String branch = (String) departmentBox.getSelectedItem();
            String total = totalAmount.getText();

            try {
                Conn c = new Conn();
                String q = "insert into feecollege values('" + rollno + "', '" + course + "', '" + branch + "', '" + semester + "', '" + total + "')";
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Fee Submitted Successfully");
                this.setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            this.setVisible(false);
        }
    }
}
