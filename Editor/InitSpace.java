package Editor;
//use to offload code from EditorMain
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InitSpace extends EditorMain {
    private JPanel p;
    private String abtInfo = "Version 0.0.1";
    private JMenuBar mb;
    private JMenu fileMenu, editMenu, viewMenu, helpMenu;
    private JMenuItem newItem, open, openRecent, save, quit, undo, redo, cut, copy, paste, 
        zoomIn, zoomOut, about;

    public InitSpace() {

    }

    //Shouldn't need main method here
    // public static void main(String[] args) {
    //     new InitSpace();
    // }

    public JMenuItem populateJMenuItems(JMenuItem x, String name) {
        x = new JMenuItem(name);

        switch(name) {
            case "New":
                x.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, 
                    KeyEvent.CTRL_DOWN_MASK));
                    break;
            case "Open":
                x.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, 
                    KeyEvent.CTRL_DOWN_MASK));
                break;
            case "Save":
                x.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, 
                    KeyEvent.CTRL_DOWN_MASK));
                break;
            case "Quit":
                /*From https://bit.ly/3hNodqX 
                codejava.net/java-se/swing/setting shortcuts & hotkeys*/
                x.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, 
                    KeyEvent.CTRL_DOWN_MASK));
                break;
            case "Copy":
                x.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, 
                    KeyEvent.CTRL_DOWN_MASK));
                break;
            case "Cut":
                x.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, 
                    KeyEvent.CTRL_DOWN_MASK));
                break;
            case "Paste":
                x.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, 
                    KeyEvent.CTRL_DOWN_MASK));
                    break;
            case "Undo":
                x.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, 
                    KeyEvent.CTRL_DOWN_MASK));
                break;
            case "Redo":
                x.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, 
                    KeyEvent.CTRL_DOWN_MASK));
                break;
        }

        x.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(name) {
                    case "New":
                        //create new level;
                        /*Initialize new frame*/
                        /*1/5/2021 this isn't working; may instantiate
                        panel but can't add to top-level frame cp,
                        even after changing from top-lvl editor content pane to JFrame*/
                        // p = new JPanel(new FlowLayout());
                        // cp.add(p);//cp cannot be referenced here
                        // p.add(new JButton("Test"));
                        // f.add(p);
                        break;
                    case "Open":
                        //open file
                        //javax.swing.FileChooser - use this class
                        break;
                    case "Open Recent":
                        //open recent file
                        break;
                    case "Save":
                        //save current level/workspace
                        //javax.swing.FileChooser - use this class
                        break;
                    case "Quit":
                        //quit the app
                        System.exit(0);
                        break;
                    case "Undo":
                        //undo last action
                        break;
                    case "Redo":
                        //redo undid action
                        break;
                    case "Cut":
                        //cut asset
                        break;
                    case "Copy":
                        //copy asset
                        break;
                    case "Paste":
                        //paste asset
                        break;
                    case "Zoom In":
                        //zoom into the level
                        break;
                    case "Zoom Out":
                        //zoom out of the level
                        break;
                }
            }
        });
        x.setActionCommand(name);
        return x;
    }

    public JPanel initEditorSpace(JFrame f, JPanel jp) {
        jp = new JPanel(new BorderLayout());
        jp.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5, true));

        /*Trying to align JPanel to the left*/
        JPanel jp2 = new JPanel(new GridBagLayout());
        // JPanel jp2 = new JPanel(new FlowLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        jp2.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5, true));
        
        JButton btn1, btn2, btn3, btn4;
        ImageIcon Tree1, Tree2, RP1, RP2;
        Tree1 = new ImageIcon("Assets//Tree1.png");
        Tree2 = new ImageIcon("Assets//Tree2.png");
        RP1 = new ImageIcon("Assets//RockPile1.png");
        RP2 = new ImageIcon("Assets//RockPIle2.png");
        // btn1 = new JButton(new ImageIcon("Assets//Tree1.png"));
        btn1 = new JButton();
        btn1.setBounds(0, 0, 50, 50);
        btn1.setIcon(resizeIcon(Tree1, btn1.getWidth(), btn1.getHeight()));
        // btn2 = new JButton(new ImageIcon("Assets//Tree2.png"));
        btn2 = new JButton();
        btn2.setBounds(15, 15, 50, 50);
        btn2.setIcon(resizeIcon(Tree2, btn2.getWidth(), btn2.getHeight()));
        // btn3 = new JButton(new ImageIcon("Assets//RockPile1.png"));
        btn3 = new JButton();
        btn3.setBounds(30, 30, 50, 50);
        btn3.setIcon(resizeIcon(RP1, btn3.getWidth(), btn3.getHeight()));
        // btn4 = new JButton(new ImageIcon("Assets//RockPile2.png"));
        btn4 = new JButton();
        btn4.setBounds(45, 45, 50, 50);
        btn4.setIcon(resizeIcon(RP2, btn4.getWidth(), btn4.getHeight()));

        /*Init top rows of assets to drag and drop, for now they will
        sit at top of the window*/
        jp2.add(btn1, gbc);
        jp2.add(btn2, gbc);
        jp2.add(btn3, gbc);
        jp2.add(btn4, gbc);

        //To test drag & drop; is ready to go for JTextArea
        JTextField nyarf = new JTextField("NYAAAAAAAAAAAARRRRRRF!!!!");
        nyarf.setDragEnabled(true);
        jp2.add(nyarf);
        //jp3.add(new JTextArea());//add this after instantiating jp3

        // JPanel jp3 = new JPanel(new GridBagLayout());
        JPanel jp3 = new JPanel(new GridLayout(0, 1));
        // GridBagConstraints gbc2 = new GridBagConstraints();
        // gbc2.fill = GridBagConstraints.SOUTH;
        // gbc2.gridx = 1;
        // gbc2.gridy = 1;
        jp3.setBorder(BorderFactory.createLineBorder(Color.RED, 5, true));
        jp3.add(new JTextArea());

        jp.add(jp2, BorderLayout.NORTH);
        jp.add(jp3, BorderLayout.CENTER);
        return jp;
    }
}