package duel;

public class CharacterA implements Dueler {
	
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


	
	
	public int getAction(Object caller) {
		if (caller != Duel.d2)
		{
			return int (Math.random()*4);
		}
	}
	
}

