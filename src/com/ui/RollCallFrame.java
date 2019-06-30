package com.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
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
	private JMenuItem startItem;
	private JMenuItem exitItem;
	private JMenuItem editItem;
	private JCheckBoxMenuItem soundItem;
	private JMenuItem settingItem;
	private JLabel label;
	private JButton startButton;

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

		// 创建菜单
		JMenu startMenu = new JMenu("开始");
		JMenu editMenu = new JMenu("编辑");
		JMenu settingMenu = new JMenu("设置");

		// 创建菜单项
		startItem = new JMenuItem("开始点名");
		startItem.addActionListener(this);
		startMenu.add(startItem);
		startMenu.addSeparator();
		exitItem = new JMenuItem("退出");
		exitItem.addActionListener(this);
		startMenu.add(exitItem);
		menuBar.add(startMenu);

		// 编辑
		editItem = new JMenuItem("编辑名单");
		editItem.addActionListener(this);
		editMenu.add(editItem);
		menuBar.add(editMenu);

		// 设置
		soundItem = new JCheckBoxMenuItem("静音");
		soundItem.addActionListener(this);
		settingMenu.add(soundItem);
		settingMenu.addSeparator();
		settingItem = new JMenuItem("设置...");
		settingItem.addActionListener(this);
		settingMenu.add(settingItem);

		menuBar.add(settingMenu);

		// 设置菜单栏
		this.setJMenuBar(menuBar);

		// 标签
		label = new JLabel("准备点名", SwingConstants.CENTER);
		label.setFont(new Font("宋体", Font.PLAIN, 50));
		getContentPane().add(label, BorderLayout.CENTER);

		// 按钮
		startButton = new JButton("开始");
		startButton.setPreferredSize(new Dimension(400, 50));
		startButton.setFont(new Font("宋体", Font.PLAIN, 20));
		startButton.setFocusPainted(false);
		startButton.addActionListener(this);
		getContentPane().add(startButton, BorderLayout.SOUTH);

		validate();
		// 显示界面
		setVisible(true);
	}
}
