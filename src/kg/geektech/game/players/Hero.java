package kg.geektech.game.players;

public abstract class Hero extends GameEntity  implements HavingSuperPower{
    private SuperPower superPower;

    public Hero(int health, int damage,SuperPower superPower) {
        super(health, damage);
        this.superPower=superPower;
    }

    public SuperPower getSuperPower() {
        return superPower;
    }

    public void setSuperPower(SuperPower superPower) {
        this.superPower = superPower;
    }
}
