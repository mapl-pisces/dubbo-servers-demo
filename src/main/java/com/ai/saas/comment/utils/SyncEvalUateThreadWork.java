package com.ai.saas.comment.utils;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 同步评价信息 多线程任务
 * @author renfeng
 *
 */
public class SyncEvalUateThreadWork implements Runnable{
	
	private Integer dishesId;
	SyncEvalUateThreadWork(Integer dishesId){this.dishesId=dishesId;}
	@SuppressWarnings("static-access")
	@Override
	public void run() {
		
		System.out.println(dishesId);
		
		/***需要执行的任务start***/
		
		List<PingJia> evaluateList = new ArrayList<PingJia>();
		for(int i=0;i<20;i++){
			PingJia pingJia = new PingJia();
			pingJia.setId(i+"");
			pingJia.setName("任锋"+i);
			pingJia.setDate(new Timestamp(System.currentTimeMillis()));
			evaluateList.add(pingJia);
			try {
				Thread.currentThread().sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Collections.sort(evaluateList, new Comparator<PingJia>() {
	        @Override
	        public int compare(PingJia o1, PingJia o2) {
	         int a=0;
	         if(o1.getDate().compareTo(o2.getDate())==-1){
	         	a=1;
	         }else if(o1.getDate().compareTo(o2.getDate())==1){
	         	a=-1;
	         }else if(o1.getDate().compareTo(o2.getDate())==0){
	         	a=0;
	         }
	         return a;
	        }
	    });
		
		List<PingJia> pingjialist = new ArrayList<PingJia>();
		int tmp=0;
		for(int i=0;i<evaluateList.size();i++){
			if(pingjialist.size()==10){
//				RedisClient.set("p"+i+"_"+dishesId, value);
				pingjialist.clear();
			}else{
				pingjialist.add(evaluateList.get(i));
			}
			tmp++;
		}
		
		if(pingjialist!=null &&pingjialist.size()>0){
//			RedisClient.set("p"+tmp+"_"+dishesId, value);
		}
		
		
		
		for(PingJia pingJia:evaluateList){
			System.out.println(pingJia.getId()+"========="+pingJia.getDate());
		}
		
		
		
		
		/***需要执行的任务end***/
	}
	
	
	public static void main(String[] args) {
		ThreadPool threadPool = ThreadPool.getThreadPool();
		for(int i=0;i<100;i++){
			threadPool.execute(new SyncEvalUateThreadWork(i));
		}
		threadPool.shutdownThreadPool();
	}
	
	

}

class PingJia{
	
	 private String id;
	 private String name;
	 private Timestamp date;
	 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}
	
}