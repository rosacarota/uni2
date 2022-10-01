#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "DataBase.h"

void leggi_stringa(char *str, int buff) {

    fgets(str, buff, stdin);
    if(str[strlen(str) - 1] == '\n') {
        str[strlen(str) - 1] = '\0';
    }
}
/*
int inserisci_canzone(char *nome_new, char *canzone_new, char *nome_file) {
    FILE *f_in;
    
    if(!(f_in = fopen(nome_file, "r"))) {
        // se non lo apre in lettura deve creare il nuovo file di testo
        if((f_in = fopen(nome_file, "w")) == NULL)
            return -1;
        else{
        fprintf(f_in,"%s\t %s\n", nome_new, canzone_new);

        fclose(f_in);

        return 1;
        }
    }
   else {
        char nome_tmp[30];
        char canzone_tmp[30];

        while (!feof(f_in)) {
            fscanf(f_in,"%s%s", nome_tmp, canzone_tmp);
            if ((strcmp(nome_tmp, nome_new) == 0) && (strcmp(canzone_tmp, canzone_new) == 0)) {
                fclose(f_in);
                return 0;
            }
        }

        FILE *f_app;

        if ((f_app = fopen(nome_file, "a")) == NULL)
            return -1;
        else{
        fprintf(f_app, "%s\t %s\n", nome_new, canzone_new);

        fclose(f_app);
        fclose(f_in);

        return 1;
        }
    }
}
*/
int inserisci_canzone(char *nome_new, char *canzone_new, char *nome_file) {
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

    return 1;
}

int ricerca_artista(char *nome, char *nome_file) {
    FILE *f_in;

    if ((f_in = fopen(nome_file, "r")) == NULL) {
        return -1;
    }
    else {
        char nome_tmp[30];
        char canzone_tmp[30];
        int flag = 0;

        printf("\n[Canzoni dell'artista]\n");
        while (!feof(f_in)) {
            if((fscanf(f_in, "%s%s", nome_tmp, canzone_tmp)) != 2)
                break;
            if((strcmp(nome, nome_tmp) == 0)){
                flag = 1;
                printf("- %s\n", canzone_tmp);
            }
        }
        putchar('\n');
        
        fclose(f_in);

        return (flag == 1) ? 1 : 0;
    }
}

int modifica_artista(char *nome, char *nome_new, char *nome_file) {
    FILE *f_in;
    FILE *f_tmp;
    int flag = 0;

    if ((f_in = fopen(nome_file, "r")) == NULL) {
        return -1;
    }
    else {
        if(((f_tmp = fopen("file_tmp", "w")) == NULL))
            return -1;
        else {
            char nome_tmp[30];
            char canzone_tmp[30];
           
            printf("\n[Canzoni dell'artista modificate]\n");

            while(!feof(f_in) && (fscanf(f_in, "%s%s", nome_tmp, canzone_tmp)) == 2) {
                if((strcmp(nome_tmp, nome)) == 0) {
                    fprintf(f_tmp, "%s\t %s\n", nome_new, canzone_tmp);
                    printf("- %s\n", canzone_tmp);
                }
                else {
                    fprintf(f_tmp, "%s\t %s\n", nome_tmp, canzone_tmp);
                }
            }

            putchar('\n');

            fclose(f_in);
            fclose(f_tmp);

            remove(nome_file);
            rename("file_tmp", nome_file);

            return (flag == 1) ? 1 : 0;          
        }
    }
}

int cancella_artista(char *nome, char *nome_file) {
    FILE *f_in;
    FILE *f_tmp;
    int flag = 0;

    if((f_in = fopen(nome_file, "r")) == NULL)
        return -1;
    else{
        if((f_tmp = fopen("file_tmp", "w")) == NULL)
            return -1;
        else {
            char nome_tmp[30];
            char canzone_tmp[30];
            
            printf("\n[Canzoni Cancellate]\n");

            while (!feof(f_in) && (fscanf(f_in, "%s%s", nome_tmp, canzone_tmp)) == 2) {

                if ((strcmp(nome_tmp, nome)) != 0) {
                    fprintf(f_tmp, "%s\t %s\n", nome_tmp, canzone_tmp); 
                }
                else {
                    flag = 1;
                    printf("- %s\n", canzone_tmp);
                }

            }

            putchar('\n');
            

            fclose(f_in);
            fclose(f_tmp);

            remove(nome_file);
            rename("file_tmp", nome_file);

            return (flag == 1) ? 1 : 0;
        }
    }
}
