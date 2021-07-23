public class P77885_2OrLessDifferentBits {
    public static void main(String[] args){
        long[] numbers = {2,7};
        long[] answer = solution(numbers);
        for(long i : answer) System.out.print(i+" ");
    }
    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        int answerCount = 0;
        for(long i : numbers){
            if(i%2==0) {answer[answerCount++] = i+1;}
            else{answer[answerCount++]=get2OrLessDifferentBits(i);}
        }
        return answer;
    }
    public static long get2OrLessDifferentBits(long ori){
        int count = 1;
        long oriCopy = ori;
        ori/=2;
        while(ori%2==1){count++;ori/=2;}
        oriCopy= (long) (oriCopy+Math.pow(2,count)-Math.pow(2,count-1));
        return oriCopy;
    }
}
