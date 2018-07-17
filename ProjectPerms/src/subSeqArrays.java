import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subSeqArrays {
	public static ArrayList<ArrayList<String>> subSeqs = new ArrayList<ArrayList<String>>();
//	public static void main(String[] args) {
//		
//		ArrayList<String> pairs = new ArrayList<String>();
//		pairs.add("12");
//		pairs.add("23");
//		pairs.add("13");
//		pairs.add("21");
//		pairs.add("31");
//		pairs.add("32");
////		System.out.println(pairs);
//		int[] egg1 = new int [] {1, 1, 0, 1};
//		int[] egg2 = new int [] {1, 1, 0, 1};
//		System.out.println(Arrays.toString(egg2));
//	}
	
	public static ArrayList<ArrayList<String>> makeSubSeqs(ArrayList<String> full, int n) {
		if (full == null || full.size()==0){
			ArrayList<String> nest = new ArrayList<String>();
			nest.add("Provide a String");
			subSeqs.add(nest);
			return subSeqs;
		}
		makeSubSeqs(new ArrayList<String>(), full, n);
		return subSeqs;
	}
	
	private static ArrayList<ArrayList<String>> makeSubSeqs(ArrayList<String> prefix, List<String> remaining, int n) {
//		System.out.println(prefix + "    " + remaining  + "    this one" + "  , n is  " + n);
		if (prefix.size() == 0){
			subSeqs = new ArrayList<ArrayList<String>>();
		}
		if (n == 0) {
			subSeqs.add(prefix);
//			System.out.println(subSeqs + "     hereare ae");
			return subSeqs;
		}
		
		for (int i = 0; i < remaining.size(); i++) {
//			System.out.println(prefix + "   " + remaining + "  i is  " + i);
//			System.out.println(remaining.subList(i+1, remaining.size()) + "      HERE IS REMAINING");
			ArrayList<String> temp = new ArrayList<String>();
			temp.addAll(prefix);
			temp.add(remaining.get(i));
			makeSubSeqs(temp, remaining.subList(i+1, remaining.size()), n-1);
		}
		return subSeqs;
	}

}


