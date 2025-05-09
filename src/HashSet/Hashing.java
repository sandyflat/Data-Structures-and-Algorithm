package HashSet;
import java.util.HashSet;
import java.util.Iterator;

public class Hashing {
    public static void main(String[] args) {
        // Creating HashSet
        HashSet<Integer> hashSet = new HashSet<>();

        // Insert
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(1);       // set doesnot allowed duplicate element to insert.
        hashSet.add(3);

        // Search - contains
        if(hashSet.contains(1)){
            System.out.println(" 1 is present in set.");
        }

        // Delete - remove
        hashSet.remove(2);
        if(hashSet.contains(2)){
            System.out.println(" 2 is present in set.");
        }else{
            System.out.println("2 is not present in set.");
        }

        // To print all elements of the set.
        System.out.println(hashSet);

        // print size of hashset
        System.out.println("size of set is :" + hashSet.size());

        // Iterator
        Iterator iterator = hashSet.iterator();      // it contains two methods
                                                      // .next and .hasNext
        while(iterator.hasNext()){    // returns true if there is next element in set
            System.out.println(iterator.next());    // returns next element.
        }





    }

}
