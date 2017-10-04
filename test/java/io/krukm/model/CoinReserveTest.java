package io.krukm.model;

import org.junit.Test;

import java.util.Stack;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class CoinReserveTest {

    private CoinReserve coinReserve = new CoinReserve();
    private Stack<Coin> change = new Stack<>();

    @Test
    public void rejectOneWhenAdded() {
        assertFalse(coinReserve.coinAccepted(Coin.COIN_ONE));
    }

    @Test
    public void acceptFiveWhenAdded() {
        assertTrue(coinReserve.coinAccepted(Coin.COIN_TWO));
    }

    @Test
    public void acceptTenWhenAdded() {
        assertTrue(coinReserve.coinAccepted(Coin.COIN_THREE));
    }

    @Test
    public void acceptTwentyFiveWhenAdded() {
        assertTrue(coinReserve.coinAccepted(Coin.COIN_FOUR));
    }

    @Test
    public void addFiveToFiveStackWhenAccepted() {
        coinReserve.addCoin(Coin.COIN_TWO);
        assertFalse(coinReserve.coinTwoSleeve.empty());
    }

    @Test
    public void addTenToTenStackWhenAccepted() {
        coinReserve.addCoin(Coin.COIN_THREE);
        assertFalse(coinReserve.coinThreeSleeve.empty());
    }

    @Test
    public void addTwentyFiveToTwentyFiveStackWhenAccepted() {
        coinReserve.addCoin(Coin.COIN_FOUR);
        assertFalse(coinReserve.coinFourSleeve.empty());
    }

    @Test
    public void addTenFivesWhenReserveIsStocked() {
        coinReserve.stockReserve();
        assertEquals(10, coinReserve.coinTwoSleeve.size());
    }

    @Test
    public void addTenTensWhenReserveIsStocked() {
        coinReserve.stockReserve();
        assertEquals(10, coinReserve.coinThreeSleeve.size());
    }

    @Test
    public void addTenTwentyFivesWhenReserveIsStocked() {
        coinReserve.stockReserve();
        assertEquals(10, coinReserve.coinFourSleeve.size());
    }

    @Test
    public void getTheContentsOfCoinReserveWhenReserveTotalCalled() {
        coinReserve.coinFourSleeve.add(Coin.COIN_FOUR);
        coinReserve.coinThreeSleeve.add(Coin.COIN_THREE);
        coinReserve.coinThreeSleeve.add(Coin.COIN_THREE);
        coinReserve.coinTwoSleeve.add(Coin.COIN_TWO);

        change.add(Coin.COIN_TWO);
        change.add(Coin.COIN_THREE);
        change.add(Coin.COIN_THREE);
        change.add(Coin.COIN_FOUR);

        assertEquals(change, coinReserve.reserveTotal());
    }

    @Test
    public void removeFiveWithRemoveCoin() {
        coinReserve.stockReserve();
        coinReserve.removeCoin(coinReserve.coinTwoSleeve);
        assertEquals(9, coinReserve.coinTwoSleeve.size());
    }

    @Test
    public void removeTenWithRemoveCoin() {
        coinReserve.stockReserve();
        coinReserve.removeCoin(coinReserve.coinThreeSleeve);
        assertEquals(9, coinReserve.coinThreeSleeve.size());
    }

    @Test
    public void removeTwentyFiveWithRemoveCoin() {
        coinReserve.stockReserve();
        coinReserve.removeCoin(coinReserve.coinFourSleeve);
        assertEquals(9, coinReserve.coinFourSleeve.size());
    }

    @Test
    public void getCoinTotalWhenUsingStackTotalMethod() {
        change.push(Coin.COIN_TWO);
        change.push(Coin.COIN_THREE);
        change.push(Coin.COIN_FOUR);
        assertEquals((Coin.COIN_TWO.value + Coin.COIN_THREE.value + Coin.COIN_FOUR.value), coinReserve.stackTotal(change));
    }

    @Test
    public void whenOverpaidForProductAddChangeToCoinReturn() {
        coinReserve.stockReserve();
        coinReserve.makeChange(100, 125);
        assertEquals(25, coinReserve.stackTotal(coinReserve.coinReturn));
    }

    @Test
    public void whenOverPaidAndReserveIsOutOfCoinFourMakeChangeWithCoinThreeAndCoinTwo() {
        change.push(Coin.COIN_THREE);
        change.push(Coin.COIN_THREE);
        change.push(Coin.COIN_TWO);
        coinReserve.stockReserve();
        coinReserve.coinFourSleeve.removeAllElements();
        coinReserve.makeChange(100, 125);
        assertEquals(change, coinReserve.coinReturn);
    }

    @Test
    public void whenOverPaidAndReserveIsOutOfCoinFourAndCoinThreeMakeChangeWithCoinTwo() {
        for (int i = 0; i < 5; i++) {
            change.push(Coin.COIN_TWO);
        }
        coinReserve.stockReserve();
        coinReserve.coinFourSleeve.removeAllElements();
        coinReserve.coinThreeSleeve.removeAllElements();
        coinReserve.makeChange(100, 125);
        assertEquals(change, coinReserve.coinReturn);
    }

    @Test
    public void whenOverPaidAndReserveIsOutOfCoinThreeMakeChangeWithCoinFourAndCoinTwo() {
        change.push(Coin.COIN_FOUR);
        for (int i = 0; i < 3; i++) {
            change.push(Coin.COIN_TWO);
        }
        coinReserve.stockReserve();
        coinReserve.coinThreeSleeve.removeAllElements();
        coinReserve.makeChange(100, 140);
        assertEquals(change, coinReserve.coinReturn);
    }

    @Test
    public void whenCoinReturnRequestedReturnCoins() {
        change.push(Coin.COIN_FOUR);
        change.push(Coin.COIN_FOUR);
        change.push(Coin.COIN_FOUR);
        change.push(Coin.COIN_THREE);
        change.push(Coin.COIN_TWO);
        coinReserve.coinReturn.push(Coin.COIN_FOUR);
        coinReserve.coinReturn.push(Coin.COIN_FOUR);
        coinReserve.coinReturn.push(Coin.COIN_FOUR);
        coinReserve.coinReturn.push(Coin.COIN_THREE);
        coinReserve.coinReturn.push(Coin.COIN_TWO);
        assertEquals(change, coinReserve.activateCoinReturn());
    }

    @Test
    public void whenCoinReturnRequestedClearCoinReturn() {
        coinReserve.coinReturn.push(Coin.COIN_FOUR);
        coinReserve.coinReturn.push(Coin.COIN_FOUR);
        coinReserve.coinReturn.push(Coin.COIN_FOUR);
        coinReserve.coinReturn.push(Coin.COIN_THREE);
        coinReserve.coinReturn.push(Coin.COIN_TWO);
        coinReserve.activateCoinReturn();
        assertTrue(coinReserve.coinReturn.empty());
    }

    @Test
    public void checkCoinReserveToMakeSureChangeCanBeMadeIfOverPaid() {
        coinReserve.stockReserve();
        assertTrue(coinReserve.canMakeChange());
    }

    @Test
    public void whenTwentyFiveStackIsEmptyMakeSureChangeCanBeMadeWithTensAndOnes() {
        coinReserve.stockReserve();
        coinReserve.coinFourSleeve.removeAllElements();
        assertTrue(coinReserve.canMakeChange());
    }

    @Test
    public void whenFiveStackIsEmptyAndTenStackHasOneMakeSureChangeCanNotBeMade() {
        coinReserve.coinThreeSleeve.add(Coin.COIN_THREE);
        assertFalse(coinReserve.canMakeChange());
    }
}
