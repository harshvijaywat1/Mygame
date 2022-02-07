package mygame;
import java.util.Random;

public class Game{
	
	private int[][] board ;
	
    //Method to print board

	public void printGrid(){
		for(int i=0 ; i<4; i++){
			for(int j=0; j<4; j++){
				System.out.print(board[i][j]);
				if(j+1 < 4)
					System.out.print(" _|_ ");
			}
			System.out.println();
		}
	}
	
   //Initialasation with 14 tiles having 0 value 2 tiles randomly selected and having either 2 or 4 as value
	public Game() {
		
		board = new int[4][4];
		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++){
				board[i][j] = 0;
			}
		}
		
		addNumber();addNumber();
	}
	
     //Method to randomly select an empty tile and fill its value to either 2 or 4
	public void addNumber(){
		if(!isFull()){
			Random ir = new Random();
			Random jr = new Random();
			int i = ir.nextInt(4);
			int j = jr.nextInt(4);
			while(board[i][j] != 0){
				i = ir.nextInt(4);
				j = jr.nextInt(4);
			}
			int x = new Random().nextInt(4);
			if( x%2 == 0){
				board[i][j] = 2;
			}else {
				board[i][j] = 4;
			}
		}
	}
	
        //Method for left move
	public boolean left(){
		boolean movePossible = false;
		 // loop for combining values as per the rules
                     for(int i=0 ; i<4; i++){
			int prevj = -1;
			for(int j=0; j<4; j++){
				if ((prevj == -1 && board[i][j] != 0)
						|| (prevj != -1 && board[i][j] != board[i][prevj])){
					prevj = j;
				}
				else if(prevj != -1 && board[i][j] == board[i][prevj]){
					if( board[i][j] != 0){
						movePossible = true;
					}
					board[i][prevj] *= 2;
					board[i][j] = 0;
					prevj = -1;
				}
			}
			prevj = 0;
		 //loop for shifting values to left if there are zeroes in left of a value
                 	for(int j=0; j<4; j++){
				if(board[i][j] != 0){
					if(prevj != j){
						if( board[i][j] != 0){
							movePossible = true;
						}
						board[i][prevj] = board[i][j];
						board[i][j] = 0;
					}
					prevj++;
				}
			}
		}
		return movePossible;
	}
	
       //Method for right move
	public boolean right(){
		boolean movePossible = false;
 	 // loop for combining values as per the rules
           	for(int i=0 ; i<4; i++){
			int nextj = -1;
			for(int j=4-1; j>=0; j--){
				if ((nextj == -1 && board[i][j] != 0)
						|| (nextj != -1 && board[i][j] != board[i][nextj])){
					nextj = j;
				}
				else if(nextj != -1 && board[i][j] == board[i][nextj]){
					if( board[i][j] != 0){
						movePossible = true;
					}
					board[i][nextj] *= 2;
					board[i][j] = 0;
					nextj = -1;
				}
			}
			nextj = 4-1;
 //loop for shifting values to right if there are zeroes in right of a value	
		for(int j=4-1; j>=0; j--){
				if(board[i][j] != 0){
					if(nextj != j){
						board[i][nextj] = board[i][j];
						board[i][j] = 0;
						movePossible = true;
					}
					nextj--;
				}
			}
		}
		return movePossible;
	}
	
        //Method for up move
	public boolean up() {
		boolean movePossible = false;
 // loop for combining values as per the rules	
 	for(int j=0 ; j<4; j++){
			int previ = -1;
			for(int i=0; i<4; i++){
				if ((previ == -1 && board[i][j] != 0)
						|| (previ != -1 && board[i][j] != board[previ][j])){
					previ = i;
				}
				else if(previ != -1 && board[i][j] == board[previ][j]){
					if( board[i][j] != 0){
						movePossible = true;
					}
					board[previ][j] *= 2;
					board[i][j] = 0;
					previ = -1;
				}
			}
			previ = 0;
 //loop for shifting values to up if there are zeroes in up of a value	
		for(int i=0; i<4; i++){
				if(board[i][j] != 0){
					if(previ != i){
						board[previ][j] = board[i][j];
						board[i][j] = 0;
						movePossible = true;
					}
					previ++;
				}
			}
		}
		return movePossible;
	}
      
     //Method for down move
 	public boolean down() {
		boolean movePossible = false;
	 // loop for combining values as per the rules
        	for(int j=0 ; j<4; j++){
			int nexti = -1;
			for(int i=4-1; i>=0; i--){
				if ((nexti == -1 && board[i][j] != 0)
						|| (nexti != -1 && board[i][j] != board[nexti][j])){
					nexti = i;
				}
				else if(nexti != -1 && board[i][j] == board[nexti][j]){
					if( board[i][j] != 0){
						movePossible = true;
					}
					board[nexti][j] *= 2;
					board[i][j] = 0;
					nexti = -1;
					
				}
			}
			nexti = 4-1;
 //loop for shifting values to down if there are zeroes in down of a value	
		for(int i=4-1; i>=0; i--){
				if(board[i][j] != 0){
					if(nexti != i){
						board[nexti][j] = board[i][j];
						board[i][j] = 0;
						movePossible = true;
					}
					nexti--;
				}
			}
		}
		return movePossible;
	}

           //Method to check if we can move in any direction	
	public boolean canMove(){
		if(!isFull()){
			return true;
		}
		for(int i=0 ; i<4; i++){
			for(int j=0; j<4; j++){
				if( ( (i+1<4) && (board[i][j] == board[i+1][j]) )
						|| ((j+1<4) && (board[i][j] == board[i][j+1]) ))
					return true;
			}
		}
		return false;
	}
            //Method to check if player won the game
	public boolean isWin(){
		for(int i=0 ; i<4; i++){
			for(int j=0; j<4; j++){
				if(board[i][j] == 2048)
					return true;
			}
		}
		return false;
	}
	
     //Method to check if grid is full 
	public boolean isFull(){
		for(int i=0 ; i<4; i++){
			for(int j=0; j<4; j++){
				if(board[i][j] == 0)
					return false;
			}
		}
		return true;
	}
}