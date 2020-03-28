package skd.app.androidfeatures.serviceDemo.services;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.Toast;
import android.support.annotation.Nullable;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import skd.app.androidfeatures.R;
import skd.app.androidfeatures.serviceDemo.ServiceDemoActivity;

/**
 * Create Forground service
 */
public class Service2 extends Service {
    private IBinder mBinder = new MyBinder();
    private Timer timer;
    private TimerTask updateTask = new TimerTask() {
        @Override
        public void run() {
            Log.wtf("SKDINFO", "Timer task doing work");
        }
    };
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.wtf("SKDINFO", "SERVICE onBind ");

        return mBinder;
    }


    @Override
    public void onCreate() {
        Log.wtf("SKDINFO", "SERVICE onCreate ");

        super.onCreate();

        final Context mContext= this;
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run()
            {
                Toast.makeText(mContext,"Service Created",Toast.LENGTH_SHORT).show();

            }
        });
        timer = new Timer("TweetCollectorTimer");
        timer.schedule(updateTask, 1000L, 60 * 1000L);


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.wtf("SKDINFO", "SERVICE onStartCommand ");

        startForegroundService();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.wtf("SKDINFO", "SERVICE "+System.currentTimeMillis());
                }
            }
        }).start();
       return START_STICKY;
        //return super.onStartCommand(intent, flags, startId);

       // return super.onStartCommand(intent, START_STICKY_COMPATIBILITY, startId);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.wtf("SKDINFO", "SERVICE onDestroy ");
        Toast.makeText(getApplicationContext(), "Service Task destroyed", Toast.LENGTH_LONG).show();


        Intent myIntent = new Intent(getApplicationContext(), Service2.class);

        PendingIntent pendingIntent = PendingIntent.getService(getApplicationContext(), 0, myIntent, 0);

        AlarmManager alarmManager1 = (AlarmManager) getSystemService(ALARM_SERVICE);

        Calendar calendar = Calendar.getInstance();

        calendar.setTimeInMillis(System.currentTimeMillis());

        calendar.add(Calendar.SECOND, 10);

        alarmManager1.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

        Toast.makeText(getApplicationContext(), "Start Alarm", Toast.LENGTH_SHORT).show();


    }



    public void startForegroundService()
    {
        createNotificationChannel();
        Log.d("SKDINFO", "Start foreground service.");
//        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, "CHANNEL_ID")
//                .setSmallIcon(R.drawable.common_google_signin_btn_icon_dark)
//                .setContentTitle("title")
//                .setContentText("contnt")
//                .setOngoing(true);
                //.setPriority(NotificationCompat.PRIORITY_HIGH);
        //NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        //notificationManager.notify(10, mBuilder.build());


        Intent callable = new Intent(this, ServiceDemoActivity.class);
        callable.setAction("android.intent.action.MAIN");
        callable.addCategory("android.intent.category.LAUNCHER");
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, callable, 0);

        Notification notification = new NotificationCompat.Builder(this, "notification-channel-errors")
                .setContentTitle("dfdfg")
                .setContentText("fgfg")
                .setSmallIcon(R.drawable.custom_spinner_back)
                .setContentIntent(contentIntent)
                .build();




        this.startForeground(12,notification);

    }
    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "notification-channel-errors";
            String description =  "notification-channel-errors";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel( "notification-channel-errors", name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
           // NotificationManager notificationManager = getSystemService(NotificationManager.class);//
            NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

            notificationManager.createNotificationChannel(channel);
        }
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        Log.wtf("SKDINFO", "SERVICE onTaskRemoved ");

        super.onTaskRemoved(rootIntent);
        startForegroundService();

        Intent myIntent = new Intent(getApplicationContext(), Service2.class);

        PendingIntent pendingIntent = PendingIntent.getService(getApplicationContext(), 0, myIntent, 0);

        AlarmManager alarmManager1 = (AlarmManager) getSystemService(ALARM_SERVICE);

        Calendar calendar = Calendar.getInstance();

        calendar.setTimeInMillis(System.currentTimeMillis());

        calendar.add(Calendar.SECOND, 10);

        alarmManager1.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

        Toast.makeText(getApplicationContext(), "Start Alarm", Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Log.wtf("SKDINFO", "SERVICE onLowMemory ");

    }

    public class MyBinder extends Binder {
       public Service2 getService() {
            return Service2.this;
        }
    }
}
