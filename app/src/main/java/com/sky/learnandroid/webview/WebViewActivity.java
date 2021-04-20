package com.sky.learnandroid.webview;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.sky.learnandroid.R;

public class WebViewActivity extends AppCompatActivity {

    public static void startWebViewActivity(Activity activity) {
        Intent intent = new Intent(activity, WebViewActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        WebView webView = findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.baidu.com");

        webView.setWebViewClient(new WebViewClient() {
            @Override

            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                // 如下方案可在非微信内部WebView的H5页面中调出微信支付

                if (url.startsWith("weixin://wap/pay?")) {

                    Intent intent = new Intent();

                    intent.setAction(Intent.ACTION_VIEW);

                    intent.setData(Uri.parse(url));

                    startActivity(intent);



                    return true;

                }

                return super.shouldOverrideUrlLoading(view, url);

            }
        });
    }
}
