package knight;

import knighttour.Board;

public class RandomKnight extends Knight {

	
	public RandomKnight(Board board) {
		super(board);
		
	}
	
	@Override
	public boolean makeMove() {
		
		int moveType = random.nextInt(8);
		for (int i = 0; i < 8; i++) { 
            if(board.isValid(currentRow + vertical[moveType], currentColumn + horizontal[moveType])) {
            	board.addMove(currentRow, currentColumn);
            	return true;
            }            
            moveType = (moveType + 1) % 8;
         }
		return false;
	}
}
