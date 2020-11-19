package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainPage extends JFrame {
   String driver = "oracle.jdbc.driver.OracleDriver";
   String url = "jdbc:oracle:thin:@localhost:1521:XE";
   String user = "user1104";
   String password = "user1104";
   Connection con;

   // 상수
   public static final int WIDTH = 1300;
   public static final int HEIGHT = 800;

   public static final int LOGIN = 0;
   public static final int MEMBERREGIST = 1;
   public static final int TRAINER = 2;
   public static final int PROGRAM = 3;

// public static final int REGIST = 4;
   JPanel[] pages = new JPanel[4];
   JPanel main_north;// 큰 패널 북쪽
   JPanel main_center;// 큰 패널
   JButton bt_member, bt_trainer, bt_program, bt_regist;

   private boolean loginStatus = false;

   public MainPage() {
      connect();

      main_north = new JPanel();
      main_center = new JPanel();
      bt_member = new JButton("회원 등록");
      bt_trainer = new JButton("트레이너");
      bt_program = new JButton("프로그램");

      // 페이지 생성
      pages[0] = new Login(this);// 처음 로그인 페이지
      pages[1] = new Member(this);
      pages[2] = new Trainer();
      pages[3] = new Program(this);

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
         if (loginStatus == false) {
            JOptionPane.showMessageDialog(this, "로그인이 필요합니다");
            setPage(LOGIN);
         } else {
            setPage(1);
         }
      });

      // 트레이너 버튼과 연결
      bt_trainer.addActionListener((e) -> {
         if (loginStatus == false) {
            JOptionPane.showMessageDialog(this, "로그인이 필요합니다");
            setPage(LOGIN);
         } else {
            setPage(2);
         }

      });

      // 프로그램이랑 연결
      bt_program.addActionListener((e) -> {
         if (loginStatus == false) {
            JOptionPane.showMessageDialog(this, "로그인이 필요합니다");
            setPage(LOGIN);
         } else {
            setPage(3);
         }
      });

      setSize(WIDTH, HEIGHT);
      setVisible(true);
      setLocationRelativeTo(null);

      this.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent e) {
            disConnection();
         }
      });

   }

   public void connect() {
      try {
         Class.forName(driver); // 드라이버 로드
         con = DriverManager.getConnection(url, user, password); // 접속시도
         if (con == null) {
            JOptionPane.showMessageDialog(this, user + "계정의 접속에 실패하였습니다.");
         } else {
            this.setTitle("Fitness management System");

         }
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public void disConnection() {
      if (con != null) {
         try {
            con.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
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

   public boolean isLoginStatus() {
      return loginStatus;
   }

   public void setLoginStatus(boolean loginStatus) {
      this.loginStatus = loginStatus;
   }

   public static void main(String[] args) {
      new MainPage();
   }

   public String getUser() {
      return user;
   }

   public void setUser(String user) {
      this.user = user;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public Connection getCon() {
      return con;
   }

   public void setCon(Connection con) {
      this.con = con;
   }

}