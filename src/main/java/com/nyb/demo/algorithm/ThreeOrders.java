package com.nyb.demo.algorithm;


/**
 * @Author:nyb
 * @DESC: 实现二叉树先序，中序，后序遍历
 * 前序遍历首先访问根结点然后遍历左子树，最后遍历右子树
 * 中序遍历首先遍历左子树，然后访问根结点，最后遍历右子树
 * 后序遍历首先遍历左子树，然后遍历右子树，最后访问根结点
 * @Date: Created in 14:18 2020/11/12
 * @Modified By:
 */
public class ThreeOrders {

    public static void main(String[] args) {

    }


    /**
     * 前序遍历首先访问根结点然后遍历左子树，最后遍历右子树
     * @param treeNode
     */
    public static void preOrder(TreeNode treeNode){
        System.out.println(treeNode.val);
        TreeNode left = treeNode.left;
        if (left!=null){
            preOrder(left);
        }
        TreeNode right=treeNode.right;
        if (right!=null){
            preOrder(right);
        }
    }

    /**
     * 中序遍历首先遍历左子树，然后访问根结点，最后遍历右子树
     * @param treeNode
     */
    public static void midOrder(TreeNode treeNode){
        if (treeNode==null){
            return;
        }else {
            midOrder(treeNode.left);
            System.out.println(treeNode.val);
            midOrder(treeNode.right);
        }
    }

    /**
     * 后序遍历首先遍历左子树，然后遍历右子树，最后访问根结点
     * @param treeNode
     */
    public static void postOrder(TreeNode treeNode){
        if (treeNode==null){
            return;
        }else {
            postOrder(treeNode.left);
            postOrder(treeNode.right);
            System.out.println(treeNode.val);
        }
    }


    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
    }
}
