package resterauntReservationApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import resterauntReservationApp.Category.KindOfItem;

public class IOHandler {

	public void loadMenuFromFile(String fileName, Category[] categories){
		int count = 0;
		Path pathToFile = Paths.get(fileName);
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_16)){
			String line = br.readLine();
			while(line != null){
				String[] attributes = line.split(",");
				Item item = new Item(attributes);
				KindOfItem kind = item.getItemCategory();
				categories[kind.ordinal()].addItemToCategory(item);
				count ++;
				//item.printItem();
				line = br.readLine();
				//System.out.println("DEBUG " + line);
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}

}
