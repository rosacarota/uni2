#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>

int fibonacci(int n) {
    if(n <= 1) return n;

    return fibonacci(n-1) + fibonacci(n-2);
}

int fattoriale(int n) {
    if (n <= 1) return 1;

    return n * fattoriale(n - 1);
    
}

int main(void) {
    pid_t value;

    value = fork();

    if (value < 0) exit(-1);
    
    if(value == 0) {
        for(int i = 0; i < 10; i++) {
           printf("%d ", fibonacci(i));
        }
        putchar('\n');
    }
    else if(value > 0) {
        for (int i = 0; i < 10; i++) {
            printf("%d ", fattoriale(i));
        }
        putchar('\n');
    }

    return 0;
}
