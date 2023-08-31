package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_class extends JFrame implements ActionListener {
    main_class() {
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icon/third.jpg"));
        Image img2 = img1.getImage().getScaledInstance(1600, 800, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel img = new JLabel(img3);
        add(img);

        JMenuBar mb = new JMenuBar();

        //new information menu

        JMenu NewInfo = new JMenu("New Information");
        NewInfo.setForeground(Color.BLACK);
        mb.add(NewInfo);

        JMenuItem FacultyInfo = new JMenuItem("New Faculty Information");
        FacultyInfo.setBackground(Color.white);
        FacultyInfo.addActionListener(this);
        NewInfo.add(FacultyInfo);

        JMenuItem StudentInfo = new JMenuItem("New Student Information");
        StudentInfo.setBackground(Color.white);
        StudentInfo.addActionListener(this);
        NewInfo.add(StudentInfo);

        //details

        JMenu Details = new JMenu("View Details");
        Details.setForeground(Color.BLACK);
        mb.add(Details);

        JMenuItem FacultyDetails = new JMenuItem("View Faculty Details");
        FacultyDetails.setBackground(Color.white);
        FacultyDetails.addActionListener(this);
        Details.add(FacultyDetails);

        JMenuItem StudentDetails = new JMenuItem("View Student Details");
        StudentDetails.setBackground(Color.white);
        StudentDetails.addActionListener(this);
        Details.add(StudentDetails);

        setJMenuBar(mb);

        setSize(1600, 900);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Leave

        JMenu Leave = new JMenu("Apply Leave");
        Leave.setForeground(Color.BLACK);
        mb.add(Leave);

        JMenuItem FacultyLeave = new JMenuItem("Faculty Leave");
        FacultyLeave.setBackground(Color.white);
        FacultyLeave.addActionListener(this);
        Leave.add(FacultyLeave);

        JMenuItem StudentLeave = new JMenuItem("Student Leave");
        StudentLeave.setBackground(Color.white);
        StudentLeave.addActionListener(this);
        Leave.add(StudentLeave);

        //Leave Details

        JMenu LeaveDetails = new JMenu("View Leave Details");
        LeaveDetails.setForeground(Color.BLACK);
        mb.add(LeaveDetails);

        JMenuItem FacultyLeaveDetails = new JMenuItem("Faculty Leave Details");
        FacultyLeaveDetails.setBackground(Color.white);
        FacultyLeaveDetails.addActionListener(this);
        LeaveDetails.add(FacultyLeaveDetails);

        JMenuItem StudentLeaveDetails = new JMenuItem("Student Leave Details");
        StudentLeaveDetails.setBackground(Color.white);
        StudentLeaveDetails.addActionListener(this);
        LeaveDetails.add(StudentLeaveDetails);

        //exam

        JMenu Exam = new JMenu("Examination");
        Exam.setForeground(Color.BLACK);
        mb.add(Exam);

        JMenuItem ExaminationDetails = new JMenuItem("Examination Result");
        ExaminationDetails.setBackground(Color.white);
        ExaminationDetails.addActionListener(this);
        Exam.add(ExaminationDetails);

        JMenuItem EnterMarks = new JMenuItem("Enter Marks");
        EnterMarks.setBackground(Color.white);
        EnterMarks.addActionListener(this);
        Exam.add(EnterMarks);

        // update info

        JMenu UpdateInfo = new JMenu("Update Details");
        UpdateInfo.setForeground(Color.BLACK);
        mb.add(UpdateInfo);

        JMenuItem UpdateFacultyInfo = new JMenuItem("Update Faculty Details");
        UpdateFacultyInfo.setBackground(Color.white);
        UpdateFacultyInfo.addActionListener(this);
        UpdateInfo.add(UpdateFacultyInfo);

        JMenuItem UpdateStudentInfo = new JMenuItem("Update Student Details");
        UpdateStudentInfo.setBackground(Color.white);
        UpdateStudentInfo.addActionListener(this);
        UpdateInfo.add(UpdateStudentInfo);

        //fee

        JMenu Fee = new JMenu("Fee Details");
        Fee.setForeground(Color.BLACK);
        mb.add(Fee);

        JMenuItem FeeStructure = new JMenuItem("Fee Structure");
        FeeStructure.setBackground(Color.white);
        FeeStructure.addActionListener(this);
        Fee.add(FeeStructure);

        JMenuItem FeeForm = new JMenuItem("Student Fee Form");
        FeeForm.setBackground(Color.white);
        FeeForm.addActionListener(this);
        Fee.add(FeeForm);

        //utility

        JMenu Utility = new JMenu("Utility");
        Utility.setForeground(Color.BLACK);
        mb.add(Utility);

        JMenuItem ca = new JMenuItem("Calculator");
        ca.setBackground(Color.white);
        ca.addActionListener(this);
        Utility.add(ca);

        JMenuItem Notepad = new JMenuItem("Notepad");
        Notepad.setBackground(Color.white);
        Notepad.addActionListener(this);
        Utility.add(Notepad);

        //about

        JMenu About = new JMenu("About");
        About.setBackground(Color.white);
        mb.add(About);

        JMenuItem about = new JMenuItem("About");
        about.setBackground(Color.white);
        about.addActionListener(this);
        About.add(about);
    }

    public static void main(String[] args) {
        new main_class();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String sm = ae.getActionCommand();
        if (sm.equals("Exit")) {
            System.exit(0);
        } else if (sm.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (sm.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (sm.equals("New Faculty Information")) {
            new AddFaculty();
        } else if (sm.equals("New Student Information")) {
            new AddStudent();
        } else if (sm.equals("View Faculty Details")) {
            new TeacherDetails();
        } else if (sm.equals("View Student Details")) {
            new StudentDetails();
        } else if (sm.equals("Faculty Leave")) {
            new TeacherLeave();
        } else if (sm.equals("Student Leave")) {
            new StudentLeave();
        } else if (sm.equals("Faculty Leave Details")) {
            new TeacherLeaveDetails();
        } else if (sm.equals("Student Leave Details")) {
            new StudentLeaveDetails();
        } else if (sm.equals("Examination Result")) {
            new ExaminationDetails();
        } else if (sm.equals("Enter Marks")) {
            new EnterMarks();
        } else if (sm.equals("Update Faculty Details")) {
            new UpdateTeacher();
        } else if (sm.equals("Update Student Details")) {
            new UpdateStudent();
        } else if (sm.equals("Fee Structure")) {
            new FeeStructure();
        } else if (sm.equals("Student Fee Form")) {
            new StudentFeeForm();
        } else if (sm.equals("About")) {
            new About();
        }
    }
}