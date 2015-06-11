package decisiontree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
	static List<String> resultsList = new ArrayList<String>();

	static float[] LOG = {0,0,1.0f,1.58f,2.0f,2.32f,2.58f,2.81f,3.0f};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		
		
		String[] temp = s.split(" ");
		int numOfAttributes = Integer.parseInt(temp[0]);
		int count = Integer.parseInt(temp[1]);

		String[][] table = new String[numOfAttributes + 1][count];

		String[] attributes = new String[numOfAttributes + 1];
		attributes = br.readLine().split(" ");
		for (int i = 0; i < count; i++) {
			s = br.readLine();

			temp = s.split(" ");

			for (int j = 0; j < numOfAttributes + 1; j++) {
				table[j][i] = temp[j];
			}
		}

		for (String t : attributes) {
			System.out.print(t + " ");
		}
		System.out.println();

		for (String[] strings : table) {
			for (String t : strings) {
				System.out.print(t + " ");
			}
			System.out.println();
		}
		
		System.out.println(setResults(table[numOfAttributes]));
		

		float ans = 5*calculateSubEntropy(5, 1) + 5*calculateSubEntropy(5, 2) +
				2*calculateSubEntropy(2, 0);
		System.out.println(ans/(float)12);
		
		
	}

	public static float caluculateDisorder(String[] samples, String[] results) {
		List<String> sampleList = getList(samples);
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		
		for(String r:resultsList){
			map.put(r, 0);
		}
		
		for(String sample:sampleList){
			for(String k:map.keySet()){
				map.put(k, 0);
			}
			int count = 0;
			for(int i=0;i<samples.length;i++){
				if(samples[i].equals(sample)){
					map.put(results[i], (map.get(results[i]))+1);
					count++;
				}
			}
		}
	
		
		
		
		
		
		return 0.1f;
	}

	public static float calculateEntropy(int overall, int count, HashMap<String,Integer> map){
		
		return 0.1f;
	}
	
	public static float calculateEntropy(String line){
		String[] temps = line.split(" ");
		int[] nums = new int[temps.length]; 
		float ret=0;
		int count = 0;
		int overall = 0;
		for(String temp: temps){
			nums[count] = Integer.parseInt(temp);
			count++;
		}
		
		for(int i=0;i<nums.length/2;i++){
			int c = nums[i*2];
			int k = nums[i*2+1];
			overall += c;
			ret += c*calculateSubEntropy(c, k);
			System.out.println(ret);
			
		}
		
		System.out.println(overall);
		
		return ret/(float)overall;
	}
	
	
	/**
	 * 
	 * @param overall
	 * @param count
	 * @return
	 */
	public static float calculateSubEntropy(int overall,int count){
		if(count == 0 || overall == count || overall == 0){
			return 0;
		}
		
		float a = count*(LOG[overall] - LOG[count] );
		float b = (overall-count)*(LOG[overall] - LOG[overall - count] );
		float ret = (a+b)/(float)overall;
		return ret;
	}
	
	/**
	 * 
	 * @param results
	 * @return
	 */
	public static int setResults(String[] results) {
		for (String result : results) {
			if (!resultsList.contains(result)) {
				resultsList.add(result);
			}
		}
		
		return resultsList.size();

	}
	
	/**
	 * 
	 * @param samples
	 * @return
	 */
	public static List<String> getList(String[] samples){
		List<String> list = new ArrayList<String>();
		for (String result : samples) {
			if (!list.contains(result)) {
				list.add(result);
			}
		}
		return list;
	}
}
