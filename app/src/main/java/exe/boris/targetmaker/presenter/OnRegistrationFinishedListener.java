package exe.boris.targetmaker.presenter;

/**
 * Created by boris on 2/27/15.
 */
public interface OnRegistrationFinishedListener {
    public void onUsernameError();
    public void onEmailError();
    public void onPasswordError();
    public void onConfirmPassError();
    public void onSuccess();
}
