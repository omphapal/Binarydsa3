package binarySearch;

import java.util.*;

public class Bs2 {

    public static void main(String[] args) {
        // Create a list
        List<Domain> l = new ArrayList<Domain>();
        l.add(new Domain(10, "Www.Geeksforgeeks.com"));
        l.add(new Domain(20, "www.practice.com"));
        l.add(new Domain(30, "code.geeks.com"));
        l.add(new Domain(40, "geeksforgeeks.com"));

        // Define the Comparator for sorting and searching by id
        Comparator<Domain> c = new Comparator<Domain>() {
            public int compare(Domain u1, Domain u2) {
                // Integer.compareTo() works correctly here
                return u1.getId().compareTo(u2.getId()); 
            }
        };

        // --- Step 1: Sort the list ---
        // Binary search requires the list to be sorted according to the comparator 'c'
        Collections.sort(l, c);
        //  

        // --- Step 2: Perform the Binary Search ---
        
        // Searching for a domain with key value 20
        // We create an object of domain with key 20 to search
        Domain searchKey20 = new Domain(20, null);
        int index20 = Collections.binarySearch(l, searchKey20, c);
        
        System.out.println("Index of Domain with ID 20: " + index20); // Expected output: 1 (since the list is sorted: 10, 20, 30, 40)

        // Searching for a domain with key value 5 (not present)
        Domain searchKey5 = new Domain(5, null);
        int index5 = Collections.binarySearch(l, searchKey5, c);
        
        // If the element is not found, binarySearch returns: (-(insertion point) - 1)
        System.out.println("Index of Domain with ID 5 (not found): " + index5); 
        // Expected output: -1 - 0 = -1 (since it would be inserted at index 0)
    }
}

// A user defined class to store domains with id and url
class Domain {
    private int id;
    private String url;

    // Constructor
    public Domain(int id, String url) {
        this.id = id;
        this.url = url;
    }

    // Returns the ID as an Integer object for use with the Comparator
    public Integer getId() {
        return Integer.valueOf(id);
    }

    // Optional: Override toString for better print output
    @Override
    public String toString() {
        return "Domain [id=" + id + ", url=" + url + "]";
    }
}
