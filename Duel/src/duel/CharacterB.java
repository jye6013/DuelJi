package duel;

public class CharacterB implements Dueler{
	
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
	
	public boolean determineIfOpponentIsFair (Dueler d, int hp) {
		if (d == d1 && d1.getHp <= hp)
		{
			return true; 
		}
	}
	
	public int getAction(Object caller) {
		if (caller != Duel.d1)
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
