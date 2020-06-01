package family;

public class addPerson {
    String name;
    treeNode left;
    treeNode right;
    int birthDay, birthMonth, birthYear;     //出生日期
    boolean isMarried;      //是否结婚
    String wifeName;
    String address;     //地址
    boolean alive;      //是否健在
    int diedDay, diedMonth, diedYear;     //死亡日期

    treeNode temp;
    treeNode person;
    changePerson cp;

    //构造函数定位到添加人员的父亲
    public addPerson(treeNode root, String fathername, String name){
        search.serchByName ssn =new search.serchByName(fathername);
        ssn.serch(root);
        temp = ssn.temp;
        person = new treeNode(name);
        cp = new changePerson(person);
        cp.changeBir(20,5,1999);
        cp.changeAdr("25-203-3");
        cp.changeMar(true);
        cp.changewife("小笨蛋");
        cp.changeAl(true);
        addToTree(temp);
    }

    //添加到树
    public void addToTree(treeNode tn){
        if (tn.left == null){
            tn.left = person;
        }else {
            addToBro(tn.left);
        }
    }
    public void addToBro(treeNode tn){
        if (tn.right == null){
            tn.right = person;
            return;
        }else {
            addToBro(tn.right);
        }
    }

}
