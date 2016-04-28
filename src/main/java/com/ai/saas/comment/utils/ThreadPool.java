package com.ai.saas.comment.utils;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * 线程池 单例
 * @author renfeng
 *
 */
public class ThreadPool {
	
	static private ThreadPool threadPool= new ThreadPool();
	
	private ThreadPoolExecutor threadPoolExecutor= null;
	
	private ThreadPool(){
		threadPoolExecutor=new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());
	}
	static public ThreadPool getThreadPool() {
		return threadPool;
	}
	public void execute(Runnable r) {
		threadPoolExecutor.execute(r);
	}
	public void shutdownThreadPool(){
		threadPoolExecutor.shutdown();
	}
	
}




