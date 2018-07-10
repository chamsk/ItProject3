package ru.udmrem.itproject3.data;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Contact.class /*, AnotherEntityType.class, AThirdEntityType.class */}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract ContactDao getPersonDao();
}