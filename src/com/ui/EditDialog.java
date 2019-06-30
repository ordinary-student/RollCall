package com.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 编辑名单窗口
 * 
 * @author ordinary-student
 *
 */
public class EditDialog extends KDialog
{
	private static final long serialVersionUID = -2252920404325741684L;
	private JTextArea textArea;
	private JButton editButton;
	private JButton saveButton;

	/**
	 * 构造方法
	 */
	public EditDialog()
	{
		// 设置标题
		setTitle("编辑名单");
		// 设置大小
		setSize(400, 300);
		setMinimumSize(new Dimension(400, 300));
		// 设置阻塞
		setModal(true);
		// 设置布局
		getContentPane().setLayout(new BorderLayout(10, 10));
		// 设置边框
		((JComponent) getContentPane()).setBorder(BorderFactory.createTitledBorder("编辑名单，一行一个名字"));
		// 设置关闭方式
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// 编辑区
		textArea = new JTextArea();
		textArea.setFont(new Font("宋体", Font.PLAIN, 18));
		getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);

		// 按钮面板
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BorderLayout());

		// 编辑按钮
		editButton = new JButton("编辑");
		editButton.setPreferredSize(new Dimension(100, 30));
		editButton.setFont(new Font("宋体", Font.PLAIN, 16));
		editButton.setFocusPainted(false);
		editButton.addActionListener(this);
		buttonPanel.add(editButton, BorderLayout.NORTH);

		// 保存按钮
		saveButton = new JButton("保存");
		saveButton.setPreferredSize(new Dimension(100, 30));
		saveButton.setFont(new Font("宋体", Font.PLAIN, 16));
		saveButton.setFocusPainted(false);
		saveButton.addActionListener(this);
		buttonPanel.add(saveButton, BorderLayout.SOUTH);

		getContentPane().add(buttonPanel, BorderLayout.EAST);

		validate();
		// 显示界面
		setVisible(true);
	}

}
