package skd.app.androidfeatures.compoundview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import skd.app.androidfeatures.R;

public class DropDown extends LinearLayout implements AdapterView.OnItemSelectedListener,ICompoundControl {

    public Spinner spinner;
    public TextView textView;
    Context mContext;
    ArrayList<String> dropDownData = new ArrayList<>();
    HashMap<String,ArrayList<String>> masterData =new HashMap<>();
    DropDown childDropDown;
    public String Key;
    public String label = "textView";

    public String selectedValue;


    public DropDown(Context context) {
        super(context);
        initializeViews(context);
        mContext=context;

    }

    public void setKey(String key)
    {
        this.Key = key;
    }


    public DropDown(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext=context;
        TypedArray typedArray;
        typedArray = context.obtainStyledAttributes(attrs, R.styleable.compoundview);
        label = typedArray.getString(R.styleable.compoundview_label);
        typedArray.recycle();
        initializeViews(context);


    }

    public DropDown(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext=context;
        TypedArray typedArray;
        typedArray = context.obtainStyledAttributes(attrs, R.styleable.compoundview);
        label = typedArray.getString(R.styleable.compoundview_label);
        typedArray.recycle();
        initializeViews(context);


    }

    @TargetApi(21)
    public DropDown(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mContext=context;
        TypedArray typedArray;
        typedArray = context.obtainStyledAttributes(attrs, R.styleable.compoundview);
        label = typedArray.getString(R.styleable.compoundview_label);
        typedArray.recycle();
        initializeViews(context);


    }

    /**
     * method to inflate the compound widget view and attach to view
     * @param context
     */
    private void initializeViews(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       View view =  inflater.inflate(R.layout.compound_widget, this);
       textView = (TextView) view.findViewById(R.id.label);
       spinner = (Spinner) view.findViewById(R.id.spinner);
       spinner.setOnItemSelectedListener(this);
       textView.setText(label);

    }

    public void setlabel(String text)
    {
        textView.setText(text);
    }

    public void setDropDownData(ArrayList<String> arrayList)
    {
        dropDownData=arrayList;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(mContext,android.R.layout.simple_spinner_item,arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        //arrayAdapter.notifyAll();
        spinner.invalidate();

    }

    public void setMasterData(HashMap<String,ArrayList<String>>  masterData)
    {
        this.masterData = masterData;
    }

    public void setChildDropDown(DropDown dropDown)
    {
        childDropDown = dropDown;
    }

    public void setDataFromMaster(String key)
    {
        dropDownData=masterData.get(key.toLowerCase());
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(mContext,android.R.layout.simple_spinner_item,dropDownData);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.invalidate();
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Log.wtf("INFO","dropdown item selected");
        //set the child spinner data
        Log.wtf("WARN","dropDownData or childDropDown can be null no try-catch");
        selectedValue=dropDownData.get(position);
        if(childDropDown!=null && dropDownData!=null)
        {
            Log.wtf("INFO","dropdown selecteded item "+dropDownData.get(position));
            childDropDown.setDataFromMaster(dropDownData.get(position));
            selectedValue=dropDownData.get(position);
        }
    }

    public ArrayList<String> getData()
    {
        ArrayList<String> tArrayList =  new ArrayList<>();
        tArrayList.add(selectedValue);
        return tArrayList;
    }

    @Override
    public String getKey() {
        return Key;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        textView.setText(label);

    }
}
