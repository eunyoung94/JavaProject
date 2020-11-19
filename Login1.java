//package project;
//
//import java.awt.Color;
//import java.awt.Dimension;
//
//import javax.swing.JButton;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JPasswordField;
//import javax.swing.JTextField;
//import javax.swing.border.LineBorder;
//import javax.swing.border.TitledBorder;
//
//public class Login extends JPanel{
//	JPanel p_center;
//	JLabel la_id;
//	JLabel la_pass;
//	   JTextField t_id;
//	   JTextField t_pass;
//	   JButton bt_login;
//	   MainPage mainPage;
//	   public Login(MainPage mainPage) {
//		   this.mainPage = mainPage;
//		   
//		  p_center =new JPanel();
//	      la_id = new JLabel("관리자ID :");
//	      la_pass = new JLabel("관리자PW :");
//	      t_id = new JTextField(15);
//	      t_pass = new JPasswordField(15);
//	      bt_login = new JButton("로그인");
//	      
//	      //스타일 
//	      p_center.setPreferredSize(new Dimension(1300, 800));
//	      p_center.setBackground(Color.GRAY);
//	      p_center.add(la_id);
//	      p_center.add(t_id);
//	      p_center.add(la_pass);
//	      p_center.add(t_pass);
//	      p_center.add(bt_login);
//	      add(p_center);
//	      p_center.setBorder(new TitledBorder(new LineBorder(Color.WHITE,2),"<관리자 로그인>"));//레이아웃주기
//	      bt_login.addActionListener((e) -> {
//	          setVisible(false);
//	          mainPage.setPage(mainPage.MEMBERREGIST);
//
//	       });
//	   }
//}
