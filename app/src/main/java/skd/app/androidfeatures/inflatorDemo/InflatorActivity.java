package skd.app.androidfeatures.inflatorDemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import skd.app.androidfeatures.R;

public class InflatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inflator);

        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.inf_li);


        /**
         * get the main content view and add view to it
         * inflating xml and adding view to it
         */
       /* View view = this.findViewById(android.R.id.content);
        FrameLayout frameLayout = (FrameLayout)view;
        Button btnTag = new Button(this);
        btnTag.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        btnTag.setText("Button");
        btnTag.setId(255);
        frameLayout.addView(btnTag);

        LayoutInflater factory = LayoutInflater.from(this);
        View myView = factory.inflate(R.layout.pager_item, null);
        myView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        frameLayout.addView(myView);*/


        /**
         * add components to linear layout
         *
         */
        Button btnTag = new Button(this);
        btnTag.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        btnTag.setText("Button");
        btnTag.setId(255);
        linearLayout.addView(btnTag);

        LayoutInflater factory = LayoutInflater.from(this);
        View myView = factory.inflate(R.layout.pager_item, null);
        myView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        linearLayout.addView(myView);
        linearLayout.addView(myView);

        View myView2 = factory.inflate(android.R.layout.expandable_list_content, null);
        myView2.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        linearLayout.addView(myView2);

    }
}
