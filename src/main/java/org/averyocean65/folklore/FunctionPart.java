package org.averyocean65.folklore;

public record FunctionPart(
        double amplification,
        double exponent,
        double xShift,
        double addition,
        Operator operatorToNext,
        FunctionPartType type
) {
   double sampleOwnValue(double x) {
       double actualAddition = addition;
       switch(type) {
           case Default -> { }
           case Log -> {
               x = Misc.Log(x, addition);
               actualAddition = 0;
           }
           case Ln -> {
               x = Math.log(x);
           }
           case Root -> {
               x = Misc.Root(x, addition);
               actualAddition = 0;
           }
           case Sqrt -> {
               x = Misc.Root(x, 2);
           }
           case xAsExp -> {
               x = Math.pow(addition, x);
               actualAddition = 0;
           }

           case Sin -> {
               x = Math.sin(addition * x);
               actualAddition = 0;
           }
           case Cos -> {
               x = Math.cos(addition * x);
               actualAddition = 0;
           }
           case Tan -> {
               x = Math.tan(addition * x);
               actualAddition = 0;
           }
           case ArcSin -> {
               x = Math.asin(addition * x);
               actualAddition = 0;
           }
           case ArcCos -> {
               x = Math.acos(addition * x);
               actualAddition = 0;
           }
           case ArcTan -> {
               x = Math.atan(addition * x);
               actualAddition = 0;
           }
       }

       // a^0 = 1
       if(Misc.areDoublesEqual(exponent, 0)) {
           return amplification + actualAddition;
       }

       // a^1 = a
       if(Misc.areDoublesEqual(exponent, 1)) {
           return amplification * (x + xShift) + actualAddition;
       }

       return amplification * Math.pow(x + xShift, exponent) + actualAddition;
   }
}
