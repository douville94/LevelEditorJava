package Editor;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EditorMain extends JFrame {//, WindowListener {
    //private vars
    private JMenuBar mb;// = new JMenuBar();
    private JMenu fileMenu, editMenu, viewMenu, helpMenu;
    private JMenuItem newItem, save, quit, cut, copy, paste, zoomIn,
        zoomOut, about;
    
    //Constructor
    public EditorMain() {
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());

        mb = new JMenuBar();
        fileMenu = new JMenu("File");
        fileMenu.add(populateJMenuItems(newItem, "New"));
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
        String abtInfo = "Version 0.0.1";
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(cp, abtInfo);
            }
        });
        about.setActionCommand("About Nyarf Editor");
        helpMenu.add(about);

        // helpMenu.add(populateJMenuItems(about, "About Nyarf Editor"));

        mb.add(fileMenu);
        mb.add(editMenu);
        mb.add(viewMenu);
        mb.add(helpMenu);

        // addWindowListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setJMenuBar(mb);
        this.setTitle("Nyarf Editor");
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
                    case "newItem":
                        //create new level;
                        System.out.print("newItem!!");
                        break;
                    case "save":
                        //save current level/workspace
                        break;
                    case "quit":
                        //quit the app
                        break;
                    case "cut":
                        //cut asset
                        break;
                    case "copy":
                        //copy asset
                        break;
                    case "paste":
                        //paste asset
                        break;
                    case "zoomIn":
                        //zoom into the level
                        break;
                    case "zoomOut":
                        //zoom out of the level
                        break;
                }
            }
        });
        x.setActionCommand(name);
        return x;
    }
   
}