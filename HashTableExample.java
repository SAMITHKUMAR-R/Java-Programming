package programs;

/*
Create a hashTable object and add the following object in the 100 , 200 , 300 ,400
 */

import java.util.Hashtable; 

public class HashTableExample { 
	public static void main(String[] args) { 
 
        Hashtable<Integer, String> ht = new Hashtable<>(); 

        ht.put(100, "Object1"); 
        ht.put(200, "Object2"); 
        ht.put(300, "Object3"); 
        ht.put(400, "Object4"); 
 
        for (Integer key : ht.keySet()) { 
            System.out.println("Key: " + key + "  Value: " + ht.get(key)); 
        } 
	}

}
