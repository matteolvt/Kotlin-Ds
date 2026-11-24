abstract class Medias(val titre: String, val dateDeParution: String,) {

    abstract fun afficher(): String
}

class Livre(titre: String, dateDeParution: String, val auteur: String, val editeur: String
) : Medias(titre, dateDeParution), Empruntable, Consultable{

    override var estEmprunte: Boolean = false
    override var estEnConsultation: Boolean = false

    override fun afficher(): String {
        return "Livre : '$titre' écrit par $auteur, édité par $editeur, paru le $dateDeParution"
    }
}

class Magazine(titre: String, dateDeParution: String, val numero: String
) : Medias(titre, dateDeParution) ,Consultable{

    override var estEnConsultation: Boolean = false

    override fun afficher(): String {
        return "Magazine : '$titre' numéro $numero paru le $dateDeParution"
    }
}

class Journal(titre: String, dateDeParution: String) : Medias(titre, dateDeParution), Consultable{

    override var estEnConsultation: Boolean = false

    override fun afficher(): String {
        return "Journal : '$titre' paru le $dateDeParution"
    }
}

class EnregistrementAudio(titre: String, dateDeParution: String, val duree: Int, val genre: String
) : Medias(titre, dateDeParution) , Empruntable{

    override var estEmprunte: Boolean = false

    override fun afficher(): String {
        return "Enregistrement Audio : '$titre' appartenant au genre $genre paru le $dateDeParution, durant $duree"
    }
}

class Dvd(titre: String, dateDeParution: String, val duree: Int, val genre: String
) : Medias(titre, dateDeParution), Empruntable{

    override var estEmprunte: Boolean = false

    override fun afficher(): String {
        return "DVD : '$titre' appartenant au genre $genre paru le $dateDeParution, durant $duree"
    }
}