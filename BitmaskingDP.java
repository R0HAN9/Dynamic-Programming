// Shortest Path Visiting All Nodes

class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length; // Number of nodes in the graph
        
        // Initialize two character arrays to track visited states
        char[] arr = new char[n]; // Represents the current state of visited nodes
        char[] allVisited = new char[n]; // Represents the state when all nodes are visited
        Arrays.fill(arr, '0'); // Initially, no nodes are visited
        Arrays.fill(allVisited, '1'); // Target state: all nodes are visited
        
        // Convert target state to a String for comparison
        String dest = new String(allVisited);
        
        // Initialize BFS queue and a map to track the minimum distance for each state
        Queue<Node> queue = new LinkedList<>();
        Map<Node, Integer> map = new HashMap<>();
        
        // Add all nodes as starting points in the BFS
        for (int i = 0; i < n; i++) {
            // Create the initial state for each node as the starting point
            StringBuilder sb = new StringBuilder(new String(arr));
            sb.setCharAt(i, '1'); // Mark the current node as visited
            Node src = new Node(i, sb.toString()); // Create a Node object
            queue.offer(src); // Add it to the queue
            map.put(src, 0); // Initial distance for this node is 0
        }
        
        // Perform BFS
        while (!queue.isEmpty()) {
            Node parent = queue.poll(); // Dequeue the current node
            int node = parent.node; // Current node index
            String state = parent.state; // Current state of visited nodes
            int parentDist = map.get(parent); // Distance to reach this state
            
            // Explore all neighbors of the current node
            for (int neighbor : graph[node]) {
                // Update the visited state for the neighbor
                StringBuilder sb = new StringBuilder(state);
                sb.setCharAt(neighbor, '1'); // Mark the neighbor as visited
                Node child = new Node(neighbor, sb.toString()); // Create a new Node object
                
                // If this state hasn't been visited or we found a shorter path to this state
                if (!map.containsKey(child) || map.get(child) > 1 + parentDist) {
                    map.put(child, 1 + parentDist); // Update the distance
                    queue.offer(child); // Enqueue the neighbor with the updated state
                }
            }
        }
        
        // Find the shortest distance to the target state where all nodes are visited
        int min = Integer.MAX_VALUE;
        for (Map.Entry<Node, Integer> entry : map.entrySet()) {
            Node node = entry.getKey();
            int distance = entry.getValue();
            if (node.state.equals(dest)) { // Check if the state represents all nodes visited
                min = Math.min(min, distance); // Update the minimum distance
            }
        }
        
        return min; // Return the shortest path length
    }
    
    // Helper class to represent a graph node and its visited state
    class Node {
        int node; // Index of the graph node
        String state; // String representation of visited nodes
        
        public Node(int node, String state) {
            this.node = node;
            this.state = state;
        }
        
        @Override
        public int hashCode() {
            // Use Objects.hash to calculate a hash code for Node
            return Objects.hash(node, state);
        }
        
        @Override
        public boolean equals(Object obj) {
            // Check if two Node objects are equal
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Node other = (Node) obj;
            return node == other.node && state.equals(other.state);
        }
    }
}
