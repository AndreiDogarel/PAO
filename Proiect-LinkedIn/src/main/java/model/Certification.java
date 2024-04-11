package model;

import interfaces.GenericClass;

import java.time.LocalDate;
import java.util.Scanner;

public class Certification implements GenericClass<Certification> {
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

    @Override
    public void read() {
        Scanner s = new Scanner(System.in);

        System.out.println("Please enter your certification name: ");
        setName(s.nextLine());

        System.out.println("Please enter your issuing organization: ");
        setIssuingOrganization(s.nextLine());

        System.out.println("Please enter your start date: ");
        LocalDate date = LocalDate.parse(s.nextLine());
        setStartDate(date);

        System.out.println("Please enter your expiration date: ");
        date = LocalDate.parse(s.nextLine());
        setEndDate(date);
    }

    @Override
    public void update() {
        Scanner s = new Scanner(System.in);

        while(true) {
            System.out.println("""
                    What do you want to change?
                    1. Certification name
                    2. Issuing organization
                    3. Start date
                    4. End date
                    5. Back
                    """);

            int response = s.nextInt();
            s.nextLine();
            if(response == 5) {
                break;
            }
            switch (response) {
                case 1: {
                    System.out.println("Please enter the new certification name: ");
                    setName(s.nextLine());
                    break;
                }
                case 2: {
                    System.out.println("Please enter the new issuing company name: ");
                    setIssuingOrganization(s.nextLine());
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
                default: {
                    System.out.println("Unknown command");
                    break;
                }
            }
        }
    }
}
