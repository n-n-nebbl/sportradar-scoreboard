package at.nebel.scoreboard;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ScoreboardTest {

  private static final String HOME_TEAM_KEY = "HOM";
  private static final String AWAY_TEAM_KEY = "AWA";
  private static final String OTHER_TEAM_KEY = "123";
  private static final String EXPECTED_MATCH_KEY = "#" + HOME_TEAM_KEY + AWAY_TEAM_KEY;

  @Mock private ScoreboardRepository repository;
  @InjectMocks private ScoreboardServiceImpl scoreboard;

  @Test
  void startValidMatch() {
    var matchKey = scoreboard.startMatch(HOME_TEAM_KEY, AWAY_TEAM_KEY);
    assertThat(matchKey).isNotNull().isEqualTo(EXPECTED_MATCH_KEY);
  }

  @Test
  void startMatchTwoTimes() {
    scoreboard.startMatch(HOME_TEAM_KEY, AWAY_TEAM_KEY);
    assertThrows(
        TeamAlreadyPlayingException.class,
        () -> scoreboard.startMatch(HOME_TEAM_KEY, AWAY_TEAM_KEY));
  }

  @Test
  void startMatchWithSameTeam() {
    assertThrows(
        InvalidTeamException.class, () -> scoreboard.startMatch(HOME_TEAM_KEY, HOME_TEAM_KEY));
  }

  @Test
  void startTwoMatchesForSameTeam() {
    scoreboard.startMatch(HOME_TEAM_KEY, AWAY_TEAM_KEY);
    assertThrows(
        TeamAlreadyPlayingException.class,
        () -> scoreboard.startMatch(HOME_TEAM_KEY, OTHER_TEAM_KEY));
    assertThrows(
        TeamAlreadyPlayingException.class,
        () -> scoreboard.startMatch(OTHER_TEAM_KEY, AWAY_TEAM_KEY));
  }
}
