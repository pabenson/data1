package data1finitesets;

public interface BST {
    
    public boolean isEmptyHuh();
    public int cardinality();
    public boolean member(int elt);
    public BST add(int elt);
    public BST remove(int elt);
    public BST union(BST u);
    public BST inter(BST u);
    public BST diff(BST u);
    public boolean equal(BST u);
    public boolean subset(BST u);
    
    
}
