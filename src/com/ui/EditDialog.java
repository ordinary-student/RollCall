package com.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.utils.FileUtil;

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
	private JButton importButton;
	private JButton saveButton;
	private JButton cancelButton;

	/**
	 * 构造方法
	 */
	public EditDialog(JFrame owner)
	{
		// 初始化界面
		initUI(owner);
	}

	/**
	 * 初始化界面
	 * 
	 * @param owner
	 */
	public void initUI(JFrame owner)
	{
		// 设置标题
		setTitle("编辑名单");
		// 设置大小
		setSize(400, 300);
		setMinimumSize(new Dimension(400, 300));
		// 设置位置
		setLocationRelativeTo(owner);
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
		textArea.setBackground(new Color(245, 245, 245));
		textArea.setEditable(false);
		getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);
		// 显示已有名字
		showNames();

		// 按钮面板
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BorderLayout());

		// 上
		JPanel upPanel = new JPanel();
		upPanel.setLayout(new BorderLayout(10, 10));

		// 编辑按钮
		editButton = new JButton("编辑");
		editButton.setPreferredSize(new Dimension(100, 30));
		editButton.setFont(new Font("宋体", Font.PLAIN, 16));
		editButton.setFocusPainted(false);
		editButton.addActionListener(this);
		upPanel.add(editButton, BorderLayout.NORTH);

		// 导入按钮
		importButton = new JButton("导入...");
		importButton.setPreferredSize(new Dimension(100, 30));
		importButton.setFont(new Font("宋体", Font.PLAIN, 16));
		importButton.setFocusPainted(false);
		importButton.addActionListener(this);
		upPanel.add(importButton, BorderLayout.SOUTH);
		buttonPanel.add(upPanel, BorderLayout.NORTH);

		// 下
		JPanel downPanel = new JPanel();
		downPanel.setLayout(new BorderLayout(10, 10));

		// 保存按钮
		saveButton = new JButton("保存");
		saveButton.setPreferredSize(new Dimension(100, 30));
		saveButton.setFont(new Font("宋体", Font.PLAIN, 16));
		saveButton.setFocusPainted(false);
		saveButton.addActionListener(this);
		downPanel.add(saveButton, BorderLayout.NORTH);

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

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// 判断来源
		if (e.getSource() == editButton)
		{
			// 编辑
			textArea.setEditable(true);
			textArea.setBackground(Color.white);

		} else if (e.getSource() == importButton)
		{
			// 导入名单
			importNames();

		} else if (e.getSource() == saveButton)
		{
			// 保存
			save();

		} else if (e.getSource() == cancelButton)
		{
			// 取消
			this.dispose();
		}
	}

	/**
	 * 导入名单
	 */
	private void importNames()
	{
		// 创建文件选择器
		JFileChooser fileChooser = new JFileChooser();
		// 设置文件选择模式
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		// 设置标题
		fileChooser.setDialogTitle("打开文件");
		// 显示弹窗
		int result = fileChooser.showOpenDialog(this);
		// 选择取消
		if (result == JFileChooser.CANCEL_OPTION)
		{
			// 退出方法
			return;
		}

		// 获取选择的文件
		File selectedFile = fileChooser.getSelectedFile();
		// 获取文件名
		String fileName = fileChooser.getName(selectedFile);

		// 判断
		if ((selectedFile == null) || (fileName.equals("")))
		{
			JOptionPane.showMessageDialog(this, "不合法的文件名", "不合法的文件名", JOptionPane.ERROR_MESSAGE);
			// 退出方法
			return;
		}

		// 读取文件
		String allNames = FileUtil.readFile(selectedFile);
		// 分割
		String[] names = allNames.split("\n");
		// 遍历显示
		for (String name : names)
		{
			textArea.append(name);
			textArea.append("\r\n");
		}
	}

	/**
	 * 保存
	 */
	private void save()
	{
		// 清空集合
		RollCallFrame.list.clear();
		// 分割
		String[] names = textArea.getText().split("\n");
		// 遍历保存进集合
		for (String name : names)
		{
			RollCallFrame.list.add(name);
		}

		textArea.setEditable(false);
		textArea.setBackground(new Color(245, 245, 245));
	}

	/*
	 * 显示名字
	 */
	private void showNames()
	{
		// 有数据
		if (RollCallFrame.list.size() > 0)
		{
			// 遍历
			for (String name : RollCallFrame.list)
			{
				textArea.append(name);
				textArea.append("\r\n");
			}
		}
	}
}
