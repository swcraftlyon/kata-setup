package tennis;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class TennisSpec {

    private int playerOneBalls;
    private int playerBBalls;

    @Test
    public void scoreStartsAs_loveLove() {
	assertThat(score()).isEqualTo("love-love");
    }
    
    @Test
    public void playAScoresOnce() {
	playerAScores();
	assertThat(score()).isEqualTo("fifteen-love");
    }
    
    @Test
    public void playerBScoresOnce() {
	playerBScores();
	assertThat(score()).isEqualTo("love-fifteen");
    }
    
    private void playerBScores() {
	playerBBalls++;
    }

    @Test
    public void playAScoresTwice() {
	playerAScores();
	playerAScores();
	assertThat(score()).isEqualTo("thirteen-love");
    }

    private void playerAScores() {
	playerOneBalls++;
    }

    private String score() {
	if (playerBBalls == 1) return "love-fifteen";
	if (playerOneBalls == 2) return "thirteen-love";
	if (playerOneBalls == 1) return "fifteen-love";
	if (playerOneBalls == 0) return "love-love";
	else throw new RuntimeException("not implemented");
    }

}
