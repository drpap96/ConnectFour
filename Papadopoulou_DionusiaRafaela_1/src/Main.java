import java.util.Random;
import java.util.Scanner;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		 
        Scanner in = new Scanner(System.in); 
        
       
     	Dashboard board = new Dashboard(); 
		Player P1= new Player();
		Player P2= new Player();
		int rows=0; //ãñáììÝò
	    int columns=0; //óôÞëåò;
	    String first_P="";
	    char first_C;
	    String second_P="";
	    char second_C;
	    
		
		
		
		System.out.println("This is Score 4 ");
		System.out.println("Please enter the name of 1st player: ");
		String name_p1=in.nextLine();
		System.out.println("Please enter the name of 2nd player: ");
		String name_p2= in.nextLine();
		
		
		P1.setName(name_p1);
		P2.setName(name_p2);
		
		
		System.out.println( P1.getName() + " ,please select your chip : ");
		char chip=in.next().charAt(0);
		while(!(chip=='X' || chip=='O')) {
			System.out.print("Incorrect input! Please enter your chip : ");
			chip=in.next().charAt(0);
		}
		 if (chip=='X') {
			 P1.setChip('X');
			 P2.setChip('O');}
		 else {
			 P1.setChip('O');
			 P2.setChip('X'); } 
			 
		 System.out.println(P2.getName() + ",your chip is: " + P2.getChip());
		
		
		//ÅËÅÃ×ÏÓ ÅÃÊÕÑÏÔÇÔÁÓ ÅÉÓÁÃÙÃÇÓ ÃÉÁ ÔÉÓ ÃÑÁÌÌÅÓ ÊÁÉ ÔÉÓ ÓÔÇËÅÓ.
		System.out.print ("Please, enter the number of rows: ");
		rows=in.nextInt();
		while(!(rows>=4 && rows<=15)) {
			System.out.print("Incorrect input.Please enter the number of rows: ");
			rows=in.nextInt();
		}
		board.setRows(rows);
		
		System.out.print("Please enter the number of columns: ");
		columns=in.nextInt();
		while(!(columns>=4 && columns<=15)) {
			System.out.print("Incorrect input.Please enter the number of columns: ");
			columns= in.nextInt();
		}
		board.setColumns(columns);
		
		
		board.setTable(rows, columns); 
		board.make_table(rows, columns); 
		board.print_table();
		
		//åõñåóç ôïõ ôõ÷áéïõ ðáéêôç ðïõ èá ðáéîåé ðñþôïò áðï ôçí random êáé åðéëïãç óôçëçò
		Random rand = new Random();
		int random_number= rand.nextInt(2); //åìöáíßæåé 0 Þ 1
		if (random_number==0){
			first_P=P1.getName();
			first_C=P1.getChip();
			second_P=P2.getName();
			second_C=P2.getChip();
			}else {
				first_P=P2.getName();
				first_C=P2.getChip();
				second_P=P1.getName();
				second_C=P1.getChip();
			}

				
			board.modified_Table(first_P,first_C,second_P,second_C);
			
			 
			
		
	}
}
