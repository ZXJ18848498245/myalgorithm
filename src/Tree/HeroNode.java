package Tree;

public class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    private int leftType;//leftTpye=0表示指向的是左子树，如果为1则表示指向前驱节点
    private int rightType;//rightTpye=0表示指向的是右子树，如果为1则表示指向后驱节点

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
    //前序遍历
    public void preOrder(){
        System.out.println(this);//输出父节点
        //递归左子树前序遍历
        if (this.left!=null){
            this.left.preOrder();
        }
        //递归右子树前序遍历
        if (this.right!=null){
            this.right.preOrder();
        }
    }
    //中序排序
    public void infixOrder(){
        if (this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right!=null){
            this.right.infixOrder();
        }
    }
    //后序排序
    public void postOrder(){
        if (this.left!=null){
            this.left.postOrder();
        }
        if (this.right!=null){
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //前序遍历查找
    public HeroNode preOrderSearch(int no){
        //进入前序查找
        if (this.getNo()==no){
            return this;
        }
        HeroNode resNode = null;
        if (this.left!=null){
            resNode = this.left.preOrderSearch(no);
        }
        //找到
        if (resNode!=null){
            return resNode;
        }
        if (this.right!=null){
            resNode = this.right.preOrderSearch(no);
        }
        return  resNode;
    }
    //中序遍历查找
    public HeroNode infixOrderSearch(int no){
        HeroNode resNode = null;
        if (this.left!=null){
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode!=null){
            return  resNode;
        }
        //进入中序查找
        if (this.getNo()==no){
            return this;
        }
        if (this.right!=null){
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }
    //后序遍历查找
    public HeroNode postOrderSearch(int no){
        HeroNode resNode = null;
        if (this.left!=null){
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode!=null){
            return  resNode;
        }
        if (this.right!=null){
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode!=null){
            return  resNode;
        }
        //进入后序查找
        if (this.getNo()==no){
            return this;
        }
        return resNode;
    }
    //删除结点
    public void delNode(int no){
        if (this.left!=null&&this.left.getNo()==no){
            this.left = null; //直接置为null,不会再遍历后面
            return;
        }
        if (this.right!=null&&this.right.getNo()==no){
            this.right = null;
            return;
        }
        if (this.left!=null){
            this.left.delNode(no);
        }
        if (this.right!=null){
            this.right.delNode(no);
        }
    }
}
