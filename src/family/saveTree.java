package family;

import java.io.*;
import java.util.ArrayList;

public class saveTree {
    private ArrayList<treeNode> savelist = new ArrayList<treeNode>();
    private ArrayList<treeNode> readlist = new ArrayList<treeNode>();

    //将node保存到list中
    public void saveTolist(treeNode stln){
        if (stln == null){
            return;
        }else{
            savelist.add(stln);
            saveTolist(stln.left);
            saveTolist(stln.right);
        }
    }

    //获取list
    public ArrayList<treeNode> getList(){
        return savelist;
    }

    //将list保存到本地
    public void saveAtLoc(ArrayList<treeNode> alt) throws IOException {
        FileOutputStream fos = new FileOutputStream("src/data/person.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(savelist);
        oos.close();
    }

    //读取list
    public ArrayList<treeNode> readFormLoc()throws IOException,ClassNotFoundException{
        ArrayList<treeNode> temp= new ArrayList<treeNode>();
        FileInputStream fos = new FileInputStream("src/data/person.txt");
        ObjectInputStream ois = new ObjectInputStream(fos);
        temp = (ArrayList<treeNode>)ois.readObject();
        return temp;
    }

}
