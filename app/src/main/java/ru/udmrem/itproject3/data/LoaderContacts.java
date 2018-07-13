package ru.udmrem.itproject3.data;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.util.Log;

import java.util.List;

import ru.udmrem.itproject3.App;
import ru.udmrem.itproject3.MVP;

public class LoaderContacts implements MVP.model{
    Context context;
    Contact contact;
    ContactDao dao;
    AppDataBase appDataBase;
    Cursor cursor;


    public LoaderContacts(Context context) {
        this.context = context;
    }

    @Override
    public void loadLocalDB(){
        appDataBase = App.getInstance().getDataBase();
        dao = appDataBase.getPersonDao();
        //Теперь мы можем работать с Contact объектами. Но эти операции должны выполняться не в UI потоке. Иначе мы получим Exception.
        ContentResolver cr = context.getContentResolver();
        cursor = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        contact = new Contact();
        int id = 0;
            try {
                if (cursor.moveToFirst()) {
                    do {
                        contact.setId(id);
                        id++;
                        String n = cursor.getString(cursor.getColumnIndex(ContactsContract.Data.DISPLAY_NAME));
                        Log.d("Stringa","name " + n);
                        contact.setName(n);
                        String p = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        contact.setPhone(p);
                        Log.d("Stringa","phone " + p);
                        String e = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA));
                        Log.d("Stringa","mail " + e);
                        contact.setEmail(e);
                        dao.insert(contact);

                    }
                    while (cursor.moveToNext());
                }
            } catch (Exception e) {
            } finally {
                cursor.close();
            }

    }

    @Override
    public List<Contact> getContacts() {
        return dao.getAllPeople();
    }
    @Override
    public Contact getDetailContact(int position){
        return dao.getContactById(position);
    }
}
