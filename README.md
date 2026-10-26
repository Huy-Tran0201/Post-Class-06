# Chapter 5 – Exercises 8, 9, 10

Unit testing the private method `PokerHand.isStraightFlush()` and measuring
statement / branch coverage (*Introduction to Software Design with Java*, M. P. Robillard).

| Exercise | Goal | Min. UUT executions |
|---|---|---|
| 8  | A "true" test + all straight flushes (9 runs x 4 suits = 36); not exhaustive | 1 (36 for all true cases) |
| 9  | Statement coverage 100% | 2 (`True` + `WrongSuit` or `WrongRank`) |
| 10 | Branch coverage 100% | 3 (`True` + `WrongSuit` + `WrongRank`) |

## Run
- Java 21, Maven, JUnit 5.
- Eclipse: *File > Import > Maven > Existing Maven Projects*, then *Run As > JUnit Test* (or *Coverage As > JUnit Test*).
- Command line: `mvn test` – JaCoCo report in `target/site/jacoco/index.html`.
