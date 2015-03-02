package exe.boris.targetmaker.presenter;

import android.content.Context;
import android.text.TextUtils;

import com.google.inject.Inject;

import org.json.JSONException;

import java.io.IOException;

import exe.boris.targetmaker.services.LoginService;
import exe.boris.targetmaker.view.LoginView;

/**
 * Created by boris on 26.02.15.
 */
public class LoginPresenter implements OnLoginFinishedListener {

    public LoginView loginView;
    private LoginService loginService;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
        loginService = new LoginService();
    }

    public void validateLogin(String username, String password) {
            try {
                loginService.login(username, password, this);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
    }

    @Override
    public void onUsernameError() {
        loginView.setUsernameError();
    }

    @Override
    public void onPasswordError() {
        loginView.setPasswordError();
    }

    @Override
    public void onSucces() {
        loginView.navigateToMainActivity();
    }

    @Override
    public void onStartActivity() {
        loginView.navigateToRegistrationActivity();
    }

    @Override
    public Context getContext() {
        return loginView.getCurrentContext();
    }

    @Override
    public void onNetworkConnectionError() {
        loginView.setNetworkConnectionError();
    }
}
