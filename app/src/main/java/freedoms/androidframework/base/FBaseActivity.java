package freedoms.androidframework.base;

import android.app.Activity;
import android.os.Bundle;

import org.xutils.x;

/**
 * Created by freedoms on 16/1/29.
 */
public class FBaseActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
    }
}
