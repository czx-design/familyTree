package Interface;

import family.addPerson;
import family.changePerson;
import family.search;
import family.treeNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addPartner extends JFrame {
    JLabel fathernamel, namel, addl, marryl, wifel, alivel, birthl, diedl;
    JTextField fathernamet, namet, addt, alivet, marryt, wifet, birtht, diedt;
    JRadioButton at, af, mt, mf;
    ButtonGroup a, m;
    JButton addTo;

    treeNode temp;

    public addPartner(treeNode root) {
        this.setTitle("添加成员");
        this.setSize(250, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setBackground(null);
        this.setLayout(null);

        fathernamel = new JLabel("父亲姓名：");
        fathernamel.setSize(70, 30);
        fathernamel.setLocation(20, 20);
        this.add(fathernamel);

        fathernamet = new JTextField(5);
        fathernamet.setBounds(100, 20, 100, 30);
        this.add(fathernamet);

        namel = new JLabel("姓名：");
        namel.setSize(70, 30);
        namel.setLocation(20, 70);
        this.add(namel);

        namet = new JTextField(5);
        namet.setBounds(100, 70, 100, 30);
        this.add(namet);

        birthl = new JLabel("生日");
        birthl.setSize(70, 30);
        birthl.setLocation(20, 120);
        this.add(birthl);

        birtht = new JTextField(2);
        birtht.setBounds(100, 120, 100, 30);
        this.add(birtht);

        addl = new JLabel("地址");
        addl.setSize(70, 30);
        addl.setLocation(20, 170);
        this.add(addl);

        addt = new JTextField(20);
        addt.setBounds(100, 170, 100, 30);
        this.add(addt);

        alivel = new JLabel("是否健在");
        alivel.setSize(70, 30);
        alivel.setLocation(20, 220);
        this.add(alivel);

        alivet = new JTextField(20);
        alivet.setBounds(100, 220, 100, 30);
        this.add(alivet);

        marryl = new JLabel("婚姻状态");
        marryl.setSize(70, 30);
        marryl.setLocation(20, 270);
        this.add(marryl);

        marryt = new JTextField(20);
        marryt.setBounds(100, 270, 100, 30);
        this.add(marryt);


        wifel = new JLabel("配偶姓名");
        wifel.setSize(70, 30);
        wifel.setLocation(20, 320);
        this.add(wifel);

        wifet = new JTextField(20);
        wifet.setBounds(100, 320, 100, 30);
        this.add(wifet);

        diedl = new JLabel("死亡日期");
        diedl.setSize(70, 30);
        diedl.setLocation(20, 370);
        this.add(diedl);

        diedt = new JTextField(20);
        diedt.setBounds(100, 370, 100, 30);
        this.add(diedt);


        addTo = new JButton("添加");
        addTo.setBounds(90,420,70,40);
        this.add(addTo);
        addTo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                treeNode temp = new treeNode();
                new addPerson(root, fathernamet.getName().trim(), namet.getText().trim());
                search.serchByName ssn = new search.serchByName(namet.getText().trim());
                ssn.serch(root);
                temp = ssn.temp;
                changePerson cp = new changePerson(temp);
                cp.changeBir(25, 1, 1999);
                cp.changeAdr(addt.getText().trim());
                if (marryt.getText().trim().equals("已婚")) {
                    cp.changeMar(true);
                }else if (marryt.getText().trim().equals("未婚")){
                    cp.changeMar(false);
                }
                if (alivet.getText().trim().equals("健在")) {
                    cp.changeAl(true);
                }else if (alivet.getText().trim().equals("去世")){
                    cp.changeAl(false);
                }
                cp.changewife(wifet.getText().trim());
                JOptionPane.showMessageDialog(null, "添加成功", "修改成功", JOptionPane.PLAIN_MESSAGE);
            }
        });


        this.repaint();
        this.validate();
    }

}
