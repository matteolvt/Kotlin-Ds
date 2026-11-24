class Bibliotheque {
    val medias : MutableList<Medias> = mutableListOf()
    val emprunts : MutableList<Medias> = mutableListOf()

    fun ajouterMedia(media : Medias) {
        if (media !in medias) {
            medias.add(media)
            println("Media ajouté au catalogue : '${media.titre}'")
        } else {
            println("Ce média est deja présent dans la bibliothèque")
        }
    }

    fun emprunter(media : Medias) {
        if (media !in medias) {
            println("Impossible : '${media.titre}' n'appartient pas à cette bibliotheque")
            return
        }
        if (media !is Empruntable) {
            println("Impossible : '${media.titre}' n'est pas un média empruntable.")
            return
        }
        if (media in emprunts || media.estEmprunte) {
            println("Impossible : '${media.titre}' est déjà emprunté.")
            return
        }
        if (media is Consultable && media.estEnConsultation) {
            println("Impossible : '${media.titre}' est actuellement en consultation sur place.")
            return
        }

        media.emprunter()
        emprunts.add(media)
    }

    fun retourner(media: Medias) {
        if (media !is Empruntable) {
            println("Impossible : '${media.titre}' n'est pas un média empruntable.")
            return
        }
        if (media !in emprunts || !media.estEmprunte) {
            println("Impossible : '${media.titre}' ne fait pas partie des emprunts en cours.")
            return
        }

        media.retourner()
        emprunts.remove(media)
    }

    fun consulter(media: Medias) {
        if (media !in medias) {
            println("Impossible : '${media.titre}' n'appartient pas à cette bibliothèque.")
            return
        }
        if (media !is Consultable) {
            println("Impossible : '${media.titre}' n'est pas consultable sur place.")
            return
        }
        if (media in emprunts || (media is Empruntable && media.estEmprunte)) {
            println("Impossible : '${media.titre}' est actuellement emprunté.")
            return
        }

        media.consulter()
    }

    fun afficherEmprunts() {
        if (emprunts.isEmpty()) {
            println("Aucun média n'est actuellement emprunté.")
        } else {
            println("--- Médias actuellement empruntés ---")
            emprunts.forEach { println(it.afficher()) }
            println("-------------------------------------")
        }
    }
}