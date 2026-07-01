class Solution {
    static List<List<String>>ll;
    static HashMap<String,HashMap<String,Double>>map;
    static double cost;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n=equations.size();
          map=new HashMap<>();
          for(int i=0;i<n;i++){
                String u=equations.get(i).get(0);
                String v=equations.get(i).get(1);
                map.putIfAbsent(u,new HashMap<>());
                 map.putIfAbsent(v,new HashMap<>());
          }
          for(int i=0;i<n;i++){
           String u=equations.get(i).get(0);
                String v=equations.get(i).get(1);
                double a=values[i];
                
                double costrev=1/a;
                map.get(u).put(v,a);
                map.get(v).put(u,costrev);
          }
         int q=queries.size();
         double[]ans=new double[q];
         int k=0;
         while(q-->0){
            String src=queries.get(k).get(0);
            String des=queries.get(k).get(1);
              if(!map.containsKey(src) || !map.containsKey(des)) {
                ans[k++] = -1.0;
                continue;
            }
              HashSet<String>visited=new HashSet<>();
             ans[k++]=dfs(src, des, 1.0, visited);
         }
         return ans;
        
    }
    public double dfs(String src,String des,double product,HashSet<String>visited){
        if(src.equals(des)){
            return product;
        }
        visited.add(src);
        for(String nbrs:map.get(src).keySet()){
                if(!visited.contains(nbrs)){
                  
                   double ans=dfs(nbrs,des,product*map.get(src).get(nbrs),visited);
                   if(ans!=-1){
                    return ans;
                   }
              }
           
              
    }
    return -1;
   
}
}