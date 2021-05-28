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
                return (o1.getPrice()!=o2.getPrice())? o1.getPrice()-o2.getPrice(): o1.getNumber()-o2.getNumber();
            }
            //price 오름차순, 같다면 index로 오름차순
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
        //가장 싼 숫자가 0이 아닌 경우
        if(eachPrice[0].getNumber()!=0){
            int pay=0;
            while((pay+=eachPrice[0].getPrice())<=money){ //해당 숫자로 다 채웠을 때 나오는 자리수가 최종 자릿수
                digit++;
            }
        }
        else{// 가장 싼 숫자가 0인 경우
            int pay = eachPrice[1].getPrice(); //두번째로 싼 숫자로 최대 자리수의 숫자를 채우고
            digit = 1;
            while((pay+=eachPrice[0].getPrice())<=money){
                digit++;
            }//나머지는 다 가장 싼 숫자인 0으로 채웠을때 나오는 자리수가 최종 자리수
        }
        return digit;
    }

    public static String getMaxRoomNumber(int digit){
        StringBuilder max = new StringBuilder();
        for(int i=0;i<digit;i++) max.append(numOfNumber-1); //index가 가장 큰 수로만 이루어진 수
        int count = digit*eachPriceSortByIndex[numOfNumber-1].getPrice(); //가장 큰 수로만 이루어진 가격
        int maxNumIndex = 0; //가격순 정렬에서 index가 최대인것 찾기 (가격을 낮추기 위해서)
        for(int i=0;i<numOfNumber;i++){
            if(numOfNumber-1==eachPrice[i].getNumber()) {
                maxNumIndex=i; //가격 순 정렬로 정렬했을 때, 숫자의 크기가 가장 큰 index를 받아오기
                break;
            }
        }

        //하나씩 비교하며 가격 낮추기
        for(int i=0;i<digit;i++){ //모든 자리수를 돌며 진행
            for(int j=maxNumIndex;j>0;j--){
                if(count<=money) return max.toString();
                // 가격이 같다면, index순으로 오름차순 정렬 했기 때문에 바꾸지 않고 지나간다.
                if(eachPrice[j].getPrice()==eachPrice[j-1].getPrice()||(i==digit-1&&eachPrice[j-1].getNumber()==0)) continue;
                // max를 만드는 가격이 가지고 있는 돈보다 더 높다면, 수를 바꾸고
                max.replace(digit-i-1,digit-i,Integer.toString(eachPrice[j-1].getNumber()));
                count-=eachPrice[j].getPrice()-eachPrice[j-1].getPrice();
                //바뀌기 전 숫자의 가격에서 바꾼 숫자의 가격의 차를 max를 만드는 가격에서 빼준다 -> 변경했으니까
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
