#include <stdio.h>
#include <unistd.h>

int main () {
    pid_t value;

    value = fork();

    if(value == 0) {
        putchar('\n');
        printf("Nel processo FIGLIO\n");
        printf("Il valore di ritorno di fork: %d\n", value);
        putchar('\n');

    }
    else{
        putchar('\n');
        printf("Nel processo PADRE\n");
        printf("Il valore di ritorno di fork: %d\n", value);
        putchar('\n');

    }
}
