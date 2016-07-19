package com.zjc.util;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class WindowsHandler extends WindowAdapter {
public void  windowsActivated(WindowEvent e) {
	super.windowActivated(e);
	// TODO 自动生成的构造函数存根}
}

@Override
	public void windowClosed(WindowEvent e) {
		// TODO 自动生成的方法存根
		super.windowClosed(e);
	}
@Override
	public void windowClosing(WindowEvent e) {
		// TODO 自动生成的方法存根
		System.exit(0);
	}
public void windowDeactivated(WindowEvent e) {
	super.windowDeactivated(e);
}
@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO 自动生成的方法存根
		super.windowDeiconified(e);
	}
}