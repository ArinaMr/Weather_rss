package com.example.weather_rss;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Weather> {

    private ArrayList<Weather> dataSet;
    Context mContext;

    private static class ViewHolder {
        TextView txtSky;
        TextView txtHumidity;
        TextView txtData;
        TextView txtNight;
        TextView txtDay;
    }

    public CustomAdapter(ArrayList<Weather> data, Context context) {
        super(context, R.layout.row_item, data);
        this.dataSet = data;
        this.mContext=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Weather dataModel = getItem(position);
        ViewHolder viewHolder;

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item, parent, false);
            viewHolder.txtSky = (TextView) convertView.findViewById(R.id.weather);
            viewHolder.txtHumidity = (TextView) convertView.findViewById(R.id.humidity);
            viewHolder.txtData = (TextView) convertView.findViewById(R.id.date);
            viewHolder.txtNight= (TextView) convertView.findViewById(R.id.night);
            viewHolder.txtDay = (TextView) convertView.findViewById(R.id.day);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        viewHolder.txtHumidity.setText("Влажность: " + dataModel.humidity);
        viewHolder.txtData.setText(dataModel.date);
        viewHolder.txtNight.setText("Ночью: " + dataModel.min_temp);
        viewHolder.txtDay.setText("Днём: " + dataModel.max_temp);

        return convertView;
    }
}
