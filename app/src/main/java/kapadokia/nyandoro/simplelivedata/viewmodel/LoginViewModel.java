package kapadokia.nyandoro.simplelivedata.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import kapadokia.nyandoro.simplelivedata.model.User;

public class LoginViewModel extends ViewModel {

    private MutableLiveData<User> userObject;

    public LoginViewModel(){
        userObject = new MutableLiveData<>();
    }

    public LiveData<User> getUserObject(){
        return userObject;
    }

    public void doAction(){
        User user = new User();
        user.setEmail("ktnyandoch@gmail.com");
        user.setPassword("1234567");

        userObject.setValue(user);
    }
}
