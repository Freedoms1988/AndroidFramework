package freedoms.androidframework.module.demo.model.action;

import freedoms.androidframework.module.demo.view.IDemoView;

/**
 * Created by freedoms on 2017/3/17.
 */

public interface IDemoAction {

	void sendPostRequest();

	void sendGetRequest();

	void sendPutRequest();

	void sendDeleteRequest();
}
