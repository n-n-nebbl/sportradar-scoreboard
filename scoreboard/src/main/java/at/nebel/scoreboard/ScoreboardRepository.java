package at.nebel.scoreboard;

import java.util.List;
import java.util.Optional;

public interface ScoreboardRepository {
  void storeLiveMatch(LiveMatch liveMatch);

  Optional<LiveMatch> findLiveMatchForTeam(String teamKey);

  List<LiveMatch> listLiveMatches();
}
