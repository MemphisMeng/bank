package Fancy_Bank;

import java.text.SimpleDateFormat;

public class CreateList {
   static public void myListCustom(String events)
   {
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
   	df.format(System.currentTimeMillis());
   	Params.Custom_trade_recoder.add((String)df.format(System.currentTimeMillis())+" : "+events);
   }
   static public void myListManager(String events)
   {
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
   	df.format(System.currentTimeMillis());
   	Params.operationsList.add((String)df.format(System.currentTimeMillis())+" : "+events);
   }
}
