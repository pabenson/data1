package data1finitesets;

public class NotEmpty implements BST {

    int node;
    BST left;
    BST right;

    //constructor method for NotEmpty
    NotEmpty(int node, BST left, BST right) {
        this.node = node;
        this.left = left;
        this.right = right;
    }

    //ISEMPTYHUH: returns true if branch is empty, false otherwisee
    public boolean isEmptyHuh() {
        return false;
        // This is the not empty case so isEmptyHuh will never return true 
        // from this class
    }

    //CARDINALITY: Counts and returns number of elts in tree
    public int cardinality() {
        return left.cardinality() + right.cardinality() + 1;
        // Elts in the left, elts in the right, and plus one for the node
    }

    //MEMBER: return true if ELT is in the Tree
    public boolean member(int elt) {
        if (elt == node) {
            // When the present node is the same as elt
            // Return true
            return true;
            // When elt is greater than the present node
        } else if (elt > node) {
            // Recusrsively check through the right branch of the tree
            return right.member(elt);
            // When elt is less than the present node
        } else {
            //Recusrsively check through the left branch of the tree
            return left.member(elt);
        }
    }

    //ADD: Add ELT to correct spot in Tree
    public BST add(int elt) {
        // If elt is equal to the present node
        if (elt == node) {
            // retrun BST, as is
            return this;
            // Else: determine if it is greater than or less than present node
            // If greater
        } else if (elt > node) {
            // create new NotEmpty and resursively check to find where it "fits"
            return new NotEmpty(node, left, right.add(elt));
            // If less
        } else {
            // do the same but go left
            return new NotEmpty(node, left.add(elt), right);
        }
    }

    //REMOVE: removes ELT from appropriate place in tree
    public BST remove(int elt) {
        // if ELT is equal to present node
        if (elt == node) {
            // return the union of left and right
            return left.union(right);
            // if ELT is greater than present node
        } else if (elt > node) {
            // retrun a new NotEmpty  and recursively search through the left branch 
            // for ELT
            return new NotEmpty(node, left.remove(elt), right);
            //Else
        } else {
            // return a new NotEmpty and recursively search through the right branch 
            // for ELT
            return new NotEmpty(node, left, right.remove(elt));
        }
    }

    //UNION: Returns a set containing everything in t and u.
    public BST union(BST u) {
        // retrun new BST that is union of everything
        return left.union(right.union(u).add(this.node));
    }

    //INTER: Returns a set containing everything that is in both t and u.
    public BST inter(BST u) {
        // if node is a member of BST u
        if (u.member(node)) {
            // return new NotEmpty wiht root included in the intersection
            return new NotEmpty(node, left.inter(u), right.inter(u));
            //else
        } else {
            //return a completely new BST with values in both right and left
            return left.inter(u).union(right.inter(u));
        }
    }

    //DIFF: Returns a set containing everything in u except those that are in t.
    public BST diff(BST u) {
        // if node is a member of BST u
        if (u.member(node)) {
            //return union of left and right, recursively call on DIFF (w/o node)
            return left.union(right).diff(u.remove(node));
            //else
        } else {
            // return the union of left and right and recursively call on DIFF
            return left.union(right).diff(u);
        }
    }

    //EQUAL: Determines if t and u contain the same elements.
    public boolean equal(BST u) {
        //because two sets are defined as equal only when they're subsets of one another
        return this.subset(u) && u.subset(this);
    }

    //SUBSET: Determines if t is a subset of u.
    public boolean subset(BST u) {
        // if node is a member of u
        if (u.member(node)) {
            //recursively check through rest of tree
            return this.left.union(this.right).subset(u);
            //else
        } else {
            //t is not a subset of u, therefore return false 
            return false;
        }
    }
}
