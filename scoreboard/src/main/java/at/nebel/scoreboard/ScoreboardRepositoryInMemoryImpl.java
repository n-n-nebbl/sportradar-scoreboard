package at.nebel.scoreboard;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Repository for the currently running matches for the scoreboard. <br>
 * Usually i would create this implementation in the test-classes to be able to test the service on
 * its own and create a "real" repository with its own test cases.
 */
public class ScoreboardRepositoryInMemoryImpl implements ScoreboardRepository {

  private final List<LiveMatch> matches = new ArrayList<>();

  @Override
  public void storeLiveMatch(LiveMatch liveMatch) {
    matches.add(liveMatch);
  }

  @Override
  public Optional<LiveMatch> findLiveMatchForTeam(String teamKey) {
    return matches.stream()
        .filter(
            match ->
                match.getHomeTeamKey().equalsIgnoreCase(teamKey)
                    || match.getAwayTeamKey().equalsIgnoreCase(teamKey))
        .findAny();
  }
}
