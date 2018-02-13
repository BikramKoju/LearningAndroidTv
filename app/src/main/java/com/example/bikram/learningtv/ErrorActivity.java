package com.example.bikram.learningtv;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v17.leanback.app.ErrorFragment;

/**
 * Created by bikram on 2/13/18.
 */

public class ErrorActivity extends Activity {
    private static final String TAG=ErrorActivity.class.getSimpleName();
    private ErrorFragment mErrorFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testError();
    }

    private void testError() {
        mErrorFragment=new ErrorFragment();
        getFragmentManager().beginTransaction().add(R.id.main_browse_fragment,mErrorFragment).commit();
    }
}
