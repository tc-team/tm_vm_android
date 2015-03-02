package exe.boris.targetmaker.presenter;

import android.content.Context;

/**
 * Created by boris on 2/27/15.
 */
public interface OnLoginFinishedListener {
    public void onUsernameError();
    public void onPasswordError();
    public void onSucces();
    public void onStartActivity();
    public Context getContext();
    public void onNetworkConnectionError();
}
