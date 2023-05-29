package com.example.weather_rss;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.ArrayList;

public class WeatherXmlParser {
    private ArrayList<WeatherReply> weathers;

    public WeatherXmlParser(){
        weathers = new ArrayList<>();
    }

    public ArrayList<WeatherReply> getWeathers(){
        return weathers;
    }

    public boolean parse(String xmlData){
        boolean status = true;
        WeatherReply currentWeather = null;
        boolean inEntry = false;
        String textValue = "";

        try{
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            int n = 1;

            xpp.setInput(new StringReader(xmlData));
            int eventType = xpp.getEventType();
            while(eventType != XmlPullParser.END_DOCUMENT){

                String tagName = xpp.getName();
                switch (eventType){
                    case XmlPullParser.START_TAG:
                        if("item".equalsIgnoreCase(tagName)){
                            inEntry = true;
                            currentWeather = new WeatherReply();
                        }
                        break;
                    case XmlPullParser.TEXT:
                        textValue = xpp.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        if(inEntry){
                            if("item".equalsIgnoreCase(tagName)){
                                weathers.add(currentWeather);
                                inEntry = false;
                            } else if("title".equalsIgnoreCase(tagName)){
                                currentWeather.setTitle(textValue);
                            } else if("description".equalsIgnoreCase(tagName)){
                                currentWeather.setDescription(textValue);
                            }
                        }
                        break;
                    default:
                }
                eventType = xpp.next();
            }
        }
        catch (Exception e){
            status = false;
            e.printStackTrace();
        }
        return  status;
    }
}
