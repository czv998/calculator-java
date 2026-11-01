1. Detektovani propusti, nedostaci i softverske greške

Na osnovu analize ponašanja i strukture metode Calculate, identifikovani su sledeći propusti i granični slučajevi koji narušavaju stabilnost i tačnost rada sistema:
Logička greška kod deljenja nulom: U Javi, deljenje tipa float sa nula ne izaziva krah aplikacije već vraća vrednost Infinity. Metoda dopušta da se ova vrednost dalje koristi u lancu operacija (na primer 5 kroz 0 plus 3 rezultuje sa Infinity), umesto da prekine izvršavanje i ispiše poruku o grešci korisniku.
Nedostatak ulazne validacije: Ne postoji provera pre prosleđivanja izraza metodi. Unos slova ili specijalnih karaktera (na primer 10 plus abc puta 2) uzrokuje nekontrolisano pucanje programa sa NumberFormatException prilikom pokušaja parsiranja tekstualnog podatka u broj.
Problem sa uzastopnim i nevalidnim operatorima: Unos neispravne sintakse poput dva plusa za redom ili kosa crta i zvezdica zbunjuje algoritam za parsiranje i razdvajanje elemenata, što dovodi do rušenja aplikacije ili pogrešnog rezultata.
Rukovanje praznim unosom: Prosleđivanje potpuno praznog teksta metodi dovodi do indeksnih grešaka u listama IndexOutOfBoundsException jer algoritam obavezno očekuje bar jedan broj.
Niti nebezbednost: Korišćenje globalne statičke promenljive finalResult za skladištenje i rekurzivno prenošenje međurezultata čini kalkulator nebezbednim za paralelni rad, jer bi više pokrenutih proračuna u isto vreme prepisivalo vrednosti jedna drugoj.

2. Test primeri i rezultati

Test primer 1: Složeni izraz sa prioritetom
Unos: 10 plus 5 puta 4 plus 3
Očekivani izlaz: 33.0
Status: Prošao

Test primer 2: Deljenje sa nulom
Unos: 5 kroz 0
Očekivani izlaz: Poruka o grešci Deljenje nulom
Status: Nije prošao (Program vraća Infinity)

Test primer 3: Unos slova u izrazu
Unos: 4 plus x minus 2
Očekivani izlaz: Poruka o grešci Nevalidan unos
Status: Nije prošao (Program puca sa NumberFormatException)

Test primer 4: Uzastopni operatori
Unos: 5 plus plus 3
Očekivani izlaz: Poruka o grešci Sintaksa
Status: Nije prošao (Program puca ili daje loš rezultat)

Test primer 5: Prazan unos
Unos: Prazan tekst
Očekivani izlaz: Poruka da se unese izraz
Status: Nije prošao (Program puca sa IndexOutOfBounds)

3. Zaključak i preporuke

Prva preporuka: Implementirati odbijanje nevalidnog unosa preko regularnih izraza pre nego što se uopšte pokrene algoritam za računanje.
Druga preporuka: Izbaciti statičku promenljivu finalResult i preći na lokalno vraćanje vrednosti kroz funkciju kako bi se obezbedila sigurnost u radu sa više niti.
Treća preporuka: Dodati eksplicitnu proveru za delilac nula pre samog izvršavanja operacije deljenja u kodu.
