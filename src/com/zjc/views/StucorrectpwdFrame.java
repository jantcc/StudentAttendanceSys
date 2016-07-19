package com.zjc.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import com.zjc.dao.StudentEntityDAO;
import com.zjc.dao.impl.StudentEntityDAOImpl;



public class StucorrectpwdFrame extends JFrame{

	private static final int DEFAULT_WIDTH = 350;
	private static final int DEFAULT_HEIGHT = 200;
	protected JFrame parentFrame;
	private int stuid3 = 0;

	public StucorrectpwdFrame(String title,int id) {
		// 设置窗体大小
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		// 设置窗体标题
		setTitle(title);
		stuid3 = id;
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
		StucorrectpwdPanel FucPortalPanel = new StucorrectpwdPanel();
		setContentPane(FucPortalPanel);
		// 设置窗口其他显示属性
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}

	public class StucorrectpwdPanel extends JPanel {
		JLabel nowpwd,newpwd,okpwd;
		JPasswordField nowpwdField,newpwdField,okpwdField;
		JButton correctpwd,back;
		JPanel JPanel01,JPanel02;
	public StucorrectpwdPanel() {
			JPanel01 = new JPanel();
			setLayout(new BorderLayout());
			JPanel01.setLayout(new FlowLayout(FlowLayout.CENTER));
			JPanel01.setBorder(BorderFactory.createTitledBorder("修改密码"));
			nowpwd = new JLabel("   当前密码  ");
			nowpwdField = new JPasswordField(20);
			newpwd = new JLabel("    新密码      ");
			newpwdField = new JPasswordField(20);
			okpwd = new JLabel("   确认密码  ");
			okpwdField = new JPasswordField(20);
			JPanel01.add(nowpwd);
			JPanel01.add(nowpwdField);
			JPanel01.add(newpwd);
			JPanel01.add(newpwdField);
			JPanel01.add(okpwd);
			JPanel01.add(okpwdField);
			add(JPanel01,BorderLayout.CENTER);
			JPanel02 = new JPanel();
			JPanel02.setLayout(new FlowLayout(FlowLayout.CENTER));
			correctpwd = new JButton("确定修改");
			back = new JButton("返回上级菜单");
			JPanel02.add(correctpwd);
			JPanel02.add(back);
			add(JPanel02,BorderLayout.SOUTH);
			ButtonAction buttonaction = new ButtonAction();
			back.addActionListener(buttonaction);
			correctpwd.addActionListener(buttonaction);
		}
	class ButtonAction implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(back)) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {	
						
						StucorrectpwdFrame.this.dispose();
						parentFrame.setVisible(true);
					}
				 });
			   }
			else if (e.getSource().equals(correctpwd)) {
				EventQueue.invokeLater(new Runnable() {
					
					public void run() {
						StudentEntityDAO stuEntity1 = new StudentEntityDAOImpl();
						if(new String(nowpwdField.getPassword()).equals("")){
							JOptionPane.showMessageDialog(null, "原密码不能为空", "警告", JOptionPane.ERROR_MESSAGE);
							nowpwdField.setText("");
						}
						else	if(new String(newpwdField.getPassword()).equals("")){
							JOptionPane.showMessageDialog(null, "新密码不能为空", "警告", JOptionPane.ERROR_MESSAGE);
							newpwdField.setText("");
						}
						else	if(new String(okpwdField.getPassword()).equals("")){
							JOptionPane.showMessageDialog(null, "确定新密码不能为空", "警告", JOptionPane.ERROR_MESSAGE);
							okpwdField.setText("");
						}
						else	if(!new String(okpwdField.getPassword()).equals(new String(newpwdField.getPassword())))
						{
							JOptionPane.showMessageDialog(null, "新密码与确定新密码不一致", "警告", JOptionPane.ERROR_MESSAGE);
							newpwdField.setText("");
							okpwdField.setText("");
						} 
						else	if(!new String(nowpwdField.getPassword()).equals(stuEntity1.getpwd(stuid3)))
						{
							JOptionPane.showMessageDialog(null, "原密码填写错误", "警告", JOptionPane.ERROR_MESSAGE);
							newpwdField.setText("");
							okpwdField.setText("");
							nowpwdField.setText("");
						} 
						else  {
						StudentEntityDAO stuEntity = new StudentEntityDAOImpl();
						stuEntity.updateStudentPwd(stuid3, new String(nowpwdField.getPassword()), new String(newpwdField.getPassword()));
						JOptionPane.showMessageDialog(null, "密码修改成功", "恭喜", JOptionPane.INFORMATION_MESSAGE);
						StucorrectpwdFrame.this.dispose();
						StuLoginFrame frame = new StuLoginFrame("学生考勤系统");
					};					
				}
				 });
			   }
			}
		}
	}
		public static void main(String args[]){
			StucorrectpwdFrame frame = new StucorrectpwdFrame("学生个人信息",001);
		}

	}


