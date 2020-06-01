package family;

import java.util.ArrayList;
import java.util.List;

public class findTogether {

    public static treeNode findCommonNode(List<treeNode> path1, List<treeNode> path2){
        treeNode result = path1.get(0);
        int temp = 0;
        while(temp<path1.size() && temp<path2.size() && path1.get(temp) == path2.get(temp)){
            result = path1.get(temp);
            temp++;
        }
        return result;
    }

    //先序遍历找到目标结点的路径
    public static boolean getPath(treeNode root, treeNode node, List<treeNode> path){
        if(root!=null){
            path.add(root);
        }
        if(node == root){
            return true;
        }
        if(root == null){
            return false;
        }
        boolean found = getPath(root.left,node,path);
        if(!found){
            found = getPath(root.right, node,path);
        }
        if(!found){
            path.remove(path.size()-1);
        }
        return found;
    }

    //找到两个结点的最近公共祖先
    public static treeNode findNode(treeNode root, String name1, String name2){
        treeNode firstNode,secondNode;
        List<treeNode> path1 = new ArrayList<treeNode>();
        List<treeNode> path2 = new ArrayList<treeNode>();
        boolean flag1 = false;
        boolean flag2 = false;
        search.serchByName ssn1 =new search.serchByName(name1);
        ssn1.serch(root);
        firstNode = ssn1.temp;
        search.serchByName ssn2 =new search.serchByName(name2);
        ssn2.serch(root);
        secondNode = ssn2.temp;
        flag1 = getPath(root,firstNode,path1);
        flag2 = getPath(root,secondNode,path2);
        if(flag1 == false || flag2 == false){
            return null;
        }
        return findCommonNode(path1,path2);
    }


}
