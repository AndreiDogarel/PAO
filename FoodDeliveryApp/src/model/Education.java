package model;

import interfaces.GenericClass;

import java.time.LocalDate;
import java.util.Scanner;

public class Education implements GenericClass<Education> {
    private String schoolName;
    private String degree;
    private String fieldOfStudy;
    private LocalDate startDate;
    private LocalDate endDate;
    private String grade;

    public Education() {

    }

    public Education(String schoolName, String degree, String fieldOfStudy,
                     LocalDate startDate, LocalDate endDate, String grade) {
        this.schoolName = schoolName;
        this.degree = degree;
        this.fieldOfStudy = fieldOfStudy;
        this.startDate = startDate;
        this.endDate = endDate;
        this.grade = grade;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Education{" +
                "schoolName='" + schoolName + '\'' +
                ", degree='" + degree + '\'' +
                ", fieldOfStudy='" + fieldOfStudy + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", grade='" + grade + '\'' +
                '}';
    }

    @Override
    public void read() {
        Scanner s = new Scanner(System.in);

        System.out.println("Please enter school name: ");
        setSchoolName(s.nextLine());

        System.out.println("Please enter your degree: ");
        setDegree(s.nextLine());

        System.out.println("Please enter your field of study: ");
        setFieldOfStudy(s.nextLine());

        System.out.println("Please enter the start date: ");
        LocalDate date = LocalDate.parse(s.nextLine());
        setStartDate(date);

        System.out.println("Please enter the end date: ");
        date = LocalDate.parse(s.nextLine());
        setEndDate(date);

        System.out.println("Please enter your grade: ");
        setGrade(s.nextLine());
    }

    @Override
    public void update() {
        Scanner s = new Scanner(System.in);

        while(true) {
            System.out.println("""
                    What do you want to change?
                    1. School name
                    2. Degree
                    3. Field of study
                    4. Start date
                    5. End date
                    6. Grade
                    7. Back
                    """);

            int response = s.nextInt();
            if(response == 7) {
                break;
            }
            switch (response) {
                case 1: {
                    setSchoolName(s.nextLine());
                    break;
                }
                case 2: {
                    setDegree(s.nextLine());
                    break;
                }
                case 3: {
                    setFieldOfStudy(s.nextLine());
                    break;
                }
                case 4: {
                    LocalDate date = LocalDate.parse(s.nextLine());
                    setStartDate(date);
                    break;
                }
                case 5: {
                    LocalDate date = LocalDate.parse(s.nextLine());
                    setEndDate(date);
                    break;
                }
                case 6: {
                    setGrade(s.nextLine());
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
