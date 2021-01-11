package Editor;
import java.awt.*;
import java.awt.dnd.*;
import java.awt.event.*;
import javax.swing.*;

public class DnDExport extends TransferHandler {
    public static TransferHandler exth;
    public DnDExport() {
        // exth = new TransferHandler() {
        //     public int getSourceActions(JComponent c) {return COPY;}

            //Error: 'Transferable' cannot be resolved to a type
            // public Transferable createTransferable(JComponent c) {
            //     return new StringSelection(c.getSelection());
            // }

            // public void exportDone(JComponent c, Transferable t, int action) {
            //     if(action == MOVE) c.removeSelection();
            // }

        //     void setDropMode(DropMode d) {

        //     }
        // };

        setDragEnabled(true);
    }

    public boolean setDragEnabled(boolean b) { return true; }

    @Override
    public int getSourceActions(JComponent c) { return COPY; }

    // public static TransferHandler getTH() {return exth;}
    public TransferHandler getTH() { return this; }

    //copy the TransferSupport sub-class
    public class DnDExportSupport {
        // JComponent getComponent() {return this.c;}

        public int getUserDropAction() { return DnDConstants.ACTION_COPY; }

        public int getSourceDropActions() { return DnDConstants.ACTION_COPY; }
    }
}