int search(char *nome, char *nome_file) {
    FILE *f_in;
    FILE *f_tmp;

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
        
        if((f_tmp = fopen("file_tmp.txt", "w")) == NULL) 
            return -1;
        else {
            while (!feof(f_in)) {
                fscanf(f_in,"%s%s", nome_tmp, canzone_tmp);
                
                if ((strcmp(nome_tmp, nome_new) == 0) && (strcmp(canzone_tmp, canzone_new) == 0)) {
                    fclose(f_in);
                    fclose(f_tmp);
                    remove("file.txt");
                    return 0;
                }
                else {
                    if(strcmp(canzone_tmp, canzone_new) > 0) {
                        fprintf(f_tmp, "%s\t %s", nome_tmp, canzone_new);
                    }
                }

                fprintf(f_tmp, "%s\t %s", nome_tmp, canzone_tmp);
            }

            fopen(f_in);
            fopen(f_tmp);

            remove(nome_file);
            rename("file_txt", nome_file);

            return 1;
        }
    }
}