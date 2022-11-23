#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

int main(void) {
    pid_t value1, value2;
    int controllo1, controllo2;

    value1 = fork();
    if(value1 < 0) exit(1);

    if(value1 == 0)  {
        printf("Il mio PID %d", getpid());
        for(int i = 1; i <= 50; i++) {
            printf("%d ", i);
        }
        putchar('\n');
        exit(1);
    }
    else if(value1 > 0) {
        value2 = fork();
        if(value2 < 0) exit(1);
        if(value2 == 0) {
            printf("Il PID di mio padre %d\n", getppid());
            execlp("ls", "ls", NULL);
        }
        else {
            controllo1 = waitpid(value1, NULL, 0);
            if(controllo1 <= 0) printf("ERROE in wait");
            controllo2 = waitpid(value2, NULL, 0);
            if(controllo2 <= 0) printf("ERRORE in wait");
            printf("Primo figlio %d terminato", controllo1);
            printf("Secondo figlio %d terminato", controllo2);
            exit(1);
        }
    }
}