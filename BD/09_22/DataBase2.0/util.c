#include <stdio.h>
#include "util.h"

void leggiStringa(char *str, int buff) {
    int i = 0, ch;

    while ((ch = getchar()) != '\n')
        if (i < buff)
            str[i++] = ch;

    str[i] = '\0';
}

Artista artistaInput(void) {
    char nomeArtista[LEN+1];
    char genere[LEN+1];
    int gruppo;
    int anni;

    printf("\n- Inserire il nome dell'artista: ");
    leggiStringa(nomeArtista, LEN + 1);
    printf("- Inserire il genere principale dell'artista: ");
    leggiStringa(genere, LEN + 1);

    printf("- L'artista è in un gruppo? (1: sì, 0: no): ");
    scanf("%d", &gruppo);
    printf("- Inserire l'età dell'artista: ");
    scanf("%d", &anni);
    getchar();
    
    return creaArtista(nomeArtista, genere, gruppo, anni);
}

Canzone canzoneInput(void) {
    char titolo[LEN+1];

    Artista artista = artistaInput();

    printf("- Inserisci il titolo della canzone: ");
    leggiStringa(titolo, LEN + 1);

    return creaCanzone(artista, titolo);
}