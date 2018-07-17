import java.util.ArrayList;

public class permutations2 {
	public ArrayList<String> perms2 = new ArrayList<String>();
//	public static void main(String[] args) {
//		System.out.println(Math.E);
//	}
	public ArrayList<String> permute(int permLength) {
		if (permLength==0){
			perms2 = new ArrayList<String>();
			perms2.add("Provide a Length");
			return perms2;
		}
		String full = new String();
		for (int i = 1; i < permLength + 1; i ++){
			full = full + String.valueOf(i) + "";
		}
		permute("", full);
		return perms2;
	}
	
	public ArrayList<String> permute(String prefix, String remaining) {
		if (prefix.length() == 0){
			perms2 = new ArrayList<String>();
		}
		if (remaining.length() == 0) {
			perms2.add(prefix);
		}
		
		for (int i = 0; i < remaining.length(); i++) {
			permute(prefix + remaining.charAt(i), remaining.substring(0, i) + remaining.substring(i+1, remaining.length()));
		}
		return perms2;
	}
}
