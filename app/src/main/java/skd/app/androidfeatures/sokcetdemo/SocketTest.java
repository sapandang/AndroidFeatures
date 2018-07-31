package skd.app.androidfeatures.sokcetdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import skd.app.androidfeatures.R;

public class SocketTest extends AppCompatActivity {
    Socket socket;
    EditText editText;
    Button button;

    String wsURl = "http://192.168.0.109:3000/log";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socket_test);


        editText = (EditText)findViewById(R.id.editText3);
        button = (Button)findViewById(R.id.button4);

        IO.Options options = new IO.Options();
        options.path="/log";

        editText.setText("Started");
        try {
            socket = IO.socket(wsURl,options);
        }catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {

            @Override
            public void call(Object... args) {
                socket.emit("foo", "hi");
                //socket.disconnect();
            }

        }).on("hi", new Emitter.Listener() {

            @Override
            public void call(Object... args) {
                Log.wtf("SKDINFO","received");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        editText.setText("received ");
                    }
                });

            }

        }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {

            @Override
            public void call(Object... args) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        editText.setText("Disconnected ");
                    }
                });

            }

        });
        socket.connect();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                socket.emit("hi","send frpom app");

            }
        });

    }
}
