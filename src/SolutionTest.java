import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;


public class SolutionTest {

	@Test
	public void test1() {
		String[] input={"acb","abc","bca"};
		String order="abc";
		String[] expect_output={"abc","acb","bca"};			
		String[] output = Solution.lexiSort(input,order); 
		
		assertEquals(Arrays.toString(output), Arrays.toString(expect_output));	
	}
	
	@Test
	public void test2() {
		String[] input={"acb","abc","bca"};
		String order="cba";
		String[] expect_output={"bca","acb","abc"};
		String[] output = Solution.lexiSort(input,order);
		assertEquals(Arrays.toString(output), Arrays.toString(expect_output));
	}
	
	@Test
	public void test3() { //string length is different
		String[] input={"aaa","aa",""};
		String order="a";
		String[] expect_output={"","aa","aaa"};
		String[] output = Solution.lexiSort(input,order);
		assertEquals(Arrays.toString(output), Arrays.toString(expect_output));
	}
	
	
	@Test
	public void test4() { //there is some duplicated strings
		String[] input={"abc","abc","bca","acb", "bca"};
		String order="cba";
		String[] expect_output={"bca","bca","acb","abc", "abc"};
		String[] output = Solution.lexiSort(input,order);
		assertEquals(Arrays.toString(output), Arrays.toString(expect_output));
	}
	


}
