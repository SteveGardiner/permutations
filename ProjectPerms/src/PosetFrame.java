import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.jsoup.Jsoup;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Desktop;

public class PosetFrame {

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
	
	ArrayList<ArrayList<String>> binSigList = new ArrayList<ArrayList<String>>();
	
	
	private JTextField enterPerm;
	private JTextField enterLength;
	private JTextField occurrencesText;
	private JTextField permLengthText;
	private JTextField occurrenceField;
	private JTextField posLengthTF;
	private JTextField lowerBoundTF;
	private JTextField upperBoundTF;
	private JTextField oeisTF;
	private JTextField posetExampleTF;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PosetFrame window = new PosetFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PosetFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
//		DefaultListModel<ArrayList<ArrayList<String>>> relationsModel = new DefaultListModel<>();
//		JList<ArrayList<ArrayList<String>>> relStringList = new JList<>(relationsModel);
//		relStringList.setBounds(51, 37, 191, 155);
//		frame.getContentPane().add(relStringList);
		

		DefaultListModel<String> relationsModel = new DefaultListModel<>();
		JList<String> relStringList = new JList<>(relationsModel);
		relStringList.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		//JList<ArrayList<ArrayList<String>>> relStringList = new JList<ArrayList<ArrayList<String>>>(relationList.relations);
//		relationsModel.addElement(relationList.relations);
//		relStringList.setBounds(26, 102, 188, 183);
//		frame.getContentPane().add(relStringList);
		
		DefaultListModel<String> posetsModel = new DefaultListModel<>();
		JList<String> posetStringList = new JList<>(posetsModel);
		posetStringList.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
		JScrollPane posetScrollPane = new JScrollPane();
		posetScrollPane.setBounds(50, 235, 279, 183);
		frame.getContentPane().add(posetScrollPane);
		
		
		
		
		
		posetStringList.setBounds(100, 235, 279, 183);
//		frame.getContentPane().add(relStringList);
		
		posetScrollPane.setViewportView(posetStringList);
		
		
		JButton btn1 = new JButton("1");
		btn1.setBackground(new Color(135, 206, 250));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (relAtext.getText().length() == 0){
					relAtext.setText("1");
				}
				else if(relBtext.getText().length() == 0){
					relBtext.setText("1");
				}
				else {
					errorMessage1.setText("clear space");
				}
			}
		});
		btn1.setBounds(10, 100, 41, 30);
		btn1.setVisible(false);
		frame.getContentPane().add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.setBackground(new Color(135, 206, 250));
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (relAtext.getText().length() == 0){
					relAtext.setText("2");
				}
				else if(relBtext.getText().length() == 0){
					relBtext.setText("2");
				}
				else {
					errorMessage1.setText("clear space");
				}
			}
		});
		btn2.setBounds(61, 100, 41, 30);
		btn2.setVisible(false);
		frame.getContentPane().add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.setBackground(new Color(135, 206, 250));
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (relAtext.getText().length() == 0){
					relAtext.setText("3");
				}
				else if(relBtext.getText().length() == 0){
					relBtext.setText("3");
				}
				else {
					errorMessage1.setText("clear space");
				}
			}
		});
		btn3.setBounds(110, 100, 41, 30);
		btn3.setVisible(false);
		frame.getContentPane().add(btn3);
		
		JButton btn4 = new JButton("4");
		btn4.setBackground(new Color(135, 206, 250));
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (relAtext.getText().length() == 0){
					relAtext.setText("4");
				}
				else if(relBtext.getText().length() == 0){
					relBtext.setText("4");
				}
				else {
					errorMessage1.setText("clear space");
				}
			}
		});
		btn4.setBounds(161, 100, 41, 30);
		btn4.setVisible(false);
		frame.getContentPane().add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.setBackground(new Color(135, 206, 250));
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (relAtext.getText().length() == 0){
					relAtext.setText("5");
				}
				else if(relBtext.getText().length() == 0){
					relBtext.setText("5");
				}
				else {
					errorMessage1.setText("clear space");
				}
			}
		});
		btn5.setBounds(212, 100, 41, 30);
		btn5.setVisible(false);
		frame.getContentPane().add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.setBackground(new Color(135, 206, 250));
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (relAtext.getText().length() == 0){
					relAtext.setText("6");
				}
				else if(relBtext.getText().length() == 0){
					relBtext.setText("6");
				}
				else {
					errorMessage1.setText("clear space");
				}
			}
		});
		btn6.setBounds(36, 140, 41, 30);
		btn6.setVisible(false);
		frame.getContentPane().add(btn6);
		
		JButton btn7 = new JButton("7");
		btn7.setBackground(new Color(135, 206, 250));
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (relAtext.getText().length() == 0){
					relAtext.setText("7");
				}
				else if(relBtext.getText().length() == 0){
					relBtext.setText("7");
				}
				else {
					errorMessage1.setText("clear space");
				}
			}
		});
		btn7.setBounds(87, 140, 41, 30);
		btn7.setVisible(false);
		frame.getContentPane().add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.setBackground(new Color(135, 206, 250));
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (relAtext.getText().length() == 0){
					relAtext.setText("8");
				}
				else if(relBtext.getText().length() == 0){
					relBtext.setText("8");
				}
				else {
					errorMessage1.setText("clear space");
				}
			}
		});
		btn8.setBounds(137, 140, 41, 30);
		btn8.setVisible(false);
		frame.getContentPane().add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.setBackground(new Color(135, 206, 250));
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (relAtext.getText().length() == 0){
					relAtext.setText("9");
				}
				else if(relBtext.getText().length() == 0){
					relBtext.setText("9");
				}
				else {
					errorMessage1.setText("clear space");
				}
			}
		});
		btn9.setBounds(190, 140, 41, 30);
		btn9.setVisible(false);
		frame.getContentPane().add(btn9);
		
		
		
		JComboBox posetLengthSelect = new JComboBox();
		posetLengthSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				posetExampleTF.setText("");
				relationsModel.clear();
				
				btn9.setVisible(false);
				btn8.setVisible(false);
				btn7.setVisible(false);
				btn6.setVisible(false);
				btn5.setVisible(false);
				btn4.setVisible(false);
				btn3.setVisible(false);
				btn2.setVisible(false);
				btn1.setVisible(false);
				if (Integer.parseInt(String.valueOf(posetLengthSelect.getSelectedItem())) == 0){
					errorMessage1.setText("Provide a length");
					
				}
				
				else {
					String numberString = new String();
					for (int i = 0; i < Integer.parseInt(String.valueOf(posetLengthSelect.getSelectedItem())); i++){
//						String btn = new String();
//						btn = "btn" + (i+1);
//						btn.setVisible(true);
						numberString = numberString + (i+1);
					}
					if (Integer.parseInt(String.valueOf(posetLengthSelect.getSelectedItem())) > 8){
						btn9.setVisible(true);
					}
					if (Integer.parseInt(String.valueOf(posetLengthSelect.getSelectedItem())) > 7){
						btn8.setVisible(true);
					}
					if (Integer.parseInt(String.valueOf(posetLengthSelect.getSelectedItem())) > 6){
						btn7.setVisible(true);
					}
					if (Integer.parseInt(String.valueOf(posetLengthSelect.getSelectedItem())) > 5){
						btn6.setVisible(true);
					}
					if (Integer.parseInt(String.valueOf(posetLengthSelect.getSelectedItem())) > 4){
						btn5.setVisible(true);
					}
					if (Integer.parseInt(String.valueOf(posetLengthSelect.getSelectedItem())) > 3){
						btn4.setVisible(true);
					}
					if (Integer.parseInt(String.valueOf(posetLengthSelect.getSelectedItem())) > 2){
						btn3.setVisible(true);
					}
					if (Integer.parseInt(String.valueOf(posetLengthSelect.getSelectedItem())) > 1){
						btn2.setVisible(true);
					}
					if (Integer.parseInt(String.valueOf(posetLengthSelect.getSelectedItem())) > 0){
						btn1.setVisible(true);
					}
					posetExampleTF.setText(numberString);
				}
				
			}
		});
		posetLengthSelect.setMaximumRowCount(9);
		posetLengthSelect.setFont(new Font("Tahoma", Font.PLAIN, 28));
		posetLengthSelect.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		posetLengthSelect.setBounds(82, 11, 120, 43);
		frame.getContentPane().add(posetLengthSelect);
		
		
		JScrollPane relScrollPane = new JScrollPane();
		relScrollPane.setBounds(455, 80, 100, 155);
		frame.getContentPane().add(relScrollPane);
		
		
		relStringList.setBounds(455, 80, 100, 155);
//		frame.getContentPane().add(relStringList);
		
		relScrollPane.setViewportView(relStringList);
		
		
		relAtext = new JTextField();
		relAtext.setFont(new Font("Tahoma", Font.BOLD, 34));
		relAtext.setEditable(false);
		relAtext.setBounds(296, 65, 51, 45);
		frame.getContentPane().add(relAtext);
		relAtext.setColumns(10);
		
		relBtext = new JTextField();
		relBtext.setFont(new Font("Tahoma", Font.BOLD, 34));
		relBtext.setEditable(false);
		relBtext.setBounds(399, 65, 46, 45);
		frame.getContentPane().add(relBtext);
		relBtext.setColumns(10);
		
		JLabel label = new JLabel(">");
		label.setFont(new Font("Tahoma", Font.PLAIN, 34));
		label.setBounds(359, 65, 30, 45);
		frame.getContentPane().add(label);
		
		
//		JScrollPane scrollPane_2 = new JScrollPane();
//		scrollPane_2.setBounds(604, 111, 118, 90);
//		frame.getContentPane().add(scrollPane_2);
		
//		JTextArea relationsTextArea = new JTextArea();
//		scrollPane_2.setViewportView(relationsTextArea);
		
		errorMessage1 = new JTextField();
		errorMessage1.setEditable(false);
		errorMessage1.setBounds(26, 179, 209, 20);
		frame.getContentPane().add(errorMessage1);
		errorMessage1.setColumns(10);
		
		JButton btnAddRelation = new JButton("Add");
		btnAddRelation.setBackground(new Color(124, 252, 0));
		btnAddRelation.setFont(new Font("Trebuchet MS", Font.ITALIC, 25));
		btnAddRelation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				relationsModel.clear();
				errorMessage1.setText("");
//				relation relationList = new relation();
				if (relAtext.getText().length() == 0 || relBtext.getText().length() == 0){// >>>>>>>DONT NEED THIS NEXT BIT AS WILL BE CLICKING ELEMENTS INTO FIELD, not typing>>>> || relAtext.getText() == " " || relBtext.getText() == " "){
//					System.out.println(relBtext.getText());
					errorMessage1.setText("Insert Element");
				}
				else if (relAtext.getText().equals(relBtext.getText())) {
					errorMessage1.setText("Unable to Add");
				}
				
//				else if (relationsModel.size() > 0) {
//					relationList.addRelation(relationList.relations, relAtext.getText(), relBtext.getText());
////					System.out.println(relationList.relations);
//				}
				else if (Integer.parseInt(String.valueOf(posetLengthSelect.getSelectedItem())) == 0){
					errorMessage1.setText("Provide Length");
				}
//				else if (relationsModel.size() == 0) {
//					System.out.println(relationsModel.size());
//					relationList.addRelation(null, relAtext.getText(), relBtext.getText());
					
//					System.out.println(relationList.relations);
					//relationsTextArea.append(relAtext.getText() + ">" + relBtext.getText() + "\n");
//				}
//				relationsTextArea.setText("");
//				DefaultListModel<ArrayList<ArrayList<String>>> relationsModel = new DefaultListModel<>();
//				JList<ArrayList<ArrayList<String>>> relStringList = new JList<>(relationsModel);
//				//JList<ArrayList<ArrayList<String>>> relStringList = new JList<ArrayList<ArrayList<String>>>(relationList.relations);
				
				
//				relStringList.addListSelectionListener(new ListSelectionListener(){
//					public void valueChanged(ListSelectionEvent e){
//						int selectedIndex = relStringList.getSelectedIndex();
//						relStringList.remove(selectedIndex);
//					}
//				});
				else {
					if (relationsModel.size() > 0) {
						relationList.addRelation(relationList.relations, relAtext.getText(), relBtext.getText());
//						System.out.println(relationList.relations);
						relAtext.setText("");
						relBtext.setText("");
					}
					if (relationsModel.size() == 0) {
//						System.out.println(relationsModel.size());
						relationList.addRelation(null, relAtext.getText(), relBtext.getText());
//						System.out.println(relationList.relations);
						relAtext.setText("");
						relBtext.setText("");
					}
					relationsModel.clear();
					for (int i = 0; i < relationList.relations.size(); i++) {
						relationsModel.addElement(relationList.relations.get(i).get(0) + " > " + relationList.relations.get(i).get(1));
//						relationsTextArea.append(relationList.relations.get(i).get(0) + " > " + relationList.relations.get(i).get(1) + "\n");
//						System.out.println(relationList.relations);
					}
				}
			}
		});
		btnAddRelation.setBounds(334, 121, 77, 45);
		frame.getContentPane().add(btnAddRelation);
		
		
//		relStringList.addListSelectionListener(new ListSelectionListener(){
//			public void valueChanged(ListSelectionEvent e){
//				int selectedIndex = relStringList.getSelectedIndex();
//				relationList.relations.remove(selectedIndex);
//				System.out.println(relationList.relations);
//			}
//		});
//		
		
		
		JButton btnClearRelations = new JButton("Clear Relations");
		btnClearRelations.setBackground(new Color(255, 245, 238));
		btnClearRelations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				relationsModel.clear();
				relationList = new relation();
//				relationsTextArea.setText("");
			}
		});
		btnClearRelations.setBounds(441, 237, 124, 23);
		frame.getContentPane().add(btnClearRelations);
		
		
//		The following code is for checking occurrences of a poset within a given permutation. This code needs edited, but could be useful (maybe in some other tab or something)
//		could be useful incase the user wishes to check which occurrences are in a given permutation or something.....
		
		
//		enterPerm = new JTextField();
//		enterPerm.setBounds(171, 468, 124, 30);
//		frame.getContentPane().add(enterPerm);
//		enterPerm.setColumns(10);
//		
//		JScrollPane scrollPane_3 = new JScrollPane();
//		scrollPane_3.setBounds(26, 470, 124, 155);
//		frame.getContentPane().add(scrollPane_3);
//		
//		JTextArea subsListTextArea = new JTextArea();
//		subsListTextArea.setEditable(false);
//		subsListTextArea.setLineWrap(true);
//		scrollPane_3.setViewportView(subsListTextArea);
//		
//		enterLength = new JTextField();
//		enterLength.setBounds(190, 520, 86, 30);
//		frame.getContentPane().add(enterLength);
//		enterLength.setColumns(10);
//		
//		
//		occurrencesText = new JTextField();
//		occurrencesText.setEditable(false);
//		occurrencesText.setBounds(51, 636, 77, 20);
//		frame.getContentPane().add(occurrencesText);
//		occurrencesText.setColumns(10);
//		
//		
//		JButton btnSubSeqsList = new JButton("SubSeqsList");
//		btnSubSeqsList.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				subsListTextArea.setText("");
//				listOfOccs.makeSubsList(enterPerm.getText(), Integer.parseInt(enterLength.getText()), relationList.relations);
//				System.out.println(listOfOccs.subsList);
//				for (int i = 0; i < listOfOccs.subsList.size(); i++) {
//					subsListTextArea.append(listOfOccs.subsList.get(i) + "\n");
//				}
//				occurrencesText.setText(String.valueOf(listOfOccs.subsList.size()));
//			}
//		});
//		btnSubSeqsList.setBounds(171, 579, 140, 23);
//		frame.getContentPane().add(btnSubSeqsList);
//		
//		
//		JLabel lblNumberOfOccurrences = new JLabel("Number of Occurrences");
//		lblNumberOfOccurrences.setBounds(26, 667, 124, 14);
//		frame.getContentPane().add(lblNumberOfOccurrences);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(377, 468, 250, 155);
		frame.getContentPane().add(scrollPane_4);
		
		JTextArea numOfOccsTA = new JTextArea();
		numOfOccsTA.setLineWrap(true);
		numOfOccsTA.setEditable(false);
		scrollPane_4.setViewportView(numOfOccsTA);
		
		permLengthText = new JTextField();
		permLengthText.setBounds(642, 473, 86, 20);
		frame.getContentPane().add(permLengthText);
		permLengthText.setColumns(10);
		
		JButton btnCountOccs = new JButton("Count Occs");
		btnCountOccs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
// MIGHT NEED TO CLEAR LIST OF PERMS OR WHATEVER AT THE START OF EVERY THINGIE
				numOfOccsTA.setText("");
				int permLength = Integer.parseInt(permLengthText.getText());
				int posetLength = Integer.parseInt(String.valueOf(posetLengthSelect.getSelectedItem()));
				double arraySize = Math.pow(Math.ceil((permLength * 2.72) / posetLength), posetLength);
				arraySize = Math.ceil(arraySize);
//				System.out.println(Integer.parseInt(permLengthText.getText()));
//				System.out.println(Integer.parseInt(enterLength.getText()));
//				System.out.println(arraySize);
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
					listOfOccs.makeSubsList(placeholder, Integer.parseInt(String.valueOf(posetLengthSelect.getSelectedItem())), relationList.relations);
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
				occurrenceField.setText(Arrays.toString(distribution));
				
				
			}
		});
		btnCountOccs.setBounds(649, 579, 89, 23);
		frame.getContentPane().add(btnCountOccs);
		
		occurrenceField = new JTextField();
		occurrenceField.setBounds(377, 664, 250, 30);
		frame.getContentPane().add(occurrenceField);
		occurrenceField.setColumns(10);
		
//		JScrollPane scrollPane_5 = new JScrollPane();
//		scrollPane_5.setBounds(377, 35, 279, 183);
//		frame.getContentPane().add(scrollPane_5);
//		
//		JTextArea posetsListTA = new JTextArea();
//		scrollPane_5.setViewportView(posetsListTA);
		
		
		JButton btnAddPoset = new JButton("Add Poset");
		btnAddPoset.setBackground(new Color(0, 255, 0));
		btnAddPoset.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddPoset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				errorMessage1.setText("");
				if (relationsModel.size() == 0){
					errorMessage1.setText("Insert Relation");
				}
				//SHOULD DEFINITELY HAVE A THING ABOUT CHECKING FOR REPETITIONS IN THE POSETS MAYBE
//				else if (relAtext.getText().equals(relBtext.getText())) {
//					errorMessage1.setText("Unable to Add");
//				}
				else if (Integer.parseInt(String.valueOf(posetLengthSelect.getSelectedItem())) == 0){
					errorMessage1.setText("Provide Length");
				}
//				else if (posetsModel.size() == 0 && posetLengthTF.getText().length() > 0) {
//					posetList.addPoset(null, posetLengthTF.getText(), relationList.relations);
////					System.out.println(posetList.posets);
//					//relationsTextArea.append(relAtext.getText() + ">" + relBtext.getText() + "\n");
//				}
				
				else {
					relAtext.setText("");
					relBtext.setText("");
					
					String listOfNums1 = new String();
					for (int i = 1; i < Integer.parseInt(String.valueOf(posetLengthSelect.getSelectedItem())) + 1; i ++){
						listOfNums1 = listOfNums1 + String.valueOf(i) + "";
					}
					String listOfNums2 = new String();
					for (int i = Integer.parseInt(String.valueOf(posetLengthSelect.getSelectedItem())); i > 0 ; i--){
						listOfNums2 = listOfNums2 + String.valueOf(i) + "";
					}
					ArrayList<String> orderedPairs = subSequences.makeSubSeqs(listOfNums1, 2);
					ArrayList<String> orderedPairs2 = subSequences.makeSubSeqs(listOfNums2, 2);
					orderedPairs.addAll(orderedPairs2);
					
					Integer pairsListSize = orderedPairs.size();
					
					
//					System.out.println(binSigList);
					
					
					ArrayList<ArrayList<ArrayList<String>>> allRelCombos = new ArrayList<ArrayList<ArrayList<String>>>();
					
					

					ArrayList<ArrayList<String>> temp = subSeqArrays.makeSubSeqs(orderedPairs, 1);
					allRelCombos.add(temp);
					ArrayList<ArrayList<String>> coreRelations = allRelCombos.get(0);
					for (int j = 0; j < relationList.relations.size(); j++){
						binarySig newBinSig = new binarySig();
						newBinSig.makeBinSig(coreRelations, relationList.relations);
						if (binSigList.contains(newBinSig.binSig)){
							errorMessage1.setText("Poset already added");
							continue;
						}
						else {
							//posetList.addPoset(posetList.posets, posetLengthTF.getText(), relationList.relations);                                           // Changed autoPoset to posetList
							binSigList.add(newBinSig.binSig);
							String seqq = new String();
							for (int l = 1; l < Integer.parseInt(String.valueOf(posetLengthSelect.getSelectedItem())) + 1; l++){
								seqq = seqq + l;
							}
							String posetString = seqq + "    :    ";
							
							if (posetsModel.size() == 0) {
								posetList.addPoset(null, String.valueOf(posetLengthSelect.getSelectedItem()), relationList.relations);
//								System.out.println(posetList.posets);
								//relationsTextArea.append(relAtext.getText() + ">" + relBtext.getText() + "\n");
							}
							else{
								posetList.addPoset(posetList.posets, String.valueOf(posetLengthSelect.getSelectedItem()), relationList.relations);
								System.out.println(posetList.posets);
							
//								posetsModel.clear();
//								posetsModel.addElement(posetLengthTF.getText() + " :  ");
							}
							for (int i = 0; i < relationsModel.size() - 1; i++) {
								posetString = posetString + relationsModel.get(i) + "   ,    ";
								
							}
							posetString = posetString + relationsModel.get(relationsModel.size() - 1);
							posetsModel.addElement(posetString);
							relationList = new relation();
//							relationsTextArea.setText("");
							relationsModel.clear();
						}
//						System.out.println(temp2);
//						System.out.println(allRelCombos);
					}
					
/// Below here is to be kept, the above stuff is an attempt to give new poset a bin sig and check if it is in the bin sig list
//					String seqq = new String();
//					for (int l = 1; l < Integer.parseInt(posetLengthTF.getText()) + 1; l++){
//						seqq = seqq + l;
//					}
//					String posetString = seqq + "    :    ";
//					
//					if (posetsModel.size() == 0) {
//						posetList.addPoset(null, posetLengthTF.getText(), relationList.relations);
////						System.out.println(posetList.posets);
//						//relationsTextArea.append(relAtext.getText() + ">" + relBtext.getText() + "\n");
//					}
//					else{
//						posetList.addPoset(posetList.posets, posetLengthTF.getText(), relationList.relations);
//						System.out.println(posetList.posets);
//					
////						posetsModel.clear();
////						posetsModel.addElement(posetLengthTF.getText() + " :  ");
//					}
//					for (int i = 0; i < relationsModel.size(); i++) {
//						posetString = posetString + relationsModel.get(i) + "   ,    ";
//						
//					}
//					posetsModel.addElement(posetString);
//					relationList = new relation();
////					relationsTextArea.setText("");
//					relationsModel.clear();
				}
				
				
				
			}
		});
		btnAddPoset.setBounds(579, 131, 110, 45);
		frame.getContentPane().add(btnAddPoset);
		
		JButton btnClearPosets = new JButton("Clear Posets");
		btnClearPosets.setBackground(new Color(255, 245, 238));
		btnClearPosets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				posetList = new poset();
				posetsModel.clear();
			}
		});
		btnClearPosets.setBounds(222, 429, 110, 23);
		frame.getContentPane().add(btnClearPosets);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(377, 722, 400, 183);
		frame.getContentPane().add(scrollPane_6);
		
		JTextArea allRelsTA = new JTextArea();
		scrollPane_6.setViewportView(allRelsTA);
		
		posLengthTF = new JTextField();
		posLengthTF.setBounds(385, 928, 86, 20);
		frame.getContentPane().add(posLengthTF);
		posLengthTF.setColumns(10);
		
		JButton btnGenRels = new JButton("Go");
		btnGenRels.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				binSigList.clear();
				allRelsTA.setText("");
//				ArrayList<ArrayList<String>> binSigList = new ArrayList<ArrayList<String>>();
				posetList = new poset();                                                                  // Changed autoPoset to posetList
				posetsModel.clear();
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
				for (int i = 0; i < 6 + 3; i++){
					allRelCombos = new ArrayList<ArrayList<ArrayList<String>>>();
					ArrayList<ArrayList<String>> temp2 = subSeqArrays.makeSubSeqs(orderedPairs, i);
					allRelCombos.add(temp2);
					String separator = "--------L" + i + "---------";
					Integer counter = 0;
//					ArrayList<String> sepLine = new ArrayList<String>();
//					sepLine.add(separator);
					allRelsTA.append(separator + "\n");
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
							posetList.addPoset(posetList.posets, posLengthTF.getText(), autoRels.relations);                                           // Changed autoPoset to posetList
							binSigList.add(newBinSig.binSig);
							allRelsTA.append(newBinSig.binSig.toString() + "\n");
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
//					ArrayList<String> count = new ArrayList<String>();
//					count.add("The count for the above is --->   " + counter.toString());
					allRelsTA.append( "\n" + "Number of new Unique Posets gained --->   " + counter.toString() + "\n");
				}
				
				for (int i = 0; i < posetList.posets.size(); i++){                            // Changed autoPoset to posetList
					String seqq = new String();
					for (int l = 1; l < Integer.parseInt(posetList.posets.get(i).get(0).get(0).get(0)) + 1; l++){                   // Changed autoPoset to posetList
						seqq = seqq + l;
					}
					String posetString = seqq + "    :    ";
					String relationString = new String();
					for (int k = 0; k < posetList.posets.get(i).get(1).size(); k++){                                            // Changed autoPoset to posetList
						relationString = relationString + posetList.posets.get(i).get(1).get(k).get(0) + "  >  " + posetList.posets.get(i).get(1).get(k).get(1) + "  ,  ";              // Changed autoPoset to posetList
					}
					posetsModel.addElement(posetString + relationString + "\n");
				}
				//allRelsTA.setText("");
//				for (int i = 0; i < binSigList.size(); i++){
//					allRelsTA.append(binSigList.get(i) + "\n");
//				}
				System.out.println(binSigList);
			}
		});
		btnGenRels.setBounds(481, 927, 59, 23);
		frame.getContentPane().add(btnGenRels);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBackground(new Color(255, 192, 203));
		
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int selectedIndex = relStringList.getSelectedIndex();
					
//							System.out.println(selectedIndex);
					relationList.relations.remove(selectedIndex);
					ArrayList<ArrayList<String>> copy = new ArrayList<ArrayList<String>>();
					copy.addAll(relationList.relations);
//					relationList.relations.remove(relStringList.getSelectedIndex());
					relStringList.clearSelection();
					relationsModel.remove(selectedIndex);
						
//							relationsModel.removeElement(relationList.relations.get(selectedIndex));
					
					relationsModel.clear();
					relationList = new relation();
//					relationsTextArea.setText("");
					for (int i = 0; i < copy.size(); i++) {
						relationList.addRelation(relationList.relations, copy.get(i).get(0), copy.get(i).get(1));
					
//						relationsTextArea.append(relationList.relations.get(i).get(0) + " > " + relationList.relations.get(i).get(1) + "\n");
					}
					for (int j = 0; j < relationList.relations.size(); j++){
						relationsModel.addElement(relationList.relations.get(j).get(0) + " > " + relationList.relations.get(j).get(1));
//						System.out.println(relationList.relations.get(j));
					}
//					relationList.relations.remove(selectedIndex);
//					System.out.println(relationList.relations);
				} catch (ArrayIndexOutOfBoundsException E) {
					
				}
				
				
			}
		});
		btnRemove.setBounds(330, 178, 89, 23);
		frame.getContentPane().add(btnRemove);
		
		JButton btnRemovePoset = new JButton("Remove Poset");
		btnRemovePoset.setBackground(new Color(255, 192, 203));
		btnRemovePoset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = posetStringList.getSelectedIndex();
				
//					System.out.println(selectedIndex);
				posetList.posets.remove(selectedIndex);
//				relationList.relations.remove(relStringList.getSelectedIndex());
				posetStringList.clearSelection();
				System.out.println(binSigList + "EEEEGGGGGGGGGGG");
				binSigList.remove(selectedIndex);
//				System.out.println(posetStringList);
				System.out.println(posetList.posets + " HEREEEEEE");
				
//				posetsModel.removeElement(posetList.posets.get(selectedIndex));
				posetsModel.remove(selectedIndex);
				
//				posetsModel.clear();
//				for (int i = 0; i < posetList.posets.size(); i++) {
//					String posetString = posetList.posets.get(i).get(0).get(0).get(0) + " : ";
//					System.out.println(posetString);
//				
//					
////					posetsModel.clear();
////					posetsModel.addElement(posetLengthTF.getText() + " :  ");
//					for (int j = 0; j < posetList.posets.get(i).get(1).size(); j++) {
//						System.out.println(posetList.posets.get(j).get(1));
//						posetString = posetString + posetList.posets.get(i).get(1).get(j).get(0) + " > " + posetList.posets.get(i).get(1).get(j).get(0) + " , ";
//						
//					}
//					posetsModel.addElement(posetString);
////					relationList = new relation();
////				
////					relationList.addRelation(relationList.relations, relationList.relations.get(i).get(0), relationList.relations.get(i).get(1));
//					posetsModel.addElement(posetList.posets.get(i).get(0) + " > " + posetList.posets.get(i).get(1));
////					relationsTextArea.append(relationList.relations.get(i).get(0) + " > " + relationList.relations.get(i).get(1) + "\n");
//				}	
////				posetList.posets.remove(selectedIndex);
			}
		});
		btnRemovePoset.setBounds(50, 429, 110, 23);
		frame.getContentPane().add(btnRemovePoset);
		
		lowerBoundTF = new JTextField();
		lowerBoundTF.setBounds(10, 473, 41, 30);
		frame.getContentPane().add(lowerBoundTF);
		lowerBoundTF.setColumns(10);
		
		upperBoundTF = new JTextField();
		upperBoundTF.setBounds(161, 473, 41, 29);
		frame.getContentPane().add(upperBoundTF);
		upperBoundTF.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 520, 327, 138);
		frame.getContentPane().add(scrollPane);
		
		JTextArea distributions = new JTextArea();
		distributions.setEditable(false);
		scrollPane.setViewportView(distributions);
		
		JButton btnDistRange = new JButton("Distributions");
		btnDistRange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lowerBoundTF.getText().length()==0 || upperBoundTF.getText().length() == 0){
					distributions.setText("Please provide both upper and lower bounds");
				}
				else if (posetsModel.size() == 0) {
					distributions.setText("Please input some posets");
				}
				else {
//					ArrayList<Integer[]> megaDistribution = new ArrayList<Integer[]>();
//					Integer[] megaDist = new Integer[0];
//					ArrayList<Integer[]> finalMega = new ArrayList<Integer[]>();
					numOfOccsTA.setText("");
					distributions.setText("");
					int lowerLim = Integer.parseInt(lowerBoundTF.getText());
					int upperLim = Integer.parseInt(upperBoundTF.getText());
					// Dont think I need the below arraylist. Maybe for saving it later on or something????
					ArrayList<ArrayList<String>> distRange = new ArrayList<ArrayList<String>>();
					for (int k = 0 ; k < posetList.posets.size(); k++){                       // Changed autoPoset to posetList
//						System.out.println(k + "HEHEHEHEHEHEHEHEHE");
						distributions.append("Poset :    " + posetsModel.get(k) + "\n");
						ArrayList<String> avoidance = new ArrayList<String>();
						for (int j = 0; j < upperLim - lowerLim + 1 ; j++){
							int permLength = lowerLim + j;
							int posetLength = Integer.parseInt(posetList.posets.get(k).get(0).get(0).get(0));              // Changed autoPoset to posetList
							double arraySize = Math.pow(Math.ceil((permLength * 2.72) / posetLength), posetLength);
							arraySize = Math.ceil(arraySize);
//							System.out.println(Integer.parseInt(permLengthText.getText()));
//							System.out.println(Integer.parseInt(enterLength.getText()));
//							System.out.println(arraySize);
//							ArrayList distributionList = new ArrayList(arraySize);
//							ArrayList<Integer> distributionList = new ArrayList<Integer>(Collections.nCopies(60, 0));
							Integer[] distributionList = Collections.nCopies((int) arraySize, 0).toArray(new Integer[0]);
							Integer[] distribution = new Integer[0];
//							megaDistribution.add(distributionList.clone());
//							ArrayList<ArrayList<String>> listPermsAndOccs = new ArrayList<ArrayList<String>>();
							listOfPerms.permute(permLength);
							for (int i = 0; i < listOfPerms.perms2.size(); i++){
								listOfOccs = new subSeqList();
								String placeholder = listOfPerms.perms2.get(i);
								ArrayList<String> permAndOccs = new ArrayList<String>();
								listOfOccs.makeSubsList(placeholder, Integer.parseInt(posetList.posets.get(k).get(0).get(0).get(0)), posetList.posets.get(k).get(1));        // Changed autoPoset to posetList
//								Might not need to keep this permsAndOccs arraylist, but will keep for now.... could possibly get rid of "permAndOcc" and stuff...??
								
								Integer distMark = listOfOccs.subsList.size();
								permAndOccs.add(placeholder);
								permAndOccs.add(String.valueOf(distMark));
//								listPermsAndOccs.add(permAndOccs);
//								numOfOccsTA.append("perm:  " + placeholder + " , Num of Occs: " + String.valueOf(listOfOccs.subsList.size()) + "\n");
								distributionList[distMark]++;
//								megaDistribution.get(j)[distMark]++;
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
							
							avoidance.add(String.valueOf(distributionList[0]));
							distributions.append("Distribution for " + permLength + " :    " + Arrays.toString(distribution) + "\n");
				
				
						}
						numOfOccsTA.append("Aviodance for poset : " + "\n" + posetsModel.get(k) + "\n" + avoidance + "\n" + "\n");
						distributions.append(" ----------------------------------------" + "\n");
						
					}
//					for (int l = 0; l < megaDistribution.size(); l++){
//						for (int i = megaDistribution.get(l).length - 1; i >= 0; i--) {
//							if (megaDistribution.get(l)[i] == 0) {
//								continue;
//							}
//							else{
//								megaDist = Arrays.copyOfRange(megaDistribution.get(l), 0, i+1);
//								finalMega.add(megaDist);
//								break;
//							}
//						}
//					}
//					distributions.append("-------------------------------" + "\n" + "Distributions over all Posets :" + "\n");
//					for (int m = 0; m < finalMega.size(); m++){
//						distributions.append("Distribution for length  " + (lowerLim + m) + " : " + Arrays.toString(finalMega.get(m)) + "\n");
//					}
				}



			}
		});
		btnDistRange.setBounds(222, 477, 100, 23);
		frame.getContentPane().add(btnDistRange);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Desktop browser = Desktop.getDesktop();
				String searchAvoidance = occurrenceField.getText();
				searchAvoidance = searchAvoidance.replace(" ", "");
				System.out.println(searchAvoidance);
				try {
					browser.browse(new URI("https://oeis.org/search?q=" + searchAvoidance));
				}
				
				catch(IOException err) {
					
				}
				catch(URISyntaxException err){
					
				}
//				Jsoup.connect("https://oeis.org/search?q=" + occurrenceField.getText());
				
			}
				
//   THE BELOW PORTION OF CODE SEARCHES OEIS AND SPITS OUT THE REFERENCE IF IT FINDS A RESULT!!				
//				try {
//					ArrayList<String> oref = OEISref.refNum(occurrenceField.getText());
//					oeisTF.setText("reference  :  " + oref);
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
				
				
				
			
		});
		btnSearch.setBounds(649, 635, 127, 23);
		frame.getContentPane().add(btnSearch);
		
		oeisTF = new JTextField();
		oeisTF.setBounds(652, 667, 140, 27);
		frame.getContentPane().add(oeisTF);
		oeisTF.setColumns(10);
		
		
		
		
//		JButton btn1 = new JButton("1");
//		btn1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (relAtext.getText().length() == 0){
//					relAtext.setText("1");
//				}
//				else if(relBtext.getText().length() == 0){
//					relBtext.setText("1");
//				}
//				else {
//					errorMessage1.setText("clear space");
//				}
//			}
//		});
//		btn1.setBounds(10, 100, 41, 30);
//		btn1.setVisible(false);
//		frame.getContentPane().add(btn1);
//		
//		JButton btn2 = new JButton("2");
//		btn2.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (relAtext.getText().length() == 0){
//					relAtext.setText("2");
//				}
//				else if(relBtext.getText().length() == 0){
//					relBtext.setText("2");
//				}
//				else {
//					errorMessage1.setText("clear space");
//				}
//			}
//		});
//		btn2.setBounds(61, 100, 41, 30);
//		btn2.setVisible(false);
//		frame.getContentPane().add(btn2);
//		
//		JButton btn3 = new JButton("3");
//		btn3.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (relAtext.getText().length() == 0){
//					relAtext.setText("3");
//				}
//				else if(relBtext.getText().length() == 0){
//					relBtext.setText("3");
//				}
//				else {
//					errorMessage1.setText("clear space");
//				}
//			}
//		});
//		btn3.setBounds(110, 100, 41, 30);
//		btn3.setVisible(false);
//		frame.getContentPane().add(btn3);
//		
//		JButton btn4 = new JButton("4");
//		btn4.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (relAtext.getText().length() == 0){
//					relAtext.setText("4");
//				}
//				else if(relBtext.getText().length() == 0){
//					relBtext.setText("4");
//				}
//				else {
//					errorMessage1.setText("clear space");
//				}
//			}
//		});
//		btn4.setBounds(161, 100, 41, 30);
//		btn4.setVisible(false);
//		frame.getContentPane().add(btn4);
//		
//		JButton btn5 = new JButton("5");
//		btn5.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (relAtext.getText().length() == 0){
//					relAtext.setText("5");
//				}
//				else if(relBtext.getText().length() == 0){
//					relBtext.setText("5");
//				}
//				else {
//					errorMessage1.setText("clear space");
//				}
//			}
//		});
//		btn5.setBounds(212, 100, 41, 30);
//		btn5.setVisible(false);
//		frame.getContentPane().add(btn5);
//		
//		JButton btn6 = new JButton("6");
//		btn6.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (relAtext.getText().length() == 0){
//					relAtext.setText("6");
//				}
//				else if(relBtext.getText().length() == 0){
//					relBtext.setText("6");
//				}
//				else {
//					errorMessage1.setText("clear space");
//				}
//			}
//		});
//		btn6.setBounds(36, 140, 41, 30);
//		btn6.setVisible(false);
//		frame.getContentPane().add(btn6);
//		
//		JButton btn7 = new JButton("7");
//		btn7.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (relAtext.getText().length() == 0){
//					relAtext.setText("7");
//				}
//				else if(relBtext.getText().length() == 0){
//					relBtext.setText("7");
//				}
//				else {
//					errorMessage1.setText("clear space");
//				}
//			}
//		});
//		btn7.setBounds(87, 140, 41, 30);
//		btn7.setVisible(false);
//		frame.getContentPane().add(btn7);
//		
//		JButton btn8 = new JButton("8");
//		btn8.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (relAtext.getText().length() == 0){
//					relAtext.setText("8");
//				}
//				else if(relBtext.getText().length() == 0){
//					relBtext.setText("8");
//				}
//				else {
//					errorMessage1.setText("clear space");
//				}
//			}
//		});
//		btn8.setBounds(137, 140, 41, 30);
//		btn8.setVisible(false);
//		frame.getContentPane().add(btn8);
//		
//		JButton btn9 = new JButton("9");
//		btn9.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (relAtext.getText().length() == 0){
//					relAtext.setText("9");
//				}
//				else if(relBtext.getText().length() == 0){
//					relBtext.setText("9");
//				}
//				else {
//					errorMessage1.setText("clear space");
//				}
//			}
//		});
//		btn9.setBounds(190, 140, 41, 30);
//		btn9.setVisible(false);
//		frame.getContentPane().add(btn9);
//		
		posetExampleTF = new JTextField();
		posetExampleTF.setFont(new Font("Tahoma", Font.BOLD, 17));
		posetExampleTF.setEditable(false);
		posetExampleTF.setBounds(73, 65, 110, 30);
		frame.getContentPane().add(posetExampleTF);
		posetExampleTF.setColumns(10);
		
//		JButton btnUseLength = new JButton("Use Length");
//		btnUseLength.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				posetExampleTF.setText("");
//				relationsModel.clear();
//				
//				btn9.setVisible(false);
//				btn8.setVisible(false);
//				btn7.setVisible(false);
//				btn6.setVisible(false);
//				btn5.setVisible(false);
//				btn4.setVisible(false);
//				btn3.setVisible(false);
//				btn2.setVisible(false);
//				btn1.setVisible(false);
//				if (Integer.parseInt(String.valueOf(posetLengthSelect.getSelectedItem())) == 0){
//					errorMessage1.setText("Provide a length");
//					
//				}
//				
//				else {
//					String numberString = new String();
//					for (int i = 0; i < Integer.parseInt(String.valueOf(posetLengthSelect.getSelectedItem())); i++){
////						String btn = new String();
////						btn = "btn" + (i+1);
////						btn.setVisible(true);
//						numberString = numberString + (i+1);
//					}
//					if (Integer.parseInt(String.valueOf(posetLengthSelect.getSelectedItem())) > 8){
//						btn9.setVisible(true);
//					}
//					if (Integer.parseInt(String.valueOf(posetLengthSelect.getSelectedItem())) > 7){
//						btn8.setVisible(true);
//					}
//					if (Integer.parseInt(String.valueOf(posetLengthSelect.getSelectedItem())) > 6){
//						btn7.setVisible(true);
//					}
//					if (Integer.parseInt(String.valueOf(posetLengthSelect.getSelectedItem())) > 5){
//						btn6.setVisible(true);
//					}
//					if (Integer.parseInt(String.valueOf(posetLengthSelect.getSelectedItem())) > 4){
//						btn5.setVisible(true);
//					}
//					if (Integer.parseInt(String.valueOf(posetLengthSelect.getSelectedItem())) > 3){
//						btn4.setVisible(true);
//					}
//					if (Integer.parseInt(String.valueOf(posetLengthSelect.getSelectedItem())) > 2){
//						btn3.setVisible(true);
//					}
//					if (Integer.parseInt(String.valueOf(posetLengthSelect.getSelectedItem())) > 1){
//						btn2.setVisible(true);
//					}
//					if (Integer.parseInt(String.valueOf(posetLengthSelect.getSelectedItem())) > 0){
//						btn1.setVisible(true);
//					}
//					posetExampleTF.setText(numberString);
//				}
//			}
//		});
//		btnUseLength.setBounds(206, 21, 105, 23);
//		frame.getContentPane().add(btnUseLength);
		
		JLabel lblLength = new JLabel("Length:");
		lblLength.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLength.setBounds(10, 24, 72, 33);
		frame.getContentPane().add(lblLength);
		
		JLabel label_1 = new JLabel("< n <");
		label_1.setFont(new Font("Tahoma", Font.ITALIC, 28));
		label_1.setBounds(65, 468, 86, 35);
		frame.getContentPane().add(label_1);
		
		JButton btnNewButton = new JButton("Clear");
		btnNewButton.setBackground(new Color(255, 245, 238));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				relAtext.setText("");
				relBtext.setText("");
			}
		});
		btnNewButton.setBounds(320, 28, 110, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnMegaDist = new JButton("Distribution over all posets");
		btnMegaDist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (lowerBoundTF.getText().length()==0 || upperBoundTF.getText().length() == 0){
					distributions.setText("Please provide both upper and lower bounds");
				}
				else if (posetsModel.size() == 0) {
					distributions.setText("Please input some posets");
				}
				else {
//					ArrayList<Integer[]> megaDistribution = new ArrayList<Integer[]>();
//					Integer[] megaDist = new Integer[0];
//					ArrayList<Integer[]> finalMega = new ArrayList<Integer[]>();
					numOfOccsTA.setText("");
					distributions.setText("");
					int lowerLim = Integer.parseInt(lowerBoundTF.getText());
					int upperLim = Integer.parseInt(upperBoundTF.getText());
					// Dont think I need the below arraylist. Maybe for saving it later on or something????
					ArrayList<ArrayList<String>> distRange = new ArrayList<ArrayList<String>>();
					ArrayList<String> avoidance = new ArrayList<String>();
					Integer numOfPosets = posetList.posets.size();
					for (int j = 0; j < upperLim - lowerLim + 1 ; j++){
						int permLength = lowerLim + j;
						int maxLength = permLength/2;              // Changed autoPoset to posetList
						double arraySize = Math.pow(Math.ceil((permLength * 2.72) / maxLength), maxLength) * numOfPosets;
						arraySize = Math.ceil(arraySize);
//						System.out.println(Integer.parseInt(permLengthText.getText()));
//						System.out.println(Integer.parseInt(enterLength.getText()));
//						System.out.println(arraySize);
//						ArrayList distributionList = new ArrayList(arraySize);
//						ArrayList<Integer> distributionList = new ArrayList<Integer>(Collections.nCopies(60, 0));
						Integer[] distributionList = Collections.nCopies((int) arraySize, 0).toArray(new Integer[0]);
						Integer[] distribution = new Integer[0];// Changed autoPoset to posetList
//						System.out.println(k + "HEHEHEHEHEHEHEHEHE");
//						megaDistribution.add(distributionList.clone());
//						ArrayList<ArrayList<String>> listPermsAndOccs = new ArrayList<ArrayList<String>>();
						listOfPerms.permute(permLength);

						for (int i = 0; i < listOfPerms.perms2.size(); i++){
							listOfOccs = new subSeqList();
							String placeholder = listOfPerms.perms2.get(i);
							ArrayList<String> permAndOccs = new ArrayList<String>();
							Integer thisPermsOccs = 0;
							for (int k = 0 ; k < numOfPosets; k++){ 
								
//								distributions.append("Poset :    " + posetsModel.get(k) + "\n");
								
//								listOfOccs = new subSeqList();
//								String placeholder = listOfPerms.perms2.get(i);
//								ArrayList<String> permAndOccs = new ArrayList<String>();
							
								listOfOccs.makeSubsList(placeholder, Integer.parseInt(posetList.posets.get(k).get(0).get(0).get(0)), posetList.posets.get(k).get(1));        // Changed autoPoset to posetList
//								Might not need to keep this permsAndOccs arraylist, but will keep for now.... could possibly get rid of "permAndOcc" and stuff...??
								thisPermsOccs = thisPermsOccs + listOfOccs.subsList.size();
							}
//							Integer distMark = listOfOccs.subsList.size();
							permAndOccs.add(placeholder);
							permAndOccs.add(String.valueOf(thisPermsOccs));
//							listPermsAndOccs.add(permAndOccs);
//							numOfOccsTA.append("perm:  " + placeholder + " , Num of Occs: " + String.valueOf(listOfOccs.subsList.size()) + "\n");
//							System.out.println(distributionList.length);
							distributionList[thisPermsOccs]++;
//							megaDistribution.get(j)[distMark]++;
							for (int l = distributionList.length - 1; l >= 0; l--) {
								if (distributionList[l] == 0) {
									continue;
								}
								else{
									distribution = Arrays.copyOfRange(distributionList, 0, l+1);
									break;
								}
								
							}
						}
						avoidance.add(String.valueOf(distributionList[0]));
						distributions.append("Distribution for " + permLength + " :    " + Arrays.toString(distribution) + "\n");
						
							

					
					
							
//							numOfOccsTA.append("Aviodance for poset : " + "\n" + posetsModel.get(k) + "\n" + avoidance + "\n" + "\n");
//						distributions.append(" ----------------------------------------" + "\n");
							
						
							
							
						
						
//						for (int i = distributionList.length - 1; i >= 0; i--) {
//								if (distributionList[i] == 0) {
//									continue;
//								}
//								else{
//									distribution = Arrays.copyOfRange(distributionList, 0, i+1);
//									break;
//								}
//							
//							}
//							
//							avoidance.add(String.valueOf(distributionList[0]));
//							distributions.append("Distribution for " + permLength + " :    " + Arrays.toString(distribution) + "\n");
//				
//				
//						}
//						numOfOccsTA.append("Aviodance for poset : " + "\n" + posetsModel.get(k) + "\n" + avoidance + "\n" + "\n");
//						distributions.append(" ----------------------------------------" + "\n");
//						
//					}
//					for (int l = 0; l < megaDistribution.size(); l++){
//						for (int i = megaDistribution.get(l).length - 1; i >= 0; i--) {
//							if (megaDistribution.get(l)[i] == 0) {
//								continue;
//							}
//							else{
//								megaDist = Arrays.copyOfRange(megaDistribution.get(l), 0, i+1);
//								finalMega.add(megaDist);
//								break;
//							}
//						}
//					}
					}
						
					numOfOccsTA.append("Avoidance Information? : " + "\n" + avoidance + "\n");
					occurrenceField.setText(avoidance.toString());
					//distributions.append("-------------------------------" + "\n" + "Distributions over all Posets :" + "\n");
//					for (int m = 0; m < finalMega.size(); m++){
//						distributions.append("Distribution for length  " + (lowerLim + m) + " : " + Arrays.toString(finalMega.get(m)) + "\n");
//					}
				}

				
			}
		});
		btnMegaDist.setBounds(10, 668, 221, 23);
		frame.getContentPane().add(btnMegaDist);
		
		
		
		
		

		
		
//		subSeqLength = new JTextField();
//		subSeqLength.setBounds(511, 200, 59, 20);
//		frame.getContentPane().add(subSeqLength);
//		subSeqLength.setColumns(10);
	}
}
