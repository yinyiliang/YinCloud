package yyl.yincloud.http;

import org.json.JSONObject;

/**
 * Created by yyl on 2016/12/14.
 */

public interface HttpOnNextListener {

    void onNext(JSONObject jsonObject, String method);

    void OnError(Throwable e);

}
