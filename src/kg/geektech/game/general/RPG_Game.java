package kg.geektech.game.general;

import kg.geektech.game.players.*;

public class RPG_Game {
    public static void start() {
        System.out.println("В БОЙ!");
        Boss boss=new Boss(800,55);
        DrownedWoman drownedWoman=new DrownedWoman(100,0);
        HellsDogs hellsDogs=new HellsDogs(300,15);
        Hacker hacker=new Hacker(200,10,SuperPower.TAKE_LIFE);
        Magic magic=new Magic(210,20);
        Medic medBrother=new Medic(225,10,10);
        Medic doctor=new Medic(160,0,50);
        Warrior warrior=new Warrior(300,35);
        Witcher witcher=new Witcher(300,0,SuperPower.LIFE);
        Berserk berserk=new Berserk(200,10,SuperPower.SAVE_DAMAGE_AND_REVERT);
        Hero[] heroes={berserk,hacker,magic,medBrother,doctor,warrior,witcher};

        printStatistics(boss,drownedWoman,hellsDogs,heroes);
        while (!isGameFinished(boss,drownedWoman,hellsDogs,heroes)){
            round(boss,drownedWoman,hellsDogs,heroes);
        }
    }




    private static void round(Boss boss,DrownedWoman drownedWoman,HellsDogs hellsDogs,Hero[] heroes){
      printStatistics(boss,drownedWoman,hellsDogs,heroes);
      heroesHits(boss, drownedWoman, hellsDogs, heroes);
      angryHits(boss, drownedWoman, hellsDogs, heroes);

    }

    private static void angryHits(Boss boss,DrownedWoman drownedWoman,HellsDogs hellsDogs,Hero[] heroes){
        for (int i = 0; i < heroes.length; i++) {
            heroes[i].setHealth(heroes[i].getHealth()- boss.getDamage());
            heroes[i].setHealth(heroes[i].getHealth()- drownedWoman.getDamage());
            heroes[i].setHealth(heroes[i].getHealth()- hellsDogs.getDamage());
        }
    }

    private static void heroesHits(Boss boss,DrownedWoman drownedWoman,HellsDogs hellsDogs,Hero[] heroes){
        for (int i = 0; i < heroes.length; i++) {
            boss.setHealth(boss.getHealth()- heroes[i].getDamage());
            drownedWoman.setHealth(drownedWoman.getHealth()- heroes[i].getDamage());
            hellsDogs.setHealth(hellsDogs.getHealth()- heroes[i].getDamage());
        }
    }

    private static boolean isGameFinished(Boss boss,DrownedWoman drownedWoman,HellsDogs hellsDogs,
                                          Hero[] heroes) {
        if (boss.getHealth() <= 0 && drownedWoman.getHealth()<=0 && hellsDogs.getHealth()<=0) {
            System.out.println("Победу одержали Герои!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth()>0) {
                allHeroesDead=false;
                break;
            }

        }
        if (allHeroesDead){
            System.out.println("Победу одержали Злодеи!");
        }
        return allHeroesDead;

    }

    private static void printStatistics(Boss boss, DrownedWoman drownedWoman, HellsDogs hellsDogs,
                                        Hero[] heroes){
        System.out.println("__________________");
        System.out.println("Boss health: "+ boss.getHealth());
        System.out.println("Drowned Woman health: "+ drownedWoman.getHealth());
        System.out.println("Hells Dogs health: "+hellsDogs.getHealth());
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getClass().getSimpleName()+" health: "+heroes[i].getHealth());
        }
        System.out.println("__________________");


    }

}
