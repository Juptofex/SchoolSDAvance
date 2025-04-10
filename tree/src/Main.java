public class Main {
  public static void main(String[] args){
    Tree l1 = new Tree(1);
    Tree l3 = new Tree(3);
    Tree l5 = new Tree(5);
    Tree l7 = new Tree(7);
    Tree l14 = new Tree(14);
    
    Tree t2 = new Tree(2, new Tree[]{l1, l3});
    Tree t6 = new Tree(6, new Tree[]{l7});
    
    Tree t4 = new Tree(4, new Tree[]{t2, l5, t6});
    Tree t12 = new Tree(12, new Tree[]{t2, l14, t6});

    System.out.println(Trees.nbrLeaves(t4));
    
    
    Tree[] ls = Trees.flattenLeaves(t4);
    System.out.println("Les " + ls.length + " feuilles");
    int i = 0;
    while(i != ls.length) {
      System.out.println(ls[i].getValue());
      i++;
    }

    System.out.println("Path V1");    
    Trees.pathV1(l7);

    System.out.println("Path V2");    
    Trees.pathV2(l7);

    System.out.println("NbrNoeuds");
    System.out.println(Trees.nbrNode(t4));

    System.out.println("Min");
    System.out.println(Trees.min(t4));

    System.out.println("Sum");
    System.out.println(Trees.sum(t4));

    System.out.println("equals true");
    System.out.println(Trees.equals(t4, t4));
    System.out.println("equals false");
    System.out.println(Trees.equals(t4, t6));
    System.out.println("equals false");
    System.out.println(Trees.equals(t4, t12));

    System.out.println("Depth");
    System.out.println(Trees.depth(l1));

    System.out.println("SameOne true");
    System.out.println(Trees.sameOne(t4, l5));

    System.out.println("SameOne false");
    System.out.println(Trees.sameOne(t4, l14));

    System.out.println("DFS");
    Trees.dfsPrint(t4);

    System.out.println("BFS");
    Trees.bfsPrint(t4);
  }
}
