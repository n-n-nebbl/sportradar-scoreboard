package at.nebel.scoreboard;

import lombok.Getter;

@Getter
public class MatchNotFoundException extends RuntimeException {
  private final String matchKey;

  public MatchNotFoundException(String matchKey, String message) {
    super(message);
    this.matchKey = matchKey;
  }
}
