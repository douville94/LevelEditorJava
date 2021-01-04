package Editor;

import java.awt.*;
import java.awt.event.*;
public class EditorMain extends Frame implements ActionListener, WindowListener {
    //private vars
    private MenuBar mb;// = new MenuBar();
    private Menu File, Edit, View, Help;
    
    //Constructor
    public EditorMain() {
        setLayout(new FlowLayout());

        mb = new MenuBar();
        File = new Menu(" File");
        Edit = new Menu("Edit");
        View = new Menu("View");
        Help = new Menu("Help");
        mb.add(File);
        mb.add(Edit);
        mb.add(View);
        mb.add(Help);

        addWindowListener(this);
        this.setMenuBar(mb);
        this.setTitle("Nyarf Editor");
        this.setSize(900, 900);
        this.setVisible(true);
    }

    //functions
    @Override
    public void actionPerformed(ActionEvent e) {

    }

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
        //Invoke constructor to setup the GUI
        new EditorMain();
    }
}