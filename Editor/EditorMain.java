package Editor;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EditorMain {
    //private vars
    private Container cp;
    private JFrame f;
    private JPanel p;
    private String abtInfo = "Version 0.0.1";
    private JMenuBar mb;
    private JMenu fileMenu, editMenu, viewMenu, helpMenu;
    private JMenuItem newItem, open, openRecent, save, quit, cut, copy, paste, zoomIn,
        zoomOut, about;
    
    //Constructor
    public EditorMain() {
        /*This was breaking the JPanels in initEditorSpace()*/
        // cp = getContentPane();
        // cp.setLayout(new FlowLayout());
        
        f = new JFrame("Top-level_frame");

        /*Constructor should be creating new blank editor space anyway
        Don't worry about "New" file menu for now*/
        f.add(initEditorSpace(f, p));
        // p = new JPanel(new FlowLayout());
        // JButton temp = new JButton("doy");
        // p.add(temp);
        // cp.add(p);

        mb = new JMenuBar();
        fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);//use Alt+F to open File menu
        fileMenu.add(populateJMenuItems(newItem, "New"));
        fileMenu.add(populateJMenuItems(open, "Open"));
        fileMenu.add(populateJMenuItems(save, "Save"));
        fileMenu.add(populateJMenuItems(quit, "Quit"));

        editMenu = new JMenu("Edit");
        editMenu.add(populateJMenuItems(cut, "Cut"));
        editMenu.add(populateJMenuItems(copy, "Copy"));
        editMenu.add(populateJMenuItems(paste, "Paste"));

        viewMenu = new JMenu("View");
        viewMenu.add(populateJMenuItems(zoomIn, "Zoom In"));
        viewMenu.add(populateJMenuItems(zoomOut, "Zoom Out"));

        helpMenu = new JMenu("Help");
        about = new JMenuItem("About Nyarf Editor");
        /*This has to go here; cannot call cp as arg for showMessageDialog
        if in populateJMenuItems()*/
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(f, abtInfo);
            }
        });
        about.setActionCommand("About Nyarf Editor");
        helpMenu.add(about);

        mb.add(fileMenu);
        mb.add(editMenu);
        mb.add(viewMenu);
        mb.add(helpMenu);

        // addWindowListener(this);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setJMenuBar(mb);
        f.setTitle("Nyarf Editor");
        f.setSize(900, 900);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        // Run GUI codes in Event-Dispatching thread for thread safety
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EditorMain();
            }
        });
    }

    public JMenuItem populateJMenuItems(JMenuItem x, String name) {
        x = new JMenuItem(name);

        switch(name) {
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

        // jp2.add(btn1);
        // jp2.add(btn2);
        // jp2.add(btn3);
        // jp2.add(btn4);
        // jp.add(jp2);//put this at the end of the method, above return stmt

        /**This block is causing problems */
        // JPanel jp3 = new JPanel(new GridLayout());
        // jp3.setBorder(BorderFactory.createLineBorder(Color.RED, 5, true));
        // jp.add(jp3);

        // JPanel jp3 = new JPanel(new GridBagLayout());
        JPanel jp3 = new JPanel(new GridLayout(0, 1));
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.fill = GridBagConstraints.SOUTH;
        gbc2.gridx = 1;
        gbc2.gridy = 1;
        jp3.setBorder(BorderFactory.createLineBorder(Color.RED, 5, true));

        // jp.add(jp3);
        jp.add(jp2, BorderLayout.NORTH);
        jp.add(jp3, BorderLayout.CENTER);
        return jp;
    }

    /*Resize the assets to have reasonable button sizes
    From:
    https://stackoverflow.com/questions/36957450/fit-size-of-an-imageicon-to-a-jbutton */
    public Icon resizeIcon(ImageIcon ii, int resizeWidth, int resizedHeight) {
        Image img = ii.getImage();
        Image resizedImage = img.getScaledInstance(resizeWidth, resizedHeight, 
            Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
}