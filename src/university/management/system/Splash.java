package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements Runnable {
    Splash() {
        Thread t;

        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icon/first.png"));
        Image img2 = img1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel img = new JLabel(img3);
        add(img);

        setSize(1280, 720);  // Set an initial size
        setLocationRelativeTo(null);

        t = new Thread(this);
        t.start();
        setVisible(true);
        setLocationRelativeTo(null);


    }

    public static void main(String[] args) {
        new Splash();
    }

    public void run() {
        try {
            Thread.sleep(7000);
            setVisible(false);
            new Login();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
