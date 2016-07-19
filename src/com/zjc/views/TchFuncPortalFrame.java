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
		TchFuncPortalPanel FucPortalPanel = new TchFuncPortalPanel();
		setContentPane(FucPortalPanel);
		// ���ô���������ʾ����
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
			viewPersonalInformation = new JButton("�鿴������Ϣ");
			correctPersonalInformation = new JButton("�޸ĸ�����Ϣ");
			correctPersonalPwd = new JButton("�޸ĸ�������");
			viewStuInformation = new JButton("�鿴ѧ����Ϣ");
			viewAttendancerecord= new JButton("�鿴���ڼ�¼");
			inputAttendancerecord= new JButton("¼�뿼�ڼ�¼");
			correctAttendancerecord= new JButton("�޸Ŀ��ڼ�¼");
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
		TchFuncPortalFrame frame = new TchFuncPortalFrame("ѧ������ϵͳ");
	}  */
}