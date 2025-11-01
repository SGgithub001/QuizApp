package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {

    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];

    JLabel qno, question, timerLabel;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;

    Timer quizTimer;
    int timer = 15, count = 0, score = 0;
    String name;

    public Quiz(String name) {
        this.name = name;

        // Frame setup
        setBounds(50, 0, 1440, 850);
//        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setUndecorated(true);

        // Safe image loading
        java.net.URL imgURL = getClass().getClassLoader().getResource("icons/quiz.png");
        if (imgURL != null) {
            ImageIcon i1 = new ImageIcon(imgURL);
            JLabel image = new JLabel(i1);
            image.setBounds(0, 0, 1440, 392);
            add(image);
        } else {
            System.out.println("Image not found: icons/quiz.png");
        }

        // Question label setup
        qno = new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);

        question = new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);

        timerLabel = new JLabel("Time left - 15 seconds");
        timerLabel.setBounds(1100, 500, 300, 30);
        timerLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
        timerLabel.setForeground(Color.RED);
        add(timerLabel);

        // Question bank
        loadQuestionsAndAnswers();

        // Options
        opt1 = createOption(170, 520);
        opt2 = createOption(170, 560);
        opt3 = createOption(170, 600);
        opt4 = createOption(170, 640);

        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        // Buttons
        next = createButton("Next", 700, 750, new Color(22, 99, 54));
        lifeline = createButton("Help", 930, 750, new Color(255, 140, 0));
        submit = createButton("Submit", 1150, 750, new Color(255, 215, 0));

        submit.setEnabled(false);
        add(next);
        add(lifeline);
        add(submit);

        next.addActionListener(this);
        lifeline.addActionListener(this);
        submit.addActionListener(this);

        start(count);
        startTimer();
        setVisible(true);
    }

    private JButton createButton(String text, int x, int y, Color color) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 200, 30);
        button.setFont(new Font("Tahoma", Font.PLAIN, 18));
        button.setBackground(color);
//        button.setForeground(Color.WHITE);
        return button;
    }

    private JRadioButton createOption(int x, int y) {
        JRadioButton opt = new JRadioButton();
        opt.setBounds(x, y, 700, 30);
//        opt.setBackground(Color.WHITE);
        opt.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt);
        return opt;
    }

    private void loadQuestionsAndAnswers() {
        // Questions
        questions[0][0] = "Number of primitive data types in Java are.?";
        questions[0][1] = "6"; questions[0][2] = "7"; questions[0][3] = "8"; questions[0][4] = "9";
        questions[1][0] = "What is the size of float and double in Java.?";
        questions[1][1] = "32 and 64"; questions[1][2] = "32 and 32"; questions[1][3] = "64 and 64"; questions[1][4] = "64 and 32";
        questions[2][0] = "Automatic type conversion is possible in which of the possible cases?";
        questions[2][1] = "Byte to int"; questions[2][2] = "Int to Long"; questions[2][3] = "Long to int"; questions[2][4] = "Short to int";
        questions[3][0] = "When an array is passed to a method, what does the method receive?";
        questions[3][1] = "The reference of the array"; questions[3][2] = "A copy of the array"; questions[3][3] = "Length of the array"; questions[3][4] = "Copy of first element";
        questions[4][0] = "Arrays in Java are.?";
        questions[4][1] = "Object References"; questions[4][2] = "Objects"; questions[4][3] = "Primitive data type"; questions[4][4] = "None";
        questions[5][0] = "When is the object created with new keyword?";
        questions[5][1] = "At run time"; questions[5][2] = "At compile time"; questions[5][3] = "Depends on the code"; questions[5][4] = "None";
        questions[6][0] = "Identify the correct definition of a package.";
        questions[6][1] = "A collection of editing tools"; questions[6][2] = "A collection of Classes"; questions[6][3] = "A collection of Classes and interfaces"; questions[6][4] = "A collection of interfaces";
        questions[7][0] = "compareTo() returns";
        questions[7][1] = "True"; questions[7][2] = "False"; questions[7][3] = "An int value"; questions[7][4] = "None";
        questions[8][0] = "To which of the following does the class String belong?";
        questions[8][1] = "java.lang"; questions[8][2] = "java.awt"; questions[8][3] = "java.applet"; questions[8][4] = "java.String";
        questions[9][0] = "Total constructors String class have.?";
        questions[9][1] = "3"; questions[9][2] = "7"; questions[9][3] = "13"; questions[9][4] = "20";

        // Answers
        answers[0][1] = "8"; answers[1][1] = "32 and 64"; answers[2][1] = "Int to Long"; answers[3][1] = "The reference of the array";
        answers[4][1] = "Objects"; answers[5][1] = "At run time"; answers[6][1] = "A collection of Classes and interfaces";
        answers[7][1] = "An int value"; answers[8][1] = "java.lang"; answers[9][1] = "13";
    }

    public void start(int count) {
        qno.setText((count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt2.setText(questions[count][2]);
        opt3.setText(questions[count][3]);
        opt4.setText(questions[count][4]);
        opt1.setActionCommand(questions[count][1]);
        opt2.setActionCommand(questions[count][2]);
        opt3.setActionCommand(questions[count][3]);
        opt4.setActionCommand(questions[count][4]);
        groupoptions.clearSelection();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            saveAnswer();
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            start(count);
            timer = 15;
        } else if (ae.getSource() == lifeline) {
            if (count % 2 == 0) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        } else if (ae.getSource() == submit) {
            saveAnswer();
            calculateScore();
            setVisible(false);
            new Score(name, score);
        }
    }

    private void saveAnswer() {
        if (groupoptions.getSelection() == null) {
            useranswers[count][0] = "";
        } else {
            useranswers[count][0] = groupoptions.getSelection().getActionCommand();
        }
    }

    private void calculateScore() {
        for (int i = 0; i < useranswers.length; i++) {
            if (useranswers[i][0] != null && useranswers[i][0].equals(answers[i][1])) {
                score += 10;
            }
        }
    }

    private void startTimer() {
        quizTimer = new Timer(1000, e -> {
            timer--;
            if (timer >= 0) {
                timerLabel.setText("Time left - " + timer + " seconds");
            } else {
                ((Timer) e.getSource()).stop();
                handleTimeout();
            }
        });
        quizTimer.start();
    }

    private void handleTimeout() {
        saveAnswer();
        if (count == 9) {
            calculateScore();
            setVisible(false);
            new Score(name, score);
        } else {
            count++;
            start(count);
            timer = 15;
            startTimer();
        }
    }

    public static void main(String[] args) {
        new Quiz("User");
    }
}
