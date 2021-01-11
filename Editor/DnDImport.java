package Editor;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DnDImport extends TransferHandler {
    // public JComponent c;
    public DnDImport() {

    }

    public boolean canImport(TransferHandler.TransferSupport ts) {
        //This method is called repeatedly while dragged component is moved
        //Query the area below moving component to see if we can drop
        //Get drop location
        // DropLocation loc = DnDImportSupport.getDropLocation();
        // if(loc == null) { return false; }
        return true;
    }

    public boolean importData(TransferHandler.TransferSupport ts2) {
        if(!canImport(ts2)) { return false; }
        java.awt.datatransfer.Transferable t = ts2.getTransferable();
        //Get drop location
        // String data = t.getTransferData(stringFlavor);
        // DropLocation loc = DnDImportSupport.getDropLocation();
        //Insert data at location
        // insertAt(loc, data);
        return true;
    }

    public static class DnDImportSupport {
        // JComponent getComponent() {return c;}
        int getDropAction() {return COPY;}
        int getUserDropAction() {return java.awt.dnd.DnDConstants.ACTION_COPY;}
        //int getSourceDropActions()
        //DataFlavor[] getDataFlavors()
        //boolean isDataFlavorSupported(DataFlavor)
        // java.awt.datatransfer.Transferable getTransferable()
        // public static DropLocation getDropLocation() {
            //Return drop location for the JButton
        //     DropLocation d;// = new DropLocation();
        //     return d;
        // }
    }
}