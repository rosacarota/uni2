all: DataBase.out

DataBase.out: DataBase.o main.o
	gcc DataBase.o main.o -o DataBase.out

main.o: main.c DataBase.h
	gcc -Wall -g -c main.c

DataBase.o: DataBase.c DataBase.h
	gcc -Wall -g -c DataBase.c

clean:
	rm *.o *.out
