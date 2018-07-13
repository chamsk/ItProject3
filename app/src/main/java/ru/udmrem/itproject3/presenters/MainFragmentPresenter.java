package ru.udmrem.itproject3.presenters;

import android.content.Context;

import java.util.List;

import ru.udmrem.itproject3.MVP;
import ru.udmrem.itproject3.data.Contact;
import ru.udmrem.itproject3.data.LoaderContacts;

public class MainFragmentPresenter implements MVP.mainFragmentPresenter{
    Context context;
    LoaderContacts loaderContacts;

    public MainFragmentPresenter(Context context) {
        this.context = context;
    }


    @Override
    public void loadContacts(){
        loaderContacts = new LoaderContacts(context);
        loaderContacts.loadLocalDB();
    }
    @Override
    public List<Contact> getContacts(){
        return loaderContacts.getContacts();
    }


}
