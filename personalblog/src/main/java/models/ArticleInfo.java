
package models;

import java.util.Date;

public class ArticleInfo {
    private int id;
    private Date createtime;
    private Date updatetime;
    private String title;
    private String content;
    private int rcount;
    private int state;
    private int uid;

    public ArticleInfo() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return this.updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRcount() {
        return this.rcount;
    }

    public void setRcount(int rcount) {
        this.rcount = rcount;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getUid() {
        return this.uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
