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
	
	// renvoie une map qui a comme cl� les lettres de la chaine de 
	// caract�re donn�e en param�tre et comme valeur la fr�quence de 
	// ces lettres 
	public static Map<Character, Integer> computeFreq(String s) {
		Map<Character, Integer> freq = new HashMap<>();
		for (char c : s.toCharArray()) {
			freq.put(c, freq.getOrDefault(c, 0) + 1);
		}
		return freq;
	}	
	
	// renvoie l'arbre de Huffman obtenu � partir de la map des fr�quences des lettres 
	public static Node buildTree(Map<Character, Integer> freq) {
		return null;
	}
	
	// renvoie une map qui associe chaque lettre � son code (suite de 0 et de 1). 
	// Ce code est obtenu en parcourant l'arbre de Huffman donn� en param�tre
	public static Map<Character, String> buildCode(Node root) {
		return null;
	}

	
	// encode la chaine de caract�re prise en param�tre en une chaine de 
	// bit (0 et 1) en utilisant la map des codes codeMap
	public static String compress(String s, Map<Character, String> codeMap) {
		return null;
	}
	
	// Cette m�thode d�code une chaine de 0 et de 1 cod� � l'aide de l'algorithme de Huffman
	// En param�tre, en plus de la chaine � d�coder, est sp�cifi� la racine de l'arbre de 
	// Huffman 
	public static String expand(Node root, String t) {
		return null;
	}
	
}
