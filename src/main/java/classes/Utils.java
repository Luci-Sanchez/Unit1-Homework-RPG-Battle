package classes;

import java.util.Scanner;

public class Utils {
    public static boolean isRunning;
    static Scanner scanner = new Scanner(System.in);
    static Party party1;
    static Party party2;

    //////////////////////////////////////////////////////////////////  //////////////////////////////////////////////
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

    //////////////////////////////////////////////////////////////////  //////////////////////////////////////////////
    //method to simulate clearing out the console
    public static void clearConsole() {
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    //////////////////////////////////////////////////////////////////  //////////////////////////////////////////////
    //method to print a separator with length n
    public static void printSeparator(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    //////////////////////////////////////////////////////////////////  //////////////////////////////////////////////

    //method to print a heading
    public static void printHeading(String title) {
        printSeparator(30);
        System.out.println(title);
        printSeparator(30);
    }
    //////////////////////////////////////////////////////////////////  //////////////////////////////////////////////

    //method to stop/pause the game until user enters anything
    public static void anythingToContinue() {
        System.out.println("\nEnter anything to continue...");
        scanner.next();
    }
    //////////////////////////////////////////////////////////////////  //////////////////////////////////////////////

    //method to start the game
    public static void startGame() {
        boolean nameSet = false;
        String name1;
        String name2;
        //print title screen
        clearConsole();
        printSeparator(30);
        System.out.println("Game Started");
        System.out.println("RPG--GAME");
        printSeparator(30);
        anythingToContinue();

        /*//getting the Partyname1
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

        } while (!nameSet);*/

        /*//getting the Partyname2
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

        } while (!nameSet);*/

        //create new player object with the name
        printSeparator(30);
        System.out.println("You are now creating your First Party");
        printSeparator(30);
        party1 = new Party(setName());
        printSeparator(30);
        System.out.println("You are now creating your Second Party");
        printSeparator(30);
        party2 = new Party(setName());

        //create new Battle with the new 2 parties
        Battle newBattle = new Battle(party1, party2);


        //setting isRunning to true, so the game loop can continue
        isRunning = true;

        //start main game loop
        battleLoop();
    }
    //////////////////////////////////////////////////////////////////  //////////////////////////////////////////////

    public static String setName(){
        boolean nameSet = false;
        String name;
        do {
            printHeading("Which name would you like?");
            name = scanner.next();
            //asking the player if he wants to correct his choice
            clearConsole();
            printHeading("Your Party name is " + name + ".\nIs that correct?");
            System.out.println("(1) Yes!");
            System.out.println("(2) No, I want to change the Party name");
            int input = readInt("-> ", 2);
            if (input == 1) {
                nameSet = true;
            }

        } while (!nameSet);
        return name;
    }
    //////////////////////////////////////////////////////////////////  //////////////////////////////////////////////
    public static Character setStats(boolean isWarrior){
        int hp;
        int stamina;
        int strength;
        String name;
        int intelligence;
        int mana;

        if (isWarrior) {
            //Setear lo de Warrior
            name = setName();
            printHeading("Warrior con cuantos Hp?");
            hp = Integer.parseInt(scanner.next());
            printHeading("Warrior con cuanta Stamina?");
            stamina = Integer.parseInt(scanner.next());
            printHeading("Warrior con cuanta Strength?");
            strength = Integer.parseInt(scanner.next());
            Warrior customWarrior = new Warrior(name, hp, stamina, strength);
            printHeading("Warrior CREADO");
            return customWarrior;

        } else {
            //Setear lo de Wizard
            name = setName();
            printHeading("Wizard con cuantos Hp?");
            hp = Integer.parseInt(scanner.next());
            printHeading("Wizard con cuanta Mana?");
            mana = Integer.parseInt(scanner.next());
            printHeading("Wizard con cuanta Intelligence ?");
            intelligence  = Integer.parseInt(scanner.next());
            Wizard customWizard = new Wizard(name, hp, mana, intelligence);
            printHeading("Wizard CREADO");
            return customWizard;
        }

    }
    //////////////////////////////////////////////////////////////////  //////////////////////////////////////////////
    //method to continue journey
    public static void continueJourney() {

    }
    //////////////////////////////////////////////////////////////////  //////////////////////////////////////////////

    //printing out the most important character info
   /* public static void characterInfo() {
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
    }*/

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
    //////////////////////////////////////////////////////////////////  //////////////////////////////////////////////

    // main game loop
    public static void battleLoop() {
        while (isRunning) {
            printPartyTypeMenu();
            int input = readInt("-> ", 3);
            if (input == 1) {
                //importParty();
                System.out.println("ImportPARYY");
            } else if (input == 2) {
                party1.randomMethod();
                party2.randomMethod();
            } else if (input == 3) {
                party1.customMenu();
                party2.customMenu();
                System.out.println("CUSTOMIZADA");

            }
        }
    }
    //////////////////////////////////////////////////////////////////  //////////////////////////////////////////////
    //Custom Menu
    /*public static void customMenu(Party party) {
        int sizeParties=5; //Ver que hacer con el tamaño de la party
        String name = " ";

        //AL final no preguntamos cuanto. Dejamos que agregue hasta cuando quiera y lo limitamos con lo del add

        do {
            clearConsole();
            if(party.getCharacters().size() == 0){
                printHeading("What's your first characters name?");
                setName();

            }else {
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
                break;
            }
        } while (party.getCharacters().size() < sizeParties );



        //create new player object with the name
        party1 = new Party(name1);
        party2 = new Party(name2);

        //create new Battle with the new 2 parties
        Battle newBattle = new Battle(party1, party2);


        //setting isRunning to true, so the game loop can continue
        isRunning = true;

        //start main game loop
        battleLoop();
    }*/
}

