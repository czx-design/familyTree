package family;

import java.util.Calendar;

public class today {
    int day;
    int month;
    int year;
    static boolean flag= false;

    public today(treeNode nd){
        Calendar c = Calendar.getInstance();
        this.day =c.get(Calendar.DATE);
        this.month = c.get(Calendar.MONTH);
        this.year = c.get(Calendar.YEAR);
        search.serchByDate sp = new search.serchByDate(day,month,year);
        sp.serch(nd);
        if (sp.flag){
            System.out.println("Boom！It's "+sp.temp.name+"'s birthday");
            flag =true;
        }
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public boolean getFlag(){
        return flag;
    }
}
