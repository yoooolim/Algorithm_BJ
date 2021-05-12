/* 미완성.. */
package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1082_RoomNumber {
    static int numOfNumber;
    static Product[] eachPrice;
    static Product[] eachPriceSortByIndex;
    static int money;
    public static void main(String[] args) throws Exception{

        //input and initialization
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        numOfNumber = Integer.parseInt(br.readLine());
        eachPrice=new Product[numOfNumber];
        eachPriceSortByIndex = new Product[numOfNumber];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<numOfNumber;i++) {
            eachPrice[i] = new Product(i, Integer.parseInt(st.nextToken(" ")));
            eachPriceSortByIndex[i]=eachPrice[i];
        }
        money = Integer.parseInt(br.readLine());
        Comparator<Product> comparator = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getPrice()-o2.getPrice();
            }
        };
        Arrays.sort(eachPrice,comparator);

        //문구점에서 0만 판매하는 경우
        if(numOfNumber==1){
            System.out.print("0");
            System.exit(0);
        }
        int max = maxDigit();
        System.out.print(getMaxRoomNumber(max));
    }
    public static int maxDigit(){
        int digit = 0;
        if(eachPrice[0].getNumber()!=0){
            int pay=0;
            while((pay+=eachPrice[0].getPrice())<=money){
                digit++;
            }
        }
        else{
            int pay = eachPrice[0].getPrice();
            digit = 1;
            while((pay+=eachPrice[1].getPrice())<=money){
                digit++;
            }
        }
        return digit;
    }

    public static String getMaxRoomNumber(int digit){
        StringBuilder max = new StringBuilder();
        for(int i=0;i<digit;i++) max.append(numOfNumber-1);
        int count = digit*eachPriceSortByIndex[numOfNumber-1].getPrice(); //가장 큰 수로만 이루어짐
        int maxNumIndex = 0;
        for(int i=0;i<numOfNumber;i++){
            if(numOfNumber-1==eachPrice[i].getNumber()) {
                maxNumIndex=i;
                break;
            }
        }

        for(int i=0;i<digit;i++){
            for(int j=maxNumIndex;j>0;j--){
                if(count<=money) return max.toString();
                if(eachPrice[j].getPrice()==eachPrice[j-1].getPrice()) continue;
                max.replace(digit-i-1,digit-i,Integer.toString(eachPrice[j-1].getNumber()));
                count-=eachPrice[j].getPrice()-eachPrice[j-1].getPrice();
            }
        }
        return max.toString();
    }
    public static class Product {
        private int number;
        private int price;
        Product(int number, int price){
            this.number=number;
            this.price=price;
        }
        public int getNumber() {
            return number;
        }

        public int getPrice() {
            return price;
        }
    }
}
