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

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.zjc.dao.StudentEntityDAO;
import com.zjc.dao.impl.StudentEntityDAOImpl;
import com.zjc.util.Commual;

public class StuLoginFrame extends JFrame {
	JFrame parentFrame;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 300;

	public StuLoginFrame(String title) {
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
		StuLoginPanel loginPanel = new StuLoginPanel();
		setContentPane(loginPanel);

		// 设置窗口其他显示属性
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}

	public class StuLoginPanel extends JPanel {
		// 定义登陆容器Panel中的控件元素。
		JLabel picLabel;
		JLabel idLabel, pwdLabel;
		JTextField stuIdTextField;
		JPasswordField pwdField;
		JButton okButton, clearButton;
		JPanel buttonPanel, infoPanel;

		// 登陆容器panel构造，将所有控件元素装入容器。

		public StuLoginPanel() {
			picLabel = new JLabel();
			idLabel = new JLabel("学生ID: ");
			pwdLabel = new JLabel("密     码: ");
			stuIdTextField = new JTextField(20);
			pwdField = new JPasswordField(20);
			okButton = new JButton("登陆"); // 构造器参数为按钮显示文本
			clearButton = new JButton("清空信息");

			buttonPanel = new JPanel();
			infoPanel = new JPanel();
			setLayout(new BorderLayout());
			infoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			picLabel.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT / 2);
			ImageIcon image = new ImageIcon(this.getClass().getResource(
					"/images/top2.jpg"));
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
			buttonPanel.add(okButton);
			buttonPanel.add(clearButton);
			add(buttonPanel, BorderLayout.SOUTH);

			ButtonAction buttonAction = new ButtonAction();
			okButton.addActionListener(buttonAction);
			clearButton.addActionListener(buttonAction);

		}

		class ButtonAction implements ActionListener {
			
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(okButton)) {
				if(stuIdTextField.getText().trim().equals(""))
				{
					JOptionPane.showMessageDialog(null, "学生ID信息不能为空","警告", JOptionPane.ERROR_MESSAGE);
					stuIdTextField.setText("");
				}
				else if(new String(pwdField.getPassword()).equals("")){
					JOptionPane.showMessageDialog(null, "密码信息不能为空", "警告", JOptionPane.ERROR_MESSAGE);
					pwdField.setText("");
				}
				else if(Commual.isInteger(stuIdTextField.getText().trim()) == false){
					JOptionPane.showMessageDialog(null, "无效ID，只能为数字形式", "警告", JOptionPane.ERROR_MESSAGE);
					stuIdTextField.setText("");
				}
				else
				{
					EventQueue.invokeLater(new Runnable() {
						
						@Override
						public void run() {
							// TODO 自动生成的方法存根
						String stuName = null;
						StudentEntityDAO stuEntity = new StudentEntityDAOImpl();
		  if((stuName = stuEntity.login(Integer.parseInt(stuIdTextField.getText().trim()),
								new String(pwdField.getPassword())))!=null){
							StuFuncPortalFrame frame = new StuFuncPortalFrame("欢迎学生"+stuName+
									"登陆考勤客户端",Integer.parseInt(stuIdTextField.getText().trim()));							
							frame.parentFrame = StuLoginFrame.this;
							StuLoginFrame.this.setVisible(false);
						}else
						{
			JOptionPane.showMessageDialog(null, "请重新输入密码！", "密码错误", JOptionPane.ERROR_MESSAGE);
			pwdField.setText("");
						}
		  
						}
					});
				}
				} else {
					stuIdTextField.setText("");
					pwdField.setText("");
				}
			}
		}
	}

public static void main(String[] args) {
		StuLoginFrame frame = new StuLoginFrame("学生登陆窗口");
	}  
}
