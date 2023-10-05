package at.nebel.scoreboard;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LiveMatch {
  @Getter private final String homeTeamKey;
  @Getter private final String awayTeamKey;

  public String getKey() {
    return "#" + homeTeamKey + awayTeamKey;
  }
}
