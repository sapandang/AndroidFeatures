package skd.app.androidfeatures.compoundview;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import skd.app.androidfeatures.R;

public class CompoundWidget extends LinearLayout {
    public CompoundWidget(Context context) {
        super(context);
        initializeViews(context);

    }

    public CompoundWidget(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initializeViews(context);

    }

    public CompoundWidget(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeViews(context);

    }

    @TargetApi(21)
    public CompoundWidget(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initializeViews(context);

    }

    /**
     * method to inflate the compound widget view and attach to view
     * @param context
     */
    private void initializeViews(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.compound_widget, this);
    }





}
