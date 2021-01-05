# PRÀCTICA 1 SAD
Pràctica 1: EditableBufferedReader

# INTRODUCCIÓ
En aquesta pràctica es treballarà amb el patró MVC (Model-View-Controller).
El model gestiona tots els accesos a la informació, ja sigui per consultar-la o actualitzar-la.
EL view seria l'interficie de l'usuari, per tant mostra a l'usuari la informació.
El controller respon a accions de l'usuari i invoca al model si hi ha peticions sobre la informació (editar una linia, per exemple). 

# Interacció entre els components:
L'usuari interactua amb el view (en el nostre cas, executant el TestReadLine). Llavors, el controller (EditableBufferedReader) serà l'encarregat de modificar el model (Line) amb l'acció sol·licitada per l'usuari (afegir caràcter, esborrar, desplaçar-se,...). El view obtindrà les dades del model per reflexar els canvis produits. També utilitzem el patró Observer que permetrà al model notificar a la resta els canvis produïts en la classe.


# PARTS DE LA PRÀCTICA
--> EditableBufferedReader: Serà una classe que extendrà la classe de Java BufferedReader. BufferedReader permet llegir el text       d'una seqüència d'entrada emmagatzemada en el buffer de caràcters. Representarà el controller del patró MVC.
    Aquesta extensió es farà implementant els següents mètodes:
    · setRaw: passa la consola de mode cooked a mode raw. 
    · unsetRaw: passa la consola de mode raw a mode cooked
    En el mode raw, les dades es passen a l'aplicació tal i com es reben, sense que es realitzi cap canvi.
    En el mode cooked, sí que hi ha la possibilitat de canviar les dades amb un editor de linia. Per tant, les linies ja editades       seran les que rebrà l'aplicació.
    · read: llegueix el següent caràcter o la següent tecla de cursor. La seva funció és retornar el numero del caràcter                introduit pel terminal. Haurem de tenir en compte que s'hauran de llegir caràcters simples o símbols. Per tant, indagarem        per implementar l'algoritme executant al test proporcionat amb la classe BufferedReader. 
    · readLine: llegeix la linia amb possibilitat d'editar-la. A diferència de l'anterior mètode, fins que no s'apreti la tecla          enter no llegirà el caràcter, i el guardarà sempre que no sigui un simbol.

--> Line: Aquesta classe permet l'edició de la línia. Haurem de crear funcions per poder mourens per la linia i poder modificar       el caràcter desitjat, esborrar-lo o substituir-lo per un altre, depenent del mode en el que ens trobem, ja sigui inserció o       sobre-escriptura. Aquesta classe va lligada amb el mètode readLine de la classe EditableBufferedReader, ja que es el mètode       que permet editar la linia inserida per terminal. També servirà per implementar el patró MVC, que representarà al Model.

--> Console: Necessari per implementar el patró MVC. Representarà el component View. Respondrà a la sol·licitud d'editar la linia     o un desplaçament. Serà l'intermediari entre la classe Line i la classe TestReadLine. 

--> TestReadLine: Classe proporcioanada per executar amb la classe EditableBufferedReader el mètode readLine. Mostrarà els           caràcters introduïts en la linia del terminal editats per pantalla.

--> TestRead: Classe semblant a TestReadLine però utilitzada a l'hora d'executar el mètode read. El vam crear ja que era més         fàcil i no haviem d'estar modificant constantment la classe anterior. 

# EXECUCIÓ DE LA PRÀCTICA

