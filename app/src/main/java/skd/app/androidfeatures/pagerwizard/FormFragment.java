package skd.app.androidfeatures.pagerwizard;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import org.json.JSONArray;

import java.util.ArrayList;

import skd.app.androidfeatures.R;
import skd.app.androidfeatures.compoundview.DropDown;
import skd.app.androidfeatures.compoundview.ICompoundControl;

public class FormFragment extends Fragment {

    Context mContext;
    PagerWizard mPagerWizard;
    JSONArray compJSONArray;

    ArrayList<ICompoundControl> compoundControlsList = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.form_fragment, container, false);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.comp_holder);

        //parsing the JSON and appending the components
        try {
            Log.wtf("INFO", "genrating components from the JSON");
            for (int i = 0; i < 100; i++) {
                DropDown tDropDown = new DropDown(mContext);
                tDropDown.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                tDropDown.setTag("tag" + i);
                linearLayout.addView(tDropDown);
                tDropDown.setDropDownData(mPagerWizard.dummySpinerAdapter);
                compoundControlsList.add(tDropDown);
            }


        } catch (Exception e) {
            e.printStackTrace();
            Log.wtf("ERROR", "ERROR building the views from JOSN FORMFragment.java");
        }


        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        mPagerWizard = (PagerWizard) context;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btn = (Button)view.findViewById(R.id.dump_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dumpCompoundsData();
            }
        });

    }

    public void setComponentArrary(JSONArray components) {
        this.compJSONArray = components;
    }

    public void dumpCompoundsData()
    {
        for(ICompoundControl t_CompoundControl : compoundControlsList)
        {
            Log.wtf("INFO","widgetData "+t_CompoundControl.getKey()+" - "+t_CompoundControl.getData());
        }
    }



}
