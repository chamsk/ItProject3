package ru.udmrem.itproject3.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ContactDao {

    // Добавление Contact в бд
    @Insert
    void insertAll(Contact... contacts);

    // Удаление Contact из бд
    @Delete
    void delete(Contact contact);

    // Получение всех Contact из бд
    @Query("SELECT * FROM contact")
    List<Contact> getAllPeople();

    // Получение всех Contacts из бд с условием
 //   @Query("SELECT * FROM contact WHERE favoriteColor LIKE :color")
 //   List<Contact> getAllPeopleWithFavoriteColor(String color);

}
