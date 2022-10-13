#include <stdio.h>
#include <unistd.h>


int main () {
    int value, value2;

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

    //padre che crea un figlio, e poi sia il padre che il figlio stanno creando un altro figlio

    value2 = fork();
    
     if(value2 == 0) {
        putchar('\n');
        printf("Nel processo FIGLIO\n");
        printf("Il valore di ritorno di fork: %d\n", value2);
        putchar('\n');

    }
    else{
        putchar('\n');
        printf("Nel processo PADRE\n");
        printf("Il valore di ritorno di fork: %d\n", value2);
        putchar('\n');

    }

    
}
