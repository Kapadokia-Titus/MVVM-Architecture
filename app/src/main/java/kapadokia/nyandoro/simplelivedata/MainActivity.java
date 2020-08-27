package kapadokia.nyandoro.simplelivedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import kapadokia.nyandoro.simplelivedata.model.User;
import kapadokia.nyandoro.simplelivedata.viewmodel.LoginViewModel;

public class MainActivity extends AppCompatActivity {

    MainActivity context;
    LoginViewModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context =this;
        model = ViewModelProviders.of(context).get(LoginViewModel.class);
        model.getUserObject().observe(context, userObjectObserver);
    }

    private final Observer<User> userObjectObserver = new Observer<User>() {
        @Override
        public void onChanged(User user) {

            // update UI
            ((TextView) findViewById(R.id.email)).setText(user.getEmail());
            ((TextView) findViewById(R.id.password)).setText(user.getPassword());

            Toast.makeText(context, "Email : " + user.getEmail() + "\nPassword : " + user.getPassword(), Toast.LENGTH_SHORT).show();
        }
    };


    public void buttonPress(View view) {
        //populating the data in view model
        model.doAction();
    }
}