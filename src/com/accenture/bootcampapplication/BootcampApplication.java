package com.accenture.bootcampapplication;

import java.util.Scanner;

public class BootcampApplication {

    static String[] bootcampList = bootcampTypeList();
    static Bootcamp[] bootcamps = instantiationOfBootcamps(bootcampList);

    public static void main(String... args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello, welcome to bootcamp application page!");
        Bootcamp java = new Bootcamp(bootcampList[0], "11.12.2018.", "10.01.2018.");
        System.out.println("You can apply to any of these bootcamps: ");
        for (String bootcampType : bootcampTypeList()) {
            System.out.println(bootcampType);
        }
        entry(scanner);
        entry(scanner);
        entry(scanner);
        entry(scanner);
        entry(scanner);

        System.out.println("Print out all bootcampers");
        bootcampParticipantOut();


    }

    public static void entry(Scanner scanner) {
        System.out.println("Enter your name");
        String name = scanner.next();
        System.out.println("Enter your bootcamp type");
        String bootcampType = scanner.next();
        System.out.println("Your name is: " + name);
        System.out.println("Your bootcamp is: " + bootcampType);
        addParticipant(bootcampType, name);
    }




    public static void bootcampParticipantOut() {
        for(int i = 0; i < bootcamps.length; i++) {
            System.out.println(bootcamps[i].getType());
            for(int j = 0; j < bootcamps[i].getParticipantName().length; j++){
                System.out.println(bootcamps[i].getParticipantName()[j]);
            }
        }
    }


    public static String[] bootcampTypeList() {
        String[] bootcampTypes = {"Java", "Test Automation", "DevOps", "CRM"};
        return bootcampTypes;
    }

    public static Bootcamp[] instantiationOfBootcamps(String[] bootcampList) {
        Bootcamp[] bootcamps = new Bootcamp[bootcampList.length];
        for (int i = 0; i < bootcampList.length; i++) {
            Bootcamp bootcamp = new Bootcamp(bootcampList[i], "11.12.2018.", "10.01.2018.");
            bootcamps[i] = bootcamp;
        }


        return bootcamps;
    }

    public static void addParticipant(String bootcampType, String name) {
        boolean assignToBootcamp = false;
        for (int i = 0; i < bootcamps.length; i++) {
            if (bootcamps[i].getType().equals(bootcampType)) {
                String[] names = {name};
                bootcamps[i].setParticipantName(names);
                System.out.println("you joined bootcamp!");
                assignToBootcamp = true;
            }
            if (i == bootcamps.length - 1 && assignToBootcamp == false) {
                System.out.println("Sorry, we don't have such bootcamp!");
            }
        }

    }


}
