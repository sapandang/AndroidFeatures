package skd.app.androidfeatures.sRecylerView;

import android.app.Application;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import skd.app.androidfeatures.R;

/**
 * Created by sapan on 10/3/2017.
 */

public class DummyVH extends RecyclerView.ViewHolder {

    TextView textView;

    /**
     * Constructor to set the items
     * @param itemView
     */
    public DummyVH(View itemView) {
        super(itemView);
        textView = (TextView)itemView.findViewById(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RecylerActivity.context, "yooo "+textView.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * functiion to set the data
     * @param dummyModel
     */
    public void bindVH(DummyModel dummyModel)
    {
        textView.setText(dummyModel.textData);
    }

}
