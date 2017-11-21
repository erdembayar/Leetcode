package Leetcode57;
//https://discuss.leetcode.com/category/1590/accounts-merge
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem721 {
	public static void main(String[] args) {
	List<List<String>>	 accounts = new ArrayList<List<String>>();
	List<String> pieces = new ArrayList<String>();

	String[] linePieces = new String[] {
    		"John", "johnsmith@mail.com", "john00@mail.com"
    };
	
	for (String piece : linePieces) {
		pieces.add(piece);
	}
	accounts.add(pieces);

	pieces = new ArrayList<String>();
	linePieces = new String[] {"John", "johnnybravo@mail.com"};	
	for (String piece : linePieces) {
		pieces.add(piece);
	}
	accounts.add(pieces);

	pieces = new ArrayList<String>();
	linePieces = new String[] {"John", "johnsmith@mail.com", "john_newyork@mail.com"};	
	for (String piece : linePieces) {
		pieces.add(piece);
	}
	accounts.add(pieces);

	pieces = new ArrayList<String>();
	linePieces = new String[] {"Mary", "mary@mail.com"};	
	for (String piece : linePieces) {
		pieces.add(piece);
	}
	accounts.add(pieces);		
	
	List<List<String>> result = accountsMerge(accounts);
	
	for (List<String> list : result) {
		System.out.print("[");
		for (String str : list) {
			System.out.print(str);
			System.out.print(",");
		}
		System.out.println("],");
	}
}
	
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        Map<String, Node> map = new HashMap<>();    // <Email, email node>  
                
        // Build the graph;
        for (int i = 0; i < accounts.size(); i++) {
            List<String> list = accounts.get(i);
            for (int j = 1; j < list.size(); j++) {
                String email = list.get(j);
                
                if (!map.containsKey(email)) {
                    Node node = new Node(email, list.get(0));
                    map.put(email, node);
                }
                
                if (j == 1) continue;
                //Connect the current email node to the previous email node;
                map.get(list.get(j - 1)).neighbors.add(map.get(email));
                map.get(email).neighbors.add(map.get(list.get(j - 1)));
            }
        }
        
        // DFS search for each components(each account);
        Set<String> visited = new HashSet<>();
        for (String s : map.keySet()) {
            if (visited.add(s)) {
                List<String> list = new LinkedList<>();
                list.add(s);              
                dfs(map.get(s), visited, list);
                Collections.sort(list);
                list.add(0, map.get(s).username);
                res.add(list);
            }
        }        
        return res;
    }
    
    public static void dfs(Node root, Set<String> visited, List<String> list) {
        for (Node node : root.neighbors) {
            if (visited.add(node.val)) {
                list.add(node.val);
                dfs(node, visited, list);
            }
        }
    }

}
