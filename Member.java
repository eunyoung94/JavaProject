package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


public class Member extends JPanel{
   JPanel input,p_west,p_center,c_center,c_north,can,bt_north;
   JTextField t_name,t_age,t_phone,t_mail,t_address,n_t_name ;
   JLabel la_name,la_age,la_phone,la_mail,la_address,n_la_name;
   JButton img_regist,regist,edit,del,search,list;
   JRadioButton man,woman;
   JScrollPane scroll;
   JTable table;
   JLabel la_ch1, la_ch2, la_ch3, la_ch4;//1달, 3달, 6달, 1년
   JCheckBox ch1,ch2,ch3,ch4;//1달, 3달, 6달, 1년

   Image img;
   File file;
   MemberList meberList;
   JFileChooser chooser=new JFileChooser("D:/workspace/java/SeProject/res/travel2");
   Toolkit kit=Toolkit.getDefaultToolkit();
   

   
   
   public Member() {

   //서쪽영역 생성
      
      p_west = new JPanel();
      la_name= new JLabel("이름");
      t_name=new JTextField(10);
      man = new JRadioButton("man");
      woman = new JRadioButton("woman");
      
      la_age= new JLabel("나이");
      t_age=new JTextField(5);
      la_phone= new JLabel(" 전화번호");
      t_phone=new JTextField(10);
      la_mail= new JLabel("메일");
      t_mail=new JTextField(22);
      la_address= new JLabel("주소");
      t_address=new JTextField(22);
      can = new JPanel() {
         public void paint(Graphics g) {
            g.drawImage(img, 0, 0, can);
         }
      };
      img_regist = new JButton("이미지 파일 등록");
      //empty = new JLabel("");
      la_ch1 = new JLabel("1개월");
      la_ch2 = new JLabel("3개월");
      la_ch3 = new JLabel("6개월");
      la_ch4 = new JLabel("1년");
      ch1 = new JCheckBox();
      ch2 = new JCheckBox();
      ch3 = new JCheckBox();
      ch4 = new JCheckBox();


      
      regist = new JButton("등록");
      edit = new JButton("수정");
      del = new JButton("삭제");
      //서쪽조립
      p_west.add(la_name);
      p_west.add(t_name);
      p_west.add(man);
      p_west.add(woman);
      p_west.add(la_age);
      p_west.add(t_age);
      p_west.add(la_phone);
      p_west.add(t_phone);
      p_west.add(la_mail);
      p_west.add(t_mail);
      p_west.add(la_address);
      p_west.add(t_address);
      p_west.add(can);
      p_west.add(img_regist);
      //p_west.add(empty);
      p_west.add(la_ch1);
      p_west.add(ch1);
      p_west.add(la_ch2);
      p_west.add(ch2);
      p_west.add(la_ch3);
      p_west.add(ch3);
      p_west.add(la_ch4);
      p_west.add(ch4);


      p_west.add(regist);
      p_west.add(edit);
      p_west.add(del);
      //서쪽 스타일적용 
      p_west.setPreferredSize(new Dimension(330,700));
      la_name.setPreferredSize(new Dimension(40,60));
      t_name.setPreferredSize(new Dimension(50,30));
      la_age.setPreferredSize(new Dimension(40,60));
      t_age.setPreferredSize(new Dimension(50,30));
      la_phone.setPreferredSize(new Dimension(60,60));
      t_phone.setPreferredSize(new Dimension(50,30));
      la_mail.setPreferredSize(new Dimension(40,60));
      t_mail.setPreferredSize(new Dimension(50,30));
      la_address.setPreferredSize(new Dimension(40,60));
      t_address.setPreferredSize(new Dimension(50,30));
      can.setPreferredSize(new Dimension(330,280));
      img_regist.setPreferredSize(new Dimension(280,30));
      //empty.setPreferredSize(new Dimension(340,20));
      regist.setPreferredSize(new Dimension(90,30));
      edit.setPreferredSize(new Dimension(90,30));
      del.setPreferredSize(new Dimension(90,30));
      p_west.setBackground(Color.lightGray);
      p_center = new JPanel();
      p_west.setBorder(new TitledBorder(new LineBorder(Color.BLUE,2),"<회원등록>"));//레이아웃주기

   
      //가운데 영역 전체패널에 두 패널부착 
      add(p_west,BorderLayout.WEST);
      
      //가운데 위쪽영역영역생성 
      c_north = new JPanel();
      c_center = new JPanel();
      n_la_name = new JLabel("이름");
      n_t_name = new JTextField(10);
      search = new JButton("검색");
      list = new JButton("전체목록");
      table =new JTable(meberList=new MemberList());
      scroll = new JScrollPane(table);
      
   
      c_center.setLayout(new BorderLayout());
      c_center.add(scroll);
      
      p_center = new JPanel();//전체패널에 가운데 
      p_center.setLayout(new BorderLayout());
      p_center.add(c_north,BorderLayout.NORTH);
      p_center.add(c_center);
      p_center.setPreferredSize(new Dimension(870,700));
      add(p_center);
      
      //북쪽 부착
      c_north.add(n_la_name);
      c_north.add(n_t_name);
      c_north.add(search);
      c_north.add(list);
      p_center.setBorder(new TitledBorder(new LineBorder(Color.RED,2),"<등록회원 리스트>"));//레이아웃주기
   
      
      //북쪽스타일 적용 
      n_la_name.setPreferredSize(new Dimension(60,60));
      n_t_name.setPreferredSize(new Dimension(50,30));
      
      
      //회원이미지찾기버튼과 리스너연결 
      img_regist.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            findImage();//쇼핑몰에 사용할 상품이미지 선택!!
            preview();
         }   
      });
      
   
     
   }
     
   
   public void getTargetImage(String path) {
      img = kit.getImage(path);
   //   img = ImageUtil.getCustomSize(img, 135, 115);
      
   }
   
   public void findImage() {
      if(chooser.showOpenDialog(this)==JFileChooser.APPROVE_OPTION) {
      //파일정보를 구한다.    
         file =chooser.getSelectedFile();
         System.out.println("선택한 파일 정보 "+file.getAbsolutePath());
         getTargetImage(file.getAbsolutePath());
      }
   }

   public void preview() {
      //paint로 그림 처리~~
      can.repaint();
   }
   
  
   
   public static void main(String[] args) {
      new Member();
   }
}