package skd.app.androidfeatures.utils;

import android.content.Context;

import java.io.InputStream;

public class FilesUtil {

    public static String ReadFileToString(Context context, String filename)
    {

        String json = null;
        try {
            InputStream is = context.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }



}
