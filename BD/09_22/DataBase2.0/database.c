#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "database.h"

Artista creaArtista(char *nome, char *genere, int gruppo, int anni) {
    Artista a;

    strcpy(a.nome, nome);
    strcpy(a.genere, genere);
    a.gruppo = gruppo;
    a.anni = anni;

    return a;
}

Canzone creaCanzone(Artista artista, char *titolo) {
    Canzone c;

    c.artista = artista;
    strcpy(c.titolo, titolo);
    
    return c;
}

int caricaFile(char *nomeFile) {
    FILE *fp;
    FILE *fd;
    
    if ((fp = fopen(nomeFile, "a")) == NULL)
        return -1;
    if ((fd = fopen("dettagliArtisti", "a")) == NULL)
        return -1;

    fclose(fp);
    fclose(fd);

    return 1;
}

int visualizzaCanzoni(char *nomeFile, char *nomeRicerca) {
    FILE *fp;
    char nomeArtistaLettura[LEN+1];
    char nomeCanzoneLettura[LEN+1];
    int trovate = 0;
    
    if ((fp = fopen(nomeFile, "r")) == NULL) return -1;
    
    while (!feof(fp)) {
        if ((fscanf(fp, "%s%s", nomeArtistaLettura, nomeCanzoneLettura)) != 2)
            break;

        if (strcmp(nomeRicerca, nomeArtistaLettura) == 0) {
            if (!trovate) printf("\n[Canzoni dell'artista \"%s\"]\n", nomeRicerca);
            trovate = 1;

            while (strcmp(nomeRicerca, nomeArtistaLettura) == 0) {
                printf("- %s\n", nomeCanzoneLettura);

                // Per evitare problemi nella lettura dell'ultimo artista
                if ((fscanf(fp, "%s%s", nomeArtistaLettura, nomeCanzoneLettura)) != 2) {
                    fclose(fp);
                    putchar('\n');
                    return 1;
                }

                // Ricerca completata
                if (strcmp(nomeRicerca, nomeArtistaLettura) != 0) {
                    fclose(fp);
                    putchar('\n');
                    return 1;
                }
            }
        }
    }
    
    fclose(fp);
    
    if (!trovate) return 0;

    putchar('\n');

    return 1;
}

static int inserisciDettagli(Artista artista) {
    FILE *fp;
    FILE *ftmp;
    Artista artistaLettura;
    int inserito = 0;
    
    if ((fp = fopen("dettagliArtisti", "r")) == NULL) return -1;
    if ((ftmp = fopen("tmp", "w")) == NULL) return -1;
    
    char c = fgetc(fp);
    if (c == EOF) {
        fprintf(ftmp, "%s\t %d\t %d\t %s\n", artista.nome, artista.gruppo,
                artista.anni, artista.genere);

        fclose(fp);
        fclose(ftmp);

        remove("dettagliArtisti");
        rename("tmp", "dettagliArtisti");

        return 1;
    }
    else rewind(fp);

    while (!feof(fp)) {
        if (fscanf(fp, "%s%d%d%s", artistaLettura.nome, &artistaLettura.gruppo,
                   &artistaLettura.anni, artistaLettura.genere) != 4)
            break;

        // Stesso nome artista
        if (strcmp(artista.nome ,artistaLettura.nome) == 0) {
            return 0;
        }
        // Il nome dell'artista da aggiungere è più piccolo di quello letto, inserisco quello da aggiungere
        else if (!inserito && strcmp(artista.nome, artistaLettura.nome) < 0) {
            inserito = 1;
            fprintf(ftmp, "%s\t %d\t %d\t %s\n", artista.nome, artista.gruppo,
                    artista.anni, artista.genere);
        }

        // Aggiungo dopo la canzone che ho letto dal file
        fprintf(ftmp, "%s\t %d\t %d\t %s\n", artistaLettura.nome, artistaLettura.gruppo,
                artistaLettura.anni, artistaLettura.genere);
    }
    
    if (!inserito)
        fprintf(ftmp, "%s\t %d\t %d\t %s\n", artista.nome, artista.gruppo,
                artista.anni, artista.genere);

    fclose(fp);
    fclose(ftmp);

    remove("dettagliArtisti");
    rename("tmp", "dettagliArtisti");
    
    return 1;
}

int inserisciCanzone(char *nomeFile, Canzone canzone) {
    FILE *fp;
    FILE *ftmp;
    char nomeArtistaLettura[LEN+1];
    char nomeCanzoneLettura[LEN+1];
    int inserito = 0;
    
    if ((fp = fopen(nomeFile, "r")) == NULL) return -1;
    if ((ftmp = fopen("tmp", "w")) == NULL) return -1;
    
    // Se devo inserire la prima canzone
    char c = fgetc(fp);
    if (c == EOF) {
        fprintf(ftmp, "%s\t %s\n", canzone.artista.nome, canzone.titolo);

        fclose(fp);
        fclose(ftmp);

        remove(nomeFile);
        rename("tmp", nomeFile);

        if (inserisciDettagli(canzone.artista) < 1) {
            printf("\n[Artista non aggiunto]\n");
            return -1;
        }
        else
            printf("\n[Artista aggiunto]\n");

        return 1;
    }
    else rewind(fp);

    while (!feof(fp)) {
        if ((fscanf(fp, "%s%s", nomeArtistaLettura, nomeCanzoneLettura)) != 2)
            break;

        // Stesso nome artista
        if (!inserito && strcmp(canzone.artista.nome ,nomeArtistaLettura) == 0) {
            // Canzone già esistente
            if (strcmp(canzone.titolo, nomeCanzoneLettura) == 0)
                return 0;
            // Canzone da aggiungere più piccola di quella letta, inserisco quella da aggiungere
            else if (strcmp(canzone.titolo, nomeCanzoneLettura) < 0) {
                inserito = 1;
                fprintf(ftmp, "%s\t %s\n", canzone.artista.nome, canzone.titolo);
            }
        }
        // Il nome dell'artista da aggiungere è più piccolo di quello letto, inserisco quello da aggiungere
        else if (!inserito && strcmp(canzone.artista.nome, nomeArtistaLettura) < 0) {
            inserito = 1;
            fprintf(ftmp, "%s\t %s\n", canzone.artista.nome, canzone.titolo);
        }

        // Aggiungo dopo la canzone che ho letto dal file
        fprintf(ftmp, "%s\t %s\n", nomeArtistaLettura, nomeCanzoneLettura);
    }
    
    if (!inserito) 
        fprintf(ftmp, "%s\t %s\n", canzone.artista.nome, canzone.titolo);

    fclose(fp);
    fclose(ftmp);

    remove(nomeFile);
    rename("tmp", nomeFile);
    
    inserisciDettagli(canzone.artista);
    
    return 1;
}

int modificaNome(char *nomeFile, char *nomeVecchio, Artista artista) {
    FILE *fp;
    FILE *ftmp;
    char nomeArtistaLettura[LEN+1];
    char nomeCanzoneLettura[LEN+1];
    int trovato = 0;

    if ((fp = fopen(nomeFile, "r")) == NULL) return -1;
    if ((ftmp = fopen("tmp2", "w")) == NULL) return -1;
    
    while (!feof(fp)) {
        if ((fscanf(fp, "%s%s", nomeArtistaLettura, nomeCanzoneLettura)) != 2)
            break;

        if (strcmp(nomeVecchio, nomeArtistaLettura) == 0) {
            trovato = 1;
            fprintf(ftmp, "%s\t %s\n", artista.nome, nomeCanzoneLettura);
        }
    }

    fclose(fp);
    fclose(ftmp);
    
    if (trovato) 
        cancellaArtista(nomeFile, nomeVecchio);
    else {
        remove("tmp2");
        return 0;
    }
    
    if ((ftmp = fopen("tmp2", "r")) == NULL) return -1;
    
    Canzone canzone;
    canzone.artista = artista;

    while (!feof(ftmp)) {
        if ((fscanf(ftmp, "%s%s", nomeArtistaLettura, nomeCanzoneLettura)) != 2)
            break;

        strcpy(canzone.titolo, nomeCanzoneLettura);
        inserisciCanzone(nomeFile, canzone);
    }
    
    fclose(ftmp);
    remove("tmp2");

    return 1;
}

static int cancellaDettagli(char *nomeRimozione) {
    FILE *fp;
    FILE *ftmp;
    Artista artistaLettura;
    
    if ((fp = fopen("dettagliArtisti", "r")) == NULL) return -1;
    if ((ftmp = fopen("tmp", "w")) == NULL) return -1;

    while (!feof(fp)) {
        if (fscanf(fp, "%s%d%d%s", artistaLettura.nome, &artistaLettura.gruppo,
                   &artistaLettura.anni, artistaLettura.genere) != 4)
            break;

        if (strcmp(nomeRimozione, artistaLettura.nome) != 0) {
            fprintf(ftmp, "%s\t %d\t %d\t %s\n", artistaLettura.nome, artistaLettura.gruppo,
                    artistaLettura.anni, artistaLettura.genere);
        }
    }

    fclose(fp);
    fclose(ftmp);

    remove("dettagliArtisti");
    rename("tmp", "dettagliArtisti");
    
    return 1;
}

int cancellaArtista(char *nomeFile, char *nomeRimozione) {
    FILE *fp;
    FILE *ftmp;
    char nomeArtistaLettura[LEN+1];
    char nomeCanzoneLettura[LEN+1];
    int trovato = 0;

    if ((fp = fopen(nomeFile, "r")) == NULL) return -1;
    if ((ftmp = fopen("tmp", "w")) == NULL) return -1;

    while (!feof(fp)) {
        if ((fscanf(fp, "%s%s", nomeArtistaLettura, nomeCanzoneLettura)) != 2)
            break;

        if (strcmp(nomeRimozione, nomeArtistaLettura) == 0) {
            if (!trovato) printf("\n[Canzoni modificate]\n");
            trovato = 1;
            printf("- %s\n", nomeCanzoneLettura);
        }
        else
            fprintf(ftmp, "%s\t %s\n", nomeArtistaLettura, nomeCanzoneLettura);
    }

    fclose(fp);
    fclose(ftmp);

    remove(nomeFile);
    rename("tmp", nomeFile);

    cancellaDettagli(nomeRimozione);
    
    return trovato;
}

int query(char *nomeFile) {
    FILE *fp;
    FILE *fd;
    Canzone canzoneLettura;
    char nomeArtistaDettagli[LEN+1];
    int trovate = 0;
    int ultimo = 0;
    
    if ((fp = fopen(nomeFile, "r")) == NULL) return -1;
    if ((fd = fopen("dettagliArtisti", "r")) == NULL) return -1;
    
        
    while (!feof(fd)) {
        if (fscanf(fd, "%s%d%d%s", nomeArtistaDettagli, &canzoneLettura.artista.gruppo,
                   &canzoneLettura.artista.anni, canzoneLettura.artista.genere) != 4)
            break;
                
        if (!ultimo)
            if ((fscanf(fp, "%s%s", canzoneLettura.artista.nome, canzoneLettura.titolo)) != 2)
                break;

        ultimo = 0;

        while ((strcmp(nomeArtistaDettagli, canzoneLettura.artista.nome)) == 0) {
            if ((canzoneLettura.artista.gruppo == 0 && canzoneLettura.artista.anni < 30) || 
                (canzoneLettura.artista.gruppo == 1 && canzoneLettura.artista.anni < 5)) {
                if (!trovate) printf("\n[Canzoni trovate]\n");
                trovate = 1;
                printf("- %s\n", canzoneLettura.titolo);
            }
            
            ultimo = 1;

            if ((fscanf(fp, "%s%s", canzoneLettura.artista.nome, canzoneLettura.titolo)) != 2)
                break;
        }
    }
    
    fclose(fp);
    fclose(fd);
    
    if (!trovate) return 0;

    putchar('\n');

    return 1;
}