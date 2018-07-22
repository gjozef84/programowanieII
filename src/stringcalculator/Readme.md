 * 1. Nie czytaj do przodu. Czytaj po jednym punkcie.
 * 2. Robimy jedną rzecz na raz. Uczymy się tworzyć programy inkrementalnie.
 * 3. Testuj tylko dla takich wejść które są podane w instrukcji.
 * 1. Programujemy kalkulator stringów. Będzie miał jedną metodę: Add(string numbers)
 * metoda przyjmuje 0, 1, 2 liczby i zwraca ich sumę
 * dla pustego wejścia suma = 0
 * przykłady : "", "1", "1,2"
 * Zacznij od najprostszego przypadku pustego stringa, potem 1 liczba, potem 2 liczby.
 * <p>
 * Rozwiązuj problemy tak prosto jak tylko potrafisz - musimy zmusić się do pisania testów o których wcześniej nie pomyśleliśmy
 * pamiętaj: RED, GREEN, REFACTOR
 * śmiało refaktoruj, zobacz czy podoba Ci się kod, cofaj zmiany (wszystko masz w gicie, prawda?)
 * nie bój się eksperymentować
 * 2. Meotda Add może dostać dowolną ilość liczb
 * 3. Liczby moga być oddzielone znakiem nowej lini
 * 3.1. taki string jest poprawny: "1\n2,3" (suma to 6)
 * 3.2. taki string nie jest ok: "1,\n" (nie musisz obsługiwać tego przypadku, w tej KATA skupiany się na poprawnych wejściach)
 * 4. Dodaj wsparcie dla innych znaków rozdzielających liczby
 * aby zdefiniować separator w stringu wejściowym będzie coś takiego: "//;\n1;2" (suma 3)
 * definicja separatora jest opcjonalana, wszystkie przypadki dotąd obsłużone muszą nadal działać
 * 5. Jeżeli w wejściu będzie liczba negatywna to Add() rzuca wyjątek "negatives not allowed" i podaje wszystkie wartości negatywne z wejścia.
 * ile testów napisałeś dla tego punktu?
 * ile razy spotkałes/spotkałaś się z programem który zamiast odrazu powiedzieć Ci o wsystkich błędach kazał Ci poprawiac je po jednym?
 * Jeżeli jesteś tutaj to znacz że idzie nam całkiem dobrze!
 * 6. Liczby większe niż 1000 będą ignorowane, więc 1000 + 2 = 2
 * 7. Separator może mieć dowolną długość: "//[delimiter]\n"
 * przykład: "//[aaa]\n1aaa2aaa3" (suma 6)
 * czy masz pomysł na ciekawy test którego Twój program jeszcze nie obsłuży?
 * programiści mają opór przed udowadnianiem że ich własne dzieło nie działa
 * dlatego potrzebujemy testerów
 * ale jeżeli Twoje programy będą miały mało błędów testerzy z Twojego zespołu będą to wiedzieć, i będą to szanowali
 * jeżeli czasem nie masz pomysłu jak sprawdzić czy Twój program jest bezbłedny i tzw. debiloodporny poproś kogoś innego żeby wymyślił jakieś testy
 * 8. Separatorów które są jednym znakiem może być wiele "//[d1][d2]\n"
 * przykład: "//[%][a]\n1%2a3" (suma 6)
 * 9. Może te być wiele separatorów o długości większej niż 1.
 