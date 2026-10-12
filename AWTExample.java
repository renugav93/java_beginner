import java.awt.*;
import java.awt.event.*;

public class AWTExample extends Frame
                        implements ActionListener {

    Button b;
    Label l;

    AWTExample() {
        b = new Button("Click Me");
        l = new Label("Hello AWT");

        setLayout(new FlowLayout());

        add(b);
        add(l);

        b.addActionListener(this);

        // Close the window when X is clicked
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setSize(300, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        l.setText("Button Clicked!");
    }

    public static void main(String[] args) {
        new AWTExample();
    }
}