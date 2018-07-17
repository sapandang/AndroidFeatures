package skd.app.androidfeatures.compoundview;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
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
import java.util.Calendar;
import java.util.TimeZone;

import skd.app.androidfeatures.R;

public class DatePicker extends LinearLayout implements ICompoundControl, View.OnClickListener {

    public EditText editText;
    public TextView textView;
    Context mContext;
    public String Key;
    private Calendar calendar;
    private DatePicker datePicker;
    public int mYear, mMonth, mDay, mHour, mMinute;
    public String selectedDate="";
    public String label = "textView";


    public DatePicker(Context context) {
        super(context);
        initializeViews(context);
        mContext = context;
    }

    public DatePicker(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initializeViews(context);
        mContext = context;
        TypedArray typedArray;
        typedArray = context.obtainStyledAttributes(attrs, R.styleable.compoundview);
        label = typedArray.getString(R.styleable.compoundview_label);
        typedArray.recycle();
    }

    public DatePicker(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeViews(context);
        mContext = context;
        TypedArray typedArray;
        typedArray = context.obtainStyledAttributes(attrs, R.styleable.compoundview);
        label = typedArray.getString(R.styleable.compoundview_label);
        typedArray.recycle();
    }

    @TargetApi(21)
    public DatePicker(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initializeViews(context);
        mContext = context;
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
        View view = inflater.inflate(R.layout.compound_datepicker, this);
        textView = (TextView) view.findViewById(R.id.label);
        editText = (EditText) view.findViewById(R.id.editText2);
        editText.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        calendar = Calendar.getInstance(TimeZone.getDefault());

        DatePickerDialog datePickerDialog = new DatePickerDialog(mContext, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth) {
                editText.setText(""+dayOfMonth+"/"+month+"/"+year);
                selectedDate=""+dayOfMonth+"/"+month+"/"+year;
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        textView.setText(label);

    }
}
