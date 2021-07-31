/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodproject;

/**
 *
 * @author johnnyfu
 */
public class food {
    String name,address,password;
    int num;
    int serial_num;
    public food(int accnum){
        num=accnum;
    }
    public void setname(String cpassword){
        name=cpassword;
    }
    public String getname(){
        return name;
    }
    public void setpassword(String cpassword){
        password=cpassword;
    }
    public String getpassword(){
        return password;
    }
    public void setadd(String add){
       address=add;
    }
    public String getadd(){
        return address;
    }
}
