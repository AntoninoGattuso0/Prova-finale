# Peer-Review 2: Protocollo di Comunicazione

Franchetto Ruben, Margherita Gaetani, Andrea Lazzarini

Gruppo 57 

Valutazione della documentazione del protocollo di comunicazione del gruppo 56.

## Lati positivi
- Scrittura esempio di sequenza messaggi.
- Suddivisione tipo di messaggi con campo channel.

## Lati negativi

- Manca una descrizione di come i messaggi vengono implementati (stringa, oggetto java serializzato, xml...).
- Il campo Channel è sempre uguale.
- Messaggio IS_EXPERT solo nel diagramma, manca la gestione dei personaggi.
- Messaggi di richiesta del setup del gioco possono essere uniti.
- Manca la richiesta dell'username.
- Manca l'utilizzo dei blocchi opt, blocchi loop poco chiari.
- Descrizione fasi di gioco scorretta, fase di pianificazione e fase di azione sono unite in un unico turno di ogni giocatore.
- Wait non è un messaggio utile per il server.
- Dati ridonodanti in DO_MOVEPAWN, manca il colore.
- Messaggio invalid action un po' generico.
- Manca il messaggio di aggiornamento view dal server agli altri giocatori.


## Confronto

Noi abbiamo separato i diagrammi, uno per ogni azione del giocatore. Abbiamo anche creato dei codici errore per ogni tipo di check dei parametri. Avendo usato oggetti java serializzati, possiamo implementare il meccanismo dei channel estendendo la classe Message nei vari sottotipi.
