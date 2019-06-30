package com.timer.task;

import java.util.List;
import java.util.Random;
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
			// 获得当前时间的毫秒数
			long time = System.currentTimeMillis();
			// 作为种子数传入到Random的构造器中
			Random rand = new Random(time);

			// 生成随机数
			int index = rand.nextInt(list.size());
			// 获取名字
			String name = list.get(index);
			// 显示名字
			label.setText(name);

			// 播放显示音效
			if (RollCallFrame.soundFlag)
			{
				// TODO...
			}

			try
			{
				Thread.sleep(60);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}

		} else
		{
			// 取消任务
			cancel();
			// 播放停止音效
			if (RollCallFrame.soundFlag)
			{
				// TODO...
			}
		}
	}

}
