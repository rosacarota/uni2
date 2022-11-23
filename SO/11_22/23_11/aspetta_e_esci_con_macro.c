#include <sys/wait.h>
#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

int main(void) {
    int pid, status;

    pid = fork();

    if (pid == 0) {
        printf("figlio: sto per terminare\n");
        exit(0);
    }
    else {
        pid = wait(&status);
        if (WIFEXITED(status))
            printf("Terminazione volontaria di %d con stato %d\n", pid, WEXITSTATUS(status));
        else if (WIFSIGNALED(status))
            printf("Terminazione involontaria per segnale %d\n", WTERMSIG(status));
    }
}