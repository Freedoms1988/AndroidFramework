package freedoms.androidframework;

import android.app.Application;

import org.xutils.x;

/**
 * Created by freedoms on 16/1/29.
 */
public class FApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

        x.Ext.init(this);
    }
}
