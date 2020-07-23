package Tree;

public class ThreadedBinaryTree {
    private HeroNode root;

    //在递归进行线索化时。pre总是保留前一个结点
    private HeroNode pre =null;

    //重载方法
    public void threadedNodes(){
        this.threadedNodes(root);
    }

    //前序遍历线索化二叉树的方法
    public void threadedList2(){
        HeroNode node = root;

        while (node!=null){
            //循环找到leftType==1的结点，第一个找到的就是8结点
            while (node.getLeftType() == 0){
                System.out.println(node);
                node = node.getLeft();
            }

            //如果当前结点的右指针指向的是后继结点，就一直输出
            while (node.getRightType()==1){
                node=node.getRight();
                System.out.println(node);
            }

            //替换这个遍历的结点
            node = node.getRight();
        }
    }
    //中序遍历线索化二叉树的方法
    public void threadedList(){
        HeroNode node = root;

        while (node!=null){
            //循环找到leftType==1的结点，第一个找到的就是8结点
            while (node.getLeftType() == 0){
                node = node.getLeft();
            }

            System.out.println(node);
            //如果当前结点的右指针指向的是后继结点，就一直输出
            while (node.getRightType()==1){
                node=node.getRight();
                System.out.println(node);
            }

            //替换这个遍历的结点
            node = node.getRight();
        }
    }

    //后序遍历线索化二叉树的方法，有错  需要知道父结点
    public void threadedList3(){
        HeroNode node = root;

        while (node!=null){
            //循环找到leftType==1的结点，第一个找到的就是8结点
            while (node.getLeftType() == 0){
                node = node.getLeft();
            }


            //如果当前结点的右指针指向的是后继结点，就一直输出
            while (node.getRightType()==1){
                node=node.getRight();
                System.out.println(node);
            }

            //替换这个遍历的结点
            node = node.getRight();

        }
    }

    //前序线索化结点
    public void threadedNodes2(HeroNode node){
        if (node == null){
            return;
        }
        //处理当前结点的前驱结点
        if (node.getLeft()==null){
            //当前结点的左指针指向前驱结点
            node.setLeft(pre);
            //修改当前结点的左指针类型，指向前驱结点
            node.setLeftType(1);

        }

        //处理后续结点
        if (pre != null&&pre.getRight()==null){
            //让前驱结点的右指针指向当前结点
            pre.setRight(node);
            //修改前去结点的右指针类型
            pre.setLeftType(1);
        }
        //每处理一个结点后，让当前结点是下一个结点的前驱结点
        pre = node;
        //先线索化左子树
        threadedNodes2(node.getLeft());


        //以最左的结点为例 8 结点
        //8结点.left =pre .leftTpye = 1

        //再线索化右子树
        threadedNodes2(node.getRight());
    }
    //中序线索化结点
    public void threadedNodes(HeroNode node){
        if (node == null){
            return;
        }

        //先线索化左子树
        threadedNodes(node.getLeft());

        //处理当前结点的前驱结点
        //以最左的结点为例 8 结点
        //8结点.left =null .leftTpye = 1
        if (node.getLeft()==null){
            //当前结点的左指针指向前驱结点
            node.setLeft(pre);
            //修改当前结点的左指针类型，指向前驱结点
            node.setLeftType(1);

        }

        //处理后续结点
        if (pre != null&&pre.getRight()==null){
            //让前驱结点的右指针指向当前结点
            pre.setRight(node);
            //修改前去结点的右指针类型
            pre.setLeftType(1);
        }
        //每处理一个结点后，让当前结点是下一个结点的前驱结点
        pre = node;

        //再线索化右子树
        threadedNodes(node.getRight());
    }
    //后序线索化结点

    public void threadedNodes3(HeroNode node){
        if (node == null){
            return;
        }

        //先线索化左子树
        threadedNodes(node.getLeft());
        //再线索化右子树
        threadedNodes(node.getRight());
        //处理当前结点的前驱结点
        //以最左的结点为例 8 结点
        //8结点.left =null .leftTpye = 1
        if (node.getLeft()==null){
            //当前结点的左指针指向前驱结点
            node.setLeft(pre);
            //修改当前结点的左指针类型，指向前驱结点
            node.setLeftType(1);

        }

        //处理后续结点
        if (pre != null&&pre.getRight()==null){
            //让前驱结点的右指针指向当前结点
            pre.setRight(node);
            //修改前去结点的右指针类型
            pre.setLeftType(1);
        }
        //每处理一个结点后，让当前结点是下一个结点的前驱结点
        pre = node;


    }
}
