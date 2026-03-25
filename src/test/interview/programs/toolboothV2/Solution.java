package toolboothV2;

/*
We are writing software to analyze logs for toll booths on a highway. This highway is a divided highway with limited access; the only way on to or off of the highway is through a toll booth.

There are three types of toll booths:
* ENTRY (E in the diagram) toll booths, where a car goes through a booth as it enters the highway.
* EXIT (X in the diagram) toll booths, where a car goes through a booth as it exits the highway.
* MAINROAD (M in the diagram), which have sensors that record a license plate as a car drives through at full speed.


        Exit Booth                         Entry Booth
            |                                   |
            X                                   E
             \                                 /
---<------------<---------M---------<-----------<---------<----
                                         (West-bound side)

===============================================================

                                         (East-bound side)
------>--------->---------M--------->--------->--------->------
             /                                 \
            E                                   X
            |                                   |
        Entry Booth                         Exit Booth

For our first task:
1-1) Read through and understand the code and comments below. Feel free to run the code and tests.
1-2) The tests are not passing due to a bug in the code. Make the necessary changes to LogEntry to fix the bug.
*/

/*
We are interested in how many people are using the highway, and so we would like to count how many complete journeys are taken in the log file.

A complete journey consists of:
* A driver entering the highway through an ENTRY toll booth.
* The driver passing through some number of MAINROAD toll booths (possibly 0).
* The driver exiting the highway through an EXIT toll booth.

For example, the following excerpt of log lines contains complete journeys for the cars with JOX304 and THX138:

.
.
.
90750.191 JOX304 250E ENTRY
91081.684 JOX304 260E MAINROAD
91082.101 THX138 110E ENTRY
91483.251 JOX304 270E MAINROAD
91873.920 THX138 120E MAINROAD
91874.493 JOX304 280E EXIT
.
.
91982.102 THX138 290E EXIT
92301.302 THX138 300E ENTRY
92371.302 THX138 310E EXIT
.

→ This log contains 3 complete journeys:
  • JOX304: 1 journey
  • THX138: 2 journeys

You may assume that the log only contains complete journeys, and there are no missing entries.

2-1) Write a function in LogFile named countJourneys() that returns how many
     complete journeys there are in the given LogFile.
*/

/*
We would like to catch people who are driving at unsafe speeds on the highway. To help us do that, we would like to identify journeys where a driver does either of the following:
* Drive 130 km/h or greater in any individual 10km segment of tollway.
* Drive 120 km/h or greater in any two 10km segments of tollway.


For example, consider the following journey:
1000.000 TST002 270W ENTRY
1275.000 TST002 260W EXIT


In this case, the driver of TST002 drove 10 km in 275 seconds. We can calculate
that this driver drove an average speed of ~130.91km/hr over this segment:


10 km * 3600 sec/hr
------------------- = 130.91 km/hr
      275 sec


Note that:
* A license plate may have multiple journeys in one file, and if they drive at unsafe speeds in both journeys, both should be counted.
* We do not mark speeding if they are not on the highway (i.e. for any driving between an EXIT and ENTRY event).
* Speeding is only marked once per journey. For example, if there are 4 segments 120km/h or greater, or multiple segments 130km/h or greater, the journey is only counted once.


3-1) Write a function catchSpeeders in LogFile that returns a collection of license plates that drove at unsafe speeds during a journey in the LogFile.
     If the same license plate drives at unsafe speeds during two different journeys, the license plate should appear twice (once for each journey they drove at unsafe speeds).
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

class LogEntry{
/**
 * Represents an entry from a single log line. Log lines look like this in the file:
 *
 * 34400.409 SXY288 210E ENTRY
 *
 * Where:
 * * 34400.409 is the timestamp in seconds since the software was started.
 * * SXY288 is the license plate of the vehicle passing through the toll booth.
 * * 210E is the location and traffic direction of the toll booth. Here, the toll
 *     booth is at 210 kilometers from the start of the tollway, and the E indicates
 *     that the toll booth was on the east-bound traffic side. Tollbooths are placed
 *     every ten kilometers.
 * * ENTRY indicates which type of toll booth the vehicle went through. This is one of
 *     "ENTRY", "EXIT", or "MAINROAD".
 **/


 //private final float timestamp;  //Change here actual question
    private final String timestamp;
    private final String licensePlate;
    private final String boothType;
    private final int location;
    private final String direction;

 public LogEntry(String logLine) {
        String[] tokens = logLine.split(" ");
        this.timestamp = tokens[0];
        this.licensePlate = tokens[1];
        this.boothType = tokens[3];
        this.location =
                Integer.parseInt(tokens[2].substring(0, tokens[2].length() - 1));
        String directionLetter = tokens[2].substring(tokens[2].length() - 1);
        if (directionLetter.equals("E")) {
            this.direction = "EAST";
        } else if (directionLetter.equals("W")) {
            this.direction = "WEST";
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getBoothType() {
        return boothType;
    }

    public int getLocation() {
        return location;
    }

    public String getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return String.format(
                "<LogEntry timestamp: %f  license: %s  location: %d  direction: %s  booth type: %s>",
                timestamp,
                licensePlate,
                location,
                direction,
                boothType
        );
    }
}

class LogFile{
    public int countJourneys()
    {
        int count=0;

        /**
         * iterate the loglist and get the action
         * if it is ENTRY
         * read the car's number plate and direction
         * create map_ENTRY and add this value
         * else if{
         * Action is EXIT
         * read the ca'rs number plate and direction and compare with the ENTRY map
         * increase the counter and remove number plate from ENTRY Map
         *
         * Car entered through Booth
         * read the car's number plat and also read the direction
         */

        // Write your code here..

        return count;

    }
    List<LogEntry> logEntries;

    public LogFile(BufferedReader reader) throws IOException {
        this.logEntries = new ArrayList<>();
        String line = reader.readLine();
        while (line != null) {
            LogEntry logEntry = new LogEntry(line.strip());
            this.logEntries.add(logEntry);
            line = reader.readLine();
        }
    }

    public LogEntry get(int index) {
        return this.logEntries.get(index);
    }

    public int size() {
        return this.logEntries.size();
    }
}


public class Solution {
    public static void main(String[] argv) throws IOException {
//        testLogFile();
//        testLogEntry();
        testCountJourneys();
    }

    public static void testLogFile() throws IOException {
        System.out.println("Running testLogFile");
        try (
                BufferedReader reader = new BufferedReader(
                        new FileReader("C:\\Users\\RA40112500\\IdeaProjects\\citibankprep\\src\\test\\resources\\tollbooth_small.log")
                );
        ) {
            LogFile logFile = new LogFile(reader);
            assertEquals(9, logFile.size());
            for (LogEntry entry : logFile.logEntries) {
                assert (entry instanceof LogEntry);
            }
        }
    }


    public static void testCountJourneys() throws IOException {
        System.out.println("Running testCountJourneys");
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\RA40112500\\IdeaProjects\\citibankprep\\src\\test\\resources\\tollbooth_small.log"))) {
            LogFile logFile = new LogFile(reader);
            assertEquals(3, logFile.countJourneys());
        }
        //Wrong file
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\RA40112500\\IdeaProjects\\citibankprep\\src\\test\\resources\\tollbooth_small.log"))) {
            LogFile logFile = new LogFile(reader);
            assertEquals(3, logFile.countJourneys());
        }
    }

    public static void testLogEntry() {
        System.out.println("Running testLogEntry");
        String logLine = "44776.619 KTB918 310E MAINROAD";
        LogEntry logEntry = new LogEntry(logLine);
        System.out.println("Log Entry print : "+ logEntry.getTimestamp());
        assertEquals("44776.619f", logEntry.getTimestamp(), 0.0001);
        assertEquals("KTB918", logEntry.getLicensePlate());
        assertEquals(310, logEntry.getLocation());
        assertEquals("EAST", logEntry.getDirection());
        assertEquals("MAINROAD", logEntry.getBoothType());
        logLine = "52160.132 ABC123 400W ENTRY";
        logEntry = new LogEntry(logLine);
        assertEquals("52160.132f", logEntry.getTimestamp(), 0.0001);
        assertEquals("ABC123", logEntry.getLicensePlate());
        assertEquals(400, logEntry.getLocation());
        assertEquals("WEST", logEntry.getDirection());
        assertEquals("ENTRY", logEntry.getBoothType());
        try (
                BufferedReader sampleLogs = new BufferedReader(
                        new FileReader("C:\\Users\\VI20107263\\Downloads\\KaratDemo\\KaratDemo\\src\\test\\resources\\tollbooth_small.log")
                );
        ) {
            LogFile logfile =new LogFile(sampleLogs);
            int totaljourneys= logfile.countJourneys();
            System.out.println(totaljourneys);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

/*LogFile logfile =new LogFile(sampleLogs);
        int totaljourneys= logfile.countJourneys();
        System.out.println(totaljourneys);*/


    }

}
