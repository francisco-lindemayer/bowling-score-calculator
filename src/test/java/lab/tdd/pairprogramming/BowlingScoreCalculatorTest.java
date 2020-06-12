package lab.tdd.pairprogramming;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class BowlingScoreCalculatorTest {

  @Test
  public void playWithStrike() {

    Integer expectedValue = 20;
    Integer actualValue;

    BowlingScoreCalculator calculator = new BowlingScoreCalculator();
    List<Integer> attempts = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 2, 3, 0, 0);

    actualValue = calculator.calculateScore(attempts);

    assertEquals(expectedValue, actualValue);

  }

  @Test
  public void playWithSpare() {

    Integer expectedValue = 17;
    Integer actualValue;

    BowlingScoreCalculator calculator = new BowlingScoreCalculator();
    List<Integer> attempts = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 8, 2, 3, 0, 0);

    actualValue = calculator.calculateScore(attempts);

    assertEquals(expectedValue, actualValue);

  }

  @Test
  public void playWithSpareAndStrike() {

    Integer expectedValue = 133;
    Integer actualValue;

    BowlingScoreCalculator calculator = new BowlingScoreCalculator();
    List<Integer> attempts = Arrays.asList(1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 1, 7, 3, 6, 4, 10, 2, 8, 6);

    actualValue = calculator.calculateScore(attempts);

    assertEquals(expectedValue, actualValue);

  }

  @Test
  public void perfectPlay() {

    Integer expectedValue = 300;
    Integer actualValue;

    BowlingScoreCalculator calculator = new BowlingScoreCalculator();
    List<Integer> attempts = Arrays.asList(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);

    actualValue = calculator.calculateScore(attempts);

    assertEquals(expectedValue, actualValue);

  }

}