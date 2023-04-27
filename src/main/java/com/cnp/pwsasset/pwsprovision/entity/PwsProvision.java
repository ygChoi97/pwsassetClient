package com.cnp.pwsasset.pwsprovision.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter @Getter @ToString
@AllArgsConstructor
public class PwsProvision {
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
    private Date   period;
    private String reason;
    private Date   joiningdate;
    private Date   applicationdate;
    private Date   provisiondate;
    private String note;
}
