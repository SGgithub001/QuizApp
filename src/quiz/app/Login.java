package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    JTextField text;
    JButton next, back;

    public Login() {
        // Frame setup
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Safe image loading (with null check)
        ImageIcon i1 = null;
        java.net.URL imgURL = getClass().getClassLoader().getResource("icons/login.png");

        if (imgURL != null) {
            i1 = new ImageIcon(imgURL);
        } else {
            System.out.println(" Image not found: icons/login.png");
        }

        JLabel image = null;
        if (i1 != null) {
            Image i = i1.getImage().getScaledInstance(550, 500, Image.SCALE_SMOOTH);
            ImageIcon i2 = new ImageIcon(i);
            image = new JLabel(i2);
            image.setBounds(450, 0, 550, 500);
            add(image);
        }

        // Heading
        JLabel heading = new JLabel("QUIZ TEST");
        heading.setBounds(140, 60, 300, 45);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
        heading.setForeground(new Color(22, 99, 54));
        add(heading);

        // Name label
        JLabel nameLabel = new JLabel("Enter Your Name");
        nameLabel.setBounds(160, 150, 300, 20);
        nameLabel.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        nameLabel.setForeground(new Color(22, 99, 54));
        add(nameLabel);

        // Input field
        text = new JTextField();
        text.setBounds(80, 200, 300, 25);
        text.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(text);

        // Next button
        next = new JButton("Next");
        next.setBounds(100, 270, 120, 25);
        next.setBackground(new Color(22, 99, 54));
//        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        // Exit button
        back = new JButton("Exit");
        back.setBounds(250, 270, 120, 25);
        back.setBackground(new Color(22, 99, 54));
//        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        // Frame properties
        setSize(1000, 500);
        setLocation(200, 150);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            String name = text.getText().trim();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your name!", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
            setVisible(false);
            new Rules(name);
        } else if (e.getSource() == back) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
