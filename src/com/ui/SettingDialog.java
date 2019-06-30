package com.ui;

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
	public SettingDialog()
	{
		// 设置标题
		setTitle("编辑名单");
		// 设置大小
		setSize(400, 300);
		// 设置阻塞
		setModal(true);
		// 设置关闭方式
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		validate();
		// 显示界面
		setVisible(true);
	}
}
