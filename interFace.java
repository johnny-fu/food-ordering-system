/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodproject;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;


public class interFace {
    Scanner scanner = new Scanner(System.in);
    private boolean done = false;
    private boolean loginin = false;
    account test1 = new account();
    String currentname = "a",currentpass ="b",currentadd ="c";
    merchandise merchandise=new merchandise();
    int serial_number;
    HashMap<Integer,order> order_s = new HashMap<>();
    String username,useradd;
    //need clear
    ArrayList<String> merchandisearray = new ArrayList();
    
    public void wel() {
      test1.manacc();
      merchandise.list();
      while (!done) {
         System.out.println("歡迎來到 Good Life Food");
         System.out.println("請輸入你需要的服務\n (1)創立新帳號 (2)登入帳戶 (3)查詢目前價格 (4)離開");
         int cnum = scanner.nextInt();
         processCommand(cnum);
      }
   }
    private void processCommand(int cnum) {
      if (cnum == 1) newacccount();
      else if (cnum == 2) loginacc();
      else if (cnum == 3) merchandise.printlist();
      else if (cnum == 4) quit();
      else
         System.out.println("不合理的要求");
   }
    private void quit() {
      done = true;
      System.out.println("謝謝光臨");
   }
    public void newacccount(){
        System.out.print("請輸入基本資料跟帳密:\n");
        System.out.print("姓名:");
        currentname=scanner.next();
        System.out.print("密碼:");
        currentpass=scanner.next();
        System.out.print("地址:");
        currentadd=scanner.next();
        test1.creatacc(currentname,currentpass,currentadd);
    }
    
    public void loginacc(){
        loginin = false;
        String judge;
        String currentn,currentp;
        System.out.print("請輸入帳號:");
        currentn=scanner.next();
        System.out.print("請輸入密碼:");
        currentp=scanner.next(); 
        judge=test1.compareacc(currentn);
        if(judge.equals(currentp) && currentn.equals("manerger")){
            manloginsuc(currentn);
        }
        else if(judge.equals(currentp)){
            username=currentn;
            useradd=test1.compareaccgetadd(currentn);
            loginsuc();
        }
        else System.out.println("帳密錯誤請在輸入一次");
    }
   
    public void loginsuc(){ 
        System.out.println("歡迎"+username);
        serial_number=(int) Math.floor(Math.random()*10000+10000) ;
        order order = new order(serial_number);
        merchandisearray.clear();//new
        order_s.put(serial_number, order);
        while (!loginin) {
        System.out.println("請輸入需要的服務\n (1)購買商品 (2)結帳 (3)登出");
        int ccnum = scanner.nextInt();
        orderCommand(ccnum);
        }
    }
    
    private void orderCommand(int ccnum) {
      if (ccnum == 1) buymerchan();
      else if (ccnum == 2) calprice();
      else if (ccnum == 3) quitacc();
      else System.out.println("不合理的要求");
   }
    
    private void buymerchan(){
        order order = order_s.get(serial_number);
        String merchanname =order.judgename();
        if(merchandise.judgelist(merchanname)==1){
            merchandisearray.add(merchanname);
            if(merchanname.equals("cake")){
                 merchandisearray.add(order.cake());
            }
            else
            merchandisearray.add(order.buymerchan());
        }
        else System.out.println("您欲購買的商品目前不再販售期間:");
    }
    
    private void calprice(){
        //將流水號與food綁在一起
        order order = order_s.get(serial_number);
        order.calprice();
        float tempnum = 0;
        int tempi;
        for(int ii=0;ii<merchandisearray.size();){
            String temp=merchandisearray.get(ii+1);
            if(temp.equals("1")){
                float tempcal=merchandise.merchan_sin.get(merchandisearray.get(ii));
                tempcal=tempcal*order.recmerchan_sin.get(merchandisearray.get(ii));
                tempnum=tempnum+tempcal;
            }
            else if(temp.equals("2")){
                float tempcal=merchandise.merchan_g.get(merchandisearray.get(ii));
                tempcal=tempcal*order.recmerchan_g.get(merchandisearray.get(ii));
                tempnum=tempnum+tempcal;
            }
            else break;
            ii=ii+2;
        }
        order.price=tempnum;
        tempi=order.judgefare();
        if(tempi==0){
            System.out.println("您的訂單編號為:"+serial_number);
            System.out.println("將運送的地址為:"+useradd);
            System.out.println("感謝"+username+"的光臨");
            System.out.println("歡迎"+username);
            order.address=useradd;
            test1.compareaccserialnum(username,serial_number);
            serial_number=(int) Math.floor(Math.random()*10000+10000) ;
            order order2 = new order(serial_number);
            merchandisearray.clear();
            order_s.put(serial_number,order2);
        }
        
        
    }
    
    public void manloginsuc(String name){
        System.out.println("歡迎"+name);
        while (!loginin) {
        System.out.println("請輸入需要的服務\n (1)增加/修改商品 (2)減少商品 (3)查詢客戶訂單 (4)登出");
        int ccnum = scanner.nextInt();
        manCommand(ccnum);
        }
    }
    
    private void manCommand(int ccnum) { 
      if (ccnum == 1) manadd();
      else if (ccnum == 2) mandec();
      else if (ccnum == 3) search_serialnum();
      else if (ccnum == 4) quitacc();
      else
         System.out.println("不合理的要求");
   }
    
    private void manadd() {
        System.out.println("請輸入需要的服務\n(1)增加單價種類(2)增加公斤種類");
        int cccnum = scanner.nextInt();
      if (cccnum == 1) merchandise.addlist_s();
      else if (cccnum == 2) merchandise.addlist_g();
      else
         System.out.println("不合理的要求");
   }
    
    private void mandec() {
        System.out.println("請輸入要減少的商品");
        String cstring = scanner.next();
        merchandise.dec(cstring);
   }
    
    private void search_serialnum() {
        System.out.println("請輸入要查詢的訂單編號");
        order order = order_s.get( scanner.nextInt());
        order.calprice();
        order.judgefare();
        System.out.println("將運送的地址為:"+order.address);
   }
    
    private void quitacc() {
      loginin = true;
      System.out.println("已登出");
   }

    
}
