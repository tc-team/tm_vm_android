package exe.boris.targetmaker.presenter;

import org.json.JSONException;

import java.io.IOException;

import exe.boris.targetmaker.services.RegistrationService;
import exe.boris.targetmaker.view.RegistrationView;

/**
 * Created by boris on 27.02.15.
 */
public class RegistrationPresenter implements OnRegistrationFinishedListener {

    private RegistrationService registrationService;
    private RegistrationView registrationView;

    public RegistrationPresenter(RegistrationView registrationView) {
        this.registrationView = registrationView;
        registrationService = new RegistrationService();
    }

    public void validateRegistration(String username, String email, String password, String confPassword) {
        try {
            registrationService.register(username, email, password, confPassword, this);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUsernameError() {
        registrationView.setUsernameError();
    }

    @Override
    public void onEmailError() {
        registrationView.setEmailError();
    }

    @Override
    public void onPasswordError() {
        registrationView.setPasswordError();
    }

    @Override
    public void onConfirmPassError() {
        registrationView.setConfirmPassError();
    }

    @Override
    public void onSuccess() {
        registrationView.navigateToActivity();
        registrationView.showToast();
    }


}
