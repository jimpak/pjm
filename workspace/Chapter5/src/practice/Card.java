package practice;

public class Card {
	private static int serialNum = 1000;
	private int cardNum;
	
	public Card() {
		setCardNum(++serialNum);
	}

	public static int getSerialNum() {
		return serialNum;
	}

	public static void setSerialNum(int serialNum) {
		Card.serialNum = serialNum;
	}

	public int getCardNum() {
		return cardNum;
	}

	public void setCardNum(int cardNum) {
		this.cardNum = cardNum;
	}
	
	
}
