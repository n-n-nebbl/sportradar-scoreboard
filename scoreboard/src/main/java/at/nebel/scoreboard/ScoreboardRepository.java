package at.nebel.scoreboard;

import java.util.List;
import java.util.Optional;

public interface ScoreboardRepository {
  void createLiveMatch(LiveMatch liveMatch);

  Optional<LiveMatch> findLiveMatchForTeam(String teamKey);

  List<LiveMatch> listLiveMatches();

  void updateLiveMatch(LiveMatch liveMatch);

  Optional<LiveMatch> findMatch(String matchKey);
}
