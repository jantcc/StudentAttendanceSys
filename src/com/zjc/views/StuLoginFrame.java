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
		StuLoginPanel loginPanel = new StuLoginPanel();
		setContentPane(loginPanel);

		// ���ô���������ʾ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}

	public class StuLoginPanel extends JPanel {
		// �����½����Panel�еĿؼ�Ԫ�ء�
		JLabel picLabel;
		JLabel idLabel, pwdLabel;
		JTextField stuIdTextField;
		JPasswordField pwdField;
		JButton okButton, clearButton;
		JPanel buttonPanel, infoPanel;

		// ��½����panel���죬�����пؼ�Ԫ��װ��������

		public StuLoginPanel() {
			picLabel = new JLabel();
			idLabel = new JLabel("ѧ��ID: ");
			pwdLabel = new JLabel("��     ��: ");
			stuIdTextField = new JTextField(20);
			pwdField = new JPasswordField(20);
			okButton = new JButton("��½"); // ����������Ϊ��ť��ʾ�ı�
			clearButton = new JButton("�����Ϣ");

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
					JOptionPane.showMessageDialog(null, "ѧ��ID��Ϣ����Ϊ��","����", JOptionPane.ERROR_MESSAGE);
					stuIdTextField.setText("");
				}
				else if(new String(pwdField.getPassword()).equals("")){
					JOptionPane.showMessageDialog(null, "������Ϣ����Ϊ��", "����", JOptionPane.ERROR_MESSAGE);
					pwdField.setText("");
				}
				else if(Commual.isInteger(stuIdTextField.getText().trim()) == false){
					JOptionPane.showMessageDialog(null, "��ЧID��ֻ��Ϊ������ʽ", "����", JOptionPane.ERROR_MESSAGE);
					stuIdTextField.setText("");
				}
				else
				{
					EventQueue.invokeLater(new Runnable() {
						
						@Override
						public void run() {
							// TODO �Զ����ɵķ������
						String stuName = null;
						StudentEntityDAO stuEntity = new StudentEntityDAOImpl();
		  if((stuName = stuEntity.login(Integer.parseInt(stuIdTextField.getText().trim()),
								new String(pwdField.getPassword())))!=null){
							StuFuncPortalFrame frame = new StuFuncPortalFrame("��ӭѧ��"+stuName+
									"��½���ڿͻ���",Integer.parseInt(stuIdTextField.getText().trim()));							
							frame.parentFrame = StuLoginFrame.this;
							StuLoginFrame.this.setVisible(false);
						}else
						{
			JOptionPane.showMessageDialog(null, "�������������룡", "�������", JOptionPane.ERROR_MESSAGE);
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
		StuLoginFrame frame = new StuLoginFrame("ѧ����½����");
	}  
}
