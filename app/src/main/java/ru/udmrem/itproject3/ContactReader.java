package ru.udmrem.itproject3;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;

import java.util.ArrayList;

import ru.udmrem.itproject3.data.Contact;

public class ContactReader {
    Contact contact;

    ArrayList<String> names = new ArrayList<>();
    ArrayList<String> phones = new ArrayList<>();
    ArrayList<String> emails = new ArrayList<>();

   Activity main;

    public ContactReader(Activity main) {
        this.main = main;
    }

    public void readContacts(){
        ContentResolver cr = main.getContentResolver();
        Cursor cursor = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    String n = cursor.getString(cursor.getColumnIndex(ContactsContract.Data.DISPLAY_NAME));
                    names.add(n);
                    String p = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    phones.add(p);
                    String e = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Email.ADDRESS));
                    emails.add(e);
                }
                while (cursor.moveToNext());
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            cursor.close();
        }
//        ReaderContact readerContact = new ReaderContact();
//        readerContact.execute();

    }
    public ArrayList<String> getNames(){
        return names;
    }
    public ArrayList<String> getPhones(){
        return phones;
    }
    public ArrayList<String> getEmails(){
        return emails;
    }

//
//    public class ReaderContact extends AsyncTask<Void,String,Void>{
//        @Override
//        protected void onProgressUpdate(String... values) {
//           Log.d("ASYNC",values[0]);
//            super.onProgressUpdate(values);
//        }
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            ContentResolver cr = presenter.getResolver();
//            Cursor cursor = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
//            try {
//                if (cursor.moveToFirst()) {
//                    do {
//                        String n = cursor.getString(cursor.getColumnIndex(ContactsContract.Data.DISPLAY_NAME));
//                        names.add(n);
//                        String p = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
//                        phones.add(p);
//                        String e = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Email.ADDRESS));
//                        emails.add(e);
//                        publishProgress(n);
//                    }
//                    while (cursor.moveToNext());
//                }
//            }
//            catch (Exception e){
//            }
//            finally {
//                cursor.close();
//            }
//            return null;
//        }
//    }
}


