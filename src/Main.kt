//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val biblio = Bibliotheque()

    val livre = Livre("L'art de la victoire", "2017-01-12", "Phill Knight", "Hugo Doc")
    val journal = Journal("Le Monde", "2026-11-24")
    val dvd = Dvd("Inception", "2010-07-16", 148, "Science-Fiction")

    // 1. Ajout des médias
    biblio.ajouterMedia(livre)
    biblio.ajouterMedia(journal)
    biblio.ajouterMedia(dvd)

    // 2. Test des emprunts et validations
    biblio.emprunter(livre)       // OK
    biblio.emprunter(livre)       // Bloqué : déjà emprunté
    biblio.emprunter(journal)     // Bloqué : Journal n'est pas Empruntable
    biblio.emprunter(dvd)         // OK

    // 3. Affichage des emprunts en cours
    biblio.afficherEmprunts()

    // 4. Test du retour
    biblio.retourner(livre)       // OK
    biblio.retourner(livre)       // Bloqué : n'est plus dans les emprunts

    // 5. Test de la consultation sur place
    biblio.consulter(journal)     // OK
    biblio.consulter(dvd)         // Bloqué : Dvd n'est pas Consultable
}