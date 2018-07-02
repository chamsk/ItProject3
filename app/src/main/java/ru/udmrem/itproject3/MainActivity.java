package ru.udmrem.itproject3;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private int REQUEST_CODE_PERMISSION_READ_CONTACTS = 100;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //checkPermission();

        MainFragment fragment = new MainFragment();
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container,fragment);
        transaction.commit();


    }


    //block permission
//    public void checkPermission(){
//        int permissionStatus = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS);
//        Log.d("asd","asdg");
//        if (permissionStatus == PackageManager.PERMISSION_GRANTED) {
//
//
//            //readContacts();
//
//
//            Log.d("PERMISSION","granted");
//        } else {
//            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_CONTACTS},
//                    REQUEST_CODE_PERMISSION_READ_CONTACTS);
//
//        }
//    }
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        switch (requestCode) {
//            case 100:
//                if (grantResults.length > 0
//                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    // permission granted
//                    // presenter.readContacts();
//                } else {
//                    // permission denied
//                }
//                return;
//        }
//    }
}
