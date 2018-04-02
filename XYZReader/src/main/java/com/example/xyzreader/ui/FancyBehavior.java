package com.example.xyzreader.ui;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.xyzreader.R;

public class FancyBehavior extends CoordinatorLayout.Behavior<DrawInsetsFrameLayout> {

    public FancyBehavior() {
    }

    public FancyBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, DrawInsetsFrameLayout child, View directTargetChild, View target, int nestedScrollAxes) {
        return true;
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, final DrawInsetsFrameLayout child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);

        Log.d("onNestedScroll", "true");

        FloatingActionButton fab = (FloatingActionButton) child.findViewById(R.id.share_fab);

        if (dyConsumed < 0) {
            // User scrolled up -> hide the FAB
            animateFab(fab, View.INVISIBLE);
        } else if (dyConsumed > 0) {
            // User scrolled down -> show the FAB
            animateFab(fab, View.VISIBLE);
        }

    }

    static public void animateFab(FloatingActionButton fab, int visibility) {
        // ignore visibility passed in, and just make fab visible regardless
        if (fab.getVisibility() != View.VISIBLE) {
            fab.show();
        }
    }
}
