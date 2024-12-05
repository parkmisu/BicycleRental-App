package com.example.tmaptest;

//로그인을 위한 회원 정보 생성
public class Member {
    private int id;
    private String loginId;
    private String loginPasswd;

    //인자 없는 생성자
    public Member(){

    }

    //constructor 생성
    public Member(int id, String loginId, String loginPasswd) {
        this.id = id;
        this.loginId = loginId;
        this.loginPasswd = loginPasswd;
    }

    //Getter and Setter 생성
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLoginId() {
        return loginId;
    }
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }
    public String getLoginPasswd() {
        return loginPasswd;
    }
    public void setLoginPasswd(String loginPasswd) {
        this.loginPasswd = loginPasswd;
    }

    //toString 생성
    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", loginId='" + loginId + '\'' +
                ", loginPasswd='" + loginPasswd + '\'' +
                '}';
    }
}




