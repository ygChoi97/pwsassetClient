package com.cnp.pwsasset.pwsprovision.dto;

import com.cnp.pwsasset.pwsprovision.entity.PwsProvision;
import lombok.*;

import java.util.Date;

@Setter @Getter @ToString
@NoArgsConstructor @AllArgsConstructor
public class PwsProvisionDto {
    private int id;
    private String department;
    private String centercd;
    private String realname;
    private String center;
    private String headquarters;
    private String sysadmin;
    private String idsysadmin;
    private String assetno;
    private String idasset;
    private String sn;
    private String manager;
    private String idmanager;
    private String areainstall;
    private String locinstall;
    private String model;
    private Date period;
    private String reason;
    private Date   joiningdate;
    private Date   applicationdate;
    private Date   provisiondate;
    private String note;

    public PwsProvisionDto(PwsProvision pwsProvision) {
        id = pwsProvision.getId();
        department = pwsProvision.getDepartment();
        centercd = pwsProvision.getCentercd();
        realname = pwsProvision.getRealname();
        center = pwsProvision.getCenter();
        headquarters = pwsProvision.getHeadquarters();
        sysadmin = pwsProvision.getSysadmin();
        idsysadmin = pwsProvision.getIdsysadmin();
        assetno = pwsProvision.getAssetno();
        idasset = pwsProvision.getIdasset();
        sn = pwsProvision.getSn();
        manager = pwsProvision.getManager();
        idmanager = pwsProvision.getIdmanager();
        areainstall = pwsProvision.getAreainstall();
        locinstall = pwsProvision.getLocinstall();
        model = pwsProvision.getModel();
        period = pwsProvision.getPeriod();
        reason = pwsProvision.getReason();
        joiningdate = pwsProvision.getJoiningdate();
        applicationdate = pwsProvision.getApplicationdate();
        provisiondate = pwsProvision.getProvisiondate();
        note = pwsProvision.getNote();
    }
}
