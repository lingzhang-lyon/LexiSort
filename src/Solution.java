import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;



public class Solution {
	
		
	public static void main(String[] args){
		String[] input1={"acb","abc","bca"};
		String order1="abc";
		String[] expect_output1={"abc","acb","bca"};
		
		String[] input2={"acb","abc","bca"};
		String order2="cba";
		String[] expect_output2={"bca","acb","abc"};
		
		String[] input3={"aaa","aa",""};
		String order3="a";
		String[] expect_output3={"","aa","aaa"};
				
		String[] output1 = lexiSort(input1,order1); 
		String[] output2 = lexiSort(input2,order2);
		String[] output3 = lexiSort(input3,order3);
		
		System.out.println("input is: "+ Arrays.toString(input1));	
		System.out.println("expected output is: "+ Arrays.toString(expect_output1));
		System.out.println("actual sort result is: " + Arrays.toString(output1));
		
		System.out.println("\ninput is: "+ Arrays.toString(input2));	
		System.out.println("expected output is: "+ Arrays.toString(expect_output2));
		System.out.println("actual sort result is: " + Arrays.toString(output2));
		
		System.out.println("\ninput is: "+ Arrays.toString(input3));	
		System.out.println("expected output is: "+ Arrays.toString(expect_output3));
		System.out.println("actual sort result is: " + Arrays.toString(output3));
		
	}
	

	
	
	public static String[] lexiSort(String[] input, String order){
		String[] output = Arrays.copyOf(input, input.length);
		HashMap<Character, Integer> orderMap=new HashMap<Character, Integer>();
		
		for(int i=0; i<order.length(); i++){
			orderMap.put(order.charAt(i), i);
		}
		
		Arrays.sort(output, new ArbitraryComparator(orderMap) );
				
		return output;
	}
	
	 private static class ArbitraryComparator implements Comparator<String>{
		
		 private HashMap<Character, Integer> orderMap;
		 
		 public ArbitraryComparator(HashMap<Character, Integer> inputOrderMap){
			this.orderMap=inputOrderMap; 
		 }
		
		 
	   public int compare(String s1, String s2)
	   {
	       
		   int i=0; 
		   int j=0;
		   while(i<s1.length() && j<s2.length()){
			   
			   if( orderMap.get(s1.charAt(i)) > orderMap.get(s2.charAt(j))  ){
				   return 1;
			   }
			   if( orderMap.get(s1.charAt(i)) < orderMap.get(s2.charAt(j))  ){
				   return -1;
			   }
			   else{ //the characters are same, move forward
				   i++;
				   j++;
			   }			   
		   }
		   if(i>=s1.length()&&j>=s2.length()){ //both reached the end
			   return 0;
		   }
		   else if(i>=s1.length()){ //s1 reached the end, but s2 not
			   return -1;			   
		   }
		   else{ //s2 reached the end, but s1 not
			   return 1;
		   }
	   }
	 }
}
