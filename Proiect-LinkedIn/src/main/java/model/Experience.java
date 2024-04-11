package model;

import interfaces.GenericClass;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Experience implements GenericClass<Experience> {
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

    @Override
    public void read() {
        Scanner s = new Scanner(System.in);

        System.out.println("Please enter your role: ");
        setJobRole(s.nextLine());

        System.out.println("Please enter the company name: ");
        setCompanyName(s.nextLine());

        System.out.println("Please enter your start date (yyyy-mm-dd): ");
        LocalDate date = LocalDate.parse(s.nextLine());
        setStartDate(date);

        System.out.println("Please enter your end date (yyyy-mm-dd): ");
        date = LocalDate.parse(s.nextLine());
        setEndDate(date);

        System.out.println("Please enter your employment type: ");
        setEmploymentType(s.nextLine());

        System.out.println("Please enter your job location");
        setLocation(s.nextLine());

        System.out.println("Please enter your job location type: ");
        setLocationType(s.nextLine());

        System.out.println("Are you currently working at this job? (yes/no): ");
        String response = s.nextLine();
        setCurrentlyWorking(response.equalsIgnoreCase("yes"));
    }

    @Override
    public void update() {
        Scanner s = new Scanner(System.in);

        while(true) {
            System.out.println("""
                    What do you want to change?
                    1. Job role
                    2. Company name
                    3. Start date
                    4. End date
                    5. Employment type
                    6. Job location
                    7. Job location type
                    8. Back
                    """);

            int response = s.nextInt();
            s.nextLine();
            if(response == 8) {
                break;
            }
            switch (response) {
                case 1: {
                    System.out.println("Please enter the new job role: ");
                    setJobRole(s.nextLine());
                    break;
                }
                case 2: {
                    System.out.println("Please enter the new company name: ");
                    setCompanyName(s.nextLine());
                    break;
                }
                case 3: {
                    System.out.println("Please enter the new start date: ");
                    LocalDate date = LocalDate.parse(s.nextLine());
                    setStartDate(date);
                    break;
                }
                case 4: {
                    System.out.println("Please enter the new end date: ");
                    LocalDate date = LocalDate.parse(s.nextLine());
                    setEndDate(date);
                    break;
                }
                case 5: {
                    System.out.println("Please enter the new employment type: ");
                    setEmploymentType(s.nextLine());
                    break;
                }
                case 6: {
                    System.out.println("Please enter the new location: ");
                    setLocation(s.nextLine());
                    break;
                }
                case 7: {
                    System.out.println("Please enter the new location type: ");
                    setLocationType(s.nextLine());
                    break;
                }
                default: {
                    System.out.println("Unknown command");
                    break;
                }
            }
        }
    }
}
