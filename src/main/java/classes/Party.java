package classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static classes.Utils.*;

public class Party {
    private String partyName;
    private List<Character> characters = new ArrayList<>();


    ////////////////////////////////////////////////////////////Contructors/////////////////////////////////////////
    //Constructor 4 Import list of characters
    public Party(String partyName, List<Character> characters) {
        this.partyName = partyName;
        this.characters = characters;
    }

    //Constructor Custom & Random (only name)
    public Party(String partyName) {
        this.partyName = partyName;
    }


    ///////////////////////////////////////////////////////////Getters ///////////////////////////////////////

    public String getPartyName() {
        return partyName;
    }


    public List<Character> getCharacters() {
        return characters;
    }


    //////////////////////////////////////////////////////////////////  //////////////////////////////////////////////

    public void addCharacter(Character newCharacter) {
        int MAX_SIZE_PARTY = 5; //Max size of a party
        System.out.println("Current party size is: " + characters.size());
        if (characters.size() <= MAX_SIZE_PARTY) {

            //List of all character names in that party
            List<String> names = new ArrayList<>();
            for (Character player : characters) {
                names.add(player.getName());
            }

            if (names.contains(newCharacter.getName())) {
                System.out.println("A player with this name already in this Party");
                System.out.println(String.format("But, don't worry, %s Junior will be created!", newCharacter.getName()));
                newCharacter.setName(newCharacter.getName() + " Jr.");
            } else {
                System.out.println(String.format("Great! %s is available..", newCharacter.getName()));
                newCharacter.setName(newCharacter.getName());
            }
            characters.add(newCharacter);
        } else {
            System.out.println("Party full!! Let's Play the Game XD :D XD");
            //todo goes to Battle
        }

    }

    //Remove character - form party in battle --> Graveyard
    public void removeCharacter(Character character) {
        characters.remove(character);
    }


    //////////////////////////////////////////////////////////////////RANDOM PARTY METHODS//////////////////////////////////////////////
    public void randomMethod() {
        Random isWarrior = new Random();
        Random randomInt = new Random();

        int partySize = readInt("Choose a party size from 1 to 5: ", 5);


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

    //////////////////////////////////////////////////////////////////  //////////////////////////////////////////////

    public void customMethod() {
        List<Character> customList = new ArrayList<>();
        int MAX_SIZE_PARTY = 5;
        String name = " ";
        boolean typeSet = false;
        boolean isWarrior = false;


        int partySize = readInt("Choose a party size from 1 to 5: ", 5);

        for (int i = 0; i < partySize; i++) {
            //do {
            printHeading("Who is going to the join you in the quest for the secret code?");
            System.out.println("(1) A Strong Warrior!");
            System.out.println("(2) or a Clever Wizard");
            int input = readInt("-> ", 2);
            if (input == 1) {
                isWarrior = true;
                typeSet = true;
            } else if (input == 2) {
                isWarrior = false;
                typeSet = true;
            }
            addCharacter(setStats(isWarrior));
            //} while (!typeSet);
        }
    }

    @Override
    public String toString() {
        /*for(int i=0; i<characters.size(); i++){
            System.out.println(characters.get(i).toString());
        };*/
        return
                "PartyName: " + partyName + '\n' +
                        "Characters: " + "\n" +
                        "==============\n" +
                        Arrays.toString(characters.toArray());

    }


//    //EXTRA Victory count / wins
//    public int getPartyWins() {
//        return partyWins; //Statistics? and %
//    }
//
//    public void setPartyWins(int partyWins) {
//        this.partyWins = partyWins;
//    }
//
//
//    //Defeat / Loss count
//    public int getPartyLosses() {
//        return partyLosses; //Statistics? and %
//    }
//
//    public void setPartyLosses(int partyLosses) {
//        this.partyLosses = partyLosses;
//    }


}
