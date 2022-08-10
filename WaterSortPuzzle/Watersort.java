import java.util.Scanner;
public class Watersort {
    private static Character red = new Character('r');
    private static Character green = new Character('g');
    private static Character blue = new Character('b');
    
    private static StackAsMyArrayList<Character> [] bottles = new StackAsMyArrayList[5];
    public static void main(String [] args)
    {        
        Scanner input = new Scanner(System.in);
        int iSourceBottle, iTargetBottle;
        
        bottles[0] = new StackAsMyArrayList<>();
        bottles[1] = new StackAsMyArrayList<>();
        bottles[2] = new StackAsMyArrayList<>();
        bottles[3] = new StackAsMyArrayList<>();
        bottles[4] = new StackAsMyArrayList<>();  

        
        
        fillBottles();
        System.out.println("Welcome to the Watersort Puzzle Game\n");
        while(!solved())
        {
            ShowAll();
            
            System.out.println("Enter source bottle number:");
            iSourceBottle = input.nextInt();
            System.out.println("Enter target bottle number:");
            iTargetBottle = input.nextInt();
            if(iSourceBottle < 0 || iSourceBottle > 4)
            {
                System.out.println("Error only enter a source bottle number between 0 & 4.\n");
            }
            else if(iTargetBottle < 0 || iTargetBottle > 4)
            {
                System.out.println("Error only enter a target bottle number between 0 & 4.\n");
            }
            else
            {
                if(bottles[iTargetBottle].getStackSize() == 4)
                {
                    System.out.println("Target bottle is full.\n");
                }
                else
                {
                    if(checkMovement(iSourceBottle, iTargetBottle))
                    { 
                        while(checkMovement(iSourceBottle, iTargetBottle))
                        {                          
                            bottles[iTargetBottle].push(bottles[iSourceBottle].pop());
                        }
                    }
                    else
                    {
                        System.out.println("Colours do not match, hence no movement took place.");
                    }
                }              
            }
        }
        
        ShowAll();
        System.out.println("Congratulations you have solved the Puzzle!");
    }
    
    public static void ShowAll()
    {
        for(int i=0; i < bottles.length; i++)
        {
            System.out.println("Bottle " + i + ": " + bottles[i].toString());
        }
    }
    
    public static void fillBottles()
    {
        int iCounter = 0;
        int randColour;
        int randBottle;
        int numRed = 0;
        int numGreen = 0;
        int numBlue = 0;        
        
        while(iCounter != 12)
        {      
            randBottle = (int)Math.floor(Math.random()*(4));
            if(bottles[randBottle].getStackSize() < 4)
            {
                randColour = (int)Math.floor(Math.random()*(3) + 1);
                {
                    switch(randColour)
                    {
                        case 1: if(numRed < 4)
                                {
                                    bottles[randBottle].push(red);
                                    numRed++;
                                    iCounter++;
                                }  
                                break;
                        
                        case 2: if(numGreen < 4)
                                {
                                    bottles[randBottle].push(green);
                                    numGreen++;
                                    iCounter++;
                                }
                                break;
                        
                        case 3: if(numBlue < 4)
                                {
                                    bottles[randBottle].push(blue);
                                    numBlue++;
                                    iCounter++;
                                }
                                break;
                                
                        default: break;                      
                    }
                }
            }
        }
    }
    
    public static boolean solved()
    {
        boolean bSolved = true;
        for (int i = 0; i < bottles.length; i++)
        {
            if(!bottles[i].checkStackUniform())
            {
                return false;
            }
            else if (bottles[i].getStackSize() != 0 && bottles[i].getStackSize() != 4)
            {
                return false;
            }
        }
        
        
        return true;
    }
    
    public static boolean checkMovement(int iSource, int iTarget)
    {
        if((bottles[iTarget].peek() == bottles[iSource].peek() && bottles[iTarget].getStackSize() != 4) || bottles[iTarget].getStackSize() == 0)
        {
            return true;
        }
        else
        {
          return false;
        }
    }
}
