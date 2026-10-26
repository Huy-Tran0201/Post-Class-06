package chapter5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TestPokerHand {

	 static boolean invokeIsStraightFlush(PokerHand pHand) {
		try {
			Method method = PokerHand.class.getDeclaredMethod("isStraightFlush");
			method.setAccessible(true);
			return (boolean) method.invoke(pHand);
		} catch (ReflectiveOperationException e) {
			e.printStackTrace();
			fail();
			return false;
		}
	}


	// Exercise 8: one test case with a "true" outcome
	@Test
	void testIsStraightFlush_True() {
		PokerHand hand = new PokerHand(
				Card.get(Rank.TWO, Suit.CLUBS),
				Card.get(Rank.THREE, Suit.CLUBS),
				Card.get(Rank.FOUR, Suit.CLUBS),
				Card.get(Rank.FIVE, Suit.CLUBS),
				Card.get(Rank.SIX, Suit.CLUBS));
		assertTrue(invokeIsStraightFlush(hand));
	}


	// Exercise 9 (statement coverage) / Exercise 10 (branch coverage)
	// Fails on the first operand of the || (the suit differs)
	@Test
	void testIsStraightFlush_WrongSuit() {
		PokerHand hand = new PokerHand(
				Card.get(Rank.TWO, Suit.CLUBS),
				Card.get(Rank.THREE, Suit.CLUBS),
				Card.get(Rank.FOUR, Suit.CLUBS),
				Card.get(Rank.FIVE, Suit.CLUBS),
				Card.get(Rank.SIX, Suit.DIAMONDS));
		assertFalse(invokeIsStraightFlush(hand));
	}

	/** Same suit but the ranks are not consecutive (second operand of ||). */
	@Test
	void testIsStraightFlush_WrongRank() {
		PokerHand hand = new PokerHand(
				Card.get(Rank.TWO, Suit.CLUBS),
				Card.get(Rank.THREE, Suit.CLUBS),
				Card.get(Rank.FOUR, Suit.CLUBS),
				Card.get(Rank.FIVE, Suit.CLUBS),
				Card.get(Rank.SEVEN, Suit.CLUBS));
		assertFalse(invokeIsStraightFlush(hand));
	}

	// Exercise 8 (second part): the 36 possible straight flushes.

	@Test
	void testIsStraightFlush_All36() {
		Rank[] ranks = Rank.values();
		int count = 0;
		for (Suit suit : Suit.values()) {
			for (int start = 0; start + 4 < ranks.length; start++) {
				PokerHand hand = new PokerHand(
						Card.get(ranks[start], suit),
						Card.get(ranks[start + 1], suit),
						Card.get(ranks[start + 2], suit),
						Card.get(ranks[start + 3], suit),
						Card.get(ranks[start + 4], suit));
				assertTrue(invokeIsStraightFlush(hand));
				count++;
			}
		}
		assertEquals(36, count);
	}
}
