package at.nebel.scoreboard;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ScoreboardFinishMatchTest extends AbstractScoreboardTest {
  @Test
  void verifyMatchNotFoundErrorWhenFinishingMatch() {
    assertThrows(MatchNotFoundException.class, () -> scoreboard.finishMatch("#123321"));
  }

  @Test
  void verifyMatchRemovedFromRepositoryWhenFinishingIt() {
    var matchKey = scoreboard.startMatch(HOME_TEAM_KEY, AWAY_TEAM_KEY);
    scoreboard.finishMatch(matchKey);

    verify(repository, times(1)).removeLiveMatch(matchKey);
    verify(repository, times(1)).removeLiveMatch(anyString());
  }
}
