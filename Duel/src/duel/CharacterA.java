package duel;

public class CharacterA implements Duel {
	
	private String name;
	private String taunt;
	
	public CharacterA() {
		
		
	}
	
	public void taunt() {
		taunt = "Can't defeat me!";
		return taunt; 
	}

	public String getName(){
		name = "Ji";
		return name;
	}
	
	public int d1LastAction() {
		
	}
	
}

