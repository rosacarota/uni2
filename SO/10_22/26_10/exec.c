#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>

int main() {
    printf("Sopra la panca\n");

    execl("/bin/echo", "echo", "la", "capra", "campa", NULL);

    printf("printf che non verrà stampata");
}
