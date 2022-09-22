#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "DataBase.h"

int main(void) {
    FILE *fp;

    char nome_file[30];
    printf("Inserisci il nome del file contenente il database canzoni: ");
    leggi_stringa(nome_file, 30);
    
    if((fp = fopen(nome_file, "r")) == NULL) {
        if((fp = fopen(nome_file, "a")) == NULL) {
            printf("\n[File %s non caricato]\n\n", nome_file);
            return -1;
        }
        else{ 
            printf("\n[File %s caricato]\n\n", nome_file);
            fclose(fp);
        }
    }
    else {
        printf("\n[File %s caricato]\n\n", nome_file);
        fclose(fp);
    }
             
    while(!feof(stdin)) {
        char a; 

        printf("1.Cerca canzoni artista\n2.Inserisci canzone\n");
        printf("3.Modifica artista\n4.Cancella artista\n\n");
        printf("[Premi EOF per terminare]\n");
        
        scanf("%c", &a);
        getchar();

        char nome[30];
        char nome_new[30];
        char canzone[30];
        int valido;
        
               
        switch (a) {
            case '1':               
                while(1) {
                    printf("Inserisci il nome dell'artista: ");
                    leggi_stringa(nome, 30);

                    valido = ricerca_artista(nome, nome_file);

                    if(valido == 0)
                        printf("\nArtista non trovato\n\n");
                    else if (valido == 1) 
                        break;
                    else if (valido == -1)
                        printf("\nProblemi con il caricamento del database.\n\n");
                }   

                break;

            case '2':
               while(1) {
                    printf("\nInserisci l'artista da inserire: ");
                    leggi_stringa(nome, 30);
                    printf("Inserisci canzoni dell'artista: ");
                    leggi_stringa(canzone, 30);

                    valido = inserisci_canzone(nome, canzone, nome_file);

                    if (valido == 0) 
                        printf("\nCanzone già presente nel database\n\n");
                    else if (valido == 1) {
                        printf("\nCanzone %s inserita con successo\n\n", canzone);
                        break;
                    }
                    else if (valido == -1){
                        printf("\nProblemi con il caricamento del DataBase.\n");
                        printf("Canzone non inserita");

                    }
                }
                break;

            case '3':
                printf("\nInserisci il nome dell'artista da modificare: ");
                leggi_stringa(nome, 30);
                printf("Inserisci il nuovo nome dell'artista: ");
                leggi_stringa(nome_new, 30);
                
                valido = modifica_artista(nome, nome_new, nome_file);

                if (valido == 0)
                    printf("\nArtista non trovato\n\n");
                else if (valido == 1){
                    break;
                }
                else if (valido == -1){
                    printf("\nProblemi con il carimento del database\n");
                    printf("\nArtista non modificato\n");
                }

                break;

            case '4':
                printf("Inserisci il nome dell'artista da cancellare: ");
                leggi_stringa(nome, 30);

                valido = cancella_artista(nome, nome_file);
                
                if (valido == 0) 
                    printf("\nArtista non trovato\n\n");
                else if (valido == 1)
                    break;
                else if (valido == -1){
                    printf("\nProblemi con il caricamento del database\n");
                    printf("\nArtista non modificato\n");
                }
                break; 
            
        }
    }
    return 0;
}