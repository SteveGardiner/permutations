import java.util.ArrayList;

public class binarySig {
	public ArrayList<String> binSig = new ArrayList<String>();
//	public static void main(String[] args) {
//		ArrayList<String> newRelation = new ArrayList<String>();
//		newRelation.add("a");
//		newRelation.add("b");
//		ArrayList<String> new2 = new ArrayList<String>();
//		new2.add("c");
//		new2.add("b");
//		
//		relations = new ArrayList<ArrayList<String>>();
//		relations.add(newRelation);
//		relations.add(new2);
//		System.out.println(relations);
//		System.out.println(addRelation(relations,"c","a"));
//	}
	public ArrayList<String> makeBinSig(ArrayList<ArrayList<String>> coreRelations, ArrayList<ArrayList<String>> newPosetRels) {
//		System.out.println("CORE RELS -   " + coreRelations + "\n" + "and newPosetRels   -   " + newPosetRels);
		if (newPosetRels.size() > 0 && newPosetRels.get(0).size() < 2){
			for (int i = 0; i < coreRelations.size(); i++){
				if (newPosetRels.contains(coreRelations.get(i))){
					binSig.add("1");
				}
				else{
					binSig.add("0");
				}
			}
		}
		else {
			for (int i = 0; i < coreRelations.size(); i++){
				ArrayList<String> coreRelCheck = new ArrayList<String>();
				//System.out.println(coreRelCheck + "  <<< This is the checker");
				//System.out.println(coreRelations.get(i).get(0).charAt(0));
				coreRelCheck.add(coreRelations.get(i).get(0).substring(0,1));
				coreRelCheck.add(coreRelations.get(i).get(0).substring(1,2));
				//System.out.println(coreRelCheck + "  <<< This is the checker");
				if (newPosetRels.contains(coreRelCheck)){
					binSig.add("1");
				}
				else{
					binSig.add("0");
				}
			}
		}
		return binSig;
	}	
}
