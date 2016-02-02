package freedoms.androidframework.demo;

import java.util.HashMap;
import java.util.Map;

import freedoms.androidframework.http.FHttp;
import freedoms.androidframework.http.FHttp.RequestCallBack;

/**
 * Created by freedoms on 16/2/1.
 */
public class XutilsDemo{

    private void getDemo() {
        //本get请求来自于免费测试接口：http://www.k780.com/api/entry.baidu
        String url = "http://api.k780.com:88/?app=idcard.get";
        Map<String, String> map = new HashMap<String,String>();
        map.put("appkey", "10003");
        map.put("sign", "b59bc3ef6191eb9f747dd4e83c99f2a4");
        map.put("format", "json");
        map.put("idcard", "110101199001011114");
        FHttp.Get(url, map, new RequestCallBack<PersonInfoBean>() {
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
        Map<String, String> map = new HashMap<String, String>();
        map.put("username", "1888");
        map.put("passwd", "123123");
        FHttp.Post(url, map, new RequestCallBack<Object>() {
            @Override
            public void onSuccess(Object result) {
                super.onSuccess(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                super.onError(ex, isOnCallback);
            }
        });
    }

    private void putDemo() {
        String url = "http://";
        Map<String, String> map = new HashMap<String, String>();
        map.put("username", "1888");
        map.put("passwd", "123123");
        FHttp.Put(url, map, new RequestCallBack<Object>() {
            @Override
            public void onSuccess(Object result) {
                super.onSuccess(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                super.onError(ex, isOnCallback);
            }
        });
    }

    private void deleteDemo() {
        String url = "http://";
        Map<String, String> map = new HashMap<String, String>();
        map.put("username", "1888");
        map.put("passwd", "123123");
        FHttp.Delete(url, map, new RequestCallBack<Object>() {
            @Override
            public void onSuccess(Object result) {
                super.onSuccess(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                super.onError(ex, isOnCallback);
            }
        });
    }

    private void uploadFileDemo() {
        //图片上传地址
        String url = "";
        Map<String, Object> map = new HashMap<>();
        //传入自己的相应参数
        //map.put(key, value);
        //map.put(key, value);
        FHttp.UpLoadFile(url, map, new FHttp.RequestProgressCallBack<Object>() {
            @Override
            public void onFinished() {
                super.onFinished();
            }

            @Override
            public void onWaiting() {
                super.onWaiting();
            }

            @Override
            public void onSuccess(Object o) {
                super.onSuccess(o);
            }

            @Override
            public void onStarted() {
                super.onStarted();
            }

            @Override
            public void onLoading(long l, long l1, boolean b) {
                super.onLoading(l, l1, b);
            }

            @Override
            public void onCancelled(CancelledException e) {
                super.onCancelled(e);
            }

            @Override
            public void onError(Throwable throwable, boolean b) {
                super.onError(throwable, b);
            }
        });
    }

    private void downloadFileDemo() {
        //文件下载地址
        String url = "";
        //文件保存在本地的路径
        String filepath = "";
        FHttp.DownLoadFile(url, filepath, new FHttp.RequestProgressCallBack<Object>() {
            @Override
            public void onFinished() {
                super.onFinished();
            }

            @Override
            public void onWaiting() {
                super.onWaiting();
            }

            @Override
            public void onSuccess(Object o) {
                super.onSuccess(o);
            }

            @Override
            public void onStarted() {
                super.onStarted();
            }

            @Override
            public void onLoading(long l, long l1, boolean b) {
                super.onLoading(l, l1, b);
            }

            @Override
            public void onCancelled(CancelledException e) {
                super.onCancelled(e);
            }

            @Override
            public void onError(Throwable throwable, boolean b) {
                super.onError(throwable, b);
            }

        });
    }
}
