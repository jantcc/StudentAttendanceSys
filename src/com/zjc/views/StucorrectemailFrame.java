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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.zjc.dao.StudentEntityDAO;
import com.zjc.dao.impl.StudentEntityDAOImpl;
import com.zjc.util.DatabaseConnection;



public class StucorrectemailFrame extends JFrame{
	
	private static final int DEFAULT_WIDTH = 350;
	private static final int DEFAULT_HEIGHT = 350;
	protected JFrame parentFrame;
	private int stuid2 = 0;

	public StucorrectemailFrame(String title,int id) {
		// 设置窗体大小
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		// 设置窗体标题
		setTitle(title);
		stuid2 = id;
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
		StucorrectemailPanel FucPortalPanel = new StucorrectemailPanel();
		setContentPane(FucPortalPanel);
		// 设置窗口其他显示属性
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}
	public class StucorrectemailPanel extends JPanel {
	JLabel stuname,stuid,stucollege,stumajor,stuemail,stupicts,stupic;
	JTextField stunameTextField,stuidTextField,stucollegeTextField,stumajorTextField,stuemailTextField;
	JButton correctpic,correctemail,back;
	JPanel JPanel001,JPanel002,JPanel01,JPanel02;
	
public StucorrectemailPanel() {
	
		JPanel001 = new JPanel();
		JPanel01 =new JPanel();
		JPanel01.setLayout(null);
		setLayout(new BorderLayout());
		stuname = new JLabel("学生");
		stunameTextField = new JTextField(20);
		stunameTextField.setEditable(false);
		stuid = new JLabel("学号");
		stuidTextField = new JTextField(20);
		stuidTextField.setEditable(false);
		stucollege = new JLabel("所属学院");
		stucollegeTextField = new JTextField(20);
		stucollegeTextField.setEditable(false);
		stumajor = new JLabel("所属专业");
		stumajorTextField = new JTextField(20);
		stumajorTextField.setEditable(false);
		stuemail = new JLabel("电子邮箱");
		stuemailTextField = new JTextField(20);
		JPanel001.setBounds(0, 0, 160, 340);
		JPanel001.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel001.add(stuname);
		JPanel001.add(stunameTextField);
		JPanel001.add(stuid);
		JPanel001.add(stuidTextField);
		JPanel001.add(stucollege);
		JPanel001.add(stucollegeTextField);
		JPanel001.add(stumajor);
		JPanel001.add(stumajorTextField);
		JPanel001.add(stuemail);
		JPanel001.add(stuemailTextField);
		JPanel01.add(JPanel001);
		add(JPanel01, BorderLayout.CENTER);
		
		JPanel002 = new JPanel();
		JPanel002.setBounds(200, 0, 140, 180);
		JPanel002.setLayout(new FlowLayout(FlowLayout.CENTER));
		stupicts = new JLabel("个人照片");
		stupic = new JLabel();
		ImageIcon image = new ImageIcon(this.getClass().getResource(
				"/images/001.jpg"));
		image.setImage(image.getImage().getScaledInstance(140, 100,
				Image.SCALE_DEFAULT));
		stupic.setIcon(image);
		correctpic = new JButton("修改个人照片");
		JPanel002.add(stupicts);
		JPanel002.add(stupic);
		JPanel002.add(correctpic);
		JPanel01.add(JPanel002);
		correctemail = new JButton("确定修改");
		back = new JButton("返回上级菜单");
		JPanel02 = new JPanel();
		JPanel02.setLayout(new FlowLayout(FlowLayout.CENTER));
		JPanel02.add(correctemail);
		JPanel02.add(back);
		add(JPanel02,BorderLayout.SOUTH);
		ButtonAction buttonaction = new ButtonAction();
		back.addActionListener(buttonaction);
		correctemail.addActionListener(buttonaction);
		
		try
		{	int returnVal=-1;
			Connection conn = DatabaseConnection.getConnection();
			 Statement stmt = conn.createStatement();
			 String querySQL="SELECT * FROM studentinfo WHERE student_id = "+stuid2;
			   ResultSet rs=stmt.executeQuery(querySQL);		  
			   while(rs.next()){
			   stunameTextField.setText(rs.getString("student_name"));
			   stuidTextField.setText(rs.getString("student_id"));
			   stucollegeTextField.setText(rs.getString("student_college"));
			   stumajorTextField.setText(rs.getString("student_major"));		   
			   }
			   DatabaseConnection.close(rs);
			   DatabaseConnection.close(stmt);
			   DatabaseConnection.close(conn);
			
		}
		catch(Exception e)
		{
			e.getStackTrace();
		} 
		
	}
class ButtonAction implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(back)) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					StucorrectemailFrame.this.dispose();
					parentFrame.setVisible(true);
				}
			 });
		   }
		else if (e.getSource().equals(correctemail)) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					StudentEntityDAO stuEntity = new StudentEntityDAOImpl();
					stuEntity.updateStudentEmail(stuid2, new String(stuemailTextField.getText()));
					JOptionPane.showMessageDialog(null,
							"邮箱修改完成！", "邮箱修改结果提示",JOptionPane.INFORMATION_MESSAGE);
						StucorrectemailFrame.this.dispose();
						StuFuncPortalFrame frame = new StuFuncPortalFrame("学生个人信息",stuid2);	
						
	 			}
			 });
		   }  
		}
	}  
}

	public static void main(String args[]){
		StuinformationFrame frame = new StuinformationFrame("学生个人信息",001);
	}
}

	
