package com.cnp.pwsasset.pws.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter @Getter @ToString
@AllArgsConstructor

public class Pws {
    private String uptake;          // 사용구분
    private String company;         // 회사
    private String headquarters;    // 본부
    private String center;          // 센터
    private String department;      // 관리부서
    private String username;        // 사용자
    private String userid;          // 사용자ID
    private String centercd;        // 코스트센터CD
    private String model;           // 모델명
    private String assetno;         // 자산번호
    private String idasset;         // 자산관리번호 (pk)
    private String sn;              // S/N
    private String graphic;         // 그래픽카드
    private String memory;          // 메모리
    private String monitor;         // 모니터
    private String area;            // 지역
    private String building;        // 건물명
    private String storey;          // 층수
    private String location;        // 상세위치
    private String objpurchase;     // 구매용도
    private String objuse;          // 사용용도
    private String desctask;        // 상세업무
    private Date introductiondate;  //도입년월
    private String note;            // 비고
}
