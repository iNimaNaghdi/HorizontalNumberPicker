package com.iranartapp.horizontalnumberpicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HorizontalRecyclerViewAdapter extends RecyclerView.Adapter<HorizontalRecyclerViewAdapter.ViewHolder> {

    private final Context context;
    private final List<YourModel> dataList;
    private final TextView textViewMain;
    private int centerPosition;

    public HorizontalRecyclerViewAdapter(Context context, List<YourModel> dataList, TextView textViewMain) {
        this.context = context;
        this.dataList = dataList;
        this.centerPosition = 0;
        this.textViewMain = textViewMain;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_horizontal_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        YourModel item = dataList.get(position);

        // Set the item name to the view holder
        holder.textView.setText(String.valueOf(item.getTemp()));

        // Update the UI of the item based on whether it is centered or not
        int centerOffset = Math.abs(position - centerPosition);
        if (centerOffset == 0) {
            // Update UI for centered item
            // Example: Change the background color or apply any other visual indicator
            holder.textView.setTextSize(50);
            textViewMain.setText(String.valueOf(item.getTemp()));
        } else {
            // Update UI for non-centered item
            holder.textView.setTextSize(30);
        }

        // Set other data to the views in the item
        // ...
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void setLastCenteredPosition(int lastCenteredPosition) {
        this.centerPosition = lastCenteredPosition;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }

    }

}

