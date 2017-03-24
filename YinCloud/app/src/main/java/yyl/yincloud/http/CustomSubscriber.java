package yyl.yincloud.http;

import org.json.JSONObject;

import rx.Subscriber;

/**
 * Created by yyl on 2016/12/14.
 */

public class CustomSubscriber<T> extends Subscriber<T> {

    private HttpOnNextListener mSubscriberOnNextListener;

    private String method;

    public CustomSubscriber(String method, HttpOnNextListener listenerSoftReference) {
        this.mSubscriberOnNextListener = listenerSoftReference;
        this.method = method;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        if (mSubscriberOnNextListener != null) {
            mSubscriberOnNextListener.OnError(e);
        }
    }

    @Override
    public void onNext(T t) {
        if (mSubscriberOnNextListener != null) {
            mSubscriberOnNextListener.onNext((JSONObject) t, method);
        }
    }

}
