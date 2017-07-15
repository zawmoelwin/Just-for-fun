/*Trying to find the view of the tree from the top.. */


int max_left, max_right = 0;
List<Integer> overhead = new ArrayList<>();

void topView(Node root) {
    int current_left = 0;
    int current_right = 0;

    if (root != null) {
        overhead.add(root.data);
        transverse (root, current_right, current_left);
    }

    for (int o : overhead){
        System.out.printf("%d ", o);
    }

}

void transverse ( Node root ,int current_right ,int current_left) {

    if (root.right!= null ){
        current_right += 1;
        current_left -= 1;
        if (current_right > max_right) {
            max_right = current_right;
            overhead.add(root.right.data);
            transverse (root.right, current_right, current_left);
        }
    }

    if (root.left != null) {
        
        
        current_left += 1;
        current_right -= 1;
        if (current_left > max_left) {

            max_left = current_left;
            overhead.add(0,root.left.data);
            transverse (root.left, current_right, current_left);
        }
    }

}
