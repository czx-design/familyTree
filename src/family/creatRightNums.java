package family;

public class creatRightNums {
    treeNode temp;
    int i=0;
    public creatRightNums(treeNode root){
        temp =root;
    }

    public void addNum(treeNode tn){
        if (tn.right!=null){
            temp.rightBrother[i]=tn.right;
            i++;
            addNum(tn.right);
        }
    }

}

