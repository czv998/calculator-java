# Izveštaj o statičkoj analizi koda

**Ukupan LOC (Lines of Code) projekta:** 212 linija koda (zbirno za Calculator.java i Start.java).

## Neformalni pregled koda i uočeni nedostaci (Code Smells)

* Calculator.java – linija 6 – Globalna statička promenljiva `static float finalResult;` se koristi za čuvanje rezultata unutar rekurentnih poziva. Ovo je loša praksa (Code Smell) jer klasa gubi niti-bezbednost (Thread Safety), pa bi paralelni proračuni prepisivali jedni drugima rezultat.
* Calculator.java – linija 20 – Naziv metode `ToString()` počinje velikim slovom, što krši standardne Java konvencije o imenovanju metoda (CamelCase) gde metode moraju počinjati malim slovom (`toString`).
* Calculator.java – linija 111 – U metodi `Calculate`, operacija deljenja (`numbers.get(indexDivide) / numbers.get(indexDivide + 1)`) izvršava se bez provere da li je delilac na desnoj strani jednak nuli (0.0f). Iako float deljenje sa nulom u Javi daje `Infinity` umesto rušenja aplikacije, ovo i dalje može izazvati logičke greške u kasnijim računskim operacijama.
* Calculator.java – linija 143 – Kompletan blok koda za rekurzivno računanje operacija sadrži visok stepen dupliranja koda (Code Duplication). Logika za uklanjanje i setovanje elemenata u listama se ponavlja nekoliko puta za svaku operaciju pojedinačno, što otežava održavanje koda.
* Start.java – linija 9 – Instanciran je objekat klase `Scanner`, ali se resurs na kraju rada programa nigde ne zatvara pomoću `scanner.close()`, što dovodi do curenja resursa (Resource Leak).
