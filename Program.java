
package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


public class Program extends JPanel {
   JPanel input, p_west, p_center, c_center, c_north, can, bt_north;
   JTextField t_name, n_t_name, t_Maxmember, t_start, t_end, t_manager,t_price;
   JLabel la_name, la_day, la_Maxmember, la_start, la_end, n_la_name, la_manager,la_price,la_time,empty;
   JButton img_regist, regist, edit, del, search, list;
   JScrollPane scroll;
   JTable table;

   Image img;
   File file;
   ProgramList programList;
   JFileChooser chooser = new JFileChooser("D:/workspace/java/SeProject/res/travel2");
   Toolkit kit = Toolkit.getDefaultToolkit();
   String days[] = { "월,수,금", "화,목" };
   String program_name[] = { "스피닝", "뮤직복싱", "줌바", "필라테스", "요가" };
   String program_time[] = { "10시~11시", "11시~12시", "19시~20시", "20시~21시", "21시~22시" };
   String program_pay[] = { "50000", "80000"};
   JComboBox<String> combo_day;
   JComboBox<String> combo_program;
   JComboBox<String> combo_pay;
   JComboBox<String> combo_time;

   MainPage mainPage;
   Connection con;

   public Program(MainPage mainPage) {
      this.mainPage = mainPage;
      con = mainPage.getCon();
      // 서쪽영역 생성

      p_west = new JPanel();

      la_name = new JLabel("프로그램명");
      combo_program = new JComboBox<String>(program_name);
      la_day = new JLabel("요일");
      combo_day = new JComboBox<String>(days);
      la_start = new JLabel("시작일");
      t_start = new JTextField(8);
      la_end = new JLabel("종료일");
      t_end = new JTextField(8);
      la_Maxmember = new JLabel("최대인원");
      t_Maxmember = new JTextField(5);
      la_manager = new JLabel("트레이너");
      t_manager = new JTextField(8);
      la_price = new JLabel("금액");
      combo_pay = new JComboBox<String>(program_pay);
      la_time = new JLabel("시간선택");
      combo_time = new JComboBox<String>(program_time);
      can = new JPanel() {
         public void paint(Graphics g) {
            g.drawImage(img, 0, 0, can);
         }
      };
      img_regist = new JButton("이미지 파일 등록");
      empty = new JLabel("");
      regist = new JButton("등록");
      edit = new JButton("수정");
      del = new JButton("삭제");
      // 서쪽조립
      p_west.add(la_name);
      p_west.add(combo_program);
      p_west.add(la_day);
      p_west.add(combo_day);
      p_west.add(la_start);
      p_west.add(t_start);
      p_west.add(la_end);
      p_west.add(t_end);
      p_west.add(la_Maxmember);
      p_west.add(t_Maxmember);
      p_west.add(la_manager);
      p_west.add(t_manager);
      p_west.add(la_price);
      p_west.add(combo_pay);
      p_west.add(la_time);
      p_west.add(combo_time);
      p_west.add(can);
      p_west.add(img_regist);
      p_west.add(empty);
      p_west.add(regist);
      p_west.add(edit);
      p_west.add(del);

      // 서쪽 스타일적용
      p_west.setPreferredSize(new Dimension(330, 700));

      la_name.setPreferredSize(new Dimension(70, 60));
      combo_program.setPreferredSize(new Dimension(80, 30));
      la_day.setPreferredSize(new Dimension(40, 60));
      combo_day.setPreferredSize(new Dimension(80, 30));

      la_start.setPreferredSize(new Dimension(40, 60));
      t_start.setPreferredSize(new Dimension(60, 30));
      la_end.setPreferredSize(new Dimension(40, 60));
      t_end.setPreferredSize(new Dimension(60, 30));

      la_manager.setPreferredSize(new Dimension(60, 60));
      t_manager.setPreferredSize(new Dimension(60, 30));

      la_Maxmember.setPreferredSize(new Dimension(60, 60));
      t_Maxmember.setPreferredSize(new Dimension(60, 30));
      
      la_price.setPreferredSize(new Dimension(40, 60));
      combo_pay.setPreferredSize(new Dimension(80, 30));
      
      la_time.setPreferredSize(new Dimension(60, 60));
      combo_time.setPreferredSize(new Dimension(100, 30));
      
      can.setPreferredSize(new Dimension(330, 280));
      img_regist.setPreferredSize(new Dimension(280, 30));
      empty.setPreferredSize(new Dimension(340,20));
      regist.setPreferredSize(new Dimension(90, 30));
      edit.setPreferredSize(new Dimension(90, 30));
      del.setPreferredSize(new Dimension(90, 30));

      p_west.setBackground(Color.lightGray);
      p_center = new JPanel();
      p_west.setBorder(new TitledBorder(new LineBorder(Color.BLUE, 2), "<프로그램 정보입력>"));// 레이아웃주기

      // 가운데 영역 전체패널에 두 패널부착
      add(p_west, BorderLayout.WEST);

      // 가운데 위쪽영역영역생성
      c_north = new JPanel();
      c_center = new JPanel();

      n_la_name = new JLabel("프로그램명");
      n_t_name = new JTextField(10);
      search = new JButton("검색");
      list = new JButton("전체목록");
      table = new JTable(programList = new ProgramList());
      scroll = new JScrollPane(table);

      c_center.setLayout(new BorderLayout());
      c_center.add(scroll);

      p_center = new JPanel();// 전체패널에 가운데
      p_center.setLayout(new BorderLayout());
      p_center.add(c_north, BorderLayout.NORTH);
      p_center.add(c_center);
      p_center.setPreferredSize(new Dimension(870, 700));
      add(p_center);

      // 북쪽 부착
      c_north.add(n_la_name);
      c_north.add(n_t_name);
      c_north.add(search);
      c_north.add(list);
      p_center.setBorder(new TitledBorder(new LineBorder(Color.RED, 2), "<프로그램 리스트>"));// 레이아웃주기

      // 북쪽스타일 적용
      n_la_name.setPreferredSize(new Dimension(80, 60));
      n_t_name.setPreferredSize(new Dimension(50, 30));

      // 회원이미지찾기버튼과 리스너연결
      img_regist.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            findImage();// 쇼핑몰에 사용할 상품이미지 선택!!
            preview();
         }
      });

      // 등록 버튼
      regist.addActionListener((e) -> {
         regist(getManagerName());
      });

   }







// order_id로 트레이너 이름 찾는 메서드
   public int getManagerName() {
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      int id =0;
      
      String sql = "select order_id from gym_manager where manager_name=?";
      try {
         pstmt=con.prepareStatement(sql);
         pstmt.setNString(1, t_manager.getText());
         rs = pstmt.executeQuery();
         rs.next();
         id =rs.getInt("order_id");
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
         if(rs!=null) {
            try {
               rs.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
         if(pstmt!=null) {
            try {
               pstmt.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
      }
      return id;
   }

   // 등록
   public void regist(int id) {
      PreparedStatement pstmt = null;
      
      String sql = "iNSERT INTO gym_program(PG_ID,ORDER_ID ,PG_NAME ,PG_DAY ,PG_START_DAY ,";
      sql += "PG_END_DAY ,PG_PRICE ,PG_TOTAL ,PG_FILE) values(seq_gym_member.nextval,?,?,?,?,?,?,?,?)";

      try {
         pstmt = con.prepareStatement(sql);
         pstmt.setInt(1, id);
         pstmt.setString(2, combo_program.getSelectedItem().toString());
         pstmt.setString(3, combo_day.getSelectedItem().toString());   
         pstmt.setString(4, t_start.getText());   
         pstmt.setString(5, t_end.getText());   
         pstmt.setString(6, t_price.getText());   
         pstmt.setString(7, t_Maxmember.getText());   
         pstmt.setString(8, file.getAbsolutePath());   
         int result=pstmt.executeUpdate();   //쿼리 수행 
         
         //등록확인
         if(result==0) {
            JOptionPane.showMessageDialog(this, "등록 실패");
         }else {
            JOptionPane.showMessageDialog(this, "등록 성공");
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
         if(pstmt!=null) {
            try {
               pstmt.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
      }

   }

   public void getTargetImage(String path) {
      img = kit.getImage(path);
      img = img.getScaledInstance(330, 280, Image.SCALE_SMOOTH);
      // img = ImageUtil.getCustomSize(img, 135, 115);

   }

   public void findImage() {
      if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
         // 파일정보를 구한다.
         file = chooser.getSelectedFile();
         System.out.println("선택한 파일 정보 " + file.getAbsolutePath());
         getTargetImage(file.getAbsolutePath());
      }
   }

   public void preview() {
      // paint로 그림 처리~~
      if (img != null) {
         can.repaint();
      }
   }

}