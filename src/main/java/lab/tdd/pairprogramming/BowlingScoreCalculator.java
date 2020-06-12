package lab.tdd.pairprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BowlingScoreCalculator {

  static final int FIRST_ROUND = 1;
  static final int FINAL_ROUND = 10;
  static final int FIRST_ATTEMPT = 1;
  static final int MAX_NUMBER_PINS = 10;
  static final int ATTEMPT_PER_ROUND = 2;
  static final int STRIKE_BONUS = 2;
  static final int SPARE_BONUS = 1;
  static final int INITIAL_BONUS_MULTIPLICATOR = 1;
  static final int ZERO = 0;

  private List<Integer> bonusHistory;
  private int currentRound;
  private Integer pinsIntoTheRound;
  private int bonusMultiplicator;
  private int attemptNumber;
  private Integer result;

  public BowlingScoreCalculator() {
    this.currentRound = FIRST_ROUND;
    this.attemptNumber = FIRST_ATTEMPT;
    this.pinsIntoTheRound = ZERO;
    this.result = ZERO;
    this.bonusHistory = new ArrayList<Integer>();
  }

  public Integer calculateScore(List<Integer> attempts) {

    attempts.forEach(pinsKnockedDown -> {
      addScore(pinsKnockedDown);
      checkBonusHistory(pinsKnockedDown);
      setAttemptNumber(pinsKnockedDown);
    });

    return result;
  }

  private void addScore(Integer score) {
    checkMultiplicator();
    this.result += score * this.bonusMultiplicator;
  }

  private void checkMultiplicator() {

    this.bonusMultiplicator = INITIAL_BONUS_MULTIPLICATOR;

    this.bonusHistory = this.bonusHistory.stream().map(bonus -> {
      if (bonus > ZERO) {
        this.bonusMultiplicator++;
        bonus--;
      }
      return bonus;
    }).collect(Collectors.toList());

  }

  private void checkBonusHistory(Integer pinsKnockedDown) {

    this.pinsIntoTheRound += pinsKnockedDown;

    if (isStrike() && currentRound < FINAL_ROUND) {
      this.bonusHistory.add(STRIKE_BONUS);
    } else if (isSpare() && currentRound < FINAL_ROUND) {
      this.bonusHistory.add(SPARE_BONUS);
    }
  }

  private void setAttemptNumber(Integer pinsKnockedDown) {
    if (this.attemptNumber == ATTEMPT_PER_ROUND || pinsKnockedDown == MAX_NUMBER_PINS) {
      startNewRound();
    } else {
      this.attemptNumber++;
    }
  }

  private void startNewRound() {
    this.currentRound++;
    this.pinsIntoTheRound = ZERO;
    this.attemptNumber = FIRST_ATTEMPT;
  }

  private boolean isStrike() {
    return this.pinsIntoTheRound == MAX_NUMBER_PINS && isRoundStart();
  }

  private boolean isSpare() {
    return this.pinsIntoTheRound == MAX_NUMBER_PINS && !isRoundStart();
  }

  private boolean isRoundStart() {
    return this.attemptNumber == FIRST_ATTEMPT;
  }
}