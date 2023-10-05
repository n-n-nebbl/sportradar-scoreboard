package at.nebel.scoreboard;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ScoreboardUpdateScoreTest extends AbstractScoreboardTest {

  @Test
  void verifyUpdateScore() {
    var matchKey = scoreboard.startMatch(HOME_TEAM_KEY, AWAY_TEAM_KEY);

    var newHomeScore = 1;
    var newAwayScore = 0;
    var newScore = new MatchScore(newHomeScore, newAwayScore);
    scoreboard.updateScore(matchKey, newScore);

    var argumentCaptor = ArgumentCaptor.forClass(LiveMatch.class);
    verify(repository, times(1)).updateLiveMatch(argumentCaptor.capture());
    var updatedLiveMatch = argumentCaptor.getValue();
    assertThat(updatedLiveMatch).isNotNull();
    assertThat(updatedLiveMatch.getKey()).isEqualTo(matchKey);
    assertThat(updatedLiveMatch.getScore().getHomeTeamScore()).isEqualTo(newHomeScore);
    assertThat(updatedLiveMatch.getScore().getAwayTeamScore()).isEqualTo(newAwayScore);
  }

  @Test
  void verifyMatchNotFoundErrorWhenUpdatingScore() {
    var newScore = new MatchScore(1, 0);
    assertThrows(MatchNotFoundException.class, () -> scoreboard.updateScore("#123321", newScore));
  }
}
