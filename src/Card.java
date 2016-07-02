
class Card {

	private String card_number;

	public Card() {

	}

	public Card(String card_number) {
		this.card_number = card_number;
	}

	public String getCard() {
		return card_number;
	}

	public void setCard(String card_number) {
		this.card_number = card_number;
	}

	@Override
	public String toString() {
		return "Card [card_number=" + card_number + "]";
	}

}
