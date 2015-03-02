package exe.boris.targetmaker.view;

import android.content.Context;

/**
 * Created by boris on 27.02.15.
 */
public interface LoginView {
    public void setUsernameError();
    public void setPasswordError();
    public void navigateToMainActivity();
    public void navigateToRegistrationActivity();
    public Context getCurrentContext();
    public void setNetworkConnectionError();
}
