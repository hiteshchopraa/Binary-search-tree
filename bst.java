import java.security.PublicKey;
import java.util.*;

import javax.lang.model.util.ElementScanner14;


public class bst {

    public static class Node
    {
        int data;
        Node left;
        Node right;
        Node(int data,Node left,Node right)
        {
            this.data=data;
            this.left=left;
            this.right=right;
        }
    } 
    public static class Pair{
        Node node;
        int state;
        Pair(Node node,int state)
        {
            this.node=node;
            this.state=state;
        }
    }
public static Node construct(int[] arr,int lo,int hi)
{
    if(lo>hi)
    {
        return null;
    }
    int mid=(hi+lo)/2;
    int data=arr[mid];
    Node lc=construct(arr, lo, mid-1);
    Node rc=construct(arr, mid+1, hi);
    Node node=new Node(data,lc,rc);
    return node;
}

public static void display(Node node) {
    if (node == null) {
        return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
}

public static int size(Node node) {
    // write your code here
    if(node==null)
    {
        return 0;
    }
    int l=size(node.left);
    int r=size(node.right);
    
    int t=l+r+1;
    return t;
}

public static int sum(Node node) {
    if(node==null)
    {
        return 0;
    }
    int l=sum(node.left);
    int r=sum(node.right);
    
    int t=l+r+node.data;
    return t;
}

public static int max(Node node) {
    if(node.right==null)
    {
        return node.data;
    }
    else
    {
        return max(node.right);
    } 
    
}

public static int min(Node node) {
    if(node.left==null)
    {
        return node.data;
    }
    else
    {
        return min(node.left);
    } 
      
}

public static boolean find(Node node, int data) {
if(node==null)
{
    return false;
}

if (data > node.data) {
    return find(node.right, data);
} else if (data < node.data) {
    return find(node.left, data);
} else {
    return true;
}
}
public static Node add(Node node,int data)
{
    if(node==null)
    {
        return new Node(data,null,null);
    }
    if(data>node.data)
    {
        node.right=add(node.right,data);
    }
    else if(data<node.data)
    {
        node.left=add(node.left,data);
    }
    else 
    { //nothing to code 
    }
    return node;
}

public static Node remove(Node node, int data) {
    if (node == null) {
        return null;
    }

    if (data > node.data) {
        node.right = remove(node.right, data);
        return node;
    } else if (data < node.data) {
        node.left = remove(node.left, data);
        return node;
    } else {
        if (node.left == null && node.right == null) {
            return null;
        } else if (node.left == null) {
            return node.right;
        } else if (node.right == null) {
            return node.left;
        } else {
            int max = max(node.left);
            node.data = max;
            node.left = remove(node.left, max);
            return node;
        }
    }
}
static int sum=0;

public static void replaceSum(Node node)
{
    if(node==null)
    {
        return;
    }
    replaceSum(node.right);
    int od=node.data;
    node.data=sum;
    sum+=od;
    replaceSum(node.left);
}  
public static int lca(Node node, int d1, int d2) {
    if (d1 < node.data && d2 < node.data) {             //lowest common annes
        return lca(node.left, d1, d2);
    } else if (d1 > node.data && d2 > node.data) {
        return lca(node.right, d1, d2);
    } else {
        return node.data;
    }
}
public static void pir(Node node, int d1, int d2) {
    if (node == null) {
        return;                         //print in range
    }

    if (node.data > d1 && node.data > d2) {
        pir(node.left, d1, d2);
    } else if (node.data < d1 && node.data < d2) {
        pir(node.right, d1, d2);
    } else {
        pir(node.left, d1, d2);
        System.out.println(node.data);
        pir(node.right, d1, d2);
    }
}

    public static void main(String args[])
    {
        int[] arr={10,20,30,40,50,60,70,80};
      Node root=  construct(arr,0,arr.length-1);
        display(root);
        int size = size(root);
        int sum = sum(root);
        int max = max(root);
        int min = min(root);
        boolean found = find(root, 20);


        System.out.println(size);
        System.out.println(sum);
        System.out.println(max);
        System.out.println(min);
        System.out.println(found);

    }
}
