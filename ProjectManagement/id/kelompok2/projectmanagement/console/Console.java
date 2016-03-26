/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kelompok2.projectmanagement.console;

import java.util.Scanner;

/**
 *
 * @author Iwan Ma'ruf
 */
public class Console {
    private Scanner sInt;
    private Scanner sStr;
    
    public void mainMenu(){
        Scanner inputInteger=new Scanner(System.in);
        int pil=0;
        do {
            try{
            
                            System.out.println("*********************************************************");
                            System.out.println("*+++>                  ON-BOARD                     <+++*");
                            System.out.println("*=======================================================*");
                            System.out.println("*          Everybody is on board with ON-BOARD          *");
                            System.out.println("*        The easiest way to manage your projects        *");
                            System.out.println("*                   NO FUSS, NO RUSH                    *");
                            System.out.println("*=======================================================*");
                            System.out.println("*               1. Start a new project                  *");
                            System.out.println("*               2. Create your team an account          *");
                            System.out.println("*               3. Give task to your team               *");
                            System.out.println("*               4. Check your team progress             *");
                            System.out.println("*               5. Log-out                              *");
                            System.out.println("*********************************************************");
                            System.out.print("Enter the number of the menu HERE: ");
                            pil=inputInteger.nextInt();
                            System.out.println();
                            System.out.println();


                            switch (pil){
                                    case 1:
                                    {
                                            System.out.println("*********************************************************");
                                            System.out.println("*   Starting a new project is easy with these 3 steps   *");
                                            System.out.println("*********************************************************");
                                            System.out.println();
                                            System.out.println();
                                            //panggil method disini
                                            break;
                                    }

                                    case 2:
                                    {	
                                            System.out.println("*********************************************************");
                                            System.out.println("*     Create an account for each of your programmers    *");
                                            System.out.println("*********************************************************");
                                            System.out.println();
                                            System.out.println();	
                                            //panggil method disini
                                            break;
                                    }

                                    case 3:
                                    {
                                            System.out.println("*********************************************************");
                                            System.out.println("*      Assign task for your prgrammers individually     *");
                                            System.out.println("*********************************************************");
                                            System.out.println();
                                            System.out.println();
                                            //panggil method disini
                                            break;
                                    }

                                    case 4:
                                    {	
                                            System.out.println("*********************************************************");
                                            System.out.println("*          Checking on the project's progress           *");
                                            System.out.println("*********************************************************");
                                            System.out.println();
                                            System.out.println();
                                            //panggil method disini
                                            break;
                                    }

                                    case 5:
                                    {
                                            System.out.println("*********************************************************");
                                            System.out.println("*             Thank you for using ON-BOARD!             *");
                                            System.out.println("*     We hope you had an amazing experience with us     *");
                                            System.out.println("*********************************************************");
                                            System.out.println();
                                            System.out.println();					
                                            break;
                                    }		
                                    default:
                                    {
                                            throw new IllegalStateException("Sorry, wrong input >_<");
                                    }
                            }
            }catch (Exception e){
                    System.out.println("Error: "+e.getMessage());
                }
        } while (pil!=0);
    }
}
