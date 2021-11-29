package pokemonGoVersion1;

/**
 * @author Tloops
 * @version 1.0
 * @date 2021/11/21 01:48
 */
public class Main {
    public static void main(String[] args) {
        GameSystem gameSystem = new GameSystem();
        gameSystem.startGame();
        gameSystem.goodbye();
    }
}
