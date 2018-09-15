package skd.app.androidfeatures.forms;

import java.io.File;

public class FormsModel {

    public String filename;
    public File file;
    public String fullFilePath;

    public void setFile(File file) {
        if(file==null)
        {
            throw new RuntimeException("file Stream is closed");
        }
        this.file = file;
        this.filename = file.getName().toString();
        this.fullFilePath=file.getAbsolutePath().toString();
    }
}
