package freedoms.androidframework.module.login.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import freedoms.androidframework.R;
import freedoms.androidframework.base.FBaseActivity;
import freedoms.androidframework.module.login.iview.ILoginView;
import freedoms.androidframework.module.login.model.listener.ClearOnClickListener;
import freedoms.androidframework.module.login.model.listener.LoginOnClickListener;
import freedoms.androidframework.tools.hud.FHudLoading;
import freedoms.androidframework.tools.log.FLog;

/**
 * Created by freedoms on 2017/3/13.
 */

public class LoginActivity extends FBaseActivity implements ILoginView {

	@BindView(R.id.usernameET)
	EditText usernameET;

	@BindView(R.id.passwordET)
	EditText passwordET;

	@BindView(R.id.clearusernameBTN)
	Button clearusernameBTN;

	@BindView(R.id.clearpasswdBTN)
	Button clearpasswdBTN;

	@BindView(R.id.loginBTN)
	Button loginBTN;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.loginlayout);
		ButterKnife.bind(this);

		clearusernameBTN.setOnClickListener(new ClearOnClickListener(this));
		clearpasswdBTN.setOnClickListener(new ClearOnClickListener(this));
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
