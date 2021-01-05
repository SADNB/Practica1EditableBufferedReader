# PRÀCTICA 1 SAD
Pràctica 1: EditableBufferedReader

# INTRODUCCIÓ
En aquesta pràctica es treballarà amb el patró MVC (Model-View-Controller).


# PARTS DE LA PRÀCTICA
--> EditableBufferedReader: Serà una classe que extendrà la classe de Java BufferedReader. BufferedReader permet llegir el text         d'una seqüència d'entrada emmagatzemada en el buffer de caràcters. 
    Aquesta extensió es farà implementant els següents mètodes:
    · setRaw: passa la consola de mode cooked a mode raw. 
    · unsetRaw: passa la consola de mode raw a mode cooked
    En el mode raw, les dades es passen a l'aplicació tal i com es reben, sense que es realitzi cap canvi.
    En el mode cooked, sí que hi ha la possibilitat de canviar les dades amb un editor de linia. Per tant, les linies ja editades       seran les que rebrà l'aplicació.
    · read: llegueix el següent caràcter o la següent tecla de cursor. La seva funció és retornar el numero del caràcter introduit          pel terminal. Haurem de tenir en compte que s'hauran de llegir caràcters simples o símbols. Per tant, indagarem per                  implementar l'algoritme executant al test proporcionat amb la classe BufferedReader. 
    · readLine: llegeix la linia amb possibilitat d'editar-la. A diferència de l'anterior mètode, fins que no s'apreti la tecla            enter no llegirà el caràcter, i el guardarà sempre que no sigui un simbol. Aquest mètode va lligat amb la classe Line.

--> Line: 

--> Console: 

--> TestRead:

--> TestReadLine: 

# EXECUCIÓ DE LA PRÀCTICA

