package classes;

import java.util.ArrayList;
import java.util.List;

public class Round {
    //each fight or round will have two combatants
    private Character currentCombatant1;
    private Character currentCombatant2;

    private List<Character> winnerArr = new ArrayList<>();
    //initial value is false, when one combatant is dead or there is a tie it will start as false again.
    private boolean roundFinished;

    public Round(Character currentCombatant1, Character currentCombatant2) {
        this.currentCombatant1 = currentCombatant1;
        this.currentCombatant2 = currentCombatant2;
        this.roundFinished = false;
    }

    public Character getCurrentCombatant1() { return currentCombatant1; }

    public void setCurrentCombatant1(Character currentCombatant1) { this.currentCombatant1 = currentCombatant1; }

    public Character getCurrentCombatant2() { return currentCombatant2; }

    public void setCurrentCombatant2(Character currentCombatant2) { this.currentCombatant2 = currentCombatant2; }

    public boolean isRoundFinished() { return roundFinished; }

    public void setRoundFinished(boolean roundFinished) { roundFinished = roundFinished; }
}
