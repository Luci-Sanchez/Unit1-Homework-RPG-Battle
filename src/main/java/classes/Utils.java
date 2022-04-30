package classes;

import java.io.File;
import java.util.Scanner;

public class Utils {
    public static boolean isRunning;
    static Scanner scanner = new Scanner(System.in);
    static Party party1;
    static Party party2;

    static Battle newBattle;
    static Duel newDuel;

    static String title =
            "                                                       %&.    ✨\n" +
                    "  ✨  @@@@@@@   @@@@, &@@@@@@%@@@@@@ @@#   #@@@@@*   %@@@/              @@@@@@(%@@\n" +
                    "   .@@( #@@  %@@@@/  .@@%    @@&  #@@    @@@      &@@&&  ,(#   *** %    #@@,  @@&  _  ##(*@\n" +
                    "   &@@@@@@  @@ @@#  @@@    &@@   @@@   .@@@@@,   @@@@&&@@@@@% @@@@&    @@@  ,@@@@@@% @&(  &@\n" +
                    " @@@  @@% @@@@@@%  @@@    @@@  .@@,   @@@.      @@& (@@   @@%#@@     .@@%  @@@  @@/@@@@##*\n" +
                    "/@@@@@@@ @@&..@@& /@@   *@@/  &@@@@@ @@@@@@   .@@. /@@@@@@ @@&      @@@   @@/ #@@ @@@@@@\n" +
                    "      *#%%(   ,,,   ,,, ,,,    ,,,   ,,,,,,.,,,,,.   ,,,    *(    ,,       ,,,  .,,  ,,,   ((\n" +
                    "    @@@@@*  @@@@@@/ ✨ @@(   &@@@@@@  .@@@@@& @@@   @@    @@@@@*  @@@@@ &@@@@@@  @@@ @@@@@@& @@@@@@\n" +
                    "   %@@/    (@@#  @@@ %@@    @@@ .@@@ &@@.   /@@@@ &@%   @@@    #@@(    @@&  @@ (@@. @@% %@@  @@@\n" +
                    "   @@#  ,% @@&   @@@ @@&   *@@.  @@@ @@@@@% @@@@@@@@    &@@@@% @@&    *@@@@@@  @@@ (@@@@@@   @@&\n" +
                    "  .@@@ %@%.@@@  @@@ *@@.   @@@  @@@ (@@#    @@ @@@@@       @@@ @@@    @@@*@@  .@@% @@@      &@@\n" +
                    "   &@@@@@  &@@@@@@  @@@@@@ @@@@@@@  @@@@@@ &@%  @@@,   @@@@@@  &@@@@@ @@#.@@@,&@@  @@*      @@@   ✨";

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

    //Credits
    public static void credits() {
        clearConsole();
        printSeparator(30);
        System.out.println("Battle for The GOLDEN SCRIPT");
        System.out.println("was powered and produced with much care");
        System.out.println("by The LLIJ Haker Team");
        System.out.println("we wish you enjoy it.");
        printSeparator(30);
        anythingToContinue();
    }

    //method to start the game

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////// START GAME///////////////////////////////////////////////////////
    public static void startGame() {
        System.out.println(title);
        anythingToContinue();


        credits();

        into();

        //naming both parties who will battle
        clearConsole();
        System.out.println("\n ✨ Go ahead, create your First Party ✨ \n");
        printSeparator(30);
        party1 = new Party(setAttribute("Name the First Party which will follow you to battle: ",
                "Party name"));
        clearConsole();
        printHeading("\n\n\n ✨ Your Party  ↂ" + party1.getPartyName() + "ↂ was Created ✨ \n\n\n");
        printSeparator(30);

        clearConsole();
        printHeading("  \nGet ready to create the second party!\n");
        anythingToContinue();

        clearConsole();
        System.out.println("\n ✨ Go ahead, create your Second Party ✨ \n");
        party2 = new Party(setAttribute("\n -> Name the Second Party which will follow you to battle: ", "Party name"));

        clearConsole();
        printHeading("\n\n\n ✨ Your Party  ↂ" + party2.getPartyName() + "ↂ was Created ✨ \n\n\n");
        anythingToContinue();


        //create new Battle with the new 2 parties
        newBattle = new Battle(party1, party2);

        //setting isRunning to true, so the game loop can continue
        isRunning = true;

        //start main game loop
        battleLoop();
    }

    //Opening Story Telling
    private static void into() {
        clearConsole();
        System.out.println("The world is full of stories, many long others short." +
                "\nBut few eco form ancient days as does the tale of The Golden Code");
        System.out.println("");
        printSeparator(7);
        anythingToContinue();

        clearConsole();
        System.out.println("The legend runs as fast as devastates the lives of those who search for it." +
                "\nAnd even though many tried, few have reached the realm which guards it.");
        System.out.println("");
        printSeparator(7);
        anythingToContinue();

        clearConsole();
        System.out.println("Driven by it's might, on endless lonely quests, you ventured for it." +
                "\nBut only now, in your hands, lies a Party which will help you.");
        System.out.println("");
        printSeparator(7);
        anythingToContinue();

        clearConsole();
        System.out.println("You are finally at the verge of it's reach." +
                "\nBut wait! There's a second party ready to battle for it. ");
        System.out.println("");
        printSeparator(7);
        anythingToContinue();
    }


    ////////////////////////////////////////////// BATTLE LOOP ////////////////////////////////////////////////////////
    public static void battleLoop() {

        printPartyTypeMenu();
        int input = readInt("-> ", 3);
        if (input == 1) {
            System.out.println("Now importing your First Party...");
            party1.importCsv(new File("party_one.csv"));
            printSeparator(30);
            System.out.println("\n ✨ First imported Party was Created! ✨ \n");
            System.out.println(party1.toString());


            System.out.println("Now importing your second Party...");
            anythingToContinue();
            clearConsole();
            System.out.println("Lets Create party2 with the importing party");
            party2.importCsv(new File("party_two.csv"));
            printSeparator(30);
            System.out.println("\n ✨ Second imported Party was Created!  ✨ \n");
            System.out.println(party2.toString());

            anythingToContinue();
            clearConsole();

        } else if (input == 2) {
            System.out.println("Now creating First Randomized Party");
            party1.randomMethod();
            printSeparator(30);
            System.out.println("\n ✨ First Random Party was Created! ✨ \n");
            System.out.println(party1.toString());

            System.out.println("Now creating Second Randomized Party\"");
            anythingToContinue();

            clearConsole();
            party2.randomMethod();
            printSeparator(30);
            System.out.println("\n ✨ Second Random Party was Created!  ✨ \n");
            System.out.println(party2.toString());

            anythingToContinue();
            clearConsole();

        } else if (input == 3) {
            party1.customMethod();
            System.out.println(party1.toString());

            party2.customMethod();
            System.out.println(party2.toString());

        } else {
            System.out.println("Select 1, 2 or 3 !!");
            printPartyTypeMenu();
        }

        //Only allow players to continue if party size is bigger than 1 and smaller or equal to 5
        if (party1.getCharacters().size() <= 5 && party2.getCharacters().size() <= 5
                && party1.getCharacters().size() >= 1 && party2.getCharacters().size() >= 1) {

            printHeading("\nChoose the brave combatants who will duel for the golden script\n");
            newDuel = new Duel(selectCombatant(party1), selectCombatant(party2));
        }

        //setting isRunning to true, so the game loop can continue
        isRunning = true;
        //start main game loop
        duelLoop(newDuel);
    }

    /////////////////////////////////////////////////// DUEL LOOP //////////////////////////////////////////////////////
    public static void duelLoop(Duel duel) {
        printHeading("\n ✨ THE BATTLE HAS BEGUN  ✨ \n");
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
                    printHeading(duel.getCurrentCombatant1().getName() + " the Mighty Warrior used Heavy Attack! \uD83D\uDCAA");
                } else {
                    charToWArr.smallAttack(duel.getCurrentCombatant2());
                    printHeading(duel.getCurrentCombatant1().getName() + " the Mighty Warrior used Weak Attack! \uD83D\uDC4F");
                }
            } else if (duel.getCurrentCombatant1().getClass().getSimpleName().equals("Wizard")) {
                Wizard charToWizz = (Wizard) duel.getCurrentCombatant1();
                if (charToWizz.getMana() >= 5) {
                    charToWizz.bigAttack(duel.getCurrentCombatant2());
                    printHeading(duel.getCurrentCombatant1().getName() + " the Mystical Wizard used Fireball! \uD83D\uDD25✨");
                } else {
                    charToWizz.smallAttack(duel.getCurrentCombatant2());
                    printHeading(duel.getCurrentCombatant1().getName() + " the Mystical Wizard used Staff Hit ⛏✨");
                }
            }


            if (duel.getCurrentCombatant2().getClass().getSimpleName().equals("Warrior")) {
                Warrior charToWArr = (Warrior) duel.getCurrentCombatant2();
                if (charToWArr.getStamina() >= 5) {
                    charToWArr.bigAttack(duel.getCurrentCombatant1());
                    printHeading(duel.getCurrentCombatant2().getName() + " the Mighty Warrior used Heavy Attack! \uD83D\uDCAA");
                } else {
                    charToWArr.smallAttack(duel.getCurrentCombatant1());
                    printHeading(duel.getCurrentCombatant2().getName() + " the Mighty Warrior used Weak Attack! \uD83D\uDC4F");
                }
            } else if (duel.getCurrentCombatant2().getClass().getSimpleName().equals("Wizard")) {
                Wizard charToWizz = (Wizard) duel.getCurrentCombatant2();
                if (charToWizz.getMana() >= 5) {
                    charToWizz.bigAttack(duel.getCurrentCombatant1());
                    printHeading(duel.getCurrentCombatant2().getName() + " the Mystical Wizard used Fireball! \uD83D\uDD25✨");
                } else {
                    charToWizz.smallAttack(duel.getCurrentCombatant1());
                    printHeading(duel.getCurrentCombatant2().getName() + " the Mystical Wizard used  Staff Hit! ⛏✨");
                }
            }
            System.out.println("\n ✨ Wow! That was quite a round, look at how it affected the combatants ✨ \n");
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
            System.out.println("\n \uD83D\uDD25 WOW!" + duel.getCurrentCombatant1().getName() + " has demolished " +
                    duel.getCurrentCombatant2().getName() + "\uD83D\uDD25 \n");
            System.out.println("\n ✨ " + duel.getCurrentCombatant1().getName() + " IS THE WINNER OF THE DUEL! \uD83C\uDFC6 \n");

            newBattle.getGraveyard().add(duel.getCurrentCombatant2());
            System.out.println("\n \uD83E\uDEA6 Wops!" + duel.getCurrentCombatant2().getName() + " has been sent to the Graveyard. \uD83E\uDEA6");
            party2.removeCharacter(duel.getCurrentCombatant2());

        } else if (duel.getCurrentCombatant2().isAlive() && !duel.getCurrentCombatant1().isAlive()) {
            clearConsole();
            System.out.println("\n \uD83D\uDD25 WOW!" + duel.getCurrentCombatant2().getName() + " has demolished " +
                    duel.getCurrentCombatant1().getName() + "\uD83D\uDD25 \n");
            System.out.println("\n ✨ " + duel.getCurrentCombatant2().getName() + " IS THE WINNER OF THE DUEL! \uD83C\uDFC6 \n");

            newBattle.getGraveyard().add(duel.getCurrentCombatant1());
            System.out.println("\n \uD83E\uDEA6 Wops!" + duel.getCurrentCombatant1().getName() + " has been sent to the Graveyard. \uD83E\uDEA6");
            party1.removeCharacter(duel.getCurrentCombatant1());

        } else if (!duel.getCurrentCombatant2().isAlive() && !duel.getCurrentCombatant1().isAlive()) {
            clearConsole();
            System.out.println(duel.getCurrentCombatant2().getName() + " & " +
                    duel.getCurrentCombatant1().getName() + " are both demolished" + "🔥 \n");
            System.out.println("THE DUEL IS A TIE!");

            newBattle.getGraveyard().add(duel.getCurrentCombatant1());
            newBattle.getGraveyard().add(duel.getCurrentCombatant2());
            System.out.println(" \uD83E\uDEA6 Both " + duel.getCurrentCombatant1().getName() + " & " +
                    duel.getCurrentCombatant2().getName() + " have been sent to the Graveyard. \uD83E\uDEA6");
            party1.removeCharacter(duel.getCurrentCombatant1());
            party2.removeCharacter(duel.getCurrentCombatant2());
        }
        anythingToContinue();
        newBattle.showGraveyard();
        anythingToContinue();
        clearConsole();

        if (party1.getCharacters().size() == 0 && party2.getCharacters().size() > 0) {
            System.out.println("" +
                    "           /@@@%    @@@@@                                               ✨      @@@@@                             ✨ \n" +
                    "        @@@@@@@@@@ @@@@@&@@@@@%    (@@@@@@@    @@@@&&@@@@  *@@@@@@@*          @@@@%   @@@@@@@@           #@@@@@@@&  \n" +
                    "  ✨      @@@@*    @@@@%   @@@@, &@@@@   @@@@  @@@@%     *@@@@   @@@@.        @@@@( (@@@@@#                 ./&@@@@  \n" +
                    "        @@@@,    @@@@(  .@@@@. @@@@@         @@@@*     %@@@@                @@@@*     #@@@@@@@   ✨   *@@@@. @@@@@   \n" +
                    "       @@@@@@@, @@@@*  ,@@@@   ,@@@@@@@@(   @@@@.       @@@@@@@@&   ✨      @@@@.  @@@@@@@@@@         @@@@@@@@@@@ " +
                    "\n \n" +
                    "     ,@@@@@@@@@@@@@@@@@@@@@@@@@@#*@@@@@@   @@@@@@@@@@@@@  /@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@,         @@@@ @@@@/   ✨ \n" +
                    "       @@@@@/ @@@@@@ ,@@@. @@@@@   @@@@@@@  %@@@* #@@@@@@   @@@@  @@@@@@@@@@@@@  @@@@@@@@@@@@&      /@@@# @@@@  \n" +
                    "       #@@@@  @@@@@* @@@   @@@@@   @@@@@@@@ *@@,   @@@@@@@% @@@   @@@@@     &@   @@@@@   @@@@@      @@@@ .@@@.  \n" +
                    "       ,@@@@ @@@@@@*@@@   .@@@@    @@@@@@@@@@@@   &@@@@@@@@@@@/   @@@@@@@@@     /@@@@@@@@@@@#       @@@. (@@@   \n" +
                    "        @@@@@@@@@@@@@@.   @@@@@   (@@. @@@@@@@#   @@@ .@@@@@@@   #@@@@       *  @@@@@@@@@@@@   ✨   @@&  &@@   \n" +
                    "   ✨   @@@@@@/@@@@@@*    @@@@/   @@@   /@@@@@   *@@,   @@@@@&   @@@@@    @@@  .@@@@,  @@@@@       @@@@ @@@@   \n" +
                    "        @@@@@@ @@@@@(    #@@@@@ @@@@@@    @@@@ .@@@@@,   %@@@  @@@@@@@@@@@@@@,@@@@@@@ @@@@@@@     %@@@& @@@@ ");
            System.out.println("✨" + party1.getPartyName() + " YOU MANAGED TO FIND " +
                    "THE GOLDEN CODE \uD83C\uDFC6 \uD83D\uDC51, USE IT WISELY ✨");

        } else if (party2.getCharacters().size() == 0 && party1.getCharacters().size() > 0) {
            System.out.println("✨" + party2.getPartyName() + " YOU MANAGED TO FIND " +
                    "THE GOLDEN CODE \uD83C\uDFC6 \uD83C\uDFFA , USE IT WISELY ✨");

        } else if (party1.getCharacters().size() == 0 && party2.getCharacters().size() == 0) {
            System.out.println("" +
                    "                             @@@(                                                                           ✨                \n" +
                    "      (@@@@@@ .@@@@@@@@@@@@@ @@@   ,@@@@@@@@@@        *@@@@@@@@@. ✨    ,@@@@@@@@@@@@@@@@@@@* @@@@@@@@@@@@@@      @@@@ @@@@,   ✨\n" +
                    "  ✨    *@@@@# @@@@@@@@@@@@@@ @@  #@@@@@@@@@@@#         *@@@@@@@        @@@@@@@@@@@@@& @@@@@   @@@@@@@@@@@@&     #@@@* @@@@    \n" +
                    "       (@@@@  @@  @@@@@  @@      @@@@@@@@   @         ,@@@@@@@%        @@  @@@@@  @@  @@@@&   @@@@@     #@      @@@@ ,@@@      \n" +
                    "       @@@@@ *.   @@@@(   @      @@@@@@@@@@@/        &@@@ @@@@@       *    @@@@/   @ ,@@@@    @@@@@@@@@         @@@  &@@&  \n" +
                    "      .@@@@.     &@@@@          ( ,@@@@@@@@@@       @@@@@@@@@@@   ✨       &@@@@      @@@@@   &@@@@       ,      //*  ///   ✨ \n" +
                    "      @@@@@      @@@@&         ,@@@/    @@@@#      @@@@@@@@@@@@%          @@@@&      @@@@,   @@@@&   .@@@     .@@@@ @@@@   \n" +
                    "      @@@@@%  *@@@@@@@@        @@@@@@@@@@@@     ,@@@@@@  @@@@@@@@      *@@@@@@@@    &@@@@@ @@@@@@@@@@@@@#     &@@@/ @@@@");
            System.out.println("\uD83E\uDEA6" + party1.getPartyName() + " AND " + party2.getPartyName() +
                    " YOU BOTH FAILED TO ACCOMPLISH THE QUEST, THE GOLDEN CODE REMAINS HIDDEN " +
                    "\uD83D\uDCA5 - WHAT A SHAME! \uD83E\uDEA6");

        } else if (party1.getCharacters().size() > 0 && party2.getCharacters().size() > 0) {
            printHeading("Choose the brave combatants who will duel next for The Golden✨ Script");
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
            name = setAttribute("Which warrior name would you like?", "warrior's name");
            hp = readStats("Choose your warrior's Health Points between 100 to 200:", 100, 200);
            stamina = readStats("Choose your warrior's Stamina between 10 to 50:", 10, 50);
            strength = readStats("Choose your warrior's Strength between 1 to 10:", 1, 10);
            Warrior customWarrior = new Warrior(name, hp, stamina, strength);
            clearConsole();
            printHeading("Your warrior has been created successfully!");
            return customWarrior;

        } else {
            name = setAttribute("Which wizard name would you like?", "wizard's name");
            hp = readStats("Choose your wizard's Health Points between 50 to 100:", 50, 100);
            mana = readStats("Choose your wizard's Mana between between 10 to 50:", 10, 50);
            intelligence = readStats("Choose your wizard's Intelligence between 1 to 50:", 1, 50);
            Wizard customWizard = new Wizard(name, hp, mana, intelligence);
            printHeading("Your wizard has been created successfully!");
            return customWizard;
        }
    }

    /////////////////////////////////////////Method to catch stat setting errors ///////////////////////////////////////

    private static int readStats(String prompt, int min, int max) {
        int stat;
        do {
            System.out.println(prompt);
            try {
                stat = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                stat = -1;
                System.out.println("Please enter a valid integer!");
            }
        } while (stat < min || stat > max);
        return stat;
    }

    /////////////////////////////////////////////////////////////Party Type Menu //////////////////////////////////////
    public static void printPartyTypeMenu() {
        clearConsole();
        printHeading(" \n And now, how will you arrange your Party? \n ");
        System.out.println(" -> Choose a Party arrangement:");
        printSeparator(20);
        System.out.println("(1) Import Party");
        System.out.println("(2) Randomize Party");
        System.out.println("(3) Customize Party");
    }

    ///////////////////////////////////////////////////////////Method to select a combatant////////////////////////////
    public static Character selectCombatant(Party party) {
        Character currentCombatant = null;
        boolean isCombatantSet = false;

        while (!isCombatantSet) {
            System.out.println("\n Choose combatant to Duel, from the " + party.getPartyName() + " Party\n");
            printSeparator(20);

            for (int i = 0; i < party.getCharacters().size(); i++) {
                int menuItemNumber = i + 1;
                System.out.println("(" + menuItemNumber + ") " + party.getCharacters().get(i).toString());
            }

            int input = readInt("-> ", party.getCharacters().size());

            currentCombatant = party.getCharacters().get((int) input - 1);

            isCombatantSet = true;
        }

        System.out.println("Your character selected is " + currentCombatant);

        return currentCombatant;

    }

}

