import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex2001 {
    private static int n, m;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int  t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<t+1; i++){
            sb.append("#" + i + " ");

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new int[n][n];

            for(int j=0; j<n; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<n; k++){
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            int max = Integer.MIN_VALUE;
            for(int j=0; j<=n-m; j++){
                for(int k=0; k<=n-m; k++){
                    max = Math.max(max, catchFly(j,k));
                }
            }
            sb.append(max + "\n");
        }
        System.out.println(sb);
    }

    private static int catchFly(int x, int y){
        int sum = 0;
        for(int i=x; i<x+m; i++){
            for(int j=y; j<y+m; j++) {
                sum += arr[i][j];
            }
        }
        return sum;
    }
}