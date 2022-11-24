#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>

int fibonacci(int i) {
    if(i < 2) return i;

    return fibonacci(i - 1) + fibonacci(i - 2);
}

void sig_usr(int signo) {
    char c;

    if(signo == SIGINT) {
        printf("Vuoi continuare l'esecuzione?");
        scanf("%c ",&c);
        if(c == 's')
            return;
        else
            exit(0);
    }

}
int main(void) {
    signal(SIGINT, sig_usr);

    for(int i = 0; i <= 4000; i++){
        printf("%d ", fibonacci(i));
    }

    putchar('\n');

}