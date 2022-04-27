package classes;

import java.util.UUID;

public abstract class Character {
    private String id;
    private String name;
    private int hp;
    private boolean isAlive;

    public Character(String name, int hp) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.hp = hp;
        this.isAlive = true;
    }

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

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    /*@Override
    public String toString() {
        return "\t" + "Character:" +
                "\t" +"id='" + id + '\n' +
                "\t" +"name='" + name + '\n' +
                "\t" +"hp=" + hp +'\n' +
                "\t" +"isAlive=" + isAlive + '\n' +
                "==============\n";
    }*/

   /* @Override    public String toString() {
        return String.format("%s, %s, %s, %s, %s",
                "id='" + id + '\t', ", name='" + name + '\t', ", hp=" + hp + '\t' , ", isAlive=" + isAlive +'\n', "\n ==============\n");
    }*/

     @Override    public String toString() {
         return "id=%s, name=%s, hp=%s, isAlive=%s \n==============\n".formatted(id, name, hp, isAlive);
    }
}
