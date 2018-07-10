package ru.udmrem.itproject3;

import android.app.Application;
import android.arch.persistence.room.Room;

import ru.udmrem.itproject3.data.AppDataBase;

public class App extends Application{
    private AppDataBase dataBase;
    public static App app;
    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        dataBase = Room.databaseBuilder(this,AppDataBase.class,"db").allowMainThreadQueries()       //убрать разрешение на работу в основном потоке
                .build();

    }
    public static App getInstance(){
        return app;
    }
    public AppDataBase getDataBase(){
        return dataBase;
    }
}
