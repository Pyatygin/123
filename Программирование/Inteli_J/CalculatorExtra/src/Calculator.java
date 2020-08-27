import java.math.BigInteger;

public  class Calculator {

    public  double summing(double a,double b){
        return a+b;
    }

    public double raznosting(double a,double b){
        return a-b;
    }

    public double multing(double a,double b){
        return a*b;
    }

    public double spliting(double a,double b){
        return a/b;
    }

    public BigInteger factorialing(double a){
        BigInteger resultFact = BigInteger.valueOf(1);
        for (int i = 2; i <= a; i++) {
            resultFact = resultFact.multiply(BigInteger.valueOf(i));
        }
        return resultFact;
    }

    public double degreeting(double a, double b){
        long resultDegree=1;
        for (int i = 0; i < b; i++) {
            resultDegree*=a;
        }
        return resultDegree;
    }

    public double parceing(double a,double b){
        double resultParcent = a*b/100;
        return resultParcent;
    }

}
