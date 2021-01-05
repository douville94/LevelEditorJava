package Editor;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EditorMain extends JFrame {
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
        cp = getContentPane();
        cp.setLayout(new FlowLayout());
        /*Instantiating blank JFrame instead of Container w/ getContentPane()
        stops pop-up windows from lining up w/ rest of window, e.g. About dialog
        is off-center*/
        // f = new JFrame("Top-level_frame");

        /*Constructor should be creating new blank editor space anyway
        Don't worry about "New" file menu for now*/
        cp.add(initEditorSpace(cp, p));
        // p = new JPanel(new FlowLayout());
        // JButton temp = new JButton("doy");
        // p.add(temp);
        // cp.add(p);

        mb = new JMenuBar();
        fileMenu = new JMenu("File");
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
        /*This has to go here; cannot call cp as arg in showMessageDialog
        if in populateJMenuItems()*/
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(cp, abtInfo);
            }
        });
        about.setActionCommand("About Nyarf Editor");
        helpMenu.add(about);

        mb.add(fileMenu);
        mb.add(editMenu);
        mb.add(viewMenu);
        mb.add(helpMenu);

        // addWindowListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setJMenuBar(mb);
        this.setTitle("Nyarthis Editor");
        this.setSize(900, 900);
        this.setVisible(true);
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

    public JPanel initEditorSpace(Container c, JPanel jp) {
        jp = new JPanel(new BorderLayout());

        /*Trying to align JPanel to the left */
        JPanel jp2 = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        // jp2.setBorder(BorderFactory.createLineBorder(Color.RED, 5, true));
        ImageIcon img = new ImageIcon("Assets//Megaman_moving-1.png");
        // JButton temp = new JButton("doy");
        JButton temp = new JButton(img);
        jp2.add(temp, gbc);
        jp2.add(new JButton("derp1"), gbc);
        jp2.add(new JButton("derp2"), gbc);
        jp2.add(new JButton("derp3"), gbc);
        jp.add(jp2);
        return jp;
    }
}