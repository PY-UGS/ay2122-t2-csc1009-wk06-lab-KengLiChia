package csc1009.src.lect06;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class HashFormat {

    //Question 4
    public static HashMap<Integer, Integer> 
    addAndSort(HashMap<Integer,Integer> hashmap, int value){

        hashmap.put(6,value);

        List<Map.Entry<Integer, Integer> >list 
        = new LinkedList<Map.Entry<Integer,Integer> >(
            hashmap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    //Question 5:
    public static HashMap<Integer,Integer> swapValues(HashMap<Integer,Integer> hash, int indexOne, int indexTwo){
        int element1 = hash.get(indexOne);
        int element2 = hash.get(indexTwo);

        hash.replace(indexOne, element2);
        hash.replace(indexTwo, element1);

        return hash;
    }

    //Question 6:
    //hashmap has no concept of position. 
    public static int findValue(HashMap<Integer,Integer>hash, int searchVal){
        
        for(int i=0; i < hash.size(); i++){
            if (searchVal == hash.get(i)){
                return i;
            }
        }
        return -1;
    }


    public static void main(String args[]) {

        //Question 4
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number to insert: ");

        int value= input.nextInt();

        HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();

        hashmap.put(0,1);
        hashmap.put(1,3);
        hashmap.put(2,5);
        hashmap.put(3,7);
        hashmap.put(4,9);
        hashmap.put(5,11);

        System.out.println("Before Change(A): " + hashmap);
        System.out.println("After Change(A): " + addAndSort(hashmap, value));

        //Question 5
        hashmap.clear();
        hashmap.put(0,1);
        hashmap.put(1,3);
        hashmap.put(2,5);
        hashmap.put(3,7);
        hashmap.put(4,9);
        hashmap.put(5,11);
        
        System.out.println("Before Change(S): " + hashmap);
        System.out.println("Before Change(S): " + swapValues(hashmap, 1, 5));

        //Question 7
        Random random= new Random();
        HashMap<Integer,Integer> hashmap2 = new HashMap<Integer,Integer>();

        for (int i=0; i < 500; i++){
            int randomNumber = random.nextInt(9000-1000) + 1000;
            //random.nextInt(high-low) + low
            hashmap2.put(i, randomNumber); //create a linked-list of 500 random numbers from 1000 to 9999;
        }

        System.out.println("Random Generated HashMap: " + hashmap2);
        int searchVal= random.nextInt(9000-1000) + 1000;
        System.out.println("Search Value: " + searchVal);
        System.out.println("Position of Search Value: "+ findValue(hashmap2, searchVal));

        input.close();
    }
    
}
