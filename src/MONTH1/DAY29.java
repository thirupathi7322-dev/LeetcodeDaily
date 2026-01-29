class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {       
        int n= source.length();
        int m=target.length();

        if(m!=n)    return -1; 

        //prepare a all pair shortest path 
        int[][] dist= new int[26][26];
        for(int i=0; i<26; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i]=0;
        }

        for(int i=0; i<original.length; i++){
            int u=original[i]-'a', v=changed[i]-'a';
            dist[u][v]= Math.min(dist[u][v], cost[i]);
        }

        floydWarshall(original, changed, cost, dist);

        long ans=0;

        for(int i=0; i<n; i++){
            char ch1=source.charAt(i), ch2= target.charAt(i);
            if(ch1==ch2)    continue;
            else{
                int minCost=dist[ch1-'a'][ch2-'a'];
                if(minCost==Integer.MAX_VALUE)  return -1;
                ans= ans+minCost;
            }
        }
        return ans;
    }
    public void floydWarshall(char[] original,char[] changed,int[] cost, int[][] dist){
         
        for(int k=0; k<26; k++){
            for(int i=0; i<26; i++){
                for(int j=0; j<26; j++){
                    if(dist[i][k]!=Integer.MAX_VALUE && dist[k][j]!=Integer.MAX_VALUE){
                        dist[i][j]= Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                    }
                }
            }
        }
    }
}