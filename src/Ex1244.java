import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1244 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=t; i++){
            sb.append("#" + i+ " ");

            StringTokenizer st = new StringTokenizer(br.readLine());

            String num = st.nextToken();
            int cnt = Integer.parseInt(st.nextToken());
            boolean[] visited = new boolean[num.length()];
            int[] arr = new int[2];

            swapNumber(num, arr, visited, 0, 0, 2);
        }
    }

    private static void swapNumber(String num, int[] arr, boolean[] visited, int start, int depth, int r){
        if(depth == r){
            swap(num, arr[0], arr[1]);
            return;
        }

        for(int i=start; i<num.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i;
                swapNumber(num, arr, visited, start+1, depth+1, r);
                visited[i] = false;
            }
        }
    }

    private static void swap(String num, int x, int y){
        char c = num.charAt(x);

    }
}
