package skd.app.androidfeatures.serviceDemo;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import skd.app.androidfeatures.R;

public class ServiceTest1 extends Service {


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.wtf("SKDINFO","service onBind");
        return null;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.wtf("SKDINFO","service Created");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.wtf("SKDINFO","service start");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService();
        }
        return START_STICKY;
    }


    /* Used to build and start foreground service. */
    private void startForegroundService()
    {
        Log.d("SKDINFO", "Start foreground service.");

        // Create notification default intent.
        Intent intent = new Intent();
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        // Create notification builder.
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        // Make notification show big text.
        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
        bigTextStyle.setBigContentTitle("Music player implemented by foreground service.");
        bigTextStyle.bigText("Android foreground service is a android service which can run in foreground always, it can be controlled by user via notification.");
        // Set big text style.
        builder.setStyle(bigTextStyle);

        builder.setWhen(System.currentTimeMillis());
        builder.setSmallIcon(R.mipmap.ic_launcher);
        Bitmap largeIconBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.common_full_open_on_phone);
        builder.setLargeIcon(largeIconBitmap);
        // Make the notification max priority.
        builder.setPriority(Notification.PRIORITY_MAX);
        // Make head-up notification.
        builder.setFullScreenIntent(pendingIntent, true);


        // Build the notification.
        Notification notification = builder.build();

        // Start foreground service.
        startForeground(1, notification);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.wtf("SKDINFO","service Stop");
    }
}
