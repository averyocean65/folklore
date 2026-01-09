package org.averyocean65.folklore;

public record FunctionPart(
        float amplification,
        float exponent,
        float xShift,
        float addition,
        Operator operatorToNext,
        FunctionPartType type
) {
   float sampleOwnValue(float x) {
       float actualAddition = addition;
       switch(type) {
           case Log -> {
               x = Misc.Log(x, addition);
               actualAddition = 0;
           }
           case Ln -> {
               x = (float)Math.log(x);
           }
           case Root -> {
               x = Misc.Root(x, addition);
               actualAddition = 0;
           }
           case Sqrt -> {
               x = Misc.Root(x, 2);
           }
       }

       // a^0 = 1
       if(Misc.areFloatsEqual(exponent, 0)) {
           return amplification + addition;
       }

       // a^1 = a
       if(Misc.areFloatsEqual(exponent, 1)) {
           return amplification * (x + xShift) + addition;
       }

       return amplification * (float)Math.pow(x + xShift, exponent) + actualAddition;
   }
}
