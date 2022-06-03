package chekk.santa.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import chekk.santa.domains.SantaDTO;

@Service
public class SantaService {
	private Logger logger = LoggerFactory.getLogger(SantaService.class);

	public ArrayList<Integer> count(SantaDTO santaDTO) {
		ArrayList<Integer> present_weights = santaDTO.getPresent_weights();
		int hood_capacity = santaDTO.getHood_capacity();

		ArrayList<ArrayList<Integer>> ans = combinationSum(present_weights, hood_capacity);

		if (ans.size() == 0) {
			throw new ValidationException("Empty weights");
			// System.out.println("Empty");
			// return;
		}

		int min = Integer.MAX_VALUE;
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < ans.size(); i++) {
			if (ans.get(i).size() < min) {
				result = ans.get(i);
				min = ans.get(i).size();
			}
		}
		// System.out.println(result);
		return result;
	}

	private static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> arr, int sum) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		ArrayList<Integer> temp = new ArrayList<>();
		Set<Integer> set = new HashSet<>(arr);
		arr.clear();
		arr.addAll(set);
		Collections.sort(arr);
		findNumbers(ans, arr, sum, 0, temp);
		return ans;
	}

	private static void findNumbers(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> arr, int sum, int index,
			ArrayList<Integer> temp) {
		if (sum == 0) {
			ans.add(new ArrayList<>(temp));
			return;
		}
		for (int i = index; i < arr.size(); i++) {
			if ((sum - arr.get(i)) >= 0) {
				temp.add(arr.get(i));
				findNumbers(ans, arr, sum - arr.get(i), i, temp);
				temp.remove(arr.get(i));
			}
		}
	}
}
