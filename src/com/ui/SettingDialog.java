package com.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
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
	private JComboBox<String> timeComboBox;
	private JCheckBox repeatCheckBox;
	private JButton defaultButton;
	private JButton applyButton;
	private JButton cancelButton;

	/*
	 * 构造方法
	 */
	public SettingDialog(JFrame owner)
	{
		// 初始化界面
		initUI(owner);
	}

	/*
	 * 初始化界面
	 */
	public void initUI(JFrame owner)
	{
		// 设置标题
		setTitle("设置");
		// 设置大小
		setSize(550, 200);
		setMinimumSize(new Dimension(550, 200));
		// 设置位置
		setLocationRelativeTo(owner);
		// 设置阻塞
		setModal(true);
		// 设置布局
		getContentPane().setLayout(new BorderLayout(10, 10));
		// 设置边框
		((JComponent) getContentPane()).setBorder(BorderFactory.createTitledBorder(""));
		// 设置关闭方式
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		// 不显示界面
		setVisible(false);

		// 设置面板
		JPanel settingPanel = new JPanel();
		settingPanel.setLayout(new BorderLayout(5, 5));

		// 自动/手动设置面板
		JPanel amPanel = new JPanel();
		amPanel.setBorder(BorderFactory.createTitledBorder("设置自动/手动停止滚动"));
		amPanel.setLayout(new BorderLayout(5, 5));

		// 自动设置面板
		JPanel autoPanel = new JPanel();
		autoPanel.setLayout(new BorderLayout(20, 5));

		// 按钮组
		ButtonGroup buttonGroup = new ButtonGroup();

		// 自动停止勾选框
		autoStopCheckBox = new JCheckBox("自动停止", true);
		autoStopCheckBox.setFont(new Font("宋体", Font.PLAIN, 16));
		autoStopCheckBox.setFocusPainted(false);
		autoStopCheckBox.addActionListener(this);
		autoPanel.add(autoStopCheckBox, BorderLayout.WEST);

		// 复选框
		timeComboBox = new JComboBox<String>();
		timeComboBox.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		timeComboBox.setFocusable(false);
		for (int i = 1; i <= 10; i++)
		{
			timeComboBox.addItem(i + "秒后");
		}
		timeComboBox.setSelectedIndex(2);
		autoPanel.add(timeComboBox, BorderLayout.CENTER);
		amPanel.add(autoPanel, BorderLayout.NORTH);

		// 手动停止勾选框
		manualStopCheckBox = new JCheckBox("手动停止");
		manualStopCheckBox.setFont(new Font("宋体", Font.PLAIN, 16));
		manualStopCheckBox.setFocusPainted(false);
		manualStopCheckBox.addActionListener(this);
		amPanel.add(manualStopCheckBox, BorderLayout.SOUTH);
		settingPanel.add(amPanel, BorderLayout.NORTH);

		// 添加进按钮组
		buttonGroup.add(autoStopCheckBox);
		buttonGroup.add(manualStopCheckBox);

		// 重复点名面板
		JPanel repeatPanel = new JPanel();
		repeatPanel.setBorder(BorderFactory.createTitledBorder("设置是否重复点名"));
		repeatPanel.setLayout(new BorderLayout(5, 5));

		// 重复点名勾选框
		repeatCheckBox = new JCheckBox("重复点名(被点过的名字可以继续重复显示)", true);
		repeatCheckBox.setFont(new Font("宋体", Font.PLAIN, 16));
		repeatCheckBox.setFocusPainted(false);
		repeatCheckBox.addActionListener(this);
		repeatPanel.add(repeatCheckBox, BorderLayout.CENTER);
		settingPanel.add(repeatPanel, BorderLayout.SOUTH);

		getContentPane().add(settingPanel, BorderLayout.WEST);

		// 按钮面板
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BorderLayout(5, 5));

		// 上面板
		JPanel upPanel = new JPanel();
		upPanel.setLayout(new BorderLayout(10, 10));

		// 编辑按钮
		defaultButton = new JButton("恢复默认设置");
		defaultButton.setPreferredSize(new Dimension(150, 35));
		defaultButton.setFont(new Font("宋体", Font.PLAIN, 16));
		defaultButton.setFocusPainted(false);
		defaultButton.addActionListener(this);
		upPanel.add(defaultButton, BorderLayout.CENTER);
		buttonPanel.add(upPanel, BorderLayout.NORTH);

		// 下面板
		JPanel downPanel = new JPanel();
		downPanel.setLayout(new BorderLayout(10, 10));

		// 保存按钮
		applyButton = new JButton("应用");
		applyButton.setPreferredSize(new Dimension(100, 35));
		applyButton.setFont(new Font("宋体", Font.PLAIN, 16));
		applyButton.setFocusPainted(false);
		applyButton.addActionListener(this);
		downPanel.add(applyButton, BorderLayout.NORTH);

		// 取消按钮
		cancelButton = new JButton("取消");
		cancelButton.setPreferredSize(new Dimension(100, 35));
		cancelButton.setFont(new Font("宋体", Font.PLAIN, 16));
		cancelButton.setFocusPainted(false);
		cancelButton.addActionListener(this);
		downPanel.add(cancelButton, BorderLayout.SOUTH);
		buttonPanel.add(downPanel, BorderLayout.SOUTH);

		getContentPane().add(buttonPanel, BorderLayout.EAST);

		validate();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// 判断来源
		if (e.getSource() == autoStopCheckBox)
		{
			timeComboBox.setVisible(autoStopCheckBox.isSelected());

		} else if (e.getSource() == manualStopCheckBox)
		{
			timeComboBox.setVisible(autoStopCheckBox.isSelected());

		} else if (e.getSource() == repeatCheckBox)
		{

		} else if (e.getSource() == defaultButton)
		{
			// 恢复默认
			setDefault();

		} else if (e.getSource() == applyButton)
		{
			// 应用
			apply();

		} else if (e.getSource() == cancelButton)
		{
			this.dispose();
		}
	}

	/**
	 * 应用
	 */
	private void apply()
	{
		// 自动停止
		RollCallFrame.autoStopFlag = autoStopCheckBox.isSelected();
		// 重复点名
		RollCallFrame.repeatFlag = repeatCheckBox.isSelected();

	}

	/**
	 * 恢复默认
	 */
	private void setDefault()
	{
		// 自动停止
		autoStopCheckBox.doClick();
		// 设置3秒
		timeComboBox.setSelectedIndex(2);
		// 重复点名
		repeatCheckBox.setSelected(true);
	}

}
