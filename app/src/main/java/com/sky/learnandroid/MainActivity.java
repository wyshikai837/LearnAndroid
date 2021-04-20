package com.sky.learnandroid;

import android.graphics.PixelFormat;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

import com.sky.learnandroid.IPC.IPCMainActivity;
import com.sky.learnandroid.aboutview.AboutViewActivity;
import com.sky.learnandroid.adapter.SimpleAdapter;
import com.sky.learnandroid.architecture.ArchitectureActivity;
import com.sky.learnandroid.jetpack.JetpackActivity;
import com.sky.learnandroid.lauchmode.LauchModeActivity;
import com.sky.learnandroid.lifecycler.LifeCyclerActivity;
import com.sky.learnandroid.service.ServiceMainActivity;
import com.sky.learnandroid.webview.WebViewActivity;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private final static List<String> learnListStrs = Arrays.asList(
            "LifeCycler",
            "LaunchMode",
            "AboutView",
            "IPC",
            "WebView",
            "Service",
            "Architecture",
            "Jetpack");

    private RecyclerView mRvLearnList;
    private SimpleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRvLearnList = (RecyclerView) findViewById(R.id.rv_learn_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRvLearnList.setLayoutManager(linearLayoutManager);
        mAdapter = new SimpleAdapter(learnListStrs);
        mAdapter.setListener(new SimpleAdapter.SimpleAdapterListener() {
            @Override
            public void onItemClicked(int position) {
                switch (position) {
                    case 0:
                        LifeCyclerActivity.startLifeCyclerActivity(MainActivity.this);
                        break;
                    case 1:
                        LauchModeActivity.startLauchModeActivity(MainActivity.this);
                        break;
                    case 2:
                        AboutViewActivity.startAboutViewActivity(MainActivity.this);
                        break;
                    case 3:
                        IPCMainActivity.startIPCMainActivity(MainActivity.this);
                        break;
                    case 4:
                        WebViewActivity.startWebViewActivity(MainActivity.this);
                        break;
                    case 5:
                        ServiceMainActivity.startServiceMainActivity(MainActivity.this);
                        break;
                    case 6:
                        ArchitectureActivity.startActivity(MainActivity.this);
                        break;
                    case 7:
                        JetpackActivity.startActivity(MainActivity.this);
                        break;
                }
            }
        });
        mRvLearnList.setAdapter(mAdapter);

//        try {
//            this.addFloatingButton();
//        } catch (Exception e) {
//            e.printStackTrace();
//            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
//            intent.setData(Uri.parse("package:" + getPackageName()));
//            startActivityForResult(intent, 111);
//        }
    }

    private void addFloatingButton() {
        WindowManager windowManager = getWindowManager();
        Button floatingButton = new Button(this);
        floatingButton.setText("button");
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY, 0, PixelFormat.TRANSPARENT);
        layoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED;
        layoutParams.gravity = Gravity.LEFT | Gravity.TOP;
        layoutParams.x = 0;
        layoutParams.y = 0;
        windowManager.addView(floatingButton, layoutParams);
    }

}
