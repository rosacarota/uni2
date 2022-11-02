#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int main(void) {
    char comando[50];
    pid_t pid;

    do {
        printf("%% ");
        scanf("%s", comando);

        pid = fork();
        if (pid < 0) exit(1);
        
        if (pid > 0) {
           wait(NULL);
            
        }
        else if (pid == 0) {
            execlp(comando, comando, NULL);
        }

    } while (1);
}
