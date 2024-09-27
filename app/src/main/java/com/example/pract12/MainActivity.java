package com.example.pract12;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<State> states = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setInitialData();

        RecyclerView recyclerView = findViewById(R.id.list);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerAddapter adapter = new RecyclerAddapter(this, states);
        recyclerView.setAdapter(adapter);
    }

    private void setInitialData() {
        states.add(new State("Бразилия", "Бразилиа", R.drawable.brazilia));
        states.add(new State("Аргентина", "Буэнос-Айрес", R.drawable.argentina));
        states.add(new State("Россия", "Москва", R.drawable.russia));
    }
}
