/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodproject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/**
 *
 * @author johnnyfu
 */
public class account {
    Scanner scanner = new Scanner(System.in);
    String name,address,password="0";
    int num=0;
    HashMap<Integer,food> acc=new HashMap<>();//姓名連foodclass
    ArrayList namesave = new ArrayList();
    public void creatacc(String currentname2 ,String currentpass2,String currentadd2){
        int accnum=num++;
        food food1 =new food(accnum);
        namesave.add(currentname2);
        food1.setname(currentname2);
        food1.setpassword(currentpass2);
        food1.setadd(currentadd2);
        acc.put(accnum,food1);
    }
    public void manacc(){
        int accnum=num++;
        food food1 =new food(accnum);
        namesave.add("manerger");
        food1.setname("manerger");
        food1.setpassword("0000");
        food1.setadd("host");
        acc.put(accnum,food1);
    }
    public String compareacc(String currentname){
        int i=0;
        while(!currentname.equals(namesave.get(i))){
            i++;
        }
        food food1 = acc.get(i);
        return food1.getpassword();
        
    }   
    public String compareaccgetadd(String currentname){
        int i=0;
        while(!currentname.equals(namesave.get(i))){
            i++;
        }
        food food1 = acc.get(i);
        return food1.getadd();

    }
     public void compareaccserialnum(String currentname,int num){
        int i=0;
        while(!currentname.equals(namesave.get(i))){
            i++;
        }
        food food1 = acc.get(i);
        food1.serial_num=num;

    }  
    
}
