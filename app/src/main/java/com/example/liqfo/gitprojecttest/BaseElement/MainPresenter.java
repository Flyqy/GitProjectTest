package com.example.liqfo.gitprojecttest.BaseElement;

import com.example.liqfo.gitprojecttest.MainView;

public class MainPresenter extends BasePresenter<MainView> {

    public MainPresenter(MainView view) {
        super(view);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public void showGit() {
        if (getView() != null){
            getView().showGitFragment();
        }
    }
}
