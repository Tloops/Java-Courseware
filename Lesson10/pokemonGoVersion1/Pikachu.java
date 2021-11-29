package pokemonGoVersion1;

/**
 * @author Tloops
 * @version 1.0
 * @date 2021/11/13 21:53
 */
public class Pikachu {
    private String name;
    private int level;
    private int maxHP;
    private int curHP;
    private int attack;
    private int defence;
    private int speed;
    private int roundsToWait = 0;

    private static int basicPowerThunderbolt = 90;
    private static int basicPowerSlam = 80;

    public Pikachu() {
        this("pikachu");
    }

    public Pikachu(String name) {
        this.name = name;
        level = (int)(Math.random() * 10) + 45;
        maxHP = (int)(Math.random() * 50) + 150;
        curHP = maxHP;
        attack = (int)(Math.random() * 10) + 90;
        defence = (int)(Math.random() * 10) + 60;
        speed = (int)(Math.random() * 40) + 90;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public int getCurHP() {
        return curHP;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void refillHP() {
        curHP = maxHP;
        System.out.println("HP becomes " + curHP + "/" + maxHP + " now");
        System.out.printf ("%s is in great condition now!\n", name);
    }

    public void showStatus() {
        System.out.println("----------------------");
        System.out.printf ("|    Name: %-10s|\n", this.name);
        System.out.printf ("|   Level: %-10d|\n", this.level);
        System.out.printf ("|      HP: %3d/%-6d|\n", this.curHP, this.maxHP);
        System.out.printf ("|  Attack: %-10d|\n", this.attack);
        System.out.printf ("| Defence: %-10d|\n", this.defence);
        System.out.printf ("|   Speed: %-10d|\n", this.speed);
        System.out.printf ("|    Wait: %-10d|\n", this.roundsToWait);
        System.out.println("----------------------");
    }

    public void showSkills() {
        System.out.println("  ~~~~~~~~~~~~~~~~~     ~~~~~~~~~~~~~~~~");
        System.out.println("  | 1 Thunderbolt |     |    2 Slam    |");
        System.out.printf ("  | Pwr.: %-3d     |     | Pwr.: %-3d    |\n", basicPowerThunderbolt, basicPowerSlam);
        System.out.println("  | Type: electric|     | Type: physic |");
        System.out.println("  | Acc.: 100%    |     | Acc.: 80%    |");
        System.out.println("  ~~~~~~~~~~~~~~~~~     ~~~~~~~~~~~~~~~~");
    }

    private int calculateDamage(int basicPower, int enemyDefense) {
        return (int)((level * 0.4 + 2) * basicPower * attack / enemyDefense * 10 / 255);
    }

    public void thunderbolt(Pikachu enemy) {
        int damage = calculateDamage(basicPowerThunderbolt, enemy.defence);
//        System.out.println(damage);
        enemy.curHP -= damage;
        enemy.curHP = Math.max(enemy.curHP, 0);
        if(Math.random() < 0.2)
            enemy.roundsToWait = 2;
        System.out.printf("%s used thunderbolt on %s with damage %d.\n", name, enemy.name, damage);
    }

    public void slam(Pikachu enemy) {
        int damage = calculateDamage(basicPowerSlam, enemy.defence);
        if (Math.random() < 0.8) {
            enemy.curHP -= damage;
            enemy.curHP = Math.max(enemy.curHP, 0);
            System.out.printf("%s used slam on %s with damage %d.\n", name, enemy.name, damage);
        }
        else
            System.out.println(name + " used slam, but miss!");
    }

    public static void main(String[] args) {
        Pikachu p = new Pikachu("Java");
        p.showStatus();
        p.showSkills();

        Pikachu enemy = new Pikachu();
        enemy.showStatus();
        p.thunderbolt(enemy);
        enemy.showStatus();

        // Object Array
        Pikachu[] pikachus = new Pikachu[10];
        for (int i = 0; i < 10; i++) {
            pikachus[i] = new Pikachu();
        }
        System.out.println(pikachus[0]);
        pikachus[0].showStatus();
    }
}