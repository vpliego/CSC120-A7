/* Here we are using the extend keyword to indicate that the class which 
*is being defined is derived from the base class (Building) --> inheritance.
*/
public class Cafe extends Building{

    // The number of ounces of coffee remaining in inventory
    private int nCoffeeOunces;
        
    
    // The number of sugar packets remaining in inventory
    private int nSugarPackets; 
    
    // The number of "splashes" of cream remaining in inventory
    private int nCreams; 
    
    // The number of cups remaining in inventory
    private int nCups; 
    
/* this will allow us to inherit attributes from superclass and add our own
 */    
    public Cafe(String name, String address, int nFloors) {
    super(name, address, nFloors);
     this.nCoffeeOunces = 20;
     this.nSugarPackets = 28;
     this.nCreams = 20;
     this.nCups = 30;
    


       
}
/* this is a private method that'll allow us to restock inventory when necessary
*@param nCoffeeOunches, nSugarPackets, nCreams, nCups 
*/    
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;

}
/*this method will allow us to decrease the remaining inventory when the Cafe sells a cup of
* of coffee while also accounting how much is in inventory so it can restock if needed by using the restock method above. 
*@param size, nSugarPackets, nCreams
*/    
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if (this.nCoffeeOunces == 0 || this.nSugarPackets == 0 || this.nCreams == 0 || this.nCups == 0){
            restock(50,50,50,50);
        }


        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
}

    public static void main(String[] args) {
        new Cafe("Compass Cafe", "7 Neilson Drive, Northampton, MA 01063", 5);
    }
    
}
