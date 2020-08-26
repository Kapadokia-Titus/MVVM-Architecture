package kapadokia.nyandoro.mvvmdatabinding.viewModels;

import android.text.TextUtils;
import android.util.Patterns;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import java.util.regex.Pattern;

import kapadokia.nyandoro.mvvmdatabinding.BR;
import kapadokia.nyandoro.mvvmdatabinding.R;
import kapadokia.nyandoro.mvvmdatabinding.model.User;

public class LoginViewModel extends BaseObservable {

    private User user;

    private String successMessage ="login success";
    private String errorMessage = "invalid email or password";

    @Bindable
    private String toastMessage = null;

    public String getToastMessage() {
        return toastMessage;
    }

    public void setToastMessage(String toastMessage) {
        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }

    public void setUserEmail(String email){
        user.setEmail(email);
        notifyPropertyChanged(BR.userEmail);
    }

    @Bindable
    public String getUserEmail(){
        return user.getEmail();
    }

    public void setUserPassword(String password){
        user.setPassword(password);
        notifyPropertyChanged(BR.userPassword);
    }

    @Bindable
    public String getUserPassword(){
        return user.getPassword();
    }

    public LoginViewModel(){
        user  = new User("","");
    }

    public void onLoginClicked(){
        if (isInputDataValid()){
            setToastMessage(successMessage);
        }else {
            setToastMessage(errorMessage);
        }
    }

    public boolean isInputDataValid(){
        return !TextUtils.isEmpty(getUserEmail())&& Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches()
                && getUserPassword().length()>5;
    }


}
