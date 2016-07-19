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
		// 设置窗体大小
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		// 设置窗体标题
		setTitle(title);
		// 显示位置在屏幕长度和宽度的1/3处。
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidthpx = screenSize.width;
		int screenHeightpx = screenSize.height;
		setLocation(screenWidthpx / 3, screenHeightpx / 3);
		setLocationByPlatform(false);
		// 设置窗口最小化时显示的图标，可选。
		Image img = new ImageIcon(this.getClass()
				.getResource("/images/001.jpg")).getImage();
		setIconImage(img);
		// 设置窗体的内容面板，该面板包含了所有的有效GUI组件信息
		noPanel FucPortalPanel = new noPanel();
		setContentPane(FucPortalPanel);
		// 设置窗口其他显示属性
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}
	public class noPanel extends JPanel {
		JLabel JLabel01;
		JButton Button1;
		public noPanel() {
			JLabel01 = new JLabel("你没有权限这么做");
			add(JLabel01);
			Button1 = new JButton("确定");
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
