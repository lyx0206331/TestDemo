package com.adrian.testdemo.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.adrian.testdemo.BR;

/**
 * Created by qing on 2017/11/29 0029.
 */

public class ToolbarContent extends BaseObservable {
    private String title;
    private String subTitle;

    public ToolbarContent(String title, String subTitle) {
        this.title = title;
        this.subTitle = subTitle;
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
        notifyPropertyChanged(BR.subTitle);
    }
}
