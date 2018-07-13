package ru.udmrem.itproject3.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



import ru.udmrem.itproject3.R;

public class DetailFragment extends android.support.v4.app.Fragment {


    TextView tvName;
    TextView tvPhone;
    TextView tvEmail;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.detail_fragment,null);
        tvName = v.findViewById(R.id.dTvEmail);
        tvPhone = v.findViewById(R.id.dTvEmail);
        tvEmail = v.findViewById(R.id.dTvPhone);

        tvName.setText(getArguments().getString("name"));
        tvPhone.setText(getArguments().getString("phone"));
        tvEmail.setText(getArguments().getString("email"));


        return v;
    }
}
