CC=gcc
CFLAGS=-Wall -g
BIN=main.o util.o database.o

main.out: $(BIN)
	$(CC) $(CFLAGS) -o $@ $^

main.o: main.c util.h
	$(CC) $(CFLAGS) -c $<

util.o: util.c util.h database.h
	$(CC) $(CFLAGS) -c $<

database.o: database.c database.h
	$(CC) $(CFLAGS) -c $<
	
clean:
	rm *.o *.out