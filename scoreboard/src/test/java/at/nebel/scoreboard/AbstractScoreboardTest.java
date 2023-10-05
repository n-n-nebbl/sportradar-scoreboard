package at.nebel.scoreboard;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;

public abstract class AbstractScoreboardTest {
  protected static final String HOME_TEAM_KEY = "HOM";
  protected static final String AWAY_TEAM_KEY = "AWA";
  protected static final String OTHER_TEAM_KEY = "123";

  @Spy protected ScoreboardRepository repository = new ScoreboardRepositoryInMemoryImpl();
  @InjectMocks protected ScoreboardServiceImpl scoreboard;

  @BeforeEach
  void resetMocks() {
    Mockito.reset(repository);
  }
}
