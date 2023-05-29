package com.example.weather_rss;

public class WeatherData {
    String date;
    String sky;
    String max_Temperature;
    String min_Temperature;
    String wind_Direction;
    String wind_Speed;
    String visibility;
    String pressure;
    String humidity;
    String uv_Risk;
    String pollution;
    String sunrise;
    String sunset;

    public WeatherData(WeatherReply rep) {
        String[] title_date = rep.getTitle().split(",");
        String[] title_sky = title_date[0].split(":");
        switch (rep.getId()){
            case 1:
                date = Utility.getToday();
                break;
            case 2:
                date = Utility.getTomorrow();
                break;
            case 3:
                date = Utility.getDayAfterTomorrow();
                break;
        }
        sky = title_sky[1];
        String[] desc_date = rep.getDescription().split(",");
        for (int i = 0; i < desc_date.length; i++) {
            if(i == 0){
                String[] max_t = desc_date[i].split(" ");
                max_Temperature = max_t[2].replaceAll("[^a-zA-Z0-9° ]+", "").trim();
            }
            if(i == 1){
                String[] min_t = desc_date[i].split(" ");
                min_Temperature = min_t[3].replaceAll("[^a-zA-Z0-9° ]+", "").trim();
            }
            if(i == 2){
                String[] data = desc_date[i].split(":");
                wind_Direction = data[1];
            }
            if(i == 3){
                String[] data = desc_date[i].split(":");
                wind_Speed = data[1];
            }
            if(i == 4){
                String[] data = desc_date[i].split(":");
                visibility = data[1];
            }
            if(i == 5){
                String[] data = desc_date[i].split(":");
                pressure = data[1];
            }
            if(i == 6){
                String[] data = desc_date[i].split(":");
                humidity = data[1];
            }
            if(i == 7){
                String[] data = desc_date[i].split(":");
                uv_Risk = data[1];
            }
            if(i == 8){
                String[] data = desc_date[i].split(":");
                pollution = data[1];
            }
            if(i == 9){
                String[] data = desc_date[i].split(":");
                sunrise = data[1];
            }if(i == 10) {
                String[] data = desc_date[i].split(":");
                sunset = data[1];
            }
        }
    }

    public WeatherData(String title, String desc) {
        String[] title_date = title.split(",");
        String[] title_sky = title_date[0].split(":");
        date = title_sky[0];
        sky = title_sky[1];
        String[] desc_date = desc.split(",");
        for (int i = 0; i < desc_date.length; i++) {
            if(i == 0){
                String[] max_t = desc_date[i].split(" ");
                max_Temperature = max_t[1];
            }
            if(i == 1){
                String[] min_t = desc_date[i].split(" ");
                min_Temperature = min_t[1];
            }
            if(i == 2){
                String[] data = desc_date[i].split(":");
                wind_Direction = data[1];
            }
            if(i == 3){
                String[] data = desc_date[i].split(":");
                wind_Speed = data[1];
            }
            if(i == 4){
                String[] data = desc_date[i].split(":");
                visibility = data[1];
            }
            if(i == 5){
                String[] data = desc_date[i].split(":");
                pressure = data[1];
            }
            if(i == 6){
                String[] data = desc_date[i].split(":");
                humidity = data[1];
            }
            if(i == 7){
                String[] data = desc_date[i].split(":");
                uv_Risk = data[1];
            }
            if(i == 8){
                String[] data = desc_date[i].split(":");
                pollution = data[1];
            }
            if(i == 9){
                String[] data = desc_date[i].split(":");
                sunrise = data[1];
            }if(i == 10) {
                String[] data = desc_date[i].split(":");
                sunset = data[1];
            }
        }
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSky() {
        return sky;
    }

    public void setSky(String sky) {
        this.sky = sky;
    }

    public String getMax_Temperature() {
        return max_Temperature;
    }

    public void setMax_Temperature(String max_Temperature) {
        this.max_Temperature = max_Temperature;
    }

    public String getMin_Temperature() {
        return min_Temperature;
    }

    public void setMin_Temperature(String min_Temperature) {
        this.min_Temperature = min_Temperature;
    }

    public String getWind_Direction() {
        return wind_Direction;
    }

    public void setWind_Direction(String wind_Direction) {
        this.wind_Direction = wind_Direction;
    }

    public String getWind_Speed() {
        return wind_Speed;
    }

    public void setWind_Speed(String wind_Speed) {
        this.wind_Speed = wind_Speed;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getUv_Risk() {
        return uv_Risk;
    }

    public void setUv_Risk(String uv_Risk) {
        this.uv_Risk = uv_Risk;
    }

    public String getPollution() {
        return pollution;
    }

    public void setPollution(String pollution) {
        this.pollution = pollution;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public Weather getWeather()
    {
        Weather w = new Weather();
        w.weather = sky;
        w.humidity = humidity;
        w.min_temp = min_Temperature;
        w.max_temp = max_Temperature;
        w.date = date;
        return w;
    }
}
