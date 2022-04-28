package classes;

import interfaces.Attackers;

public class Wizard extends Character implements Attackers {
    private int mana;
    private int intelligence;
    //TODO add stats limits


    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        this.mana = mana;
        this.intelligence = intelligence;
    }

    public Wizard() {

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
    public void bigAttack(Character receiver) {
        //Disminuyo lo consumido de mana
        this.mana = this.mana - 5;
        //Defino el daño que realiza
        //que hay que restarselo al strength o intelligence del contrincante
        int damage = this.intelligence;
        receiver.setHp(getHp()-damage);
    }

    @Override
    public void smallAttack(Character receiver) {
        //Disminuyo lo consumido de mana
        this.mana = this.mana + 1;
        //Defino el daño que realiza
        //que hay que restarselo al strength o intelligence del contrincante
        int damage = 2;
        receiver.setHp(getHp()-damage);
    }

    @Override
    public String toString() {

        return "Name: %s, Hp: %s, Mana: %s, Intelligence: %s \n==============\n".formatted(getName(), getHp(), mana, intelligence);
    }

}
