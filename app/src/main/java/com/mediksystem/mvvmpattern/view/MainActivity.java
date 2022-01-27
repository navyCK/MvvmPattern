package com.mediksystem.mvvmpattern.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.mediksystem.mvvmpattern.R;
import com.mediksystem.mvvmpattern.databinding.ActivityMainBinding;
import com.mediksystem.mvvmpattern.model.Database;
import com.mediksystem.mvvmpattern.viewModel.ViewModel;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("onCreate()", "Main_onCreate() 실행");
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        viewModel = new ViewModel(Database.getInstance());
        binding.setViewModel(viewModel);

        binding.okBtnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("버튼 클릭", "버튼 클릭");
                viewModel.getUser();
            }
        });
    }
}