package jsonimplementation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.example.Internal;
import com.example.ItemInfo;
import com.example.ListItem;
import com.example.Sales;
import com.example.TimeSold;


public class GroceryStore {
	
	
	
	static ArrayList<ListItem> ls = new ArrayList<ListItem>();
	
	public static ArrayList<ListItem> jsonParser()
    {
        JSONParser parser = new JSONParser();
        try
        {
            Object object = parser
                    .parse(new FileReader("src/jsonimplementation/json.txt"));
            
            //convert Object to JSONObject
            JSONArray jsonArray = (JSONArray)object;
            
            for(int i =0; i<jsonArray.size();i++)
            {
            	JSONObject ob = (JSONObject) jsonArray.get(i);
            	String name = ob.get("Name").toString();
            	Long id = (Long) ob.get("ID");
            	
            	
            	JSONObject itemInfo = (JSONObject) ob.get("ItemInfo");
            	String des = itemInfo.get("Description").toString();
            	String category = itemInfo.get("Category").toString();
            	
            	JSONObject sales = (JSONObject) ob.get("Sales");
            	float price = Float.parseFloat(sales.get("Price").toString());
                float discount = Float.parseFloat(sales.get("Discount").toString());
            	
            	JSONObject internal = (JSONObject) ob.get("Internal");
            	int aisle = Integer.parseInt(internal.get("Aisle").toString());
            	
            	
            	JSONObject timesSold = (JSONObject) internal.get("TimesSold");
            	int yesterday =  Integer.parseInt(timesSold.get("Yesterday").toString());
            	int today =  Integer.parseInt(timesSold.get("Today").toString());
            	
            	
            	
            	//creating object to insert into arraylist 
            	ItemInfo ifo1 = new ItemInfo(des,category);
            	Sales sl1 = new Sales(price, discount);
            	TimeSold ts1 = new TimeSold(today, yesterday);
            	Internal in1 = new Internal(aisle, ts1);
            	
            	ListItem item = new ListItem(name, id, ifo1, sl1, in1);
            	ls.add(item);
            		
            	
            }
            

        }
        catch(FileNotFoundException fe)
        {
            fe.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return ls;
    }

}
