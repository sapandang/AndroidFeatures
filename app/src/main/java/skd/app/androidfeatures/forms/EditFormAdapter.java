package skd.app.androidfeatures.forms;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

import skd.app.androidfeatures.R;
import skd.app.androidfeatures.sRecylerView.SingleDataSelAdapter;

public class EditFormAdapter extends RecyclerView.Adapter<EditFormAdapter.ViewHolder> {

    ArrayList<FormsModel> mFormsModels;
    Context mContext;

    public EditFormAdapter(ArrayList<FormsModel> formsModels, Context context)
    {
        this.mFormsModels = formsModels;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.edit_form_row, parent, false);
        EditFormAdapter.ViewHolder vh = new EditFormAdapter.ViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    final FormsModel formsModel = mFormsModels.get(position);
       holder.formName.setText(formsModel.filename);

       //handler
        holder.formName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putString("VALUE_FILE_NAME",formsModel.fullFilePath);
                Intent i = new Intent(mContext,AddForm.class);
                i.putExtras(b);
                mContext.startActivity(i);;
            }
        });

    }

    @Override
    public int getItemCount() {
       return mFormsModels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView formName;
        public ViewHolder(View v) {
            super(v);
            formName = (TextView) v.findViewById(R.id.form_name);

        }


    }

}
