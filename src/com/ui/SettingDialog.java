package com.ui;

import javax.swing.JFrame;

/**
 * 设置窗口类
 * 
 * @author ordinary-student
 *
 */
public class SettingDialog extends KDialog
{
	private static final long serialVersionUID = -1868260515328289597L;

	/*
	 * 构造方法
	 */
	public SettingDialog(JFrame owner)
	{
		// 设置标题
		setTitle("编辑名单");
		// 设置大小
		setSize(400, 300);
		// 设置位置
		setLocationRelativeTo(owner);
		// 设置阻塞
		setModal(true);
		// 设置关闭方式
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		validate();
		// 显示界面
		setVisible(true);
	}
}
