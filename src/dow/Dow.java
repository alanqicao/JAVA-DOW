
//Student Name:  Qi Cao
package dow;

import java.util.Arrays;

public class Dow
{

    public static void main(String[] args)
    { //start
        //init
        int dayOfWeek = 0;
        int temperature = 0;
        int[] count = new int[8];
        int[] lowTemperature = new int[8];
        int[] highTemperature = new int[8];
        int[] total = new int[8];
        int index = 0;
        //instanciating needed classes
        InputFile input = new InputFile("input.txt");
        OutputFile output = new OutputFile("output.txt");
        //output
        System.out.println("DOW Temperature Started. Please wait....");
        //init arrays
        while (index < 8)
        {
            lowTemperature[index] = 999;
            highTemperature[index] = -999;
            count[index] = 0;
            total[index] = 0;
            index = index + 1;
        }


        //loop to read all records
        while (!input.eof())
        {
            

            // read a record
            dayOfWeek = input.readInt();
            temperature = input.readInt();
            //System.out.println(dayOfWeek +" "+temperature);
            //check for new high
            if (temperature > highTemperature[dayOfWeek])
            {
                highTemperature[dayOfWeek] = temperature;
            }
            //check for new low
            if (temperature < lowTemperature[dayOfWeek])
            {
                lowTemperature[dayOfWeek] = temperature;
            }
            //conut the days & accumulate the totals
            count[dayOfWeek] = count[dayOfWeek] + 1;
            total[dayOfWeek] = total[dayOfWeek] + temperature;
        }

        
        //start with day 1
        //write 7 records 1 for each day
        for (index = 1; index < 8; index++)
        //out put record type depending if day exist
        {
            if (count[index] > 0)
            {
                output.writeWord(index + " "+highTemperature[index] + " "+lowTemperature[index] + " "+total[index]/count[index]);
            }else
            {
                output.writeWord(index+" "+0+" "+0+" "+0);
            }
       output.writeEOL();
        }
        output.close();
        System.out.println("DOW Temperature Completed Successfully.");
    }//Main

}//Class
