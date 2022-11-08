import java.util.ArrayList;

/* Here we are using the extend keyword to indicate that the class which 
*is being defined is derived from the base class (Building) --> inheritance.
*/
public class House extends Building {
  ArrayList<String> residents;
  boolean hasDiningRoom;
  int nResidents;
  boolean hasFloors;
  
  public House() {
    this("<Name Unknown>", "<Address Unknown>", 3, true);
}

/* Overloaded constructor with address only */
public House(String address) {
    this(); // Call default constructor
    this.address = address; // Override address
}

/* Overloaded constructor with name, address, floors, and hasDR
 * @param name, address
 */
public House(String name, String address) {
    this(name, address, 3, true); // Call full constructor with hard-coded # floors
}



/*in here, we are using the same params from the Building class so that it can be accessed/used
*@param name, addresss, nFloors, hasDR
*/  
  public House(String name, String address, int nFloors, boolean hasDR) {
    super(name, address, nFloors);
    this.hasDiningRoom=hasDR;
    this.residents=new ArrayList<String>();
    if (nFloors > 1) {
      hasFloors = true; 
     } else{
       hasFloors = false;
     }
  }
  
/*this is an accessor that'll be able to retrieve the indicated values
*@return the num of residents
*/    
  public int nResidents(){
    return this.nResidents;
  }
/*this is an accessor that'll be able to retrieve the indicated values
*@return true or false to indicate if house has dining room 
*/  
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }
   
/*this will update the ArrayList of residents every time someone moves in
*@param name
*/  
  public void moveIn(String name){
    this.residents.add(name);
    this.nResidents += 1;
  }
/* this will update the ArrayList of residents every time someone moves out
*@param name
*/    
  public String moveOut(String name){
    this.residents.remove(name);
    this.nResidents -= 1;
    return name;
  }
/*this method tells us whether or not the given person is a resident of the House 
*@param person 
*@return true or false to tell us if given person is resident of house
*/
  public boolean isResident(String person){
    return this.residents.contains(person);
    
  }
/*In order to allow the showOptions method to take in the attributes made in library, we must add them below with n inside so that it knows to pass something into them. 
 */  
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n) \n + moveOut(n) \n + isResident(n) /n + nResidents(n) /n + hasDiningRoom(n) /n + moveIn(n)");
}
/*To make this more efficient, we will use a boolean in the constructor that can be called here so that the code runs the following if statements only if it truly applies. Otherwise, it can just print that the house does not have multiple floors. 
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
    new House("Park Annex", "117 Elm St, Northampton, MA 01063", 4, true);
  }

}