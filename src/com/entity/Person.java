package com.entity;

/**
 * Person类
 * 
 * @author Administrator
 *
 */
public class Person
{
	private int id;
	private String name;

	/*
	 * 构造方法
	 */
	public Person()
	{

	}

	/**
	 * @return id
	 */
	public int getId()
	{
		return this.id;
	}

	/**
	 * @param id
	 *            要设置的 id
	 */
	public void setId(int id)
	{
		this.id = id;
	}

	/**
	 * @return name
	 */
	public String getName()
	{
		return this.name;
	}

	/**
	 * @param name
	 *            要设置的 name
	 */
	public void setName(String name)
	{
		this.name = name;
	}

}
