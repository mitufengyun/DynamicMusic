package com.ixuea.courses.mymusic.bean;

/**
 * author: xpf
 * time: 2020/2/10 6:33
 * describe: 歌单对象
 */
public class Sheet {

    /**
     * 歌单ID
     */
    private String id;

    /**
     * 歌单标题
     */
    private String title;

    /**
     * 歌单封面
     */
    private String banner;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }
}
