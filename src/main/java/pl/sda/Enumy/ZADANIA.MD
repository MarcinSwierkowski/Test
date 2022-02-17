# Enumy - zadania

### Zadanie 1
Stwórz typ wyliczeniowy ColorName oraz ColorBackgroundName zgodnie z tabelą.
Oprócz nazwy koloru powinna być jego wartość.

|Color Name |Color code |Background Color   | Background Color code|
|-----------|-----------|-------------------|----------------------|
|BLACK	    |\u001B[30m	|BLACK_BACKGROUND	| \u001B[40m              |
|RED	    |\u001B[31m	|RED_BACKGROUND 	| \u001B[41m              |
|GREEN	    |\u001B[32m	|GREEN_BACKGROUND	| \u001B[42m              |
|YELLOW	|\u001B[33m	|YELLOW_BACKGROUND	| \u001B[43m              |
|BLUE	    |\u001B[34m	|BLUE_BACKGROUND	| \u001B[44m              |
|PURPLE	|\u001B[35m	|PURPLE_BACKGROUND  | \u001B[45m              |
|CYAN	    |\u001B[36m	|CYAN_BACKGROUND    | \u001B[46m              |
|WHITE	    |\u001B[37m	|WHITE_BACKGROUND   | \u001B[47m              |

Użyj tych dwóch enumów by napisać kolorowy tekst na kolorowym tle na konsoli np.:

![img.png](img.png)

Wartością resetująca ustawienia kolorów jest "\u001B[0m"
