package Baekjoon.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1991_TreeTraversal {
    static int nodeNum;
    static ArrayList<Node> tree;
    static StringBuilder sb;
    static boolean[] notRoot;
    static boolean[] visited;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nodeNum = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        sb = new StringBuilder();
        notRoot = new boolean[nodeNum];
        visited = new boolean[nodeNum];
        for(int i=0;i<nodeNum;i++) tree.add(new Node(i,null,null));
        for(int i=0;i<nodeNum;i++) {
            String str = br.readLine();
            int a = str.charAt(0)-'A';
            int b = str.charAt(2)-'A';
            int c = str.charAt(4)-'A';
            if(b>=0) {
                tree.get(a).leftChild = tree.get(b);
                notRoot[b]=true;
            }
            if(c>=0) {
                tree.get(a).rightChild = tree.get(c);
                notRoot[c]=true;
            }
        }
        Node root=null;
        for(int i=0;i<nodeNum;i++){
            if(notRoot[i]==true) continue;
            root = tree.get(i);
            break;
        }

        preorder(root);
        sb.append("\n");
        inorder(root);
        sb.append("\n");
        postorder(root);
        System.out.print(sb);
    }
    static class Node{
        int node;
        Node leftChild;
        Node rightChild;
        Node(int node, Node leftChild, Node rightChild){
            this.node = node;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }
    static void preorder(Node node){
        sb.append((char)(node.node+'A')+" ");
        if(node.leftChild!=null) preorder(node.leftChild);
        if(node.rightChild!=null) preorder(node.rightChild);
    }
    static void postorder(Node node){
        if(node.leftChild!=null) postorder(node.leftChild);
        if(node.rightChild!=null) postorder(node.rightChild);
        sb.append((char)(node.node+'A')+" ");
    }
    static void inorder(Node node){
        if(node.leftChild!=null) inorder(node.leftChild);
        sb.append((char)(node.node+'A')+" ");
        if(node.rightChild!=null) inorder(node.rightChild);
    }
}
