package com.ui;

/**
 * 编辑名单窗口
 * 
 * @author ordinary-student
 *
 */
public class EditDialog extends KDialog
{
	private static final long serialVersionUID = -2252920404325741684L;

	/**
	 * 构造方法
	 */
	public EditDialog()
	{
		// 设置标题
		setTitle("编辑名单");
		// 设置大小
		setSize(400, 300);
		// 设置阻塞
		setModal(true);
		// 设置关闭方式
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		validate();
		// 显示界面
		setVisible(true);
	}

}
