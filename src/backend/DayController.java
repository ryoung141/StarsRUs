import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class DayController extends Controller
{
	public DayController()
	{
		if(Controller.open || !Controller.open)
		{
			System.out.println(getDate());
		}
	}

	public void openMarket()
	{
		this.open = true;
	}

	public void closeMarket()
	{
		this.open = false;
		String d = Controller.date;
		String temp[] = d.split("/");
		String day = temp[1];
		int date = Integer.parseInt(day);
		date++;
		d = temp[0]+"/"+Integer.toString(date)+"/"+temp[2];

		Controller.date = d;
		item.setSystemDay(d);

		
	}

	public void setDay(String date)
	{
		Controller.date = date;
		item.setSystemDay(date);
	}

	public String getDate()
	{
		return Controller.date;
	}

}