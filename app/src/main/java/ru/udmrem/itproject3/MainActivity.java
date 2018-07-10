package ru.udmrem.itproject3;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends AppCompatActivity implements ListAdapter.OnItemClick{


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        MainFragment fragment = new MainFragment();
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container,fragment);
        transaction.commit();


    }

    void showDetail(int position){
        Bundle bundle = new Bundle();
        bundle.putInt("position",position);
        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container,detailFragment).addToBackStack(null);
        transaction.commit();
    }


    @Override
    public void itemClick(int position) {
        Log.d("Activity","Onclick "+ position);
        showDetail(position);
    }
}
