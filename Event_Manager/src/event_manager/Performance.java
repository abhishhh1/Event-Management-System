/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event_manager;

/**
 *
 * @author abhishhh1
 */
public class Performance {
    private String performanceId;
    private int noOfMembers;
    private int batchYear;
    private String performanceType;
    private int marks1, marks2, marks3;

    public Performance(String performanceId, int noOfMembers, int batchYear, String performanceType) {
        this.performanceId = performanceId;
        this.noOfMembers = noOfMembers;
        this.batchYear = batchYear;
        this.performanceType = performanceType;
    }

    public Performance(String performanceId, int noOfMembers, int batchYear, String performanceType, int marks1, int marks2, int marks3) {
        this(performanceId, noOfMembers, batchYear, performanceType);
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;
    }

    public String getPerformanceId() {
        return performanceId;
    }

    public void setPerformanceId(String performanceId) {
        this.performanceId = performanceId;
    }

    public int getNoOfMembers() {
        return noOfMembers;
    }

    public void setNoOfMembers(int noOfMembers) {
        this.noOfMembers = noOfMembers;
    }

    public int getBatchYear() {
        return batchYear;
    }

    public void setBatchYear(int batchYear) {
        this.batchYear = batchYear;
    }

    public String getPerformanceType() {
        return performanceType;
    }

    public void setPerformanceType(String performanceType) {
        this.performanceType = performanceType;
    }

    public int getMarks1() {
        return marks1;
    }

    public void setMarks1(int marks1) {
        this.marks1 = marks1;
    }

    public int getMarks2() {
        return marks2;
    }

    public void setMarks2(int marks2) {
        this.marks2 = marks2;
    }

    public int getMarks3() {
        return marks3;
    }

    public void setMarks3(int marks3) {
        this.marks3 = marks3;
    }

    @Override
    public String toString() {
        return "Performance{" +
                "performanceId=" + performanceId +
                ", noOfMembers=" + noOfMembers +
                ", batchYear=" + batchYear +
                ", performanceType='" + performanceType + '\'' +
                ", marks1=" + marks1 +
                ", marks2=" + marks2 +
                ", marks3=" + marks3 +
                '}';
    }
}
