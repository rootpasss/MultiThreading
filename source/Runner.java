//-------------------------------------------------------------------------------------------------------------------------------------------------
import java.awt.Toolkit;

import java.util.Random;

import java.io.FileWriter;

import java.time.LocalDate;

//-------------------------------------------------------------------------------------------------------------------------------------------------

/**
 * Engineered and developed by Jhonny Trejos Barrios.
 * Technology: Java.
 * Version: Java Development Kit 1.8.0_31, Standard Edition.
 * Development Environment: VIM.
 * ------------------------------------------------------------------------------------------------------------------------------------------------
 * ------------------------------------------------------------------------------------------------------------------------------------------------
 * Additional Info.
 *
 * Source Code Target:
 *
 *			[A SIMPLE DEMONSTRATIONAL GAME OF SEVERAL THREADS WRITING THEIR PROGRESS ON A SINGLE FILE - RUNNER THREAD]
 *
 * Licenses: GNU GPL v3.0, Eclipse Public License 1.0, personal not for commercial purposes.
 * Developer Contact: jtrejosb@live.com || jtrejosb@gmail.com || jtrejosb@icloud.com
 * Mobile: --.
 */

//-------------------------------------------------------------------------------------------------------------------------------------------------
public class Runner extends Thread
{
    String name, status = "";
    int pitTime, pitStops = 0;
    long start, end;
    //---------------------------------------------------------------------------------------------------------------------------------------------
    
    public Runner( String name )
    {
        this.name = name;
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------
    
    public void run()
    {
        try
        {
            Track.FW = new FileWriter( Track.file );
            start = System.currentTimeMillis();

            for( int progress = 0; progress <= 100; progress ++ )
            {
                status = name + " on racing.\tProgress: " + progress + "%";
                System.out.println( status );
                Track.FW.write( status + "\n" );

                pitTime = new Random().nextInt( 90 );

                sleep( 110 + pitTime );

                if( pitTime > 30 && pitTime <= 32 )
                {
                    pitStops ++;
                    status = name + " is on pits...";
                    System.out.println( status );
                    Track.FW.write( status + "\n" );
                    sleep( 2700 );
                    status = name + " on track again.";
                    System.out.println( status );
                    Track.FW.write( status + "\n" );
                }
            }

            Track.position ++;
            end = System.currentTimeMillis();
            status = "\n" + name + " finished the race in position " + Track.position + "\n";
            System.out.println( status );
            Track.FW.write( status + "\n" );
            Track.stats += Track.position + ".  " + name + "\t(" + ( end - start ) / 1000.0 + " ms.  " + pitStops + " pit stops)\n";

            if( Track.position == 6 )
            {
                status = "\nFinal Standings:\n" + Track.stats + "\nSiMpLe ThReAdS GaMe.  [created on " + LocalDate.now() + "]";
                System.out.println( status );
                Track.FW.write( status + "\n" );
                Track.FW.close();
                Toolkit.getDefaultToolkit().beep();
            }
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------
}
//-------------------------------------------------------------------------------------------------------------------------------------------------
