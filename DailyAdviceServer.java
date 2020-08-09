package com.company;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DailyAdviceServer {
    String []adviceList = {"Sleep well", "Dont overthink", "Work hard", "Wear comfy clothes"};

    public void go(){
        try{
            ServerSocket s = new ServerSocket(4242);

            while (true){
                Socket socket = s.accept();

                PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
                String advice = getAdvice();
                printWriter.println(advice);
                printWriter.close();
                System.out.println(advice);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public String getAdvice(){
        int random = (int) (Math.random()*adviceList.length);
        return adviceList[random];
    }
}
