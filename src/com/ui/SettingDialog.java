package com.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
		setTitle("设置");
		// 设置大小
		setSize(400, 300);
		setMinimumSize(new Dimension(400, 300));
		// 设置位置
		setLocationRelativeTo(owner);
		// 设置阻塞
		setModal(true);
		// 设置布局
		getContentPane().setLayout(new BorderLayout(10, 10));
		// 设置关闭方式
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// 按钮面板
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BorderLayout());

		validate();
		// 显示界面
		setVisible(true);
	}
}
