package pokemonGoVersion1;

import java.util.Scanner;

/**
 * @author Tloops
 * @version 1.0
 * @date 2021/11/21 00:41
 */
public class GameSystem {
    private Scanner in;
    private Pikachu myPikachu;
    private static final int MAX_NAME_LENGTH = 9;

    public GameSystem() {
        greeting();
        in = new Scanner(System.in);
        String name = getName();
        myPikachu = new Pikachu(name);
        System.out.println("Congratulation! You got a pikachu: ");
        myPikachu.showStatus();
    }

    public void startGame() {
        while (true) {
            System.out.println();
            System.out.println("------------------------------------------------");
            System.out.println("|    1 Adventure     2 Fill HP      3 Exit     |");
            System.out.println("------------------------------------------------");
            System.out.println("Choose a thing you want to do: (input 1, 2 or 3)");

            String input = in.nextLine();
            if (input.length() == 1
                    && (input.charAt(0) == '1' || input.charAt(0) == '2' || input.charAt(0) == '3')) {
                boolean isExit = false;
                switch (Integer.parseInt(input)) {
                    case 1:
                        battle();
                        break;
                    case 2:
                        fillHP();
                        break;
                    case 3:
                        isExit = true;
                }

                if (isExit)
                    break;
            }
            else
                System.out.println("Wrong input!!!");
        }
    }

    private void greeting() {
        System.out.print(
                ",-.----.                                                                                             \n" +
                "\\    /  \\                  ,-.                    ____                          ,----..              \n" +
                "|   :    \\             ,--/ /|                  ,'  , `.                       /   /   \\             \n" +
                "|   |  .\\ :   ,---.  ,--. :/ |               ,-+-,.' _ |   ,---.        ,---, |   :     :    ,---.   \n" +
                ".   :  |: |  '   ,'\\ :  : ' /             ,-+-. ;   , ||  '   ,'\\   ,-+-. /  |.   |  ;. /   '   ,'\\  \n" +
                "|   |   \\ : /   /   ||  '  /      ,---.  ,--.'|'   |  || /   /   | ,--.'|'   |.   ; /--`   /   /   | \n" +
                "|   : .   /.   ; ,. :'  |  :     /     \\|   |  ,', |  |,.   ; ,. :|   |  ,\"' |;   | ;  __ .   ; ,. : \n" +
                ";   | |`-' '   | |: :|  |   \\   /    /  |   | /  | |--' '   | |: :|   | /  | ||   : |.' .''   | |: : \n" +
                "|   | ;    '   | .; :'  : |. \\ .    ' / |   : |  | ,    '   | .; :|   | |  | |.   | '_.' :'   | .; : \n" +
                ":   ' |    |   :    ||  | ' \\ \\'   ;   /|   : |  |/     |   :    ||   | |  |/ '   ; : \\  ||   :    | \n" +
                ":   : :     \\   \\  / '  : |--' '   |  / |   | |`-'       \\   \\  / |   | |--'  '   | '/  .' \\   \\  /  \n" +
                "|   | :      `----'  ;  |,'    |   :    |   ;/            `----'  |   |/      |   :    /    `----'   \n" +
                "`---'.|              '--'       \\   \\  /'---'                     '---'        \\   \\ .'              \n" +
                "  `---`                          `----'                                         `---`                \n"
        );
        System.out.println("Welcome to my PokemonGo game!!!");
    }

    private String getName() {
        String result;
        while (true) {
            System.out.print("Please give your pikachu a name: ");
            result = in.nextLine();
            if (result.length() <= MAX_NAME_LENGTH)
                return result;
            else
                System.out.println("Input name too long. Please try a shorter one.");
        }
    }

    private void battle() {
        // randomly generate an enemy
        System.out.println();
        System.out.println("You encountered a pikachu.");
        Pikachu enemy = new Pikachu();

        while (true) {
            System.out.println("------------------------------------------------");
            System.out.println("|   1 Fight   2 See his status    3 Run away   |");
            System.out.println("------------------------------------------------");
            System.out.println("Choose a thing you want to do: (input 1, 2 or 3)");

            String input = in.nextLine();
            if (input.length() == 1
                    && (input.charAt(0) == '1' || input.charAt(0) == '2' || input.charAt(0) == '3')) {
                boolean isEnd = false;
                switch (Integer.parseInt(input)) {
                    case 1:
                        fight(enemy);
                        isEnd = true;
                        break;
                    case 2:
                        enemy.showStatus();
                        break;
                    case 3:
                        isEnd = true;
                }

                if (isEnd)  break;
            }
            else
                System.out.println("Wrong input!!!");
        }
    }

    private void fight(Pikachu enemy) {
        while (myPikachu.getCurHP() > 0 && enemy.getCurHP() > 0) {
            myPikachu.showSkills();
            System.out.println("Choose a skill to perform on your enemy: (input 1 or 2)");

            String input = in.nextLine();
            if (input.length() == 1
                    && (input.charAt(0) == '1' || input.charAt(0) == '2')) {
                char choice = input.charAt(0);
                if (choice == '1')
                    myPikachu.thunderbolt(enemy);
                else
                    myPikachu.slam(enemy);
            }

            showFightStatus(enemy);

            if (myPikachu.getCurHP() <= 0 || enemy.getCurHP() <= 0)
                break;

            enemy.slam(myPikachu);
            showFightStatus(enemy);
        }
        System.out.println(myPikachu.getCurHP() == 0 ? enemy.getName() : myPikachu.getName() + " wins!!");
    }

    private void showFightStatus(Pikachu enemy) {
        System.out.println("|-----------------------|");
        System.out.printf ("| %-9s | %-9s |\n", myPikachu.getName(), enemy.getName());
        System.out.printf ("| %4d/%-4d | %4d/%-4d |\n", myPikachu.getCurHP(), myPikachu.getMaxHP(),
                                                        enemy.getCurHP(), enemy.getMaxHP());
        System.out.println("|-----------------------|");
    }

    private void fillHP() {
        myPikachu.refillHP();
        // coin system
    }

    public void goodbye() {
        System.out.println();
        System.out.println("|======================|");
        System.out.println("|  Thanks for playing  |");
        System.out.println("| Tloops @ SUSTech CSE |");
        System.out.println("|======================|");
    }
}
