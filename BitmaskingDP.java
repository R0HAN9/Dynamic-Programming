// Shortest Path Visiting All Nodes

class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        char[] arr = new char[n], allVisited = new char[n];
        Arrays.fill(arr, '0');
        Arrays.fill(allVisited, '1');
        String dest = new String(allVisited);
        Queue<Node> queue = new LinkedList<>();
        Map<Node, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder(new String(arr));
            sb.setCharAt(i, '1');
            Node src = new Node(i, sb.toString());
            queue.offer(src);
            map.put(src, 0);
        }
        while (!queue.isEmpty()) {
            Node parent = queue.poll();
            int node = parent.node;
            String state = parent.state;
            int parentDist = map.get(parent);
            for (int neighbor : graph[node]) {
                StringBuilder sb = new StringBuilder(state);
                sb.setCharAt(neighbor, '1');
                Node child = new Node(neighbor, sb.toString());
                if (!map.containsKey(child) || 
                    map.get(child) > 1 + parentDist) {
                    map.put(child, 1 + parentDist);
                    queue.offer(child);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (Map.Entry<Node, Integer> entry : map.entrySet()) {
            Node node = entry.getKey();
            int distance = entry.getValue();
            if (node.state.equals(dest)) {
                min = Math.min(min, distance);
            }
        }
        return min;
    }
    
    class Node {
        int node;
        String state;
        public Node(int node, String state) {
            this.node = node;
            this.state = state;
        }
        @Override
        public int hashCode() {
            return Objects.hash(node, state);
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Node other = (Node) obj;
            return node == other.node && state.equals(other.state);
        }
    }
}
