package generic;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 *
 * @author Dwi Fauzi
 */
public class Musik {
    
    JFileChooser fc = new JFileChooser();
    ArrayList ls = new ArrayList();
    
    void add(JFrame frame){
        fc.setMultiSelectionEnabled(true);
        int fileValid = fc.showOpenDialog(frame);
        if (fileValid == javax.swing.JFileChooser.CANCEL_OPTION){
            return;
        } else if (fileValid == javax.swing.JFileChooser.APPROVE_OPTION){
            File[] file = fc.getSelectedFiles();
            ls.addAll(Arrays.asList(file));
        }
    }
    
    ArrayList getListSong(){
        return ls;
    }
    String path, fileName, fileSize, extention;
    
    public Musik(String p, String fn, String fs, String e) {
        this.path = p;
        this.fileName = fn;
        this.fileSize = fs;
        this.extention = e;
    }
    public String getPath() {
        return path;
    }
    public String getFileName() {
        return fileName;
    }
    public String getFileSize() {
        return fileSize;
    }
    public String getExtention() {
        return extention;
    }
    
    
}
