package com.example.tmaptest;

import java.util.ArrayList;
import java.util.List;

public class AppDataBase {
    private static List<Member> memberList;

    //회원 생성을 위한 리스트
    static {
        memberList = new ArrayList<>();
        Member member = null;

        //회원정보 가상 데이터 하나 생성(임의의 아이디와 비밀번호 생성)
        member = new Member(1,"user1","user1");
        memberList.add(member);
    }
    //가입된 아이디와 비밀번호 정보가 일치하지 않으면 로그인이 실행되되지 않도록 설정
    public static Member findMember(String loginId) {
        for (Member member : memberList) {
            if (member.getLoginId().equals(loginId)){
                return member;
            }
        }
        return null; //정보없음
    }
    //회원 번호의 숫자는 가장 마지막 회원에서 +1 해서 회원 등록
    public static void join(String loginId, String loginPasswd, String name){
        int id = memberList.get(memberList.size()-1).getId()+1;
        Member member = new Member(id, loginId, loginPasswd);
        memberList.add(member);
    }
}


