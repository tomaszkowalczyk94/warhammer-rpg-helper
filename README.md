# warhammer-rpg-helper

## Krótki opis
 Program ma za zadanie pomagać przy sesjach gry Warhammer Fantasy Roleplay 
 (https://pl.wikipedia.org/wiki/Warhammer_Fantasy_Roleplay). 
 
Przykład jak wygląda sesja rpg: https://www.youtube.com/watch?time_continue=2692&v=alN3SSHkAXk

Sama gra jest dosyć skomplikowana, 
podstawowy podręcznik do niej ma prawie 300 stron
(https://www.pdf-archive.com/2016/07/14/warhammer-2-0-podr-cznik-gry-pl/warhammer-2-0-podr-cznik-gry-pl.pdf). 
Aplikacja ma za zadanie usprawnić taką grę, wyręczając nas z obliczeń, pilnować aby nie zrobić prostych błędów. 


## Aktualnie mamy


Każdy gracz musi mieć otwartą aplikacje podczas gry. 
Wybiera czy ma być graczem, czy gamemasterem.
Gamemaster widzi listę wszystkich zmian jakie robią inni gracze na swoich kartach postaci. 
Gracz widzi swoją kartę postaci.

W tej chwili jest stworzone połączenie z bazą danych, edytowanie podstawowych pól postaci, 
baza danych


## W planach
* Zarządzanie ekwipunkiem, broniami, opancerzeniem (każda profesja ma dostępne inny ekwipunek, które nawzajem potrafią na siebie wpływać)

* Wizzard z tworzeniem postaci (losowanie cech, obliczanie statystyk, jest to dosyć skomplikowane, na papierze to około 30-60 minut z kalkulatorkiem w ręku)
dać możliwość gamemasterowi edytowanie postaci graczy (czyli gracz powinien udostępnić proste api do edycji swojej lokalnej bazy danych h2)
* Każdy z graczy powinien mieć możliwość podglądu tego, co inny gracz zmienił, podejrzeć statystyki innego gracza. 
* Lista z dostępnymi profesjami, generowanie "drzewa rozwoju" (około 130 profesji), blokada wybrania profesji, jeśli nie spełniliśmy warunków wymaganych do przejścia na daną profesje
* Lista z dostępnymi umiejętnościami
* Ekwipunek gracza, obliczanie automatycznie ciężaru ekwipunku, i statystyk gracza (ciężki ekwipunek wpływa na statystyki)
* Waluty w grze, automatyczne przewalutowanie (w grze dostępnych jest kilka walut)
* Lista dostępnych czarów dla dla gracza (lista jest zależna od profesji, ekwipunku, umiejętności)
* Konwersja punktów na doświadczenia na punkty w statystykach (expienie, lvl-owanie)
* Aplikacja nie ma na celu zastąpienia całkowicie gry, sama w sobie nie będzie grą, ma za zadanie jedynie usprawnić grę mówioną, wyręczyć z obliczeń, pilnować gracza aby nie zrobił pomyłek, wyświetlać opisy danych profesji/przedmiotów)

## Aktualnie w aplikacji używamy:

* OrmLite (http://ormlite.com/) 
* Baza danych h2
* SWING
* maven
* biblioteka kryonet do sieci
* junita i mockito do testów (jest ich na razie niewiele)
* Git
