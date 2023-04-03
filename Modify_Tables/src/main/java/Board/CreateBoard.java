package Board;


/**
 * Name: Eric Nunez-Rodriguez
 * Description: Create a table board with numbers of 1 and 0's, and modify it 
 *              however you would like with the options available, or you
 *              could search for a number value in the table.
 */

import java.util.Scanner;

public class CreateBoard 
{

    public static void main(String[] args) 
    {
        driverloop();
    }
    
    static Scanner Scan = new Scanner(System.in);
    
    static public void driverloop()
    {
        char choice;
        int Option;
        
        System.out.print("Create a table (y to continue/n to quit) --> ");
        choice = Scan.next().charAt(0);
        if (choice == 'N' || choice == 'n')
            System.out.println("Goodbye");
        else if (choice == 'y' || choice == 'y')
        {
            Table board = new Table();
            
            System.out.print("Enter the size of the table: ");
            int n = Scan.nextInt();
            board.init(n, n);
            System.out.print("Enter the percentage of board occupancy (e.g 0.1 = 10%): ");
            float x = Scan.nextFloat();
            board.randomize(x);
            System.out.println("Loading randomized table");
            
            System.out.println("Raw Output: ");
            System.out.println("-------------------------------------------------------------------------------");
            board.rawOutput();
            
            System.out.println("Pretty Output: * represents 1 and blanks represent 0's");
            System.out.println("-------------------------------------------------------------------------------");
            board.prettyOutput();
            
            do 
            {
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("Enter corresponding number from the list to choose what you want to do next");
                System.out.println("0: Quit program");
                System.out.println("1: Show raw output");
                System.out.println("2: Show pretty output");
                System.out.println("3: Expand table size");
                System.out.println("4: shrink table size");
                System.out.println("5: Search for value inside table");

                System.out.print("Enter number --> ");
                Option = Scan.nextInt();
                

                switch (Option) 
                {
                    case 0:
                        System.out.println("Goodbye");
                        break;
                    case 1:
                        board.rawOutput();
                        break;
                    case 2:
                        board.prettyOutput();
                        break;
                    case 3:
                        System.out.print("Enter bigger size for table: ");
                        n = Scan.nextInt();
                        board.expand(n, n);
                        break;
                    case 4:
                        System.out.print("Enter smaller size for table: ");
                        n = Scan.nextInt();
                        board.shrink(n, n);
                        break;
                    case 5:
                        System.out.println("Enter a value to search in the maze");
                        int y = Scan.nextInt();
                        board.rawOutput();
                        board.prettyOutput();
                        board.SearchFirst(y);
                        board.SearchLast(y);
                        break;
                }
            }
            while (Option != 0);
        }
        
    }
    
}
