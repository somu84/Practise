package src.com.ctc.c9;
/**
 * If you have a 2 GB file with one string per line, which sorting algorithm would you use to sort the file and why?
 * @author Somu
 *
 */
public class q4 {

	/**
	 * When an interviewer gives a size limit of 2GB, it should tell you something - in this case, it suggests that they don’t want you to bring all the data into memory.
		So what do we do? We only bring part of the data into memory..
		Algorithm:
		How much memory do we have available? Let’s assume we have X MB of memory available.
		1. Divide the file into K chunks, where X * K = 2 GB. Bring each chunk into memory and sort the lines as usual using any O(n log n) algorithm. Save the lines back to the file.
		2. Now bring the next chunk into memory and sort.
		3. Once we’re done, merge them one by one.
		The above algorithm is also known as external sort. Step 3 is known as N-way merge
		The rationale behind using external sort is the size of data. Since the data is too huge and we can’t bring it all into memory, we need to go for a disk based sorting algorithm.
	 */
}
