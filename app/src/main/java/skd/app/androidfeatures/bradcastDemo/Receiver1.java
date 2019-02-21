package skd.app.androidfeatures.bradcastDemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import skd.app.androidfeatures.serviceDemo.ServiceDemoActivity;

public class Receiver1 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.wtf("SKDINFO","RECEIVER STARTED");

        if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {
            Intent pushIntent = new Intent(context, ServiceDemoActivity.class);
            context.startService(pushIntent);
        }
    }


}
