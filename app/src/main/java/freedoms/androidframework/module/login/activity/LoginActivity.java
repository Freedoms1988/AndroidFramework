package freedoms.androidframework.module.login.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import freedoms.androidframework.R;
import freedoms.androidframework.base.FBaseActivity;
import freedoms.androidframework.module.login.model.listener.ClearOnClickListener;
import freedoms.androidframework.module.login.model.listener.LoginOnClickListener;
import freedoms.androidframework.module.login.iview.ILoginView;
import freedoms.androidframework.tools.hud.FHudLoading;
import freedoms.androidframework.tools.log.FLog;

/**
 * Created by freedoms on 2017/3/13.
 */

public class LoginActivity extends FBaseActivity implements ILoginView{
    private EditText usernameET;
    private EditText passwordET;
    private Button clearUsernameBTN;
    private Button clearPasswordBTN;
    private Button loginBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginlayout);

        usernameET=(EditText) findViewById(R.id.usernameET);
        passwordET=(EditText) findViewById(R.id.passwordET);

        clearUsernameBTN=(Button)findViewById(R.id.clearusernameBTN);
        clearUsernameBTN.setOnClickListener(new ClearOnClickListener(this));

        clearPasswordBTN=(Button)findViewById(R.id.clearpasswdBTN);
        clearPasswordBTN.setOnClickListener(new ClearOnClickListener(this));

        loginBTN=(Button) findViewById(R.id.loginBtn);
        loginBTN.setOnClickListener(new LoginOnClickListener(this));


    }

    @Override
    protected void onPause() {
        super.onPause();
        dismissHudLoading();
    }

    @Override
    public String getUsername() {
        return usernameET.getText().toString();
    }

    @Override
    public String getPassword() {
        return passwordET.getText().toString();
    }

    @Override
    public void loginSuccess() {
        FLog.debug("模拟登录成功");
    }

    @Override
    public void loginFailure() {
        FLog.debug("模拟登录失败");
    }

    @Override
    public void clearUsername() {
        usernameET.setText("");
        FLog.debug("用户名删除成功");
    }

    @Override
    public void clearPassword() {
        passwordET.setText("");
        FLog.debug("密码删除成功");
    }

    @Override
    public void showHudLoading() {
        FHudLoading.getInstance().showLoading(LoginActivity.this);
    }

    @Override
    public void dismissHudLoading() {
        FHudLoading.getInstance().dismissLoading();
    }
}
