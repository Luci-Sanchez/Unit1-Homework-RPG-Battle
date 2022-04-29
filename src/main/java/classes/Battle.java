package classes;

import java.util.ArrayList;
import java.util.List;

public class Battle {
    //will receive 2 Parties who will battle & type of combat
    private Party party1;
    private Party party2;
    private List<Character> graveyard = new ArrayList<>();
    private List<Duel> battleDuels = new ArrayList<>();

    //isBattleFinished is set to true when one of the parties is empty, it has lost all its combatants
    private boolean battleFinished;

    ////////////////////////////////////////////////////////////Contructor/////////////////////////////////////////
    public Battle(Party party1, Party party2) {
        this.party1 = party1;
        this.party2 = party2;
        this.battleFinished = false;
    }

    ///////////////////////////////////////////////////////////Getters///////////////////////////////////////
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


    public List<Character> getGraveyard() {
        return graveyard;
    }
    public void showGraveyard() {
        System.out.println("\uD83D\uDC7B    \uD83D\uDC7B    \uD83D\uDC7B    \uD83D\uDC7B    \uD83D\uDC7B    \uD83D\uDC7B    \uD83D\uDC7B    \uD83D\uDC7B    \uD83D\uDC7B    \uD83D\uDC7B \n" +
                "            @@@@@@@@@%                                                                                                 @@@@(                          \n" +
                "         @@@@@   @@@@@  #@@@@/@@@@  #@@@@@@@@  @@@@@&   @@@@  *@@@@@@@,  @@@@@   @@@@  %@@@@@@@%   (@@@@/@@@@. (@@@@@@@@@@,                           \n" +
                "       #@@@@  ,@@@@@@  &@@@@.         ./%@@@@  %@@@@,.@@@% *@@@@   @@@@. @@@@& @@@@      .(@@@@@  %@@@@.     @@@@%  .@@@@                             \n" +
                "       @@@@.   @@@@@  @@@@@     .@@@@. %@@@@   *@@@@@@@.  %@@@@          (@@@@@@&  (@@@@  @@@@@  @@@@@      @@@@*  ,@@@@                              \n" +
                "       &@@@@@@@#@@@  @@@@@      @@@@@@@@@@@     @@@@@      @@@@@@@@&      @@@@*    @@@@@@@@@@@  @@@@@       @@@@@@@@@@@                               \n" +
                "                                                                    .@@@@@@%                                             ");
        System.out.println(" \n \uD83E\uDEA6wWhere you'll find ALL your dead palls. MUAHAHAHA! \uD83E\uDEA6 \n");
        System.out.println("The unlucky ones were: ");

        for(Character dead : graveyard){
            System.out.println("✞ \uD83C\uDF44 Here lies  %s the Brave and Mighty %s ".formatted(dead.getName(), dead.getClass().getSimpleName()));
        }
    }

    public void setGraveyard(List<Character> graveyard) { this.graveyard = graveyard; }

    public boolean isBattleFinished() { return battleFinished; }

    public void setBattleFinished(boolean battleFinished) { this.battleFinished = battleFinished; }

}



