package classes;

import interfaces.Attackers;

public class Warrior extends Character implements Attackers {

    private int stamina;
    private int strength;
    //TODO add stats limits

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
        //HeavyAttack
        //Disminuyo lo consumido de stamina en -5 puntos
        this.stamina = this.stamina - 5;
        //Defino el daño que realiza: es igual a su strength
        int damage = this.strength;
        return damage;
    }

    @Override
    public int smallAttack() {
        //Weak Attack
        //Restablezco la stamina + 1 punto
        this.stamina = this.stamina + 1;
        //Defino el daño que realiza: es la mitad del strength sin decimales.
        int damage = Math.round(this.strength/2);
        return damage;
    }
}
