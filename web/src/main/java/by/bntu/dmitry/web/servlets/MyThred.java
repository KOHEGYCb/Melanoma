/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bntu.dmitry.web.servlets;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dmitry
 */
public class MyThred  extends Thread {

    String cmd;

    public MyThred(String name, String cmd) {
        super(name);
        System.out.println("Start");
        this.cmd = cmd;
        run();
    }

    @Override
    public void run() {
        System.out.println("run");
        try {
            Runtime.getRuntime().exec(cmd);
//            System.out.println("*******");
//            PrintStream printStream;
//            printStream = new PrintStream(Runtime.getRuntime().exec(cmd).getOutputStream());
//            printStream.println();
        } catch (IOException ex) {
            Logger.getLogger(RunThread.class.getName()).log(Level.SEVERE, null, ex);
        }

//        System.out.printf("%s started... \n", Thread.currentThread().getName());
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            System.out.println("Thread has been interrupted");
//        }
//        System.out.printf("%s fiished... \n", Thread.currentThread().getName());

    }
}
