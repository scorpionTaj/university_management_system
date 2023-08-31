package university.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.util.Random;

public class UpdateTeacher extends JFrame implements ActionListener {
    JTextField textAddress, textPhone, textemail, textCin, textcourse, textbranch;
    JLabel emptext;
    JButton submit, cancel;
    Choice cempID;

    UpdateTeacher() {
        getContentPane().setBackground(new Color(230, 210, 252));

        JLabel heading = new JLabel("Update Teacher Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 35));
        add(heading);

        JLabel empID = new JLabel("select Employee ID");
        empID.setBounds(50, 100, 200, 20);
        empID.setFont(new Font("serif", Font.PLAIN, 20));
        add(empID);

        cempID = new Choice();
        cempID.setBounds(250, 100, 200, 20);
        add(cempID);

        try {
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("select * from teacher");
            while (rs.next()) {
                cempID.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 100, 30);
        name.setFont(new Font("serif", Font.BOLD, 20));
        add(name);

        JLabel textName = new JLabel();
        textName.setBounds(150, 150, 150, 30);
        add(textName);

        JLabel fname = new JLabel("Father Name");
        fname.setBounds(400, 150, 200, 30);
        fname.setFont(new Font("serif", Font.BOLD, 20));
        add(fname);

        JLabel textfather = new JLabel();
        textfather.setBounds(600, 150, 150, 30);
        add(textfather);

        JLabel EMPID = new JLabel("Employee ID");
        EMPID.setBounds(50, 200, 200, 30);
        EMPID.setFont(new Font("serif", Font.BOLD, 20));
        add(EMPID);

        emptext = new JLabel();
        emptext.setBounds(200, 200, 150, 30);
        emptext.setFont(new Font("serif", Font.BOLD, 20));
        add(emptext);

        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(400, 200, 200, 30);
        dob.setFont(new Font("serif", Font.BOLD, 20));
        add(dob);

        JLabel dobdob = new JLabel();
        dobdob.setBounds(600, 200, 150, 30);
        add(dobdob);

        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 200, 30);
        address.setFont(new Font("serif", Font.BOLD, 20));
        add(address);

        textAddress = new JTextField();
        textAddress.setBounds(150, 250, 200, 30);
        add(textAddress);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(400, 250, 200, 30);
        phone.setFont(new Font("serif", Font.BOLD, 20));
        add(phone);

        textPhone = new JTextField();
        textPhone.setBounds(600, 250, 150, 30);
        add(textPhone);

        JLabel email = new JLabel("Email");
        email.setBounds(50, 300, 200, 30);
        email.setFont(new Font("serif", Font.BOLD, 20));
        add(email);

        textemail = new JTextField();
        textemail.setBounds(150, 300, 200, 30);
        add(textemail);

        JLabel M10 = new JLabel("Class X (%)");
        M10.setBounds(400, 300, 200, 30);
        M10.setFont(new Font("serif", Font.BOLD, 20));
        add(M10);

        JLabel textM10 = new JLabel();
        textM10.setBounds(600, 300, 150, 30);
        add(textM10);

        JLabel M12 = new JLabel("Class XII (%)");
        M12.setBounds(50, 350, 150, 30);
        M12.setFont(new Font("serif", Font.BOLD, 20));
        add(M12);

        JLabel textM12 = new JLabel();
        textM12.setBounds(200, 350, 150, 30);
        add(textM12);

        JLabel CinNo = new JLabel("CIN Number");
        CinNo.setBounds(400, 350, 200, 30);
        CinNo.setFont(new Font("serif", Font.BOLD, 20));
        add(CinNo);

        textCin = new JTextField();
        textCin.setBounds(600, 350, 150, 30);
        add(textCin);

        JLabel Qualification = new JLabel("Qualification");
        Qualification.setBounds(50, 400, 200, 30);
        Qualification.setFont(new Font("serif", Font.BOLD, 20));
        add(Qualification);

        textcourse = new JTextField();
        textcourse.setBounds(200, 400, 150, 30);
        add(textcourse);

        JLabel Department = new JLabel("Department");
        Department.setBounds(400, 400, 200, 30);
        Department.setFont(new Font("serif", Font.BOLD, 20));
        add(Department);

        textbranch = new JTextField();
        textbranch.setBounds(600, 400, 150, 30);
        add(textbranch);

        try {
            Conn c = new Conn();
            String query = "select * from teacher where empId = '" + cempID.getSelectedItem() + "'";
            ResultSet rs = c.statement.executeQuery(query);
            while (rs.next()) {
                textName.setText(rs.getString("name"));
                textfather.setText(rs.getString("fname"));
                dobdob.setText(rs.getString("dob"));
                textAddress.setText(rs.getString("address"));
                textPhone.setText(rs.getString("phone"));
                textemail.setText(rs.getString("email"));
                textM10.setText(rs.getString("class_X"));
                textM12.setText(rs.getString("class_XII"));
                textCin.setText(rs.getString("cin"));
                emptext.setText(rs.getString("empId"));
                textcourse.setText(rs.getString("education"));
                textbranch.setText(rs.getString("department"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        cempID.addItemListener((new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    Conn c = new Conn();
                    String query = "select * from teacher where empId = '" + cempID.getSelectedItem() + "'";
                    ResultSet rs = c.statement.executeQuery(query);
                    while (rs.next()) {
                        textName.setText(rs.getString("name"));
                        textfather.setText(rs.getString("fname"));
                        dobdob.setText(rs.getString("dob"));
                        textAddress.setText(rs.getString("address"));
                        textPhone.setText(rs.getString("phone"));
                        textemail.setText(rs.getString("email"));
                        textM10.setText(rs.getString("class_X"));
                        textM12.setText(rs.getString("class_XII"));
                        textCin.setText(rs.getString("cin"));
                        emptext.setText(rs.getString("empId"));
                        textcourse.setText(rs.getString("education"));
                        textbranch.setText(rs.getString("department"));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        }));

        submit = new JButton("Update");
        submit.setBounds(250, 550, 120, 30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 550, 120, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900, 700);
        setLocation(350, 50);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new UpdateTeacher();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String empid = emptext.getText();
            String address = textAddress.getText();
            String phone = textPhone.getText();
            String email = textemail.getText();
            String cin = textCin.getText();
            String course = textcourse.getText();
            String branch = textbranch.getText();

            try {
                String q = "update teacher set address = '" + address + "', phone = '" + phone + "', email = '" + email + "'cin = '" + cin + "', education = '" + course + "', department = '" + branch + "' where empId = '" + empid + "'";
                Conn c = new Conn();
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Teacher Details Updated Successfully");
                this.setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            this.setVisible(false);
        }
    }
}
