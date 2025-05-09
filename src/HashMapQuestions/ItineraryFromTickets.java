package HashMapQuestions;

/*
Title: Find Itinerary/path from Given Tickets

 Description:
 -> This code determines the complete travel itinerary from a set of source-to-destination ticket pairs.
 -> It ensures there is only one unique path from the starting source to the final destination without
    any circular loops or multiple paths between any two points.

 Key points:
 1. Each ticket represents a journey from a source address to a destination address.
 2. There is exactly one unique path from the starting point to the final destination.
 3. The traveler does not return to any source address once they leave it.
 */

import java.util.HashMap;

public class ItineraryFromTickets {
    // this getStart function returns the source address from where journey is started.
    public static String getStart(HashMap<String, String> ticket){
        // reverse the original hashmap to find the value of start.
        // starting address must not be presented in destination address.
        HashMap<String, String> reverseMap = new HashMap<>();

        for(String key: ticket.keySet()){   // keySet() method gives set of key of hashmap
            // Swapping key as value and value as key and store in reverseMap hashmap.
            reverseMap.put(ticket.get(key), key);
        }

        // checks whether the key of original hashmap existed in key of reverse hashmap
        for(String key: ticket.keySet()){
            if(!reverseMap.containsKey(key)){
                return key;   // it's become starting destination.
            }
        }
         return null;
    }

    public static void findItinerary(HashMap<String, String> tickets){
        // at first find starting address
        String start = getStart(tickets);
        while(tickets.containsKey(start)){
            System.out.print(start +" ---> ");
            start = tickets.get(start);      // new start will be its value.
        }
        // at last print key which doesn't have any value
        System.out.print(start);
    }

    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();
        // tickets from source to destination
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        findItinerary(tickets);
    }
}
