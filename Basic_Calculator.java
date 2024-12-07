import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException; 

public class Basic_Calculator 
{
    ArrayList<ArrayList<Double>> calculations = new ArrayList<>();
    private boolean useSave;
    private double result;
     

public Boolean canBeInt(double doub)
{
    if(doub % 1 == 0)
    {
        return true;
    }
    else return false;
}

public void printSum(){
ArrayList<Double> recallSum = calculations.get(calculations.size()-1);
                    for(int j=0;j<recallSum.size();j++)
                    {
                        if (j == 1)
                        {
                            int toInt = recallSum.get(j).intValue();
                            int a = toInt;
                            char toChar = (char) a;
                            System.out.print(" "+toChar);
                            continue;
                        }
                        if (j == 3) 
                        {
                            System.out.print(" "+"=");
                            if (canBeInt(recallSum.get(j)))
                            {
                                int toInt = recallSum.get(j).intValue();
                                System.out.print(" "+toInt);
                            }
                            else
                            {
                            System.out.print(" "+recallSum.get(j));
                            }
                        }
                        else if (canBeInt(recallSum.get(j)))
                        {
                            int toInt = recallSum.get(j).intValue();
                            System.out.print(" "+toInt);
                        }
                        else 
                        {
                            System.out.print(" "+recallSum.get(j));
                        }
                    }
                    System.out.println();
                }
public void mainMenu(double result,Boolean useSave)
{
    System.out.println("/////////////////////////////////////////////");
    System.out.println("///////////// Basic calculator //////////////");
    System.out.println("/////////////////////////////////////////////");
    System.out.println("|1| Addition\n|2| Subtraction\n|3| Multiplication\n|4| Division\n|5| History\n|0| Quit");
    System.out.println("/////////////////////////////////////////////");
    Scanner kb = new Scanner(System.in);
    int userOp = kb.nextInt();
    menu(userOp,result,useSave);
    kb.close();
}
    public void saveCal(double a,double b,double op,double sum)
    {
        ArrayList<Double> saved = new ArrayList<>();
        saved.add(a);
        saved.add(op);
        saved.add(b);
        saved.add(sum);
        if(calculations.size()<10)
        {
        calculations.add(saved);
        }
        else 
        {
            calculations.remove(9);
            calculations.add(saved);
        }
    }

    public boolean useSave(int userOption)
    {
        if (userOption == 2)
        {
            return true;
        }
        return false;
    }
    
    
    public void menu(int UserOp,double result,boolean useSave)
    {
        Scanner selector = new Scanner(System.in);
        switch (UserOp) {
            case 1:
            try 
            {
                System.out.println("//////////////////Addition///////////////////");
                System.out.println("Enter the first number and then press enter:");
                double a = (useSave) ? (result) : (selector.nextDouble());
                System.out.println("Enter the second number and then press enter:"); 
                double b = selector.nextDouble();
                System.out.println("/////////////////////////////////////////////");
                double sum = add(a, b);
                result=sum;
                double operator = 43.0;
                saveCal(a, b, operator, sum);
                printSum();
                System.out.println("/////////////////////////////////////////////");
                System.out.println("|0| Main Menu\n|1| New Calculation\n|2| Use Result");
                int back = selector.nextInt();
                useSave = (back == 2) ? (true) : (false);
                switch (back) 
                {
                    case 0:
                    mainMenu(result,useSave);
                    case 1:
                    menu(1,result,useSave);
                    case 2:   
                    mainMenu(result,useSave);
                }
                } catch (InputMismatchException e) {
                System.out.println("Invalid\nPlease select a valid number:");
                menu(1,result,useSave);
            }
                break;
            case 2:
            try 
            {
                System.out.println("////////////////Subtraction//////////////////");
                System.out.println("Enter the first number and then press enter:");
                double a = selector.nextDouble();
                System.out.println("Enter the second number and then press enter:"); 
                double b = selector.nextDouble();
                System.out.println("/////////////////////////////////////////////");
                double sum = sub(a,b);
                result=sum;
                double operator = 45.0;
                saveCal(a, b, operator, sum);
                printSum();
                System.out.println();
                System.out.println("Enter 0 for main menu or 1 for new calculation:");
                int back = selector.nextInt();
                if (back == 1)
                {
                    menu(2,result,useSave);
                }
                else 
                {
                    mainMenu(result,useSave);
                }
                } catch (InputMismatchException e) {
                System.out.println("Invalid\nPlease select a valid number:");
                menu(2,result,useSave);
            }
            case 3:
            try 
            {
                System.out.println("///////////////Multiplication////////////////");
                System.out.println("Enter the first number and then press enter:");
                double a = selector.nextDouble(); 
                System.out.println("Enter the second number and then press enter:");
                double b = selector.nextDouble();
                System.out.println("/////////////////////////////////////////////");
                double sum = multi(a,b);
                result=sum;
                double operator = 42.0;
                saveCal(a, b, operator, sum);
                printSum();
                System.out.println();
                System.out.println("Enter 0 for main menu or 1 for new calculation:");
                int back = selector.nextInt();
                if (back == 1)
                {
                    menu(3,result,useSave);
                }
                else 
                {
                    mainMenu(result,useSave);
                }
                } catch (InputMismatchException e) {
                System.out.println("Invalid\nPlease select a valid number:");
                menu(3,result,useSave);
            }
            case 4:
            try
            {
                System.out.println("//////////////////Division///////////////////");
                System.out.println("Enter the first number and then press enter:");
                double a = selector.nextDouble();
                System.out.println("Enter the second number and then press enter:"); 
                double b = selector.nextDouble();
                System.out.println("/////////////////////////////////////////////");
                double sum = div(a,b);
                result=sum;
                double operator = 47.0;
                saveCal(a, b, operator, sum);
                printSum();
                System.out.println();
                System.out.println("Enter 0 for main menu or 1 for new calculation:");
                int back = selector.nextInt();
                if (back == 1)
                {
                    menu(4,result,useSave);
                }
                else 
                {
                    mainMenu(result,useSave);
                }
                } catch (InputMismatchException e) {
                System.out.println("Invalid\nPlease select a valid number:");
                menu(4,result,useSave);
            } catch (NumberFormatException e) 
            {
                System.out.println("Invalid\nPlease select a valid number:");
                menu(UserOp,result,useSave);
            }
                break;
            case 5:
                System.out.println("//////////////////History////////////////////");
                for(int i=0;i<calculations.size();i++)
                {
                    ArrayList<Double> recallSum = calculations.get(i);
                    for(int j=0;j<recallSum.size();j++)
                    {
                        if (j == 1)
                        {
                            int toInt = recallSum.get(j).intValue();
                            int a = toInt;
                            char toChar = (char) a;
                            System.out.print(" "+toChar);
                            continue;
                        }
                        if (j == 3) 
                        {
                            System.out.print(" "+"=");
                            if (canBeInt(recallSum.get(j)))
                            {
                                int toInt = recallSum.get(j).intValue();
                                System.out.print(" "+toInt);
                            }
                            else
                            {
                            System.out.print(" "+recallSum.get(j));
                            }
                        }
                        else if (canBeInt(recallSum.get(j)))
                        {
                            int toInt = recallSum.get(j).intValue();
                            System.out.print(" "+toInt);
                        }
                        else 
                        {
                            System.out.print(" "+recallSum.get(j));
                        }
                    }
                    System.out.println();
                }
                    System.out.println();
                    System.out.println("/////////////////////////////////////////////");
                    System.out.println("Enter 0 to return to main menu:");
                    int back = selector.nextInt();
                    if (back == 0) 
                    {
                        mainMenu(result,useSave);
                    }
                
                
            case 0:
                selector.close();
                break;
        
            
        }
    }
    
       
    
    public double add(double x,double y)
    {
        return x+y;
    }
    public double sub(double x,double y)
    {
        return x-y;
    }
    public double multi(double x,double y)
    {
        return x*y;
    }
    
     
        public double div(double x,double y) 
        {
            try 
            {
                if (x == 0.0||y == 0.0) 
                {
                    throw new IllegalArgumentException();
                }
                  
            } catch (IllegalArgumentException e) {
                System.out.println("Cannot divide by zero\nStart again");
                menu(4,result,useSave);
            }
            return x/y;  
        }

    public static void main(String[] args) throws Exception 
    {
        Basic_Calculator calculator = new Basic_Calculator();
        calculator.mainMenu(0.0, false);
        

    }
    
    
}    



