package warhammerrpg.GameMechanics;

import java.util.Random;

public class Dice {
    private Integer result;

    public Integer oneDiceThrow(){
        Random generator = new Random();
        return generator.nextInt(10);
    }

    public Integer twoDiceThrow(){
        Random generator = new Random();
        return generator.nextInt(90)+10;
    }

    /* test obiektu
    public static void main(String args[])
    {
        Dice obj = new Dice();
        System.out.println(obj.oneDiceThrow());
        System.out.println(obj.twoDiceThrow());
    }
    */
}
