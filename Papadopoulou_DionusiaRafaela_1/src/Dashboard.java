import java.util.Scanner;

public class Dashboard {
 Scanner in = new Scanner(System.in);
	private int rows;
	private int columns;
	private char[][] table;  

	
	public Dashboard() {
		this.rows = 0;
		this.columns = 0;
		this.table = table;
	}
	
	public void setRows(int num_of_rows) {
		rows=num_of_rows;
	}
	public void setColumns(int num_of_col) {
		columns=num_of_col;
	}
	public void setTable(int rows,int columns) {
		
	 table= new char[rows][columns];
		
		}
	
	//μέθοδος δημιουργίας αρχικού πίνακα
	public void  make_table(int rows,int columns) {
		
		for (int i=0; i<rows; i++)
			for (int j=0; j<columns; j++)
				table[i][j]='-';
	}
	
	public void print_table() {
		
		 for (int i=0; i<rows; i++) {
			 System.out.print("|");
			 for (int j=0; j<columns; j++) {
				 
				 System.out.print( table[i][j] + " ");
			 } 
			 System.out.print("|");
			 System.out.println(" ");
		 }
		 for(int i=0; i<columns+rows+4; i++)
			 System.out.print("-");
		     System.out.println(" ");
		 
		//System.out.println("--------------");
		for(int i=1; i<=columns; i++)
			System.out.print(" " + i); 
		System.out.println("");
		}
	
	
	//τροποποίηση του πίνακα
	public void modified_Table(String player1, char chip1,String player2, char chip2 ) {
	    //counter-πίνακας-μετρητής που κάθε κελί του δείχνει πόσα στοιχεία έχει μέσα η αντίστοιχη στήλη του πίνακα table.
		int[] counter= new int[columns];
		for(int i=0; i<columns; i++)
			counter[i]=0;
		int c;
		String player=player1;
		char chip=chip1;
		
				
		while(!( thereIsWinner(chip,table) || isTableFull() ) ) {
			System.out.println( player + " your turn, select column: ");
			c=in.nextInt();
			while(!(c<=columns)) {
				System.out.println("Incorrect column. Please select again: ");
				c=in.nextInt();
			}
			/*while((counter[c-1]==rows)) {
				System.out.print("This column if Full.Please select another one:");
				c=in.nextInt();
			}*/
					
						
			if(counter[c-1]>rows) {
				System.out.println("This column if Full.Please select another one: ");
			}else {
				
				int m=counter[c-1]+1;
				table[rows-m][c-1]=chip;
				counter[c-1]++;
			} 
			print_table(); 
			if (thereIsWinner(chip,table)){
				System.out.println(player + ",won this game! ");
				break;}
			
			if(player==player1) {
				player=player2;
				chip=chip2;
			}else {
				player=player1;
				chip=chip1;
			}
			}	
		}	
	
	
	//Γενική συνάρτηση ελέγχου-ύπαρξης νίκης.
	public boolean thereIsWinner(char x,char[][] table) {
		if(horizontalWin(x,table) || verticalWin(x,table) || diagonalWinForward(x,table) ||diagonalWinDownward(x,table))
			return true;
		else
			return false;
		
	}
	
	
	public boolean horizontalWin (char c,char[][] table) {
		for(int i=0; i<rows; i++)
			for (int j=0; j<columns-3; j++) {
				if(table[i][j]==c & table[i][j+1]==c & table[i][j+2]==c & table[i][j+3]==c) {
					return true;
				}
			}
		return false;		
	}
	
	public boolean verticalWin(char ch,char[][] table) {
		for(int i=0; i<rows-3; i++)
			for(int j=0; j<columns; j++) {
				if(table[i][j] == ch && table[i+1][j] == ch && table[i+2][j] == ch && table[i+3][j] == ch) {
					return true;
				}
			}
		return false;				
	}

	public boolean diagonalWinForward(char chip,char[][] table) {
		for (int i=0; i<rows; i++)
			for(int j=0; j<columns-3; j++) {
				if(table[i][j] == chip && table[i-1][j+1] == chip && table[i-2][j+2] == chip && table[i-3][j-3] == chip)
					return true;
			}
			
        return false;
	}
	
	
	public boolean diagonalWinDownward(char chip,char[][] table) {
		for (int i=0; i<rows-3; i++)
			for(int j=0; j<columns-3; j++)
				if(table[i][j]==chip && table[i+1][j+1]==chip && table[i+2][j+2]==chip && table[i+3][j+3]==chip) {
					return true;
				}
		return false;
	}
	
	public boolean isTableFull() {
        boolean fullboard = true;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (table[i][j] == '-') {
                   fullboard = false;
                }
            }
        }
        return fullboard;
    }
	
	
	
}
