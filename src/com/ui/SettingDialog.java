package com.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
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
	private JCheckBox autoStopCheckBox;
	private JCheckBox manualStopCheckBox;

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

		// 设置面板
		JPanel settingPanel = new JPanel();
		settingPanel.setLayout(new BorderLayout());

		// 自动设置
		JPanel autoPanel = new JPanel();
		autoPanel.setLayout(new BorderLayout());

		// 按钮组
		ButtonGroup buttonGroup = new ButtonGroup();

		// 自动停止勾选框
		autoStopCheckBox = new JCheckBox("自动停止", true);
		autoStopCheckBox.setFont(new Font("宋体", Font.PLAIN, 16));
		autoStopCheckBox.setFocusPainted(false);

		// 手动停止勾选框
		manualStopCheckBox = new JCheckBox("手动停止");
		manualStopCheckBox.setFont(new Font("宋体", Font.PLAIN, 16));
		manualStopCheckBox.setFocusPainted(false);

		// 添加进按钮组
		buttonGroup.add(autoStopCheckBox);
		buttonGroup.add(manualStopCheckBox);

		// 按钮面板
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BorderLayout());

		validate();
		// 显示界面
		setVisible(true);
	}
}
