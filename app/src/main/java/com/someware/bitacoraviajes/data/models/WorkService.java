package com.someware.bitacoraviajes.data.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;


@Entity(tableName = "work_service_table")
public class WorkService {

    public long getWorkId() {
        return workId;
    }

    public void setWorkId(long workId) {
        this.workId = workId;
    }

    public String getLicensePlateTruck() {
        return licensePlateTruck;
    }

    public void setLicensePlateTruck(String licensePlateTruck) {
        this.licensePlateTruck = licensePlateTruck;
    }

    public String getLicensePlatePlatform() {
        return licensePlatePlatform;
    }

    public void setLicensePlatePlatform(String licensePlatePlatform) {
        this.licensePlatePlatform = licensePlatePlatform;
    }

    public int getKmstart() {
        return kmstart;
    }

    public void setKmstart(int kmstart) {
        this.kmstart = kmstart;
    }

    public int getKmfinal() {
        return kmfinal;
    }

    public void setKmfinal(int kmfinal) {
        this.kmfinal = kmfinal;
    }

    public int getKmRecorrido() {
        return kmRecorrido;
    }

    public void setKmRecorrido(int kmRecorrido) {
        this.kmRecorrido = kmRecorrido;
    }

    public String getOutboundStartLocation() {
        return outboundStartLocation;
    }

    public void setOutboundStartLocation(String outboundStartLocation) {
        this.outboundStartLocation = outboundStartLocation;
    }

    public Date getOutboundStartDate() {
        return outboundStartDate;
    }

    public void setOutboundStartDate(Date outboundStartDate) {
        this.outboundStartDate = outboundStartDate;
    }

    public String getOutboundStartTime() {
        return outboundStartTime;
    }

    public void setOutboundStartTime(String outboundStartTime) {
        this.outboundStartTime = outboundStartTime;
    }

    public String getOutBoundEndLocation() {
        return outBoundEndLocation;
    }

    public void setOutBoundEndLocation(String outBoundEndLocation) {
        this.outBoundEndLocation = outBoundEndLocation;
    }

    public Date getOutboundEndDate() {
        return outboundEndDate;
    }

    public void setOutboundEndDate(Date outboundEndDate) {
        this.outboundEndDate = outboundEndDate;
    }

    public String getOutboundEndTime() {
        return outboundEndTime;
    }

    public void setOutboundEndTime(String outboundEndTime) {
        this.outboundEndTime = outboundEndTime;
    }

    public String getOutboundProduct() {
        return outboundProduct;
    }

    public void setOutboundProduct(String outboundProduct) {
        this.outboundProduct = outboundProduct;
    }

    public int getOutboundWeight() {
        return outboundWeight;
    }

    public void setOutboundWeight(int outboundWeight) {
        this.outboundWeight = outboundWeight;
    }

    public String getOutboundDocuments() {
        return outboundDocuments;
    }

    public void setOutboundDocuments(String outboundDocuments) {
        this.outboundDocuments = outboundDocuments;
    }

    public boolean isOutboundWorkType() {
        return outboundWorkType;
    }

    public void setOutboundWorkType(boolean outboundWorkType) {
        this.outboundWorkType = outboundWorkType;
    }

    public int getTakenTimeOutbound() {
        return takenTimeOutbound;
    }

    public void setTakenTimeOutbound(int takenTimeOutbound) {
        this.takenTimeOutbound = takenTimeOutbound;
    }

    public String getReturnStartLocation() {
        return returnStartLocation;
    }

    public void setReturnStartLocation(String returnStartLocation) {
        this.returnStartLocation = returnStartLocation;
    }

    public Date getReturnStartDate() {
        return returnStartDate;
    }

    public void setReturnStartDate(Date returnStartDate) {
        this.returnStartDate = returnStartDate;
    }

    public String getReturnStartTime() {
        return returnStartTime;
    }

    public void setReturnStartTime(String returnStartTime) {
        this.returnStartTime = returnStartTime;
    }

    public String getReturnEndLocation() {
        return returnEndLocation;
    }

    public void setReturnEndLocation(String returnEndLocation) {
        this.returnEndLocation = returnEndLocation;
    }

    public Date getReturnEndDate() {
        return returnEndDate;
    }

    public void setReturnEndDate(Date returnEndDate) {
        this.returnEndDate = returnEndDate;
    }

    public String getReturnEndTime() {
        return returnEndTime;
    }

    public void setReturnEndTime(String returnEndTime) {
        this.returnEndTime = returnEndTime;
    }

    public String getReturnProduct() {
        return returnProduct;
    }

    public void setReturnProduct(String returnProduct) {
        this.returnProduct = returnProduct;
    }

    public int getReturnWeight() {
        return returnWeight;
    }

    public void setReturnWeight(int returnWeight) {
        this.returnWeight = returnWeight;
    }

    public String getReturnDocuments() {
        return returnDocuments;
    }

    public void setReturnDocuments(String returnDocuments) {
        this.returnDocuments = returnDocuments;
    }

    public boolean isReturnWorkType() {
        return returnWorkType;
    }

    public void setReturnWorkType(boolean returnWorkType) {
        this.returnWorkType = returnWorkType;
    }

    public int getTakenTimeReturn() {
        return takenTimeReturn;
    }

    public void setTakenTimeReturn(int takenTimeReturn) {
        this.takenTimeReturn = takenTimeReturn;
    }
    @PrimaryKey(autoGenerate = true)
    long workId;

    /******************************GENERAL INFO***********************/
    int status;

    public int isStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    String licensePlateTruck;

    String licensePlatePlatform;
    /*****************************************************************/
    int kmstart;
    int kmfinal;

    public int getStatus() {
        return status;
    }

    int kmRecorrido;
    /*****************************************************************/
    //ida
    String outboundStartLocation;
    Date outboundStartDate;
    String outboundStartTime;
    String outBoundEndLocation;
    Date outboundEndDate;
    String outboundEndTime;
    String outboundProduct;
    int outboundWeight;
    String outboundDocuments;
    boolean outboundWorkType;
    int takenTimeOutbound;


    /*****************************************************************/
    //retorno
    String returnStartLocation;
    Date returnStartDate;
    String returnStartTime;
    String returnEndLocation;
    Date returnEndDate;
    String returnEndTime;
    String returnProduct;
    int returnWeight;
    String returnDocuments;
    boolean returnWorkType;
    int takenTimeReturn;
    /*****************************************************************/

}

