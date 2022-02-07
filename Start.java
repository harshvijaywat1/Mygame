package mygame;
import java.util.Scanner;

public class Start 
{
    public static void main( String[] args )
    {
     Game game = new Game();
     
     System.out.println("******************** START *************************");
     game.printGrid();
     Scanner sc = new Scanner(System.in);
		
			int input = sc.nextInt();
			while (true){
				boolean movePossible = false;
				if(input==1){
					movePossible = game.left();
				}else if(input==2){
					movePossible = game.right();
				}else if(input==3){
					movePossible = game.up();
				}else if(input==4){
					movePossible = game.down();
				}else if(input==0){
					System.out.println("*************** Exiting the Game! ************");
					break;
				}else {
					System.out.println("Wrong input! Enter move again.");
					game.printGrid();
					input = sc.nextInt();
					continue;
				}
				System.out.println("*********************************************");
				if(movePossible){
					game.addNumber();
				}
				game.printGrid();
				if(game.isWin()){
					System.out.println("****************** WIN **********************");
					break;
				}else if(game.isFull() && !game.canMove()){
					System.out.println("****************** GAME OVER! LOST! **********************");
					break;
				}
				input = sc.nextInt();
			}
			game.printGrid();
		
	    
    }
    
}

