import java.util.Map;

public static void main(String[] args) {
    String s="Bonjour! Au revoir!";
    Map<Character, Integer> freq = Huffman.computeFreq(s);
    System.out.println(freq);
}