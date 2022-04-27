package classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Party {
    private String partyName;
    private List<Character> characters = new ArrayList<>(); // In Constructor this.Characters = new Character[3]; // Or ArrayList
    private boolean randomPArty;

    //private int partyWins;
    //private int partyLosses;


    //Constructor 4 Import (all)

    public Party(String partyName, List<Character> characters) {
        this.partyName = partyName;
        this.characters = characters;
    }

    //Constructor 4 Customizable - (only name)

    public Party(String partyName) {
        this.partyName = partyName;
    }

    //Constructor 4 Random - (only name)

    public Party(String partyName, boolean randomParty) {
        this.partyName = partyName;
        randomMethod();
    }


    //Party Name
    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }


    //Character Array
    public List<Character> getCharacters() {
        return characters; //Select Character to battle/ duel/ edit
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;  //Import Array
    }

    //Add Character
   /* public void addCharacter(Character character) {
        //Validar tamaño Party/ espacios nulos?
        //VAlidar si nombre existe - +Jr.
        characters.add(character);
    }*/

    ////////////////////////////

    //Yo reemplzaria el addCharacter por esta
    public void addCharacter(Character newCharacter) {
        /*int sizeParties=5; //Ver que hacer con el tamaño de la party
        if(characters.size()<sizeParties){*/

                //check si ya hay jugador con ese nombre
                List<String> names = new ArrayList<>();
                for(Character player : characters){
                    names.add(player.getName());
                }

                if(names.contains(newCharacter.getName())){
                    System.out.println("A player with this name already in this Party");
                    System.out.println(String.format("But, don't worry, %s Junior will be created!", newCharacter.getName()));
                    newCharacter.setName(newCharacter.getName()+" Jr.");
                }else {
                    System.out.println(String.format("Great! %s is available..", newCharacter.getName()));
                    //Creo que no hace falta pero por las deudas
                    newCharacter.setName(newCharacter.getName());

            }

        /*}else{
            System.out.println("Party full!! Let's Play the Fucking Game XD :D XD");
        }*/
        characters.add(newCharacter);
    }

    ////////////////////////////////////

    //Remove character - form party in battle --> Graveyard
    public void removeCharacter(Character character) {
        characters.remove(character);
    }

    //Random Method
    public List randomMethod() {
        List<Character> randomList = new ArrayList<>();

        String name = randomName();
        Random isWarrior = new Random();
        Random randomInt = new Random();

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
        return randomList;
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

//    //Victory count / wins
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


    @Override
    public String toString() {
        /*for(int i=0; i<characters.size(); i++){
            System.out.println(characters.get(i).toString());
        };*/
        return
                "\nPartyName: " + partyName + '\n' +
                "IsRandomPArty=" + randomPArty + '\n' +
                 "Characters: " + "\n"+
                        "==============\n"+
                "HOLAA" + Arrays.toString(characters.toArray())+
                '}';

    }
}
