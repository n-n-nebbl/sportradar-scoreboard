package at.nebel.scoreboard;

import java.util.List;

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

  /**
   * @return a list of all running live matches ordered first by total score descending then by
   *     startingTime descending
   */
  List<LiveMatch> listLiveMatches();

  /**
   * Update the score of a running match
   * @param matchKey the match to update
   * @param newScore the new score of the match
   */
  void updateScore(String matchKey, MatchScore newScore);

  /**
   * Finish a match by removing it from the scoreboard.
   * @param matchKey the identifier of the match which ended
   */
  void finishMatch(String matchKey);
}
