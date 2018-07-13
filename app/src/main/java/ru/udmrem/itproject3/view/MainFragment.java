package ru.udmrem.itproject3.view;

import android.Manifest;
import android.content.ContentResolver;
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

import ru.udmrem.itproject3.ListAdapter;
import ru.udmrem.itproject3.R;
import ru.udmrem.itproject3.presenters.MainFragmentPresenter;


public class MainFragment extends Fragment {



   // ContactReader contactReader;
    private int REQUEST_CODE_PERMISSION_READ_CONTACTS = 100;
    MainFragmentPresenter presenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        presenter = new MainFragmentPresenter(getContext());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_main,null);
        checkPermission();
        presenter.loadContacts();

        RecyclerView recyclerView = v.findViewById(R.id.rv);
        ListAdapter listAdapter = new ListAdapter(getContext());
        listAdapter.addList(presenter.getContacts());
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(listAdapter);

        return v;
    }


    //block permission
    public void checkPermission(){
        int permissionStatus = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_CONTACTS);
        Log.d("asd","asdg");
        if (permissionStatus == PackageManager.PERMISSION_GRANTED) {

            presenter.loadContacts();

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
    @Override
    public void onDetach() {
        super.onDetach();
        presenter = null;
    }

}
