/*
    * Muhammad Ashraf Ewaily        14101380
    * Theory of Computation | Turing Machine Simulator
 */
package turing_machine;

import java.util.Scanner;
public class Turing_Machine {
    public static void main(String[]args){
        
        Scanner input = new Scanner(System.in);
        int NS ,NA ,current,q=0,count;
        String tape ;
        
        System.out.println("No of states");
        NS = input.nextInt();                   // getting the number of states
        System.out.println("No of alphabets");
        NA = input.nextInt();                   // getting the number of alphabets used in the states
        String[] Alphabets = new String[NA];
        String[][] Trans = new String[NS-2][NA];
        for(int i =0;i<NA;i++){
        System.out.println("Alphabet no "+(i+1));
        Alphabets[i]=input.next();              // getting the alphates 
        }
        
        for(int i =0;i<NS-2;i++){
            for(int j =0;j<NA;j++){
        System.out.println("Transition state for alphabet "+Alphabets[j]+" for the state no "+i+"\nL / R,Goto state no,Write");
        Trans[i][j]=input.next();           // saving the transition for each alphabet at each state in a form of (  ,   , )
            }
        }
        
        System.out.println("Tested string");
        tape = input.next();                    // getting the string we shall to test 
        tape+="u";
        char[] Tape = tape.toCharArray();               // save the string we shall to test in an array of characters
        System.out.println("Head position");
        current =input.nextInt();                   
        
        while(q<Tape.length){                           // stop we we reach the end of the string
            String a = String.valueOf(Tape[q]);
            for(count=0;count<Alphabets.length;count++){
                if(Alphabets[count].contains(a)){           // match the alphabet in the string with the alhpabets we got
                    break;
                }
            }
                String[] x=Trans[current][count].split(",");    // splitting the transaition starting with the current == head **position**
                
                current = Integer.parseInt(x[1]);               // updating the head for the next loop
                char[] v = x[2].toCharArray();  // the alphabet we will update with
                Tape[q] = v[0];                 // updating the alphabet
                if("r".equals(x[0])){
                    q++;
                }
             
            
            if(current==NS-1||current==NS-2){           // check if we reach a reject / accept state or not
                break;
            }
        }
        
        if(current == NS-2){
            System.out.println("accepted");
        }
        else{
            System.out.println("rejected");
        }
        tape = String.valueOf(Tape);
        System.out.println(tape);
    }
    
}