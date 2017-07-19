package skd.app.androidfeatures.sRecylerView;

/**
 * Created by sapan on 7/19/2017.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import skd.app.androidfeatures.R;

/**
 * THis class will be the data adapter for the recycler view
 * This class must exxtend the Recycler view adapter.
 */
public class RvDataAdpt extends RecyclerView.Adapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //lets populate our recyler view with the item created;
        //get the view from the layout inflator
        //  third parameter is set to false to prevent viewgroup to attach to root
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);

        // as this method need to return the viewHolder type
        // need to convert our view to the view holder
        RecyclerView.ViewHolder viewHolder = new RecyclerView.ViewHolder(view) {
            @Override
            public String toString() {
                return super.toString();
            }
        };
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3000; // to display the 100 items
    }
}
