package com.example.weather_rss;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Weather {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "city")
    public int city;

    @ColumnInfo(name = "weather")
    public String weather;

    @ColumnInfo(name = "humidity")
    public String humidity;

    @ColumnInfo(name = "min_temp")
    public String min_temp;

    @ColumnInfo(name = "max_temp")
    public String max_temp;

    @ColumnInfo(name = "data")
    public String date;
}
