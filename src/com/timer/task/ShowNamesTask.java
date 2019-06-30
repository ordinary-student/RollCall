package com.timer.task;

import java.util.List;
import java.util.TimerTask;

import javax.swing.JLabel;

import com.ui.RollCallFrame;

/**
 * 显示名字任务类
 * 
 * @author ordinary-student
 *
 */
public class ShowNamesTask extends TimerTask
{
	private List<String> list;
	private JLabel label;

	/*
	 * 构造方法
	 */
	public ShowNamesTask(List<String> list, JLabel label)
	{
		this.list = list;
		this.label = label;
	}

	@Override
	public void run()
	{
		// 判断运行标志
		if (RollCallFrame.runFlag)
		{
			// 遍历显示
			for (String name : list)
			{
				// 再次判断运行标志
				if (RollCallFrame.runFlag)
				{
					// 显示名字
					label.setText(name);
					try
					{
						Thread.sleep(100);
					} catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				} else
				{
					// 取消任务
					cancel();
					break;
				}
			}
		} else
		{
			// 取消任务
			cancel();
		}
	}

}
