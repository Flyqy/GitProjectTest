package com.example.liqfo.gitprojecttest;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.liqfo.gitprojecttest.BaseElement.BaseView;
import com.example.liqfo.gitprojecttest.BaseElement.IdleActivity;
import com.example.liqfo.gitprojecttest.BaseElement.MainPresenter;
import com.example.liqfo.gitprojecttest.Fragments.Git.GitFragment;

public class MainActivity extends IdleActivity implements MainView {

    private MainPresenter mainPresenter;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        mainPresenter = new MainPresenter(this);
        mainPresenter.onCreate();
        mainPresenter.showGit();
    }

    private void showFragment(@NonNull Fragment fragment) {
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    @Override
    public void showGitFragment() {
        showFragment(new GitFragment());
    }
}
