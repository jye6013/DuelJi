package duel;


public class CharacterA implements Dueler { 

	
	private String name;

	//private String taunt;
	private boolean loadedGun;
	private int hp;

	private String taunt;


	private String tauntArray[] = {"Can't defeat me.", "Try again!", "You're too weak.", 
	"Why don't you try something else?"};

	
	public CharacterA() {
	
	}
	
	
	public void taunt() {
		int randomNum = (int) (Math.random()*4);
		String t = tauntArray[randomNum];
		System.out.println(t);
	}

	
	public String getName(){
		name = "Ji";
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
	
	
	public int getAction(Object caller) 
	{
		if (caller instanceof Duel) //duel is calling it
		{
			if(loadedGun == true && Math.random() < .5) //is gun loaded? and 50% chance
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

