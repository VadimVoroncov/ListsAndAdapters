package com.example.listsandadapters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int quantity = 0;
    ArrayList<State> states = new ArrayList<State>();
    ListView carList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // начальная инициализация списка
        setInitialData();
        // получаем элемент ListView
        carList = findViewById(R.id.carList);
        // создаем адаптер
        StateAdapter stateAdapter = new StateAdapter(this, states, R.layout.list_item);

        // устанавливаем адаптер
        carList.setAdapter(stateAdapter);

        // слушатель выбора в списке
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                // получаем выбранный пункт
                State selectedState = (State) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Был выбран пункт " + selectedState.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        };

    }
    private void setInitialData(){
        states.add(new State ("Audi", "Audi A6", R.drawable.foto1,1));
        states.add(new State ("Audi", "Audi Q8", R.drawable.foto2,1 ));
        states.add(new State ("Ford", "Ford Shel by GT350", R.drawable.foto3,1  ));
        states.add(new State ("Jaguar", "Jaguar F type R", R.drawable.foto4,1 ));
        states.add(new State ("Mclaren", "Mercedes", R.drawable.foto5,1 ));
        states.add(new State ("Pagani", "Pagani Zonda F", R.drawable.foto6,1 ));
    }
}