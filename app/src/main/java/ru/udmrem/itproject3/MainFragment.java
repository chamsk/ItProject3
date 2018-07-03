package ru.udmrem.itproject3;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MainFragment extends Fragment {


    ContactReader contactReader;
    private int REQUEST_CODE_PERMISSION_READ_CONTACTS = 100;
    OnItemClick onItemClick;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onItemClick = (OnItemClick) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_main,null);
        contactReader = new ContactReader(getActivity());
        checkPermission();
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.rv);
        ListAdapter listAdapter = new ListAdapter();
        listAdapter.addList(contactReader.getNames());
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(listAdapter);

        return v;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onItemClick = null;
    }

    //block permission
    public void checkPermission(){
        int permissionStatus = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_CONTACTS);
        Log.d("asd","asdg");
        if (permissionStatus == PackageManager.PERMISSION_GRANTED) {

            contactReader.readContacts();


            Log.d("PERMISSION","granted");
        } else {
            ActivityCompat.requestPermissions(getActivity(), new String[] {Manifest.permission.READ_CONTACTS},
                    REQUEST_CODE_PERMISSION_READ_CONTACTS);

        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 100:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission granted

                } else {
                    // permission denied
                }
                return;
        }
    }
}
