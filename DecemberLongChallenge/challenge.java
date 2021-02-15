import java.io.*; 
import java.util.*; 
  

class Graph 
{ 
    private int V;   // No. of vertices 
    private ArrayList<Integer> adj[]; // Adjacency List
    private int niveles[];
    private int index[];
  
    Graph(int v) 
    { 
        V = v; 
        adj = new ArrayList[v];
        niveles= new int[v];
        index= new int[v];
        for (int i=0; i<v; ++i) {
            adj[i] = new ArrayList();
            index[i]=i;
        }
            
    } 
    void addEdge(int v,int w) { adj[v].add(w); } 
  
    void topologicalSortUtil(int v, boolean visited[], 
                             Stack stack) 
    { 
        visited[v] = true; 
        Integer i; 
        Iterator<Integer> it = adj[v].iterator(); 
        while (it.hasNext()) 
        { 
            i = it.next(); 
            if (!visited[i]) 
                topologicalSortUtil(i, visited, stack); 
        } 
  
        stack.push(new Integer(v)); 
    } 

    void topologicalSort() 
    { 
        Stack<Integer> s = new Stack<Integer>(); 
  
        boolean visited[] = new boolean[V]; 
        for (int i = 0; i < V; i++) 
            visited[i] = false; 
  
        for (int i = 0; i < V; i++) 
            if (visited[i] == false) 
                topologicalSortUtil(i, visited, s); 
  
        while(!s.isEmpty()){
            int aux=s.pop();
            for(int i=0; i<adj[aux].size(); i++){
                niveles[adj[aux].get(i)]=Math.max(niveles[adj[aux].get(i)], niveles[aux]+1);
            }
        }
        mergeSort(niveles, index, 0, V-1);

        int i=V-1;
        int s1=0, c=0;
        while(i>=0){
            if(i>0 && niveles[i]==niveles[i-1]){
                s1++;
                c++;
                i-=2;
            }else if(i>0){
                int j=i-1;
                boolean p = false;
                while(j>=0 &&niveles[j]==niveles[i-1] && !p){
                    if(!adj[index[j]].contains(index[i])){
                        p=true;
                        j++;
                    }
                    j--;
                }
                if(p){
                    int aux=niveles[j];
                    niveles[j]=niveles[i-1];
                    niveles[i-1]=aux;
                    aux=index[j];
                    index[j]=index[i-1];
                    index[i-1]=aux;
                    s1++;
                    c++;
                    i-=2;
                }else{
                    i--;
                    s1++;
                }
            }else{
                i--;
                s1++;
            }
        }
        i=V-1;
        System.out.println(s1);
        while(i>=0){
            if(i>0 && niveles[i]==niveles[i-1]){ 
                System.out.println("2 "+(index[i]+1)+" "+(index[i-1]+1));
                s1++;
                c++;
                i-=2;
            }else if(i>0 && !adj[index[i-1]].contains(index[i])){
                System.out.println("2 "+(index[i]+1)+" "+(index[i-1]+1));
                s1++;
                c++;
                i-=2;
            }else{
                System.out.println("1 "+(index[i]+1));
                i--;
                s1++;
            }
        }

    }
    
    void merge(int arr[], int index[] ,int l, int m, int r) 
{ 
    int i, j, k; 
    int n1 = m - l + 1; 
    int n2 =  r - m; 

    int L[] = new int [n1]; 
    int R[] = new int [n2];
    int iL[] = new int [n1]; 
    int iR[] = new int [n2];

    for (i = 0; i < n1; i++){ 
        L[i] = arr[l + i]; 
        iL[i]=index[l+i];
    }
    for (j = 0; j < n2; j++) {
        R[j] = arr[m + 1+ j];
        iR[j]=index[m + 1+ j]; 
    }
  
    i = 0; // Initial index of first subarray 
    j = 0; // Initial index of second subarray 
    k = l; // Initial index of merged subarray 
    while (i < n1 && j < n2) 
    { 
        if (L[i] <= R[j]) 
        { 
            arr[k] = L[i];
            index[k]=iL[i];
            i++; 
        } 
        else
        { 
            arr[k] = R[j];
            index[k]=iR[j];
            j++; 
        } 
        k++; 
    } 

    while (i < n1) 
    { 
        arr[k] = L[i];
        index[k]=iL[i];
        i++; 
        k++; 
    } 
  
    while (j < n2) 
    { 
        arr[k] = R[j];
        index[k]=iR[j]; 
        j++; 
        k++; 
    } 
} 
  
void mergeSort(int arr[], int index[], int l, int r) 
{ 
    if (l < r) 
    { 
        int m = l+(r-l)/2; 
        mergeSort(arr, index, l, m); 
        mergeSort(arr, index, m+1, r); 
  
        merge(arr, index, l, m, r); 
    } 
} 
  
    
}


class challenge{
    public static void main(String args[]) 
    { 
        // Create a graph given in the above diagram 
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        Graph g = new Graph(n);
        for(int i=0; i<m; i++){
            g.addEdge(in.nextInt()-1, in.nextInt()-1);
        }
        g.topologicalSort(); 
    } 


}