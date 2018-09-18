package com.example;


import java.util.ArrayList;

import org.json.simple.JSONArray;

import com.example.Internal;
import com.example.ItemInfo;
import com.example.ListItem;
import com.example.Sales;
import com.example.TimeSold;

import jsonimplementation.GroceryStore;
public class Utility {
	
	//Arraylist of GroceryItems
	static ArrayList<ListItem> ls = new ArrayList<ListItem>();
	
	
	//to calculate total cost after discount
	static float cashierCheckout(long id, int qty) {
		float cost = 0.0f;
		for(int i=0; i<ls.size() ;i++) {
			
			if(ls.get(i).id == id) {
				float price = ls.get(i).sales.price;
				float dis = ls.get(i).sales.discount;
				cost = qty*(price - dis);
			}
		}
		
		return cost;
	}
	
	//move to super saving aisle 15
	static void moveAisle() {
		for(int i=0;i<ls.size();i++) {
			if(ls.get(i).sales.price < 1.00) {
				Internal in = new Internal(15,ls.get(i).internal.timeSold);
				ListItem l1 = new ListItem(ls.get(i).name,ls.get(i).id, 
						ls.get(i).itemInfo, ls.get(i).sales, in);
				ls.set(i,l1);
			}
			
		}
		
	}
	
	// To find top 2 selling fruits
	static void  sales() {
		int max1 = 0, max2 = 0, pos1=0, pos2=-1;
		
		for(int i=0;i<ls.size();i++) {
			
			if((ls.get(i).itemInfo.category).equalsIgnoreCase("fruit")) {
			
				int today = ls.get(i).internal.timeSold.today;
				int yes = ls.get(i).internal.timeSold.yesterday;
				
				if(max1 < today+yes) {
					max1 = today+yes;
					pos1=i;
					
				}
				if((max2 < (today + yes) && (today + yes) < max1)|| pos2==-1) {
					max2 = today + yes;
					pos2 = i;
				}
			}
		} 
		if (pos2>=0)
		  System.out.println(ls.get(pos1).name +"  "+ls.get(pos2).name);
		else
			System.out.println("Fruits are unavailable!");
			
	}
	
	
	// To Insert data into list
	public static void insertList() {
		
		
	//For 1st element of arraylist
	ItemInfo ifo = new ItemInfo("Brown","grain");
	Sales sl = new Sales((float) 0.9, 0.1f);
	TimeSold ts = new TimeSold(0, 0);
	Internal in = new Internal(9, ts);
	
	//For 2nd element of arraylist
	ItemInfo ifo1 = new ItemInfo("Red Apple","fruit");
	Sales sl1 = new Sales(90, 10);
	TimeSold ts1 = new TimeSold(3, 5);
	Internal in1 = new Internal(9, ts1);
	
	//For 3rd element of arraylist
	ItemInfo ifo2 = new ItemInfo("Alphanso","fruit");
	Sales sl2 = new Sales((float) 0.1, 0.3f);
	TimeSold ts2 = new TimeSold(9, 50);
	Internal in2 = new Internal(8, ts2);
	
	//For 4th element of arraylist
	ItemInfo ifo3 = new ItemInfo("Fresh","fruit");
	Sales sl3 = new Sales((float) 0.7, 0.1f);
	TimeSold ts3 = new TimeSold(3, 5);
	Internal in3 = new Internal(7, ts3);
	
	//Creating objects to insert into arraylist
	ListItem l1 = new ListItem("Rice",1,ifo,sl,in);
	ListItem l2 = new ListItem("Apple",2,ifo1,sl1,in1);
	ListItem l3 = new ListItem("Mango",3,ifo2,sl2,in2);
	ListItem l4 = new ListItem("Banana",4,ifo3,sl3,in3);
	
	//adding elements to the arraylist manually
	ls.add(l1);
	ls.add(l2);
	ls.add(l3);
	ls.add(l4);

		
	}
	
	//Extracting data from json file and converting it to a custom arraylist
	public static void jsonToArrayList()
	{
		GroceryStore gs = new GroceryStore();
		ls.clear();
		ls.addAll(gs.jsonParser());
		
	}
	
	
	//main method
	public static void main(String[] args) {
		
		//Manipulation of data from list
		insertList();
		float cost= cashierCheckout(2,3);
		System.out.println("Total cost after discount :"+cost);
		sales();
		moveAisle();
		
		//Manipulation of data from json file 
		jsonToArrayList();
		float cost1= cashierCheckout(3,3);
		System.out.println("Total cost after discount :"+cost1);
		sales();
		moveAisle();
		
	}
}
