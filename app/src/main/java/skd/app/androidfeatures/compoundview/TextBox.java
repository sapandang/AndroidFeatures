package skd.app.androidfeatures.compoundview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import skd.app.androidfeatures.R;

public class TextBox extends LinearLayout  implements ICompoundControl{

    public EditText editText;
    public TextView textView;
    Context mContext;
    public String Key;
    public String label = "textView";


    public TextBox(Context context) {
        super(context);
        initializeViews(context);
        mContext=context;
    }

    public TextBox(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initializeViews(context);
        mContext=context;
        TypedArray typedArray;
        typedArray = context.obtainStyledAttributes(attrs, R.styleable.compoundview);
        label = typedArray.getString(R.styleable.compoundview_label);
        typedArray.recycle();
    }

    public TextBox(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeViews(context);
        mContext=context;
        TypedArray typedArray;
        typedArray = context.obtainStyledAttributes(attrs, R.styleable.compoundview);
        label = typedArray.getString(R.styleable.compoundview_label);
        typedArray.recycle();
    }

    @TargetApi(21)
    public TextBox(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initializeViews(context);
        mContext=context;
        TypedArray typedArray;
        typedArray = context.obtainStyledAttributes(attrs, R.styleable.compoundview);
        label = typedArray.getString(R.styleable.compoundview_label);
        typedArray.recycle();
    }

    @Override
    public ArrayList<String> getData() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(editText.getText().toString());
        return arrayList;
    }

    @Override
    public String getKey() {
        return Key;
    }


    private void initializeViews(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view =  inflater.inflate(R.layout.compound_textbox, this);
        textView = (TextView) view.findViewById(R.id.label);
        editText = (EditText)view.findViewById(R.id.editText);

    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        textView.setText(label);

    }
}
