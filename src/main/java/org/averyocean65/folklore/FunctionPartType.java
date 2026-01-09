package org.averyocean65.folklore;

/**
 * Modulates the output of a {@link FunctionPart}<br>
 * {@link FunctionPartType#Default} leaves x unchanged.<br>
 * {@link FunctionPartType#Ln} turns x into {@code ln(x)}<br>
 * {@link FunctionPartType#Log} turns x into {@code log_a(x)} where {@code a} is {@link FunctionPart#addition()}<br>
 * {@link FunctionPartType#Sqrt} turns x into {@code sqrt(x)}<br>
 * {@link FunctionPartType#Root} turns x into {@code root_a(x)} where {@code a} is {@link FunctionPart#addition()}<br>
 */
public enum FunctionPartType {
    Default,
    Log,
    Ln,
    Root,
    Sqrt
}
