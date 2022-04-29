package classes;

public class Duel {
    //each fight or round will have two combatants
    private Character currentCombatant1;
    private Character currentCombatant2;

    ////////////////////////////////////////////////////////////Contructors/////////////////////////////////////////
    public Duel(Character currentCombatant1, Character currentCombatant2) {
        this.currentCombatant1 = currentCombatant1;
        this.currentCombatant2 = currentCombatant2;
    }

    ///////////////////////////////////////////////////////////Getters y setters///////////////////////////////////////
    public Character getCurrentCombatant1() { return currentCombatant1; }

    public void setCurrentCombatant1(Character currentCombatant1) { this.currentCombatant1 = currentCombatant1; }

    public Character getCurrentCombatant2() { return currentCombatant2; }

    public void setCurrentCombatant2(Character currentCombatant2) { this.currentCombatant2 = currentCombatant2; }


}
