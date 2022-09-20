#include <stdio.h>
#include <stdlib.h>

int main(void) {
    while(!feof(stdin)) {
        char a; 

        printf("")
    }
    return 0;
}

int inserisci_artista(char *canzone_new, char *artista_new) {
    FILE *f_in;
    FILE *f_tmp;

    if(!(f_in = fopen("database.txt", "r"))){
        printf("Il file non può essere aperto");
        return 0;
    }
    else {
        if(f)
    }
}
