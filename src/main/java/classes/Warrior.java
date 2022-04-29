package classes;

import interfaces.Attackers;

public class Warrior extends Character implements Attackers {

    private int stamina;
    private int strength;
    //TODO add stats limits

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        setStamina(stamina);
        setStrength(strength);
    }


    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        if (stamina < 10) {
            this.stamina = 10;
        } else if (stamina > 50) {
            this.stamina = 50;
        } else {
            this.stamina = stamina;
        }
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        if (strength < 1) {
            this.strength = 1;
        } else if (strength > 10) {
            this.strength = 10;
        } else {
            this.strength = strength;
        }

    }

    @Override
    public void setHp(int hp) {
        if (hp < 100) {
            super.setHp(100);
        } else if (hp > 200) {
            super.setHp(200);
        } else {
            super.setHp(hp);
        }
    }

    @Override
    public void bigAttack(Character receiver) {
        //HeavyAttack
        //Disminuyo lo consumido de stamina en -5 puntos
        this.stamina = this.stamina - 5;
        //Defino el daño que realiza: es igual a su strength
        int damage = this.strength;
        receiver.setHp(getHp() - damage);
    }

    @Override
    public void smallAttack(Character receiver) {
        //Weak Attack
        //Restablezco la stamina + 1 punto
        this.stamina = this.stamina + 1;
        //Defino el daño que realiza: es la mitad del strength sin decimales.
        int damage = Math.round(this.strength / 2);
        receiver.setHp(getHp() - damage);
    }

    @Override
    public String toString() {

        return "Name: %s, Hp: %s, Stamina: %s, Strength: %s \n==============\n".formatted(getName(), getHp(), stamina, strength);
    }

}

