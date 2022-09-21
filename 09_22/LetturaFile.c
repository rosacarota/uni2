#include <stdio.h>
#include <stdlib.h>

int main(void) {
    char matricola[4];
    char nome[50];
    double media_voti;

    FILE *f;

    if((f = fopen("studenti.txt", "r")) == NULL) {
        printf("Il file non può essere aperto\n");
        exit(-1);
    }
    printf("%s\t %s\t %s \n", "Matricola", "Nome", "Media_Voti");

    while(!feof(f)) {
        fscanf(f, "%s\t%s\t%lf\n", matricola, nome, &media_voti);
        printf("%s\t %s\t %.2lf\n", matricola, nome, media_voti);
    }

    fclose(f);

    return 0;
    
}