import java.util.Map;
import java.util.HashMap;


class BNode{
    public int data;
    public BNode left;
    public BNode right;

    public BNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Btree{
    public BNode root;
    
    public void add(int data){
        if(root == null){
            root = new BNode(data);
            return;
        }
        
        BNode current = root;
        while(current != null){
            if(data < current.data && current.left != null){
                current = current.left;
            }
            else if(data >= current.data && current.right != null){
                current = current.right;
            }
            else if(data < current.data && current.left == null){
                current.left = new BNode(data);
                break;
            }
            else if(data >= current.data && current.right == null){
                current.right = new BNode(data);
                break;
            }
            
        }
    }
    
    public void printInOrder(){
        _printInOrder(root);
        System.out.println("");
    }

    private void _printInOrder(BNode node){
        if(node == null)
            return;

        _printInOrder(node.left);
        System.out.print(node.data + ",");
        _printInOrder(node.right);
        
    }
    
    public void printPreOrder(){
        _printPreOrder(root);
        System.out.println("");
    }

    private void _printPreOrder(BNode node){
        if(node == null)
            return;
        System.out.print(node.data + ",");
        _printPreOrder(node.left);
        _printPreOrder(node.right);
    }
    
    
    public void printPostOrder(){
        _printPostOrder(root);
        System.out.println("");
    }

    private void _printPostOrder(BNode node){
        if(node == null)
            return;
        _printPreOrder(node.left);
        _printPreOrder(node.right);
        System.out.print(node.data + ",");
    }
}

public class Btree{

     public static void main(String []args){
           Btree bTree = new Btree();
           
           bTree.add(30);
           bTree.add(40);
           bTree.add(35);
           bTree.add(50);
           bTree.add(55);
           bTree.add(15);
           bTree.add(25);
           bTree.add(35);
           bTree.printInOrder();
           bTree.printPreOrder();
     }
}
