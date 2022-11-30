#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

int main(void) {
    pid_t value1, value2;
    int controllo1, controllo2;

    value1 = fork(); //creo il primo processo figlio
    if(value1 < 0) exit(1); // controllo che la fork() non abbia
                            // dato errori

    if(value1 == 0)  {
        printf("Il mio PID %d", getpid()); // stampo il pid del primo figlio
        for(int i = 1; i <= 50; i++) { // stampo i numero da 1 a 50
            printf("%d ", i);
        }
        putchar('\n');
        exit(1); // termino il primo figlio
    }
    else if(value1 > 0) { // nel caso invece sia il padre 
        value2 = fork(); //  creo il secondo figlio
        if(value2 < 0) exit(1); // controllo che la fork() non abbia dato errori
        if(value2 == 0) { // secondo figlio 
            printf("Il PID di mio padre %d\n", getppid()); // stampo il PID del padre
            // Aggiunta del controllo per execlp()
            if((execlp("ls", "ls", NULL)) == -1) exit(1);  // eseguo il comando ls
        }
        else {
            // controllo che la wait non abbia dato errori in entrambi i casi
            controllo1 = waitpid(value1, NULL, 0);
            if(controllo1 <= 0) printf("ERRORE in wait");
            
            controllo2 = waitpid(value2, NULL, 0);
            if(controllo2 <= 0) printf("ERRORE in wait");

            // stampo i PID dei 2 figli terminati e termino
            // e termino l'esecuzione del padre
            printf("Primo figlio %d terminato", controllo1);
            printf("Secondo figlio %d terminato", controllo2);
            exit(1);
        }
    }
} // Aggiunta di questa parentesi