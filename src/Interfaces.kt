interface Empruntable {
    var estEmprunte: Boolean

    fun emprunter() {
        if (!estEmprunte) {
            estEmprunte = true
            println("Le média a bien été emprunté.")
        } else {
            println("Impossible : ce média est deja emprunté")
        }
    }

    fun retourner() {
        if (estEmprunte) {
            estEmprunte = false
            println("Le média a bien été retourné")
        } else {
            println("Impossible : Ce média n'était pas emprunté")
        }
    }
}

interface Consultable {
    var estEnConsultation: Boolean

    fun consulter() {
        if (!estEnConsultation) {
            estEnConsultation = true
            println("Consultation sur place entamée")
        } else {
            println("Impossible : ce média est deja en cours de consultation/emprunté")
        }
    }

    fun terminerConsultation() {
        if (estEnConsultation) {
            estEnConsultation = false
            println("Consultation sur place terminée")
        } else {
            println("Impossible : ce média n'était pas en consultation")
        }
    }
}