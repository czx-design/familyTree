package Interface;

import family.treeNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class signFace extends JFrame {
    JPanel toolShow;
    JButton sign;
    JLabel jl1, jl2;
    JTextField user,password;
    String users[]={"陈","b","c"};
    String passw[]={"123456","123456","123456"};
    boolean flag = false;
    treeNode temp;

    public signFace(treeNode root){
        this.setTitle("登陆");
        this.setSize(250,160);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setBackground(null);
        this.setLayout(null);

        temp = root;
        /*toolShow = new JPanel();
        toolShow.setBackground(null);
        toolShow.setBounds(0,0,300,200);
        toolShow.setOpaque(false);
        toolShow.setLayout(new FlowLayout());
        toolShow.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.BLACK));         //设置边框用于调整界面
        this.add(toolShow);*/


        sign = new JButton("登陆");
        sign.setBounds(90,85,70,40);
        this.add(sign);
        sign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    turnTo(jl1.getText(),jl2.getText());
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });


        jl1 = new JLabel("用户名:");
        jl1.setSize(50,30);
        jl1.setLocation(20,20);
        add(jl1);

        user = new JTextField(8);
        user.setBounds(90,20,130,30);
        add(user);

        jl2 = new JLabel("密码:");
        jl2.setSize(50,30);
        jl2.setLocation(20,50);
        add(jl2);

        password =new JTextField(8);
        password.setBounds(90,50,130,30);
        add(password);

        this.repaint();
        this.validate();
    }

    public void turnTo(String name, String pass) throws IOException, ClassNotFoundException {
        for (int i=0;i<3;i++){
            if (user.getText().trim().equals(users[i])){
                flag=true;
                if (password.getText().trim().equals(passw[i])){
                    mainFace mf =new mainFace(temp);
                    this.dispose();
                    break;
                }else {
                    JOptionPane.showMessageDialog(null,"密码错误","警告",JOptionPane.WARNING_MESSAGE);
                }
            }else {
                JOptionPane.showMessageDialog(null,"该用户不存在","警告",JOptionPane.WARNING_MESSAGE);
            }
        }

    }

}
