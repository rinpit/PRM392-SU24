package com.example.app_demo;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecycleLayoutActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AnimalAdapter animalAdapter;
    private List<Animal> animalList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycle_layout);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main
        ), (v, insets) -> {
            Insets systemBars =
                    insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top,
                    systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        animalList = new ArrayList<>();

        animalList.add(new Animal(1, "Lion", "The lion is a species in the family Felidae."));
        animalList.add(new Animal(2, "Tiger", "The tiger is the largest living cat species."));
        animalList.add(new Animal(4, "Elephant", "Elephants are the largest existing land animals."));
        animalList.add(new Animal(5, "Elephant", "Elephants are the largest existing land animals."));
        animalList.add(new Animal(6, "Elephant", "Elephants are the largest existing land animals."));
        animalList.add(new Animal(7, "Elephant", "Elephants are the largest existing land animals."));
        animalList.add(new Animal(8, "Elephant", "Elephants are the largest existing land animals."));
        animalList.add(new Animal(9, "Elephant", "Elephants are the largest existing land animals."));
        animalList.add(new Animal(10, "Elephant", "Elephants are the largest existing land animals."));


        animalAdapter = new AnimalAdapter(this, animalList);
        recyclerView.setAdapter(animalAdapter);


    }
}
