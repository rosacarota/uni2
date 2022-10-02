#include <stdio.h>
#include <string.h>
#include "util.h"

int main(void) {
    char nomeFile[LEN+1];
    
    printf("- Inserire il nome del file da caricare: ");
    leggiStringa(nomeFile, LEN+1);

    if (caricaFile(nomeFile) < 0) {
        printf("\n[Impossibile caricare il file]\n");
        return -1;
    }
    
    printf("\n[File <%s> caricato]\n\n", nomeFile);
    
    char nomeRicerca[LEN+1];
    char nomeVecchio[LEN+1];
    char nomeRimozione[LEN+1];
    Canzone canzone;
    Artista artista;
    int eseguito;
    char c;
    
    do {
        printf("0. Esci dal programma\n1. Visualizza canzoni artista\n2. Inserisci canzone\n");
        printf("3. Modifica nome artista\n4. Cancella canzoni artista\n");
        printf("5. Visualizza canzoni di artisti autonomi con meno di 30 anni\n");
        printf("   oppure visualizza canzoni di gruppi costituiti da meno di 5 anni\n");
        printf("\nSelezione: ");
        scanf("%c", &c);
        getchar();

        switch(c) {
            case '0': break;
            
            case '1':
                printf("\n- Inserire il nome dell'artista di cui cercare le canzoni: ");
                leggiStringa(nomeRicerca, LEN+1);

                eseguito = visualizzaCanzoni(nomeFile, nomeRicerca);

                if (eseguito == 0)
                    printf("\n[Nessuna canzone dell'artista \"%s\" trovata]\n\n", nomeRicerca);
                else if (eseguito < 0)
                    printf("\nIl file non può essere aperto\n\n");

                break;
            
            case '2':
                canzone = canzoneInput();

                eseguito = inserisciCanzone(nomeFile, canzone);

                if (eseguito)
                    printf("\n[Canzone \"%s\" inserita con successo]\n\n", canzone.titolo);
                else if (eseguito == 0)
                    printf("\n[Canzone già esistente]\n\n");
                else if (eseguito < 0)
                    printf("\n[Il file non può essere aperto]\n\n");

                break;
            
            case '3':
                printf("\n- Inserire il nome dell'artista da modificare: ");
                leggiStringa(nomeVecchio, LEN+1);

                artista = artistaInput();
                
                eseguito = modificaNome(nomeFile, nomeVecchio, artista);

                if (eseguito)
                    printf("\n[Operazione eseguita]\n\n");
                else if (eseguito == 0)
                    printf("\n[Artista non trovato]\n\n");
                else if (eseguito < 0)
                    printf("\n[Il file non può essere aperto]\n\n");

                break;
                
            case '4':
                printf("\n- Inserire il nome dell'artista da rimuovere: ");
                leggiStringa(nomeRimozione, LEN+1);
                
                eseguito = cancellaArtista(nomeFile, nomeRimozione);

                if (eseguito)
                    printf("\n[Operazione eseguita]\n\n");
                else if (eseguito == 0)
                    printf("\n[Artista non trovato]\n\n");
                else if (eseguito < 0)
                    printf("\n[Il file non può essere aperto]\n\n");

                break;
            
            case '5':
                eseguito = query(nomeFile);

                if (eseguito == 0)
                    printf("\n[Nessuna canzone trovata]\n\n");
                else if (eseguito < 0)
                    printf("\nIl file non può essere aperto\n\n");

                break;

            default: printf("\n[Carattere non valido]\n\n");
        }

    } while (c != '0');

    return 0;
}