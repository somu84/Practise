package src.com.prac;

public class AmazonTechInterview {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,1,0,1,2,3,4,5,6};
		int i = find(arr, 8);
		if(i!= -1){
			System.out.println("Found at index: " + i);
			return;
		}
		System.out.println("Not found");
		return;
	}
	public static int find(int[] arr, int x)
	{
	    if(x == arr[0])
	    {
	        return 0;
	    }
	    int diff = 0;
	    while( diff <= arr.length -1)
	    {
	        if(x == arr[diff])
	        {
	            return diff;
	        }
	        diff = diff + difference(arr[diff], x);
	    } 
	    return -1;
	}

	private static int difference(int i, int j)
	{
	    return Math.abs(i-j);
	}

}
