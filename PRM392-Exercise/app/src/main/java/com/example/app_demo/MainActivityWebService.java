package com.example.app_demo;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_demo.WEB_SERVICE.AddPostActivity;
import com.example.app_demo.WEB_SERVICE.ApiClient;
import com.example.app_demo.WEB_SERVICE.ApiService;
import com.example.app_demo.WEB_SERVICE.Post;
import com.example.app_demo.WEB_SERVICE.PostAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityWebService extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PostAdapter postAdapter;
    Button button;
    private ApiService apiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_web_service);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        recyclerView = findViewById(R.id.recyclerView);
        button = findViewById(R.id.button1);
        apiService = ApiClient.getApiService();
        recyclerView.setLayoutManager(new
                LinearLayoutManager(this));
        button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivityWebService.this,
                    AddPostActivity.class);
            startActivity(intent);
        });
        fetchPosts();
    }
    private void fetchPosts() {
        apiService.getPosts().enqueue(new Callback<List<Post>>()
        {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    postAdapter = new
                            PostAdapter(MainActivityWebService.this, response.body(), new
                            PostAdapter.OnItemClickListener() {
                                @Override
                                public void onEditClick(Post post) {
                                    // Handle edit post
                                }
                                @Override
                                public void onDeleteClick(Post post) {
                                    // Handle delete post
                                }
                            });
                    recyclerView.setAdapter(postAdapter);
                }
            }
            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(MainActivityWebService.this, "Failed to fetch posts", Toast.LENGTH_SHORT).show();
            }
        });
    }

}

