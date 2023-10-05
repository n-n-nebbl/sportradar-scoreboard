package at.nebel.scoreboard;

import java.util.Comparator;

public class MatchScoreComparator implements Comparator<MatchScore> {
  @Override
  public int compare(MatchScore o1, MatchScore o2) {
    return getTotalScore(o1).compareTo(getTotalScore(o2));
  }

  private static Integer getTotalScore(MatchScore o1) {
    return o1.getHomeTeamScore() + o1.getAwayTeamScore();
  }
}
