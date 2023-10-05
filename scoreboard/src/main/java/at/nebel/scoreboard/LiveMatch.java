package at.nebel.scoreboard;

import java.time.Instant;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;

@Getter
public class LiveMatch {
  @NotBlank
  @Size(min = 3, max = 3)
  private final String homeTeamKey;

  @NotBlank
  @Size(min = 3, max = 3)
  private final String awayTeamKey;

  @NotNull private MatchScore score = new MatchScore(0, 0);

  // if it would not be the easiest solution with in-memory repository, this would not be final to
  // be able to set it when loaded from the actual store
  private final Instant startedAt = Instant.now();

  public LiveMatch(String homeTeamKey, String awayTeamKey) {
    if (homeTeamKey.equalsIgnoreCase(awayTeamKey)) {
      throw new InvalidTeamException(homeTeamKey, "Same team provided for home and away!");
    }
    this.homeTeamKey = homeTeamKey;
    this.awayTeamKey = awayTeamKey;
  }

  public String getKey() {
    return "#" + homeTeamKey + awayTeamKey;
  }

  public void updateScore(MatchScore newScore) {
    this.score = newScore;
  }
}
