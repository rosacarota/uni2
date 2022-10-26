#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>

int main(void) {
    pid_t value1, value2;

   value1 = fork(); 

    if (value1 < 0) exit(0);

    if (value1 == 0) {
        printf("PID primo figlio: %d\n", getpid());

        for(int i = 1; i <= 50; i++) {
            printf("%d ", i);
        }
        putchar('\n');

        exit(0);
    }
    else if (value1 > 0) {
        value2 = fork();
        
        if (value2 < 0) exit(0);

        if (value2 == 0) {
            printf("PID padre dal secondo figlio: %d\n", getppid());

            for(int i = 101; i <= 150; i++) {
                printf("%d ", i);
            }
            putchar('\n');

            exit(0);
        }
        else if (value2 > 0) {
            printf("PID primo figlio terminato dal padre: %d\n", waitpid(value1, NULL, 0));
            printf("PID secondo figlio terminato dal padre: %d\n", waitpid(value2, NULL, 0));
        }
    }

    return 0;
}
