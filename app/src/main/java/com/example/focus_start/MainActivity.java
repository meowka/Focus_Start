package com.example.focus_start;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.focus_start.API.APIClient;
import com.example.focus_start.API.APIService;
import com.example.focus_start.Adapter.Adapter;
import com.example.focus_start.POJO.APIResponse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    APIService apiService;
    Adapter adapter;
    APIResponse resource;
    Collection<APIResponse.Valute> data;
    RecyclerView recyclerView;
    List<APIResponse.Valute> list;
    Toolbar toolbar;
    ImageButton imageButton;
    Call<APIResponse> call;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        imageButton = findViewById(R.id.imageButton);
        recyclerView = findViewById(R.id.recyclerView);
        if (savedInstanceState == null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            apiService = APIClient.getClient().create(APIService.class);
            call = apiService.doGetResponse();
            list = new ArrayList<>();
            call.enqueue(new Callback<APIResponse>() {
                @Override
                public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {
                    resource = response.body();
                    data = resource.valute.values();
                    list.addAll(data);
                    adapter = new Adapter(MainActivity.this, list);
                    recyclerView.setAdapter(adapter);
                }
                @Override
                public void onFailure(Call<APIResponse> call, Throwable t) {
                    Toast.makeText(MainActivity.this, R.string.errorToast, Toast.LENGTH_SHORT).show();
                }
            });
        }else {
            list = (List<APIResponse.Valute>) savedInstanceState.getSerializable(getString(R.string.outStateData));
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            adapter = new Adapter(MainActivity.this, list);
            recyclerView.setAdapter(adapter);
        }

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Toast.makeText(MainActivity.this, R.string.reset, Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(getString(R.string.outStateData), (Serializable) list);
    }
}