package demo;

import java.util.Scanner;

/**
 * Created by clbo on 04/02/2016.
 */
public class Telephone {

    // fields
    // Constants to tell about the state

    private static final int IDLE = 0;
    private static final int ACTIVE = 1;

    // Sub state Machine
    private static final int PLAY_DAILING_TONE = 2;
    private static final int DAILING = 3;
    private static final int CONNECTING = 4;
    private static final int TALKING = 5;


    private int state = IDLE;

    public void offHook(){

        // if (valid user) then run code beneath
        // other vise give an error / throw exeption / call onHook()
        state = PLAY_DAILING_TONE;

       enterDigit();
    }

    public void onHook(){
        state = IDLE;
        System.out.println("Phone is Idle");
    }

    private void enterDigit() {
        state = DAILING;

        Scanner scan = new Scanner(System.in);
        int i = 0;
        while(i <= 7){

            System.out.print(scan.nextInt());
            i++;
        }
        complete();

    }

    private void complete(){
        try {

            System.out.println("connecting");
            Thread.sleep(5000);
            state = CONNECTING;
            connected();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void connected(){
        state = TALKING;
        System.out.println("Hello this is Claus speaking!");

    }




















}
