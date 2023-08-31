package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class EnterMarks extends JFrame implements ActionListener {
    Choice choiceRollNo;
    JComboBox comboBoxSemester;
    JTextField sub1, sub2, sub3, sub4, sub5, mrk1, mrk2, mrk3, mrk4, mrk5;

    JButton submit, cancel;

    EnterMarks() {
        getContentPane().setBackground(new Color(252, 245, 210));

        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icon/exam.png"));
        Image img2 = img1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel img = new JLabel(img3);
        img.setBounds(500, 40, 400, 300);
        add(img);

        JLabel heading = new JLabel("Enter Marks of Student");
        heading.setBounds(50, 0, 500, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);

        JLabel rollNo = new JLabel("Select Roll Number");
        rollNo.setBounds(50, 70, 150, 20);
        add(rollNo);

        choiceRollNo = new Choice();
        choiceRollNo.setBounds(200, 70, 150, 20);
        add(choiceRollNo);

        try {
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("select * from student");
            while (rs.next()) {
                choiceRollNo.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel sem = new JLabel("Select Semester");
        sem.setBounds(50, 110, 150, 20);
        add(sem);

        String[] semestre = {"1st Semester ", "2nd Semester", "3rd Semester", "4th Semester"};
        comboBoxSemester = new JComboBox<>(semestre);
        comboBoxSemester.setBounds(200, 110, 150, 20);
        comboBoxSemester.setBackground(Color.WHITE);
        add(comboBoxSemester);

        JLabel entersub = new JLabel("Enter Subject");
        entersub.setBounds(100, 150, 200, 40);
        add(entersub);

        sub1 = new JTextField();
        sub1.setBounds(50, 200, 200, 20);
        add(sub1);

        sub2 = new JTextField();
        sub2.setBounds(50, 230, 200, 20);
        add(sub2);

        sub3 = new JTextField();
        sub3.setBounds(50, 260, 200, 20);
        add(sub3);

        sub4 = new JTextField();
        sub4.setBounds(50, 290, 200, 20);
        add(sub4);

        sub5 = new JTextField();
        sub5.setBounds(50, 320, 200, 20);
        add(sub5);

        JLabel entermarks = new JLabel("Enter Marks");
        entermarks.setBounds(250, 150, 200, 40);
        add(entermarks);

        mrk1 = new JTextField();
        mrk1.setBounds(250, 200, 100, 20);
        add(mrk1);

        mrk2 = new JTextField();
        mrk2.setBounds(250, 230, 100, 20);
        add(mrk2);

        mrk3 = new JTextField();
        mrk3.setBounds(250, 260, 100, 20);
        add(mrk3);

        mrk4 = new JTextField();
        mrk4.setBounds(250, 290, 100, 20);
        add(mrk4);

        mrk5 = new JTextField();
        mrk5.setBounds(250, 320, 100, 20);
        add(mrk5);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(70, 370, 150, 25);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(280, 370, 150, 25);
        cancel.addActionListener(this);
        add(cancel);

        setSize(1000, 500);
        this.setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new EnterMarks();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            try {
                Conn c = new Conn();
                String Q1 = "insert into subject values('" + choiceRollNo.getSelectedItem() + "','" + comboBoxSemester.getSelectedItem() + "','" + sub1.getText() + "','" + sub2.getText() + "','" + sub3.getText() + "','" + sub4.getText() + "','" + sub5.getText() + "')";
                String Q2 = "insert into marks values('" + choiceRollNo.getSelectedItem() + "','" + comboBoxSemester.getSelectedItem() + "', '" + mrk1.getText() + "','" + mrk2.getText() + "','" + mrk3.getText() + "','" + mrk4.getText() + "','" + mrk5.getText() + "')";

                c.statement.executeUpdate(Q1);
                c.statement.executeUpdate(Q2);
                JOptionPane.showMessageDialog(null, "Marks Inserted Successfully");
                this.setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            this.setVisible(false);
        }
    }
}
