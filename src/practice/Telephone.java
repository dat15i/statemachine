package practice;

import java.util.Scanner;

/**
 * Created by clbo on 03/02/2016.
 */
public class Telephone {

    // Each state is represented as a constant integer
    private static final int IDLE = 0;
    private static final int ACTIVE = 1;
    // States from substate
    private static final int PLAYING_DIAL_TONE = 2;
    private static final int DAILING = 3;
    private static final int CONNECTING = 4;
    private static final int TALKING = 5;

    // an instance variable to hold the current state
    private int state = IDLE;

    // Events are represented as methods
    public void offHook(){
        if (state == IDLE){
            state = PLAYING_DIAL_TONE;
            System.out.println("Phone is Active");

            // Transition to digit state
            digit();
        }
        else{
            System.out.println("ERROR: Phone is already in Active mode, " +
                    "reboot the phone to make it work");
        }
    }

    public void onHook(){
        if (state != IDLE){
            state = IDLE;
            System.out.println("Phone is IDLE");
        }
        else{
            System.out.println("ERROR: Phone is already in IDLE mode, " +
                    "reboot the phone to make it work");
        }
    }

    public void digit() {
        if (state == PLAYING_DIAL_TONE){

            state = DAILING;
            System.out.println("Please enter the phone number");

            Scanner s = new Scanner(System.in);
            int i = 0;
            while (i <=8){
                System.out.println(s.nextInt());
                i++;
            }
            // transition to connecting state
            complete();
        } else {
            System.out.println("ERROR: No dialing tone");
            onHook();
        }
    }

    public void complete(){
        state = CONNECTING;
        System.out.println("Connecting ...");
        try {
            Thread.sleep(5000);
            connected();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void connected(){
        state = TALKING;
        System.out.println("Hello this is Claus");
    }























}
