#include <stdio.h>
#include <unistd.h>
#include <signal.h>
#include <stdlib.h>
#include <wait.h>

int fattoriale(int i) {
    if(i == 0) return 1;

    return fattoriale(i - 1) * i;
}

int fibonacci(int i) {
    if(i < 2) return i;

    return fibonacci(i - 1) + fibonacci(i - 2);
}

void sig_usr1(int signo) {
    if(signo == SIGINT)
        printf("IL MIO PID %d\n", getpid());
    else 
        return;
}

void sig_usr2(int signo) {
    char c; 

    if(signo == SIGINT) {
        printf("Vuoi continuare l'esecuzione? s/n");
        scanf("%c", &c);

        if(c == 's')
            return;
        else
            exit(1);
    }
}

int main(void) {
    pid_t pid1, pid2;
    
    if(signal(SIGINT, SIG_IGN) == SIG_ERR) {
        printf("Errore nella signal()\n");
        exit(1);
    }
 
    setbuf(stdout, NULL);

    pid1 = fork();
    if(pid1 < 0) exit(1);

    if (pid1 == 0) {
        if(signal(SIGINT, sig_usr1) == SIG_ERR) {
            printf("Errore nella signal()\n");
            exit(1);
        }

        for(int i = 0; i < 40; i++) {
            printf("Fibonacci = %d ", fibonacci(i));
        }

        exit(0);
    }
    else if(pid1 > 0) {
        pid2 = fork();
        if(pid2 < 0) exit(1);

        if(pid2 == 0) { 
            if(signal(SIGINT, sig_usr2) == SIG_ERR) {
                printf("Errori nella signal()\n");
                exit(1);
            }

            for(int i = 0; i < 30; i++) 
                printf("Fattoriale = %d ", fattoriale(i));
            
            exit(0);
        }
        else {
           
            printf("\nTerminato il primo figlio %d\n", waitpid(pid1, NULL, 0));
            printf("Terminato il secondo figlio %d\n", waitpid(pid2, NULL, 0));

            exit(0);
        }
    }
    return 0;
} 