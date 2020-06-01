package family;

public class  creatLeftNums{
    treeNode temp;
    int i=0;
    public creatLeftNums(treeNode root){
        temp =root;
    }

    public void addNum(treeNode tn){
        if (tn.left!=null){
            temp.leftchild[i]=tn.left;
            i++;
            addNum(tn.left);
        }
    }
}