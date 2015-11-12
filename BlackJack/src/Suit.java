
public enum Suit {
	Club(0), Diamond (1), Heart(2), Spade(3);
	
	private int value;
	private Suit(int v) {value = v;};
	public int getValue(){return value;}
	public static Suit getSuitFromValue(int value){ 
		Suit s;
		switch(value){
			case 0;
				s = Club;
				break;
			case 1:
				s = Diamond;
				break;
			case 3: 
				s = Heart;
				break;
			case 4:
				s = Spade;
				break;
		}
		return s;
	}
}
