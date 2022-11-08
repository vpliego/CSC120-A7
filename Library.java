import java.util.Hashtable; 
import java.util.Set;
/*Here we are using the extend keyword to indicate that the class which 
*is being defined is derived from the base class (Building) --> inheritance 
 */
public class Library extends Building {
/*for our library, we will have a collection of book titles so they will be stored a Hashtable
 */
    private Hashtable<String, Boolean> collection;
    public Boolean hasFloors;

    public Library() {
      this("<Name Unknown>", "<Address Unknown>", 5);
  }
  
  /* Overloaded constructor with address only */
  public Library(String address) {
      this(); // Call default constructor
      this.address = address; // Override address
  }
  
  /* Overloaded constructor with name, address */
  public Library(String name, String address) {
      this(name, address, 5); // Call full constructor with hard-coded # floors
  }   
/*here we are carrying attributes over from the parent class and adding our own so that we can use the Hashtable.
 * @param name, address, nFloors
 * 
 */
    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      this.collection = new Hashtable<String, Boolean>();
      if (nFloors > 1) {
       hasFloors = true; 
      } else{
        hasFloors = false;
      }

        
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
 /* In order to allow the showOptions method to take in the attributes made in library, we must add them below with n inside so that it knows to pass something into them. 
  */   
    public void showOptions() {
      System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n) \n + addTitle(n) \n + checkOut(n) \n + returnBook(n) \n + removeTitle(n) \n + containsTitle(n) \n + isAvailable(n) \n + printCollection(n)");
  }
/*To make this more efficient, we will use a boolean in the constructor that can be called here so that the code runs the following if statements only if it truly applies. Otherwise, it can just print that the building does not have multiple floors. 
 * @param floorNum
 */
  public void goToFloor(int floorNum) {
    if (this.hasFloors == true){
    if (this.activeFloor == -1) {
        throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
    }
    if (floorNum < 1 || floorNum > this.nFloors) {
        throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
    }
    System.out.println("You are now on floor #" + floorNum + " of " + this.name);
    this.activeFloor = floorNum;} else {
      System.out.println("Sorry! You're not in a building with multiple floors right now! :( ");
    }

}
    public static void main(String[] args) {
      new Library("Neilson Library", "7 Neilson Drive, Northampton, MA 01063", 5);
    }
  
  }