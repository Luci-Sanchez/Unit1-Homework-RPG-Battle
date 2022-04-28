package Main;

import classes.Character;
import classes.Party;
import classes.Warrior;
import classes.Wizard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Warrior jofi= new Warrior("Jofi", 10,200,122);
        Wizard paz= new Wizard("Paz", 101,210,1232);
        //Wizard paz= new Wizard("Paz", 101,210,1232);
        //List<Character> list = Arrays.asList(jofi , paz);
        List<Character> list = new ArrayList<>();
        list.add(jofi);
        list.add(paz);

        //Create con import
        Party sisters = new Party("SIss", list);

        System.out.println(String.format("%s, %s, %s", "Party" ,sisters.getPartyName(), "fue creada"));
        System.out.println("Info: "+ sisters);
        System.out.println(":.....:");


        Wizard ana= new Wizard("Jofi", 1021,2310,12332);
        sisters.addCharacter(ana);
        System.out.println(sisters);
        //System.out.println(sisters.getCharacters());
        
    }
}
