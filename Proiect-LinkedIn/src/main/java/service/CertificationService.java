package service;

import interfaces.GenericService;
import model.Certification;

import java.time.LocalDate;
import java.util.Scanner;

public class CertificationService implements GenericService<Certification> {
    @Override
    public Certification read() {
        Certification certification = new Certification();
        Scanner s = new Scanner(System.in);

        System.out.println("Please enter your certification name: ");
        certification.setName(s.nextLine());

        System.out.println("Please enter your issuing organization: ");
        certification.setIssuingOrganization(s.nextLine());

        System.out.println("Please enter your start date: ");
        LocalDate date = LocalDate.parse(s.nextLine());
        certification.setStartDate(date);

        System.out.println("Please enter your expiration date: ");
        date = LocalDate.parse(s.nextLine());
        certification.setEndDate(date);

        return certification;
    }

    @Override
    public void update(Certification certification) {
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
                    certification.setName(s.nextLine());
                    break;
                }
                case 2: {
                    System.out.println("Please enter the new issuing company name: ");
                    certification.setIssuingOrganization(s.nextLine());
                    break;
                }
                case 3: {
                    System.out.println("Please enter the new start date: ");
                    LocalDate date = LocalDate.parse(s.nextLine());
                    certification.setStartDate(date);
                    break;
                }
                case 4: {
                    System.out.println("Please enter the new end date: ");
                    LocalDate date = LocalDate.parse(s.nextLine());
                    certification.setEndDate(date);
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
