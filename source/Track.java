//-------------------------------------------------------------------------------------------------------------------------------------------------
import java.io.File;
import java.io.FileWriter;

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
 *           [A SIMPLE DEMONSTRATIONAL GAME OF SEVERAL THREADS WRITING THEIR PROGRESS ON A SINGLE FILE - POSITIONING.. SET.. RUN!]
 *
 * Licenses: GNU GPL v3.0, Eclipse Public License 1.0, personal not for commercial purposes.
 * Developer Contact: jtrejosb@live.com || jtrejosb@gmail.com || jtrejosb@icloud.com
 * Mobile: --.
 */

//-------------------------------------------------------------------------------------------------------------------------------------------------

public class Track
{
    public static int position = 0;
    public static String stats = "";
    public static File file;
    public static FileWriter FW;
    //---------------------------------------------------------------------------------------------------------------------------------------------
    
    public static void main( String[] args )
    {
        Runner r1, r2, r3, r4, r5, r6;

        new Track().setupFile();

        r1 = new Runner( "Lewis Hamilton" );
        r2 = new Runner( "Nico Rosberg" );
        r3 = new Runner( "Sebastian Vettel" );
        r4 = new Runner( "Fernando Alonso" );
        r5 = new Runner( "Kimi Raikkonen" );
        r6 = new Runner( "Felipe Massa" );

        r1.start();
        r2.start();
        r3.start();
        r4.start();
        r5.start();
        r6.start();
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------
    
    public void setupFile()
    {
        try
        {
            file = new File( "/source/raceLog.txt" );
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------
}
//-------------------------------------------------------------------------------------------------------------------------------------------------
