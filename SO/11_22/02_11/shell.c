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
        
        if (pid == 0) {
            if (execlp(comando, comando, NULL) == -1) 
                exit(1);
        }
        else if (pid > 0) 
            wait(NULL);

    } while (1);
}
