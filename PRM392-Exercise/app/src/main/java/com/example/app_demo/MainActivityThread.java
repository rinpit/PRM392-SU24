package com.example.app_demo;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.app_demo.THREAD.ImageDownloader;

public class MainActivityThread extends AppCompatActivity {
    private ImageView imageView;
    private Button downloadButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_thread);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        imageView = findViewById(R.id.imageView);
        downloadButton = findViewById(R.id.downloadButton);
        downloadButton.setOnClickListener(new
                                                  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imageUrl =
                        "https://www.planetware.com/wpimages/2020/02/france-inpictures-beautiful-places-to-photograph-eiffel-tower.jpg";
                new ImageDownloader(imageView).downloadImage(imageUrl);
            }
        });
    }
}
