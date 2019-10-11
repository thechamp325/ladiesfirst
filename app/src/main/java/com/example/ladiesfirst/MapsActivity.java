package com.example.ladiesfirst;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class MapsActivity extends Fragment implements View.OnClickListener {
    private ViewGroup mListView;

    //Comment to see if I can push to the repository

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @androidx.annotation.Nullable ViewGroup container, @androidx.annotation.Nullable Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.map,container,false);
//        setContentView(R.layout.main);

        mListView = (ViewGroup) v.findViewById(R.id.list);

        addDemo("Heatmaps", HeatmapsDemoActivity.class);

        addDemo("Heatmaps API", HeatmapsPlacesDemoActivity.class);
        return v;

    }

    private void addDemo(String demoName, Class<? extends Activity> activityClass) {
        Button b = new Button(getActivity());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        b.setLayoutParams(layoutParams);
        b.setText(demoName);
        b.setTag(activityClass);
        b.setOnClickListener(this);
        mListView.addView(b);
    }

    @Override
    public void onClick(View view) {
        Class activityClass = (Class) view.getTag();
        startActivity(new Intent(getActivity(), activityClass));
    }
}

