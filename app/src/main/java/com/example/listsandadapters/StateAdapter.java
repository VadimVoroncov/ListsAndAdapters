package com.example.listsandadapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StateAdapter  extends ArrayAdapter<State> {

    private LayoutInflater inflater;
    private List<State> states;
    private int layout;

    public StateAdapter(Context context, List<State> states, int resource) {
        super(context, resource, states);
        this.states = states;
        this.inflater = LayoutInflater.from(context);
        this.layout = resource;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(this.layout, parent, false);
        State state = states.get(position);
        TextView textViewDesc = view.findViewById(R.id.description);
        ImageView carView = view.findViewById(R.id.car);
        textViewDesc.setText(state.getDescription());
        carView.setImageResource(state.getCarResource());

        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(this.layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        State car = states.get(position);//final

        viewHolder.nameView.setText(car.getName());
        viewHolder.countView.setText(car.getKolvoCar() + " " );
        viewHolder.descriptionView.setText(car.getDescription());
        viewHolder.photo.setImageResource(car.getCarResource());
        viewHolder.removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = car.getKolvoCar() - 1;
                if (count < 0) count = 0;
                car.setKolvoCar(count);
                viewHolder.countView.setText(count + " " );
            }
        });
        viewHolder.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = car.getKolvoCar() + 1;
                car.setKolvoCar(count);
                viewHolder.countView.setText(count + " " );
            }
        });

        return convertView;
    }
    private class ViewHolder {
        Button addButton, removeButton;
        TextView nameView, countView, descriptionView;
         ImageView photo;

        ViewHolder(View view) {
            addButton = view.findViewById(R.id.btnPlus);
            removeButton = view.findViewById(R.id.btnMinus);
            nameView = view.findViewById(R.id.name);
            countView = view.findViewById(R.id.Kolvo);
            descriptionView = view.findViewById(R.id.description);
            photo = view.findViewById(R.id.car);
        }
    }
}

