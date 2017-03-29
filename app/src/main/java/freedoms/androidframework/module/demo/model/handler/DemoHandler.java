package freedoms.androidframework.module.demo.model.handler;

import android.os.Handler;
import android.os.Message;

import freedoms.androidframework.module.demo.view.IDemoView;

/**
 * Created by freedoms on 2017/3/17.
 */

public class DemoHandler extends Handler{

	private static final int GET=0;
	private static final int POST=1;
	private static final int PUT=2;
	private static final int DELETE=3;

	private IDemoView iDemoView;

	public DemoHandler(IDemoView iDemoView){
		this.iDemoView=iDemoView;
	}

	@Override
	public void handleMessage(Message msg) {
		super.handleMessage(msg);
		switch (msg.what){
			case GET:
				iDemoView.sendGetRequest();
				break;
			case POST:
				iDemoView.sendPostRequest();
			case PUT:
				iDemoView.sendPutRequest();
			case DELETE:
				iDemoView.sendDeleteRequest();
		}
	}
}
