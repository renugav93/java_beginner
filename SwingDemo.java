import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingDemo {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Simple Swing Example");

        JButton button = new JButton("Click Me");
        JLabel label = new JLabel("Waiting for button click...");

        frame.setLayout(new FlowLayout());
        frame.add(button);
        frame.add(label);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Button Clicked!");
            }
        });

        frame.setSize(350, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}