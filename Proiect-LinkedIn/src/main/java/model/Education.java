package model;

import interfaces.GenericClass;

import java.time.LocalDate;
import java.util.Scanner;

public class Education implements GenericClass<Education> {
    private int id;
    private String schoolName;
    private String degree;
    private String fieldOfStudy;
    private LocalDate startDate;
    private LocalDate endDate;
    private String grade;
    private int userId;

    public Education() {

    }

    public Education(int id, String schoolName, String degree, String fieldOfStudy, LocalDate startDate, LocalDate endDate, String grade, int userId) {
        this.id = id;
        this.schoolName = schoolName;
        this.degree = degree;
        this.fieldOfStudy = fieldOfStudy;
        this.startDate = startDate;
        this.endDate = endDate;
        this.grade = grade;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
            s.nextLine();
            if(response == 7) {
                break;
            }
            switch (response) {
                case 1: {
                    System.out.println("Please enter the new school name: ");
                    setSchoolName(s.nextLine());
                    break;
                }
                case 2: {
                    System.out.println("Please enter the new degree: ");
                    setDegree(s.nextLine());
                    break;
                }
                case 3: {
                    System.out.println("Please enter the new field of study name: ");
                    setFieldOfStudy(s.nextLine());
                    break;
                }
                case 4: {
                    System.out.println("Please enter the new start date: ");
                    LocalDate date = LocalDate.parse(s.nextLine());
                    setStartDate(date);
                    break;
                }
                case 5: {
                    System.out.println("Please enter the new end date: ");
                    LocalDate date = LocalDate.parse(s.nextLine());
                    setEndDate(date);
                    break;
                }
                case 6: {
                    System.out.println("Please enter the new grade: ");
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
