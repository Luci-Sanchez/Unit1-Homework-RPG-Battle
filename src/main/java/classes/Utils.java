package classes;

import java.util.Scanner;

public class Utils {
    public static boolean isRunning;
    static Scanner scanner = new Scanner(System.in);
    static Party party1;
    static Party party2;

    static Battle newBattle;

    static String title = "%&.\n" +
            "     @@@@@@@   @@@@, &@@@@@@%@@@@@@ @@#   #@@@@@*   %@@@/               @@@@@@(%@@\n" +
            "   .@@( #@@  %@@@@/  .@@%    @@&  #@@    @@@      &@@&&  ,(#   *** %    #@@,  @@& #%    #(*\n" +
            "   &@@@@@@  @@ @@#  @@@    &@@   @@@   .@@@@@,   @@@@&&@@@@@% @@@@&    @@@  ,@@@@@@% @@&(@&\n" +
            " @@@  @@% @@@@@@%  @@@    @@@  .@@,   @@@.      @@& (@@  @@%#@@      .@@%  @@@  @@/@@@@@@#\n" +
            "/@@@@@@@ @@&..@@& /@@   *@@/  &@@@@@ @@@@@@   .@@. /@@@@@@ @@&      @@@   @@/ #@@ @@@@@@\n" +
            "*#%%(   ,,,   ,,, ,,,    ,,,   ,,,,,,.,,,,,.   ,,,    *(    ,,       ,,,  .,,  ,,,   ((\n" +
            "@@@@@*  @@@@@@/  @@(   &@@@@@@  .@@@@@& @@@   @@    @@@@@*  @@@@@ &@@@@@@  @@@ @@@@@@& @@@@@@\n" +
            "   %@@/    (@@#  @@@ %@@    @@@ .@@@ &@@.   /@@@@ &@%   @@@    #@@(    @@&  @@ (@@. @@% %@@  @@@\n" +
            "   @@#  ,% @@&   @@@ @@&   *@@.  @@@ @@@@@% @@@@@@@@    &@@@@% @@&    *@@@@@@  @@@ (@@@@@@   @@&\n" +
            "  .@@@ %@%.@@@  @@@ *@@.   @@@  @@@ (@@#    @@ @@@@@       @@@ @@@    @@@*@@  .@@% @@@      &@@\n" +
            "   &@@@@@  &@@@@@@  @@@@@@ @@@@@@@  @@@@@@ &@%  @@@,   @@@@@@  &@@@@@ @@#.@@@,&@@  @@*      @@@";

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////Method to get user input from console////////////////////////////////
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

    //////////////////////////////////////////////Method to simulate clearing out the console///////////////////////
    public static void clearConsole() {
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    //////////////////////////////////////////////Method to print a separator with length n//////////////////////////
    public static void printSeparator(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    ///////////////////////////////////////////////Method to print a heading/////////////////////////////////////////
    public static void printHeading(String title) {
        printSeparator(30);
        System.out.println(title);
        printSeparator(30);
    }


    ///////////////////////////////////Method to pause the game until user enters anything/////////////////////////////
    public static void anythingToContinue() {
        System.out.println("\nEnter anything to continue...");
        scanner.next();
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////// START GAME///////////////////////////////////////////////////////
    public static void startGame() {
        System.out.println(title);
        clearConsole();

        printSeparator(30);
        System.out.println("Game Started");
        System.out.println("RPG--GAME");
        printSeparator(30);

        anythingToContinue();
        //Naming both parties who will battle
        clearConsole();

        printSeparator(30);
        System.out.println("You are now creating your First Party");
        printSeparator(30);
        party1 = new Party(setAttribute("Name the First Party which will follow you to battle: ",
                "Party name"));
        printSeparator(30);
        clearConsole();
        printHeading("The name of your first Party is --> " + party1.getPartyName() + " <--");
        printSeparator(30);
        printHeading("Are you raady to create the second party?");
        anythingToContinue();
        clearConsole();
        printSeparator(30);
        System.out.println("You are now creating your Second Party");
        printSeparator(30);
        party2 = new Party(setAttribute("Name the Second Party which will follow you to battle: ",
                "Party name"));
        clearConsole();
        printHeading("The name of your second Party is --> " + party2.getPartyName() + " <--");
        anythingToContinue();

        //create new Battle with the new 2 parties
        newBattle = new Battle(party1, party2);

        //setting isRunning to true, so the game loop can continue
        isRunning = true;

        //start main game loop
        battleLoop();
    }

    ////////////////////////////////////////////// BATTLE LOOP ////////////////////////////////////////////////////////
    public static void battleLoop() {
        Duel newDuel = null;

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

            anythingToContinue();

            clearConsole();
            System.out.println("Lets Create party2 with random Method");
            party2.randomMethod();
            printSeparator(30);
            System.out.println("Party2 random Created");
            System.out.println(party2.toString());

            anythingToContinue();
            clearConsole();

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

    /////////////////////////////////////////////////// DUEL LOOP //////////////////////////////////////////////////////
    public static void duelLoop(Duel duel) {
        printHeading("THE BATTLE HAS BEGUN");
        printHeading(duel.getCurrentCombatant1().getName() + " the " +
                duel.getCurrentCombatant1().getClass().getSimpleName()
                + " from the " + party1.getPartyName() + " party  -VS- " +
                duel.getCurrentCombatant2().getName() + " the " +
                duel.getCurrentCombatant2().getClass().getSimpleName()
                + " from the " + party2.getPartyName() + " party");
        anythingToContinue();

        while (duel.getCurrentCombatant1().isAlive() && duel.getCurrentCombatant2().isAlive()) {

            if (duel.getCurrentCombatant1().getClass().getSimpleName().equals("Warrior")) {
                Warrior charToWArr = (Warrior) duel.getCurrentCombatant1();
                if (charToWArr.getStamina() >= 5) {
                    charToWArr.bigAttack(duel.getCurrentCombatant2());
                    printHeading(duel.getCurrentCombatant1().getName() + " the Mighty Warrior used Heavy Attack!");
                } else {
                    charToWArr.smallAttack(duel.getCurrentCombatant2());
                    printHeading(duel.getCurrentCombatant1().getName() + " the Mighty Warrior used Weak Attack!");
                }
            } else if (duel.getCurrentCombatant1().getClass().getSimpleName().equals("Wizard")) {
                Wizard charToWizz = (Wizard) duel.getCurrentCombatant1();
                if (charToWizz.getMana() >= 5) {
                    charToWizz.bigAttack(duel.getCurrentCombatant2());
                    printHeading(duel.getCurrentCombatant1().getName() + " the Mystical Wizard used Fireball!");
                } else {
                    charToWizz.smallAttack(duel.getCurrentCombatant2());
                    printHeading(duel.getCurrentCombatant1().getName() + " the Mystical Wizard used Staff Hit");
                }
            }


            if (duel.getCurrentCombatant2().getClass().getSimpleName().equals("Warrior")) {
                Warrior charToWArr = (Warrior) duel.getCurrentCombatant2();
                if (charToWArr.getStamina() >= 5) {
                    charToWArr.bigAttack(duel.getCurrentCombatant1());
                    printHeading(duel.getCurrentCombatant2().getName() + " the Mighty Warrior used Heavy Attack!");
                } else {
                    charToWArr.smallAttack(duel.getCurrentCombatant1());
                    printHeading(duel.getCurrentCombatant2().getName() + " the Mighty Warrior used Weak Attack!");
                }
            } else if (duel.getCurrentCombatant2().getClass().getSimpleName().equals("Wizard")) {
                Wizard charToWizz = (Wizard) duel.getCurrentCombatant1();
                if (charToWizz.getMana() >= 5) {
                    charToWizz.bigAttack(duel.getCurrentCombatant1());
                    printHeading(duel.getCurrentCombatant2().getName() + " the Mystical Wizard used Fireball!");
                } else {
                    charToWizz.smallAttack(duel.getCurrentCombatant1());
                    printHeading(duel.getCurrentCombatant2().getName() + " the Mystical Wizard used  Staff Hit!");
                }
            }
            System.out.println("Check your combatants status");
            anythingToContinue();
            printHeading("STATUS: \n" + duel.getCurrentCombatant1().toString() + "\n" +
                    duel.getCurrentCombatant2().toString());

            duel.getCurrentCombatant1().setAlive();
            duel.getCurrentCombatant2().setAlive();

            System.out.println(duel.getCurrentCombatant1().isAlive() + " " + duel.getCurrentCombatant2().isAlive());
            anythingToContinue();
        }
        if (duel.getCurrentCombatant1().isAlive() && !duel.getCurrentCombatant2().isAlive()) {
            clearConsole();
            System.out.println(duel.getCurrentCombatant1().getName() + " has demolished " +
                    duel.getCurrentCombatant2().getName());
            System.out.println(duel.getCurrentCombatant1().getName() + " IS THE WINNER OF THE DUEL!");

            newBattle.getGraveyard().add(duel.getCurrentCombatant2());
            System.out.println(duel.getCurrentCombatant2().getName() + " has been sent to the Graveyard.");
            party2.removeCharacter(duel.getCurrentCombatant2());

        } else if (duel.getCurrentCombatant2().isAlive() && !duel.getCurrentCombatant1().isAlive()) {
            clearConsole();
            System.out.println(duel.getCurrentCombatant2().getName() + " has demolished " +
                    duel.getCurrentCombatant1().getName());
            System.out.println(duel.getCurrentCombatant2().getName() + " IS THE WINNER OF THE DUEL!");

            newBattle.getGraveyard().add(duel.getCurrentCombatant1());
            System.out.println(duel.getCurrentCombatant1().getName() + " has been sent to the Graveyard.");
            party1.removeCharacter(duel.getCurrentCombatant1());

        } else if (!duel.getCurrentCombatant2().isAlive() && !duel.getCurrentCombatant1().isAlive()) {
            clearConsole();
            System.out.println(duel.getCurrentCombatant2().getName() + " & " +
                    duel.getCurrentCombatant1().getName() + " are both demolished");
            System.out.println("THE DUEL IS A TIE!");

            newBattle.getGraveyard().add(duel.getCurrentCombatant1());
            newBattle.getGraveyard().add(duel.getCurrentCombatant2());
            System.out.println("Both " + duel.getCurrentCombatant1().getName() + " & " +
                    duel.getCurrentCombatant2().getName() + " have been sent to the Graveyard.");
            party1.removeCharacter(duel.getCurrentCombatant1());
            party2.removeCharacter(duel.getCurrentCombatant2());
        }
        anythingToContinue();
        newBattle.showGraveyard();
        anythingToContinue();
        clearConsole();

        if (party1.getCharacters().size() == 0 && party2.getCharacters().size() > 0) {
            System.out.println(party1.getPartyName() + " YOU MANAGED TO FIND " +
                    "THE GOLDEN CODE \uD83C\uDFC6 \uD83D\uDC51, USE IT WISELY");

        } else if (party2.getCharacters().size() == 0 && party1.getCharacters().size() > 0) {
            System.out.println(party2.getPartyName() + " YOU MANAGED TO FIND " +
                    "THE GOLDEN CODE \uD83C\uDFC6 \uD83C\uDFFA , USE IT WISELY");

        } else if (party1.getCharacters().size() == 0 && party2.getCharacters().size() == 0) {
            System.out.println(party1.getPartyName() + " AND " + party2.getPartyName() +
                    " YOU BOTH FAILED TO ACCOMPLISH THE QUEST, THE GOLDEN CODE REMAINS HIDDEN " +
                    "\uD83D\uDCA5 - WHAT A SHAME!");

        } else if (party1.getCharacters().size() > 0 && party2.getCharacters().size() > 0) {
            printHeading("Choose the brave combatants who will duel for the golden script");
            Duel newDuel = new Duel(selectCombatant(party1), selectCombatant(party2));

            duelLoop(newDuel);
        }

    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////Method setAttribute/////////////////////////////////////////
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

    ///////////////////////////////////////////////////////////////Method to set Stats////////////////////////////////
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
            printHeading("Choose your warrior's Health Points between 100 to 200:");
            hp = Integer.parseInt(scanner.next());
            printHeading("Choose your warrior's Stamina between 10 to 50:");
            stamina = Integer.parseInt(scanner.next());
            printHeading("Choose your warrior's Strength between 1 to 10:");
            strength = Integer.parseInt(scanner.next());
            Warrior customWarrior = new Warrior(name, hp, stamina, strength);
            clearConsole();
            printHeading("Your warrior has been created successfully!");
            return customWarrior;

        } else {
            //Setear lo de Wizard
            name = setAttribute("Which wizard name would you like?", "wizard's name");
            printHeading("Choose your wizard's Health Points between 50 to 100:");
            hp = Integer.parseInt(scanner.next());
            printHeading("Choose your wizard's Mana between between 10 to 50:");
            mana = Integer.parseInt(scanner.next());
            printHeading("Choose your wizard's Intelligence between 1 to 50:");
            intelligence = Integer.parseInt(scanner.next());
            Wizard customWizard = new Wizard(name, hp, mana, intelligence);
            printHeading("Your wizard has been created successfully!");
            return customWizard;
        }
    }


    /////////////////////////////////////////////////////////////Party Type Menu //////////////////////////////////////
    public static void printPartyTypeMenu() {
        clearConsole();
        System.out.println("Choose a Party type:");
        printSeparator(20);
        System.out.println("(1) Import Party");
        System.out.println("(2) Random Party");
        System.out.println("(3) Custom Party");
    }

    ///////////////////////////////////////////////////////////Method to select a combatant////////////////////////////
    public static Character selectCombatant(Party party) {
        Character currentCombatant = null;
        boolean isCombatantSet = false;

        while (!isCombatantSet) {
            System.out.println("Choose combatant from the " + party.getPartyName() + " Party");
            printSeparator(20);

            for (int i = 0; i < party.getCharacters().size(); i++) {
                int menuItemNumber = i + 1;
                System.out.println("(" + menuItemNumber + ") " + party.getCharacters().get(i).toString());
            }

            System.out.println("------- PARTY SIZE ------>>>>>> " + party.getCharacters().size());

            int input = readInt("-> ", party.getCharacters().size());

            currentCombatant = party.getCharacters().get((int) input - 1);

            isCombatantSet = true;
        }

        System.out.println("Your character selected is " + currentCombatant);

        return currentCombatant;

    }

}

