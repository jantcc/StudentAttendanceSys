package com.zjc.views;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.zjc.util.WindowsHandler;
public class MainLoginFrame extends JFrame {

	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 300;

	public MainLoginFrame(String title) {
		// ���ô����С
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		// ���ô������
		setTitle(title);

		// ��ʾλ������Ļ���ȺͿ�ȵ�1/3����
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidthpx = screenSize.width;
		int screenHeightpx = screenSize.height;
		setLocation(screenWidthpx / 3, screenHeightpx / 3);
		setLocationByPlatform(false);

		// ���ô�����С��ʱ��ʾ��ͼ�꣬��ѡ��
		Image img = new ImageIcon(this.getClass()
				.getResource("/images/001.jpg")).getImage();
		setIconImage(img);

		// ���ô����������壬�������������е���ЧGUI�����Ϣ
		MainLoginPanel loginPanel = new MainLoginPanel();
		setContentPane(loginPanel);

		// ���ô���������ʾ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(true);
		addWindowListener(new WindowsHandler());
	}

	private class MainLoginPanel extends JPanel {
		// �����½����Panel�еĿؼ�Ԫ�ء�
		JLabel picLabel;
		JButton stuLoginButton, tchLoginButton;
		JPanel buttonPanel, infoPanel;

		// ��½����panel���죬�����пؼ�Ԫ��װ��������

		public MainLoginPanel() {
			
			picLabel =new JLabel();
			stuLoginButton = new JButton("�����ת��ѧ����½����");
			tchLoginButton = new JButton("�����ת���̹���½����");
			infoPanel = new JPanel();
			setLayout(new BorderLayout());
			infoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			picLabel.setSize(DEFAULT_WIDTH,DEFAULT_WIDTH/2);
			ImageIcon image = new ImageIcon(this.getClass().getResource("/images/top2.jpg"));
			image.setImage(image.getImage().getScaledInstance(picLabel.getWidth(), picLabel.getHeight(),
					Image.SCALE_DEFAULT));
			picLabel.setIcon(image);
			infoPanel.add(picLabel);
			infoPanel.add(stuLoginButton);
			infoPanel.add(tchLoginButton);
			add(infoPanel,BorderLayout.CENTER);
			ButtonAction buttonAction = new ButtonAction();
			stuLoginButton.addActionListener(buttonAction);
			tchLoginButton.addActionListener(buttonAction);
		}
class ButtonAction implements ActionListener{
			
			public void actionPerformed(ActionEvent e){
				if(e.getSource().equals(stuLoginButton)){
					EventQueue.invokeLater(new Runnable(){
						public void run(){
							StuLoginFrame frame = new StuLoginFrame("ѧ����½���");	
						}
					});
					MainLoginFrame.this.setVisible(false);
					}else {
					EventQueue.invokeLater(new Runnable(){
					public void run(){
						TchLoginFrame frame = new TchLoginFrame("�̹���½���");	
					}
					});
					MainLoginFrame.this.setVisible(false);
					}
			}
			
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainLoginFrame frame = new MainLoginFrame("ѧ�����ڹ����½ϵͳ");
	}

}
