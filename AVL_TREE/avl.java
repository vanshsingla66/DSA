package AVL_TREE;
class Node {
    int key;
    int height;
    Node left, right;

    Node(int key) {
        this.key = key;
        height = 1;
    }
}

public class avl {

    int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    int getbalancefactor(Node node){
        if(node==null){
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    Node rightRotate(Node node){
        Node a = node.left;
        Node b = a.right;

        a.right = node;
        node.left = b;

        a.height = 1+Math.max(height(a.left),height(a.right));
        node.height = 1+Math.max(height(b.left),height(b.right));

        return a;
    }
    Node leftRotate(Node node){
        Node a = node.right;
        Node b = a.left;

        a.left = node;
        node.right = b;

        a.height = 1+Math.max(height(a.left),height(a.right));
        node.height = 1+Math.max(height(b.left),height(b.right));

        return a;
    }
    Node insert(Node node, int key){
        if(node == null){
            return new Node(key);
        }
        if(key<node.key){
            node .left = insert(node.left,key);
        }
        else if(key>node.key){
            node.right = insert(node.right, key);
        }
        else{
            return node;
        }

        node.height = 1+Math.max(height(node.left),height(node.right));

        int balance = getbalancefactor(node);

        if(balance>1 && key<node.left.key){
            return rightRotate(node);
        }
        if(balance>1 && key>node.left.key){
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if(balance<-1 && key>node.right.key){
            return leftRotate(node);
        }
        if(balance<-1 && key<node.right.key){
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }
}
