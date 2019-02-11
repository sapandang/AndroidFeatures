package skd.app.androidfeatures.serviceDemo;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

import skd.app.androidfeatures.R;

public class ServiceTest extends Service {
    public ServiceTest() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startForegroundService();
        Log.wtf("SKDINFO","service start");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
           // startForegroundService();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i=0;
                while (true) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.wtf("SKDINFO", ""+i);
                    i++;
                }
            }
        }).start();
        return START_STICKY;
    }


    /* Used to build and start foreground service. */
    private void startForegroundService()
    {
        createNotificationChannel();
        Log.d("SKDINFO", "Start foreground service.");
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, "CHANNEL_ID")
                .setSmallIcon(R.drawable.common_google_signin_btn_icon_dark)
                .setContentTitle("title")
                .setContentText("contnt")
                .setPriority(NotificationCompat.PRIORITY_HIGH);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        notificationManager.notify(10, mBuilder.build());

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.wtf("SKDINFO","service Stop");
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "CHANNEL_ID";
            String description =  "CHANNEL_ID";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel( "CHANNEL_ID", name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
