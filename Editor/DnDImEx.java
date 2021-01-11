package Editor;
import java.awt.*;
import java.awt.dnd.*;
import java.awt.datatransfer.*;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Base64;

public class DnDImEx extends TransferHandler {//implements Transferable {
    public static final DataFlavor df = DataFlavor.stringFlavor;
    public String imgByteString;
    byte[] imgByteArray;
    public ArrayList<String> AssetsList = EditorMain.AssetsList;

    public DnDImEx() {

    }

    /*We support COPY only*/
    @Override
    public int getSourceActions(JComponent c) { return COPY; }

    public TransferHandler getTH() { return this; }

    public boolean canImport(TransferHandler.TransferSupport ts) {
        return true;
    }

    public String getValue() { return imgByteString; }

    public boolean setDragEnabled(boolean b) { return true; }

    // @Override
    // public Object getTransferData(DataFlavor flavor) {

    // }

    /*Package data in JButton into Transferable object */
    @Override
    public Transferable createTransferable(JComponent c) {
        JButton btn = (JButton)c;
        //grab image from JButton
        Icon i = btn.getIcon();
        ImageIcon ii = (ImageIcon)btn.getIcon();
        Image img = ii.getImage();
        // byte imgData[] = img.toString();
        // byte[] imgByteArray = 

        DataFlavor imgFlv = DataFlavor.imageFlavor;
        /**Transferable is an interface and thus cannot be instantiated
         * You'd need to initialize one of Transferable's implementing classes:
         * DataHandler, DropTargetContext.TransferableProxy, or StringSelection
         * Only StringSelection has a valid constructor
         * You'll need to convert the image/icon from btn into a String and export it
         */
        //Get the filename/path
        File file;// = new File("path");
        FileInputStream fis;
        // for(int iter = 0; iter < EditorMain.AssetsList.size(); iter++) {
        // for(String iter : EditorMain.AssetsList) {
        //     // file = new File(AssetsList.get(iter));
        //     file = new File(iter);
            
        //     try {
        //         fis = new FileInputStream(file);
        //         // imgByteArray = new byte[(int)file.length()];
        //         imgByteArray = Base64.getEncoder().encode(file.toString().getBytes());
        //         fis.read(imgByteArray);
        //         // imgByteString = Base64.encodeBase64(imgByteArray).toString();
        //         imgByteString = imgByteArray.toString();
        //     } catch (FileNotFoundException e) { break; }
        //     catch (IOException e) { break; }
        // }

        // if(ii.toString().equals(imgByteString)) {}

        imgByteString = ii.toString();

        // DataHandler dh = new DataHandler(i, DataSource.getInputStream(i));
        // DataFlavor df = new DataFlavor(Object.class, "imgClass");
        // DataFlavor[] df = Transferable.getTransferDataFlavors();
        // return Transferable.getTransferData(df);

        // Object o = Transferable.getTransferData(imgFlv);
        return new StringSelection(getValue());
        // return new DataHandler(Transferable.getTransferData(imgFlv, ""));
        // return DropTargetContext.TransferableProxy.getTransferData(imgFlv);
    }

    /**Import the data*/
    @Override
    public boolean importData(TransferHandler.TransferSupport tsimpt) {
        JButton btn = (JButton)tsimpt.getComponent();
        //Our JComponent is not a JList, but maybe this code will work
        JList.DropLocation dl = (JList.DropLocation)tsimpt.getDropLocation();
        int index = dl.getIndex();
        Transferable t = tsimpt.getTransferable();
        //need exceptions to call getTransferData
        try {
            String tempstr = (String)t.getTransferData(DataFlavor.stringFlavor);
        }
        catch(Exception e) { return false; }

        //Fill the destination w/ the actual data
        //Convert byteString back into actual Image
        //btn.setIcon(new ImageIcon(convertedImage))
        imgByteArray = Base64.getDecoder().decode(imgByteString);
        ImageIcon ii = new ImageIcon(imgByteArray);
        btn.setIcon(ii);
        return true;
    }

    @Override
    protected void exportDone(JComponent c, Transferable t, int action) {

    }
}