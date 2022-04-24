package classes;

import java.util.ArrayList;
import java.util.List;

public class Battle {
    //will receive 2 Parties who will battle & type of combat
    private final int MAX_LENGTH = 5;
    private List<Character> party1 = new ArrayList<>(MAX_LENGTH);
    private List<Character> party2 = new ArrayList<>(MAX_LENGTH);
    private List<Character> graveyard = new ArrayList<>();
    private List<Round> battleRounds = new ArrayList<>();
    //isBattleFinished is set to true when one of the parties is empty, it has lost all its combatants
    private boolean battleFinished;

    public Battle(List<Character> party1, List<Character> party2) {
        this.party1 = party1;
        this.party2 = party2;
        this.battleFinished = false;
    }

    public int getMAX_LENGTH() { return MAX_LENGTH; }

    public List<Character> getParty1() { return party1; }

    public void setParty1(List<Character> party1) { this.party1 = party1; }

    public List<Character> getParty2() { return party2; }

    public void setParty2(List<Character> party2) { this.party2 = party2; }

    public List<Character> getGraveyard() { return graveyard; }

    public void setGraveyard(List<Character> graveyard) { this.graveyard = graveyard; }

    public boolean isBattleFinished() { return battleFinished; }

    public void setBattleFinished(boolean battleFinished) { this.battleFinished = battleFinished; }
}



