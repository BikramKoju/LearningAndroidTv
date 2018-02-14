package com.example.bikram.learningtv;

import android.support.v17.leanback.widget.AbstractDetailsDescriptionPresenter;


/**
 * Created by bikram on 2/14/18.
 */

public class DescriptionPresenter extends AbstractDetailsDescriptionPresenter {

    private static final String TAG = DescriptionPresenter.class.getSimpleName();

    @Override
    protected void onBindDescription(ViewHolder viewHolder, Object item) {
        viewHolder.getTitle().setText(((Movie) item).getTitle());
        viewHolder.getSubtitle().setText(((Movie) item).getStudio());
    }
}