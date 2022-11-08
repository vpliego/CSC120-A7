import java.util.Hashtable; 
import java.util.Set;
/*Here we are using the extend keyword to indicate that the class which 
*is being defined is derived from the base class (Building) --> inheritance 
 */
public class Library extends Building {
/*for our library, we will have a collection of book titles so they will be stored a Hashtable
 */
    private Hashtable<String, Boolean> collection;

/*here we are carrying attributes over from the parent class and adding our own so that we can use the Hashtable.
 * @param name, address, nFloors
 * 
 */
    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      this.collection = new Hashtable<String, Boolean>();

    }
/* this method will update the Hashtable containing the collection every time we add a title
*@param title 
*/    
    public void addTitle(String title){
      this.collection.put(title,true);
    }
/*these methods will modify the value associated with the given key(the title)
 * @param title
 */
    public void checkOut(String title){
      this.collection.replace(title, false);
    }
    public void returnBook(String title){
      this.collection.replace(title, true);
    }
/* this method will update the Hashtable containing the collection every time we remove a title
* @param title
* @return the title of removed book
*/  
    public String removeTitle(String title){
      this.collection.remove(title, false);
      return title;
    }
/*this will check if a book is in the library's collection
*@param title
*returns true if the title appears as a key in the Libary's collection, false otherwise
*/ 
    public boolean containsTitle(String title){
      return this.collection.containsKey(title);
    } 

/*this will check if a book is currently available or not
*@param title
*returns true if the title is currently available, false otherwise
*/    
    public boolean isAvailable(String title){
      return this.collection.get(title);
    }
// prints out the entire collection(including checkout status)
    public void printCollection(){
     Set<String> keys = this.collection.keySet(); 
      for (String key: keys){
        System.out.println("This book: " + key + collection.get(key));
      }
    }

    public static void main(String[] args) {
      new Library("Neilson Library", "7 Neilson Drive, Northampton, MA 01063", 5);
    }
  
  }