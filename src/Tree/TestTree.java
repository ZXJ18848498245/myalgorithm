package Tree;


public class TestTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        HeroNode root = new HeroNode(1,"小明");
        HeroNode heroNode2 = new HeroNode(2,"小红");
        HeroNode heroNode3 = new HeroNode(3,"小西");
        HeroNode heroNode4 = new HeroNode(4,"小米");
        HeroNode heroNode5 = new HeroNode(5,"小张");

        root.setLeft(heroNode2);
        root.setRight(heroNode3);
        heroNode2.setRight(heroNode4);
        heroNode3.setLeft(heroNode5);

        binaryTree.setRoot(root);

        System.out.println("前序遍历");
        binaryTree.preOrder();//1 2 4 3 5

        System.out.println("中序遍历");
        binaryTree.infixOrder();//2 4 1 5 3

        System.out.println("后序排序");
        binaryTree.postOrder(); // 4 2 5 3 1

        binaryTree.postOrderSearch(4);


    }
}
