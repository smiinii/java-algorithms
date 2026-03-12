#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int num1, int num2) {
    double divisionResult = (double) num1 / (double) num2; 
    double result = divisionResult * 1000;
    return (int) result;
}