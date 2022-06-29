# Peer-Review 1: UML

Ruben Franchetto, Margherita Gaetani, Andrea Lazzarini

Gruppo 57

Valutazione del diagramma UML delle classi del gruppo 56.

## Lati positivi
- Belli i nomi dei Character
- Completa suddivisione delle fasi di gioco in Round, Turn e Phase.
- Controllo numero studenti nelle varie classi che li contengono.


## Lati negativi
#### UML Generale:
- Cardinalità indicate con notazione per array invece della numerazione sulle connessioni di relazione.
- Ripetizione degli attributi redPawn, greenPawn, …, si potrebbe usare una classe dedicata.
- Tanti Array dove potrebbe essere più semplice usare strutture dinamiche.
- Mancano tipi di ritorno per alcuni metodi.
- Ripetizione del controllo delle fasi in Model e Controller
- Composizioni indicate solo con frecce, devono essere anche attributi delle classi contenitrici.

#### Classi Specifiche
##### Game
-  “NumPlayer” è un nome poco chiaro.
- Si controlla se il gioco è modalità expert a ogni turno?
- Cloud e Island salvati come Array. Forse funziona ancora per Cloud, ma non è chiaro come unifyIsland() potrebbe agire su un array.
- chooseWizard() ritorna un unico assistente.

##### Studentbag
- RefillCloud(): è metodo di StudentBag, quindi StudentBag come parametro non serve
- Perché l’Enum ColorPawn vi è collegato? Non ne notiamo l’utilizzo.

##### Professor
- Non appare da nessuna parte da quali classi è usato.
- moveProf(): confonde NumPlayer come parametro - può essere superfluo, dato che il movimento dei Prof non dipende dal Player corrente, ma dalla situazione globale.

##### Cloud
- Non chiarissima l’implementazione. Sembra che moveToEntrance usi l’altro metodo per ricevere il  player corrente e acceda alla sua Entrance per metterci students prelevati da StudentBag.
- Manca un metodo per riempire la nuvola.

##### Player
- Confonde un po’ il metodo numStepMN(), qual è il suo ruolo?

##### AssistantCard
- setDeck(Wizard): superfluo; I deck associati ai Wizard diversi sono tutti identici. Inoltre la classe Wizard non è definita.

##### Schoolboard
- Va specificata l’associazione. Come si accede alla Schoolboard? Al momento non è chiaro: dalla Schoolboard si può accedere al Player, ma non viceversa.

##### ProfTable
- Averne una per giocatore è in realtà ridondante. Si può usare invece una classe che associa ciascun colore al giocatore che ne ha il controllo.

##### DiningRoom
- coinPosition(): ritorna void, meglio un altro return type.
- addPawn(): controlla se la Row è piena prima di aggiungere?

##### Entrance 
- CheckNum(num: int) inutile, nella Entrance ci sono sempre solo 7/9 pedine all’inizio del turno, forse meglio CheckColor.

##### Island
- Manca una struttura per gestire isole unificate.

##### Deck
- Come può essere raggiunto? Associato a Player in cui non appare.

##### CharacterCard
- Non usato da Deck che contiene invece oggetti Character
- Come viene gestito il prezzo?

##### Implementazioni di CharacterCard
- Implementazione come metodi non spiega come le azioni che cambiano le regole del gioco possano agire. Es: Lancillotto cambia come si conta l’influence in un momento successivo, come si intende implementarlo? Con un check se Lancillotto è active? Cosa succede quando Lancillotto non esiste?

##### Controller
- setPlayer cosa fa? Nessun metodo in Game o Player prende stringhe.

##### RoundController
- Come fa a leggere i cardValue degli assistenti giocati?

## Confronto tra le architetture
Noi non abbiamo suddiviso completamente le fasi di gioco, molto utile per ordinare meglio la logica di controllo. Nel nostro UML aggiungeremo questo e più check espliciti prima dell’esecuzione di ogni azione.



