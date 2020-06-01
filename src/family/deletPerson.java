package family;

public class deletPerson {
    treeNode temp;


    public deletPerson (treeNode root, String name){
        search.serchByName ssn =new search.serchByName(name);
        ssn.serch(root);
        temp = ssn.temp;
        if ((temp.leftBorther==null)&&(temp.rightfather==null)){
            withRoot(temp);
        }
        if ((temp.right != null)){
            withRight(temp);
        }else if (temp.right == null){
            temp.rightfather = null;
        }
    }

    //存在右边结点兄弟
    public void withRight(treeNode tn){
        treeNode tn1,tn2;
        if (tn.leftBorther != null){
            tn1 = tn.leftBorther;
            tn1.right =tn.right;
        }else if (tn.rightfather != null){
            tn2 = tn.rightfather;
            tn.leftBorther = null;
            tn.rightfather = tn2;
            tn2.left = tn.right;
        }
    }

    //根结点
    public void withRoot(treeNode tn){
        if (tn.right != null){
            tn.right.leftBorther = null;
            tn = tn.right;
        }else {
            System.out.println("该结点不可删除");
        }
    }

}
