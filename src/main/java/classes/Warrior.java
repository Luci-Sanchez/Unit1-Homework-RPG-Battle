package classes;

import interfaces.Attackers;

public class Warrior extends Character implements Attackers {

    private int stamina;
    private int strength;

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        this.stamina = stamina;
        this.strength = strength;
    }

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


    @Override
    public int bigAttack() {
        //Disminuyo lo consumido de mana
        this.mana = this.mana - 5;
        //Defino el daño que realiza
        //que hay que restarselo al strength o intelligence del contrincante
        int damage = this.intelligence;
        return damage;
    }

    @Override
    public int smallAttack() {
        //Disminuyo lo consumido de mana
        this.mana = this.mana + 1;
        //Defino el daño que realiza
        //que hay que restarselo al strength o intelligence del contrincante
        int damage = 2;
        return damage;
    }
}
