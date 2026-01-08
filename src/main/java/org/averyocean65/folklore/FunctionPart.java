package org.averyocean65.folklore;

public record FunctionPart(
        float amplification,
        float exponent,
        float xShift,
        float addition,
        Operator operatorToNext
) {
   float sampleOwnValue(float x) {
       // a^0 = 1
       if(Misc.areFloatsEqual(exponent, 0)) {
           return amplification + addition;
       }

       // a^1 = a
       if(Misc.areFloatsEqual(exponent, 1)) {
           return amplification * (x + xShift) + addition;
       }

       return amplification * (float)Math.pow(x + xShift, exponent) + addition;
   }
}
