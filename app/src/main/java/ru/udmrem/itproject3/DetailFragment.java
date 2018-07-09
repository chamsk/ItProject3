package ru.udmrem.itproject3;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailFragment extends android.support.v4.app.Fragment {
    private int position;
    ContactReader contactReader;
    TextView tvName;
    ArrayList<String> names;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.detail_fragment,null);
        //position = savedInstanceState.getInt("position");
        tvName = v.findViewById(R.id.dTvName);
        contactReader = new ContactReader(getActivity());
       // names = contactReader.getNames();
        tvName.setText("242424");


        return v;
    }
}
