package src.com.prac;

public class TestStatic {
	private String fname;
	private String lname;
	private static int members = 0;
	public static int countCall = 0;
	TestStatic(String fn, String ln){
		fname = fn;
		lname = ln;
		members++;
		return;
	}
	
	public static void display(TestStatic obj){
		countCall++;
		System.out.printf("First Name: %s\n", obj.fname);
		System.out.printf("Last Name: %s\n", obj.lname);
		System.out.printf("Total Members: %d\n", obj.members);
		return;
	}
	
}
