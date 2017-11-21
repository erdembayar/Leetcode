package Leetcode57;

import java.util.ArrayList;
import java.util.List;


class Node {
    String val;         // Email address;
    String username;    // Username;
    List<Node> neighbors;
    Node(String val, String username) {
        this.val = val;
        this.username = username;
        neighbors = new ArrayList<>();
    }
}