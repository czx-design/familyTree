package Interface;

import family.search;
import family.treeNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class showInfByDate extends JFrame {
    JLabel  namel, addl, marryl, wifel, alivel, birthl, diedl;
    JLabel  addt, alivet, marryt, wifet, namet, birtht, diedt;
    JButton sea;

    public showInfByDate(treeNode root,int d,int m,int y){
        treeNode temp = root;
        search.serchByDate ssn =new search.serchByDate(d,m,y);
        ssn.serch(temp);
        temp = ssn.getNode();

        this.setTitle("依据日期查询");
        this.setSize(250, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setBackground(null);
        this.setLayout(null);

        namel = new JLabel("姓名：");
        namel.setSize(70, 30);
        namel.setLocation(20, 120);
        this.add(namel);

        namet = new JLabel(temp.getName());
        namet.setBounds(100, 120, 100, 30);
        this.add(namet);

        birthl = new JLabel("查询日期");
        birthl.setSize(70, 30);
        birthl.setLocation(20, 70);
        this.add(birthl);

        StringBuffer bir =new StringBuffer();
        bir.append(temp.getBirthYear());
        bir.append("/");
        bir.append(temp.getBirthMonth());
        bir.append("/");
        bir.append(temp.getBirthDay());
        birtht = new JLabel(bir.toString());
        birtht.setBounds(100, 70, 100, 30);
        this.add(birtht);

        addl = new JLabel("地址");
        addl.setSize(70, 30);
        addl.setLocation(20, 170);
        this.add(addl);

        addt = new JLabel(temp.getAddress());
        addt.setBounds(100, 170, 100, 30);
        this.add(addt);

        alivel = new JLabel("是否健在");
        alivel.setSize(70, 30);
        alivel.setLocation(20, 220);
        this.add(alivel);

        alivet = new JLabel(String.valueOf(temp.getAlive()));
        alivet.setBounds(100, 220, 100, 30);
        this.add(alivet);

        marryl = new JLabel("婚姻状态");
        marryl.setSize(70, 30);
        marryl.setLocation(20, 270);
        this.add(marryl);

        marryt = new JLabel(String.valueOf(temp.getisMarried()));
        marryt.setBounds(100, 270, 100, 30);
        this.add(marryt);


        wifel = new JLabel("配偶姓名");
        wifel.setSize(70, 30);
        wifel.setLocation(20, 320);
        this.add(wifel);

        wifet = new JLabel(temp.getWifeName());
        wifet.setBounds(100, 320, 100, 30);
        this.add(wifet);


        diedl = new JLabel("死亡日期");
        diedl.setSize(70, 30);
        diedl.setLocation(20, 370);
        this.add(diedl);

        StringBuffer died =new StringBuffer();
        died.append(temp.getDiedYear());
        died.append("/");
        died.append(temp.getDiedMonth());
        died.append("/");
        died.append(temp.getDiedDay());
        diedt = new JLabel(died.toString());
        diedt.setBounds(100, 370, 100, 30);
        this.add(diedt);


        /*sea = new JButton("查找");
        sea.setBounds(90,420,70,40);
        this.add(sea);
        sea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String date[] =birtht.getText().split("/");
                int day,month,year;
                year = Integer.valueOf(date[0]).intValue();
                month = Integer.valueOf(date[1]).intValue();
                day = Integer.valueOf(date[2]).intValue();
                search.serchByDate ssn =new search.serchByDate(day,month,year);
                ssn.serch(temp[0]);
                temp[0] = ssn.getNode();
            }
        });*/
        this.repaint();
        this.validate();
    }


}
