package src.com.prac;

public class AmazonTechInterview {

	public static void main(String[] args) {
		int[] arr = {};
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
	    //This is why I was rejected by Amazon. I forgot the null check.
		if(arr == null || arr.length < 1)
		{
			System.out.println("Array is empty");
			return -1;
		}
		//Always remember to have null and empty checks.
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
