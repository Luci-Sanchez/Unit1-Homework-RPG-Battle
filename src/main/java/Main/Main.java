package Main;

import classes.*;
import classes.Character;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static classes.Utils.startGame;

public class Main {
    public static void main(String[] args) {
        /*Warrior jofi= new Warrior("Jofi", 10,200,122);
        Wizard paz= new Wizard("Paz", 101,210,1232);

        List<Character> list = new ArrayList<>();
        list.add(jofi);
        list.add(paz);

        //Create con import
        Party sisters = new Party("SIss", list);

        System.out.println(String.format("%s, %s, %s", "Party" ,sisters.getPartyName(), "fue creada"));
        System.out.println("Info: "+ sisters);
        System.out.println(":..AGREGO CHARACTERS...:");

        Wizard ana= new Wizard("Jofi", 1021,2310,12332);
        sisters.addCharacter(ana);


        Wizard lisa= new Wizard("lisa", 1021,2310,12332);
        sisters.addCharacter(lisa);

        Wizard itallia= new Wizard("italia", 1021,2310,12332);
        sisters.addCharacter(itallia);


        System.out.println(sisters);
        //System.out.println(sisters.getCharacters());*/

        startGame();



    }


}
