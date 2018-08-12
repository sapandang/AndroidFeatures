package skd.app.androidfeatures.sRecylerView;

import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import skd.app.androidfeatures.R;

public class MultiDataSelAdapter extends RecyclerView.Adapter<MultiDataSelAdapter.ViewHolder> {

    ArrayList<SelectDataModel> selectDataModels;

    public MultiDataSelAdapter(ArrayList<SelectDataModel> selectDataModels)
    {
        this.selectDataModels = selectDataModels;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.comp_multi_select_item, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public ViewHolder(View v) {
            super(v);

        }
    }



}
