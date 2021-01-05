package Example;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingAccumulator extends JFrame {
    private JTextField tf1, tf2;
    private int temp = 0;

    public SwingAccumulator() {
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(2, 2, 5, 5));

        cp.add(new JLabel("Enter an integer"));
        tf1 = new JTextField();
        cp.add(tf1);
        cp.add(new JLabel("The accumulated sum is"));
        tf2 = new JTextField();
        tf2.setEditable(false);
        cp.add(tf2);

        tf1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                temp += Integer.parseInt(tf1.getText());
                tf1.setText("");
                tf2.setText(temp + "");
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Swing accumulator");
        setSize(350, 120);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingAccumulator();
            }
        });
    }
}