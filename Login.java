package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

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
	private JPanel setTitle;

	public Login(MainPage mainPage) {
		this.mainPage = mainPage;

		//생성하기 
		p_center = new JPanel();
		la_id = new JLabel("관리자 ID :");
		la_pass = new JLabel("관리자 PW :");
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
		
		la_id.setBounds(410, 245, 110, 100);
		t_id.setBounds(540, 280, 250, 30);
		
		la_pass.setBounds(410, 330, 130, 70);
		t_pass.setBounds(540, 350, 250, 30);
		bt_login.setBounds(830, 280, 100, 100);
		
		// JPanel p_center =null;
		//조립 
		p_center.setLayout(null); // 배치관리자를 null
		p_center.add(la_id);
		p_center.add(t_id);
		p_center.add(la_pass);
		p_center.add(t_pass);
		p_center.add(bt_login);
		
		p_x = new JPanel() {
			public void paint(Graphics g) {
				try {
					String file = "C:/Users/최은영/eclipse-workspace/seproject/image/헬스.jpg";
					buffImg = ImageIO.read(new File(file));
					img = buffImg;
					img = img.getScaledInstance(1300, 800, Image.SCALE_SMOOTH);
					g.drawImage(img, 0, 0, this);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		
		//p_center.add(p_x);
		add(p_center);
				


		bt_login.addActionListener((e) -> {
			setVisible(false);
			mainPage.setPage(mainPage.MEMBERREGIST);
		});

	}

	private void setTitle(String string) {
		// TODO Auto-generated method stub
		
	}

	public void paintComponents(Graphics g) {
		g.drawImage(img, 0, 0, null);
	};

}