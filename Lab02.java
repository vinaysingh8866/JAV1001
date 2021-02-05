

import java.util.Scanner;
/**
 *
 * @author vinay
 */
public class Lab02 {

    /**
     * @param args the command line arguments
     */
       
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Enter \n 1 for cypher \n 2 for decypher \n 3 For calculating array sum \n 4 Find in array");
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        if(value==1){
            cypher();
        }
        else if(value==2){
            decypher();
        }
        else if (value==3){
            sum();
        }
        else if(value==4){
            find_in_array();
        }
        else{
            System.out.println("Enter Correct selection");
        }
    }
    static void cypher(){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Sting to cypher");
        String value = sc.nextLine();
        System.out.println("Enter value to shift by");
        int scrm_by = sc.nextInt();
        String scram_value = new String();
        System.out.println(value.length());
        for (int i=0;i<value.length();i++){
            char character = value.charAt(i);
            int ascii = (int) character;
            char scram_char =  (char) (ascii + scrm_by);
            scram_value +=scram_char;
            
        }
        
        System.out.println(scram_value);
        
    }
    
    static void decypher(){
        System.out.println("Enter Sting to cypher");
        Scanner sc = new Scanner(System.in);
        String scram_value = sc.nextLine();
        System.out.println("Enter Shift value");
        int scram_by = sc.nextInt();
        String dec_value = new String();
        for (int i=0;i<scram_value.length();i++){
            char character = scram_value.charAt(i);
            int ascii = (int) character;
            char scram_char =  (char) (ascii - scram_by);
            dec_value +=scram_char;
            
        }
        System.out.println("Dechyphered cypher");
        System.out.println(dec_value);
    }
    
    static void sum(){
        
        System.out.println("Enter Array");
        Scanner sc = new Scanner(System.in);
        int[] array_sum = new int[10];
        int sum = 0;
        for (int i=0;i<10;i++){
            int val = sc.nextInt();
            array_sum[i]=val;
            sum+=val;
        }
        System.out.println("Sum of array is "+ (sum));
        
        String scram_value = sc.nextLine();
        
    }
    
    static void find_in_array(){
        int[] num = new int[10];
        for (int i=0;i<num.length;i++){
            num[i]= (int) (Math.random()*100);
            System.out.print(num[i]+",");
        }
        
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter value to find");
        int val = sc.nextInt();
        int find_num = val;
        boolean hit = false;
        for (int n : num){
            if (n==find_num){
                hit = true;
            }
        }
        if(hit){
            System.out.println(find_num+ " is found");
        }
        else{
            System.out.println(find_num + " Not Found");
        }
    }
}
