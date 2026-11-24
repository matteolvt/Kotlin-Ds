# Ds Kotlin

Dans ce Repository Git vous retrouverez mon rendu concernant le DS Kotlin.

---

## Architecture du projet

Le projet est organisé autour de 4 fichiers dans le dossier `src/` :

```text
src/
├── Interfaces.kt      # Comportements Empruntable et Consultable
├── Medias.kt          # Classe abstraite Medias et ses sous-classes concrètes
├── Bibliotheque.kt    # Collections, emprunts et validations
└── Main.kt            # Scénarios de test et démonstration
```

### 1. Hiérarchie des classes (`Medias.kt`)

`Medias` est une classe abstraite. Elle définit les propriétés communes (`titre`, `dateDeParution` au format ISO `AAAA-MM-JJ`) et impose la méthode `afficher(): String`.

| Classe             | Attributs spécifiques | Empruntable | Consultable |
|--------------------|-----------------------|:-----------:|:-----------:|
| `Livre`            | `auteur`, `editeur`   | Oui         | Oui         |
| `Magazine`         | `numero`              | Non         | Oui         |
| `Journal`          | —                     | Non         | Oui         |
| `EnregistrementAudio` | `duree`, `genre`   | Oui         | Non         |
| `Dvd`              | `duree`, `genre`      | Oui         | Non         |

### 2. Interfaces (`Interfaces.kt`)

- **`Empruntable`** : gère l'état `estEmprunte` ainsi que les méthodes `emprunter()` et `retourner()`.
- **`Consultable`** : gère l'état `estEnConsultation` ainsi que les méthodes `consulter()` et `terminerConsultation()`.

### 3. Gestionnaire (`Bibliotheque.kt`)

La classe `Bibliotheque` centralise les opérations et garantit la cohérence des états.

- `medias: MutableList<Medias>` : catalogue complet des médias.
- `emprunts: MutableList<Medias>` : médias actuellement empruntés.
- **Méthodes** : `ajouterMedia()`, `emprunter()`, `retourner()`, `consulter()`, `afficherEmprunts()`.
- **Validations** : empêche l'emprunt d'un média déjà emprunté ou en consultation, vérifie l'appartenance au catalogue et contrôle le support des interfaces avant toute action.

---

## Exemple d'utilisation (`Main.kt`)

```kotlin
fun main() {
    val biblio = Bibliotheque()

    // 1. Création des médias (dates au format ISO AAAA-MM-JJ)
    val livre = Livre("1984", "1949-06-08", "George Orwell", "Gallimard")
    val journal = Journal("Le Monde", "2026-11-24")
    val dvd = Dvd("Inception", "2010-07-16", 148, "Science-Fiction")

    // 2. Ajout au catalogue
    biblio.ajouterMedia(livre)
    biblio.ajouterMedia(journal)
    biblio.ajouterMedia(dvd)

    // 3. Emprunts, retours et consultations
    biblio.emprunter(livre)     // Succès
    biblio.emprunter(journal)   // Refusé (non empruntable)
    biblio.afficherEmprunts()   // Liste les médias empruntés
    biblio.retourner(livre)     // Retour en rayon
    biblio.consulter(journal)   // Consultation sur place
}
```

---

## Prérequis et exécution

- **Langage** : Kotlin (JVM 21+)
- **IDE recommandé** : IntelliJ IDEA

1. Ouvrir le dossier du projet dans IntelliJ IDEA.
2. Vérifier que le SDK du projet est configuré sur Java 21 (ou supérieur) avec la bibliothèque `KotlinJavaRuntime`.
3. Ouvrir `src/Main.kt` et cliquer sur la flèche verte ▶ à côté de `fun main()`.

---

## Exemple de sortie console

```text
Media ajouté au catalogue : '1984'
Media ajouté au catalogue : 'Le Monde'
Media ajouté au catalogue : 'Inception'
Le média a bien été emprunté.
Impossible : 'Le Monde' n'est pas un média empruntable.
--- Médias actuellement empruntés ---
Livre : '1984' écrit par George Orwell, édité par Gallimard, paru le 1949-06-08
-------------------------------------
Le média a bien été retourné
Consultation sur place entamée
```