#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "DataBase.h"

char *leggi_stringa() {
    char str1[30];
    char *str2;

    fgets(str1, 30, stdin);
    if(str1[strlen(str1) - 1] == '\n') {
        str1[strlen(str1) - 1] = '\0';
    }

    str2 = malloc(strlen(str1) + 1);
    if(!str2) return NULL;

    strcpy(str2, str1);

    return str2;

}

int inserisci_canzone(char *nome_new, char *canzone_new) {
    FILE *f_in;
    
    if(!(f_in = fopen("DataBase.txt", "r"))) {
        // se non lo apre in lettura deve creare il nuovo file di testo
        if((f_in = fopen("DataBase.txt", "w")) == NULL)
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

        while(!feof(f_in)) {
            fscanf(f_in,"%s%s", nome_tmp, canzone_tmp);
            if ((strcmp(nome_tmp, nome_new) == 0) && (strcmp(canzone_tmp, canzone_new) == 0)) {
                fclose(f_in);
                return 0;
            }
        }

        FILE *f_app;

        if ((f_app = fopen("DataBase.txt", "a")) == NULL)
            return -1;
        else{
        fprintf(f_app, "%s\t %s\n", nome_new, canzone_new);

        fclose(f_app);
        fclose(f_in);

        return 1;
        }
    }
}