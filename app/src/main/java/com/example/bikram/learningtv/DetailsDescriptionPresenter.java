package com.example.bikram.learningtv;

import android.support.v17.leanback.widget.AbstractDetailsDescriptionPresenter;


/**
 * Created by bikram on 2/12/18.
 */

public class DetailsDescriptionPresenter extends AbstractDetailsDescriptionPresenter {
    @Override
    protected void onBindDescription(ViewHolder vh, Object item) {
        Movie movie = (Movie) item;

        if (movie != null) {
            vh.getTitle().setText(movie.getTitle());
            vh.getSubtitle().setText(movie.getStudio());
            vh.getBody().setText(movie.getDescription());
        }
    }
}
