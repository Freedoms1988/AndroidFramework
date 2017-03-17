package freedoms.androidframework.module.demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import java.io.IOException;

import freedoms.androidframework.R;
import freedoms.androidframework.tools.fokhttp.FOkHttpClient;
import freedoms.androidframework.tools.fokhttp.FRequestCallBack;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by freedoms on 2017/3/16.
 */

public class DemoActivity extends Activity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.demolayout);

		findViewById(R.id.getBTN).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				FOkHttpClient.getInstance().getWithJSON("http://www.baidu.com", new FRequestCallBack() {
					@Override
					public void onFailure(Call call, IOException e) {
						System.out.println("请求错误"+e.toString());
					}

					@Override
					public void onResponse(Call call, Response response) throws IOException {
						System.out.println("请求响应"+response.code());
						System.out.println("请求响应"+response.body().string());
					}
				});
			}
		});
	}
}
