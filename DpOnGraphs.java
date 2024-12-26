// Cheapest Flights Within K Stops

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // Create an adjacency list to represent the graph
        Map<Integer, List<int[]>> adj = new HashMap<>();
        
        // Array to track the minimum cost to reach each node
        int[] visited = new int[n];
        Arrays.fill(visited, Integer.MAX_VALUE); // Initialize with a high value
        visited[src] = 0; // Cost to reach the source is 0
        
        // Populate the adjacency list with flight information
        for (int[] flight : flights) {
            adj.computeIfAbsent(flight[0], key -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }
        
        // Queue to perform a BFS-like traversal (stores [node, current cost])
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0});
        
        // Increment K by 1 to include the source node in the count
        K++;
        
        // BFS with a limit of K stops
        while (!queue.isEmpty() && K-- > 0) {
            int size = queue.size(); // Process all nodes at the current level
            while (size-- > 0) {
                int[] curr = queue.poll(); // Dequeue the current node
                int currNode = curr[0]; // Current node
                int currPrice = curr[1]; // Current total cost
                
                // Explore neighbors of the current node
                if (adj.containsKey(currNode)) {
                    for (int[] neighbor : adj.get(currNode)) {
                        int newPrice = currPrice + neighbor[1]; // Calculate new cost
                        
                        // If the new cost is less than the previously recorded cost
                        if (newPrice < visited[neighbor[0]]) {
                            visited[neighbor[0]] = newPrice; // Update the cost
                            queue.offer(new int[]{neighbor[0], newPrice}); // Enqueue the neighbor
                        }
                    }
                }
            }
        }
        
        // Return the minimum cost to reach the destination, or -1 if unreachable
        return visited[dst] == Integer.MAX_VALUE ? -1 : visited[dst];
    }
}

