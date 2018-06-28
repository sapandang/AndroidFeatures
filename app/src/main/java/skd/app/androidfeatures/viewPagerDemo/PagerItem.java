package skd.app.androidfeatures.viewPagerDemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import skd.app.androidfeatures.R;

/**
 * Created by sapan on 12/25/2017.
 */

public class PagerItem extends Fragment {

    String textViewText="yoo";
     public String title = "dummy";
    TextView textView;
    Switch simpleSwitch ;
Context mContext;
    // check current state of a Switch (true or false).
    Boolean switchState= false;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pager_item, container, false);
        Button btnTag = new Button(mContext);
        btnTag.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        btnTag.setText("Button");
        btnTag.setId(255);
        LinearLayout linearLayout = (LinearLayout)view;
        linearLayout.addView(btnTag);

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = (TextView) view.findViewById(R.id.textView2);
        textView.setText(textViewText);
        simpleSwitch = (Switch) view.findViewById(R.id.switch1);
        switchState = simpleSwitch.isChecked();

        simpleSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchState = simpleSwitch.isChecked();
            }
        });

    }

    public void setTextView(String a)
    {
        textViewText =a;
    }

    public boolean canMove()
    {
        return simpleSwitch.isChecked();
    }

    public void setTitle(String title)
    {
        this.title = title;
    }
}


