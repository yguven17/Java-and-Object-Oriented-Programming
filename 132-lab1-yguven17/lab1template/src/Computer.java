import java.util.Random;

public class Computer {

	int numberOfCarts ;
	int removedCards ;
	
	public void setNumber(int numberOfCarts) {
		this.numberOfCarts = numberOfCarts;
		
	}
	
	public int getNumber() {
		return numberOfCarts;
	}
	
	public int numberGenerator(int mode) {
		Random rand = new Random();
		
		if(mode == 1) {
			
			while (true) {
				
				int power = rand.nextInt((int) (Math.log(getNumber())/Math.log(2)));
				if(Math.pow(2, power) < getNumber() && Math.pow(2, power) >= 2 ) {
					int temp =  (int) (getNumber() +1 - Math.pow(2, power));
					if(temp<getNumber()/2) {
						removedCards =  (int) (getNumber() +1 - Math.pow(2, power));
						break;
					}
					}
					
			}
			

		}else {
			removedCards = rand.nextInt(numberOfCarts-1) + 1;
		}
		return removedCards;
		
	}
}
