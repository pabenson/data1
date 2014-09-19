package data1finitesets;

import java.util.Random;

public class Data1FiniteSets {

   public static Random random = new Random();

    //Generate random integer using above
    public static int randomInt(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    //Generate random BST
    public static BST randomBST(int count) {
        if (count == 0) {
            return new data1finitesets.Empty();
        } else {
            return randomBST(count - 1).add(randomInt(0, 50));
        }
    }

    //isEmptyCardChecker TEST
    //A tree is either empty or non-empty. When empty, isEmptyHuh returns TRUE
    //and Cardinality == 0
    //When non-empty, isEmptyHuh returns FALSE and Cardinality > 0
    //Anything else means something is wrong
    public static void isEmptyCardChecker(BST u) {
        if (u.isEmptyHuh() && (u.cardinality() == 0)) {
            System.out.println("YES!!! Empty and Cardinality == 0!!!");
        } else if (!u.isEmptyHuh() && (u.cardinality() != 0)) {
            System.out.println("YES!!! Non-Empty and Cardinality > 0");
        } else {
            System.out.println("NO. Something's wrong.");
        }
    }

    //CardAddChecker TEST
    //Cardinality increases by however many elements are added
    //Anything else means something is wrong
    public static void CardAddChecker(int elt, BST u) {
        u = new data1finitesets.Empty();
        for (int i = 0; i < elt; i++) {
            u = u.add(i);
        }
        if (u.cardinality() == elt) {
            System.out.println("YES!!! Cardinality increases by # of elts!");
        } else {
            System.out.println("NO!!! Something's Wrong");
        }
    }

    //CardRemChecker TEST
    //Cardinality decreases by however many elements are removed
    //Anything else means something is wrong
    public static void CardRemChecker(int elt, BST u) {
        u = randomBST(50);
        BST rmvd = u.remove(elt);
        if (rmvd.cardinality() <= u.cardinality()) {
            System.out.println("YES!!! Cardinality decreases by # of elts!");
        } else {
            System.out.println("NO!!! Something's Wrong");
        }
    }

    

    //MemberUnionChekcer TEST
    //By definition of union, whatever elements found in either u or t 
    //are in the Union of u and t
    //Anything else means something is wrong
    public static void MemberUnionChecker(BST u, BST t, int elt) {
        Boolean bool = u.union(t).member(elt);
        if ((bool && u.member(elt)) || (bool && t.member(elt))) {
            System.out.println("YES!!! ELT is a member of the U or T AND "
                    + "is a member of the union");
        } else if (!bool && (!u.member(elt) && !t.member(elt))) {
            System.out.println("YES!!! ELT is not a member of the U or T AND "
                    + "is not a member of the union");
        } else {
            System.out.println("NO!!! Something's Wrong");
        }
    }
    
    //UnionSubsetChecker TEST
    //checks to make sure u and t are subsets of their union
    //Anything else means something is wrong
    public static void UnionSubsetChecker(BST u, BST t){
        BST union = u.union(t);
        if (u.subset(union) && t.subset(union)){
            System.out.println("YES!!! U and T are subsets of their union!");
        } else { 
            System.out.println("NO!!! Something's Wrong");
        }
    }
    
    //AddMemberChecker TEST
    //Checks that an element is a member of u when added
    //Anything else means something is wrong
    public static void AddMemberChecker(BST u){
        int rndelt = randomInt(100,450);
        BST uAdd = u.add(rndelt);
        if(uAdd.member(rndelt) && !u.member(rndelt)){
            System.out.println("YES!!! Added element registers as a member");
        }else {
            System.out.println("NO!!! Something's Wrong");
        }
    }
    
    //MemberInterChecker TEST
    //by definition, the intersection of two sets contains all elements found in 
    //both u and t
    //Using isEmptyHuh => intersection can't be empty if elt is in both u and t
    //Anything else means something's wrong
    public static void MemberInterChecker(BST u, BST t, int elt){
        u = u.add(elt);
        t = t.add(elt);
        if (u.member(elt) && t.member(elt) && u.inter(t).member(elt)){
            System.out.println("YES!!! ELT is in both U and T and the intersection");
        }else if (!u.member(elt) || !t.member(elt) && !u.inter(t).member(elt)){
            System.out.println("YES!!! ELT is not both U and T and not in the intersection");
        }else {
            System.out.println("NO!!! Something's Wrong");
        }
    }
    
    //UnionInterEqualChecker TEST
    //Two sets are equal when Union and intersection are equal
    //Anything else means something's wrong
    public static void UnionInterEqualChecker(BST u, BST t){
        if ((u.union(t).equal(u.inter(t))) && u.equal(t)){
            System.out.println("YES!!! same UNION and INTERS. and are EQUAL");
        }else if ((u.union(t) != u.inter(t)) && !u.equal(t)) {
            System.out.println("YES!!! NOT same UNION and INTERS. and are NOT EQUAL");   
        }else {
            System.out.println("NO!!! Something's Wrong");
        }
    }
    
    //EmptyDiffChecker TEST
    //Two sets are equal if their difference is 0 (empty set)
    //Anything else means something's wrong
    public static void EmptyDiffChecker(BST u, BST t){
        if ((u.diff(t)).isEmptyHuh() && t.diff(u).isEmptyHuh()){
            System.out.println("YES!!! Diff. of U and T is the Empty set");           
        }else if (!(u.diff(t)).isEmptyHuh() && !t.diff(u).isEmptyHuh()){
            System.out.println("YES!!! Diff. of U and T is not the Empty set");  
        }else {
            System.out.println("NO!!! Something's Wrong");
        }
    }
    
    public static void main(String[] args) {

        BST empty1 = new data1finitesets.Empty();
        BST u = randomBST(1);
        BST t = randomBST(5);

            
            System.out.println("\nisEmptyCardCheck:");
            isEmptyCardChecker(empty1);
            isEmptyCardChecker(u);
            isEmptyCardChecker(t);
            isEmptyCardChecker(randomBST(randomInt(0, 100)));
            isEmptyCardChecker(randomBST(randomInt(0, 100)));
            isEmptyCardChecker(randomBST(randomInt(0, 100)));
            
            System.out.println("\nCardAddChecker:");
            CardAddChecker(randomInt(0,10),empty1);
            CardAddChecker(randomInt(0,10),u);
            CardAddChecker(randomInt(0,10),t);
            CardAddChecker(randomInt(0,10),randomBST(randomInt(0, 100)));
            CardAddChecker(randomInt(0,10),randomBST(randomInt(0, 100)));
            CardAddChecker(randomInt(0,10),randomBST(randomInt(0, 100)));
            
            System.out.println("\nCardRemChecker:");
            CardRemChecker(randomInt(0,10),empty1);
            CardRemChecker(randomInt(0,10),u);
            CardRemChecker(randomInt(0,10),t);
            CardRemChecker(randomInt(0,10),randomBST(randomInt(0, 100)));
            CardRemChecker(randomInt(0,10),randomBST(randomInt(0, 100)));
            CardRemChecker(randomInt(0,10),randomBST(randomInt(0, 100)));           
            
            System.out.println("\n MemberUnionChecker:");
             MemberUnionChecker(empty1,empty1,randomInt(0,10));
             MemberUnionChecker(t,u,randomInt(0,10));
             MemberUnionChecker(u,t,randomInt(0,10));
             MemberUnionChecker(randomBST(randomInt(0, 100)),randomBST(randomInt(0, 100)),randomInt(0,10));
               MemberUnionChecker(randomBST(randomInt(0, 100)),randomBST(randomInt(0, 100)),randomInt(0,10));
               MemberUnionChecker(randomBST(randomInt(0, 100)),randomBST(randomInt(0, 100)),randomInt(0,10));
        
           
           System.out.println("\nMemberInterChecker:");
             MemberInterChecker(empty1,empty1,randomInt(0,10));
             MemberInterChecker(t,u,randomInt(0,10));
             MemberInterChecker(u,t,randomInt(0,10));
             MemberInterChecker(randomBST(randomInt(0, 100)),randomBST(randomInt(0, 100)),randomInt(0,10));
             MemberInterChecker(randomBST(randomInt(0, 100)),randomBST(randomInt(0, 100)),randomInt(0,10));
             MemberInterChecker(randomBST(randomInt(0, 100)),randomBST(randomInt(0, 100)),randomInt(0,10));
             
             System.out.println("\nUnionInterEqualChecker:");
             UnionInterEqualChecker(empty1,empty1);
            UnionInterEqualChecker(t,u);
             UnionInterEqualChecker(u,t);
             UnionInterEqualChecker(randomBST(randomInt(0, 100)),randomBST(randomInt(0, 100)));
             UnionInterEqualChecker(randomBST(randomInt(0, 100)),randomBST(randomInt(0, 100)));
             UnionInterEqualChecker(randomBST(randomInt(0, 100)),randomBST(randomInt(0, 100)));
             
             System.out.println("\nEmptyDiffChecker:");
             EmptyDiffChecker(empty1,empty1);
            EmptyDiffChecker(t,u);
             EmptyDiffChecker(u,t);
             EmptyDiffChecker(randomBST(randomInt(0, 100)),randomBST(randomInt(0, 100)));
             EmptyDiffChecker(randomBST(randomInt(0, 100)),randomBST(randomInt(0, 100)));
             EmptyDiffChecker(randomBST(randomInt(0, 100)),randomBST(randomInt(0, 100)));
    }
    
    
}
