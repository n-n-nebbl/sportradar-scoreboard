package at.nebel.scoreboard;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ScoreboardSummaryTest extends AbstractScoreboardTest {
  @Spy private ScoreboardRepository repository = new ScoreboardRepositoryInMemoryImpl();
  @InjectMocks private ScoreboardServiceImpl scoreboard;

  @BeforeEach
  void resetMocks() {
    Mockito.reset(repository);
  }

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
}
