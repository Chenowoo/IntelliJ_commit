import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1954 {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i=1; i<t+1; i++){
            sb.append("#" + i + "\n");

            int n = Integer.parseInt(br.readLine());
            int[][] arr = snailArr(n);
            printArr(arr);
        }
        System.out.println(sb);
    }

    private static int[][] snailArr(int n) {
        int[][] arr = new int[n][n];

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int x = 0;
        int y = 0;
        int d = 1;//방향
        int num = 1;
        arr[x][y] = num;

        while(num<n*n) {

            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx>=0 && nx<n && ny>=0 && ny<n && arr[nx][ny]==0) {
                num++;
                arr[nx][ny] = num;
            } else {
                nx -= dx[d];
                ny -= dy[d];
                d++;
                if(d==4) d=0;
            }
            x = nx;
            y = ny;
        }
        return arr;
    }

    public static void printArr(int[][] arr){
        int size =  arr.length;

        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }
    }
}
