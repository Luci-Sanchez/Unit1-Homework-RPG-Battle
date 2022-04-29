package classes;

import java.util.UUID;

public abstract class Character {
    private String id;
    private String name;
    private int hp;
    private boolean isAlive;

    ////////////////////////////////////////////////////////////Contructors/////////////////////////////////////////
    public Character(String name, int hp) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.hp = hp;
        this.isAlive = true;
    }

    public Character() {
    }
    ///////////////////////////////////////////////////////////Getters ///////////////////////////////////////
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isAlive() { return isAlive; }

    //Setting the isAlive property depending on character's health points
    public void setAlive() {
        if (hp > 0) {
            isAlive = true;
        } else {
            isAlive = false;
        }
    }

    ///////////////////////////////////////////////////////////Override Methods///////////////////////////////////////
    @Override    public String toString() {
        return "name=%s, hp=%s, isAlive=%s \n==============\n".formatted(name, hp, isAlive);
    }
    public void chooseCharacter(){
    }
}
