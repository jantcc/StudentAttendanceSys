package com.zjc.util;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class WindowsHandler extends WindowAdapter {
public void  windowsActivated(WindowEvent e) {
	super.windowActivated(e);
	// TODO �Զ����ɵĹ��캯�����}
}

@Override
	public void windowClosed(WindowEvent e) {
		// TODO �Զ����ɵķ������
		super.windowClosed(e);
	}
@Override
	public void windowClosing(WindowEvent e) {
		// TODO �Զ����ɵķ������
		System.exit(0);
	}
public void windowDeactivated(WindowEvent e) {
	super.windowDeactivated(e);
}
@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO �Զ����ɵķ������
		super.windowDeiconified(e);
	}
}