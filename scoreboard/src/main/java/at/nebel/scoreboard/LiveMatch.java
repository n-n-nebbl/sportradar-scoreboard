package at.nebel.scoreboard;

import javax.validation.constraints.NotBlank;
import lombok.Getter;

public class LiveMatch {
  @Getter private final String homeTeamKey;
  @Getter private final String awayTeamKey;

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
