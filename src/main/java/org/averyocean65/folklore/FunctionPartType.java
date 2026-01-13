package org.averyocean65.folklore;

import org.averyocean65.folklore.functions.FunctionPart;

/**
 * Modulates the output of a {@link FunctionPart}<br>
 * {@link FunctionPartType#Default} leaves x unchanged.<br>
 * {@link FunctionPartType#Ln} turns x into {@code ln(x)}<br>
 * {@link FunctionPartType#Log} turns x into {@code log_a(x)} where {@code a} is {@link FunctionPart#addition()}<br>
 * {@link FunctionPartType#Sqrt} turns x into {@code sqrt(x)}<br>
 * {@link FunctionPartType#Root} turns x into {@code root_a(x)} where {@code a} is {@link FunctionPart#addition()}<br>
 * {@link FunctionPartType#xAsExp} turns x into {@code a^x} where {@code a} is {@link FunctionPart#addition()}<br>
 * {@link FunctionPartType#Sin} turns x into {@code sin(a*x)} where {@code a} is {@link FunctionPart#addition()}<br>
 * {@link FunctionPartType#Cos} turns x into {@code cos(a*x)} where {@code a} is {@link FunctionPart#addition()}<br>
 * {@link FunctionPartType#Tan} turns x into {@code tan(a*x)} where {@code a} is {@link FunctionPart#addition()}<br>
 * {@link FunctionPartType#ArcSin} turns x into {@code arcsin(a*x)} where {@code a} is {@link FunctionPart#addition()}<br>
 * {@link FunctionPartType#ArcCos} turns x into {@code arccos(a*x)} where {@code a} is {@link FunctionPart#addition()}<br>
 * {@link FunctionPartType#ArcTan} turns x into {@code arctan(a*x)} where {@code a} is {@link FunctionPart#addition()}<br>
*/
 public enum FunctionPartType {
    Default,
    Log,
    Ln,
    Root,
    Sqrt,
    xAsExp,
    Sin,
    Cos,
    Tan,
    ArcSin,
    ArcCos,
    ArcTan
}
