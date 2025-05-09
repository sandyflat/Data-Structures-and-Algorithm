package HashMapImplementation;
import java.util.*;

public class HashMapCode {
    static class HashMap<K, V>{    // generics
        private class Node{
            K key;
            V value;

            public Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        private int n;    // size of total nodes in hashmap
        private int N;    // size of the array
        private LinkedList[] buckets;    // N = buckets.length

        public HashMap(){
            this.N = 4;
            this.buckets = new LinkedList[4];
            for(int i=0; i<4; i++){
                this.buckets[i] = new LinkedList<>();     // create empty linked list in each bucket.
            }
        }

        private int hashFunction(K key){
            int bucketIndex = key.hashCode();    // .hashCode() method is predefined in java
            return Math.abs(bucketIndex) % N;     // which returns hash value of key.
            // it will return bucketIndex value always 0 to N-1;
        }

        private int searchInLinkedList( K key, int bucketIndex){
            LinkedList<Node> linkedList = buckets[bucketIndex];
            for(int i = 0; i< linkedList.size(); i++){
                if(linkedList.get(i).key == key){
                    return i;   // dataIndex;
                }
            }
            return -1;
        }

        private void rehash(){
             LinkedList<Node> oldBucket[] = buckets;  // copying old bucket data into new bucket.
             buckets = new LinkedList[N * 2];       // updating/re-initializing old bucket.

             for(int i = 0; i<N *2; i++){
                 buckets[i] = new LinkedList<>();   // creating empty linked-list in each bucket.
             }

             for(int i = 0; i< oldBucket.length; i++){
                 LinkedList<Node> linkedList = oldBucket[i];
                 for(int j = 0; j<linkedList.size(); j++){
                     Node node = linkedList.get(j);
                     put(node.key, node.value);       // put every key and value of old bucket into
                                                      // new bucket
                 }
             }
        }

        public void put (K key, V value){
            int bucketIndex = hashFunction(key);       // bucketIndex = array index.
            int dataIndex = searchInLinkedList(key, bucketIndex);  // returns actual data index.

            if(dataIndex == -1){    // key doesn't exist.
                buckets[bucketIndex].add(new Node(key, value));  // create new node with key and value.
                n++;
            }else{                  // key exists.
                Node node = (Node) buckets[bucketIndex].get(dataIndex);
                node.value = value;      // update the value if key already exists.
            }

            double lambda = (double)n/N;
            if(lambda > 2.0){                 // 2.0 is threshold value. in which max 2 no. of
                // rehashing                  // node in each bucket can be stored. otherwise rehashing
                rehash();                     // is done

            }
        }

        public V get(K key){
            int bucketIndex = hashFunction(key);       // bucketIndex = array index.
            int dataIndex = searchInLinkedList(key, bucketIndex);  // returns actual data index.

            if(dataIndex == -1){    // key doesn't exist.
               return null;
            }else{                  // key exists.
                Node node = (Node) buckets[bucketIndex].get(dataIndex);
                return node.value;     // if key exists return value of that node.
            }
        }

        public boolean containsKey(K key){
            int bucketIndex = hashFunction(key);       // bucketIndex = array index.
            int dataIndex = searchInLinkedList(key, bucketIndex);  // returns actual data index.

            if(dataIndex == -1){    // key doesn't exist.
                return false;
            }else{                  // key exists.
                return true;
            }
        }

        public V remove(K key){
            int bucketIndex = hashFunction(key);       // bucketIndex = array index.
            int dataIndex = searchInLinkedList(key, bucketIndex);  // returns actual data index.

            if(dataIndex == -1){    // key doesn't exist.
                return null;
            }else{                  // key exists.
                Node node = (Node) buckets[bucketIndex].remove(dataIndex);
                n--;
                return node.value;     // if key exists return value of that node.
            }
        }

        public boolean isEmpty(){
            return n == 0;
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();

            for(int i = 0; i<buckets.length; i++){
                LinkedList<Node> linkedList = buckets[i];
                for(int j = 0; j<linkedList.size(); j++){
                    Node node = linkedList.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();    // here we are using Hashmap class that we
                                                            // have created not a predefined class in
        map.put("Nepal", 234);                             // in java.
        map.put("China", 456);
        map.put("India", 345);
        map.put("USA", 670);

        ArrayList<String> keys = map.keySet();
        for(int i = 0; i<keys.size(); i++){
            System.out.println(keys.get(i) + " " + map.get(keys.get(i)));
        }

        map.remove("India");
        System.out.println(map.get("India"));
    }
}
