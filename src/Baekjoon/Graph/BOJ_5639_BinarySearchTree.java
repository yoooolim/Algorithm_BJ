package Baekjoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_5639_BinarySearchTree {
    static Node head;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Node> element = new ArrayList<>();
        while(true){
            String str = br.readLine();
            if (str == null || str.equals("")) //null인지 먼저 판단해야 하니까 순서 상관 있음
                break;
            element.add(new Node(Integer.parseInt(str),null,null));
        }

        setTree(element);
        postOrder(head);
    }
    static void setTree(ArrayList<Node> ele){
        head=ele.get(0);
        for(int i=1;i<ele.size();i++){
            Node now = ele.get(i);
            Node nowRoot=head;
            while(true){
                if(now==null) return;
                if(now.rootNum < nowRoot.rootNum) {
                    if(nowRoot.left==null) { nowRoot.left = now; break; }
                    nowRoot = nowRoot.left;
                }
                else{
                    if(nowRoot.right==null) { nowRoot.right = now; break; }
                    nowRoot = nowRoot.right;
                }
            }
        }
    }
    static void postOrder(Node now){
        if(now==null) return;
        postOrder(now.left);
        postOrder(now.right);
        System.out.print(now.rootNum+"\n");
    }
    static class Node{
        int rootNum;
        Node left;
        Node right;

        Node(int rootNum, Node left, Node right){
            this.rootNum = rootNum;
            this.left = left;
            this.right = right;
        }
    }
}