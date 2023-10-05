package at.nebel.scoreboard;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ScoreboardSummaryTest extends AbstractScoreboardTest {

  @Test
  void verifySummaryStartsEmpty() {
    var summary = scoreboard.listLiveMatches();
    assertThat(summary).isEmpty();
  }

  @Test
  void verifyStartedMatchIsInSummary() {
    var matchKey = scoreboard.startMatch(HOME_TEAM_KEY, AWAY_TEAM_KEY);
    var summary = scoreboard.listLiveMatches();
    assertThat(summary).isNotEmpty().hasSize(1);
    assertThat(summary.get(0).getKey()).isEqualTo(matchKey);
  }

  @Test
  void verifyOrderingOfMatchesWithSameScore() {
    var matchKeyEarlier = scoreboard.startMatch(HOME_TEAM_KEY, AWAY_TEAM_KEY);
    var matchKeyLater = scoreboard.startMatch("123", "321");

    var summary = scoreboard.listLiveMatches();

    assertThat(summary).isNotEmpty().hasSize(2);
    assertThat(summary.get(0).getKey()).isEqualTo(matchKeyLater);
    assertThat(summary.get(1).getKey()).isEqualTo(matchKeyEarlier);
  }

  @Test
  void verifyOrderingOfMatchesWithDifferentScore() {
    var matchKeyEarlier = scoreboard.startMatch(HOME_TEAM_KEY, AWAY_TEAM_KEY);
    var matchKeyLater = scoreboard.startMatch("123", "321");

    //    scoreboard.updateScore(matchKeyEarlier, new MatchScore(1, 0));

    var summary = scoreboard.listLiveMatches();

    assertThat(summary).isNotEmpty().hasSize(2);
    assertThat(summary.get(0).getKey()).isEqualTo(matchKeyEarlier);
    assertThat(summary.get(1).getKey()).isEqualTo(matchKeyLater);
  }
}
