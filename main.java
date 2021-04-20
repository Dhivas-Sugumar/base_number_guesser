import java.util.List;       
import java.util.Scanner;    

public class main {
  // Decalring variables 
    static int high;                                    // used to keep track of the highest index of a list 
    static int low;                                     // used to keep track of the lowest index of a list 
    static int guess;                                   // used to store the number guessed by the program 
    static int current_index;                           // used to keep track of the current index 
    static int count=1;                                 // used to keep track of how many times a guess is made 
    static int ceiling=15;                              // the maximum number of tries
    static boolean done=false;                          // boolean to exit out of the program 
    static Scanner answer= new Scanner(System.in);      // used to store the user input 
    
  
    static public void main(String[] args)
    {
      final String YES="Y"; 
      final String NO="N";
      final String BINARY="B";
      final String DECIMAL="D";
      final String Hexadecimal= "H";

      int mult_var=1;

      //variables used to store the users answer to each question  
      String base_answer;  
      String start_answer;
      String guess_answer;
      String decimal_question_answer; 
      String prime_question_answer;
      String two_question_answer;
      String three_question_answer;
      String five_question_answer;
      String seven_question_answer;

      //Lists for each question
      List<Integer> primenumbers = listbuilder.makePrimes();
      List<Integer> divby2 = listbuilder.make_list(new ByTwo());
      List<Integer> divby3 = listbuilder.make_list(new Bythree());
      List<Integer> divby5 = listbuilder.make_list(new  Byfive());
      List<Integer> divby7 = listbuilder.make_list(new Byseven());
  
      // Game instructions and prompt to start
      System.out.println("Think of a number between " + "0" + " and " + 65535 + " in either decimal, binary, or heaxadecimal");
      System.out.println("I will guess your number in " + ceiling + " or fewer tries \n Just answer the following questions");
      System.out.println("Are you thinking of a number? \n Enter (Y) if yes or (N) if no");
      start_answer = answer.next();
   
      // Switch case to handle Yes or No depending on the users imput
      switch (start_answer.toUpperCase())
      {
        //Handles the code if the user does have a number in mind 
        case YES:
        //Question to ask which base the user is thinking of. 
        System.out.println("What base are you thinking of?");
        System.out.println("For Decimal: D");
        System.out.println("For Binary: B");
        System.out.print("For Hexadecimal: H");
    
        base_answer = answer.next();
        
        //Switch case to handle each base 
        switch (base_answer.toUpperCase())
        {
          // Handles the binary base case
          case BINARY:
          System.out.println("You chose Binary");
          
          // Asks the user if they are thinking of a prime number 
          System.out.println("Is your number a prime number?: Y (Yes) N (No)");
          prime_question_answer = answer.next();

          
          if (prime_question_answer.toUpperCase().equals("Y")){     // Checks if the answer to the prime question is yes 
            // The user has answered yes. Executes the code for prime. 

            System.out.println("Your number is prime");

            // Assigns 0 as the highest index. Assigns the index of the last element as high.
            low=0;
            high= primenumbers.size() - 1;
  
            //While loop to repeat guesses. 
           while (!done){
             // calculates the midpoint of the list 
             current_index = ((high+low)/2);
             guess = (primenumbers.get(current_index));  // used to obtain the element in the list 
             System.out.println("Are you thinking of "+ base_converter.binary_convert(guess) +" ?"+ "\n Y : Yes or N : No");  // outputs guess
             guess_answer =answer.next();
  
             // guessed correctly 
             if (guess_answer.toUpperCase().equals("Y")){
               System.out.println("I guessed it in " + count + " tries");
               done=true;
               break;
             } 
             // guessed incorrectly 
             else{
               ++count;
               // stops the game if the number of tries is greater than the ceiling 
               if (count >= ceiling ){
                 System.out.println(" I couldn't guess it in time. Good Pick");
                 done=true;
               }
               // continues the game if the number of tries is lower than ceiling 
               else{
                 System.out.println("Is your number smaller than " + base_converter.binary_convert(guess)  + " ?");  // outputs the guess as a binary
                 guess_answer=answer.next();
                 
                 if (guess_answer.toUpperCase().equals("Y")){
                   high=current_index-1;  // reduces high by 1
                 }
                 else{
                   low = current_index +1; // increases low by 1
                 }
  
               }
  
  
             }
  
              
            }
  
      
  
          }
          else{
          // If the number is not prime   
          System.out.println("Is you number divisible by 2? Y (Yes) N (No)");
          two_question_answer = answer.next();

          System.out.println("Is you number divisible by 3? Y (Yes) N (No)");
          three_question_answer = answer.next();

          System.out.println("Is you number divisible by 5? Y (Yes) N (No)");
          five_question_answer = answer.next();

          System.out.println("Is you number divisible by 7? Y (Yes) N (No)");
          seven_question_answer = answer.next();

          // if functions to increase multi var depending on the users response to questions. 
          if(two_question_answer.toUpperCase().equals("Y")){
            mult_var = mult_var * 2;
          }

        if(three_question_answer.toUpperCase().equals("Y")){
            mult_var = mult_var * 3; 
        }

        if(five_question_answer.toUpperCase().equals("Y")){
            mult_var = mult_var * 5;
        }

        if(seven_question_answer.toUpperCase().equals("Y")){
            mult_var = mult_var * 7;
        }         
        
        // Calls make_list with muti var to make a list containing numbers only of a certain multiple. 
        List<Integer> list = listbuilder.make_list(new ByAny(mult_var));

          // Assigns 0 as the highest inde. Assigns the index of the last element as high.
          low=0;
          high= list.size() - 1;

         while (!done){
           current_index = ((high+low)/2);    // calculates the midpoint of the list 
           guess = (list.get(current_index)); // used to obtain the element in the list
           System.out.println("Are you thinking of "+ base_converter.binary_convert(guess) + " ?"+ "\n Y : Yes or N : No"); // outputs guess in binary 
           guess_answer =answer.next();

            // guessed correctly 
           if (guess_answer.toUpperCase().equals("Y")){
             System.out.println("I guessed it in " + count + " tries");
             done=true;
             break;
           } 

           // guessed incorrectly 
           else{
             ++count;
            // stops the game if the number of tries is greater than the ceiling 
             if (count >= ceiling ){
               System.out.println(" I couldn't guess it in time. Good Pick");
               done=true;
             }
             // continues the game if the number of tries is lower than ceiling 
             else{
               System.out.println("Is your number smaller than " +  base_converter.binary_convert(guess) + " ?");
               guess_answer=answer.next();
               
               if (guess_answer.toUpperCase().equals("Y")){
                 high=current_index-1; // reduces high by 1
               }
               else{
                 low = current_index +1; // increases low by 1
               }

             }


           }

            
          }

          }



  
          break;

          // Handles the decimal base case
          case DECIMAL:

          // Asks the user if they are thinking of a prime number 
          System.out.println("Is your number a prime number?: Y (Yes) N (No)");
          prime_question_answer = answer.next();
  
          if (prime_question_answer.toUpperCase().equals("Y")){ // Checks if the answer to the prime question is yes 
            // The user has answered yes. Executes the code for prime. 
            
            System.out.println("Your number is prime");

            // Assigns 0 as the highest index. Assigns the index of the last element as high.

            low=0;
            high= primenumbers.size() - 1;
            
            //While loop to repeat guesses. 
           while (!done){
             // calculates the midpoint of the list 
             current_index = ((high+low)/2);   // used to obtain the element in the list 
             guess = (primenumbers.get(((high + low)/2) ));
             System.out.println("Are you thinking of "+guess +" ?"+ "\n Y : Yes or N : No");
             guess_answer =answer.next();
  
              // guessed correctly 
             if (guess_answer.toUpperCase().equals("Y")){
               System.out.println("I guessed it in " + count + " tries");
               done=true;
               break;
             } 

             // guessed incorrectly 
             else{
               ++count;
               // stops the game if the number of tries is greater than the ceiling 
               if (count >= ceiling ){
                 System.out.println(" I couldn't guess it in time. Good Pick");
                 done=true;
               }
               // continues the game if the number of tries is lower than ceiling 
               else{
                 System.out.println("Is your number smaller than " + guess + " ?");  // outputs the guess in decimal 
                 guess_answer=answer.next();
                 
                 if (guess_answer.toUpperCase().equals("Y")){
                   high=current_index-1;   // reduces high by 1
                 }
                 else{
                   low = current_index +1; // increases low by 1
                 }
  
               }
  
  
             }
  
              
            }
  
      
  
          }
          else{
          // If the number is not prime             
          System.out.println("Is you number divisible by 2? Y (Yes) N (No)");
          two_question_answer = answer.next();

          System.out.println("Is you number divisible by 3? Y (Yes) N (No)");
          three_question_answer = answer.next();

          System.out.println("Is you number divisible by 5? Y (Yes) N (No)");
          five_question_answer = answer.next();

          System.out.println("Is you number divisible by 7? Y (Yes) N (No)");
          seven_question_answer = answer.next();
            // if functions to increase multi var depending on the users response to questions. 
          if(two_question_answer.toUpperCase().equals("Y")){
            mult_var = mult_var * 2;
          }

        if(three_question_answer.toUpperCase().equals("Y")){
            mult_var = mult_var * 3; 
        }

        if(five_question_answer.toUpperCase().equals("Y")){
            mult_var = mult_var * 5;
        }

        if(seven_question_answer.toUpperCase().equals("Y")){
            mult_var = mult_var * 7;
        }         
        // Calls make_list with muti var to make a list containing numbers only of a certain multiple. 
        List<Integer> list = listbuilder.make_list(new ByAny(mult_var));

        // Assigns 0 as the highest index. Assigns the index of the last element as high.
          low=0;
          high= list.size() - 1;

         while (!done){
           current_index = ((high+low)/2);    // calculates the midpoint of the list 
           guess = (list.get(((high + low)/2) ));   // used to obtain the element in the list
           System.out.println("Are you thinking of "+ guess +" ?"+ "\n Y : Yes or N : No"); // outputs guess in decimal 
           guess_answer =answer.next();

           // guessed correctly 
           if (guess_answer.toUpperCase().equals("Y")){
             System.out.println("I guessed it in " + count + " tries");
             done=true;
             break;
           } 

           // guessed incorrectly
           else{
             ++count;
            // stops the game if the number of tries is greater than the ceiling 
             if (count >= ceiling ){
               System.out.println(" I couldn't guess it in time. Good Pick");
               done=true;
             }
             // continues the game if the number of tries is lower than ceiling 
             else{
               System.out.println("Is your number smaller than " + guess + " ?");
               guess_answer=answer.next();
               
               if (guess_answer.toUpperCase().equals("Y")){
                 high=current_index-1;  // reduces high by 1
               }
               else{
                 low = current_index +1; // increases low by 1
               }

             }


           }

            
          }

          }

          break; 
         // Handles the hexadecimal base case
          case Hexadecimal:
          System.out.println("You chose Hexadecimal");

           // Asks the user if they are thinking of a prime number 
          System.out.println("Is your number a prime number?: Y (Yes) N (No)");
          prime_question_answer = answer.next();
  
          if (prime_question_answer.toUpperCase().equals("Y")){   // Checks if the answer to the prime question is yes 
             // The user has answered yes. Executes the code for prime. 
            System.out.println("Your number is prime");
            // Assigns 0 as the highest index. Assigns the index of the last element as high.
            low=0;
            high= primenumbers.size() - 1;
            
           //While loop to repeat guesses. 
           while (!done){
             // calculates the midpoint of the list 
             current_index = ((high+low)/2);
             guess = (primenumbers.get(((high + low)/2) ));  // used to obtain the element in the list 
             System.out.println("Are you thinking of "+ base_converter.hexadecimal_convert(guess) +" ?"+ "\n Y : Yes or N : No");  // outputs guess in hexadecimal 
             guess_answer =answer.next();
            
             // guessed correctly 
             if (guess_answer.toUpperCase().equals("Y")){
               System.out.println("I guessed it in " + count + " tries");
               done=true;
               break;
             } 
             // guessed incorrectly
             else{
               ++count;
              // stops the game if the number of tries is greater than the ceiling 
               if (count >= ceiling ){
                 System.out.println(" I couldn't guess it in time. Good Pick");
                 done=true;
               }
              // continues the game if the number of tries is lower than ceiling 
               else{
                 System.out.println("Is your number smaller than " + base_converter.hexadecimal_convert(guess) + " ?"); // outputs the guess in hexadecimal 
                 guess_answer=answer.next();
                 
                 if (guess_answer.toUpperCase().equals("Y")){
                   high=current_index-1;   // reduces high by 1
                 }
                 else{
                   low = current_index +1; // increases low by 1
                 }
  
               }
  
  
             }
  
              
            }
  
      
  
          }
          else{
          // If the number is not prime     
          System.out.println("Is you number divisible by 2? Y (Yes) N (No)");
          two_question_answer = answer.next();

          System.out.println("Is you number divisible by 3? Y (Yes) N (No)");
          three_question_answer = answer.next();

          System.out.println("Is you number divisible by 5? Y (Yes) N (No)");
          five_question_answer = answer.next();

          System.out.println("Is you number divisible by 7? Y (Yes) N (No)");
          seven_question_answer = answer.next();

          // if functions to increase multi var depending on the users response to questions. 
          if(two_question_answer.toUpperCase().equals("Y")){
            mult_var = mult_var * 2;
          }

        if(three_question_answer.toUpperCase().equals("Y")){
            mult_var = mult_var * 3; 
        }

        if(five_question_answer.toUpperCase().equals("Y")){
            mult_var = mult_var * 5;
        }

        if(seven_question_answer.toUpperCase().equals("Y")){
            mult_var = mult_var * 7;
        }         
        // Calls make_list with muti var to make a list containing numbers only of a certain multiple. 
        List<Integer> list = listbuilder.make_list(new ByAny(mult_var));

          // Assigns 0 as the highest inde. Assigns the index of the last element as high.
          low=0;
          high= list.size() - 1;

         while (!done){
           current_index = ((high+low)/2);            // calculates the midpoint of the list 
           guess = (list.get(((high + low)/2) ));   // used to obtain the element in the list
           System.out.println("Are you thinking of "+ base_converter.hexadecimal_convert(guess) +" ?"+ "\n Y : Yes or N : No"); // outputs guess in hexadecimal 
           guess_answer =answer.next();
            // guessed correctly 
           if (guess_answer.toUpperCase().equals("Y")){
             System.out.println("I guessed it in " + count + " tries");
             done=true;
             break;
           } 
          // guessed incorrectly 
           else{
             ++count;
             // stops the game if the number of tries is greater than the ceiling 
             if (count >= ceiling ){
               System.out.println(" I couldn't guess it in time. Good Pick");
               done=true;
             }
             // continues the game if the number of tries is lower than ceiling 
             else{
               System.out.println("Is your number smaller than " + base_converter.hexadecimal_convert(guess) + " ?");
               guess_answer=answer.next();
               
               if (guess_answer.toUpperCase().equals("Y")){
                 high=current_index-1;      // reduces high by 1
               }
               else{
                 low = current_index +1;    // increases low by 1
               }

             }


           }

            
          }

          }
  
          break;
          // unrecognised base format. 
          default:
          System.out.println("I do not recognize this base. I shall tell my creators to add it in a future version.");
          break;
  
        }
  
  
        break;
        // If the user is not thinking of a number 
        case NO:
        System.out.println("'Clear your mind is. At peace you are'- Yoda");
        break;
        // unrecognized input
        default:
        System.out.println("Mamma Mia! Your input is not recognized. You got to try again!");
        break;
      }
    }
    
}
