import java.util.ArrayList;
import java.util.List;

public class TSP {
    public static int findNearestCity(int v ,boolean[] visited , int[][] c){
        int n = c.length;
        int w = -1; // Thành phố gần nhất, ban đầu đặt là -1 (chưa xác định).
        int minCost = Integer.MAX_VALUE; //Ban đầu đặt là vô cực (Integer.MAX_VALUE) để luôn cập nhật giá trị nhỏ hơn.

        for (int i = 0;i < n;i++) {
            if(!visited[i] && c[v][i] < minCost){
                w = i;
                minCost = c[v][i];
            }
        }
        return w;
    }
    public static void GTS1(int n , int u , int[][] c) {
        boolean[] visited = new boolean[n];
        List<Integer> tour = new ArrayList<>();
        int cost = 0;

        //xuat phat
        int v = u;
        visited[v] = true;
        tour.add(v);

        for (int i = 1; i < n ; i++ ){
            int w = findNearestCity(v, visited, c);
            if(w != -1){
                tour.add(w);
                cost += c[v][w];
                visited[w] = true;
                v = w;
            }
        }

         // Quay lại thành phố xuất phát
        cost += c[v][u];
        tour.add(u);

        System.out.println("Hành trình (tour): " + tour);
        System.out.println("Tổng chi phí (cost): " + cost);
    }
}
