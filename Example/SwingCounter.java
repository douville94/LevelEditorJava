package Example;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingCounter extends JFrame {
    private JTextField tf1;
    private JButton btnCount;
    private int count = 0;

    public SwingCounter() {
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());

        cp.add(new JLabel("Counter", JLabel.LEFT));
        tf1 = new JTextField("0");
        tf1.setEditable(false);
        cp.add(tf1);

        btnCount = new JButton("Count");
        cp.add(btnCount);

        //Allocate an anonymous instance of an anonymous inner class that
        //implements ActionListener as ActionEvent listener
        btnCount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                tf1.setText(count + "");
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Swing counter");
        setSize(300, 100);
        setVisible(true);
    }

    public static void main(String[] args) {
        //For thread safety
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingCounter();
            }
        });
    }
}