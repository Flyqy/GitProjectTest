package com.example.liqfo.gitprojecttest.Activity.WebActivity;

import com.example.liqfo.gitprojecttest.BaseElement.BasePresenter;

public class WebPresenter extends BasePresenter<WebViewInterface> {

    public WebPresenter(WebViewInterface view) {
        super(view);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public void showWebSite(String url) {
        if (getView() != null) {
            getView().showSite(url);
        }
    }

    public void statusProgressBar(int progress) {
        if (getView() != null) {
            if (progress == 100) {
                getView().hideWebProgress();
            } else {
                getView().showWebProgress(progress);
            }
        }
    }

    public void shareLink(String url) {
        if (getView() != null) {
            getView().shareLink(url);
        }
    }
}
