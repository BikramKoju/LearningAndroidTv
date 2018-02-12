package com.example.bikram.learningtv;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v17.leanback.app.BrowseFragment;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v17.leanback.widget.OnItemViewSelectedListener;
import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.Row;
import android.support.v17.leanback.widget.RowPresenter;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by bikram on 2/12/18.
 */

public class MainFragment extends BrowseFragment {
    private static final String TAG = MainFragment.class.getSimpleName();
    private ArrayObjectAdapter mRowsAdapter;
    private static final int GRID_ITEM_WIDTH = 300;
    private static final int GRID_ITEM_HEIGHT = 200;
    private static SimpleBackgroundManager simpleBackgroundManager=null;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onActivityCreated");
        super.onActivityCreated(savedInstanceState);
        setupUIElements();
        loadRows();
        setupEventListeners();
        simpleBackgroundManager=new SimpleBackgroundManager(getActivity());
    }

    private void setupEventListeners() {
        setOnItemViewSelectedListener(new ItemViewSelectedListener());
    }

    private void loadRows() {
        mRowsAdapter=new ArrayObjectAdapter(new ListRowPresenter());

        /*GridItemPresenter*/
        HeaderItem gridItemPresenterHeader= new HeaderItem(0,"GridItemPresenter");

        GridItemPresenter mGridPresenter=new GridItemPresenter();

        ArrayObjectAdapter gridRowAdapter = new ArrayObjectAdapter(mGridPresenter);
        gridRowAdapter.add("Item 1");
        gridRowAdapter.add("Item 2");
        gridRowAdapter.add("Item 3");
        mRowsAdapter.add(new ListRow(gridItemPresenterHeader,gridRowAdapter));

          /* CardPresenter */
        HeaderItem cardPresenterHeader = new HeaderItem(1, "CardPresenter");
        CardPresenter cardPresenter = new CardPresenter();
        ArrayObjectAdapter cardRowAdapter = new ArrayObjectAdapter(cardPresenter);

        for(int i=0; i<10; i++) {
            Movie movie = new Movie();
            movie.setCardImageUrl("http://heimkehrend.raindrop.jp/kl-hacker/wp-content/uploads/2014/08/DSC02580.jpg");
            movie.setTitle("title" + i);
            movie.setStudio("studio" + i);
            cardRowAdapter.add(movie);
        }

        mRowsAdapter.add(new ListRow(cardPresenterHeader, cardRowAdapter));

        /* Set */

        setAdapter(mRowsAdapter);


    }

    private void setupUIElements() {
        // setBadgeDrawable(getActivity().getResources().getDrawable(R.drawable.videos_by_google_banner));
        setTitle("Hello World");// Badge, when set, takes precedent over title

        setHeadersState(HEADERS_ENABLED);
        setHeadersTransitionOnBackEnabled(true);

        // set fastLane (or headers) background color
        setBrandColor(getResources().getColor(R.color.fastlane_background));
// set search icon color
        setSearchAffordanceColor(getResources().getColor(R.color.search_opaque));
    }

    private class GridItemPresenter extends Presenter {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent) {
            TextView view=new TextView(parent.getContext());
            view.setLayoutParams(new ViewGroup.LayoutParams(GRID_ITEM_WIDTH,GRID_ITEM_HEIGHT));
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
            view.setBackgroundColor(getResources().getColor(R.color.default_background));
            view.setTextColor(Color.WHITE);
            view.setGravity(Gravity.CENTER);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, Object item) {
            ((TextView) viewHolder.view).setText((String)item);

        }

        @Override
        public void onUnbindViewHolder(ViewHolder viewHolder) {

        }
    }

    private final class ItemViewSelectedListener implements OnItemViewSelectedListener {
        @Override
        public void onItemSelected(Presenter.ViewHolder itemViewHolder, Object item, RowPresenter.ViewHolder rowViewHolder, Row row) {
            // each time the item is selected, code inside here will be executed.
            if (item instanceof String) { // GridItemPresenter row
                simpleBackgroundManager.clearBackground();
            } else if (item instanceof Movie) { // CardPresenter row
                simpleBackgroundManager.updateBackground(getActivity().getDrawable(R.drawable.movie));
            }


        }
    }
}
