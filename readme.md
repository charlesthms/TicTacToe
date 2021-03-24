# Tic Tac Toe
[![License: WTFPL](https://img.shields.io/badge/License-WTFPL-brightgreen.svg)](http://www.wtfpl.net/about/)
>Ce projet est une implémentation du jeu de morpion en Java utilisant un affichage console.


## Installation
Commencer par cloner ce dépôt et lancer le jeu. Dans une console, tapez :
```
$ git clone https://github.com/charlesthms/TicTacToe
$ cd TicTacToe/out/artifacts/ && java -jar TicTacToe.jar
```
## Comment jouer
Au lancement, le jeu vous demandera de choisir le mode de jeu souhaité ( **[1]** pour jouer contre un humain et **[2]** pour jouer contre une intelligence artificielle )
```
Sélectionnez le mode de jeu ( [1] HUMAN / [2] AI ) et appuyez sur [ENTRER]
1
```
Puis vous devrez rentrer votre nom, ainsi que celui de votre adversaire.
```
Entrez le nom du joueur 1 et appuyez sur [ENTRER]
Jack
```
Une fois vos caractères créés, le jeu commence. Il faudra alors taper le numéro de la case sur laquelle vous souhaitez jouer pour placer votre symbole à cet endroit là.  

```
-------------------
|  1  |  2  |  3  |
-------------------
|  4  |  5  |  6  |
-------------------
|  7  |  8  |  9  |
-------------------

[JOUEUR1] Entrez votre position et appuyez sur [ENTRER]
2

-------------------
|  1  |  X  |  3  |
-------------------
|  4  |  5  |  6  |
-------------------
|  7  |  8  |  9  |
-------------------

[JOUEUR2] Entrez votre position et appuyez sur [ENTRER]
```
>**Attention** si vous entrez autre chose qu'un nombre le programme produira une erreur, il faudra donc relancer celui-ci. 
>

## Intelligence artificielle

Ce programme utilise l'algorithme Minimax afin de trouver de manière récursive la meilleure position.

