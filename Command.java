import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.InputMismatchException;

class Command{
    Scanner scan = new Scanner(System.in);
    Board board = new Board();
    int index = 0;
    
    void selected(int operation){
	try{
	    switch(operation){
	    case 1:
		//create
		board.create();
		break;
	    
	    case 2:
		//move
	    
		Rectangle rect_move = board.selectRectangle();
		System.out.print("移動方向x : ");
		int x0 = scan.nextInt();
		System.out.print("移動方向y : ");
		int y0 = scan.nextInt();
		//フィールドを動かす
		if(rect_move.move(x0,y0)){
		    board.replaceRectangle(rect_move);
		}
	  
	
		break;
	    case 3:
	    case 4:
		//expand/shrink
		Rectangle rect_scale = board.selectRectangle();
		System.out.print("縮尺x : ");
		float mx = scan.nextFloat();
		System.out.print("縮尺y : ");
		float my = scan.nextFloat();
		//拡大/縮小
		if(rect_scale.scale(mx,my)){
		    board.replaceRectangle(rect_scale);
		}
		
		break;
	    case 5:
		board.delete();
		break;
	    case 6:
		board.deleteAll();
		break;
	    case 7:
		System.out.println("実装してないよ、ゴメンネ");
		break;
	    case 8:
		board.displayBoard();
		break;
	    case 9:
		System.out.println("終了します");
		System.exit(0);
	    default:
		System.out.println("1~9から選んでください");
		break;
	    }
	}catch(InputMismatchException e){
	    scan.next();
	    System.out.println("数値を入力してください");
	}catch(IndexOutOfBoundsException e){
	    System.out.println("存在していません");
	}
    }
	
}
