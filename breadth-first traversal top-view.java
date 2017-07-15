
int max_left, max_right = 0;
List<Integer> overhead = new ArrayList<>();
Queue<Node> breadth_first = new LinkedList<>();
Queue<Integer>  node_related_position = new LinkedList<>();

void topView(Node root) {
    int current_left = 0;
    int current_right = 0;

    if (root != null) {
        overhead.add(root.data);
        System.out.printf("Node %d Right position %d Left Position %d ||", root.data, 0 , 0);
        transverse (root, 0, 0);
    }

    int right, left;
    
    while (breadth_first.peek()!= null){

        Node current_node = breadth_first.remove();      
        right = node_related_position.remove();
        left = node_related_position.remove();
        System.out.printf("Node %d Right position %d Left Position %d ||", current_node.data, right , left);

        if (right > max_right) {
            max_right = right;
            overhead.add(current_node.data);
        }
        if (left > max_left) {
            max_left = left;
            overhead.add(0,current_node.data);
        }
        transverse (current_node, right, left);
    }

    for (int o : overhead){
        System.out.printf("%d ", o);
    }

}



void transverse ( Node root ,int c_right ,int c_left) {
    if (root.left != null) {
        int l_right = c_right -1;
        int l_left = c_left + 1;
        breadth_first.add(root.left);
        node_related_position.add(l_right);
        node_related_position.add(l_left);

    }

    if (root.right!= null ){
        int r_right = c_right + 1;
        int r_left = c_left - 1;
        breadth_first.add(root.right);
        node_related_position.add(r_right);
        node_related_position.add(r_left);

    }
    


}
