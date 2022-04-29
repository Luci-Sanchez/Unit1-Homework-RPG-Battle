package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static classes.Utils.*;

public class Party {
    private String partyName;
    private List<Character> characters = new ArrayList<>();


    ////////////////////////////////////////////////////////////Contructors/////////////////////////////////////////
    public Party(String partyName, List<Character> characters) {
        this.partyName = partyName;
        this.characters = characters;
    }

    public Party(String partyName) {
        this.partyName = partyName;
    }

    ///////////////////////////////////////////////////////////Getters////////////////////////////////////////////////
    public String getPartyName() {
        return partyName;
    }

    public List<Character> getCharacters() {
        return characters;
    }


    //////////////////////////////////////////////////////////////////addCharacter Method//////////////////////////////
    public void addCharacter(Character newCharacter) {
        int MAX_SIZE_PARTY = 5; //Max size of a party

        if (characters.size() <= MAX_SIZE_PARTY) {

            //List of all character names already in that party
            List<String> names = new ArrayList<>();
            for (Character player : characters) {
                names.add(player.getName());
            }

            if (names.contains(newCharacter.getName())) {
                System.out.println("A player with this name already in this Party");
                System.out.println(String.format("But, don't worry, %s Junior will be created!",
                        newCharacter.getName()));
                newCharacter.setName(newCharacter.getName() + " Jr.");
            } else {
                System.out.println(String.format("Great! %s is available.", newCharacter.getName()));
                newCharacter.setName(newCharacter.getName());
            }
            characters.add(newCharacter);
        } else {
            clearConsole();
            System.out.println("\n ✨ Party is FULL!!  Now, Let's BATTLE!! ✨\n");
        }

    }
    //////////////////////////////////////////////////////////////////removeCharacter Method///////////////////////////
    //Remove character - form party in battle --> Graveyard
    public void removeCharacter(Character character) {
        characters.remove(character);
    }


    //////////////////////////////////////////////////////////////////Random party/////////////////////////////////////
    public void randomMethod() {
        Random isWarrior = new Random();
        Random randomInt = new Random();

        clearConsole();
        int partySize = readInt("Choose a party size from 1 to 5: ", 5);
        clearConsole();

        for (int i = 0; i < partySize; i++) {
            String name = randomName();

            if (isWarrior.nextBoolean()) {
                int randomHP = randomInt.nextInt((200 - 100) + 1) + 100;
                int randomStamina = randomInt.nextInt((50 - 10) + 1) + 10;
                int randomStrength = randomInt.nextInt((10 - 1) + 1) + 1;
                Warrior randomWarrior = new Warrior(name, randomHP, randomStamina, randomStrength);
                addCharacter(randomWarrior);

            } else {
                int randomHP = randomInt.nextInt((100 - 50) + 1) + 50;
                int randomMana = randomInt.nextInt((50 - 10) + 1) + 10;
                int randomSIntelligence = randomInt.nextInt((50 - 1) + 1) + 1;
                Wizard randomWizard = new Wizard(name, randomHP, randomMana, randomSIntelligence);
                addCharacter(randomWizard);
            }
        }
    }

    public String randomName() {

        List<String> subjects = new ArrayList<>();
        subjects.add("Agnar");
        subjects.add("Elbrus");
        subjects.add("Medea");
        subjects.add("Circe");
        subjects.add("Helios");
        subjects.add("Demeter");
        subjects.add("Xena");
        subjects.add("Boudicca");

        Random randomizer = new Random();
        return subjects.get(randomizer.nextInt(subjects.size()));
    }

    /////////////////////////////////////////////////////////Custom Party //////////////////////////////////////////////
    public void customMethod() {
        boolean typeSet = false;
        boolean isWarrior = false;

        clearConsole();
        int partySize = readInt(" -> From 1 to 5, how many fellows will serve the Party's quest?: ",
                5);
        clearConsole();

        for (int i = 0; i < partySize; i++) {
            clearConsole();
            printHeading("\n ✨ WoW! ✨   Both Wizards & Warriors are willing to join. " +
                    "\n Who will join you on the quest for The Golden✨ Script\n?");
            System.out.println("(1) A Strong Warrior! \uD83D\uDCAA");
            System.out.println("(2) or a Clever Wizard! \uD83E\uDDD9");
            int input = readInt("-> ", 2);
            if (input == 1) {
                isWarrior = true;
            } else if (input == 2) {
                isWarrior = false;
            }
            addCharacter(setStats(isWarrior));

        }
    }
    ///////////////////////////////////////////////Import Party /////////////////////////////////////////////////////
    public void importCsv(File csvFile) {
        try {
            Scanner scanner = new Scanner(csvFile);

            String partyName = csvFile.getName().substring(0, csvFile.getName().length() -4);
            System.out.println(partyName);
            scanner.nextLine();

            while(scanner.hasNextLine()) {

                String stringCharacter = scanner.nextLine();
                String[] dataCharacter = stringCharacter.split(";");

                if(dataCharacter[6].equals(true)) {
                    Warrior warrior = new Warrior(dataCharacter[1], Integer.parseInt(dataCharacter[2]),
                            Integer.parseInt(dataCharacter[4]), Integer.parseInt(dataCharacter[5]));
                    addCharacter(warrior);
                } else {
                    Wizard wizard = new Wizard(dataCharacter[1], Integer.parseInt(dataCharacter[2]),
                            Integer.parseInt(dataCharacter[4]), Integer.parseInt(dataCharacter[5]));
                    addCharacter(wizard);
                }
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    ///////////////////////////////////////////////////////////Override Methods///////////////////////////////////////
    @Override
    public String toString() {
        String charactersString =  "";
        for(int i=0; i<characters.size(); i++){
            charactersString = charactersString+characters.get(i).toString();
        };
        return
                "PartyName: " + partyName + '\n' +
                        "Characters: " + "\n" +
                        "==============\n" +
                        charactersString;
    }


}
