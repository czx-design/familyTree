package family;

public class search {

    //按姓名查找类
    public static class serchByName {

        boolean flag;       //flag判断是否搜索成功
        String name;
        public treeNode temp = new treeNode();

        public serchByName(String name) {
            this.name = name;
            this.flag = false;
        }

        public treeNode getNode(){
            return temp;
        }

        //姓名查找递归函数
        public treeNode serch(treeNode nd) {
            if (nd != null) {
                if (name.trim().equals(nd.name)) {
                    System.out.println("找到" + name);
                    temp = nd;
                    flag = true;
                    return temp;
                } else {

                    serch(nd.left);
                    serch(nd.right);
                    return null;
                }
            } else {
                return null;
            }
        }
    }

    public static class serchByDate{
        boolean flag;       //flag判断是否搜索成功
        int day,month,year;
        public treeNode temp = new treeNode();

        public serchByDate(int day, int month,int year){
            this.day = day;
            this.month = month;
            this. year = year;
            flag = false;
        }

        public treeNode getNode(){
            return temp;
        }

        //日期查找递归函数

        public treeNode serch(treeNode nd) {
            if (nd != null) {
                if ((nd.birthDay == day) && (nd.birthMonth == month) && (nd.birthYear == year)) {
                    temp = nd;
                    System.out.println("找到了在" + temp.birthYear + "年" + temp.birthMonth + "月" + temp.birthDay + "日"+"，出生的：" + temp.name);//查找功能
                    flag = true;
                    return temp;
                } else {
                    serch(nd.left);
                    serch(nd.right);
                    return null;
                }
            } else {
                return null;
            }
        }
    }
}
