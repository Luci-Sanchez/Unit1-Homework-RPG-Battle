package classes;

import java.util.ArrayList;
import java.util.List;

public class Battle {
    //will receive 2 Parties who will battle & type of combat
    private final int MAX_LENGTH = 5;
    private Party party1; //List<Character>
    private Party party2;
    private List<Character> graveyard = new ArrayList<>();
    private List<Duel> battleDuels = new ArrayList<>();
    //isBattleFinished is set to true when one of the parties is empty, it has lost all its combatants
    private boolean battleFinished;

    public Battle(Party party1, Party party2) {
        this.party1 = party1;
        this.party2 = party2;
        this.battleFinished = false;
    }


    //if Party is empty battleFinished or is running change to true

    public int getMAX_LENGTH() { return MAX_LENGTH; }

    public Party getParty1() {
        return party1;
    }

    public void setParty1(Party party1) {
        this.party1 = party1;
    }

    public Party getParty2() {
        return party2;
    }

    public void setParty2(Party party2) {
        this.party2 = party2;
    }

    public List<Duel> getBattleDuels() {
        return battleDuels;
    }

    public void setBattleDuels(List<Duel> battleDuels) {
        this.battleDuels = battleDuels;
    }

    public List<Character> getGraveyard() { return graveyard; }

    public void setGraveyard(List<Character> graveyard) { this.graveyard = graveyard; }

    public boolean isBattleFinished() { return battleFinished; }

    public void setBattleFinished(boolean battleFinished) { this.battleFinished = battleFinished; }
}



