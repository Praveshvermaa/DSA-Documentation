class Solution {
    public void dfs(List<Integer>[] graph,int [] vis,int node,int []nodeAndEdgesCountTarck){
        vis[node] = 1;
        nodeAndEdgesCountTarck[0]++;
        nodeAndEdgesCountTarck[1] += graph[node].size();
        for(int no : graph[node]){
            if(vis[no]==0){
                dfs(graph,vis,no,nodeAndEdgesCountTarck);
            }
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer> [] graph = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int [] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int totalCom = 0;
        int [] vis = new int[n];
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                int [] nodeAndEdgesCountTarck = new int[2];
                dfs(graph,vis,i,nodeAndEdgesCountTarck);
                if(nodeAndEdgesCountTarck[0]*(nodeAndEdgesCountTarck[0]-1)==nodeAndEdgesCountTarck[1]){
                    totalCom++;
                }
            }
        }
        return totalCom;
    }
}