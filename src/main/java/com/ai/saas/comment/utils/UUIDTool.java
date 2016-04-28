package com.ai.saas.comment.utils;


import java.util.UUID;

public class UUIDTool
{
  public static String genId32(){
	  return UUID.randomUUID().toString();
//    return UUID.randomUUID().toString().replaceAll("\\-", "").toUpperCase();
  }
  /**
   * 邮件历史ID
   * @return
   */
  public static String genIdToUpperCase(){
	  return UUID.randomUUID().toString().replaceAll("\\-", "").toUpperCase();
  }
  public static int genShortId() {
    return genId32().hashCode();
  }
  public static void main(String[] args) {
    System.out.println(genId32());
  }
}