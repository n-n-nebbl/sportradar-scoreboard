package at.nebel.scoreboard;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TeamAlreadyPlayingException extends RuntimeException {
  private final LiveMatch liveMatch;
}
