
public class BinarySearchTree {

    private Node root;
    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(Node root) {
        this.root = root;
    }
    public Node getRoot() {
        return root;
    }
    public void setRoot(Node root) {
        this.root = root;
    }

    /**
     * Insert a new node with the given 'key' into the tree.
     * @param key
     */
    public void insert(int key) {
        recursiveInsert(key, root);
    }

    /**
     * Insert a new node with the given 'key' into the subtree in the proper position.
     * @param key
     * @param n
     */
    private void recursiveInsert(int key, Node n) {
        if (n == null){
            setRoot(new Node(key,null,null));
        }
        else{
            if (key > n.getKey()) if (n.getRightChild() == null) n.setRightChild(new Node(key,null,null));else recursiveInsert(key,n.getRightChild());else if (key < n.getKey()) if (n.getLeftChild() == null) n.setLeftChild(new Node(key,null,null));else recursiveInsert(key,n.getLeftChild());
        }

    }

    /**
     * Searches the tree and returns the Node which the 'key' value.
     * @param key
     * @return the node with the value 'key', or null if no node is found
     */
    public Node search(int key) {
        return recursiveSearch(key, root);
    }
    /**
     * Searches the subtree starting at node n. Returns the Node which the 'key' value.
     * @param key
     * @param n
     * @return the node with the value 'key', or null if no node is found
     */
    private Node recursiveSearch(int key, Node n){
        if (n == null)
            return null;
        if (n.getKey() == key)
            return n;
        Node node = recursiveSearch(key,n.getLeftChild());
        if (node == null)
            return (recursiveSearch(key,n.getRightChild()));
        return node;
    }

    /**
     * Print the 'key' values in order. See the assignment description for more details.
     */
    public void inOrderTraversal() {
        recursiveInOrderTraversal(root);
    }

    /**
     * Prints the 'key' values from the subtree rooted at 'n' in order.
     * @param n
     */
    public void recursiveInOrderTraversal(Node n) {
        if (n != null){
            recursiveInOrderTraversal(n.getLeftChild());
            System.out.println(n.getKey());
            recursiveInOrderTraversal(n.getRightChild());
        }
    }

    /**
     * Returns the minimum value of the tree.
     * @return
     */
    public int min() {
        return recursiveMin(root);
    }
    /**
     * Recursive method, returns the minimum value of the subtree rooted at n.
     * Assumes that the root is not null
     * @param n
     * @return
     */
    private int recursiveMin(Node n) {
        if (n.getLeftChild() == null)
            return n.getKey();
        return recursiveMin(n.getLeftChild());

    }

    /**
     * Returns the maximum value of the tree
     * @return
     */
    public int max() {
        return recursiveMax(root);
    }
    /**
     * Recursive method, returns the maximum value of the subtree rooted at n.
     * @param n
     * @return
     */
    private int recursiveMax(Node n) {
        if (n.getRightChild() == null)
            return n.getKey();
        return recursiveMax(n.getRightChild());
    }


}