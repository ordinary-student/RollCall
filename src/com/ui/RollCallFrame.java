package com.ui;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

import com.utils.WindowUtil;

/**
 * 点名小程序主窗口类
 * 
 * @author ordinary-student
 *
 */
public class RollCallFrame extends KFrame
{
	private static final long serialVersionUID = 2632712392130634764L;
	private JLabel label;
	private JMenuItem editItem;

	/*
	 * 构造方法
	 */
	public RollCallFrame()
	{
		// 初始化界面
		initUI();
	}

	/**
	 * 初始化界面
	 */
	private void initUI()
	{
		// 设置标题
		setTitle("随机点名器");
		// 设置大小
		setSize(400, 300);
		// 设置居中
		WindowUtil.center(this);
		// 设置关闭方式
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// 创建菜单栏
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("宋体", Font.CENTER_BASELINE, 15));

		// 创建菜单
		JMenu settingMenu = new JMenu("设置");

		// 创建菜单项
		editItem = new JMenuItem("编辑名单");
		editItem.addActionListener(this);
		settingMenu.add(editItem);

		menuBar.add(settingMenu);

		// 设置菜单栏
		this.setJMenuBar(menuBar);

		// 标签
		label = new JLabel("准备点名", SwingConstants.CENTER);
		label.setFont(new Font("宋体", Font.PLAIN, 40));
		getContentPane().add(label, BorderLayout.CENTER);

		// 按钮

		validate();
		// 显示界面
		setVisible(true);
	}
}
