package duel;

//period 4


public class Duel {

	

	public static final int YEAH_RIGHT = 3;//may return to anyone who calls who is not the Duel master. If you return to the duel master, you will die
	public static final int LOADING = 0;//must load before shooting
	public static final int SHOOTING = 1;//takes 10 away from opponent
	public static final int GUARDING = 2;//cannot be shot
	
	public static final String[] outcomes = {"loads","shoots","guards","stands there looking confused"};
	
	private Dueler d1;
	private Dueler d2;
	
	private int d1LastAction = 3;
	private int d2LastAction = 3;
	
	private int dueler1HP = 100;
	private int dueler2HP = 100;
	private boolean d1Loaded;
	private boolean d2Loaded;
	
	
	
	public static void main(String[] args){
		Duel duel = new Duel();
		duel.dukeItOut();
	}
	
	public Duel() {
		d1 = new CharacterA();
		d2 = new CharacterB();
	}
	
	public void dukeItOut(){
		System.out.print(d1.getName());
		pause(600);
		System.out.print(" vs ");
		pause(600);
		System.out.println(d2.getName());
		pause(600);
		d1.taunt();
		pause(2000);
		d2.taunt();
		pause(2000);
		d1.setStartingHP(dueler1HP);
		d2.setStartingHP(dueler2HP);
		

		
		
		boolean d1SaysD2Fair = d1.determineIfOpponentIsFair(d2, 100);
		boolean d2SaysD1Fair = d2.determineIfOpponentIsFair(d1, 100);
		
		//make students implement "determineIfOpponentCheating"  before showing this
		boolean correctlyDoneD1 = d1.getHP() == 100;
		boolean correctlyDoneD2 = d2.getHP() == 100;
		
		if (isFair(correctlyDoneD1, correctlyDoneD2)){
			
			if (d1SaysD2Fair == correctlyDoneD2 && d2SaysD1Fair == correctlyDoneD1){ 
				//print a taunt that is different than last time
				pause(2000);
				d1.taunt();
				pause(2000);
				d2.taunt();
				pause(2000);
				startFighting();
			}else{
				System.out.println("It looks like the duelers can't determine if the other is cheating.");
			}

		}

	}
	
	public int getLastActionOf(Dueler d){
		if (d == d1){
			return d1LastAction;
		}else if(d == d2){
			return d2LastAction;
		}
		return YEAH_RIGHT;
	}
	
	public void startFighting(){
		int startingRounds = 60;
		int rounds = startingRounds;
		while (rounds > 0 && dueler1HP == d1.getHP() && dueler2HP == d2.getHP() && dueler1HP > 0 && dueler2HP > 0){
			System.out.println("ROUND "+(startingRounds-rounds));
			rounds --;
			int d1Action = d1.getAction(this);
			int d2Action = d2.getAction(this);
			if(!(d1Action >= 0 && d2Action >= 0 && d1Action <4 && d2Action < 4)){
				System.out.println("Someone is trying to complete an action that doesn't exist. Start over.");
				return;
			}
			System.out.println(d1.getName()+": "+dueler1HP + " and " + d2.getName() + ": " + dueler2HP+".");
			System.out.println(d1.getName()+" "+outcomes[d1Action] + " and " + d2.getName() + " " + outcomes[d2Action]+".");
			if (d1Action == LOADING){
				d1Loaded = true;
			}
			if (d2Action == LOADING){
				d2Loaded = true;
			}
			if(d1Action == SHOOTING){
				if (d1Loaded){
					if(d2Action != GUARDING){
						dueler2HP -= 10;
						d2.hit(this);
						System.out.println(d2.getName() + " was shot! (Reported) HP = " + d2.getHP());
					}else{
						System.out.println(d2.getName() + " blocked a shot!");
					}
					d1Loaded = false;
				}else{
					System.out.println(d1.getName() + " tried to shoot an unloaded gun.");
				}
			}
			if(d2Action == SHOOTING){
				if (d2Loaded){
					if(d1Action != GUARDING){
						dueler1HP -= 10;
						d1.hit(this);
						System.out.println(d1.getName() + " was shot! (Reported) HP = " + d1.getHP());
					}else{
						System.out.println(d1.getName() + " blocked a shot!");
					}
					d2Loaded = false;
				}else{
					System.out.println(d2.getName() + " tried to shoot an unloaded gun.");
				}
			}
			
			pause(300);
			d1LastAction = d1Action;
			d2LastAction = d2Action;
			
		}
		if (dueler1HP != d1.getHP() || dueler2HP != d2.getHP()){
			System.out.println("Someone is cheating!");
		}
		if (dueler1HP <= 0 && dueler2HP > 0){
			System.out.println(d2.getName() + " is victorious!");
		}else if (dueler2HP <= 0 && dueler1HP > 0){
			System.out.println(d1.getName() + " is victorious!");
		}else{
			if(dueler1HP > dueler2HP){
				System.out.println(d1.getName()+" wins!");
			}else if(dueler2HP > dueler1HP){
				System.out.println(d2.getName()+" wins!");
			}else{
				System.out.println("It's a draw!");
			}
			
			
		}
	}
	
	
	
	
	public boolean isFair(boolean correctlyDoneD1, boolean correctlyDoneD2){
		if (!correctlyDoneD1 && correctlyDoneD2){
			System.out.println(d1.getName() + " is cheating. " + d2.getName() + " wins");
			return false;
		}else if (!correctlyDoneD2 && correctlyDoneD1){
			System.out.println(d2.getName() + " is cheating. " + d1.getName() + " wins");
			return false;
		}else if (!correctlyDoneD2 && !correctlyDoneD1){
			System.out.println("Both players are cheating. You should be ashamed.");
			return false;
		}
		return true;
	}
	
	public void pause(long time){
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

