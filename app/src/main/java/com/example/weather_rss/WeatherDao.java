package com.example.weather_rss;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WeatherDao {
    @Query("SELECT * FROM weather")
    List<Weather> getAll();

    @Query("SELECT * FROM weather WHERE city LIKE :index")
    List<Weather> findByCity(int index);

    @Insert
    void insert(Weather weather);

    @Delete
    void delete(Weather weather);
}
