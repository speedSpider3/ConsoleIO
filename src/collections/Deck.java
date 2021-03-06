package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

import interfaces.Card;

/**
 * A collection for containing a list of {@code Card} objects
 * 
 * @author Ryder James
 */
public class Deck implements Iterable<Card> {
	private final ArrayList<Card> my_cards;

	/**
	 * Initializes a new deck with any number of {@code Card} objects
	 * 
	 * @param initialCards - the {@code Card} objects to initially add to the deck,
	 *                     if any
	 */
	public Deck(Card... initialCards) {
		my_cards = new ArrayList<>();
		for (Card c : initialCards) {
			my_cards.add(c);
		}
	}

	/**
	 * Adds a {@code Card} to the deck
	 * 
	 * @param toAdd
	 */
	public void add(Card toAdd) {
		my_cards.add(toAdd);
	}

	/**
	 * Adds any number of {@code Card} objects to the deck
	 * 
	 * @param cardsToAdd
	 */
	public void add(Card... cardsToAdd) {
		for (Card card : cardsToAdd) {
			add(card);
		}
	}

	/**
	 * Removes a specific {@code Card} from the deck
	 * 
	 * @param toRemove
	 */
	public void remove(Card toRemove) {
		my_cards.remove(toRemove);
	}

	/**
	 * Removes any number of specific {@code Card} objects from the deck
	 * 
	 * @param cardsToRemove
	 */
	public void remove(Card... cardsToRemove) {
		for (Card card : cardsToRemove) {
			remove(card);
		}
	}

	/**
	 * Draws a {@code Card} off the "top" (the highest index) of the {@code Deck},
	 * removing it from the {@code Deck}
	 * 
	 * @return the drawn {@code Card}
	 */
	public Card draw() {
		Card result = my_cards.get(my_cards.size() - 1);
		my_cards.remove(result);
		return result;
	}

	/**
	 * Draws a certain number of {@code Card} objects off the "top" (the highest
	 * index) of the {@code Deck}, removing them from the {@code Deck}
	 * 
	 * @param numberToDraw - the number of {@code Card} objects to draw
	 * 
	 * @return a {@code Deck} containing all the drawn {@code Card} objects
	 */
	public Deck draw(int numberToDraw) {
		if (numberToDraw < 1) {
			throw new IllegalArgumentException("Must draw at least 1 card!");
		} else if (numberToDraw > my_cards.size()) {
			throw new IllegalArgumentException("Not enough cards in the deck!");
		}

		Deck deck = new Deck();

		for (int i = 0; i < numberToDraw; i++) {
			deck.add(this.draw());
		}

		return deck;
	}

	/**
	 * @return true if the number of {@code Card} objects in this deck is 0
	 */
	public boolean isEmpty() {
		return (my_cards.size() == 0);
	}

	/**
	 * Shuffles the deck. More specifically, switches the {@code Card} at every
	 * index for a {@code Card} at a random index.
	 */
	public void shuffle() {
		for (int i = 0; i < my_cards.size(); i++) {
			Card temp = my_cards.get(i);
			int randIndex = new Random().nextInt(my_cards.size());

			my_cards.set(i, my_cards.get(randIndex));
			my_cards.set(randIndex, temp);
		}
	}

	@Override
	public String toString() {
		return Arrays.toString(my_cards.toArray(new Card[0]));
	}

	@Override
	public Iterator<Card> iterator() {
		return my_cards.iterator();
	}
}
