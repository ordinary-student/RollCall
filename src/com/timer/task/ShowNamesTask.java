package com.timer.task;

import java.util.List;
import java.util.Random;
import java.util.TimerTask;

import javax.swing.JLabel;

import com.thread.PlaySoundThread;
import com.ui.RollCallFrame;

/**
 * 显示名字任务类
 * 
 * @author ordinary-student
 *
 */
public class ShowNamesTask extends TimerTask
{
	private JLabel label;
	private int soundCount = 0;

	/*
	 * 构造方法
	 */
	public ShowNamesTask(JLabel label)
	{
		this.label = label;
	}

	@Override
	public void run()
	{
		// 判断运行标志
		if (RollCallFrame.runFlag)
		{
			// 如果备份集合还有名字
			if (RollCallFrame.list2.size() > 0)
			{
				// 获取随机名字，用来滚动显示
				String name = getRandomName(RollCallFrame.list);
				// 显示名字
				label.setText(name);

				// 播放显示音效
				if (RollCallFrame.soundFlag)
				{
					// 隔3条播放一次
					soundCount++;
					if (soundCount % 3 == 0)
					{
						new PlaySoundThread("show.wav").start();
					}
				}

				// 停顿
				try
				{
					Thread.sleep(60);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}

			} else// 如果备份集合空了
			{
				// 取消任务
				cancel();
			}
		} else// 如果停止了
		{
			// 取消任务
			cancel();

			// 获取随机名字，用来在最后显示的，真正的点名
			String name = getRandomName(RollCallFrame.list2);
			// 显示名字
			label.setText(name);

			// 播放停止音效
			if (RollCallFrame.soundFlag)
			{
				new PlaySoundThread("stop.wav").start();
			}

			// 如果选择不重复，则从集合中移除名字
			if (!RollCallFrame.repeatFlag)
			{
				RollCallFrame.list2.remove(label.getText());
			}
		}
	}

	/**
	 * 从集合里获取随机名字
	 * 
	 * @param list
	 * @return
	 */
	private String getRandomName(List<String> list)
	{
		// 获得当前时间的毫秒数
		long time = System.currentTimeMillis();
		// 作为种子数传入到Random的构造器中
		Random rand = new Random(time);

		// 生成随机数
		int index = rand.nextInt(list.size());
		// 获取名字
		return list.get(index);
	}

}
