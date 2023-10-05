# sportradar-scoreboard

## requirements

The scoreboard supports the following operations:

1. Start a new match, assuming initial score 0 – 0 and adding it the scoreboard.
   This should capture following parameters:
   a. Home team
   b. Away team
2. Update score. This should receive a pair of absolute scores: home team score and away
   team score.
3. Finish match currently in progress. This removes a match from the scoreboard.
4. Get a summary of matches in progress ordered by their total score. The matches with the
   same total score will be returned ordered by the most recently started match in the
   scoreboard.

## assumptions

* teams can be identified by a string with a length of 3
* a team can only participate once on the scoreboard
* a team can not compete against itself
* there will be a framework checking the validation annotations --> no manual check if parameters or attributes are correct
* an actual implementation of a repository would make use of transactions --> no special handling for concurrent access. would be to complex for this case and could be done e.g. with locks.
