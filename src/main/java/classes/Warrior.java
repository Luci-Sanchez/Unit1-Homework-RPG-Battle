package classes;

import interfaces.Attackers;

import java.util.List;

public class Warrior extends Character implements Attackers {

    private int stamina;
    private int strength;
    //TODO add stats limits

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        this.stamina = stamina;
        this.strength = strength;
    }

    public Warrior() {

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
    public void bigAttack(Character receiver) {
        //HeavyAttack
        //Disminuyo lo consumido de stamina en -5 puntos
        this.stamina = this.stamina - 5;
        //Defino el daño que realiza: es igual a su strength
        int damage = this.strength;
        receiver.setHp(getHp()-damage);
    }

    @Override
    public void smallAttack(Character receiver) {
        //Weak Attack
        //Restablezco la stamina + 1 punto
        this.stamina = this.stamina + 1;
        //Defino el daño que realiza: es la mitad del strength sin decimales.
        int damage = Math.round(this.strength / 2);
        receiver.setHp(getHp()-damage);
    }

    @Override
    public String toString() {

        return "Name: %s, Hp: %s, Stamina: %s, Strength: %s \n==============\n".formatted(getName(), getHp(), stamina, strength);
    }

}

