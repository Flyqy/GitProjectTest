package com.example.liqfo.gitprojecttest.Activity.WebActivity;


import com.example.liqfo.gitprojecttest.BaseElement.BaseView;

public interface WebViewInterface extends BaseView {

    void showSite(String url);

    void showWebProgress(int progress);

    void hideWebProgress();

    void shareLink(String url);

}
