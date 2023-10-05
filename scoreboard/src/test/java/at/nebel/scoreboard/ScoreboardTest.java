package at.nebel.scoreboard;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ScoreboardTest {

  private static final String HOME_TEAM_KEY = "HOM";
  private static final String AWAY_TEAM_KEY = "AWA";
  private static final String EXPECTED_MATCH_KEY = "#" + HOME_TEAM_KEY + AWAY_TEAM_KEY;

  private ScoreboardServiceImpl scoreboard = new ScoreboardServiceImpl();

  @Test
  void startValidMatch() {
    var matchKey = scoreboard.startMatch(HOME_TEAM_KEY, AWAY_TEAM_KEY);
    Assertions.assertThat(matchKey).isNotNull().isEqualTo(EXPECTED_MATCH_KEY);
  }
}
