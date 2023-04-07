package com.iranartapp.horizontalnumberpicker;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CenterScrollListener extends RecyclerView.OnScrollListener {

    private final LinearLayoutManager layoutManager;
    private final HorizontalRecyclerViewAdapter adapter;

    public CenterScrollListener(LinearLayoutManager layoutManager, HorizontalRecyclerViewAdapter adapter) {
        this.layoutManager = layoutManager;
        this.adapter = adapter;
    }

    @Override
    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        // Get the center position of the RecyclerView
        int centerPosition = layoutManager.findFirstVisibleItemPosition();
        centerPosition += layoutManager.findLastVisibleItemPosition();
        centerPosition /= 2;

        // Update the centered position in the adapter
        adapter.setLastCenteredPosition(centerPosition);
    }
}

