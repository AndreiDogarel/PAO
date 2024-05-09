package model;

import interfaces.GenericClass;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Experience {
    private int id;
    private String jobRole;
    private String companyName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String employmentType;
    private String location;
    private String locationType;
    private boolean currentlyWorking;
    private int userId;

    public Experience() {

    }

    public Experience(int id, String jobRole, String companyName, LocalDate startDate, LocalDate endDate, String employmentType, String location, String locationType, boolean currentlyWorking, int userId) {
        this.id = id;
        this.jobRole = jobRole;
        this.companyName = companyName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employmentType = employmentType;
        this.location = location;
        this.locationType = locationType;
        this.currentlyWorking = currentlyWorking;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public boolean isCurrentlyWorking() {
        return currentlyWorking;
    }

    public void setCurrentlyWorking(boolean currentlyWorking) {
        this.currentlyWorking = currentlyWorking;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "jobRole='" + jobRole + '\'' +
                ", companyName='" + companyName + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", employmentType='" + employmentType + '\'' +
                ", location='" + location + '\'' +
                ", locationType='" + locationType + '\'' +
                ", currentlyWorking=" + currentlyWorking +
                '}';
    }
}
