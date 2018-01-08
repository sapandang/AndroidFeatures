package skd.app.androidfeatures.menu;

import android.app.Application;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import skd.app.androidfeatures.MainActivity;
import skd.app.androidfeatures.R;
import skd.app.androidfeatures.sRecylerView.RecylerActivity;

/**
 * Created by sapan on 11/26/2017.
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuView> {

    ArrayList<MenuModel> menuList;

    public MenuAdapter(ArrayList<MenuModel> list)
    {
        menuList = list;
    }

    @Override
    public MenuView onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        return new MenuView(v);
    }

    @Override
    public void onBindViewHolder(MenuView holder, int position) {
        holder.text.setText(menuList.get(position).name);
        holder.activityClass = menuList.get(position).activityClass;
    }

    @Override
    public int getItemCount() {
      return   menuList.size();
    }

    public  class MenuView extends RecyclerView.ViewHolder
    {
        public TextView text;
        public Class activityClass = null;

        public MenuView(final View itemView) {
            super(itemView);
            text =(TextView) itemView.findViewById(R.id.textView);

            text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(itemView.getContext(),activityClass );
                    MainActivity.mainActivity.startActivity(in);

                }
            });

        }
    }

}
