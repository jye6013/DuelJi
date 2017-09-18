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

	public boolean determineIfOpponentIsFair (Dueler d, int hp) {
		if (d == d2 && d2.getHp <= hp)
		{
			return true; 
		}
	}
	
	
	public int getAction(Object caller) {
		if (caller != Duel.d2)
		{
			return int (Math.random()*4);
		}
	}
	
	public int hit(Object caller) {
		if(caller instanceof Duel)
		{
			//newHp = whatever the variable for hp - 10; has to go to getHp();
		}
	}
	
}

