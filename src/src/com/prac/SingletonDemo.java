package src.com.prac;
//This is a demo program for SingleTonClass.java

public class SingletonDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleTonClass p1 = SingleTonClass.getInstance();
		SingleTonClass p2 = SingleTonClass.getInstance();
		//Here we are reducing the health of p1 and p2. 
		//But both are referring to the same object.
		p1.damage();
		p2.damage();
		//Print the health
		System.out.printf("Player name: %s\n", p1.getName());
		System.out.printf("Player Health: %d\n", p1.getHealth());
		
		//Print the health
		System.out.printf("Player name: %s\n", p2.getName());
		System.out.printf("Player Health: %d\n", p2.getHealth());
	}

}
