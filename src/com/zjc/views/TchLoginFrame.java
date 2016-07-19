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
		TchLoginPanel loginPanel = new TchLoginPanel();
		setContentPane(loginPanel);

		// ���ô���������ʾ����
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
			idLabel = new JLabel("�̹�ID��"); // ����������Ϊ��ǩ��ʾ�ı�
			pwdLabel = new JLabel("��    �룺"); // ����������Ϊ��ǩ��ʾ�ı�
			stuIdTextField = new JTextField(20);
			pwdField = new JPasswordField(20);
			okButton = new JButton("��½"); // ����������Ϊ��ť��ʾ�ı�
			clearButton = new JButton("�����Ϣ");

			buttonPanel = new JPanel();
			infoPanel = new JPanel();
			adminCheckBox = new JCheckBox("���ǹ���Ա");
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
										"���ڿͻ���-ѧ����½");
								frame.parentFrame = TchLoginFrame.this;
								TchLoginFrame.this.setVisible(false);
							} else {
								JOptionPane.showMessageDialog(null, "��������������!",
										"�������", JOptionPane.ERROR_MESSAGE);
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
		TchLoginFrame frame = new TchLoginFrame("�̹���½����");
	}  */
}
