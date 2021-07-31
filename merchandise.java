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
public class merchandise {
    HashMap<String,Integer> merchan_sin=new HashMap<>();
    HashMap<String,Float> merchan_g=new HashMap<>();
    Scanner scanner = new Scanner(System.in);
    String merchann;
    int price_i;
    float price_f;
    public void list(){
       merchan_sin.put("apple",10); 
       merchan_sin.put("banana",15);
       merchan_sin.put("cherry",20);
       merchan_sin.put("grapes",25);
       merchan_sin.put("orange",30);
       merchan_sin.put("cake",50);
       merchan_g.put("apple",1f); 
       merchan_g.put("banana",1.5f);
       merchan_g.put("cherry",2.0f);
       merchan_g.put("grapes",2.5f);
       merchan_g.put("orange",3.0f);
    }
    
    public void addlist_s(){
        System.out.print("請輸入商品名稱:");
        merchann = scanner.next();
        System.out.print("請輸入商品單價:");
        price_i= scanner.nextInt();
        merchan_sin.put(merchann, price_i);
    }
    
    public void addlist_g(){
        System.out.print("請輸入商品名稱:");
        merchann = scanner.next();
        System.out.print("請輸入商品公斤價:");
        price_f= scanner.nextFloat();
        merchan_g.put(merchann, price_f);
    }
    
    public void dec(String cstring){
        merchan_g.remove(cstring);
        merchan_sin.remove(cstring);
    }
    
    public void printlist(){
       for ( String key : merchan_sin.keySet() ) {
        System.out.print("商品:"+key+" 單價/公斤價: "+merchan_sin.get(key)+"/"+merchan_g.get(key)+"\n");
       }
    }
    
    public int judgelist(String merchanname){
        if(merchan_sin.get(merchanname)==null && merchan_g.get(merchanname)==null){
            return 0;
        }
        else return 1;
    }
    
    public float getprice_s(String merchan){
        price_i=0;
        price_i=merchan_sin.get(merchan);
        
        return price_i;
    }
}
