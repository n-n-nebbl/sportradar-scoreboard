package at.nebel.scoreboard;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import lombok.Value;

@Value
public class MatchScore {
  @NotNull @PositiveOrZero Integer homeTeamScore;
  @NotNull @PositiveOrZero Integer awayTeamScore;
}
