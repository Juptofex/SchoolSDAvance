import java.util.HashMap;
import java.util.Map;


public class Huffman {

	private static class Node  {
		private char ch;
		private int freq;
		private final Node left, right;

		public Node(char ch, int freq, Node left, Node right) {
			this.ch = ch;
			this.freq = freq;
			this.left = left;
			this.right = right;
		}

		public boolean isLeaf() {
			return left == null && right == null;
		}

	}
	
	// renvoie une map qui a comme clé les lettres de la chaine de 
	// caractère donnée en paramètre et comme valeur la fréquence de 
	// ces lettres 
	public static Map<Character, Integer> computeFreq(String s) {
		Map<Character, Integer> freq = new HashMap<>();
		for (char c : s.toCharArray()) {
			freq.put(c, freq.getOrDefault(c, 0) + 1);
		}
		return freq;
	}	
	
	// renvoie l'arbre de Huffman obtenu à partir de la map des fréquences des lettres 
	public static Node buildTree(Map<Character, Integer> freq) {
		return null;
	}
	
	// renvoie une map qui associe chaque lettre à son code (suite de 0 et de 1). 
	// Ce code est obtenu en parcourant l'arbre de Huffman donné en paramètre
	public static Map<Character, String> buildCode(Node root) {
		return null;
	}

	
	// encode la chaine de caractère prise en paramètre en une chaine de 
	// bit (0 et 1) en utilisant la map des codes codeMap
	public static String compress(String s, Map<Character, String> codeMap) {
		return null;
	}
	
	// Cette méthode décode une chaine de 0 et de 1 codé à l'aide de l'algorithme de Huffman
	// En paramètre, en plus de la chaine à décoder, est spécifié la racine de l'arbre de 
	// Huffman 
	public static String expand(Node root, String t) {
		return null;
	}
	
}
