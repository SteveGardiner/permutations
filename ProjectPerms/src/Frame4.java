import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class Frame4 {

	private JFrame frame;
	public static JTextField permsTextField;
	public static JTextArea permsTextArea;
	public static JTextArea subSeqTextArea;
	private JTextField subSeqText;
	private JTextField subSeqLength;
	private JTextField relAtext;
	private JTextField relBtext;
	private JTextField errorMessage1;
	
	relation relationList = new relation();
	
	subSeqList listOfOccs = new subSeqList();
	
	permutations2 listOfPerms = new permutations2();
	
	poset posetList = new poset();
	
	poset autoPosets = new poset();
	
	
	private JTextField enterPerm;
	private JTextField enterLength;
	private JTextField occurrencesText;
	private JTextField permLengthText;
	private JTextField occurrenceField;
	private JTextField posetLengthTF;
	private JTextField txtLength;
	private JTextField posLengthTF;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Frame4 window = new Frame4();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public Frame4() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 920, 835);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(84, 34, 192, 155);
		frame.getContentPane().add(scrollPane);
		
		JTextArea permsTextArea = new JTextArea();
		permsTextArea.setEditable(false);
		permsTextArea.setLineWrap(true);
		scrollPane.setViewportView(permsTextArea);
		
		permsTextField = new JTextField();
		permsTextField.setBounds(84, 200, 192, 20);
		frame.getContentPane().add(permsTextField);
		permsTextField.setColumns(10);
		
		JButton btnPerms = new JButton("Perms");
		btnPerms.setBounds(137, 227, 89, 23);
		btnPerms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				permsTextArea.setText("");
				ArrayList<String> perms = new ArrayList<String>();
				perms = permutations.permute(permsTextField.getText());
				for (int i = 0; i < perms.size(); i++) {
					permsTextArea.append(perms.get(i) + "\n");
				}
			}
		});
		frame.getContentPane().add(btnPerms);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(377, 34, 192, 155);
		frame.getContentPane().add(scrollPane_1);
		
		JTextArea subSeqTextArea = new JTextArea();
		subSeqTextArea.setEditable(false);
		subSeqTextArea.setLineWrap(true);
		scrollPane_1.setViewportView(subSeqTextArea);
		
		subSeqText = new JTextField();
		subSeqText.setBounds(377, 200, 97, 20);
		frame.getContentPane().add(subSeqText);
		subSeqText.setColumns(10);
		
		subSeqLength = new JTextField();
		subSeqLength.setBounds(511, 200, 59, 20);
		frame.getContentPane().add(subSeqLength);
		subSeqLength.setColumns(10);
		
		JButton btnSubseqs = new JButton("subSeqs");
		btnSubseqs.setBounds(429, 227, 89, 23);
		btnSubseqs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				subSeqTextArea.setText("");
				ArrayList<String> subSeqs = new ArrayList<String>();
				if (subSeqLength.getText().length() == 0){
					subSeqTextArea.setText("Provide a Length");
				}
				else {
					subSeqs = subSequences.makeSubSeqs(subSeqText.getText(), Integer.parseInt(subSeqLength.getText()));
					for (int i = 0; i < subSeqs.size(); i++) {
						subSeqTextArea.append(subSeqs.get(i) + "\n");
					}
				}
			}
		});
		frame.getContentPane().add(btnSubseqs);
		
		relAtext = new JTextField();
		relAtext.setBounds(604, 37, 41, 30);
		frame.getContentPane().add(relAtext);
		relAtext.setColumns(10);
		
		relBtext = new JTextField();
		relBtext.setBounds(687, 37, 41, 30);
		frame.getContentPane().add(relBtext);
		relBtext.setColumns(10);
		
		JLabel label = new JLabel(">");
		label.setFont(new Font("Tahoma", Font.PLAIN, 26));
		label.setBounds(655, 40, 26, 27);
		frame.getContentPane().add(label);
		
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(604, 111, 118, 90);
		frame.getContentPane().add(scrollPane_2);
		
		JTextArea relationsTextArea = new JTextArea();
		scrollPane_2.setViewportView(relationsTextArea);
		
		errorMessage1 = new JTextField();
		errorMessage1.setEditable(false);
		errorMessage1.setBounds(687, 78, 99, 20);
		frame.getContentPane().add(errorMessage1);
		errorMessage1.setColumns(10);
		
		JButton btnAddRelation = new JButton("Add");
		btnAddRelation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				errorMessage1.setText("");
//				relation relationList = new relation();
				if (relAtext.getText().length() == 0 || relBtext.getText().length() == 0){// >>>>>>>DONT NEED THIS NEXT BIT AS WILL BE CLICKING ELEMENTS INTO FIELD, not typing>>>> || relAtext.getText() == " " || relBtext.getText() == " "){
					System.out.println(relBtext.getText());
					errorMessage1.setText("Insert Element");
				}
				else if (relAtext.getText().equals(relBtext.getText())) {
					errorMessage1.setText("Unable to Add");
				}
				else if (relationsTextArea.getText().length() == 0) {
					relationList.addRelation(null, relAtext.getText(), relBtext.getText());
					System.out.println(relationList.relations);
					//relationsTextArea.append(relAtext.getText() + ">" + relBtext.getText() + "\n");
				}
				else if (relationsTextArea.getText().length() > 0) {
					relationList.addRelation(relationList.relations, relAtext.getText(), relBtext.getText());
					System.out.println(relationList.relations);
				}
				relationsTextArea.setText("");
				for (int i = 0; i < relationList.relations.size(); i++) {
					relationsTextArea.append(relationList.relations.get(i).get(0) + " > " + relationList.relations.get(i).get(1) + "\n");
				}
			}
		});
		btnAddRelation.setBounds(604, 79, 77, 23);
		frame.getContentPane().add(btnAddRelation);
		
		JButton btnClearRelations = new JButton("Clear Relations");
		btnClearRelations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				relationList = new relation();
				relationsTextArea.setText("");
			}
		});
		btnClearRelations.setBounds(604, 212, 124, 23);
		frame.getContentPane().add(btnClearRelations);
		
		enterPerm = new JTextField();
		enterPerm.setBounds(171, 268, 124, 30);
		frame.getContentPane().add(enterPerm);
		enterPerm.setColumns(10);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(26, 270, 124, 155);
		frame.getContentPane().add(scrollPane_3);
		
		JTextArea subsListTextArea = new JTextArea();
		subsListTextArea.setEditable(false);
		subsListTextArea.setLineWrap(true);
		scrollPane_3.setViewportView(subsListTextArea);
		
		enterLength = new JTextField();
		enterLength.setBounds(190, 320, 86, 30);
		frame.getContentPane().add(enterLength);
		enterLength.setColumns(10);
		
		
		occurrencesText = new JTextField();
		occurrencesText.setEditable(false);
		occurrencesText.setBounds(51, 436, 77, 20);
		frame.getContentPane().add(occurrencesText);
		occurrencesText.setColumns(10);
		
		
		JButton btnSubSeqsList = new JButton("SubSeqsList");
		btnSubSeqsList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subsListTextArea.setText("");
				listOfOccs.makeSubsList(enterPerm.getText(), Integer.parseInt(enterLength.getText()), relationList.relations);
				System.out.println(listOfOccs.subsList);
				for (int i = 0; i < listOfOccs.subsList.size(); i++) {
					subsListTextArea.append(listOfOccs.subsList.get(i) + "\n");
				}
				occurrencesText.setText(String.valueOf(listOfOccs.subsList.size()));
			}
		});
		btnSubSeqsList.setBounds(171, 379, 140, 23);
		frame.getContentPane().add(btnSubSeqsList);
		
		
		JLabel lblNumberOfOccurrences = new JLabel("Number of Occurrences");
		lblNumberOfOccurrences.setBounds(26, 467, 124, 14);
		frame.getContentPane().add(lblNumberOfOccurrences);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(377, 268, 250, 155);
		frame.getContentPane().add(scrollPane_4);
		
		JTextArea numOfOccsTA = new JTextArea();
		numOfOccsTA.setLineWrap(true);
		numOfOccsTA.setEditable(false);
		scrollPane_4.setViewportView(numOfOccsTA);
		
		permLengthText = new JTextField();
		permLengthText.setBounds(642, 273, 86, 20);
		frame.getContentPane().add(permLengthText);
		permLengthText.setColumns(10);
		
		JButton btnCountOccs = new JButton("Count Occs");
		btnCountOccs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
// MIGHT NEED TO CLEAR LIST OF PERMS OR WHATEVER AT THE START OF EVERY THINGIE
				numOfOccsTA.setText("");
				int permLength = Integer.parseInt(permLengthText.getText());
				int posetLength = Integer.parseInt(enterLength.getText());
				double arraySize = Math.pow(Math.ceil((permLength * 2.72) / posetLength), posetLength);
				arraySize = Math.ceil(arraySize);
				System.out.println(Integer.parseInt(permLengthText.getText()));
				System.out.println(Integer.parseInt(enterLength.getText()));
				System.out.println(arraySize);
//				ArrayList distributionList = new ArrayList(arraySize);
//				ArrayList<Integer> distributionList = new ArrayList<Integer>(Collections.nCopies(60, 0));
				Integer[] distributionList = Collections.nCopies((int) arraySize, 0).toArray(new Integer[0]);
				Integer[] distribution = new Integer[0];
				ArrayList<ArrayList<String>> listPermsAndOccs = new ArrayList<ArrayList<String>>();
				listOfPerms.permute(Integer.parseInt(permLengthText.getText()));
				for (int i = 0; i < listOfPerms.perms2.size(); i++){
					listOfOccs = new subSeqList();
					String placeholder = listOfPerms.perms2.get(i);
					ArrayList<String> permAndOccs = new ArrayList<String>();
					listOfOccs.makeSubsList(placeholder, Integer.parseInt(enterLength.getText()), relationList.relations);
//					Might not need to keep this permsAndOccs arraylist, but will keep for now.... could possibly get rid of "permAndOcc" and stuff...??
					permAndOccs.add(placeholder);
					permAndOccs.add(String.valueOf(listOfOccs.subsList.size()));
					listPermsAndOccs.add(permAndOccs);
					numOfOccsTA.append("perm:  " + placeholder + " , Num of Occs: " + String.valueOf(listOfOccs.subsList.size()) + "\n");
					distributionList[listOfOccs.subsList.size()]++;
				}
				for (int i = distributionList.length - 1; i >= 0; i--) {
					if (distributionList[i] == 0) {
						continue;
					}
					else{
						distribution = Arrays.copyOfRange(distributionList, 0, i+1);
						break;
					}
				}
				occurrenceField.setText("Distribution: " + Arrays.toString(distribution));
				
				
			}
		});
		btnCountOccs.setBounds(649, 379, 89, 23);
		frame.getContentPane().add(btnCountOccs);
		
		occurrenceField = new JTextField();
		occurrenceField.setBounds(377, 464, 250, 30);
		frame.getContentPane().add(occurrenceField);
		occurrenceField.setColumns(10);
		
		posetLengthTF = new JTextField();
		posetLengthTF.setBounds(835, 37, 59, 30);
		frame.getContentPane().add(posetLengthTF);
		posetLengthTF.setColumns(10);
		
		txtLength = new JTextField();
		txtLength.setText(" Length:");
		txtLength.setEditable(false);
		txtLength.setBounds(778, 37, 47, 30);
		frame.getContentPane().add(txtLength);
		txtLength.setColumns(10);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(40, 522, 279, 183);
		frame.getContentPane().add(scrollPane_5);
		
		JTextArea posetsListTA = new JTextArea();
		scrollPane_5.setViewportView(posetsListTA);
		
		
		JButton btnAddPoset = new JButton("Add Poset");
		btnAddPoset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (relationsTextArea.getText().length() == 0){
					errorMessage1.setText("Insert Relation");
				}
				//SHOULD MAYBE HAVE A THING ABOUT CHECKING FOR REPETITIONS IN THE POSETS MAYBE
//				else if (relAtext.getText().equals(relBtext.getText())) {
//					errorMessage1.setText("Unable to Add");
//				}
				else if (posetsListTA.getText().length() == 0) {
					posetList.addPoset(null, posetLengthTF.getText(), relationList.relations);
					System.out.println(posetList.posets);
					//relationsTextArea.append(relAtext.getText() + ">" + relBtext.getText() + "\n");
				}
				else if (posetsListTA.getText().length() > 0) {
					posetList.addPoset(posetList.posets, posetLengthTF.getText(), relationList.relations);
					System.out.println(posetList.posets);
				}
				
				posetsListTA.setText("");
				for (int i = 0; i < posetList.posets.size(); i++) {
					posetsListTA.append(posetList.posets.get(i) + "\n");
				}
				relationList = new relation();
				relationsTextArea.setText("");
			}
		});
		btnAddPoset.setBounds(754, 113, 110, 23);
		frame.getContentPane().add(btnAddPoset);
		
		JButton btnClearPosets = new JButton("Clear Posets");
		btnClearPosets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				posetList = new poset();
				posetsListTA.setText("");
			}
		});
		btnClearPosets.setBounds(116, 727, 110, 23);
		frame.getContentPane().add(btnClearPosets);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(377, 522, 400, 183);
		frame.getContentPane().add(scrollPane_6);
		
		JTextArea allRelsTA = new JTextArea();
		scrollPane_6.setViewportView(allRelsTA);
		
		posLengthTF = new JTextField();
		posLengthTF.setBounds(377, 728, 86, 20);
		frame.getContentPane().add(posLengthTF);
		posLengthTF.setColumns(10);
		
		JButton btnGenRels = new JButton("Go");
		btnGenRels.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<ArrayList<String>> binSigList = new ArrayList<ArrayList<String>>();
				autoPosets = new poset();
				posetsListTA.setText("");
				String listOfNums1 = new String();
				for (int i = 1; i < Integer.parseInt(posLengthTF.getText()) + 1; i ++){
					listOfNums1 = listOfNums1 + String.valueOf(i) + "";
				}
				String listOfNums2 = new String();
				for (int i = Integer.parseInt(posLengthTF.getText()); i > 0 ; i--){
					listOfNums2 = listOfNums2 + String.valueOf(i) + "";
				}
				ArrayList<String> orderedPairs = subSequences.makeSubSeqs(listOfNums1, 2);
				ArrayList<String> orderedPairs2 = subSequences.makeSubSeqs(listOfNums2, 2);
				orderedPairs.addAll(orderedPairs2);
				
				Integer pairsListSize = orderedPairs.size();
				
				
				
				ArrayList<ArrayList<ArrayList<String>>> allRelCombos = new ArrayList<ArrayList<ArrayList<String>>>();
				
				

				ArrayList<ArrayList<String>> temp = subSeqArrays.makeSubSeqs(orderedPairs, 1);
				allRelCombos.add(temp);
				ArrayList<ArrayList<String>> coreRelations = allRelCombos.get(0);
//				System.out.println(coreRelations);
				
				
				
//				for (int i = 0; i < pairsListSize / 2 + 1; i++){
//					ArrayList<ArrayList<String>> temp = subSeqArrays.makeSubSeqs(orderedPairs, i);
//					allRelCombos.add(temp);
//				}
				
				// The next line is for checking theory about L1 > L2 jump:
				for (int i = 0; i < 6 + 1; i++){
					allRelCombos = new ArrayList<ArrayList<ArrayList<String>>>();
					ArrayList<ArrayList<String>> temp2 = subSeqArrays.makeSubSeqs(orderedPairs, i);
					allRelCombos.add(temp2);
					String separator = "--------L" + i + "---------";
					Integer counter = 0;
					ArrayList<String> sepLine = new ArrayList<String>();
					sepLine.add(separator);
					binSigList.add(sepLine);
//					System.out.println(allRelCombos + "THIS IS ALL REL COMBOS");
					for (int j = 0; j < allRelCombos.get(0).size(); j++){
						relation autoRels = new relation();
						for (int k = 0; k < allRelCombos.get(0).get(j).size(); k++){
							autoRels.addRelation(autoRels.relations, allRelCombos.get(0).get(j).get(k).substring(0,1), allRelCombos.get(0).get(j).get(k).substring(1,2));
						}
						binarySig newBinSig = new binarySig();
						newBinSig.makeBinSig(coreRelations, autoRels.relations);
						if (binSigList.contains(newBinSig.binSig)){
							continue;
						}
						else {
							autoPosets.addPoset(autoPosets.posets, posLengthTF.getText(), autoRels.relations);
							binSigList.add(newBinSig.binSig);
							counter += 1;
						}
//					System.out.println(temp2);
//					System.out.println(allRelCombos);
					}
				
				//System.out.println("HERE    " + allRelCombos.get(1));
//				Integer numOfCoreRels = coreRelations.size();
				//ArrayList<ArrayList<ArrayList<ArrayList<String>>>> trivialPoset = new ArrayList<ArrayList<ArrayList<ArrayList<String>>>>();
				//ArrayList<ArrayList<String>> emptyRels = new ArrayList<ArrayList<String>>();
//				autoPosets.addPoset(null, posLengthTF.getText(), null);
//				int[] zeroSig = new int[];
//				
//				for (int i = 0; i < numOfCoreRels; i++){
//					zeroSig[i] = 0;
//				}
//				binSigList.add(zeroSig);
//				System.out.println(zeroSig);
//				for (int i = 1; i < allRelCombos.size(); i++){
//					String separator = "--------L" + (i-1) + "---------";
//					Integer counter = 0;
//					ArrayList<String> sepLine = new ArrayList<String>();
//					sepLine.add(separator);
//					binSigList.add(sepLine);
//					for (int j = 0; j < allRelCombos.get(i).size(); j++){
//						relation autoRels = new relation();
//						for (int k = 0; k < allRelCombos.get(i).get(j).size(); k++){
//							autoRels.addRelation(autoRels.relations, allRelCombos.get(i).get(j).get(k).substring(0,1), allRelCombos.get(i).get(j).get(k).substring(1,2));
//						}
//						binarySig newBinSig = new binarySig();
//						newBinSig.makeBinSig(coreRelations, autoRels.relations);
//						if (binSigList.contains(newBinSig.binSig)){
//							continue;
//						}
//						else {
//							autoPosets.addPoset(autoPosets.posets, posLengthTF.getText(), autoRels.relations);
//							binSigList.add(newBinSig.binSig);
//							counter += 1;
//						}
//					}
					ArrayList<String> count = new ArrayList<String>();
					count.add("The count for the above is --->   " + counter.toString());
					binSigList.add(count);
				}
				for (int i = 0; i < autoPosets.posets.size(); i++){
					posetsListTA.append(autoPosets.posets.get(i) + "\n");
				}
				allRelsTA.setText("");
				for (int i = 0; i < binSigList.size(); i++){
					allRelsTA.append(binSigList.get(i) + "\n");
				}
				//System.out.println(binSigList);
			}
		});
		btnGenRels.setBounds(480, 727, 59, 23);
		frame.getContentPane().add(btnGenRels);
		
		
		
		
		

		
		
//		subSeqLength = new JTextField();
//		subSeqLength.setBounds(511, 200, 59, 20);
//		frame.getContentPane().add(subSeqLength);
//		subSeqLength.setColumns(10);
	}
}
