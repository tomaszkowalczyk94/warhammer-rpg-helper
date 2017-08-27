package warhammerrpg.core.gameMechanics;

import java.util.Random;

public class Dice {
    private Integer result;

    public Integer oneDiceThrow(){
        Random generator = new Random();
        return generator.nextInt(10);
    }

    public Integer twoDicesThrow(){
        Random generator = new Random();
        return generator.nextInt(90)+10;
    }

}
