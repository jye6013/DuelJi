package duel;




public class Duel {

	

	private Dueler d1;
	private Dueler d2;
	
	
	
	
	public static void main(String[] args){
		Duel duel = new Duel();
		duel.dukeItOut();
	}
	
	public Duel() {
		d1 = new CharacterA();
		d2 = new CharacterB();
	}
	
	public void dukeItOut(){
		
	}
	

}

