package com.zjc.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import com.zjc.views.TchLoginFrame.TchLoginPanel;

public class TchFuncPortalFrame extends JFrame {
	private static final int DEFAULT_WIDTH = 500;
	private static final int DEFAULT_HEIGHT = 450;
	protected TchLoginFrame parentFrame;

	public TchFuncPortalFrame(String title) {
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
		TchFuncPortalPanel FucPortalPanel = new TchFuncPortalPanel();
		setContentPane(FucPortalPanel);
		// 设置窗口其他显示属性
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}

	public class TchFuncPortalPanel extends JPanel {
		JLabel tchpicLabel;
		JLabel tchidLabel;
		JLabel courseID;
		JButton viewPersonalInformation;
		JButton correctPersonalInformation;
		JButton correctPersonalPwd;
		JButton viewStuInformation;
		JButton viewAttendancerecord;
		JButton inputAttendancerecord;
		JButton correctAttendancerecord;
		JButton check;
		JTable resultshow;
		JTextField courseIDTextField;
		JPanel JPanel01, JPanel02, JPanel03, JPanel04;

		public TchFuncPortalPanel() {
			tchpicLabel = new JLabel();
			tchidLabel = new JLabel("10001");
			JPanel01 = new JPanel();
			JPanel01.setLayout(new FlowLayout(FlowLayout.CENTER));
			JPanel01.setBounds(0, 0, 150, 145);
			JPanel01.setBorder(BorderFactory.createEtchedBorder());
			ImageIcon image = new ImageIcon(this.getClass().getResource(
					"/images/002.jpg"));
			image.setImage(image.getImage().getScaledInstance(140, 100,
					Image.SCALE_DEFAULT));
			tchpicLabel.setIcon(image);
			JPanel01.add(tchpicLabel);
			JPanel01.add(tchidLabel);
			setLayout(null);
			add(JPanel01);
			viewPersonalInformation = new JButton("查看个人信息");
			correctPersonalInformation = new JButton("修改个人信息");
			correctPersonalPwd = new JButton("修改个人密码");
			viewStuInformation = new JButton("查看学生信息");
			viewAttendancerecord= new JButton("查看考勤记录");
			inputAttendancerecord= new JButton("录入考勤记录");
			correctAttendancerecord= new JButton("修改考勤记录");
			JPanel02 = new JPanel();
			JPanel02.setLayout(new FlowLayout(FlowLayout.CENTER));
			JPanel02.setBounds(0, 150, 150, 265);
			JPanel02.setBorder(BorderFactory.createEtchedBorder());
			JPanel02.add(viewPersonalInformation);
			JPanel02.add(correctPersonalInformation);
			JPanel02.add(correctPersonalPwd);
			JPanel02.add(viewStuInformation);
			JPanel02.add(viewAttendancerecord);
			JPanel02.add(inputAttendancerecord);
			JPanel02.add(correctAttendancerecord);
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
			DefaultTableModel defaulttablemodel = new DefaultTableModel();
			resultshow = new JTable(defaulttablemodel);
			Object[] data = new Object[7];
			JScrollPane jsp = new JScrollPane(resultshow);
			for (int column = 0; column < 4; column++) {
				defaulttablemodel.addColumn("Column " + column);
			}
			for (int row = 0; row < 100; row++) {
				for (int column = 0; column < 7; column++) {
					data[column] = "Cell " + row + "," + column;
				}
				defaulttablemodel.addRow(data);
			}
			resultshow.setAutoResizeMode(0);
			JPanel04.add(jsp);
			add(JPanel04);
		}
	}

/*	public static void main(String[] args) {
		TchFuncPortalFrame frame = new TchFuncPortalFrame("学生考勤系统");
	}  */
}