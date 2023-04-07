package com.iranartapp.horizontalnumberpicker;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private HorizontalRecyclerViewAdapter adapter;
    private TextView textViewMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewMain = findViewById(R.id.textViewMain);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);

        // Create a list of data for the adapter
        List<YourModel> dataList = new ArrayList<>();
        for (int i = 15; i <= 35; i++) {
            dataList.add(new YourModel(i));
        }
        // Add your data to the list here

        // Create and set the adapter
        adapter = new HorizontalRecyclerViewAdapter(this, dataList, textViewMain);
        recyclerView.setAdapter(adapter);
        int spaceBefore = 450;
        int spaceAfter = 450;
        recyclerView.addItemDecoration(new SpaceItemDecoration(spaceBefore, spaceAfter));

        // Create an instance of CenterScrollListener and attach it to your RecyclerView
        CenterScrollListener centerScrollListener = new CenterScrollListener(layoutManager, adapter);
        recyclerView.addOnScrollListener(centerScrollListener);

        // Calculate the center position based on the screen width
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;
        int centerPosition = screenWidth / 2;

// Set an OnScrollListener to update the center position
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                // Check if scrolling has stopped
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    // Find the center item after scrolling stops
                    View centerView = snapHelper.findSnapView(layoutManager);
                    if (centerView != null) {
                        // Get the position of the center item
                        int centerPosition = layoutManager.getPosition(centerView);
                        // Update the adapter with the new center position
                        adapter.setLastCenteredPosition(centerPosition);
                    }
                }
            }
        });

    }
}
