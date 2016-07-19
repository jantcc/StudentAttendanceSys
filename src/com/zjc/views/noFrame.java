package com.zjc.views;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.zjc.views.StuFuncPortalFrame.StuFuncPortalPanel;

public class noFrame extends JFrame {
	private static final int DEFAULT_WIDTH = 100;
	private static final int DEFAULT_HEIGHT = 100;
	protected JFrame parentFrame;



	public noFrame(String title) {
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
		noPanel FucPortalPanel = new noPanel();
		setContentPane(FucPortalPanel);
		// ���ô���������ʾ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}
	public class noPanel extends JPanel {
		JLabel JLabel01;
		JButton Button1;
		public noPanel() {
			JLabel01 = new JLabel("��û��Ȩ����ô��");
			add(JLabel01);
			Button1 = new JButton("ȷ��");
			add(Button1);
			ButtonAction buttonaction= new ButtonAction();
			Button1.addActionListener(buttonaction);
		}
class ButtonAction implements ActionListener {
			
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(Button1)) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							noFrame.this.dispose();
							parentFrame.setVisible(true);
						}
					 });
				   }
			}
}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		noFrame frame = new noFrame(" ");
	}

}
