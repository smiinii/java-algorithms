#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int n, int k) {
    int drink = k - (n / 10);
    return (12000 * n) + (2000 * drink);
}