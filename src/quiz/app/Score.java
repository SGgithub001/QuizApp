package quiz.app;

import javax.swing.*;
import java.awt.*;

public class Score extends JFrame {

    public Score(String name, int score) {

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // Load Score Icon safely
        JLabel image = new JLabel();
        java.net.URL scoreURL = ClassLoader.getSystemResource("icons/score.png");
        if (scoreURL != null) {
            ImageIcon i1 = new ImageIcon(scoreURL);
            Image i2 = i1.getImage().getScaledInstance(200, 150, Image.SCALE_DEFAULT);
            image.setIcon(new ImageIcon(i2));
        } else {
            System.out.println("️Image not found: icons/score.png");
        }
        image.setBounds(60, 200, 200, 150);
        add(image);

        JLabel heading = new JLabel("Thank you " + name + " for Playing QUIZ Test");
        heading.setBounds(100, 80, 700, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 26));
        heading.setForeground(new Color(22, 99, 54));
        add(heading);

        JLabel scoreLabel = new JLabel("Your Score is : " + score);
        scoreLabel.setBounds(350, 200, 300, 30);
        scoreLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
        scoreLabel.setForeground(new Color(22, 99, 54));
        add(scoreLabel);

        JButton exit = new JButton("EXIT");
        exit.setBounds(380, 270, 120, 30);
        exit.setBackground(new Color(22, 99, 54));
//        exit.setForeground(Color.WHITE);
        add(exit);

        exit.addActionListener(e -> {
            setVisible(false);
            new Login(); // go back to login
        });

        // Safe background image load
        JLabel background = new JLabel();
        java.net.URL bgURL = ClassLoader.getSystemResource("icons/back.png");
        if (bgURL != null) {
            ImageIcon bg = new ImageIcon(bgURL);
            Image bgImg = bg.getImage().getScaledInstance(750, 550, Image.SCALE_DEFAULT);
            background.setIcon(new ImageIcon(bgImg));
        } else {
            System.out.println("Background not found: icons/back.png");
        }
        background.setBounds(0, 0, 750, 550);
        add(background);

        setSize(750, 550);
        setLocation(400, 150);
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Score("User", 0);
    }
}
