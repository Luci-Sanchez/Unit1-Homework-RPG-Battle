package classes;

import java.util.Scanner;

public class Utils {
    public static boolean isRunning;
    static Scanner scanner = new Scanner(System.in);
    static Party party1;
    static Party party2;

    //method to get user input from console
    public static int readInt(String prompt, int userChoices) {
        int input;

        do {
            System.out.println(prompt);
            try {
                input = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                input = -1;
                System.out.println("Please enter an integer!");
            }
        } while (input < 1 || input > userChoices);
        return input;
    }

    //method to simulate clearing out the console
    public static void clearConsole() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    //method to print a separator with length n
    public static void printSeparator(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    //method to print a heading
    public static void printHeading(String title) {
        printSeparator(30);
        System.out.println(title);
        printSeparator(30);
    }

    //method to stop/pause the game until user enters anything
    public static void anythingToContinue() {
        System.out.println("\nEnter anything to continue...");
        scanner.next();
    }


    //method to start the game
    public static void startGame() {
        boolean nameSet = false;
        String name1;
        String name2;
        //print title screen
        clearConsole();
        printSeparator(40);
        printSeparator(30);
        System.out.println("AGE OF THE EVIL EMPEROR");
        System.out.println("TEXT RPG BY FRED FOR CODESTUDENT.NET");
        printSeparator(30);
        printSeparator(40);
        anythingToContinue();

        //getting the Partyname1
        do {
            clearConsole();
            printHeading("What's your first Party name?");
            name1 = scanner.next();
            //asking the player if he wants to correct his choice
            clearConsole();
            printHeading("Your Party name is " + name1 + ".\nIs that correct?");
            System.out.println("(1) Yes!");
            System.out.println("(2) No, I want to change the Party name");
            int input = readInt("-> ", 2);
            if (input == 1) {
                nameSet = true;
            }

        } while (!nameSet);

        //getting the Partyname2
        nameSet = false;
        do {
            clearConsole();
            printHeading("What's your second Party name?");
            name2 = scanner.next();
            //asking the player if he wants to correct his choice
            clearConsole();
            printHeading("Your Party name is " + name2 + ".\nIs that correct?");
            System.out.println("(1) Yes!");
            System.out.println("(2) No, I want to change the Party name");
            int input = readInt("-> ", 2);
            if (input == 1) {
                nameSet = true;
            }

        } while (!nameSet);

        //create new player object with the name
        party1 = new Party(name1);
        party2 = new Party(name2);

        //create new Battle with the new 2 parties
        Battle newBattle = new Battle(party1, party2);


        //setting isRunning to true, so the game loop can continue
        isRunning = true;

        //start main game loop
        battleLoop();
    }

    //TODO Party Type Menu


    //method to continue journey
    public static void continueJourney() {

    }

    //printing out the most important character info
    public static void characterInfo() {
        clearConsole();
        printHeading("CHARACTER INFO");
        System.out.println(player.name + "\tHP: " + player.hp + "/" + player.maxHp);
        printSeparator(20);
        System.out.println("XP: " + player.xp + "/");

        //printing the chosen traits
        if (player.numAtkUpgrades > 0) {
            System.out.println("Offensive trait: " + player.atkUpgrades[player.numAtkUpgrades - 1]);
            printSeparator(20);
        }
        if (player.numDefUpgrades > 0) {
            System.out.println("Defensive trait: " + player.defUpgrades[player.numDefUpgrades - 1]);
            printSeparator(20);
        }
        anythingToContinue();
    }

    //printing the party type menu
    public static void printPartyTypeMenu() {
        clearConsole();
        printHeading("MENU");
        System.out.println("Choose a Party type:");
        printSeparator(20);
        System.out.println("(1) Import Party");
        System.out.println("(2) Random Party");
        System.out.println("(3) Custom Party");
    }

    // main game loop
    public static void battleLoop() {
        while (isRunning) {
            printPartyTypeMenu();
            int input = readInt("-> ", 3);
            if (input == 1) {
                importParty();
            } else if (input == 2) {
                party1.randomMethod();
                party2.randomMethod();
            } else if (input == 3) {
                customMenu(party1);
                customMenu(party2);

            }
        }

    }

    //Custom Menu
    public static void customMenu(Party party) {
        clearConsole();
        printHeading("How many Characters?");
        name1 = scanner.next();
        //asking the player if he wants to correct his choice
        clearConsole();
        //getting the Partyname1
        do {
            clearConsole();
            printHeading("What's your first Party name?");
            name1 = scanner.next();
            //asking the player if he wants to correct his choice
            clearConsole();
            printHeading("Your Party name is " + name1 + ".\nIs that correct?");
            System.out.println("(1) Yes!");
            System.out.println("(2) No, I want to change the Party name");
            int input = readInt("-> ", 2);
            if (input == 1) {
                nameSet = true;
            }

        } while (!nameSet);

        //getting the Partyname2
        nameSet = false;
        do {
            clearConsole();
            printHeading("What's your second Party name?");
            name2 = scanner.next();
            //asking the player if he wants to correct his choice
            clearConsole();
            printHeading("Your Party name is " + name2 + ".\nIs that correct?");
            System.out.println("(1) Yes!");
            System.out.println("(2) No, I want to change the Party name");
            int input = readInt("-> ", 2);
            if (input == 1) {
                nameSet = true;
            }

        } while (!nameSet);

        //create new player object with the name
        party1 = new Party(name1);
        party2 = new Party(name2);

        //create new Battle with the new 2 parties
        Battle newBattle = new Battle(party1, party2);


        //setting isRunning to true, so the game loop can continue
        isRunning = true;

        //start main game loop
        battleLoop();
    }
}

