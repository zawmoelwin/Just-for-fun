/*You can consider recursive like asynchronous calls.
Let common_ancester be NaN
while common_ancester is NaN do 
    get the node
        if node_value equals numbers
        	return node_value
        else    
        	if visit left child && visit right child
                visit the node, get value
                assign value
return the value
*/    	
    
static Node lca(Node root,int v1,int v2)
    {
    // need to check if v1 == v2 and return that node
    
    // root is the universal common ancester
    //Node common_ancester = root;
    List<Node> v1_path = new ArrayList<>();
    List<Node> v2_path = new ArrayList<>();

    // there are two strategies.. one is finding the node of one value and from that node on the way back finding the value 2 on child node of that branch.
    // Another is storing the path of each value and see if the node present in another path.
    
    v2_path =  traverse_find(root, v2 , v2_path);
    v1_path =  traverse_find(root, v1 , v1_path);
    
    int i = 0;
    
    while (v1_path.get(i)==v2_path.get(i)){
        i++;
    }
              
   //traverse the tree to find the v1 and v2    
   // need to check smaller or larger to pass the left and right node
    return v1_path.get(i-1);
    }

// assuming the value is present in the tree
static List traverse_find(Node node, int value, List<Node> path ){
    
    path.add(node);
    if ( node.left != null && node.data < value){
        path = traverse_find(node.left,value,  path); 
    } else if (  node.right != null && node.data > value){ 
        path = traverse_find(node.right, value, path);
    }
    
   return path;
}

