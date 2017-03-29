package freedoms.androidframework.module.demo.presenter;

import freedoms.androidframework.module.demo.model.action.DemoAction;
import freedoms.androidframework.module.demo.model.action.IDemoAction;
import freedoms.androidframework.module.demo.view.IDemoView;

/**
 * Created by freedoms on 2017/3/17.
 */

public class DemoPresenter {
	private IDemoAction iDemoAction;

	public DemoPresenter(){
		this.iDemoAction=new DemoAction();
	}

	public void sendGetRequest(){
		iDemoAction.sendGetRequest();
	}

	public void sendPostRequest(){
		iDemoAction.sendPostRequest();
	}

	public void sendPutRequest(){
		iDemoAction.sendPutRequest();
	}

	public void sendDeleteRequest(){
		iDemoAction.sendDeleteRequest();
	}


}
