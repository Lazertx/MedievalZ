package cc.ophion;

import java.util.ArrayList;

import cc.ophion.items.*;

public class ItemManager {
	
	public static ArrayList<Item> items = new ArrayList<Item>();

	public ItemManager() {
		new ItemBlastingWand();
	}
}
