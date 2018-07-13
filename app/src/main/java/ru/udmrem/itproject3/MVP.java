package ru.udmrem.itproject3;

import android.content.Context;

import java.util.List;

import ru.udmrem.itproject3.data.Contact;

public interface MVP {
    interface model{
        public void loadLocalDB();
        public List<Contact> getContacts();
        public Contact getDetailContact(int position);
    }
    interface detailPreseneter{
        public void itemClick(int position);
    }
    interface mainFragmentPresenter{
        public List<Contact> getContacts();
        public void loadContacts();
    }
    interface view{

    }
}
