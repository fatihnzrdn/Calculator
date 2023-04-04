import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    private JTextField TextField;
    private JRadioButton ONRadioButton;
    private JRadioButton OFFRadioButton;
    private JButton button1;
    private JButton a1Button;
    private JButton a0Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton cButton;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JPanel PanelCalculator;
    double a, b, result;
    String op;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new Calculator().PanelCalculator);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Calculator() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(((JButton) e.getSource()).getText().trim());
                TextField.setText(TextField.getText() + value);
            }
        };

        a0Button.addActionListener(listener);
        a1Button.addActionListener(listener);
        a2Button.addActionListener(listener);
        a3Button.addActionListener(listener);
        a4Button.addActionListener(listener);
        a5Button.addActionListener(listener);
        a6Button.addActionListener(listener);
        a7Button.addActionListener(listener);
        a8Button.addActionListener(listener);
        a9Button.addActionListener(listener);

        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!TextField.getText().contains("."))
                {
                    TextField.setText(TextField.getText()+ button7.getText());
                }
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a = Double.parseDouble (TextField.getText());
                op = "+";
                TextField.setText("");
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a = Double.parseDouble (TextField.getText());
                op = "-";
                TextField.setText("");
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a = Double.parseDouble (TextField.getText());
                op = "*";
                TextField.setText("");
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a = Double.parseDouble (TextField.getText());
                op = "/";
                TextField.setText("");
            }
        });

        cButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextField.setText("");
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String backspace = null;
                if(TextField.getText().length() > 0)
                {
                    StringBuilder strB = new StringBuilder (TextField.getText());
                    strB.deleteCharAt(TextField.getText().length() - 1);
                    backspace = String.valueOf(strB);
                    TextField.setText (backspace);
                }
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b = Double.parseDouble (TextField.getText());
                if (op == "+")
                {
                    result = a+b;
                    TextField.setText(String.valueOf(result));
                }else if (op == "-")
                {
                    result = a-b;
                    TextField.setText(String.valueOf(result));
                }else if(op== "")
                {
                    result = a*b;
                    TextField.setText(String.valueOf(result));
                }else if(op== "/")
                {
                    result = a/b;
                    TextField.setText(String.valueOf(result));
                }
            }
        });
    }

}
