package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener {

    JButton start, back;
    String name;

    public Rules(String name) {
        this.name = name;

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Welcome " + name + " to QUIZ TEST");
        heading.setBounds(150, 100, 700, 30);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 28));
        heading.setForeground(new Color(22, 99, 54));
        add(heading);

        JLabel rules = new JLabel();
        rules.setBounds(70, 150, 700, 350);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 16));
        rules.setForeground(new Color(22, 99, 54));
        rules.setText("<html>" +
                "1. Participation in the quiz is free and open to all persons above 18 years old.<br><br>" +
                "2. There are total 10 questions.<br><br>" +
                "3. You have 15 seconds for each question.<br><br>" +
                "4. No cell phones or external help allowed.<br><br>" +
                "5. Be honest and have fun!<br><br>" +
                "</html>");
        add(rules);

        back = new JButton("Back");
        back.setBounds(300, 500, 100, 30);
        back.setBackground(new Color(22, 99, 54));
//        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        start = new JButton("Start");
        start.setBounds(450, 500, 100, 30);
        start.setBackground(new Color(22, 99, 54));
//        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);

        // Safe image loading
        ImageIcon i1 = null;
        java.net.URL imgURL = ClassLoader.getSystemResource("icons/back.png");
        if (imgURL != null) {
            i1 = new ImageIcon(imgURL);
        } else {
            System.out.println("Image not found: icons/back.png");
        }

        JLabel image = new JLabel();
        if (i1 != null) {
            Image i = i1.getImage().getScaledInstance(800, 650, Image.SCALE_DEFAULT);
            image.setIcon(new ImageIcon(i));
        }
        image.setBounds(0, 0, 800, 650);
        add(image);

        setSize(800, 650);
        setLocation(350, 100);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            setVisible(false);
            new Quiz(name);
        } else {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Rules("User");
    }
}
