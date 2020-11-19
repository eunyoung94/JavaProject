package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainPage extends JFrame {
   //상수
   public static final int WIDTH = 1300;
   public static final int HEIGHT = 800;
   
   public static final int LOGIN = 0;
   public static final int MEMBERREGIST = 1;
   public static final int TRAINER = 2;
   public static final int PROGRAM = 3;
   JPanel[] pages = new JPanel[4];
   JPanel main_north;// 큰 패널 북쪽
   JPanel main_center;// 큰 패널
   JButton bt_member, bt_trainer,bt_program;


   public MainPage() {
      main_north = new JPanel();
      main_center = new JPanel();
      bt_member = new JButton("회원 등록");
      bt_trainer = new JButton("트레이너");
      bt_program = new JButton("프로그램");
      
      // 페이지 생성
      pages[0] = new Login(this);//처음 로그인 페이지
      pages[1] = new Member();
      pages[2] = new Trainer();
      pages[3] = new Program();
      

      main_north.add(bt_member);
      main_north.add(bt_trainer);
      main_north.add(bt_program);
      main_north.setPreferredSize(new Dimension(1200, 40));
      main_north.setBackground(Color.BLACK);
      main_center.setPreferredSize(new Dimension(WIDTH, HEIGHT - 30));

      main_center.add(pages[0]);
      main_center.add(pages[1]);
      main_center.add(pages[2]);
      main_center.add(pages[3]);
      add(main_north, BorderLayout.NORTH);
      add(main_center);

      setPage(MainPage.LOGIN);// 첫번째로 보여질 페이지

      // 회원등록버튼과 연결
      bt_member.addActionListener((e) -> {
         setPage(1);
      });

      // 트레이너 버튼과 연결
      bt_trainer.addActionListener((e) -> {
         setPage(2);
      });
      
      //프로그램이랑 연결 
      bt_program.addActionListener((e) -> {
          setPage(3);
       });
      
   
      

      setSize(WIDTH, HEIGHT);
      setVisible(true);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
   }

   // 화면 전환
   public void setPage(int index) {
      for (int i = 0; i < pages.length; i++) {
         if (index == i) {
            pages[i].setVisible(true);// 보여질 페이지
         } else {
            pages[i].setVisible(false);// 가려질 페이지
         }
      }
   }

   public static void main(String[] args) {
      new MainPage();
   }

}