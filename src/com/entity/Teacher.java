package com.entity;

public class Teacher {
    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public int getAdministrators() {
        return administrators;
    }

    public void setAdministrators(int administrators) {
        this.administrators = administrators;
    }

    public String getAprt() {
        return aprt;
    }

    public void setAprt(String aprt) {
        this.aprt = aprt;
    }

    public String getNewpasswd() {
        return newpasswd;
    }

    public void setNewpasswd(String newpasswd) {
        this.newpasswd = newpasswd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNew_passwd() {
        return new_passwd;
    }

    public void setNew_passwd(String new_passwd) {
        this.new_passwd = new_passwd;
    }

    public int getEnable() {
        return enable;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }

    private String tId;
    private String tName;
    private String passwd;
    private int    administrators;
    private String aprt;
    private String newpasswd;
    private String email;
    private String new_passwd;
    private int enable;
}
