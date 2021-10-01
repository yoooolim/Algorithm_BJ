import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2872_ThereIsLibraryInMyHouse {
    public static void main(String[] args) throws IOException {
        //input and initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = -1, maxIdx = -1;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            int temp = Integer.parseInt(br.readLine());
            if((max = Math.max(max,temp))==temp) maxIdx=i;
            arr[i]=temp;
        }
        //solution
        if(maxIdx==0) System.out.print(N-1);
        else {
            int left=maxIdx-1;
            int right=maxIdx;
            int length = 1;
            while(left>=0){
                if(arr[right]==arr[left]+1){
                    length++;
                    right=left;
                } left--;
            }
            System.out.print(N-length);
        }
    }
}
