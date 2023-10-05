package at.nebel.scoreboard;

import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ScoreboardServiceImpl implements ScoreboardService {

  private final ScoreboardRepository repository;

  @Override
  public String startMatch(String homeTeamKey, String awayTeamKey) {
    var newMatch = new LiveMatch(homeTeamKey, awayTeamKey);
    verifyTeamsNotLiveYet(newMatch);
    repository.storeLiveMatch(newMatch);
    return newMatch.getKey();
  }

  private void verifyTeamsNotLiveYet(LiveMatch newMatch) {
    var existingLiveMatch =
        repository
            .findLiveMatchForTeam(newMatch.getHomeTeamKey())
            .or(() -> repository.findLiveMatchForTeam(newMatch.getAwayTeamKey()));
    if (existingLiveMatch.isPresent()) {
      throw new TeamAlreadyPlayingException(existingLiveMatch.get());
    }
  }

  @Override
  public List<LiveMatch> listLiveMatches() {
    return repository.listLiveMatches();
  }
}
