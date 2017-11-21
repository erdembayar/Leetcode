package Problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//https://stackoverflow.com/questions/4640034/calculating-all-of-the-subsets-of-a-set-of-numbers
public class powerSetIteration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> originalSet = new HashSet<Integer>();
		
		originalSet.add(1);
		originalSet.add(2);
		originalSet.add(3);
		
		Set<Set<Integer>> result = powerSet(originalSet);
		for (Set<Integer> set : result) {
			System.out.println(set);
		}
	}
	public static Set<Set<Integer>> powerSet(Set<Integer> originalSet) {
        Set<Set<Integer>> sets = new HashSet<Set<Integer>>();
        if (originalSet.isEmpty()) {
            sets.add(new HashSet<Integer>());
            return sets;
        }
        List<Integer> list = new ArrayList<Integer>(originalSet);
        Integer head = list.get(0);
        Set<Integer> rest = new HashSet<Integer>(list.subList(1, list.size()));
        for (Set<Integer> set : powerSet(rest)) {
            Set<Integer> newSet = new HashSet<Integer>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }
        return sets;
    }
}
