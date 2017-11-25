package skd.app.androidfeatures.sRecylerView;

/**
 * Created by sapan on 7/19/2017.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import skd.app.androidfeatures.R;

/**
 * THis class will be the data adapter for the recycler view
 * This class must exxtend the Recycler view adapter.
 */
public class RvDataAdpt2 extends RecyclerView.Adapter {
    List<DummyModel> dummyModelsList;

    public RvDataAdpt2(List<DummyModel> listDummyModels)
    {
        dummyModelsList = listDummyModels;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //lets populate our recyler view with the item created;
        //get the view from the layout inflator
        //  third parameter is set to false to prevent viewgroup to attach to root
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        return new DummyVH(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //bind the view with the holder
        ((DummyVH)holder).bindVH(dummyModelsList.get(position));
    }

    @Override
    public int getItemCount() {
        return dummyModelsList.size(); // to display the 100 items
    }


}
