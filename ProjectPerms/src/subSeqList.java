import java.util.ArrayList;

public class subSeqList {
	public ArrayList<String> subsList = new ArrayList<String>();
//	public static void main(String[] args) {
//		ArrayList<String> newRelation = new ArrayList<String>();
//		newRelation.add("2");
//		newRelation.add("3");
////		ArrayList<String> new2 = new ArrayList<String>();
////		new2.add("3");
////		new2.add("2");
//
//		ArrayList<ArrayList<String>> relationees = new ArrayList<ArrayList<String>>();
//		relationees.add(newRelation);
////		relationees.add(new2);
////		System.out.println(relationees);
//		System.out.println(makeSubsList("4321", 3, relationees));
//		//System.out.println(subsList);
//	}
	
	public ArrayList<String> makeSubsList(String permutation, Integer length, ArrayList<ArrayList<String>> relations) {
//		if (permutation == null || permutation.length()==0){
//			
//		}
		
//		Probably won't need safety measures here, since the warnings can be dealt with in Frame4 class?
		
		
		subsList = subSequences.makeSubSeqs(permutation, length);
//		System.out.println(subsList);
		for (int j = 0; j < relations.size(); j++) {
//			System.out.println(relations.get(j) + " is our relation");
//			System.out.println("j is " + j);
			for (int i = 0; i < subsList.size(); i++) {
//				System.out.println(subsList.get(i) + " is up as a contender");
//				System.out.println("i is starting as " + i);
//				System.out.println(" THE SIZE IS " + subsList.size());
				if (subsList.get(i).length() == 0) {
					return subsList;
				}
				if (subsList.get(i).charAt(Integer.parseInt(relations.get(j).get(0))-1) < subsList.get(i).charAt(Integer.parseInt(relations.get(j).get(1))-1)) {
//					System.out.println("Is " + subsList.get(i).charAt(Integer.parseInt(relations.get(j).get(0))-1) + " < " + subsList.get(i).charAt(Integer.parseInt(relations.get(j).get(1))-1) + "?");
//					
//					System.out.println("just deleted " + subsList.get(i));
//					System.out.println("i is " + i);
					subsList.remove(subsList.get(i));
					
					i = i - 1;
//					System.out.println("i is finishing as " + i);
				}
			}
		}
		
		
		
//		ArrayList<String> subseqs = subSequences.makeSubSeqs(permutation, length);
//		System.out.println(subseqs);
//		for (int i = 0; i < subseqs.size(); i++) {
//			for (int j = 0; j < relations.size(); j++) {
//				if (subseqs.get(i).charAt(Integer.parseInt(relations.get(j).get(0))-1) < subseqs.get(i).charAt(Integer.parseInt(relations.get(j).get(1))-1)) {
//					subsList.add(subseqs.get(i));
//				}
//			}
//		}
		return subsList;
	}
}
