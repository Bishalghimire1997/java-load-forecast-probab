package Bayan;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class prediction {
	ArrayList<ArrayList<Integer>> weight;
	ArrayList<OffsetDateTime> date;
	ArrayList<ArrayList<Double>> posterior_matrix;
	ArrayList<ArrayList<Double>> probablity;
	ArrayList<ArrayList<Double>> emptyPosteriorMatrix;
	ArrayList<ArrayList<Float>> groupedData;
	ArrayList<Integer> consumptionInSmallGroup;
	double posterior;
	double prior;
	double result;
	double consumption;
	int dateIndex;
	int uniqueIndex;
	int ingroup;
	//double Posterior;
	Set<Integer> uniqueDataGroup;

	// Model Temp2=new Model(new GetData());

	prediction(Model Temp2, double consumption, int dateIndex, double prior) {
		// this.index= index;
		this.date = Temp2.date;
		this.weight = Temp2.Weight;
		//this.Posterior=Posterior;
		this.posterior_matrix = new ArrayList<ArrayList<Double>>();
		this.probablity = Temp2.posterior;
		this.consumptionInSmallGroup = Temp2.consumption_in_group_small;
		this.groupedData = Temp2.groupedData;
		this.uniqueDataGroup = Temp2.unique;
		this.consumption = consumption;
		this.dateIndex = dateIndex;
		//this.ingroup=ingroup;
		//this.uniqueIndex=uniqueIndex;
		this.prior=prior;

		this.posterior=(double)this.getposterior();
		this.result=this.getprobablityofload();
	}

	public double getposterior() {
		/// Identify to which group data belongs
		 this.ingroup=0;
		ArrayList<Integer> indexToBeChecked = new ArrayList<Integer>();
		double Posterior=0;
		for (int j = 0; j < (this.groupedData.size()); j++) {

			if (this.consumption >= Collections.min(this.groupedData.get(j))
					&& this.consumption < Collections.max(this.groupedData.get(j))) {

				this.ingroup = j;
//				System.out.println("The provided data falls in following data group");
//				System.out.println(ingroup);
//				System.out.println("The load range for provided data is ");
//				System.out.println(this.groupedData.get(ingroup));
				

			} 
			else {
				// System.out.print("Load range doesnot eist");

			}

		}
	
		
		Set<Integer> unique1 = new HashSet<Integer>(this.consumptionInSmallGroup);
		//System.out.println(unique);
		Iterator<Integer> iter = unique1.iterator();
		int counter=0;

		while (iter.hasNext()) {
			counter=counter+1;
			
			int temp = iter.next();
			if(this.ingroup==temp) {
				//System.out.println("unique index");
				
				this.uniqueIndex=counter;
//				System.out.println(this.uniqueIndex);
				
			}
			
		}
//		System.out.println(this.uniqueIndex);
//		System.out.println(this.weight.size());
//		indexToBeChecked = this.weight.get(this.uniqueIndex);
//		System.out.println("The data group has previously occur in following dates index");
//		System.out.println(indexToBeChecked);
//		System.out.println("Corresponding dates are");
//		System.out.println(this.date.get(indexToBeChecked.get(0)));
//		System.out.println(this.date.get(indexToBeChecked.get(1)));
//		System.out.println(this.date.get(indexToBeChecked.get(2)));
//		System.out.println(this.date.get(indexToBeChecked.get(3)));
//		System.out.println(this.date.get(indexToBeChecked.get(4)));
//		System.out.println(this.date.get(indexToBeChecked.get(5)));
//		System.out.println(this.date.get(indexToBeChecked.get(6)));
//		System.out.println("Date passed by user");
//		System.out.println(this.date.get(this.dateIndex));
//		
		
		for(int i=0;i<this.weight.get(this.uniqueIndex).size();i++) {

//			System.out.println(this.weight.get(this.uniqueIndex).get(i));
			if(this.weight.get(this.uniqueIndex).get(i)==this.dateIndex) {
			Posterior=this.probablity.get(this.uniqueIndex).get(i);
//			System.out.print("This works");
			}
			else {}
			
		}
//		System.out.println("This is posterior");
//		System.out.println(Posterior);
		return Posterior;

	}
	public double getprobablityofload() {
		double result=(double)(this.posterior*this.prior)*this.date.size();
				//System.out.println("the probablity of load based on last year data to occur at given time is ");
//		System.out.println(result);
		return result;
	}
	
	// this.consumption_in_group.add(this.consumption_in_group_small);
	// this.consumption_in_group_small = new ArrayList<Integer>();

}
