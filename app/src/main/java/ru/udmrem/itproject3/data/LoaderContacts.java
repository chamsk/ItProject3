package ru.udmrem.itproject3.data;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;

import ru.udmrem.itproject3.App;

public class LoaderContacts {
    Context context;
    Contact contact;
    ContactDao dao;
    AppDataBase appDataBase;
    Cursor cursor;

    public LoaderContacts(Context context) {
        this.context = context;
    }

    public void load(){
        appDataBase = App.getInstance().getDataBase();
        dao = appDataBase.getPersonDao();
        //Теперь мы можем работать с Employee объектами. Но эти операции должны выполняться не в UI потоке. Иначе мы получим Exception.
        ContentResolver cr = context.getContentResolver();
        cursor = cr.query(ContactsContract.Contacts.CONTENT_URI, PROJECTION, null, null, null);

    }
}
