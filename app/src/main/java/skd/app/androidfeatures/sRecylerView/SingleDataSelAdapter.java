package skd.app.androidfeatures.sRecylerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

import skd.app.androidfeatures.R;

public class SingleDataSelAdapter extends RecyclerView.Adapter<SingleDataSelAdapter.ViewHolder> {

    ArrayList<SelectDataModel> selectDataModels;
    private int lastCheckedPosition = -1;

    public SingleDataSelAdapter(ArrayList<SelectDataModel> selectDataModels)
    {
        this.selectDataModels = selectDataModels;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.comp_single_select_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

       //get the model at the position
       final SelectDataModel t_selecSelectDataModel = selectDataModels.get(position);


        /**
         * Click event for the radio button
         */
        holder.radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                t_selecSelectDataModel.isSelected=true; //set the clicked data model selected to true

                //uncheck the last radio button
                //lastposition holds the last checkbox
                //lastpositon is -1 so to avoid indexOutOfBound used try
                try {
                    if(lastCheckedPosition!=position) {
                        SelectDataModel last_selecSelectDataModel = selectDataModels.get(lastCheckedPosition); //get last model
                        last_selecSelectDataModel.isSelected = false; //set model to flase
                        last_selecSelectDataModel.text = "I am changed"; //change the text
                    }
                }catch (Exception e)
                {
                    e.printStackTrace();
                }

                lastCheckedPosition=position;
                notifyItemRangeChanged(0,selectDataModels.size());
            }
        });

        //set up the radio button
        //check and uncheck radio depend upon the model data
        if(t_selecSelectDataModel.isSelected) {

            holder.radioButton.setText("i am selected "+lastCheckedPosition);
            holder.radioButton.setChecked(true);
            holder.radioButton.invalidate();

        }else
        {
            holder.radioButton.setChecked(false);
            holder.radioButton.invalidate();
            holder.radioButton.setText("i am not "+lastCheckedPosition);
        }


    }

    @Override
    public int getItemCount() {
        return selectDataModels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public RadioButton radioButton;
        public ViewHolder(View v) {
            super(v);
            radioButton = (RadioButton)v.findViewById(R.id.radioButton);

        }


    }



}
