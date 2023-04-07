package com.iranartapp.horizontalnumberpicker;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {

    private final int spaceStart;
    private final int spaceEnd;

    public SpaceItemDecoration(int spaceStart, int spaceEnd) {
        this.spaceStart = spaceStart;
        this.spaceEnd = spaceEnd;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        // Add space before the first item
        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.left = spaceStart;
        }

        // Add space after the last item
        if (parent.getChildAdapterPosition(view) == parent.getAdapter().getItemCount() - 1) {
            outRect.right = spaceEnd;
        }
    }
}
