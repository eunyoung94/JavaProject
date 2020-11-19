package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JPanel {
	JPanel p_center, p_x;
	JLabel la_id;
	JLabel la_pass;
	JTextField t_id;
	JTextField t_pass;
	JButton bt_login;
	MainPage mainPage;
	Image img;
	BufferedImage buffImg;
	// private JPanel setTitle;

	Connection con;

	public Login(MainPage mainPage) {
		this.mainPage = mainPage;

		// 생성하기
		p_center = new JPanel();
		la_id = new JLabel("관리자 이름 :");
		la_pass = new JLabel("관리자 휴대폰번호 :");
		t_id = new JTextField(15);
		t_pass = new JPasswordField(15);
		bt_login = new JButton("로그인");

		p_center.setBackground(Color.GRAY);

		// 사이즈 설정
		p_center.setPreferredSize(new Dimension(1300, 800));
		p_center.setLayout(new BorderLayout());

		la_id.setFont(new Font("맑은고딕", Font.BOLD, 20));
		la_id.setForeground(Color.WHITE);
		la_pass.setFont(new Font("맑은고딕", Font.BOLD, 20));
		la_pass.setForeground(Color.WHITE);

		la_id.setBounds(410, 245, 250, 100);
		t_id.setBounds(540, 280, 250, 30);

		la_pass.setBounds(350, 330, 250, 70);
		t_pass.setBounds(540, 350, 250, 30);
		bt_login.setBounds(830, 280, 100, 100);

		// JPanel p_center =null;
		// 조립
		p_center.setLayout(null); // 배치관리자를 null
		p_center.add(la_id);
		p_center.add(t_id);
		p_center.add(la_pass);
		p_center.add(t_pass);
		p_center.add(bt_login);

		// p_center.add(p_x);
		add(p_center);

		bt_login.addActionListener((e) -> {
			login();
			String name = t_id.getText();// name
			String pass = t_pass.getText();// 01012345678
			if (name.equals("") && pass.equals("")) {
				JOptionPane.showMessageDialog(this, "아이디와 비밀번호를 입력해주세요");
			} else if (name.equals(name) && pass.equals(pass)) {
				this.setVisible(false);
				mainPage.setPage(mainPage.MEMBERREGIST);
			} else {
				JOptionPane.showMessageDialog(this, "아이디 혹은 비밀번호가 일치하지않습니다");
			}
		});
		
		bt_login.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					bt_login.doClick();
				}
			}
		});

	}

	// 로그인
	public void login() {
		con = mainPage.getCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from gym_manager where manager_name=? and manager_phone=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t_id.getText());
			pstmt.setString(2, t_pass.getText());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("로그인 성공");
				mainPage.setLoginStatus(true);
			} else {
				System.out.println("로그인 실패");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void paintComponents(Graphics g) {
		g.drawImage(img, 0, 0, null);
	};

}