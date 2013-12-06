package com.carlgo11.bungeecordsaveip;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

public class Main extends Plugin implements Listener {
    
    
    public void onEnable(){
this.getProxy().registerChannel("saveip");
        this.getProxy().getPluginManager().registerListener(this, this);
    }
    
    
     @EventHandler
    public void onPlayerConnect(ServerConnectEvent e){
         File dir = new File("players");
        if(!dir.exists()){
        dir.mkdir();
        }
         File x = new File("players/"+e.getPlayer().getName()+".yml");
       if(x.exists()){
           
       }else{
             try {
                 x.createNewFile();
             } catch (IOException ex) {
                 Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
             }
             try {
                 //FileWriter outfile = new FileWriter("chat.txt", true);
                PrintWriter outi = new PrintWriter(x);
                outi.println("Hostname: "+e.getPlayer().getAddress().getHostName());
                outi.println("IP: "+e.getPlayer().getAddress());
                outi.close();
             } catch (FileNotFoundException ex) {
                 Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
             }
           
       }
    }
    

}
