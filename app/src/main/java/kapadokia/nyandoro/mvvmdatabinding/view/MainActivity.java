package kapadokia.nyandoro.mvvmdatabinding.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import kapadokia.nyandoro.mvvmdatabinding.R;
import kapadokia.nyandoro.mvvmdatabinding.databinding.ActivityMainBinding;
import kapadokia.nyandoro.mvvmdatabinding.viewModels.LoginViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.setViewModel(new LoginViewModel());


    }

    @BindingAdapter({"toastMessage"})
    public static void runMe(View view, String message){
        if (message!=null){
            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
        }
    }
}