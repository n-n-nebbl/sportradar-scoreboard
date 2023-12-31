package at.nebel.scoreboard;

import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ScoreboardServiceImpl implements ScoreboardService {

  private final ScoreboardRepository repository;

  @Override
  public String startMatch(String homeTeamKey, String awayTeamKey) {
    var newMatch = new LiveMatch(homeTeamKey, awayTeamKey);
    verifyTeamsNotLiveYet(newMatch);
    repository.createLiveMatch(newMatch);
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
    return repository.listLiveMatchesOrderedByTotalScoreDescStartingTimeDesc();
  }

  @Override
  public void updateScore(String matchKey, MatchScore newScore) {
    var liveMatchOpt = repository.findLiveMatch(matchKey);
    if (liveMatchOpt.isEmpty()) {
      throw new MatchNotFoundException(matchKey, "Could not find running match to update score!");
    }
    var liveMatch = liveMatchOpt.get();
    liveMatch.updateScore(newScore);

    repository.updateLiveMatch(liveMatch);
  }

  @Override
  public void finishMatch(String matchKey) {
    var liveMatchOpt = repository.findLiveMatch(matchKey);
    if (liveMatchOpt.isEmpty()) {
      throw new MatchNotFoundException(matchKey, "Could not find running match to finish!");
    }
    repository.removeLiveMatch(matchKey);
  }
}
