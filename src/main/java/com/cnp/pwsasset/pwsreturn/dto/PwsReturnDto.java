package com.cnp.pwsasset.pwsreturn.dto;

import com.cnp.pwsasset.pwsreturn.entity.PwsReturn;
import lombok.*;

import java.util.Date;

@Setter @Getter @ToString
@NoArgsConstructor @AllArgsConstructor
public class PwsReturnDto {
    private int id;
    private String hoteam;
    private String housername;
    private String houserid;
    private String toteam;
    private String manager;
    private String assetno;
    private String idasset;
    private String sn;
    private String model;
    private String location;
    private String reason;
    private String note;
    private Date resigndate;
    private Date returndate;
    public PwsReturnDto(PwsReturn pwsReturn) {
        id = pwsReturn.getId();
        hoteam = pwsReturn.getHoteam();
        housername = pwsReturn.getHousername();
        houserid = pwsReturn.getHouserid();
        toteam = pwsReturn.getToteam();
        manager = pwsReturn.getManager();
        assetno = pwsReturn.getAssetno();
        idasset = pwsReturn.getIdasset();
        sn = pwsReturn.getSn();
        model = pwsReturn.getModel();
        location = pwsReturn.getLocation();
        reason = pwsReturn.getReason();
        note = pwsReturn.getNote();
        resigndate = pwsReturn.getResigndate();
        returndate = pwsReturn.getReturndate();
    }
}
