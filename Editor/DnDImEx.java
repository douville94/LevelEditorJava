package Editor;
import java.awt.*;
import java.awt.dnd.*;
import java.awt.datatransfer.*;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Base64;
import java.awt.event.InputEvent;

public class DnDImEx extends TransferHandler {//implements Transferable {
    public static final DataFlavor df = DataFlavor.stringFlavor;
    public String imgByteString;
    public File file;
    public FileInputStream fis;
    public ArrayList<String> imgByteStringArrayList;
    public ArrayList<byte[]> imgByteArrayList;
    // byte[] imgByteArray;
    public ImageIcon ii;
    public ArrayList<String> AssetsList = EditorMain.AssetsList;
    public Image image;

    public DnDImEx() {
        /**Organize asset paths into an ArrayList of strings
         * 
        */
        int i = 0;
        imgByteStringArrayList = new ArrayList<String>();
        // for(int iter = 0; iter < EditorMain.AssetsList.size(); iter++) {
        for(String iter : EditorMain.AssetsList) {
            file = new File(iter);
            try {
                fis = new FileInputStream(file);
                byte[] imgByteArray = new byte[(int)file.length()];
                imgByteArray = Base64.getEncoder().encode(file.toString().getBytes());
                fis.read(imgByteArray);
                // imgByteString = Base64.encodeBase64(imgByteArray).toString();
                // imgByteString = imgByteArray.toString();
                imgByteString = new String(imgByteArray, "UTF-8");
                imgByteStringArrayList.add(i, imgByteString);
                // imgByteArrayList.add(i, imgByteArray);
            } catch (FileNotFoundException e) { break; }
            catch (IOException e) { break; }
            i++;
        }
    }

    public TransferHandler getTH() { return this; }

    //IMPORT SECTION
    public boolean canImport(TransferHandler.TransferSupport ts) {
        DropLocation droploc = ts.getDropLocation();
        if(droploc != null) { return true; }
        return false;
    }
    /**Import the data*/
    @Override
    public boolean importData(TransferHandler.TransferSupport tsimpt) {
        boolean result = false;
        // JButton btn = (JButton)tsimpt.getComponent();
        // ii = (ImageIcon)btn.getIcon();

        //Our JComponent is not a JList, but maybe this code will work
        // JList.DropLocation dl = (JList.DropLocation)tsimpt.getDropLocation();
        // int index = dl.getIndex();
        // Transferable t = tsimpt.getTransferable();
        //need try-catch block to call getTransferData
        try {
            Transferable t = tsimpt.getTransferable();
            /*^We're getting valid drop location here*/
            String tempstr = (String)t.getTransferData(DataFlavor.stringFlavor);
            // JComponent jcomp = (JComponent)tsimpt.getComponent();
            JTable jt = (JTable)tsimpt.getComponent();
            // byte[] imgByteArray2 = Base64.getDecoder().decode(tempstr);
            /**^IllegalArgumentException
             * Illegal base64 character 5b (or 3f)
            */
            byte[] imgByteArray2 = Base64.getMimeDecoder().decode(tempstr);
            /**^IllegalArgumentException 
             * Last unit does not have enough valid bits
            */

            System.out.println("imgByteString = " + tempstr);
            System.out.println("imgByteArray2 = " + imgByteArray2.toString());

            ii = new ImageIcon(imgByteArray2);
            jt.setValueAt(ii, jt.getDropLocation().getRow(), 
                jt.getDropLocation().getColumn());
            // if(jcomp instanceof JButton) {
            //     ((JButton)jcomp).setIcon(ii);
            //     result = true;
            // }

            // DropLocation loc = tsimpt.getDropLocation();
            //insertAt(loc, tempstr);
        }
        catch(Exception e) { return false; }//e.printStackTrace();

        //Fill the destination w/ the actual data
        //Convert byteString back into actual Image
        //btn.setIcon(new ImageIcon(convertedImage))
        // imgByteArray = Base64.getDecoder().decode(imgByteString);
        // ImageIcon ii = new ImageIcon(imgByteArray);
        // btn.setIcon(ii);
        return result;
    }

    //EXPORT SECTION
    /*We support COPY only*/
    @Override
    public int getSourceActions(JComponent c) { return COPY; }
    
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
        Icon icon = btn.getIcon();
        ii = (ImageIcon)btn.getIcon();
        // Image img = ii.getImage();
        // byte imgData[] = img.toString();
        // byte[] imgByteArray = 

        // DataFlavor imgFlv = DataFlavor.imageFlavor;
        /**Transferable is an interface and thus cannot be instantiated
         * You'd need to initialize one of Transferable's implementing classes:
         * DataHandler, DropTargetContext.TransferableProxy, or StringSelection
         * Only StringSelection has a valid constructor
         * You'll need to convert the image/icon from btn into a String and export it
         */
        //Get the filename/path
        // File file;// = new File("path");
        // FileInputStream fis;
        //This is iterating over all the files in the arraylist and overwriting
        //imgByteString each time

        for(String iter : imgByteStringArrayList) {
            if(iter.equals(ii.toString())) { imgByteString = iter; }
        }
        setDragImage(ii.getImage());
        // if(ii.toString().equals(imgByteString)) {}

        // imgByteString = ii.toString();

        // DataHandler dh = new DataHandler(i, DataSource.getInputStream(i));
        // DataFlavor df = new DataFlavor(Object.class, "imgClass");
        // DataFlavor[] df = Transferable.getTransferDataFlavors();
        // return Transferable.getTransferData(df);

        // Object o = Transferable.getTransferData(imgFlv);
        return new StringSelection(getValue());
        // return new DataHandler(Transferable.getTransferData(imgFlv, ""));
        // return DropTargetContext.TransferableProxy.getTransferData(imgFlv);
    }

    @Override
    public void setDragImage(Image img) { image = img; }

    @Override
    public Image getDragImage() { return image; }

    // @Override
    // public void exportAsDrag(JComponent comp, InputEvent e, int action) {
    //     getSourceActions(comp);
    // }

    // @Override
    // protected void exportDone(JComponent c, Transferable t, int action) {
    //     // super.exportDone(c, t, action);
    //     JButton jbtn = (JButton)c;
    //     jbtn.setIcon(ii);
    // }
}