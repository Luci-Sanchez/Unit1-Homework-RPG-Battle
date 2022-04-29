package classes;

import interfaces.Attackers;

public class Warrior extends Character implements Attackers {

    private int stamina;
    private int strength;
    //TODO add stats limits

    ////////////////////////////////////////////////////////////Contructors/////////////////////////////////////////
    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        this.stamina = stamina;
        this.strength = strength;
    }

    public Warrior() {

    }

    ///////////////////////////////////////////////////////////Getters y Setter///////////////////////////////////////
    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    ///////////////////////////////////////////////////////////Override Methods///////////////////////////////////////

    @Override
    public void bigAttack(Character receiver) {
        //HeavyAttack
        //The damage is equals to their strength
        int damage = this.strength;
        receiver.setHp(getHp()-damage);
        //and every hit will decrease their stamina by 5 points.
        this.stamina = this.stamina - 5;
    }

    @Override
    public void smallAttack(Character receiver) {
        //Weak Attack
        //The damage of a weak attack is the half of the strength (truncate decimals).
        int damage = Math.round(this.strength / 2);
        receiver.setHp(getHp()-damage);
        // Every weak attack will recover his stamina by 1.
        this.stamina = this.stamina + 1;
    }

    @Override
    public String toString() {
        return ("Name: %s, Hp: %s, " +
                "Stamina: %s, Strength: %s " +
                "\n==============\n").formatted(getName(), getHp(), stamina, strength);
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////


}

