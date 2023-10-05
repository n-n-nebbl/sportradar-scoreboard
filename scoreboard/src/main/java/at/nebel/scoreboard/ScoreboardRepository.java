package at.nebel.scoreboard;

import java.util.Optional;

public interface ScoreboardRepository {
  void storeLiveMatch(LiveMatch liveMatch);

  Optional<LiveMatch> findLiveMatchForTeam(String teamKey);
}
