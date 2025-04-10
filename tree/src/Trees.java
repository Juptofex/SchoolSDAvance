import java.util.ArrayList;
import java.util.Collections;

public class Trees {

	// *******************************************************
	// Un premier exemple: le nombre de feuilles d'un arbre
	// *******************************************************
	public static int nbrLeaves(Tree t) {
		int r;
		if (t.isLeaf()) {
			r = 1;
		} else {
			r = 0;
			for (Tree child : t) {
				r += nbrLeaves(child);
			}
		}
		return r;
	}

	// *******************************************************
	// Un deuxième exemple: aplanir un arbre
	// *******************************************************
	public static Tree[] flattenLeaves(Tree t) {
		int nl = nbrLeaves(t);
		Tree[] r = new Tree[nl];
		flattenLeaves(t, r, 0);
		return r;
	}

	private static int flattenLeaves(Tree t, Tree[] a, int idx) {
		int r;
		if (t.isLeaf()) {
			a[idx] = t;
			r = 1;
		} else {
			r = 0;
			for (Tree child : t) {
				r += flattenLeaves(child, a, idx + r);
			}
		}
		return r;
	}

	// *******************************************************
	// Un troisième exemple:
	// tous les algorithmes ne sont pas récursifs
	// *******************************************************
	public static void pathV1(Tree t) {
		System.out.println(t.getValue());
		if (t.getParent() != null) {
			pathV1(t.getParent());
		}
	}

	public static void pathV2(Tree t) {
		while (t != null) {
			System.out.println(t.getValue());
			t = t.getParent();
		}
	}

	// *******************************************************
	// Exercices 1
	// *******************************************************

	// 1.1)
	public static int nbrNode(Tree t) {
		int r=1;
		if (t.isLeaf()) {
			return r;
		}
		for (Tree child: t) {
			r+=nbrNode(child);
		}
		return r;
	}

	// 1.2)
	public static int min(Tree t) {
		int v=t.getValue();
		if (t.isLeaf()) {
			return t.getValue();
		}
		for (Tree child: t) {
			int temp=min(child);
			if (v>temp)
				v=temp;
		}
		return v;
	}

	// 1.3)
	public static int sum(Tree t) {
		int v=t.getValue();
		if (t.isLeaf()) {
			return t.getValue();
		}
		for (Tree child: t) {
			v+=sum(child);
		}
		return v;
	}

	// 1.4)
	public static boolean equals(Tree t1, Tree t2) {
		if (t1.getValue()!= t2.getValue()) return false;
		int n1=t1.nbrChildren();
		int n2=t2.nbrChildren();
		if (n1!=n2) return false;
		for (int i = 0; i < n1; i++) {
			if (!equals(t1.getChildren()[i], t2.getChildren()[i]))
				return false;
		}
		return true;
	}

	// 1.5)
	public static int depth(Tree n) {
		int i=0;
		if (n.getParent()==null)
			return i;
		i = depth(n.getParent()) + 1;
		return i;
	}

	// 1.6)
	public static boolean sameOne(Tree n1, Tree n2) {
		if (n1.getParent() != null)
			return sameOne(n1.getParent(), n2);
		if (n2.getParent() != null)
			return sameOne(n1, n2.getParent());
		return n1==n2;
	}

	// 1.7)
	public static void dfsPrint(Tree t) {
		System.out.println(t.getValue());
		for (Tree child : t.getChildren()) {
			dfsPrint(child);
		}
	}

	// 1.8)
	public static void bfsPrint(Tree t) {
		ArrayList<Tree> currentLevel = new ArrayList<>();
		currentLevel.add(t);
		bfsPrintLevel(currentLevel);
	}

	private static void bfsPrintLevel(ArrayList<Tree> currentLevel) {
		if (currentLevel.isEmpty()) {
			return;
		}
		ArrayList<Tree> nextLevel = new ArrayList<>();
		for (Tree node : currentLevel) {
			System.out.println(node.getValue());
      Collections.addAll(nextLevel, node.getChildren());
		}

		// Process next level recursively
		bfsPrintLevel(nextLevel);
	}

	// *******************************************************
	// Exercices 2
	// *******************************************************

	// 2.1)
	static void printPathV1(Tree node) {
	}

	// 2.2)
	static void printPathV2(Tree node) {
	}

	// 2.3
	static void printPathV3(Tree t, int v) {
	}

	// *******************************************************
	// Exercices 3
	// *******************************************************

	// 3.1
	public static int[][] toArray(Tree t) {
		return null;
	}

	// 3.2
	public static Tree toTree(int[][] t) {
		return null;
	}

	// *******************************************************
	// Exercices 4
	// *******************************************************

	public static Tree lca(Tree n1, Tree n2) {
		return null;
	}
}