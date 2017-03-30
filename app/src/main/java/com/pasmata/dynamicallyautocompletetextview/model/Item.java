package com.pasmata.dynamicallyautocompletetextview.model;

/**
 * Created by jhon on 29/03/17.
 */

public class Item {

    private String id;
    private String username;
    private Object groupName;
    private String nip;
    private String name;
    private String groupID;
    private String positionID;
    private String positionName;
    private String branchOfficeID;
    private String branchOfficeCode;
    private String branchOfficeName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Object getGroupName() {
        return groupName;
    }

    public void setGroupName(Object groupName) {
        this.groupName = groupName;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getPositionID() {
        return positionID;
    }

    public void setPositionID(String positionID) {
        this.positionID = positionID;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getBranchOfficeID() {
        return branchOfficeID;
    }

    public void setBranchOfficeID(String branchOfficeID) {
        this.branchOfficeID = branchOfficeID;
    }

    public String getBranchOfficeCode() {
        return branchOfficeCode;
    }

    public void setBranchOfficeCode(String branchOfficeCode) {
        this.branchOfficeCode = branchOfficeCode;
    }

    public String getBranchOfficeName() {
        return branchOfficeName;
    }

    public void setBranchOfficeName(String branchOfficeName) {
        this.branchOfficeName = branchOfficeName;
    }

}