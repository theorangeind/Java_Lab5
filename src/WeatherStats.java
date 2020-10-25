import java.util.ArrayList;
import java.util.List;

public class WeatherStats
{
    public List<CityWeatherStat> list = new ArrayList<CityWeatherStat>();

    public void add(CityWeatherStat item)
    {
        list.add(item);
    }

    public String toString()
    {
        String result = "";

        for(CityWeatherStat item : list)
        {
            result += item.toString() + System.lineSeparator();
        }

        return result;
    }

    public WeatherStats getByCity(String cityName)
    {
        WeatherStats result = new WeatherStats();

        for(CityWeatherStat item : this.list)
        {
            if(item.cityName.equals(cityName))
                result.add(item);
        }

        return result;
    }
}
