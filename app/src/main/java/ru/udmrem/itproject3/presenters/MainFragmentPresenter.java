package ru.udmrem.itproject3.presenters;

import android.content.Context;

import java.util.List;

import ru.udmrem.itproject3.data.Contact;
import ru.udmrem.itproject3.data.LoaderContacts;

public class MainFragmentPresenter {
    Context context;
    LoaderContacts loaderContacts;

    public MainFragmentPresenter(Context context) {
        this.context = context;
    }


    public void loadContacts(){
        loaderContacts = new LoaderContacts(context);
    }
    public void getContacts(){

    }


}
