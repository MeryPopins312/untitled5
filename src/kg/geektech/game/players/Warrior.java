package kg.geektech.game.players;

public class Warrior extends Hero{


    public Warrior(int health, int damage) {
        super(health, damage, SuperPower.CRITICAL_DAMAGE);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {

    }
}
