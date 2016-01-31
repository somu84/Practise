package src.com.prac;
//This is an implementation of Singleton Class in Java
//I'm going to create the Game Player Class which can only be instantiated once
public class SingleTonClass {
	private String pName;
	private Integer pHealth;
	private static SingleTonClass objects;
	//Constructor must be private for Singleton
	private SingleTonClass(){
		pName = "Player1";
		pHealth = 100;
	}
	/*The getInstance method is called to get an instance for 
	 * this class. It checks if an object isn't already present.
	 * If it is then return that object, else call the constructor to create it. 
	 */
	public static SingleTonClass getInstance(){
		if(objects == null){
			objects = new SingleTonClass();
		}
		return objects;
	}
	//Function to reduce health of the player by 1
	public void damage(){
		this.pHealth -= 1;
	}
	
	public String getName(){
		return this.pName;
	}
	
	public int getHealth(){
		return pHealth;
	}
	//
}
