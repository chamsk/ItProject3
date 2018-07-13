package ru.udmrem.itproject3.view;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import ru.udmrem.itproject3.ListAdapter;
import ru.udmrem.itproject3.R;
import ru.udmrem.itproject3.presenters.DetailFtagmentPresentor;


public class MainActivity extends AppCompatActivity implements ListAdapter.OnItemClick {

    DetailFtagmentPresentor presentor;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presentor = new DetailFtagmentPresentor(getApplicationContext(),getSupportFragmentManager());



        MainFragment fragment = new MainFragment();
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container,fragment);
        transaction.commit();
    }



    @Override
    public void itemClick(int position) {
        presentor.itemClick(position);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presentor = null;
    }
}
