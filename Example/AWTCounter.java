package Example;
import java.awt.*;
import java.awt.event.*;

public class AWTCounter extends Frame implements ActionListener, WindowListener {
    private Button btnCounter;
    private TextField tf, tf2;
    private int count = 0;

    public AWTCounter() {
        setLayout(new FlowLayout());
        
        this.add(new Label("Counter", Label.LEFT));

        tf = new TextField("0");
        this.add(tf);

        tf2 = new TextField();
        tf2.setEditable(false);
        this.add(tf2);

        btnCounter = new Button("Count");
        this.add(btnCounter);
        btnCounter.addActionListener(this);
        // "btnCount" is the source object that fires an ActionEvent when clicked.
        // The source add "this" instance as an ActionEvent listener, which provides
        //   an ActionEvent handler called actionPerformed().
        // Clicking "btnCount" invokes actionPerformed().

        addWindowListener(this);
        // "super" Frame (source object) fires WindowEvent.
        // "super" Frame adds "this" object as a WindowEvent listener.

        //Setting window properties
        this.setTitle("AWT Counter");
        this.setSize(250, 250);
        this.setVisible(true);        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        tf2.setText(count + "");
    }

    /* WindowEvent handlers */
    // Called back upon clicking close-window button
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
    // Not Used, BUT need to provide an empty body to compile.
    @Override public void windowOpened(WindowEvent evt) { }
    @Override public void windowClosed(WindowEvent evt) { }
    // For Debugging
    @Override public void windowIconified(WindowEvent evt) { System.out.println("Window Iconified"); }
    @Override public void windowDeiconified(WindowEvent evt) { System.out.println("Window Deiconified"); }
    @Override public void windowActivated(WindowEvent evt) { System.out.println("Window Activated"); }
    @Override public void windowDeactivated(WindowEvent evt) { System.out.println("Window Deactivated"); }

    public static void main(String[] args) {
        new AWTCounter();
    }
}