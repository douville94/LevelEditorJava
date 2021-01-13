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

public class PaintJTableCell extends JTable implements TableModel {
    public int row, column;

    public PaintJTableCell(int row, int column) {
        this.row = row;
        this.column = column;
        int i = 0, j = 0;
        // while(i <= row) {
        //     this.addColumn(aColumn);
        // }
    }

    @Override
    public Class<?> getColumnClass(int column) {
        return Icon.class;
    }

    @Override
    public int getColumnCount() {
        return column;
    }

    @Override
    public int getRowCount() {
        return row;
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        // TODO Auto-generated method stub

    }
}