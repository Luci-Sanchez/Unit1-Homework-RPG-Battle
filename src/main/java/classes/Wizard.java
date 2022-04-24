package classes;

import interfaces.Attackers;

public class Wizard extends Character  implements Attackers {
    private int mana;
    private int intelligence;

    public Wizard(int id, String name, int hp, boolean isAlive, int mana, int intelligence) {
        super(id, name, hp, isAlive);
        this.mana = mana;
        this.intelligence = intelligence;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
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
