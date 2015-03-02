package exe.boris.targetmaker.presenter;

import android.content.Context;

/**
 * Created by boris on 2/27/15.
 */
public interface OnRegistrationFinishedListener {
    public void onUsernameError();
    public void onEmailError();
    public void onPasswordError();
    public void onConfirmPassError();
    public void onConfirmPassErr();
    public void onSuccess();
    public Context getContext();
    public void onNetworkConnectionError();
}
