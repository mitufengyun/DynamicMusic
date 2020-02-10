package com.ixuea.courses.mymusic.activity.base;

import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;

import com.ixuea.courses.mymusic.R;

import butterknife.BindView;

/**
 * author: xpf
 * time: 2020/2/6 6:23
 * describe: 通用标题栏父类
 */
public class BaseTitleActivity extends BaseCommonActivity{

    /**
     * Toolbar
     */
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void initViews() {
        super.initViews();
        // 初始化Toolbar
        setSupportActionBar(toolbar);

        //是否显示返回按钮
        if (isShowBackMenu()) {
            showBackMenu();
        }
    }

    /**
     * 显示返回按钮
     */
    protected void showBackMenu() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    /**
     * 是否显示返回按钮
     */
    protected boolean isShowBackMenu() {
        return true;
    }

    /**
     * 按钮点击回调事件
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //Toolbar返回按钮点击
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
