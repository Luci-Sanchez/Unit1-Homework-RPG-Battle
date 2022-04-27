package classes;

import java.util.ArrayList;
import java.util.List;

public class Duel {
    //each fight or round will have two combatants
    private Character currentCombatant1;
    private Character currentCombatant2;
    private Character winner;
    private boolean isATie;
    //initial value is false, when one combatant is dead or there is a tie it will start as false again.
    private boolean roundFinished;
    //TODO log

    //isDuelFinished, if true, check length of both parties to assess if Battle is finished
    private boolean duelFinished;


    public Duel(Character currentCombatant1, Character currentCombatant2) {
        this.currentCombatant1 = currentCombatant1;
        this.currentCombatant2 = currentCombatant2;
        winner = null;
        isATie = false;
        roundFinished = false;
        duelFinished = false;
    }

    //duel llama método round hasta que haya setWinner or tie ?
    public void duel(){
        do{
            round();
        }
        while(!winner.equals(null) || !isATie);

        setDuelFinished(false);
    }

    //Story calls rounds ??
    //method round
    public void round(){
        System.out.println("Choose your attack");
        //asks user to input comb1 attack & comb2 attack

        //when set roundFinished to false ??

        //calculates stats of each combatant after damage

        //setts a true round finished

        //if.. setWinner()
    }

    //

    public Character getCurrentCombatant1() { return currentCombatant1; }

    public void setCurrentCombatant1(Character currentCombatant1) { this.currentCombatant1 = currentCombatant1; }

    public Character getCurrentCombatant2() { return currentCombatant2; }

    public void setCurrentCombatant2(Character currentCombatant2) { this.currentCombatant2 = currentCombatant2; }

    public Character getWinner() { return winner; }

    public void setWinner() {
        //setting isAlive to true or false depending on hp
        currentCombatant1.setAlive();
        currentCombatant2.setAlive();

        if (currentCombatant1.isAlive() && !currentCombatant2.isAlive()) {
            winner = currentCombatant1;
        } else if (!currentCombatant1.isAlive() && currentCombatant2.isAlive()) {
            winner = currentCombatant2;
        } else if (!currentCombatant1.isAlive() && !currentCombatant2.isAlive()){
            setATie(true);
        }
    }

    public boolean isDuelFinished() { return duelFinished; }

    public void setDuelFinished(boolean duelFinished) { this.duelFinished = duelFinished; }

    public boolean isRoundFinished() { return roundFinished; }

    //TODO check this after each round ---> if combatant is dead roundFinished is true
    public void setRoundFinished(boolean roundFinished) { roundFinished = roundFinished; }

    public boolean isATie() { return isATie; }

    public void setATie(boolean ATie) { isATie = ATie; }
}
