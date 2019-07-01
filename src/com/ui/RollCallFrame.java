package com.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	// 备份名单集合
	public static List<String> list2 = new ArrayList<String>();

	// 定时器
	public javax.swing.Timer autoTimer;

	// 运行标志
	public static boolean runFlag = false;
	// 自动停止标志
	public static boolean autoStopFlag = true;
	// 自动停止时间(秒)
	public static int autoStopTime = 3;
	// 重复点名标志
	public static boolean repeatFlag = true;
	// 声音标志
	public static boolean soundFlag = true;

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
		// 不显示界面
		setVisible(false);

		// 创建菜单栏
		JMenuBar menuBar = new JMenuBar();

		// 创建菜单
		JMenu startMenu = new JMenu("开始");
		startMenu.setFont(new Font("宋体", Font.PLAIN, 18));
		JMenu editMenu = new JMenu("编辑");
		editMenu.setFont(new Font("宋体", Font.PLAIN, 18));
		JMenu settingMenu = new JMenu("设置");
		settingMenu.setFont(new Font("宋体", Font.PLAIN, 18));

		// 创建菜单项
		// 开始点名
		startItem = new JMenuItem("开始点名");
		startItem.setFont(new Font("宋体", Font.PLAIN, 18));
		startItem.addActionListener(this);
		startMenu.add(startItem);

		startMenu.addSeparator();

		// 退出
		exitItem = new JMenuItem("退出");
		exitItem.setFont(new Font("宋体", Font.PLAIN, 18));
		exitItem.addActionListener(this);
		startMenu.add(exitItem);
		menuBar.add(startMenu);

		// 编辑名单
		editItem = new JMenuItem("编辑名单");
		editItem.setFont(new Font("宋体", Font.PLAIN, 18));
		editItem.addActionListener(this);
		editMenu.add(editItem);
		menuBar.add(editMenu);

		// 静音
		soundItem = new JCheckBoxMenuItem("静音");
		soundItem.setFont(new Font("宋体", Font.PLAIN, 18));
		soundItem.addActionListener(this);
		settingMenu.add(soundItem);

		settingMenu.addSeparator();

		// 设置
		settingItem = new JMenuItem("设置...");
		settingItem.setFont(new Font("宋体", Font.PLAIN, 18));
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
		startButton.setFont(new Font("宋体", Font.PLAIN, 24));
		startButton.setFocusPainted(false);
		startButton.addActionListener(this);
		getContentPane().add(startButton, BorderLayout.SOUTH);

		validate();
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
			stop();
		} else
		{
			// 否则开始
			start();
		}
	}

	/**
	 * 开始
	 */
	private void start()
	{
		if (list.size() > 0)
		{
			if (list2.size() > 0)
			{
				runFlag = true;
				startButton.setText("停止");
				startItem.setText("停止点名");
				// 创建循环显示名字的任务
				createShowNamesTask();

			} else
			{
				label.setText("准备点名");
				JOptionPane.showMessageDialog(this, "名单全部都被点过啦！");
				return;
			}
		} else
		{
			label.setText("准备点名");
			JOptionPane.showMessageDialog(this, "名单为空！");
			return;
		}
	}

	/**
	 * 停止
	 */
	protected void stop()
	{
		runFlag = false;
		startButton.setText("开始");
		startItem.setText("开始点名");
		// 取消自动停止的任务
		if (autoTimer != null)
		{
			autoTimer.stop();
		}
	}

	/**
	 * 创建循环显示名字的任务
	 */
	private void createShowNamesTask()
	{
		// 自动停止
		if (autoStopFlag)
		{
			// 创建自动停止任务
			createAutoStopTask();
		}

		// 创建定时器
		Timer timer = new Timer();
		// 任务
		TimerTask task = new ShowNamesTask(label);
		// 安排执行
		timer.schedule(task, 10, 60);
	}

	/**
	 * 创建自动停止任务
	 */
	private void createAutoStopTask()
	{
		// autoStopTime秒后自动停止
		autoTimer = new javax.swing.Timer(autoStopTime * 1000, new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				stop();
			}
		});

		// 只执行一次
		autoTimer.setRepeats(false);
		// 启动定时器
		autoTimer.start();
	}

	/**
	 * 创建编辑窗口
	 */
	private void createEditDialog()
	{
		new EditDialog(this).setVisible(true);
	}

	/**
	 * 创建设置窗口
	 */
	private void createSettingDialog()
	{
		new SettingDialog(this).setVisible(true);
	}

}
