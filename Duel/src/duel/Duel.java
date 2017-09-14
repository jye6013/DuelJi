package duel;




public class Duel {

	

	private Dueler d1;
	private Dueler d2;
	private int dueler1HP = 30;
	private int dueler2HP = 30;
	
	
	
	
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
		

		
	}
	
	
	/**
	 * This method involves "Threads" which we will get to much later in the year, essentially, it
	 * creates a pause in the execution of the program, which makes it more dramatic
	 * @param time
	 */
	public void pause(long time){
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

}

