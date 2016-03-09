# Matched Pair algorithm (how-to)

## Opis zastosowanego podejścia do rozwiązania zadania:

Opis szczegółowy zastosowanego podejścia oraz przebieg algorytmu dla przykładowych danych znajduje się pod adresem:

  https://daniel-fryze-matchedpair-task.herokuapp.com

## Krótki opis klas znajdujących się w projekcie:

Klasa z implementacją algorytmu:

* _MatchedPair_ - abc

Metoda algorytmu do zaimplementowania (zmiana):

Sygnatura wymaganej do zaimplementowania metody:
```
int matchedPair(int[] P, int[] Q)
```
musiała zostać zmieniona na następującą:
```
long matchedPair(int[] P, int[] Q)
```
Bowiem, zgodnie z opisem algorytmu, oraz zadanymi ograniczeniami dla danych wejściowych, maksymalna wartość wyniku do uzyskania przez algorytm: 4.999.950.000.

Na przykład dla danych wejściowych w postaci:

P - tablica 100.000 liczb o takiej samej wartości: 10, czyli [10, 10, 10 ... 10]
Q - tablica 100.000 liczb o takiej samej wartości: 10, czyli [1, 1, 1 ... 1]

Wynik algorytmu to suma ciągu arytmetycznego w postaci: 99.999 + 99.998 + 99.997 + ... + 1, czyli: 4.999.950.000.

Natomiast w Javie maksymalna wartość dla typu prostego 'int' wynosi: 2.147.483.647.

Zatem, aby poprawnie zwrócić wynik z algorytmu musimy użyc typu prostego o większym zakresie, np. zastosowany 'long'. Od strony logicznej, zmiana ta nie wpływa na działanie samego algorytmu.

Ponadto dodano również opcjonalny argument dodatkowy w postaci flagi logicznej (typ 'boolean') na końcu listy argumentów wywołania metody:
```
long matchedPair(int[] P, int[] Q, boolean ... args)
```
Działa on w sposób następujący:
* podanie wartości 'true' dla tego argument dezaktywuje walidację danych wejściowych (tablic z liczbami)
* pominięcie go w wywołaniu metody lub podanie wartości 'false' pozostaia aktywną walidację

Jego zastosowanie ma miejsce w testach, gdzie dla celów wydajnościowych można wyłączyć walidację danych wejściowych, przyjmując, że wartości te spełniają wymóg zadany w opisie algorytmu. A jako że jest opcjonalny, to de facto nie wpływa na sygnaturę metody.

Klasy pomocnicze:

* _MatchedPairBruteForce_ - abc
* _BigDecimalConverter_ - abc
* _MatchedPairInputValidator_ - abc

Klasy z testami:

* _MatchedPairInputInvalidTest_ - abc
* _MatchedPairInputValidTest_ - abc
* _MatchedPairRandomInputsTest_ - abc
