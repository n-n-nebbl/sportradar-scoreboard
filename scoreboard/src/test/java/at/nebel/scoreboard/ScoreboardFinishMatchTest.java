package at.nebel.scoreboard;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ScoreboardFinishMatchTest extends AbstractScoreboardTest {
  @Test
  void verifyMatchNotFoundErrorWhenFinishingMatch() {
    assertThrows(MatchNotFoundException.class, () -> scoreboard.finishMatch("#123321"));
  }
}
