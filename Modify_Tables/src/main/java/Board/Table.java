package Board;

/**
 * Name: Eric Nunez-Rodriguez
 * 
 */

import java.util.Random;


public class Table 
{
    private int maze[][];
    int rows, columns;
    
    
    static Random rand = new Random();
    
    
    public Table()   // Default constructor
    {
        init(0,0);
    }
    
    public Table(int n)    //new overloaded constructor
    {
        init(n, n);
    }
    
    public Table(int row, int col) // Constructor with parameters
    {
        init(row, col);
    }
    
    
    public void init(int x, int y)  //Initializes 2D array
    {
       if (x > 0 && y > 0)
       {
           maze = new int[x][y];
           rows = x;
           columns = y;
       } 
    }
    
    public void randomize(float number)
    {
       float r;
       
        for (int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {
               r = rand.nextFloat();
               if (r <= number)
                   maze[i][j] = 1;
            }
        }
        
    }
    
    
    public void rawOutput()
    {
        for (int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
                System.out.printf("%3d ", maze[i][j]);
            System.out.println();
        }
    }
    
    public void expand(int newRow, int newCol)
    {
        int[][] mazeCopy = maze;
        init(newRow,newCol);
        for (int i = 0; i < mazeCopy.length; i++) 
        {
            System.arraycopy(mazeCopy[i], 0, maze[i], 0, mazeCopy[i].length);
        }
    }
    
    public void shrink(int newRow, int newCol)
    {
        int[][] mazeCopy = maze;
        init(newRow,newCol);
        for (int i = 0; i < rows; i++) 
        {
            System.arraycopy(mazeCopy[i], 0, maze[i], 0, columns);
        }
    }
       
    public void prettyOutput()
    {
        // Top border
        System.out.print("+");
        for(int j = 0; j < columns; j++)
            System.out.print("--");
        System.out.print("+\n");
        
        // Border body
        for (int i = 0; i < rows; i++)
        {
            System.out.print("|");
            for(int j = 0; j < columns; j++)
                if (maze[i][j] == 0)
                    System.out.printf("  ");
                else if (maze[i][j] == 1)
                    System.out.printf("* ");
                else if (maze[i][j] == 2)
                    System.out.printf(". ");
            System.out.println("|");
        }
        
        // Bottom border
        System.out.print("+");
        for(int j = 0; j < columns; j++)
            System.out.print("--");
        System.out.print("+\n");
    }
    
    
    public void SearchFirst(int x)
    {
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < columns; j++)
                if(maze[i][j] == x)
                {
                    System.out.println("First occurence of value at coordinates: (" +(i+1)+", "+(j+1)+")");
                    return;
                }
        System.out.println("Value not found");
    }
    
    public void SearchLast(int x)
    {
        int m = -1, n = -1;
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < columns; j++)
                if(maze[i][j] == x)
                {
                    m = i;
                    n = j;
                }
        if (m != -1 && n != -1)
            System.out.println("Last occurence of value at coordinates: (" +(m+1)+", "+(n+1)+")");
        else
            System.out.println("Value is not in the table");
    }
}
