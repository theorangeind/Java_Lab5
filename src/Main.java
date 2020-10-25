import java.util.List;
import java.util.Scanner;

public class Main
{
    public static WeatherStats stats = new WeatherStats();

    public static void main(String[] args)
    {
        //0116465a84c941d9a4eb16463b489e1a
        //https://api.weatherbit.io/v2.0/current?city=Odessa&key=0116465a84c941d9a4eb16463b489e1a

        JSONGetter jsonGetter = new JSONGetter();
        jsonGetter.start();

//        jsonGetter.checkWeather("Odessa");
//        jsonGetter.checkWeather("Kyiv");

        String input = "";
        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            System.out.println("Enter the name of a city where you want to check weather:");
            input = scanner.next();
            if(!jsonGetter.checkWeather(input))
            {
                System.out.println("Incorrect city name. Please, try again.");
                continue;
            }

            boolean shouldContinue = false;
            while (true)
            {
                System.out.println("Do you want to check another city? (Enter y/n)");
                input = scanner.next();
                if (input.equals("n"))
                {
                    break;
                }
                else if(input.equals("y"))
                {
                    shouldContinue = true;
                    break;
                }
                else
                {
                    System.out.println("Please, enter 'y' or 'n'!");
                }
            }

            if(!shouldContinue)
            {
                break;
            }
        }

        jsonGetter.stopSearch();

        try
        {
            jsonGetter.join();
        }
        catch (InterruptedException e) {}

        System.out.println("\nLoaded data:");
        for(CityWeatherStat item : stats.list)
        {
            System.out.println(item.toString() + "\n");
        }

        System.out.println("\nYour city stats:");
        WeatherStats filtered = stats.getByCity("Odessa");
        for(CityWeatherStat item : filtered.list)
        {
            System.out.println(item.toString() + "\n");
        }
    }
}
