package chapter5;

/**
 * An immutable description of a playing card. Cards are flyweights: there is
 * exactly one Card instance per (rank, suit) combination.
 */
public final class Card {

	private static final Card[][] CARDS = new Card[Suit.values().length][Rank.values().length];

	static {
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				CARDS[suit.ordinal()][rank.ordinal()] = new Card(rank, suit);
			}
		}
	}

	private final Rank aRank;
	private final Suit aSuit;

	private Card(Rank pRank, Suit pSuit) {
		aRank = pRank;
		aSuit = pSuit;
	}

	/**
	 * @param pRank The rank of the card.
	 * @param pSuit The suit of the card.
	 * @return The unique Card instance for the given rank and suit.
	 */
	public static Card get(Rank pRank, Suit pSuit) {
		assert pRank != null && pSuit != null;
		return CARDS[pSuit.ordinal()][pRank.ordinal()];
	}

	public Rank getRank() {
		return aRank;
	}

	public Suit getSuit() {
		return aSuit;
	}

	@Override
	public String toString() {
		return aRank + " of " + aSuit;
	}
}
