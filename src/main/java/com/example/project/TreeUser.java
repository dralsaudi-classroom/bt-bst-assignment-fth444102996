package com.example.project;

public class TreeUser {
    public static <T> int countLeaves(BT<T> bt) {
    	
    	if(bt.empty())
    		return 0;
    	bt.find(Relative.Root);
    	return RCL(bt);
    	
		// Write the method countLeafs that should return the number of leaf nodes in the tree. A leaf node is a node that has no children.
        // assume the following method exists in the ADT: isLeaf (boolean flag): requires: Binary tree is not empty.
        // input: None. results: if the current node of the binary tree is a leaf then flag is set to true otherwise it is set to false. output: flag.
        // you can't call countLeaves from BT.java
    }
    
    public static <T> int RCL(BT<T> bt) {
    	
    	boolean l, r;
    	int il, ir;
    	
    	if(bt.isLeaf()) 
    		return 1;
    	
    	l = bt.find(Relative.LeftChild);
    	if(l)
    		bt.find(Relative.Parent);
    	r = bt.find(Relative.RightChild);
    	if(r) 
    		bt.find(Relative.Parent);
    	
    	if(l&&r) {
    		bt.find(Relative.LeftChild);
    		il = RCL(bt);
    		bt.find(Relative.Parent);
    		bt.find(Relative.RightChild);
    		ir = RCL(bt);
    		return il+ir;
    	}
    	if(l&&!r) {
    		bt.find(Relative.LeftChild);
    		return RCL(bt);
    	}
    	if(!l&&r) {
    		bt.find(Relative.RightChild);
    		return RCL(bt);
    	}
    	
    	return 0;
    	
    }
    
    
    
    
    
    
    
    
    
}