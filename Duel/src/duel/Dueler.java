package duel;

public interface Dueler {

	
	//print a taunt
	//later: the taunt must be different each time the method is called
	void taunt();
	
	//returns the name of the Dueler
	String getName();
	
	//set the value of a field. Challenge: Write this in such a way that it can only be called once (by the Duel, at the start)
	void setStartingHP(int hp);
	//returns the value of HP, can be called as often as anyone wants
	int getHP();
	
	//This method is called by the Duel and can be used by the dueler
	//return true if d has its HP equal to "target"
	boolean determineIfOpponentIsFair(Dueler d, int target);
}
