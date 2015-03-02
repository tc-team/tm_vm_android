package exe.boris.targetmaker.view;

/**
 * Created by boris on 2/27/15.
 */
public interface RegistrationView {
    public void setUsernameError();
    public void setEmailError();
    public void setPasswordError();
    public void setConfirmPassError();
    public void navigateToActivity();
    public void showToast();
}
