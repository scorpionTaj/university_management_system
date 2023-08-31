package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About extends JFrame implements ActionListener {
    About() {

        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icon/about.png"));
        Image img2 = img1.getImage().getScaledInstance(200, 250, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel img = new JLabel(img3);
        img.setBounds(350, 100, 300, 200);
        add(img);

        JLabel heading = new JLabel("<html> Scorpion</br> BTS University</html>");
        heading.setBounds(70, 20, 300, 130);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        JLabel name = new JLabel("Tajeddine BOURHIM");
        name.setBounds(60, 240, 550, 40);
        name.setFont(new Font("serif", Font.BOLD, 30));
        add(name);

        JLabel contact = new JLabel("bourhimtajeddine@gmail.com");
        contact.setBounds(60, 360, 550, 40);
        contact.setFont(new Font("serif", Font.BOLD, 30));
        add(contact);

        setSize(700, 500);
        getContentPane().setBackground(Color.cyan);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new About();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
