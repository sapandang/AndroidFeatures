package skd.app.androidfeatures.sRecylerView;

import android.net.wifi.p2p.WifiP2pManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sapan on 10/3/2017.
 */

public class DummyModel {

    //text
    String textData = "not set yet !!";

    public DummyModel() {

    }

    /**
     * constructor to set the dummy text
     * @param data
     */
    public DummyModel(String data) {
        textData = data;
    }

    static public List<DummyModel> getDummyModel(int length) {
        List<DummyModel> dummyModelsList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            dummyModelsList.add(new DummyModel("This is the model "+i));
        }
        return dummyModelsList;
    }

    /**
     * just a setter method !Not used!
     * @param text
     */
    public void setText(String text) {
        this.textData = text;
    }

}
