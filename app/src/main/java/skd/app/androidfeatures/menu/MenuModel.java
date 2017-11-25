package skd.app.androidfeatures.menu;

/**
 * Created by sapan on 11/26/2017.
 */

public class MenuModel {

    public String name ="nothing";
    public Class activityClass = null;

    public MenuModel(String text , Class activity)
    {
        name =text;
        activityClass = activity;
    }

}
