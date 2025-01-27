package Editor;

import java.util.ArrayList;
import java.io.File;
import java.awt.*;
import java.awt.datatransfer.Transferable;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class EditorMain {
    //private vars
    private Container cp;
    private JFrame f;
    private JPanel p;
    private String abtInfo = "Version 0.0.1";
    private JMenuBar mb;
    private JMenu fileMenu, editMenu, viewMenu, helpMenu;
    private JMenuItem newItem, open, openRecent, save, quit, undo, redo, cut, copy, paste, 
        zoomIn, zoomOut, about;
    public static ArrayList<String> AssetsList;
    
    public EditorMain() {
        /*This was breaking the JPanels in initEditorSpace()*/
        // cp = getContentPane();
        // cp.setLayout(new FlowLayout());
        
        f = new JFrame("Top-level_frame");

        AssetsList = new ArrayList<String>();
        File dir = new File("Assets");
        int i = 0;
        for(File f : dir.listFiles()) {
            AssetsList.add(i, f.toString());
            System.out.println(f.toString() + " added!");
            i++;
        }

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
        editMenu.add(populateJMenuItems(undo, "Undo"));
        editMenu.add(populateJMenuItems(redo, "Redo"));
        editMenu.add(populateJMenuItems(cut, "Cut"));
        editMenu.add(populateJMenuItems(copy, "Copy"));
        editMenu.add(populateJMenuItems(paste, "Paste"));

        viewMenu = new JMenu("View");
        viewMenu.add(populateJMenuItems(zoomIn, "Zoom In"));
        viewMenu.add(populateJMenuItems(zoomOut, "Zoom Out"));

        helpMenu = new JMenu("Help");
        about = new JMenuItem("About Nyarf Editor");
        /*This has to go here; cannot call f as arg for showMessageDialog
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
        /*Shortcuts have to be set here; cannot reference x in the anonymous ActionListener
        below.*/
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
        RP2 = new ImageIcon("Assets//RockPile2.png");
        /*Init top rows of assets to drag and drop, for now they will
        sit at top of the window*/
        //Instead of using JButtons, you could add icons to JLabels
        btn1 = new JButton();
        btn1.setBounds(0, 0, 50, 50);
        btn1.setIcon(resizeIcon(Tree1, btn1.getWidth(), btn1.getHeight()));
        btn2 = new JButton();
        btn2.setBounds(15, 15, 50, 50);
        btn2.setIcon(resizeIcon(Tree2, btn2.getWidth(), btn2.getHeight()));
        btn3 = new JButton();
        btn3.setBounds(30, 30, 50, 50);
        btn3.setIcon(resizeIcon(RP1, btn3.getWidth(), btn3.getHeight()));
        btn4 = new JButton();
        btn4.setBounds(45, 45, 50, 50);
        btn4.setIcon(resizeIcon(RP2, btn4.getWidth(), btn4.getHeight()));
        //Add buttons to 2nd JPanel
        jp2.add(btn1, gbc);
        jp2.add(btn2, gbc);
        jp2.add(btn3, gbc);
        jp2.add(btn4, gbc);

        //To test drag & drop; is ready to go for JTextArea
        JTextField nyarf = new JTextField("NYAAAAAAAAAAAARRRRRRF!!!!");
        nyarf.setDragEnabled(true);
        jp2.add(nyarf);
        // jp3.add(new JTextArea());//add this after instantiating jp3
        
        /*Create 3rd JPanel as main editing space*/
        JPanel jp3 = new JPanel(new GridLayout(0, 1));
        jp3.setBorder(BorderFactory.createLineBorder(Color.RED, 5, true));
        // jp3.add(new JTextArea());//to test D&D from lines 240-243
        int row = 20, col = 10;
        /*Maybe create grid in jp3 to drag/drop assets - use JTable?*/
        DefaultTableModel dtm = new DefaultTableModel(row, col) {
            @Override
            public Class getColumnClass(int column) {
                return ImageIcon.class;
            }
        };
        // JTable table = new JTable(20, 10);
        JTable table = new JTable(dtm);
        // JTable table = new PaintJTableCell(20, 10);
        table.setRowHeight(50);
        table.setShowGrid(true);
        // table.getColumn(0).setCellRenderer(table.getDefaultRenderer(ImageIcon.class));
        /**^java.lang.IllegalArgumentException: identifier not found*/
        table.getColumnClass(0);
        
        jp3.add(table);

        JPanel jp4 = new JPanel();
        JButton jp3btn = new JButton();
        /*Initialize the transfer handler*/
        DnDImEx dndimex = new DnDImEx();
        // jp3.add(jp3btn);
        // jp4.setTransferHandler(dndimex);
        // jp3.add(jp4);
        // jp3btn.setTransferHandler(dndimex);
        // TransferHandler th = dndimex.getTH();
        table.setTransferHandler(dndimex);

        // dndimex.setDragEnabled(true);
        JButton[] btnArray = { btn1, btn2, btn3, btn4 };
        /*Create listener for drag & drop on buttons*/
        for(JButton jb : btnArray) {
            jb.addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    // th.setDropMode(DropMode.INSERT);
                    // jb.setDropMode(DropMode.INSERT);
                    JButton jb = (JButton)e.getSource();
                    jb.setTransferHandler(new DnDImEx());
                    TransferHandler thandl = jb.getTransferHandler();
                    thandl.exportAsDrag(jb, e, TransferHandler.COPY);
                    //^goes to DnDImex.createTransferable()
                }
            });
        }

        jp.add(jp2, BorderLayout.NORTH);
        jp.add(jp3, BorderLayout.CENTER);
        return jp;
    }

    // public int getSourceActions(JComponent c) {
    //     return COPY;
    // }

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