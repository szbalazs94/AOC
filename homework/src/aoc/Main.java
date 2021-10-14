package aoc;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int MinimumTimeRequired(int [] speeds, int n)
    {
        if (n < 3)
        {
            return speeds[n - 1];
        }
        else if (n == 3)
        {
            return speeds[0] + speeds[1] + speeds[2];
        }
        else
        {
            int temp1 = speeds[n - 1] + speeds[0] + speeds[n - 2] + speeds[0];
            int temp2 = speeds[1] + speeds[0] + speeds[n - 1] + speeds[1];

            if (temp1 < temp2)
            {
                return temp1 + MinimumTimeRequired(speeds, n - 2);
            }
            else if (temp2 < temp1)
            {
                return temp2 + MinimumTimeRequired(speeds, n - 2);
            }
            else
            {
                return temp2 + MinimumTimeRequired(speeds, n - 2);
            }
        }
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of participants and hit Enter: ");
        int numberOfPeople = s.nextInt();
        int [] crossingSpeeds = new int[numberOfPeople];
        System.out.println("Enter a speed for each participant separated with a space and hit Enter: ");

        for(int i=0; i < numberOfPeople; i++ ) {
            crossingSpeeds[i] = s.nextInt();
        }

        System.out.println(Arrays.toString(crossingSpeeds));

        Arrays.sort(crossingSpeeds);

        System.out.println("Minimum time required for the participants to cross: " + MinimumTimeRequired(crossingSpeeds, numberOfPeople) + " minutes");
    }
}
