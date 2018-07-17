import java.util.ArrayList;

public class subSequences {
	public static ArrayList<String> subSeqs = new ArrayList<String>();
//	public static void main(String[] args) {
//		System.out.println(makeSubSeqs("123",2));
//	}
	
	public static ArrayList<String> makeSubSeqs(String full, int n) {
		if (full == null || full.length()==0){
			subSeqs.add("Provide a String");
			return subSeqs;
		}
		makeSubSeqs("", full, n);
		return subSeqs;
	}
	
	private static ArrayList<String> makeSubSeqs(String prefix, String remaining, int n) {
//		System.out.println(n);
		if (prefix.length() == 0){
			subSeqs = new ArrayList<String>();
		}
		if (n == 0) {
			subSeqs.add(prefix);
			return subSeqs;
		}
//		if (remaining.length() == n) {
//			subSeqs.add(prefix + remaining);
//		}
//		
//		if (remaining.length() == 0) {
//			subSeqs.add(prefix);
//		}
		
		for (int i = 0; i < remaining.length(); i++) {
//			System.out.println(prefix + "     " + remaining);
			makeSubSeqs(prefix + remaining.charAt(i), remaining.substring(i+1, remaining.length()), n-1);
		}
		return subSeqs;
	}

}


