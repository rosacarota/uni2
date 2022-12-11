#Seleziona i soci che hanno almeno un prestito
/*SELECT Nome, Cognome
FROM Socio INNER JOIN Prestito ON Socio.matricola = Prestito.matricola;*/

/*SELECT *
FROM Copia JOIN Edizione ON Copia.ISBN = Edizione.ISBN;*/

/*SELECT *
FROM Copia C JOIN Edizione E ON C.ISBN = E.ISBN;*/

/*SELECT *
FROM Copia LEFT OUTER JOIN Edizione ON Copia.ISBN = Edizione.ISBN;*/

/*SELECT *
FROM Copia RIGHT OUTER JOIN Edizione ON Copia.ISBN = Edizione.ISBN;*/

/*#Prodotto cartesiano tra Copia e Edizione 
SELECT *
FROM Copia CROSS JOIN Edizione;*/ 

/*SELECT *
#join implicito
FROM Copia, Edizione;*/ 

/*#trasformre da join esplicito a implicito
SElECT *
FROM Copia, Edizione
WHERE Copia.ISBN = Edizione.ISBN;*/

/*#Possiamo omettere l'ON poichè abbiamo lo stesso nome per l'attributo*/ 
SELECT *
FROM Copia NATURAL JOIN Edizione;
