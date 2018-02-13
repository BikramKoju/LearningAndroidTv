package com.example.bikram.learningtv;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v17.leanback.app.BrowseFragment;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v17.leanback.widget.OnItemViewClickedListener;
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
    //    private static SimpleBackgroundManager simpleBackgroundManager=null;
    private static PicassoBackgroundManager picassoBackgroundManager = null;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onActivityCreated");
        super.onActivityCreated(savedInstanceState);
        setupUIElements();
        loadRows();
        setupEventListeners();
//        simpleBackgroundManager=new SimpleBackgroundManager(getActivity());
        picassoBackgroundManager = new PicassoBackgroundManager(getActivity());

    }

    private void setupEventListeners() {
        setOnItemViewSelectedListener(new ItemViewSelectedListener());
        setOnItemViewClickedListener(new ItemViewClickedListener());

    }

    private void loadRows() {
        mRowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());

        /*GridItemPresenter*/
        HeaderItem gridItemPresenterHeader = new HeaderItem(0, "GridItemPresenter");

        GridItemPresenter mGridPresenter = new GridItemPresenter();

        ArrayObjectAdapter gridRowAdapter = new ArrayObjectAdapter(mGridPresenter);
       gridRowAdapter.add("ErrorFragment");
        gridRowAdapter.add("Item 1");
        gridRowAdapter.add("Item 2");
        gridRowAdapter.add("Item 3");
        mRowsAdapter.add(new ListRow(gridItemPresenterHeader, gridRowAdapter));

          /* CardPresenter */
        HeaderItem cardPresenterHeader = new HeaderItem(1, "CardPresenter");
        CardPresenter cardPresenter = new CardPresenter();
        ArrayObjectAdapter cardRowAdapter = new ArrayObjectAdapter(cardPresenter);

        for (int i = 0; i < 10; i++) {
            Movie movie = new Movie();
            if (i % 3 == 0) {
                movie.setCardImageUrl("http://heimkehrend.raindrop.jp/kl-hacker/wp-content/uploads/2014/08/DSC02580.jpg");
            } else if (i % 3 == 1) {
                movie.setCardImageUrl("http://heimkehrend.raindrop.jp/kl-hacker/wp-content/uploads/2014/08/DSC02630.jpg");
            } else {
                movie.setCardImageUrl("http://heimkehrend.raindrop.jp/kl-hacker/wp-content/uploads/2014/08/DSC02529.jpg");
            }
            movie.setTitle("title" + i);
            movie.setStudio("studio" + i);
            String description = "Lorem ipsum dolor sit amet, qui mundi vivendum cu. Mazim dicant possit te his. Quo solet dicant prodesset eu, pri deseruisse concludaturque ea, saepe maiorum sea et. Impetus discere sed at. Vim eu novum erant integre, te tale voluptatibus est. Facer labores te mel.\n" +
                    "\n" +
                    "Dictas denique qualisque mea id, cu mei verear fabellas. Mel no autem nusquam, viderer oblique te mei. At minimum corpora consulatu vim. Cibo nominavi vis no, in verterem vulputate eos, essent iriure cu vel. Ius ferri expetendis ad, omnes aeterno nominati id his, eum debitis lobortis comprehensam id.\n" +
                    "\n" +
                    "Illud dicit nostrud sit no. Eu quod nostro pro. Ut gubergren mnesarchum has, nostro detracto scriptorem et quo, no illud phaedrum recteque sea. Ad his summo probatus recusabo. Qui amet tale viris et, ei his quodsi torquatos adipiscing. Laudem malorum no eum, accusam mandamus sit ex, est ut tractatos dissentiet. Dictas feugiat usu et, an his cibo appareat placerat, eu quis dignissim qui.\n" +
                    "\n" +
                    "Euripidis neglegentur eu per, denique singulis vel cu, malis dolore ne duo. Cum no iracundia persecuti expetendis. Vim alii dolore malorum at, veniam perfecto salutandi cu nec, vix ad nonumes consulatu scripserit. At sit nonumy dolores aliquando, eu nam sumo legere. Eu maiorum adipisci torquatos his, vidit appareat eos no.\n" +
                    "\n" +
                    "Solet laboramus no quo, cu aperiam inermis vix. Eum animal graecis id, ne quodsi abhorreant sit. Tale persequeris te qui. Labitur invenire explicari in vix."
                    + "Lorem ipsum dolor sit amet, qui mundi vivendum cu. Mazim dicant possit te his. Quo solet dicant prodesset eu, pri deseruisse concludaturque ea, saepe maiorum sea et. Impetus discere sed at. Vim eu novum erant integre, te tale voluptatibus est. Facer labores te mel.\n" +
                    "\n" +
                    "Dictas denique qualisque mea id, cu mei verear fabellas. Mel no autem nusquam, viderer oblique te mei. At minimum corpora consulatu vim. Cibo nominavi vis no, in verterem vulputate eos, essent iriure cu vel. Ius ferri expetendis ad, omnes aeterno nominati id his, eum debitis lobortis comprehensam id.\n" +
                    "\n" +
                    "Illud dicit nostrud sit no. Eu quod nostro pro. Ut gubergren mnesarchum has, nostro detracto scriptorem et quo, no illud phaedrum recteque sea. Ad his summo probatus recusabo. Qui amet tale viris et, ei his quodsi torquatos adipiscing. Laudem malorum no eum, accusam mandamus sit ex, est ut tractatos dissentiet. Dictas feugiat usu et, an his cibo appareat placerat, eu quis dignissim qui.\n" +
                    "\n" +
                    "Euripidis neglegentur eu per, denique singulis vel cu, malis dolore ne duo. Cum no iracundia persecuti expetendis. Vim alii dolore malorum at, veniam perfecto salutandi cu nec, vix ad nonumes consulatu scripserit. At sit nonumy dolores aliquando, eu nam sumo legere. Eu maiorum adipisci torquatos his, vidit appareat eos no.\n" +
                    "\n" +
                    "Solet laboramus no quo, cu aperiam inermis vix. Eum animal graecis id, ne quodsi abhorreant sit. Tale persequeris te qui. Labitur invenire explicari in vix.";
            movie.setDescription(description);
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
            TextView view = new TextView(parent.getContext());
            view.setLayoutParams(new ViewGroup.LayoutParams(GRID_ITEM_WIDTH, GRID_ITEM_HEIGHT));
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
            view.setBackgroundColor(getResources().getColor(R.color.default_background));
            view.setTextColor(Color.WHITE);
            view.setGravity(Gravity.CENTER);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, Object item) {
            ((TextView) viewHolder.view).setText((String) item);

        }

        @Override
        public void onUnbindViewHolder(ViewHolder viewHolder) {

        }
    }

    private final class ItemViewSelectedListener implements OnItemViewSelectedListener {
        @Override
        public void onItemSelected(Presenter.ViewHolder itemViewHolder, Object item, RowPresenter.ViewHolder rowViewHolder, Row row) {
            // each time the item is selected, code inside here will be executed.
           /* if (item instanceof String) { // GridItemPresenter row
                simpleBackgroundManager.clearBackground();
            } else if (item instanceof Movie) { // CardPresenter row
                simpleBackgroundManager.updateBackground(getActivity().getDrawable(R.drawable.movie));
            }*/
            if (item instanceof String) {                    // GridItemPresenter
                picassoBackgroundManager.updateBackgroundWithDelay("http://heimkehrend.raindrop.jp/kl-hacker/wp-content/uploads/2014/10/RIMG0656.jpg");
            } else if (item instanceof Movie) {              // CardPresenter
                picassoBackgroundManager.updateBackgroundWithDelay(((Movie) item).getCardImageUrl());
            }


        }
    }

    private final class ItemViewClickedListener implements OnItemViewClickedListener {
        @Override
        public void onItemClicked(Presenter.ViewHolder itemViewHolder, Object item, RowPresenter.ViewHolder rowViewHolder, Row row) {
            // each time the item is clicked, code inside here will be executed.
            if (item instanceof Movie) {
                Movie movie = (Movie) item;
                Log.d(TAG, "Item: " + item.toString());
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                intent.putExtra(DetailsActivity.MOVIE, movie);

                getActivity().startActivity(intent);
            }else if (item instanceof String){
                if (item=="ErrorFragment"){
                    Intent intent=new Intent(getActivity(),ErrorActivity.class);
                    startActivity(intent);
                }
            }

        }
    }
}
