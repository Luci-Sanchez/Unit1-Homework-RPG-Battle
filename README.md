# RPG battle simulator :mage: :crossed_swords: :elf_woman: :joystick:

### Authors
The LLIJ Team: Lucía Sánchez, Lisa Medina, Italia Herrera and Josefina Cresta.

### Usage

1. Clone or Download the project from the repository.

2. Open the directory as a project on a IDE as IntelliJ.

3. Run the Main.java file on the path:

```
./src/main/java/Main/Main.java  
```

You can play in our RPG battle simulator, where you can create a party of warriors and wizards to fight other parties to determine the winner. 
We have two types of characters, warriors and wizards who have different attributes and combat styles:

- WARRIORS are strong well armored characters that focus on the attribute strength. Every round a warrior will try to do a “Heavy attack”. 
  The  damage of a heavy attack is equals to their strength and every hit will decrease their stamina by 5 points. If he can’t make a heavy attack   he will do a “Weak attack”. The damage of a weak attack is the half of the strength. Every weak attack will recover his stamina by 1.
  
- WIZARDS are the masters of the arcane their main attribute is intelligence. Every round a wizard will try to cast a “Fireball”. The damage of a     fireball is equals to his intelligence and every fireball will decrease their mana by 5 points. If he can’t cast a fireball he will do a “Staff     hit”. The damage of a staff hit is equals to 2. Every staff hit will recover his mana by 1.

Game RULES:

- The characters are grouped in parties and the battle is between 2 parties. So before the battle begins you will need to add warriors or wizards in both parties (could be mixed with warriors and wizards).

- The battles are 1 vs 1. So you can choose between members of the party to duel another member from the rival party.

- The battle happens by rounds, in each round both combatants attack at the same time (so you even if one combatant does the killing blow both will take     damage). So the combat could end in a tie.

- When a round is over the winner returns to the party and the loser is removed and sent to the graveyard. Then, you can choose thecombatants for the next duel.

- When a party loses all their members, a winner party is declared!

ENJOY PLAYING!! :checkered_flag:
