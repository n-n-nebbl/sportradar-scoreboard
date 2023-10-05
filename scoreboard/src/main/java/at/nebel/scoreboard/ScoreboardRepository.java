package at.nebel.scoreboard;

import java.util.List;
import java.util.Optional;

public interface ScoreboardRepository {
  void createLiveMatch(LiveMatch liveMatch);

  Optional<LiveMatch> findLiveMatchForTeam(String teamKey);

  List<LiveMatch> listLiveMatches();

  void updateLiveMatch(LiveMatch liveMatch);

  Optional<LiveMatch> findLiveMatch(String matchKey);

  void removeLiveMatch(String matchKey);
}
