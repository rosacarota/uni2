#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "DataBase.h"

int main(void) {
    while(!feof(stdin)) {
        char a; 

        printf("1.Inserisci canzone\n2.Cerca canzoni artista\n");
        printf("3.Modifica artista\n4.Cancella artista\n\n");
        printf("[Premi EOF per terminare]\n");
        
        scanf("%c", &a);
        getchar();

        char *nome_file;        char *nome;
        char *canzone;
        int valido;
                
        switch (a) {
            case '1':
 
                while (1) {
                    printf("\nInserisci il nome del file contenente il database canzoni: ");
                    nome_file = leggi_stringa();

                    if(strcmp(nome_file, "DataBase.txt") == 0) {
                        printf("File DataBase.txt loaded\n");
                        break;
                    }
                    else {
                        printf("Database non trovato\n");
                    }
                }

                while(1) {
                    printf("Inserisci il nome dell'artista: ");
                    nome = leggi_stringa;

                    valido = ricerca_artista(nome);

                    if(!valido)
                        pritnf("Artista non trovato\n");
                    else 
                        break;
                }   

                break;

            case '2':
               while(1) {
                    printf("\nInserisci il nome della canzone da inserire\n");
                    nome = leggi_stringa();
                    printf("Inserisci l'artista da associare alla canzone\n");
                    canzone = leggi_stringa();

                    valido = inserisci_canzone(nome, canzone);

                    if (!valido) 
                        printf("\nCanzone già presente nel database\n\n");
                    else if (valido) {
                        printf("\nCanzone inserita con successo\n\n");
                        break;
                    }
                    else {
                        printf("\nCanzone non inserita\n\n");
                        break;
                    }
                }
                break;

            case '3':
            break;

            case '4':
            break; 
            
        }
    }
    return 0;
}