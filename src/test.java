import java.util.Scanner;

public class test {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double StartX = sc.nextDouble();
        double StartY = sc.nextDouble();
        double EndX =  sc.nextDouble();
        double EndY = sc.nextDouble();
        double CirclecenterX = sc.nextDouble();
        double CirclecenterY = sc.nextDouble();
        double CircleRadius = sc.nextDouble();
        boolean IsIntersection = false;
        boolean IsIn = false;

        double Inclination = 0.0;
        double Y_Intercept = 0.0;
        if(StartX-EndX==0){
            if(Math.abs(StartX-CirclecenterX)<CircleRadius)
                IsIn=true;
        }
        else{
            Inclination = (StartY-EndY)/(StartX-EndX);
            Y_Intercept = -(Inclination*StartX)+StartY;
        }

        if(coordDistance(StartX,StartY,CirclecenterX,CirclecenterY)<CircleRadius||
                coordDistance(EndX,EndY,CirclecenterX,CirclecenterY)<CircleRadius){
            IsIntersection=true;
        }
        else{
            if(Math.abs(Inclination*CirclecenterX-CirclecenterY+Y_Intercept)<CircleRadius||IsIn==true){
                Vector2D vectorFromCircletoLine1 = new Vector2D(StartX-CirclecenterX,StartY-CirclecenterY);
                Vector2D vectorFromCircletoLine2 = new Vector2D(EndX-CirclecenterX,EndY-CirclecenterY);
                Vector2D vectorLine1 = new Vector2D(EndX-StartX,EndY-StartY);
                Vector2D vectorLine2 = new Vector2D(StartX-EndX,StartY-EndY);
                System.out.println(vectorFromCircletoLine1.x +" / "+vectorFromCircletoLine1.y+" / "+vectorLine1.x+" / "+vectorLine1.y);
                System.out.println((180/Math.PI)*Math.acos(vectorFromCircletoLine1.dot(vectorLine1)/(vectorFromCircletoLine1.getLength()*vectorLine1.getLength())));
                System.out.println((180/Math.PI)*Math.acos(vectorFromCircletoLine2.dot(vectorLine2)/(vectorFromCircletoLine2.getLength()*vectorLine2.getLength())));
                IsIntersection= (180 / Math.PI) * Math.acos(vectorFromCircletoLine1.dot(vectorLine1) / (vectorFromCircletoLine1.getLength() * vectorLine1.getLength())) >= 90 &&
                        (180 / Math.PI) * Math.acos(vectorFromCircletoLine2.dot(vectorLine2) / (vectorFromCircletoLine2.getLength() * vectorLine2.getLength())) >= 90;
            }
            else IsIntersection=false;
        }
        System.out.println(IsIntersection);
    }
    public static double coordDistance(double StartX, double StartY, double EndX, double EndY){
        return Math.sqrt(Math.pow(StartX-EndX,2)+Math.pow(StartY-EndY,2));
    }
}

