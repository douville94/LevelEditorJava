package Editor;
import java.awt.*;
import java.awt.dnd.*;
import java.awt.datatransfer.*;
import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Base64;
import java.awt.event.InputEvent;

public class CustomTableModel extends DefaultTableModel {
    public CustomTableModel(Object[][] data, String[] colNames) { }

    @Override
    public Class<?> getColumnClass(int column) {
        // return ImageIcon.class;
        return getValueAt(0, column).getClass();
    }
}