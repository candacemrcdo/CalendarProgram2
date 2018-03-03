package parsers;

import java.io.*;

import backend.*;

public class CSVDataParser extends DataParser {
	
	public void readData(){
		try {
			File f = new File("src\\sample_files\\Events.csv");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
		
			String curLine = br.readLine();
			
			while(curLine != null) {
				
				String line[] = curLine.split(",");
				eventlines.add(line);
			
				curLine = br.readLine();
			}

			f = new File("src\\sample_files\\Tasks.csv");
			fr = new FileReader(f);
			br = new BufferedReader(fr);

			curLine = br.readLine();

			while(curLine != null) {

				String line[] = curLine.split(",");
				tasklines.add(line);

				curLine = br.readLine();
			}

			br.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void processData() {
		CalendarItems items = new CalendarItems();
		
		for(int i = 0; i < eventlines.size(); i++) {
			for(int j = 0; j < eventlines.get(i).length; j=j+4) {
								
				Event e = new Event();

				String line = eventlines.get(i)[j];
				String date[] = line.split("/");
				e.setDate(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));

				line = eventlines.get(i)[j+1];
				String starttime[] = line.split(":");
				e.setStartTime(Integer.parseInt(starttime[0]), Integer.parseInt(starttime[1]));
				
				line = eventlines.get(i)[j+2];
				String endtime[] = line.split(":");
				e.setEndTime(Integer.parseInt(endtime[0]), Integer.parseInt(endtime[1]));
				
				e.setTitle(eventlines.get(i)[j+3]);
				
				items.addEvent(e);
			}
		}
		
		for(int i = 0; i < tasklines.size(); i++) {
			for(int j = 0; j < tasklines.get(i).length; j=j+3) {
								
				Task t = new Task();

				String line = tasklines.get(i)[j];
				String date[] = line.split("/");
				t.setDate(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));

				line = tasklines.get(i)[j+1];
				String starttime[] = line.split(":");
				t.setStartTime(Integer.parseInt(starttime[0]), Integer.parseInt(starttime[1]));
								
				t.setTitle(tasklines.get(i)[j+2]);
				
				items.addEvent(t);
			}
		}
		//items.printEvents(); //test
	}	

	public static void writeData(int index) {
		
	}
}
