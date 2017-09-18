package warhammerrpg.core.gameMechanics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiceTest {

    Dice dice;

    @Before
    public void setUp() throws Exception {
        dice = new Dice();
    }

    @Test
    public void oneDiceThrow() throws Exception {

        for(int i = 0; i<500; i++) {
            Integer integer = dice.oneDiceThrow();
            if(integer<0 || integer>10) {
                Assert.fail();
            }

        }
    }

    @Test
    public void twoDicesThrow() throws Exception {
        for(int i = 0; i<1500; i++) {
            Integer integer = dice.twoDicesThrow();
            if(integer<0 || integer>99) {
                Assert.fail();
            }

        }
    }

}