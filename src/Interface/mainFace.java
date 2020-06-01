package Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import family.*;

public class mainFace extends JFrame {
    private JLayeredPane layeredPane;       //分层布局，方便设置背景
    private JPanel oprrateTo,familyMap;
    private JButton add,searchn,searchd,findTo,seeTree,delPer;
    today td;
    int lenth,higth;
    int bortherNum;         //兄弟结点数
    int nextX,nextY;
    treeNode temp;
    treeDrawer treeD;

    public mainFace(treeNode tn) throws IOException, ClassNotFoundException {


        temp = tn;
        layeredPane = new JLayeredPane();

        lenth = 600;
        higth = 700;
        nextX = lenth/2;
        nextY = 50;


        this.setLayeredPane(layeredPane);
        this.setBackground(null);
        this.setTitle("家谱管理系统2.2");
        this.setSize(150,520);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        //退出设置
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);

        oprrateTo = new JPanel();
        oprrateTo.setBackground(null);
        oprrateTo.setLayout(null);
        oprrateTo.setBounds(0,0,150,520);
        oprrateTo.setOpaque(false);
        //oprrateTo.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.BLACK));         //设置边框用于调整界面
        layeredPane.add(oprrateTo,JLayeredPane.MODAL_LAYER);


        familyMap = new JPanel();
        familyMap.setBackground(null);
        familyMap.setOpaque(false);
        familyMap.setBounds(0,0,600,500);
        familyMap.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.BLUE));
        //layeredPane.add(familyMap,JLayeredPane.MODAL_LAYER);



        add = new JButton("添加成员");
        add.setBounds(25,30,100,50);
        oprrateTo.add(add);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPartner ap = new addPartner(temp);
            }
        });

        searchn = new JButton("依据姓名搜索成员");
        searchn.setBounds(25,100,100,50);
        oprrateTo.add(searchn);
        searchn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog(null,"请输入查找姓名）","按日期查找",JOptionPane.PLAIN_MESSAGE);
                new showInfByName(temp,name);
            }
        });


        searchd = new JButton("依据日期搜索成员");
        searchd.setBounds(25,170,100,50);
        oprrateTo.add(searchd);
        searchd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String birtht = JOptionPane.showInputDialog(null,"请输入查找日期（中间加/）","按日期查找",JOptionPane.PLAIN_MESSAGE);
                String date[] =birtht.split("/");
                int day,month,year;
                year = Integer.valueOf(date[0]).intValue();
                month = Integer.valueOf(date[1]).intValue();
                day = Integer.valueOf(date[2]).intValue();
                new showInfByDate(temp,day,month,year);
            }
        });

        findTo =new JButton("查找共同祖先");
        findTo.setBounds(25, 240,100,50);
        oprrateTo.add(findTo);
        findTo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String names[] = JOptionPane.showInputDialog(null,"请输入两人姓名中间用'/'隔开","按姓名查找",JOptionPane.PLAIN_MESSAGE).split("/");
                String firstOne = names[0];
                String secendOne = names[1];
                treeNode anc = new treeNode();
                anc = findTogether.findNode(temp,firstOne,secendOne);
                StringBuffer outmeg = new StringBuffer();
                outmeg.append(firstOne);
                outmeg.append("和");
                outmeg.append(secendOne);
                outmeg.append("的共同先祖为");
                outmeg.append(anc.getName());
                JOptionPane.showConfirmDialog(null,outmeg.toString(),"共同先祖",JOptionPane.WARNING_MESSAGE);
            }
        });

        delPer = new JButton("删除成员");
        delPer.setBounds(25,310,100,50);
        oprrateTo.add(delPer);
        delPer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog(null,"请输入要删去成员姓名）","删除成员",JOptionPane.PLAIN_MESSAGE);
                new deletPerson(temp,name);
                JOptionPane.showConfirmDialog(null,name+"已被移除","删除成员",JOptionPane.WARNING_MESSAGE);
            }
        });

        seeTree = new JButton("查看家谱");
        seeTree.setBounds(25,380,100,50);
        oprrateTo.add(seeTree);
        seeTree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    treeD =new treeDrawer(temp);        //画树
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        seeTree.repaint();
        seeTree.validate();

        //提醒当天生日成员
        td = new today(temp);
        boolean warn =td.getFlag();
        if (warn){
            treeNode wt = temp;
            search.serchByDate ssn =new search.serchByDate(td.getDay(),td.getMonth(),td.getYear());
            ssn.serch(wt);
            wt = ssn.getNode();
            JOptionPane.showMessageDialog(null,"今天是"+wt.getName()+"的生日","生日快乐",JOptionPane.PLAIN_MESSAGE);
        }

        this.repaint();
        this.validate();

    }

}
