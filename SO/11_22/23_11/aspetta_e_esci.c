#include <stdio.h>
#include <wait.h>

int main (void) {
    pid_t pid;
    int status;
    
    // continuare
    if(pid == 0) {
        printf("figlio:syo per terminare\n");
        exit(0)
    }
    else {
        pid = wait(&status);
        printf("Termin il figlio con pid %d\n", pid);
        if((char) status == 0)
            printf("Terminazione volontri con stato %d\n", status >> 8);
        else {
            printf("Terminazione involontaria per segnale %d\n", (char) status);
        }
    }
}