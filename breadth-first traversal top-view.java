class QItem
{
   Node node;
   int r_hd;
   int l_hd;
   public QItem(Node n, int r_h, int l_h)
   {
        node = n;
        r_hd = r_h;
        l_hd = l_h;
   }
}

int max_left, max_right = 0;
List<Integer> overhead = new ArrayList<>();
Queue<QItem> breadth_first = new LinkedList<>();
HashSet<Integer> set = new HashSet<>();
Queue<Integer>  node_related_position = new LinkedList<>();

void topView(Node root) {
    if (root == null) {  return;  }
    
    else {
        overhead.add(root.data);
        set.add(0);
        transverse (root, 0, 0);
    }

    int right, left;
    Node current_node;
    while (breadth_first.peek()!= null){

        QItem current_queue = breadth_first.remove();
        current_node = current_queue.node;
        right = current_queue.r_hd;
        left = current_queue.l_hd;
        int hd;
        
        if ( Math.abs(left)>right )  hd=left; else hd = right;
            if (!set.contains(hd)){
                set.add(hd);
               if (hd > max_right) {
                    max_right = hd;
                    overhead.add(current_node.data);
                }
                if (hd < max_left) {
                    max_left = hd;
                    overhead.add(0,current_node.data);
                }
                
            }
        
        transverse (current_node, right, left);
    }
    Iterator<Integer> itr = set.iterator();
            while(itr.hasNext()){
                System.out.println(" Iterating over HashSet :" + itr.next());
            }
    for (int o : overhead){
        System.out.printf("%d ", o);
    }
}



void transverse ( Node root ,int c_right ,int c_left) {
    
    if (root.left != null) {
        int l_right = c_right -1;
        int l_left = c_left + 1;
        QItem q = new QItem(root.left, l_right, l_left );
        breadth_first.add(q);
        //node_related_position.add(l_right);
        //node_related_position.add(l_left);
    }

    if (root.right!= null ){
        int r_right = c_right + 1;
        int r_left = c_left - 1;
        QItem r = new QItem(root.right, r_right, r_left );
        breadth_first.add(r);
    }
}
