package com.example.bikram.learningtv;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

/**
 * Created by bikram on 2/13/18.
 */

public class ErrorFragment extends android.support.v17.leanback.app.ErrorFragment {
    private static final String TAG=ErrorFragment.class.getSimpleName();
    private static final boolean TRANSLUCENT=true;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG,"onCreate");
        super.onCreate(savedInstanceState);

        setTitle(getResources().getString(R.string.app_name));
        setErrorContent();
    }

    private void setErrorContent() {
        setImageDrawable(getActivity().getDrawable(R.drawable.lb_ic_sad_cloud));
        setMessage(getResources().getString(R.string.error_fragment_message));
        setDefaultBackground(TRANSLUCENT);

        setButtonText(getResources().getString(R.string.dismiss_error));
        setButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().remove(ErrorFragment.this).commit();
            }
        });
    }
}
