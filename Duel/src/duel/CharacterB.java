package duel;

public class CharacterB implements Duel{
	
	private String name;
	private String taunt;
	
	public CharacterB() {
		
		
	}
	
	public void taunt() {
		taunt = "How weak!";
		return taunt; 
	}

	public String getName(){
		name = "Jessica";
		return name;
	}
	
	public int d2LastAction() {
		
	}
}
