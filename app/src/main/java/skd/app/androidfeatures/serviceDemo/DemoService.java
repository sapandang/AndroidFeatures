package skd.app.androidfeatures.serviceDemo;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import skd.app.androidfeatures.R;

/**
 * Created by sapan on 9/24/2017.
 */

public class DemoService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Toast.makeText(this,"Service started ",Toast.LENGTH_SHORT).show();
        super.onCreate();
        WindowManager mWindowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        Display display = mWindowManager.getDefaultDisplay();

        Button btn = new Button(this);
        btn.setText("Haaa III");
        LayoutInflater layoutInflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //   LinearLayout linearLayout = (LinearLayout) R.layout.recycler_item;
        //View view = LayoutInflater.from(this).inflate(R.layout.recycler_item, null);
        View view = layoutInflater.inflate(R.layout.activity_overlay,null);

        WindowManager.LayoutParams params = new WindowManager.LayoutParams(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.TYPE_PHONE,
                   WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN, PixelFormat.TRANSLUCENT);


        WindowManager.LayoutParams paramsx = new  WindowManager.LayoutParams(WindowManager.LayoutParams.TYPE_APPLICATION_SUB_PANEL,
                WindowManager.LayoutParams.FLAG_FULLSCREEN|WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                        | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,PixelFormat.TRANSPARENT);

        WindowManager.LayoutParams params2 =new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_SYSTEM_ALERT,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);
         params.gravity = Gravity.LEFT | Gravity.TOP;
         //params.x = 0;
         //params.y = 0;
        mWindowManager.addView(view, params);



    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this,"Service stopped ",Toast.LENGTH_SHORT).show();

        super.onDestroy();

    }
}
