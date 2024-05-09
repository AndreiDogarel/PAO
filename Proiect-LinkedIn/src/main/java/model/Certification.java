package model;

import interfaces.GenericClass;

import java.time.LocalDate;
import java.util.Scanner;

public class Certification {
    private int id;
    private String name;
    private String issuingOrganization;
    private LocalDate startDate;
    private LocalDate endDate;
    private int userId;

    public Certification() {

    }

    public Certification(int id, String name, String issuingOrganization, LocalDate startDate, LocalDate endDate, int userId) {
        this.id = id;
        this.name = name;
        this.issuingOrganization = issuingOrganization;
        this.startDate = startDate;
        this.endDate = endDate;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIssuingOrganization() {
        return issuingOrganization;
    }

    public void setIssuingOrganization(String issuingOrganization) {
        this.issuingOrganization = issuingOrganization;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Certification{" +
                "name='" + name + '\'' +
                ", issuingOrganization='" + issuingOrganization + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
