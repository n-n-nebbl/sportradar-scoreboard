package at.nebel.scoreboard;

import java.util.List;
import java.util.Optional;

public interface ScoreboardRepository {
  void createLiveMatch(LiveMatch liveMatch);

  Optional<LiveMatch> findLiveMatchForTeam(String teamKey);

  /**
   * for the simple case with in-memory and always retrieving all matches you could argue to not put
   * the ordering logic in the service, but usually there would be a parameter for pagination and
   * then the ordering needs to be done already when querying the objects from the database.
   */
  List<LiveMatch> listLiveMatchesOrderedByTotalScoreDescStartingTimeDesc();

  void updateLiveMatch(LiveMatch liveMatch);

  Optional<LiveMatch> findLiveMatch(String matchKey);

  void removeLiveMatch(String matchKey);
}
