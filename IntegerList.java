package csc1009.src.lect06;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Random;

public class IntegerList{

    //Question 1: addAndSort(); can just straight away use collections as well. 
    public static void addAndSort(LinkedList<Integer> list, int value){

        if (list.size() ==0){
            list.add(value);
        }
        else if(list.get(0) > value){
            list.add(0,value);
        }
        else if(list.get(list.size()-1) < value){
            list.add(list.size(), value);
        }
        else{
            int i=0;
            while (list.get(i) < value){
                i++;
            }
            list.add(i, value);
        }
        return;
    }

    //Question 2: swap()
    public static void swap(LinkedList<Integer> list, int indexOne, int indexTwo){ 
        int element1 = list.get(indexOne);
        int element2 = list.get(indexTwo);

        list.set(indexOne, element2);
        list.set(indexTwo, element1);
    }

    //Question 3: Random
    public static int findValue(LinkedList<Integer>list, int searchVal){
        for(int i=0; i < list.size(); i++){
            if (searchVal == list.get(i)){
                return list.indexOf(i);
            }
        }
        return -1;
    } 

    public static void main (String[] args){

        //Question 1
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number to insert: ");
        int value= input.nextInt();


        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        
        for (int i=1; i < 12; i++){
            if(i%2 !=0){
                linkedList.add(i);
            }
        }

        System.out.println("Before Change(A): " + linkedList);
        addAndSort(linkedList, value);
        System.out.println("After Change(A): " + linkedList);


        //Question 2:
        linkedList.clear();
        for (int i=1; i < 12; i++){
            if(i%2 !=0){
                linkedList.add(i);
            }
        }
        System.out.println("");
        
        System.out.println("Before Change(S): " + linkedList);
        swap(linkedList, 1, 5);
        System.out.println("After Change(S): " + linkedList);


        //Question 3:
        Random random= new Random();
        LinkedList<Integer>linkedList2 = new LinkedList<Integer>();

        for (int i=0; i < 500; i++){
            int randomNumber = random.nextInt(9000-1000) + 1000;
            //random.nextInt(high-low) + low
            linkedList2.add(randomNumber); //create a linked-list of 500 random numbers from 1000 to 9999;
        }

        System.out.println("Random Generated List: " + linkedList2);
        int searchVal= random.nextInt(9000-1000) + 1000;
        System.out.println("Search Value: " + searchVal);

        System.out.println("Position of Search Value: "+ findValue(linkedList2, searchVal));

        input.close();

    }
}

