package at.nebel.scoreboard;

import java.time.Instant;
import javax.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class LiveMatch {
  private final String homeTeamKey;
  private final String awayTeamKey;

  private MatchScore score = new MatchScore(0, 0);

  private final Instant startedAt = Instant.now();

  public LiveMatch(@NotBlank String homeTeamKey, @NotBlank String awayTeamKey) {
    if (homeTeamKey.equalsIgnoreCase(awayTeamKey)) {
      throw new InvalidTeamException(homeTeamKey, "Same team provided for home and away!");
    }
    this.homeTeamKey = homeTeamKey;
    this.awayTeamKey = awayTeamKey;
  }

  public String getKey() {
    return "#" + homeTeamKey + awayTeamKey;
  }
}
