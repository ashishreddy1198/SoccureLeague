package com.example.listner;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import comm.example.model.League;

public class LeagueListner implements ServletContextListener
{
String str=null;

@Override
public void contextInitialized(ServletContextEvent sce) 
{
	ServletContext context=sce.getServletContext();
	List<League> l=new ArrayList<League>();
	str=(String)context.getInitParameter("leagues-file");
	System.out.println(str);
	String arr[]=str.split(",");
	League newleague=new League(Integer.parseInt(arr[0]),arr[1],arr[2]);
	l.add(newleague);
	context.setAttribute("leaguelist",l);
	
}
@Override
public void contextDestroyed(ServletContextEvent sce)
{
	// TODO Auto-generated method stub
	str=null;
	System.out.println("context destroyed");
}
}
