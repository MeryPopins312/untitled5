package kg.geektech.game.players;

public class Magic extends Hero {
    public Magic(int health, int damage) {
        super(health, damage, SuperPower.BOOST);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {

    }
}
