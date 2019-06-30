package com.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.timer.task.ShowNamesTask;
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
	// 名单集合
	public static List<String> list = new ArrayList<String>();
	// 运行标志
	public static boolean runFlag = false;
	// 声音标志
	private boolean soundFlag = true;

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
		setMinimumSize(new Dimension(400, 300));
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
		// 开始点名
		startItem = new JMenuItem("开始点名");
		startItem.addActionListener(this);
		startMenu.add(startItem);

		startMenu.addSeparator();

		// 退出
		exitItem = new JMenuItem("退出");
		exitItem.addActionListener(this);
		startMenu.add(exitItem);
		menuBar.add(startMenu);

		// 编辑名单
		editItem = new JMenuItem("编辑名单");
		editItem.addActionListener(this);
		editMenu.add(editItem);
		menuBar.add(editMenu);

		// 静音
		soundItem = new JCheckBoxMenuItem("静音");
		soundItem.addActionListener(this);
		settingMenu.add(soundItem);

		settingMenu.addSeparator();

		// 设置
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

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// 判断来源
		if ((e.getSource() == startItem) || (e.getSource() == startButton))
		{
			// 开始点名
			startRollCall();

		} else if (e.getSource() == exitItem)
		{
			// 退出
			System.exit(0);

		} else if (e.getSource() == editItem)
		{
			// 编辑名单
			createEditDialog();

		} else if (e.getSource() == soundItem)
		{
			soundFlag = !soundItem.isSelected();

		} else if (e.getSource() == settingItem)
		{
			// 设置
			createSettingDialog();
		}
	}

	/**
	 * 开始点名
	 */
	private void startRollCall()
	{
		// 如果已运行则停止
		if (runFlag)
		{
			runFlag = false;
			startButton.setText("开始");
			startItem.setText("开始点名");

		} else
		{
			// 否则开始
			if (list.size() > 0)
			{
				runFlag = true;
				startButton.setText("停止");
				startItem.setText("停止点名");
				// 循环显示
				showNames();

			} else
			{
				label.setText("准备点名");
				JOptionPane.showMessageDialog(this, "名单为空！");
				return;
			}
		}

	}

	/**
	 * 循环显示名字
	 */
	private void showNames()
	{
		// 创建定时器
		Timer timer = new Timer();
		// 任务
		TimerTask task = new ShowNamesTask(list, label);
		// 安排执行
		timer.schedule(task, 10, 100);
	}

	/**
	 * 创建编辑窗口
	 */
	private void createEditDialog()
	{
		new EditDialog(this);
	}

	/**
	 * 创建设置窗口
	 */
	private void createSettingDialog()
	{
		new SettingDialog(this);
	}

}
