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
		// ���ô����С
		
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		// ���ô������
		setTitle(title);
		
		stuid = id;
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
		StuFuncPortalPanel FucPortalPanel = new StuFuncPortalPanel();
		setContentPane(FucPortalPanel);
		// ���ô���������ʾ����
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
			viewPersonalInformation = new JButton("�鿴������Ϣ");
			correctPersonalInformation = new JButton("�޸ĸ�����Ϣ");
			correctPersonalPwd = new JButton("�޸ĸ�������");
			viewTeacherInformation = new JButton("�鿴��ʦ��Ϣ");
			viewCourseInformation = new JButton("�鿴�γ���Ϣ");
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
			courseID = new JLabel("������Ҫ��ѯ�Ŀ��ڼ�¼�Ŀγ̱��:");
			courseIDTextField = new JTextField(20);
			check = new JButton("��ѯ");
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
										"ѧ��������Ϣ",stuid);
							frame.parentFrame = StuFuncPortalFrame.this;
							StuFuncPortalFrame.this.setVisible(false);
						}
					 });
				   }
				else if (e.getSource().equals(correctPersonalInformation)) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
						
							noFrame frame = new noFrame(
										"ѧ��������Ϣ");
							frame.parentFrame = StuFuncPortalFrame.this;
							StuFuncPortalFrame.this.setVisible(false);
						}
					 });
				   }
				else if (e.getSource().equals(correctPersonalPwd)) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
						
							StucorrectpwdFrame frame = new StucorrectpwdFrame(
										"ѧ��������Ϣ",stuid);
							frame.parentFrame = StuFuncPortalFrame.this;
							StuFuncPortalFrame.this.setVisible(false);
						}
					 });
				   }
				else if (e.getSource().equals(viewTeacherInformation)) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
						
							ViewtchinformationFrame frame = new ViewtchinformationFrame(
										"�鿴��ʦ��Ϣ",stuid);
							frame.parentFrame = StuFuncPortalFrame.this;
							StuFuncPortalFrame.this.setVisible(false);
						}
					 });
				   }
				else if (e.getSource().equals(viewCourseInformation)) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
						
							ViewCourseinformationFrame frame = new ViewCourseinformationFrame(
										"�鿴�γ���Ϣ");
							frame.parentFrame = StuFuncPortalFrame.this;
							StuFuncPortalFrame.this.setVisible(false);
						}
					 });
				   }
				else if (e.getSource().equals(check)) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try
							{	Vector<String> columnName1 = new Vector<String>();//�ֶ���
							Vector<Vector<Object>> dataVector = new    
				                    Vector<Vector<Object>>(); 
							columnName1.add("����ʱ��");
							columnName1.add("���ڿγ�");
							columnName1.add("���ڽ��");
							
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
								   DatabaseConnection.close(rs); // �رս����
									DatabaseConnection.close(stmt); // �ر�Ԥ�������
									DatabaseConnection.close(conn); // �ر����Ӷ���
								   
								  
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
