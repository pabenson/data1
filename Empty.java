package data1finitesets;

public class Empty implements BST{
    
    Empty(){
        
    }
    
    //EMPTY: Returns a fresh empty set.
    public BST empty(){
        return new Empty();
    }
    
    //IsEmptyHuh: returns true if branch is empty, false otherwise
    public boolean isEmptyHuh(){
        //this is the class for the empty case
        //therefore, this sould always return true
        return true;
    }
    
    //CARDINALITY: Counts and returns number of elts in tree
    public int cardinality(){
        //this is the empty case. This is the empty tree. There are no elements
        return 0;
    }
    
    //MEMBER: return true if ELT is in the Tree
    public boolean member(int elt){
        //empty case = no members
        return false;
    }
    
     //ADD: Add ELT to correct spot in Tree
    public BST add(int elt){
        //add elt as a node because the tree is empty,
        //so elt == first element of tree
        return new NotEmpty(elt,this,this);
    }
    
    //REMOVE: removes ELT from appropriate place in tree
    public BST remove(int elt){
        //you can't remove something from nothing
        //returns empty set
        return this;
    }
    
     //UNION: Returns a set containing everything in t and u.
    public BST union(BST u){
        // because t is empty, the union of t and u contains only u
        return u;
    }
    
    //INTER: Returns a set containing everything that is in both t and u.
    public BST inter(BST u){
        //an intersection can't exist between 
        return this;
    }
    
    //DIFF: Returns a set containing everything in u except those that are in t.
    public BST diff(BST u){
        //nothing is in t (empty case)
        //just return u
        return u;
    }
    
    //EQUAL: Determines if t and u contain the same elements.
    public boolean equal(BST u){
        //t and u only contain the same elements if u is also equal to the empty set
        return u.isEmptyHuh();
    }
    
    //SUBSET: Determines if t is a subset of u.
    public boolean subset(BST u){
        //The empty set is a subset of any set
        //Therefore it is a subset of u
        return true;
    }
}
