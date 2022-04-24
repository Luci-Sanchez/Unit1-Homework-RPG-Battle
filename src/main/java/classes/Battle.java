package classes;

import java.util.ArrayList;
import java.util.List;

public class Battle {
    //will receive 2 Parties who will battle & type of combat
    private final int MAX_LENGTH = 5;
    private List<Character> party1 = new ArrayList<>(MAX_LENGTH);
    private List<Character> party2 = new ArrayList<>(MAX_LENGTH);
    private List<Character> graveyard = new ArrayList<>();
    //isBattleFinished is set to true when one of the parties is empty, it has lost all its combatants
    private boolean isBattlefinished = false;

    //each fight or round will have two combatants
    private Character currentCombatant1;
    private Character currentCombatant2;
    //initial value is false, when one combatant is dead or there is a tie it will start as false again.
    private boolean isRoundFinished = false;
    private boolean isRoundStarted = false;

    public Battle(List<Character> party1, List<Character> party2, List<Character> graveyard, boolean isBattlefinished) {
        this.party1 = party1;
        this.party2 = party2;
        this.graveyard = graveyard;
        this.isBattlefinished = isBattlefinished;
    }

    public Battle(List<Character> party1, List<Character> party2, List<Character> graveyard, boolean isBattlefinished,
                  Character currentCombatant1, Character currentCombatant2, boolean isRoundFinished) {
        this.party1 = party1;
        this.party2 = party2;
        this.graveyard = graveyard;
        this.isBattlefinished = isBattlefinished;
        this.currentCombatant1 = currentCombatant1;
        this.currentCombatant2 = currentCombatant2;
        this.isRoundFinished = isRoundFinished;
    }

    public int getMAX_LENGTH() { return MAX_LENGTH; }

    public List<Character> getParty1() { return party1; }

    public void setParty1(List<Character> party1) { this.party1 = party1; }

    public List<Character> getParty2() { return party2; }

    public void setParty2(List<Character> party2) { this.party2 = party2; }

    public List<Character> getGraveyard() { return graveyard; }

    public void setGraveyard(List<Character> graveyard) { this.graveyard = graveyard; }

    public boolean isBattlefinished() { return isBattlefinished; }

    public void setBattlefinished(boolean battlefinished) {
        isBattlefinished = battlefinished; }

    public Character getCurrentCombatant1() { return currentCombatant1; }

    public void setCurrentCombatant1(Character currentCombatant1) { this.currentCombatant1 = currentCombatant1; }

    public Character getCurrentCombatant2() { return currentCombatant2; }

    public void setCurrentCombatant2(Character currentCombatant2) { this.currentCombatant2 = currentCombatant2; }

    public boolean isRoundFinished() { return isRoundFinished; }

    public void setRoundFinished(boolean roundFinished) { isRoundFinished = roundFinished; }
}



