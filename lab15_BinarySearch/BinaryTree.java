import java.util.ArrayList;
import java.util.*; 

public class BinaryTree {

    private TreeNode myRoot;

    public BinaryTree() {
        myRoot = null;
    }

    public BinaryTree(TreeNode t) {
        myRoot = t;
    }
    
    public TreeNode getRoot() {
    	return myRoot;
    }

    public void print() {
    	if (myRoot != null) {
    	myRoot.print(0);
    	}
    	else
    	{
    		myRoot.print(myRoot.height());
    	}
    }
    
    // Print the values in the tree in preorder: root value first,
    // then values in the left subtree (in preorder), then values
    // in the right subtree (in preorder).
    public void printPreorder() {
        if (myRoot == null) {
            System.out.println("(empty tree)");
        } else {
            myRoot.printPreorder();
            System.out.println();
        }
    }

    // Print the values in the tree in inorder: values in the left
    // subtree first (in inorder), then the root value, then values
    // in the right subtree (in inorder).
    public void printInorder() {
        if (myRoot == null) {
            System.out.println("(empty tree)");
        } else {
            myRoot.printInorder();
            System.out.println();
        }
    }
    
    public int height() 
    {
    	if (myRoot != null)
    	{
    		myRoot.height(); 
    	}
    	return 0; 
    }
    
    public void isOK() {
    	if(myRoot == null){
    		System.out.println("empty tree but still legal!");
    	} else {
    		myRoot.isOK(myRoot); 		
    	}
    }
    
//     Return the tree corresponding to the given arithmetic expression.
//     The expression is legal, fully parenthesized, contains no blanks, 
//     and involves only the operations + and *.
    private TreeNode exprTreeHelper (String expr) {
        if (expr.charAt (0) != '(') {
            // YOUR CODE HERE
        	return(new TreeNode(expr));
        } else {
            // expr is a parenthesized expression.
            // Strip off the beginning and ending parentheses,
            // find the main operator (an occurrence of + or * not nested
            // in parentheses, and construct the two subtrees.
            int nesting = 0;
            int opPos = 0;
            for (int k = 1; k < expr.length() - 1; k++) {
                // YOUR CODE HERE
            	if(expr.charAt(k) == '(')
            		nesting += 1;
            	if(expr.charAt(k) == ')')
            		opPos += 1;
            	else
            	{
            		if ((nesting == opPos) && (expr.charAt(k) == '+' || expr.charAt(k) == '*'))
            		{
            				opPos = k;
            				break;	
            		
            		}
            	}
            }
            String opnd1 = expr.substring (1, opPos);
            String opnd2 = expr.substring (opPos+1, expr.length()-1);
            String op = expr.substring (opPos, opPos+1);
            System.out.println ("expression = " + expr);
            System.out.println ("operand 1 = " + opnd1);
            System.out.println ("operator = " + op);
            System.out.println ("operand 2 = " + opnd2);
            System.out.println ( );
            // YOUR CODE HERE
            return(new TreeNode(op, exprTreeHelper(opnd1), exprTreeHelper(opnd2)));
        }
    }
 
    
    
    private TreeNode fibTreeHelper (int n){
    	TreeNode myNode;
    	if(n == 0 || n == 1)
    		myNode = new TreeNode(1);
    	else {
    		Integer x = (Integer) fibTreeHelper(n-1).myItem;
    		Integer y = (Integer) fibTreeHelper(n-2).myItem;
    		myNode = new TreeNode(x+y, fibTreeHelper(n-1), fibTreeHelper(n-2));
    	}
    	return myNode; 	
    }
    
    public void optimize()
    {
    	if(myRoot != null){
    		myRoot.optimize();
    	}
    	return; 
    }

    public void fillSampleTree1() {
        myRoot = new TreeNode("a", new TreeNode("b"), new TreeNode("c"));
    }

    public void fillSampleTree2() {
        myRoot = new TreeNode("a", new TreeNode("b", new TreeNode("d",
                new TreeNode("e"), new TreeNode("f")), null), new TreeNode("c"));
    }
    
    public void fillSampleTree3() {
    	TreeNode sharedNode = new TreeNode("bad");
    	myRoot = new TreeNode("a", new TreeNode("b", null, sharedNode), 
    			              new TreeNode("c", sharedNode, null));
    }
    
    
    
    public static BinaryTree fibTree (int n) {
	  	BinaryTree result = new BinaryTree();
	  	result.myRoot = result.fibTreeHelper (n);
	  	return result;
	  }
    
    public static BinaryTree exprTree (String s) {
        BinaryTree result = new BinaryTree();
        result.myRoot = result.exprTreeHelper (s);
        return result;
    }
    
    public static void main(String[] args) {
        BinaryTree t;
        t = new BinaryTree();
        print(t, "the empty tree");
        t.fillSampleTree1();
        print(t, "sample tree 1");
        t.fillSampleTree2();
        print(t, "sample tree 2");
        
        BinaryTree myTree = new BinaryTree();
        myTree.fillSampleTree2();
        try {
             myTree.isOK();
        } catch (IllegalStateException e) {
        	System.out.println("First Its Illegal!");
        }
        
        
        myTree.fillSampleTree3();
        try {
            myTree.isOK();
       } catch (IllegalStateException e) {
       	System.out.println("Second Its Illegal!");
       }
       
 
        
     
    }


    
    
    private static void print(BinaryTree t, String description) {
        System.out.println(description + " in preorder");
        t.printPreorder();
        System.out.println(description + " in inorder");
        t.printInorder();
        
       
        System.out.println(description + " indented");
        t.print();
    }

    
    
    
    
    private static class TreeNode {

        public Object myItem;
        public TreeNode myLeft;
        public TreeNode myRight;

        public TreeNode(Object obj) {
            myItem = obj;
            myLeft = myRight = null;
        }
        
        public TreeNode(Object obj, TreeNode left, TreeNode right) {
            myItem = obj;
            myLeft = left;
            myRight = right;
        }
        
        private void printPreorder() {
            System.out.print(myItem + " ");
            if (myLeft != null) {
                myLeft.printPreorder();
            }
            if (myRight != null) {
                myRight.printPreorder();
            }
        }

        private void printInorder() {
            if (myLeft != null) {
                myLeft.printInorder();
            }
            System.out.print(myItem + " ");
            if (myRight != null) {
                myRight.printInorder();
            }
        }
        
        private static final String indent1 = "    ";

        private void print(int indent) {
	        // YOUR CODE HERE
        	if(myRight != null)
        		myRight.print(indent+1);
	        println(myItem, indent);
	        // YOUR CODE HERE
	        if(myLeft != null)
	        	myLeft.print(indent+1);
        }

        private static void println (Object obj, int indent) {
	        for (int k = 0; k < indent; k++) {
	        	System.out.print(indent1);
	        }
	        	System.out.println (obj);
        }
        
       private ArrayList<TreeNode> alreadyseen = new ArrayList<TreeNode>();
        private void isOK (TreeNode obj) throws IllegalStateException{
        	if(alreadyseen.contains(obj)){
        		throw new IllegalStateException("Illegal Tree!");
        	} else{
        		alreadyseen.add(obj);
        		if(myLeft != null)
        		obj.isOK(myLeft);
        		if(myRight != null)
        		obj.isOK(myRight); 		
        	}
        }
        
       
        public void optimize()
        {
        	if (myLeft != null){
        		myLeft.optimize();
        	}
        	if (myRight != null){
        		myRight.optimize();
        	}
        	if(myRight == null || myLeft == null){
        		return; 
        	} 
        	else{
	        	try{
	        		String StringLeft = (String) myLeft.myItem; // parse left integer
	            	String StringRight = (String) myRight.myItem;// parse right integer
	                int numLeft = Integer.parseInt(StringLeft);
	                int numRight = Integer.parseInt(StringRight);
	          
		            if (myItem.equals("*")){
		            	myItem = "" + (numLeft * numRight); 
		            		myLeft = myRight = null;
		            	} 
		            	else if (myItem.equals("+")){
		            		myItem = "" + (numLeft + numRight);
		            		myLeft = myRight = null;
		            	}
	            	} catch (NumberFormatException e){
	            		return;
	            	}
        	}
        }
        
        
        public int height() 
        {
        	TreeNode left = this.myLeft; 
        	TreeNode right = this.myRight; 
        	int countLeft = 0; 
        	int countRight = 0; 
        	if (this.myItem == null)
        	{
        		return 0; 
        	}
        	if (left == null && right == null)
        		return 1; 
        	if (left != null)
        	{
        		countLeft = countLeft + left.height();		 
        	}
        	if (right != null)
        	{
        		countRight = countRight + right.height(); 
        	}
        	if (countRight < countLeft)
        	{
        		return countLeft + 1; 
        	}
        	else
        	{
        		return countRight + 1; 
        	}
        }
    }
}
             
 
