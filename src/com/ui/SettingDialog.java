package com.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
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
	private JButton applyButton;
	private JButton cancelButton;
	private JCheckBox repeatCheckBox;

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
		autoPanel.setPreferredSize(new Dimension(150, 90));
		autoPanel.setBorder(BorderFactory.createTitledBorder("设置自动/手动停止滚动"));
		autoPanel.setLayout(new BorderLayout(10, 10));

		// 按钮组
		ButtonGroup buttonGroup = new ButtonGroup();

		// 自动停止勾选框
		autoStopCheckBox = new JCheckBox("自动停止", true);
		autoStopCheckBox.setFont(new Font("宋体", Font.PLAIN, 16));
		autoStopCheckBox.setFocusPainted(false);
		autoPanel.add(autoStopCheckBox, BorderLayout.NORTH);

		// 手动停止勾选框
		manualStopCheckBox = new JCheckBox("手动停止");
		manualStopCheckBox.setFont(new Font("宋体", Font.PLAIN, 16));
		manualStopCheckBox.setFocusPainted(false);
		autoPanel.add(manualStopCheckBox, BorderLayout.SOUTH);
		settingPanel.add(autoPanel, BorderLayout.NORTH);

		// 添加进按钮组
		buttonGroup.add(autoStopCheckBox);
		buttonGroup.add(manualStopCheckBox);

		// 重复点名面板
		JPanel repeatPanel = new JPanel();
		repeatPanel.setBorder(BorderFactory.createTitledBorder("设置是否重复点名"));
		repeatPanel.setLayout(new BorderLayout());

		// 重复点名勾选框
		repeatCheckBox = new JCheckBox("重复点名(被点过的名字可以继续重复显示)");
		repeatCheckBox.setFont(new Font("宋体", Font.PLAIN, 16));
		repeatCheckBox.setFocusPainted(false);
		repeatPanel.add(repeatCheckBox, BorderLayout.CENTER);
		settingPanel.add(repeatPanel, BorderLayout.SOUTH);

		getContentPane().add(settingPanel, BorderLayout.WEST);

		// 按钮面板
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BorderLayout());

		// 下
		JPanel downPanel = new JPanel();
		downPanel.setLayout(new BorderLayout());

		// 保存按钮
		applyButton = new JButton("应用");
		applyButton.setPreferredSize(new Dimension(100, 30));
		applyButton.setFont(new Font("宋体", Font.PLAIN, 16));
		applyButton.setFocusPainted(false);
		applyButton.addActionListener(this);
		downPanel.add(applyButton, BorderLayout.NORTH);

		// 取消按钮
		cancelButton = new JButton("取消");
		cancelButton.setPreferredSize(new Dimension(100, 30));
		cancelButton.setFont(new Font("宋体", Font.PLAIN, 16));
		cancelButton.setFocusPainted(false);
		cancelButton.addActionListener(this);
		downPanel.add(cancelButton, BorderLayout.SOUTH);
		buttonPanel.add(downPanel, BorderLayout.SOUTH);

		getContentPane().add(buttonPanel, BorderLayout.EAST);

		validate();
		// 显示界面
		setVisible(true);
	}
}
