package family;



import Interface.signFace;

import java.io.IOException;
import java.io.Serializable;

public class treeNode implements Serializable {

    private static String pd = "陈智鑫;周奕飞;王智明;#;#;卢姓康;胡世聪;#;#;#;#";
    private static String personData[] = pd.toString().split(";");
    private static int i = 0, n = personData.length;

    String name;
    treeNode left;
    treeNode right;
    treeNode rightfather;
    treeNode leftBorther;
    treeNode[] leftchild;
    treeNode[] rightBrother;
    int birthDay, birthMonth, birthYear;     //出生日期
    boolean isMarried;      //是否结婚
    String wifeName;
    String address;     //地址
    boolean alive;      //是否健在
    int diedDay, diedMonth, diedYear;     //死亡日期

    public treeNode(String n, treeNode l, treeNode r) {
        this.name = n;
        this.left = l;
        this.right = r;
    }

    public String getName(){
        return name;
    }
    public String getWifeName(){
        return wifeName;
    }
    public int getBirthDay(){
        return birthDay;
    }
    public int getBirthMonth(){
        return birthMonth;
    }
    public int getBirthYear(){
        return birthYear;
    }
    public boolean getisMarried(){
        return isMarried;
    }
    public String getAddress(){
        return address;
    }
    public boolean getAlive(){
        return alive;
    }
    public int getDiedDay(){
        return diedDay;
    }
    public int getDiedMonth(){
        return diedMonth;
    }
    public int getDiedYear(){
        return diedYear;
    }
    public treeNode getLeft(){return left;}
    public treeNode getRight(){return right;}

    //构造函数进行结点赋值
    public treeNode(String name) {
        this.name = name;
    }

    public treeNode() {
        this.name = null;
    }

    //更改成员姓名
    public void changeName(String name) {
        this.name = name;
    }

    //先序建立二叉树
    public static treeNode creatTree() {
        treeNode tn = null;
        String s = "#";
        if (i < n) {
            s = personData[i++];
        } else {
            return null;
        }
        if (s.trim().equals("#")) {
            //tn =new treeNode("#",null,null);
            return tn;
        } else {
            tn = new treeNode(s);
            tn.left = creatTree();
            tn.right = creatTree();
            return tn;
        }
    }

    //实现树结点双向链接
    public static void bothWay(treeNode nd){
        if ((nd != null) && (nd.left != null) ) {
            nd.left.rightfather = nd;
        }
        if ((nd != null) && (nd.right != null) ){
            nd.right.leftBorther = nd;
        }
    }

    //先序遍历链接反向结点
    public static void preLink(treeNode nd){
        if (nd != null) {
            bothWay(nd);
            preLink(nd.left);
            preLink(nd.right);
        }
    }

    //先序遍历测试检查二叉树
    public static void prePrintTree(treeNode tn) {
        if (tn == null) {
            System.out.print(" # ");
        } else {
            System.out.print(tn.name + " ");
            prePrintTree(tn.left);
            prePrintTree(tn.right);
        }
    }


    public static int bortherNum(treeNode tn){
        if (tn.right != null){
            bortherNum(tn.right);
            return 1;
        }else {
            return 0;
        }
    }        //兄弟结点数

    public static void preGetNum(treeNode tn){
        if (tn!= null){
            creatRightNums crn=new creatRightNums(tn);
            creatLeftNums cln = new creatLeftNums(tn);
            crn.addNum(tn);
            cln.addNum(tn);
            preGetNum(tn.left);
            preGetNum(tn.right);
        }else {
            return;
        }
    }


    //获取同辈数组
    public static String[] changeToEasy(treeNode tn){
        int i=0;
        StringBuffer a =new StringBuffer();
        treeNode temp = tn;
        while (temp != null){
            a.append(temp.right.name);
            a.append(";");
            i++;
            temp = temp.right;
        }
        String b[] = a.toString().split(";");
        return b;
    }


    //获取每一个结点的同辈


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        saveTree st = new saveTree();
        //treeNode root = creatTree();
        treeNode root = new treeNode();
        treeNode temp = new treeNode();
        for (treeNode tn : st.readFormLoc()){
            System.out.println(tn.name);
        }
        root = st.readFormLoc().get(0);
        preLink(root);
        //treeNode node = st.readFormLoc().get(0);
        prePrintTree(root);
        //preGetNum(root);
        /*st.saveTolist(root);
        st.saveAtLoc(st.getList());*/

        /*search.serchByName ssn =new search.serchByName("周奕飞");
        ssn.serch(root);
        temp = ssn.temp;
        changePerson cp =new changePerson(temp);
        cp.changeBir(25,1,1999);
        cp.changeAdr("25-203-2");
        cp.changeMar(true);
        cp.changeAl(true);
        cp.changewife("小吴");
        System.out.println(temp.wifeName);*/

        //new addPerson(root,"周奕飞", "熊立鹏");//添加成员（树根结点，父亲名称，待添加成员名称）

        //new deletPerson(root,"熊立鹏");      //删除成员

        st.saveTolist(root);
        st.saveAtLoc(st.getList());

        /*treeNode anc = new treeNode();
        anc = findTogether.findNode(root,"周奕飞","王智明");*/

        System.out.println("ok" );
        new signFace(root);
    }
}
