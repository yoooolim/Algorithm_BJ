import java.util.Stack;

public class P42584_StockPrice {
    public static void main(String[] args){
//        int[] prices = {1,2,3,2,3};
//        int[] prices = {1,2,3,4,5,6,7,8,9,10};
        int[] prices = {10,9,8,7,6,5,4,3,2,1};
//        int[] prices = {1,2,3,2,3};
//        int[] prices = {1,2,3,2,3};
//        int[] prices = {1,2,3,2,3};
        int[] answer = solution(prices);
        for(int i : answer) System.out.print(i);
    }
    public static int[] solution(int[] prices) {
        int N = prices.length;
        int[] answer = new int[N];
        Stack<Stock> s = new Stack<>();
        for(int i=0;i<N;i++){
            int now = prices[i];
            if(!s.isEmpty()){
                while(!s.isEmpty()){
                    Stock peekS = s.peek();
                    if(peekS.price<=now) break;
                    s.pop();
                    answer[peekS.idx] = i-peekS.idx;
                }
            }
            s.push(new Stock(now,i));
        }
        while(!s.isEmpty()){
            Stock now = s.pop();
            answer[now.idx] = N-now.idx-1;
        }
        return answer;
    }
    private static class Stock{
        int price; int idx;
        Stock(int price, int idx) { this.price = price; this.idx=idx; }
    }
}
