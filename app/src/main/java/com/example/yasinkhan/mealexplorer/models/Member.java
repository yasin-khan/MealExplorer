package com.example.yasinkhan.mealexplorer.models;

/**
 * Created by YasinKhan on 27-Aug-18.
 */

public class Member {
    private int memberId;
    private String memberName;
    private String memberDeposite;
    private String memberMeal;

    public Member(int memberId, String memberName, String memberDeposite, String memberMeal) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberDeposite = memberDeposite;
        this.memberMeal = memberMeal;
    }

    public Member(String memberName, String memberDeposite, String memberMeal) {
        this.memberName = memberName;
        this.memberDeposite = memberDeposite;
        this.memberMeal = memberMeal;
    }

    public Member(String memberName, String memberDeposite) {
        this.memberName = memberName;
        this.memberDeposite = memberDeposite;
    }

    public Member(String memberName) {
        this.memberName = memberName;
    }

    public Member() {
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberDeposite() {
        return memberDeposite;
    }

    public void setMemberDeposite(String memberDeposite) {
        this.memberDeposite = memberDeposite;
    }

    public String getMemberMeal() {
        return memberMeal;
    }

    public void setMemberMeal(String memberMeal) {
        this.memberMeal = memberMeal;
    }
}
