package freedoms.mymvpframework.module.login.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import freedoms.mymvpframework.R;
import freedoms.mymvpframework.base.BaseActivity;
import freedoms.mymvpframework.module.login.model.listener.ClearOnClickListener;
import freedoms.mymvpframework.module.login.model.listener.LoginOnClickListener;
import freedoms.mymvpframework.module.login.presenter.LoginPresenter;
import freedoms.mymvpframework.module.login.view.ILoginView;

/**
 * Created by freedoms on 2017/3/13.
 */

public class LoginActivity extends BaseActivity implements ILoginView{
    private EditText usernameET;
    private EditText passwordET;
    private Button clearUsernameBTN;
    private Button clearPasswordBTN;
    private Button loginBTN;
    private LoginPresenter loginPresenter;

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
    public String getUsername() {
        return usernameET.getText().toString();
    }

    @Override
    public String getPassword() {
        return passwordET.getText().toString();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(LoginActivity.this, "模拟登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFailure() {
        Toast.makeText(LoginActivity.this,"模拟登录失败",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearUsername() {
        usernameET.setText("");
        System.out.println("用户名删除成功");
    }

    @Override
    public void clearPassword() {
        passwordET.setText("");
        System.out.println("密码删除成功");
    }
}
