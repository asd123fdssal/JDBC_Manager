package com.arsud.jdbc.utility;

import javax.swing.JOptionPane;

public class MessageManager {

	public static void showErr(String msg) {
		JOptionPane.showMessageDialog(null, msg, "메시지", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void showMsg(String msg) {
		JOptionPane.showMessageDialog(null, msg, "메시지", JOptionPane.INFORMATION_MESSAGE);
	}
	
}
