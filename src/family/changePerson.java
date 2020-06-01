package family;

public class changePerson {
    treeNode temp;

    public changePerson(treeNode tn){
        this.temp = tn;
    }

    //出生日期
    public void changeBir(int d, int m, int y){
        temp.birthDay = d;
        temp.birthMonth = m;
        temp.birthYear = y;
    }

    //地址
    public void changeAdr( String ad){
        temp.address = ad;
    }

    //婚姻状态
    public void changeMar(  boolean im){
        temp.isMarried = im;
    }

    //配偶姓名
    public void changewife( String wn){
        if (temp.isMarried){
            temp.wifeName = wn;
        }else {
            temp.wifeName = null;
        }
    }

    //健在状态
    public void changeAl( boolean al){
        temp.alive =al;
        if (!al){
            temp.diedDay = temp.diedMonth = temp.diedYear = 0;
        }
    }

    //死亡日期
    public void changeDied( int d, int m,int y){
        temp.diedDay = d;
        temp.diedMonth = m;
        temp.diedYear = y;
    }

}
