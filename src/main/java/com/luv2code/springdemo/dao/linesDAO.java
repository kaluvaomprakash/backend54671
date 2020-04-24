package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.lines;

public interface linesDAO {

	public lines newLine(lines thelinee,String cookie);
	public lines updateLine(lines theline,String cookie);
	public List<lines> listLines(String cookie);
	public lines singleLine(int id,String cookie);
	public int removeLine(int id,String cookie);
	public List customersInLines(String cookie);
}
