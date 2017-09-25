package duel;

public class CharacterB implements Dueler {
	private String name;
	private String taunt;
	private int hp;
	private String tauntArray[] = {"Too weak for me.", "Similar to a child!", "Can't defeat me!", 
	"Try something else since that won't work"};
	
	private boolean loadedGun; 
	
	public CharacterB() {
		
	}
	
		
	public void taunt() {
		int randomNum = (int) (Math.random()*4);
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
		if (d.getHP() == hp)
		{
			return true; 
		}
		else
		{
			return false; 
		}
	}
	
	public int getAction(Object caller) {
		if (caller instanceof Duel) //duel is calling it
		{
			if( loadedGun == true && Math.random() < .5) //is gun loaded? and 50% chance
			{
				loadedGun = false; //shoot the gun then it unloads
				return Duel.SHOOTING;
			}
			else
			{
				if(!loadedGun && Math.random() < .4) //gun not loaded and 40% chance
				{
					loadedGun = true;//loaded gun
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
			
			
			
		}
		
	}
	public void hit(Object caller) {
		if(caller instanceof Duel)
		{
			this.hp = this.hp - 10;
		}
	}
}