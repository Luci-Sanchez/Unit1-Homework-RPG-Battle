package classes;

import java.util.Scanner;

public class Utils {
    public static boolean isRunning;
    static Scanner scanner = new Scanner(System.in);
    static Party party1;
    static Party party2;

    static Battle newBattle;

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
                System.out.println("Please enter a valid integer!");
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
        //todo print title screen
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

        //naming both parties who will battle
        printSeparator(30);
        System.out.println("You are now creating your First Party");
        printSeparator(30);
        party1 = new Party(setAttribute("Name the First Party which will follow you to battle: ", "Party name"));
        printHeading("Your Party-> " + party1.getPartyName() + "<- is Created");
        printSeparator(30);
        System.out.println("You are now creating your Second Party");
        printSeparator(30);
        party2 = new Party(setAttribute("Name the Second Party which will follow you to battle: ", "Party name"));
        printHeading("Your Party-> " + party2.getPartyName() + "<- is Created");

        //create new Battle with the new 2 parties
        newBattle = new Battle(party1, party2);

        //setting isRunning to true, so the game loop can continue
        isRunning = true;

        //start main game loop
        battleLoop();
    }
    //////////////////////////////////////////////////////////////////  //////////////////////////////////////////////

    public static String setName() {
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
    public static String setAttribute(String header, String attribute) {
        //va en header lo que ve el jugador y attribute
        boolean attributeSet = false;
        String whatWeAreSetting;

        do {
            printHeading(header);
            whatWeAreSetting = scanner.next();
            //asking the player if he wants to correct his choice
            clearConsole();
            printHeading("Your " + attribute + " is " + whatWeAreSetting + ".\nIs that correct?");
            System.out.println("(1) Yes!");
            System.out.println("(2) No, I want to correct it");
            int input = readInt("-> ", 2);
            if (input == 1) {
                attributeSet = true;
            }

        } while (!attributeSet);
        return whatWeAreSetting;
    }

    //////////////////////////////////////////////////////////////////  //////////////////////////////////////////////
    public static Character setStats(boolean isWarrior) {
        int hp;
        int stamina;
        int strength;
        String name = "";
        int intelligence;
        int mana;

        if (isWarrior) {
            //Setear lo de Warrior
            name = setAttribute("Which warrior name would you like?", "warrior's name");
            printHeading("Choose your warrior's Health Points:");
            hp = Integer.parseInt(scanner.next());
            printHeading("Choose your warrior's Stamina:");
            stamina = Integer.parseInt(scanner.next());
            printHeading("Choose your warrior's Strength:");
            strength = Integer.parseInt(scanner.next());
            Warrior customWarrior = new Warrior(name, hp, stamina, strength);
            printHeading("Your warrior has been created successfully!");
            return customWarrior;

        } else {
            //Setear lo de Wizard
            name = setAttribute("Which wizard name would you like?", "wizard's name");
            printHeading("Choose your wizard's Health Points:");
            hp = Integer.parseInt(scanner.next());
            printHeading("Choose your wizard's Mana:");
            mana = Integer.parseInt(scanner.next());
            printHeading("Choose your wizard's Intelligence:");
            intelligence = Integer.parseInt(scanner.next());
            Wizard customWizard = new Wizard(name, hp, mana, intelligence);
            printHeading("Your wizard has been created successfully!");
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
        //clearConsole();
        //printHeading("MENU");
        printHeading("PartyTypeMenu");
        System.out.println("Choose a Party type:");
        printSeparator(20);
        System.out.println("(1) Import Party");
        System.out.println("(2) Random Party");
        System.out.println("(3) Custom Party");
    }
    ////////////////////////////////////////////////////////////////// BATTLE LOOP //////////////////////////////////////////////

    // main game loop
    public static void battleLoop() {
        Duel newDuel = null;
        System.out.println("In the Battle loop");
        boolean arePartiesSet = false;
        int numberOfSetParties = 1;

        //while (numberOfSetParties<=2) {
        System.out.println("In the While loop of Battleloop");
        printPartyTypeMenu();
        int input = readInt("-> ", 3);
        if (input == 1) {
            //importParty();
            System.out.println("ImportPARYY");
            // break;
        } else if (input == 2) {
            System.out.println("Lets Create party1 with random Method");
            party1.randomMethod();
            printSeparator(30);
            System.out.println("Party1 random Created");
            System.out.println(party1.toString());
            printSeparator(30);

            System.out.println("Lets Create party2 with ransom Method");
            party2.randomMethod();
            printSeparator(30);
            System.out.println("Party2 random Created");
            System.out.println(party2.toString());
            printSeparator(30);

        } else if (input == 3) {
            party1.customMethod();
            System.out.println(party1.toString());

            party2.customMethod();
            System.out.println(party2.toString());
            // break;
        } else {
            System.out.println("Select 1, 2 or 3 !!");
            printPartyTypeMenu();
        }

        //Only allow players to continue if party size is bigger than 1 and smaller or equal to 5
        if (party1.getCharacters().size() <= 5 && party2.getCharacters().size() <= 5
                && party1.getCharacters().size() > 1 && party2.getCharacters().size() > 1) {

            printHeading("Choose the brave combatants who will duel for the golden script");
             newDuel = new Duel(selectCombatant(party1), selectCombatant(party2));


        }

        //setting isRunning to true, so the game loop can continue
        isRunning = true;

        //start main game loop
        duelLoop(newDuel);

    }



    //////////////////////////////////////////////////////////////////  //////////////////////////////////////////////

    public static void duelLoop(Duel duel){
        printHeading("THE BATTLE HAS BEGUN");
        printHeading( duel.getCurrentCombatant1().getName() + " the " + duel.getCurrentCombatant1().getClass().getSimpleName()
                + " from the " + party1.getPartyName() + " party  -VS- " + duel.getCurrentCombatant2().getName() + " the " + duel.getCurrentCombatant2().getClass().getSimpleName()
                + " from the " + party2.getPartyName() + " party");
        anythingToContinue();

        while(duel.getCurrentCombatant1().isAlive() && duel.getCurrentCombatant2().isAlive()){

            if(duel.getCurrentCombatant1().getClass().getSimpleName().equals("Warrior")){
                Warrior charToWArr = (Warrior) duel.getCurrentCombatant1();
                if(charToWArr.getStamina() >= 5){
                    charToWArr.bigAttack(duel.getCurrentCombatant2());
                    printHeading(duel.getCurrentCombatant1().getName() + " the Mighty Warrior used Heavy Attack!");
                }else{
                    charToWArr.smallAttack(duel.getCurrentCombatant2());
                    printHeading(duel.getCurrentCombatant1().getName() + " the Mighty Warrior used Weak Attack!");
                }
            }else if(duel.getCurrentCombatant1().getClass().getSimpleName().equals("Wizard")){
                Wizard charToWizz = (Wizard) duel.getCurrentCombatant1();
                if(charToWizz.getMana() >= 5){
                    charToWizz.bigAttack(duel.getCurrentCombatant2());
                    printHeading(duel.getCurrentCombatant1().getName() + " the Mystical Wizard used Fireball!");
                }else{
                    charToWizz.smallAttack(duel.getCurrentCombatant2());
                    printHeading(duel.getCurrentCombatant1().getName() + " the Mystical Wizard used Staff Hit");
                }
            }


            if(duel.getCurrentCombatant2().getClass().getSimpleName().equals("Warrior")){
                Warrior charToWArr = (Warrior) duel.getCurrentCombatant2();
                if(charToWArr.getStamina() >= 5){
                    charToWArr.bigAttack(duel.getCurrentCombatant1());
                    printHeading(duel.getCurrentCombatant2().getName() + " the Mighty Warrior used Heavy Attack!");
                }else{
                    charToWArr.smallAttack(duel.getCurrentCombatant1());
                    printHeading(duel.getCurrentCombatant2().getName() + " the Mighty Warrior used Weak Attack!");
                }
            }else if(duel.getCurrentCombatant2().getClass().getSimpleName().equals("Wizard")){
                Wizard charToWizz = (Wizard) duel.getCurrentCombatant1();
                if(charToWizz.getMana() >= 5){
                    charToWizz.bigAttack(duel.getCurrentCombatant1());
                    printHeading(duel.getCurrentCombatant2().getName() + " the Mystical Wizard used Fireball!");
                }else{
                    charToWizz.smallAttack(duel.getCurrentCombatant1());
                    printHeading(duel.getCurrentCombatant2().getName() + " the Mystical Wizard used  Staff Hit!");
                }
            }
            System.out.println("Check your combatants status");
            anythingToContinue();
            printHeading("STATUS: \n" + duel.getCurrentCombatant1().toString() + "\n" + duel.getCurrentCombatant2().toString());

            duel.getCurrentCombatant1().setAlive();
            duel.getCurrentCombatant2().setAlive();

            System.out.println(duel.getCurrentCombatant1().isAlive() + " " + duel.getCurrentCombatant2().isAlive());
            anythingToContinue();
        }
        if(duel.getCurrentCombatant1().isAlive() && !duel.getCurrentCombatant2().isAlive()){
            clearConsole();
            System.out.println(duel.getCurrentCombatant1().getName() + " has demolished " + duel.getCurrentCombatant2().getName());
            System.out.println(duel.getCurrentCombatant1().getName() + " IS THE WINNER OF THE DUEL!");

            newBattle.getGraveyard().add(duel.getCurrentCombatant2());
            System.out.println(duel.getCurrentCombatant2().getName() + " has been sent to the Graveyard.");
            party2.removeCharacter(duel.getCurrentCombatant2());

        }else if(duel.getCurrentCombatant2().isAlive() && !duel.getCurrentCombatant1().isAlive()){
            clearConsole();
            System.out.println(duel.getCurrentCombatant2().getName() + " has demolished " + duel.getCurrentCombatant1().getName());
            System.out.println(duel.getCurrentCombatant2().getName() + " IS THE WINNER OF THE DUEL!");

            newBattle.getGraveyard().add(duel.getCurrentCombatant1());
            System.out.println(duel.getCurrentCombatant1().getName() + " has been sent to the Graveyard.");
            party1.removeCharacter(duel.getCurrentCombatant1());

        }else if(!duel.getCurrentCombatant2().isAlive() && !duel.getCurrentCombatant1().isAlive()) {
            clearConsole();
            System.out.println(duel.getCurrentCombatant2().getName() + " & " + duel.getCurrentCombatant1().getName() + " are both demolished");
            System.out.println("THE DUEL IS A TIE!");

            newBattle.getGraveyard().add(duel.getCurrentCombatant1());
            newBattle.getGraveyard().add(duel.getCurrentCombatant2());
            System.out.println("Both " + duel.getCurrentCombatant1().getName() + " & " + duel.getCurrentCombatant2().getName()+ " have been sent to the Graveyard.");
            party1.removeCharacter(duel.getCurrentCombatant1());
            party2.removeCharacter(duel.getCurrentCombatant2());
        }
        anythingToContinue();
        newBattle.showGraveyard();
        anythingToContinue();

        printHeading("Choose the brave combatants who will duel for the golden script");
        Duel newDuel = new Duel(selectCombatant(party1), selectCombatant(party2));

        duelLoop(newDuel);
    }


    //////////////////////////////////////////////////////////////////  //////////////////////////////////////////////

    // method to select a combatant of each party to send to the duel
    public static Character selectCombatant(Party party) {
        Character currentCombatant = null;
        boolean isCombatantSet = false;

        while (!isCombatantSet) {
            System.out.println("Choose combatant from the " + party.getPartyName() + "Party");
            printSeparator(20);

            for (int i = 0; i < party.getCharacters().size(); i++) {
                int menuItemNumber = i + 1;
                System.out.println("(" + menuItemNumber + ")" + party.getCharacters().get(i).toString());
            }

            int input = readInt("-> ", party.getCharacters().size() + 1);

            currentCombatant = party.getCharacters().get((int) input - 1);

            isCombatantSet = true;
        }

        System.out.println("Your character selected is " + currentCombatant);

        return currentCombatant;

    }

    //////////////////////////////////////////////////////////////////  //////////////////////////////////////////////

}

