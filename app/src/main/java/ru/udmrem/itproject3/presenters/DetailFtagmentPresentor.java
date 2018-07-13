package ru.udmrem.itproject3.presenters;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import ru.udmrem.itproject3.MVP;
import ru.udmrem.itproject3.R;
import ru.udmrem.itproject3.data.Contact;
import ru.udmrem.itproject3.data.LoaderContacts;
import ru.udmrem.itproject3.view.DetailFragment;

public class DetailFtagmentPresentor implements MVP.detailPreseneter{
    LoaderContacts loaderContacts;
    Context context;
    FragmentManager fragmentManager;
    Contact contact;

    public DetailFtagmentPresentor(Context context,FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
        this.context = context;
        loaderContacts = new LoaderContacts(context);
        loaderContacts.loadLocalDB();
    }

    void showDetail(Contact contact){
        Bundle bundle = new Bundle();
        bundle.putString("name",contact.getName());
        bundle.putString("phone",contact.getPhone());
        bundle.putString("email",contact.getEmail());
        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setArguments(bundle);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container,detailFragment).addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void itemClick(int position){
       contact = loaderContacts.getDetailContact(position);
       showDetail(contact);
    }
}

