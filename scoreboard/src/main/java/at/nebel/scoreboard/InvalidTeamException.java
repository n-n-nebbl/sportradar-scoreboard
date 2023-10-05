package at.nebel.scoreboard;

import lombok.Getter;

@Getter
public class InvalidTeamException extends RuntimeException {
  private final String teamKey;

  public InvalidTeamException(String teamKey, String message) {
    super(message);
    this.teamKey = teamKey;
  }
}
