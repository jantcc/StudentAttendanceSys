package com.zjc.views;

import java.awt.BorderLayout;	
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.zjc.util.DatabaseConnection;
import com.zjc.views.StuLoginFrame.StuLoginPanel;

public class StuFuncPortalFrame extends JFrame {
	
	
	private static final int DEFAULT_WIDTH = 500;
	private static final int DEFAULT_HEIGHT = 450;	
	private int stuid = 0;
	protected JFrame parentFrame;


	
	

	public StuFuncPortalFrame(String title,int id) {
		// 设置窗体大小
		
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		// 设置窗体标题
		setTitle(title);
		
		stuid = id;
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
		StuFuncPortalPanel FucPortalPanel = new StuFuncPortalPanel();
		setContentPane(FucPortalPanel);
		// 设置窗口其他显示属性
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}

	public class StuFuncPortalPanel extends JPanel {
		JLabel stupicLabel;
		JLabel stuidLabel;
		JLabel courseID;
		JButton viewPersonalInformation;
		JButton correctPersonalInformation;
		JButton correctPersonalPwd;
		JButton viewTeacherInformation;
		JButton viewCourseInformation;
		JButton check;
		JTable resultshow;
		JTextField courseIDTextField;
		JPanel JPanel01, JPanel02, JPanel03, JPanel04;

		public StuFuncPortalPanel() {
			String s ="";
			s=String.valueOf(stuid);
			stupicLabel = new JLabel();
			stuidLabel = new JLabel();
			stuidLabel.setText(s);
			JPanel01 = new JPanel();
			JPanel01.setLayout(new FlowLayout(FlowLayout.CENTER));
			JPanel01.setBounds(0, 0, 150, 145);
			JPanel01.setBorder(BorderFactory.createEtchedBorder());
			ImageIcon image = new ImageIcon(this.getClass().getResource(
					"/images/001.jpg"));
			image.setImage(image.getImage().getScaledInstance(140, 100,
					Image.SCALE_DEFAULT));
			stupicLabel.setIcon(image);
			
			JPanel01.add(stupicLabel);
			JPanel01.add(stuidLabel);
			setLayout(null);
			add(JPanel01);
			viewPersonalInformation = new JButton("查看个人信息");
			correctPersonalInformation = new JButton("修改个人信息");
			correctPersonalPwd = new JButton("修改个人密码");
			viewTeacherInformation = new JButton("查看教师信息");
			viewCourseInformation = new JButton("查看课程信息");
			JPanel02 = new JPanel();
			JPanel02.setLayout(new FlowLayout(FlowLayout.CENTER));
			JPanel02.setBounds(0, 150, 150, 265);
			JPanel02.setBorder(BorderFactory.createEtchedBorder());
			JPanel02.add(viewPersonalInformation);
			JPanel02.add(correctPersonalInformation);
			JPanel02.add(correctPersonalPwd);
			JPanel02.add(viewTeacherInformation);
			JPanel02.add(viewCourseInformation);
			add(JPanel02);
			JPanel03 = new JPanel();
			courseID = new JLabel("请输入要查询的考勤记录的课程编号:");
			courseIDTextField = new JTextField(20);
			check = new JButton("查询");
			JPanel03.setLayout(new FlowLayout(FlowLayout.LEFT));
			JPanel03.setBorder(BorderFactory.createEtchedBorder());
			JPanel03.setBounds(160, 0, 340, 70);
			JPanel03.add(courseID);
			JPanel03.add(courseIDTextField);
			JPanel03.add(check);
			add(JPanel03);
			JPanel04 = new JPanel();
			resultshow = new JTable();
			JPanel04.setLayout(new FlowLayout(FlowLayout.LEFT));
			JPanel04.setBounds(160, 70, 330, 345);
			
			resultshow.setEnabled(false);
			JScrollPane scrollPanel = new JScrollPane(resultshow,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			JPanel04.add(scrollPanel);
			add(JPanel04);
			ButtonAction buttonaction = new ButtonAction();
			viewPersonalInformation.addActionListener(buttonaction);
			correctPersonalInformation.addActionListener(buttonaction);
			correctPersonalPwd.addActionListener(buttonaction);
			viewTeacherInformation.addActionListener(buttonaction);
			viewCourseInformation.addActionListener(buttonaction);
			check.addActionListener(buttonaction);
			
			
		}
class ButtonAction implements ActionListener {
			
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(viewPersonalInformation)) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
						
							StuinformationFrame frame = new StuinformationFrame(
										"学生个人信息",stuid);
							frame.parentFrame = StuFuncPortalFrame.this;
							StuFuncPortalFrame.this.setVisible(false);
						}
					 });
				   }
				else if (e.getSource().equals(correctPersonalInformation)) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
						
							noFrame frame = new noFrame(
										"学生个人信息");
							frame.parentFrame = StuFuncPortalFrame.this;
							StuFuncPortalFrame.this.setVisible(false);
						}
					 });
				   }
				else if (e.getSource().equals(correctPersonalPwd)) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
						
							StucorrectpwdFrame frame = new StucorrectpwdFrame(
										"学生个人信息",stuid);
							frame.parentFrame = StuFuncPortalFrame.this;
							StuFuncPortalFrame.this.setVisible(false);
						}
					 });
				   }
				else if (e.getSource().equals(viewTeacherInformation)) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
						
							ViewtchinformationFrame frame = new ViewtchinformationFrame(
										"查看教师信息",stuid);
							frame.parentFrame = StuFuncPortalFrame.this;
							StuFuncPortalFrame.this.setVisible(false);
						}
					 });
				   }
				else if (e.getSource().equals(viewCourseInformation)) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
						
							ViewCourseinformationFrame frame = new ViewCourseinformationFrame(
										"查看课程信息");
							frame.parentFrame = StuFuncPortalFrame.this;
							StuFuncPortalFrame.this.setVisible(false);
						}
					 });
				   }
				else if (e.getSource().equals(check)) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try
							{	Vector<String> columnName1 = new Vector<String>();//字段名
							Vector<Vector<Object>> dataVector = new    
				                    Vector<Vector<Object>>(); 
							columnName1.add("考勤时间");
							columnName1.add("考勤课程");
							columnName1.add("考勤结果");
							
								Connection conn = DatabaseConnection.getConnection();
								 Statement stmt = conn.createStatement();
								 String querySQL="SELECT attendance_time,course_name,attendance_status FROM mystatus WHERE class_id="+courseIDTextField.getText();
								   ResultSet rs=stmt.executeQuery(querySQL);
							
								
								   while(rs.next()){
									 
									   Vector<Object> vec = new Vector<Object>();
									   for(int i=1;i<=3;i++){
										   vec.add(rs.getObject(i));
										   }
										   dataVector.add(vec);
									   }
								   DefaultTableModel tmhavesold = new DefaultTableModel();
								   tmhavesold.setDataVector(dataVector, columnName1);
								   resultshow.setModel(tmhavesold);
								   DatabaseConnection.close(rs); // 关闭结果集
									DatabaseConnection.close(stmt); // 关闭预处理对象
									DatabaseConnection.close(conn); // 关闭连接对象
								   
								  
							}
							catch(Exception e)
							{
								e.getStackTrace();
							} 
						}
					 });
				   }  
				}
			}
			
	}

	public static void main(String[] args) {
		StuFuncPortalFrame frame = new StuFuncPortalFrame("",001);
	}  
}
