package com.cnp.pwsasset.pws.dto;

import com.cnp.pwsasset.pws.entity.Pws;
import lombok.*;

import java.util.Date;

@Setter @Getter @ToString
@NoArgsConstructor @AllArgsConstructor
public class PwsDto {
    private String uptake;          // 사용구분
    private String company;         // 회사
    private String classification;  // 자산구분
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
    private Date introductiondate;    //도입년월
    private String note;            // 비고


    public PwsDto(Pws pws) {
        uptake = pws.getUptake();
        company = pws.getCompany();
        classification = pws.getClassification();
        headquarters = pws.getHeadquarters();
        center = pws.getCenter();
        department = pws.getDepartment();
        username = pws.getUsername();
        userid = pws.getUserid();
        centercd = pws.getCentercd();
        model = pws.getModel();
        assetno = pws.getAssetno();
        idasset = pws.getIdasset();
        sn = pws.getSn();
        graphic = pws.getGraphic();
        memory = pws.getMemory();
        monitor = pws.getMonitor();
        area = pws.getArea();
        building = pws.getBuilding();
        storey = pws.getStorey();
        location = pws.getLocation();
        objpurchase = pws.getObjpurchase();
        objuse = pws.getObjuse();
        desctask = pws.getDesctask();
        introductiondate = pws.getIntroductiondate();
        note = pws.getNote();
    }
}
