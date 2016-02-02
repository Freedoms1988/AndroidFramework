package freedoms.androidframework.demo;

import java.util.HashMap;
import java.util.Map;

import freedoms.androidframework.XUtils;
import freedoms.androidframework.XUtils.RequestCallBack;

/**
 * Created by freedoms on 16/2/1.
 */
public class XutilsDemo {

    private void getDemo() {
        //本get请求来自于免费测试接口：http://www.k780.com/api/entry.baidu
        String url = "http://api.k780.com:88/?app=idcard.get";
        Map<String, String> map = new HashMap<String,String>();
        map.put("appkey", "10003");
        map.put("sign", "b59bc3ef6191eb9f747dd4e83c99f2a4");
        map.put("format", "json");
        map.put("idcard", "110101199001011114");
        XUtils.Get(url, map, new RequestCallBack<PersonInfoBean>() {
            @Override
            public void onSuccess(PersonInfoBean result) {
                super.onSuccess(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                super.onError(ex, isOnCallback);
            }
        });
    }

    private void postDemo(){
        String url = "http://";
        Map<String,String> map=new HashMap<>();
    }
}
