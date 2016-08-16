package com.myrecycleview.zmj;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ToggleButton;

import com.fivehundredpx.greedolayout.GreedoLayoutManager;
import com.fivehundredpx.greedolayout.GreedoSpacingItemDecoration;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        initView();
        initData();
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
    }

    private void initData() {
        //
        PhotosAdapter photosAdapter = new PhotosAdapter(this);
        final GreedoLayoutManager layoutManager = new GreedoLayoutManager(photosAdapter);
        layoutManager.setMaxRowHeight(MeasUtils.dpToPx(150, this));
        //
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(photosAdapter);
        //边距
        int spacing = MeasUtils.dpToPx(4, this);
        recyclerView.addItemDecoration(new GreedoSpacingItemDecoration(spacing));
        //点击更改高度
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (toggleButton.isChecked()) {
                    layoutManager.setMaxRowHeight(MeasUtils.dpToPx(200, MainActivity.this));
                    layoutManager.requestLayout();
                } else {
                    layoutManager.setMaxRowHeight(MeasUtils.dpToPx(150, MainActivity.this));
                    layoutManager.requestLayout();
                }
            }
        });
    }

    //强制全屏_无论有无ActionBar
    private void fullScreen() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

    }


}
