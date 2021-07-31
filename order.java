/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodproject;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author johnnyfu
 */
public class order {
    int serial_number;
    float price,fare;
    String merchann,cakemes="",address="";
    Scanner scanner = new Scanner(System.in);
    HashMap<String,Integer> recmerchan_sin=new HashMap<>();
    HashMap<String,Float> recmerchan_g=new HashMap<>();
    
    public order(int serial_number){//設流水號
        this.serial_number=serial_number;
    }
    
    public String judgename(){
        System.out.println("請輸入您要購買的商品:");
        merchann = scanner.next();
        return merchann;
    }
    
    public String buymerchan(){
        System.out.println("(1)單價 (2)公斤價:");
           int aa = scanner.nextInt();
           if(aa==1){
               int aaa = scanner.nextInt();
               recmerchan_sin.put(merchann,aaa);
               return "1";
           }
           else if(aa==2){
               float bbb = scanner.nextFloat();
               recmerchan_g.put(merchann,bbb);
               return "2";
           }
           else return "3"; 
    }
    
    public String cake(){
        System.out.println("請問需要買多少個?");
        int aa = scanner.nextInt();
        System.out.println("請問要傳遞訊息嗎?\n (1)yes (2)no");
        int aaa=scanner.nextInt();
        if(aaa==1){
            System.out.println("請輸入要傳遞的訊息:");
            cakemes=scanner.next();
        }
        recmerchan_sin.put(merchann,aa);  
        return "1";
    }
    
    public void calprice(){
        for ( String key : recmerchan_sin.keySet() ) {
        System.out.print("商品:"+key+" 個數: "+recmerchan_sin.get(key)+"\n");
       }
        for ( String key : recmerchan_g.keySet() ) {
        System.out.print("商品:"+key+" 公斤: "+recmerchan_g.get(key)+"\n");
       }
         System.out.println("傳遞的訊息為:"+cakemes);
    }
    
    public int judgefare(){
        if(price>=1200){
            fare=0;
            System.out.println("價錢為:"+price);
            System.out.println("運費為:"+fare);
            return 0;
        }
        else if(price<1200 && price>=400){
            fare=200;
            System.out.println("價錢為:"+price);
            System.out.println("運費為:"+fare);
            return 0;
        }
        else {
            System.out.println("價錢為:"+price);
            System.out.println("請至少購買400元，訂單才能成立");
            return 1;
        }
    }
}
