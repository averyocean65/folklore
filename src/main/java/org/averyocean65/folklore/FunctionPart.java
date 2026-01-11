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
       }

       // a^0 = 1
       if(Misc.areDoublesEqual(exponent, 0)) {
           return amplification + addition;
       }

       // a^1 = a
       if(Misc.areDoublesEqual(exponent, 1)) {
           return amplification * (x + xShift) + addition;
       }

       return amplification * Math.pow(x + xShift, exponent) + actualAddition;
   }
}
