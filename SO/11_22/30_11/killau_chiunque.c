#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <wait.h>
#include <signal.h>


void sig_handler(int signo) {
    pid_t pid2;
    
    if(signal(SIGINT, SIG_IGN) == SIG_ERR) {
        printf("Errore nella signal()");
        exit(1);
    }

    pid2 = fork(); 


    if(pid2 < 0) exit(1);

    if(pid2 == 0) {
        char c;

        printf("L'esecuzione di mio padre deve continuare? s/n: ");
        scanf("%c", &c);
        if(c == 'n')
            kill(getppid(), SIGKILL);
        
        raise(SIGKILL);
    }
}

int fibonacci(int i) {
    if(i < 2) return i;

    return fibonacci(i - 1) + fibonacci(i - 2);
}

int main(void) {
    pid_t pid1;

    if(signal(SIGINT, SIG_IGN) == SIG_ERR) {
        printf("Errore nella signal()");
        exit(1);
    }

    pid1 = fork();

    if(pid1 < 0) exit(1);

    if(pid1 == 0) {
        if(signal(SIGINT,sig_handler) == SIG_ERR) {
            printf("Errore nella signal()");
            exit(1);
        }

        for(int i = 0; i < 45; i++) 
            printf("Fibonacci = %d\n", fibonacci(i));
    }
    else {
        printf("Mio figlio %d ha terminato\n", wait(NULL));
        exit(0);
    }

    return 0;
}