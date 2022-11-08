 
class Node {
 
    int data;
    Node left, right;
 
    Node(int val)
    {
        data = val;
        left = right = null;
    }
}
 
class BinarySearchTree {
 
    
    Node root;
 
    
    BinarySearchTree() { root = null; }
    void insert(int key) { root = insertRec(root, key); }
 
    
    Node insertRec(Node root, int data)
    {
 
        
        if (root == null) {
            root = new Node(data);
            return root;
        }
 
        
        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);
 
        return root;
    }
   
    boolean isPairPresent(Node root, Node temp, int target)
    {
        if (temp == null)
            return false;
 
        return search(root, temp, target - temp.data)
            || isPairPresent(root, temp.left, target)
            || isPairPresent(root, temp.right, target);
    }
 
    boolean search(Node root, Node temp, int k)
    {
 
        if (root == null)
            return false;
 
        Node c = root;
        boolean flag = false;
        while (c != null && flag != true) {
            if (c.data == k && temp != c) {
                flag = true;
                System.out.println("Pair Found: " + c.data
                                   + " + " + temp.data);
                return true;
            }
            else if (k < c.data)
                c = c.left;
            else
                c = c.right;
        }
 
        return false;
    }
 
    public static void main(String[] args)
    {
        BinarySearchTree tree = new BinarySearchTree();
       
        tree.insert(40);
        tree.insert(20);
        tree.insert(60);
        tree.insert(10);
        tree.insert(30);
        tree.insert(50);
        tree.insert(70);
 
        boolean test
            = tree.isPairPresent(tree.root, tree.root, 1000);
        if (!test)
            System.out.println("No such Notes are found!");
    }
}
