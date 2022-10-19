#include <stdio.h>
#include <unistd.h>

int main () {
    int value, value2;

    value = fork();

    if(value == 0) {
        putchar('\n');
        printf("Il valore di ritorno di fork del processo figlio: %d\n", value);
        putchar('\n');
    }
    else{
        putchar('\n');
        printf("Nel processo PADRE\n");
        printf("Il valore di ritorno di fork: %d\n", value);
        putchar('\n');
        printf("PID PADRE: %d\n", getppid());

    }

    //padre che crea un figlio, e poi sia il padre che il figlio stanno creando un altro figlio
    // devo controllare se la fork() funzioni o meno (se non vunziona restituisce -1)
   
    if (value > 0) {
        value2 = fork();
        if(value2 == 0) {
            putchar('\n');
            printf("Nel secondo processo FIGLIO\n");
            printf("Il valore di ritorno di fork: %d\n", value2);
            putchar('\n');

        }
        else{
            putchar('\n');
            printf("Nel processo PADRE\n");
            printf("Il valore di ritorno della seconda fork: %d\n", value2);
            putchar('\n');
    
        }
    }
}
