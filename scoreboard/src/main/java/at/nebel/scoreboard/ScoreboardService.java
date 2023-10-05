package at.nebel.scoreboard;

public interface ScoreboardService {
  /**
   * Starting a new live match to appear on the scoreboard. <br>
   * Throws {@link TeamAlreadyPlayingException} if one of the teams is already on the scoreboard.
   * <br>
   * Throws {@link InvalidTeamException} if the teams are not different.
   *
   * @param homeTeamKey identifier for the home team participating in the match
   * @param awayTeamKey identifier for the away team participating in the match
   * @return identifier for the started match
   */
  String startMatch(String homeTeamKey, String awayTeamKey);
}
