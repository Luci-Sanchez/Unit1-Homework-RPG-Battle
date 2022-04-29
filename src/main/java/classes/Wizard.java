package classes;

import interfaces.Attackers;

public class Wizard extends Character implements Attackers {
    private int mana;
    private int intelligence;
    //TODO add stats limits

    ////////////////////////////////////////////////////////////Contructors/////////////////////////////////////////
    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        setMana(mana);
        setIntelligence(intelligence);
    }

    public Wizard() {
    }

    ///////////////////////////////////////////////////////////Getters y Setter///////////////////////////////////////

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if (mana < 10) {
            this.mana = 10;
        } else if (mana > 50) {
            this.mana = 50;
        } else {
            this.mana = mana;
        }

    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        if (intelligence < 1) {
            this.intelligence = 1;
        } else if (intelligence > 50) {
            this.intelligence = 50;
        } else {
            this.intelligence = intelligence;
        }

    }


    ///////////////////////////////////////////////////////////Override Methods///////////////////////////////////////

    @Override
    public void setHp(int hp) {
        if (hp < 50) {
            super.setHp(50);
        } else if (hp > 100) {
            super.setHp(100);
        } else {
            super.setHp(hp);
        }
    }

    @Override
    public void bigAttack(Character receiver) {
        //Fireball
        //The damage is equals to the intelligence
        int damage = this.intelligence;
        receiver.setHp(getHp()-damage);
        //and every fireball will decrease their mana by 5 points.
        this.mana = this.mana - 5;
    }

    @Override
    public void smallAttack(Character receiver) {
        //Staff hit
        //The damage of a staff hit is equals to 2.
        int damage = 2;
        receiver.setHp(getHp()-damage);
        // Every staff hit will recover his mana by 1.
        this.mana = this.mana + 1;
    }

    @Override
    public String toString() {
        return ("Name: %s, Hp: %s, " +
                "Mana: %s, Intelligence: %s " +
                "\n==============\n").formatted(getName(), getHp(), mana, intelligence);
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
