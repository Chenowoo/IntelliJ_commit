import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1244 {
    private static int cnt, max;
    private static String[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=t; i++){
            sb.append("#").append(i).append(" ");

            StringTokenizer st = new StringTokenizer(br.readLine());

            num = st.nextToken().split("");
            cnt = Integer.parseInt(st.nextToken());
            max = Integer.MIN_VALUE;

            if(num.length < cnt){
                cnt = num.length;
            }
            swapNumber(0, 0);
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
    private static void swapNumber(int start, int depth){
        if(depth == cnt){
            StringBuilder answer = new StringBuilder();
            for (String s : num) {
                answer.append(s);
            }
            max = Math.max(max, Integer.parseInt(answer.toString()));
            return;
        }

        for(int i=start; i<num.length; i++){
            for(int j=i+1; j<num.length; j++){
                String temp = num[i];
                num[i] = num[j];
                num[j] = temp;

                swapNumber(i, depth+1);

                temp = num[i];
                num[i] = num[j];
                num[j] = temp;
            }
        }
    }


}
