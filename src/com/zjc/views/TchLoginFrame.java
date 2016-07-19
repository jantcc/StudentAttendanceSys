package com.zjc.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.zjc.views.StuLoginFrame.StuLoginPanel.ButtonAction;

public class TchLoginFrame extends JFrame {
	JFrame parentFrame;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 300;

	public TchLoginFrame(String title) {
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
		TchLoginPanel loginPanel = new TchLoginPanel();
		setContentPane(loginPanel);

		// 设置窗口其他显示属性
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}

	public class TchLoginPanel extends JPanel {

		JLabel picLabel;
		JLabel idLabel, pwdLabel;
		JTextField stuIdTextField;
		JPasswordField pwdField;
		JButton okButton, clearButton;
		JPanel buttonPanel, infoPanel;
		JCheckBox adminCheckBox;

		public TchLoginPanel() {
			picLabel = new JLabel();
			idLabel = new JLabel("教工ID："); // 构造器参数为标签显示文本
			pwdLabel = new JLabel("密    码："); // 构造器参数为标签显示文本
			stuIdTextField = new JTextField(20);
			pwdField = new JPasswordField(20);
			okButton = new JButton("登陆"); // 构造器参数为按钮显示文本
			clearButton = new JButton("清空信息");

			buttonPanel = new JPanel();
			infoPanel = new JPanel();
			adminCheckBox = new JCheckBox("我是管理员");
			setLayout(new BorderLayout());
			infoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			picLabel.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT / 2);
			ImageIcon image = new ImageIcon(this.getClass().getResource(
					"/images/002.jpg"));
			image.setImage(image.getImage().getScaledInstance(
					picLabel.getWidth(), picLabel.getHeight(),
					Image.SCALE_DEFAULT));
			picLabel.setIcon(image);
			infoPanel.add(picLabel);
			infoPanel.add(idLabel);
			infoPanel.add(stuIdTextField);
			infoPanel.add(pwdLabel);
			infoPanel.add(pwdField);
			add(infoPanel, BorderLayout.CENTER);
			infoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			infoPanel.add(adminCheckBox);
			add(infoPanel, BorderLayout.CENTER);
			buttonPanel.add(okButton);
			buttonPanel.add(clearButton);
			add(buttonPanel, BorderLayout.SOUTH);
			ButtonAction buttonAction = new ButtonAction();

			okButton.addActionListener(buttonAction);
			clearButton.addActionListener(buttonAction);
			adminCheckBox.addActionListener(buttonAction);

		}

		class ButtonAction implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(okButton)) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							if (new String(pwdField.getPassword())
									.compareTo("123456") == 0) {
								TchFuncPortalFrame frame = new TchFuncPortalFrame(
										"考勤客户端-学生登陆");
								frame.parentFrame = TchLoginFrame.this;
								TchLoginFrame.this.setVisible(false);
							} else {
								JOptionPane.showMessageDialog(null, "请重新输入密码!",
										"密码错误", JOptionPane.ERROR_MESSAGE);
								pwdField.setText("");
							}
						}
					});
				}       else {
					stuIdTextField.setText("");
					pwdField.setText("");
				} 
					
			}
		}

		
	}
	

/*	public static void main(String[] args) {
		TchLoginFrame frame = new TchLoginFrame("教工登陆窗口");
	}  */
}
