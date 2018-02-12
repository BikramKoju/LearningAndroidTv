package com.example.bikram.learningtv;
import android.support.v17.leanback.widget.FullWidthDetailsOverviewRowPresenter;
import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.RowPresenter;

/**
 * Created by bikram on 2/12/18.
 */

class CustomFullWidthDetailsOverviewRowPresenter extends FullWidthDetailsOverviewRowPresenter{
    private static final String TAG = CustomFullWidthDetailsOverviewRowPresenter.class.getSimpleName();

    public CustomFullWidthDetailsOverviewRowPresenter(Presenter detailsPresenter) {
        super(detailsPresenter);
    }

    @Override
    protected void onBindRowViewHolder(RowPresenter.ViewHolder holder, Object item) {
        super.onBindRowViewHolder(holder, item);
        this.setState((ViewHolder)holder,FullWidthDetailsOverviewRowPresenter.STATE_SMALL);
    }
}
