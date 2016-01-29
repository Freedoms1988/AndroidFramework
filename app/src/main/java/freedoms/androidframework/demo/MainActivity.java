package freedoms.androidframework.demo;

import android.os.Bundle;

import freedoms.androidframework.base.FBaseActivity;
import freedoms.androidframework.R;

/**
 * Created by freedoms on 16/1/29.
 */
public class MainActivity extends FBaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
