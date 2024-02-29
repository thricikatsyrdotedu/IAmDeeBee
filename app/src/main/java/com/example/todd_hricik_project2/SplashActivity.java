package com.example.todd_hricik_project2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.content.Intent;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;


public class SplashActivity extends AppCompatActivity {

    public static class SplashFragment extends Fragment {
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            // Inflate the layout
            View v = inflater.inflate(R.layout.activity_fragment, container, false);
            Glide.with(getActivity())
                    .load(R.drawable.ttgthm)
                    .into((ImageView) v.findViewById(R.id.splash_fragment_imageView));
            return v;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.splash_framelayout_container, new SplashFragment());
        fragmentTransaction.commit();
        // Create a countdown timer to control the number of seconds the splash screen is on
        new CountDownTimer(5000, 1000) {
            public void onTick(long millisUntilFinished) {
                // pass
            }
            public void onFinish() {
                // start activity 1 once the timer has counted down;
                startActivity(new Intent(SplashActivity.this, Activity1.class));
            }
        }.start();
    }
}