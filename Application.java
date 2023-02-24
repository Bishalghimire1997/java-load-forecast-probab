package Bayan;

import java.lang.reflect.Array;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Application {

	public static void main(String args[]) {
		ArrayList<Float> result=new ArrayList<Float>();

		// Importing data
		// path=""C:\\Users\\bishal.ghimire\\Desktop\\data\\loadValues.csv""
		//GetData Temp1 = new GetData();
		 //Training model
		//Model Temp2 = new Model(Temp1);

		/// Predicting
		//prediction Temp3 = new prediction(Temp2, 148, 1254, 1.0);
		//prediction Temp4 = new prediction(Temp2, 148.1, 105271, 1.0);
	Application foo=new Application();
	//System.out.print(Temp1.data.get(0));
	//Float avr=foo.predict((double)Temp1.data.get(0), 301, 1.0);
	foo.predict(0);
		

	}
//	public void looper(){
//		Model Temp1=new Model(new GetData());
//		Set<Integer> unique1 = new HashSet<Integer>(Temp1.consumption_in_group_small);
//		Iterator<Integer> iter = unique1.iterator();
//		double val=iter.next();
//		for (int i=0;i<Temp1.date.size();i++) {
//			Double avr=predict(val,i,1.0);
//			System.out.print(i);
//		}
//		
		
//	}

	public void predict(int date_index) {
		ArrayList<Double>predicted=new ArrayList<Double>();

				Model temp5 = new Model(new GetData());
				System.out.print("Working");
				
				
				for (int i=0;i<5000;i++) {
					for(int j=0; j<temp5.data_range.size();j++) {
						//System.out.println(temp5.data_range.get(j));
					prediction temp6=new prediction(temp5,temp5.data_range.get(j),i,1.0);
					///System.out.println(i);
				if (temp6.result>0) {
					
					Double avr=get_avrage(temp5.groupedData.get(temp6.ingroup));
					//System.out.println("gotittttttttttttttt");
					
					predicted.add(avr);
					//System.out.println(temp5.groupedData.get(temp6.ingroup));
					System.out.println(predicted);
					
					break;
				
				}
				
				else {}	
					}
				 
				}
				}

				
			
		
				//return 0.0;
	
	

	public double get_avrage(ArrayList<Float> a) {
		float avrage;
		
		double random=new Random().nextDouble();
		avrage = a.get(0) + a.get(1);
		
		return (double) (avrage / 2)+random;
	}
}
