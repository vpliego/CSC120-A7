import java.util.ArrayList;

/* Here we are using the extend keyword to indicate that the class which 
*is being defined is derived from the base class (Building) --> inheritance.
*/
public class House extends Building {
  ArrayList<String> residents;
  boolean hasDiningRoom;
  int nResidents;
  
/*in here, we are using the same params from the Building class so that it can be accessed/used
*@param name, addresss, nFloors, hasDR
*/  
  public House(String name, String address, int nFloors, boolean hasDR) {
    super(name, address, nFloors);
    this.hasDiningRoom=hasDR;
    this.residents=new ArrayList<String>();
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

  
  public static void main(String[] args) {
    new House("Park Annex", "117 Elm St, Northampton, MA 01063", 4, true);
  }

}