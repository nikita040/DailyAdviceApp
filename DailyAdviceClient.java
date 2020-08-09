package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class DailyAdviceClient {

    public void go(){
        try{
            Socket s = new Socket("127.0.0.1", 4242);

            InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(streamReader);

            String advice = bufferedReader.readLine();
            System.out.println("Today's advice is " + advice);

            bufferedReader.close();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}