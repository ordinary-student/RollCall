package com.ui;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
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

		// 标签
		label = new JLabel("准备点名", SwingConstants.CENTER);
		label.setFont(new Font("宋体", Font.PLAIN, 40));
		getContentPane().add(label, BorderLayout.CENTER);
	}
}
