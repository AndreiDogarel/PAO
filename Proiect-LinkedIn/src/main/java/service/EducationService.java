package service;

import interfaces.GenericService;
import model.Education;

import java.time.LocalDate;
import java.util.Scanner;

public class EducationService implements GenericService<Education> {
    @Override
    public Education read() {
        Education education = new Education();
        Scanner s = new Scanner(System.in);

        System.out.println("Please enter school name: ");
        education.setSchoolName(s.nextLine());

        System.out.println("Please enter your degree: ");
        education.setDegree(s.nextLine());

        System.out.println("Please enter your field of study: ");
        education.setFieldOfStudy(s.nextLine());

        System.out.println("Please enter the start date: ");
        LocalDate date = LocalDate.parse(s.nextLine());
        education.setStartDate(date);

        System.out.println("Please enter the end date: ");
        date = LocalDate.parse(s.nextLine());
        education.setEndDate(date);

        System.out.println("Please enter your grade: ");
        education.setGrade(s.nextLine());

        return education;
    }

    @Override
    public void update(Education education) {
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
                    education.setSchoolName(s.nextLine());
                    break;
                }
                case 2: {
                    System.out.println("Please enter the new degree: ");
                    education.setDegree(s.nextLine());
                    break;
                }
                case 3: {
                    System.out.println("Please enter the new field of study name: ");
                    education.setFieldOfStudy(s.nextLine());
                    break;
                }
                case 4: {
                    System.out.println("Please enter the new start date: ");
                    LocalDate date = LocalDate.parse(s.nextLine());
                    education.setStartDate(date);
                    break;
                }
                case 5: {
                    System.out.println("Please enter the new end date: ");
                    LocalDate date = LocalDate.parse(s.nextLine());
                    education.setEndDate(date);
                    break;
                }
                case 6: {
                    System.out.println("Please enter the new grade: ");
                    education.setGrade(s.nextLine());
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
