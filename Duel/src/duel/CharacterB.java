package duel;

public class CharacterB implements Duel {
	
	private String name;
	private String taunt;

	private String tauntArray[] = {"Too weak for me.", "Similar to a child!", "Can't defeat me!", 
	"Try something else since that won't work"};
	
	public CharacterB() {
		
	}
	
	static int randomNum = Math.random()*4;
		
	public void taunt() {
		System.out.println(tauntArray[randomNum]);
	}

	public String getName(){
		name = "Jessica";
		return name;
	}
	
	public void setStartingHP(int hp) {
		this.hp = hp;
	}
	
	public int getHP() {
		return this.hp;
	}
	
	public boolean determineIfOpponentIsFair (Dueler d, int hp) {
		if (d.getHp == hp)
		{
			return true; 
		}
	}
	
	public int getAction(Object caller) {
		if (caller instanceof Duel) //duel is calling it
		{
			if(d2loaded == true && Math.random() < .5) //is gun loaded? and 50% chance
			{
				d2loaded = false; //shoot the gun then it unloads
				return Duel.SHOOTING;
			}
			else
			{
				if(!d2loaded && Math.random() < .4) //gun not loaded and 40% chance
				{
					d2loaded = true;//loaded gun
					return Duel.LOADING;
					
				}
				else
				{
					return Duel.GUARDING; //no other option but to guard
				}
			}
		}
		else
		{
			return Duel.YEAH_RIGHT;
			
			if(!d2loaded && Math.random() < .4) //gun not loaded and 40% chance
			{
				d2loaded = true;//loaded gun
				return Duel.LOADING;
				
			}
			else
			{
				return Duel.GUARDING;
			}
			
		}
		
	}
	public int hit(Object caller) {
		if(caller instanceof Duel)
		{
			this.hp = this.hp - 10;
		}
	}
}
