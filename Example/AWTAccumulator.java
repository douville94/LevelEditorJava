package Example;
import java.awt.*;
import java.awt.event.*;

public class AWTAccumulator extends Frame implements ActionListener {
    private TextField tf1, tf2;
    private int temp = 0;
    
    public AWTAccumulator() {
        setLayout(new FlowLayout());

        this.add(new Label("Enter an integer"));
        tf1 = new TextField();
        this.add(tf1);
        tf1.addActionListener(this);

        this.add(new Label("Accumulated sum is"));
        tf2 = new TextField();
        tf2.setEditable(false);
        this.add(tf2);

        this.setTitle("AWTAccumulator");
        this.setSize(250, 250);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        temp += Integer.parseInt(tf1.getText());
        tf1.setText("");
        tf2.setText(temp + "");
    }

    public static void main(String[] args) {
        new AWTAccumulator();
    }
}