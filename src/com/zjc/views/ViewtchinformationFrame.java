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
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import com.zjc.util.DatabaseConnection;
import com.zjc.views.StucorrectpwdFrame.StucorrectpwdPanel;

public class ViewtchinformationFrame extends JFrame{

	
	
	private static final int DEFAULT_WIDTH = 500;
	private static final int DEFAULT_HEIGHT = 380;
	protected JFrame parentFrame;
	private int stuid11 = 0;
	

	public ViewtchinformationFrame(String title,int id) {
		// 设置窗体大小
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		// 设置窗体标题
		setTitle(title);
		stuid11=id;
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
		ViewtchinformationPanel FucPortalPanel = new ViewtchinformationPanel();
		setContentPane(FucPortalPanel);
		// 设置窗口其他显示属性
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}
	
	public class ViewtchinformationPanel extends JPanel {
		JTable resultshow;
		JButton back;
		JPanel JPanel01,JPanel02;
		public ViewtchinformationPanel(){
			back = new JButton("返回上级菜单");	
			
			resultshow = new JTable();
			resultshow.setRowHeight(20);
			resultshow.setEnabled(false);
			JScrollPane scrollPanel = new JScrollPane(resultshow,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			setLayout(new BorderLayout());
			JPanel01 = new JPanel();
			JPanel01.setLayout(new FlowLayout(FlowLayout.LEFT));
			JPanel01.add(scrollPanel);
			JPanel02 = new JPanel();
			JPanel02.setLayout(new FlowLayout(FlowLayout.CENTER));
			JPanel02.add(back);
			add(JPanel01,BorderLayout.CENTER);
			add(JPanel02,BorderLayout.SOUTH);
			ButtonAction buttonaction = new ButtonAction();
			back.addActionListener(buttonaction);
			try
			{	Vector<String> columnName1 = new Vector<String>();//字段名
			Vector<Vector<Object>> dataVector = new    
                    Vector<Vector<Object>>(); 
			columnName1.add("姓名");
			columnName1.add("所属教研室");
			columnName1.add("所属学院");
			
				Connection conn = DatabaseConnection.getConnection();
				 Statement stmt = conn.createStatement();
				 String querySQL="SELECT teacher_name,faculty_name,college_name FROM teacherinfo ";
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
		class ButtonAction implements ActionListener {
			
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(back)) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							ViewtchinformationFrame.this.dispose();
							parentFrame.setVisible(true);
						}
					 });
				   }
				}
			}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ViewtchinformationFrame frame = new ViewtchinformationFrame("查看教师信息",001);
	}

}
