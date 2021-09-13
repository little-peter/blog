package models;

import java.util.Date;

public class UserInfo {
    private int id;
    private Date createtime;
    private Date updatatime;
    private String username;
    private String password;
    private int state;

    public UserInfo() {
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

    public Date getUpdatatime() {
        return this.updatatime;
    }

    public void setUpdatatime(Date updatatime) {
        this.updatatime = updatatime;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
