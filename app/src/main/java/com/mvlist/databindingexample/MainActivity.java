package com.mvlist.databindingexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mvlist.databindingexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private CounterViewModel viewModel;
    private ViewModelProvider.AndroidViewModelFactory viewModelFactory;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(viewModelFactory == null) {
            viewModelFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());
        }
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        user= new User(25, "Your Name");
        binding.setUser(user);
        binding.setLifecycleOwner(this); //이 객체가 이 액티비티의 라이프사이클을 참조하면서 데이터가 변경되거나 하면 refresh 시키겠다.
        viewModel = new ViewModelProvider(this,viewModelFactory).get(CounterViewModel.class); // ViewModel 가져오기
        binding.setViewModel(viewModel);

        binding.tvDate.setText("Test Text");
        /*
        viewModel.counter.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.tvCounter.setText(integer + " ");
            }
        });
         */
    }


}