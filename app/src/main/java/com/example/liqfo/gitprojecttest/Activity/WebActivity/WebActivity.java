package com.example.liqfo.gitprojecttest.Activity.WebActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.liqfo.gitprojecttest.BaseElement.IdleActivity;
import com.example.liqfo.gitprojecttest.R;

public class WebActivity extends IdleActivity implements WebViewInterface {

    private WebPresenter webPresenter;

    public static final String URL = "url";
    private String currentUrl;

    private WebView webView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.git_web_layout);

        currentUrl = getIntent().getStringExtra(URL);
        setTitle(R.string.web_View);
        initViews();

        webPresenter = new WebPresenter(this);
        webPresenter.onCreate();
        webPresenter.showWebSite(currentUrl);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.web_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_share:
                webPresenter.shareLink(currentUrl);
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void initViews() {
        webView = findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }
        });
        progressBar = findViewById(R.id.progressBar);
        progressBar.setMax(100);
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                webPresenter.statusProgressBar(newProgress);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {

            }
        });
    }

    @Override
    public void showSite(String url) {
        webView.loadUrl(url);
    }

    @Override
    public void showWebProgress(int progress) {
        progressBar.setVisibility(View.VISIBLE);
        progressBar.setProgress(progress);
    }

    @Override
    public void hideWebProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void shareLink(String url) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT, "GearPhoto");
        String sAux = url + " \n\n";
        i.putExtra(Intent.EXTRA_TEXT, sAux);
        startActivity(Intent.createChooser(i, getResources().getString(R.string.choose)));
    }
}
