/**
 * Classe Règle
 * 
 * Règle avec ses prédicats
 * 
 * @author: Loana MOTTAIS, Himidati BOINAIDI
 */


import java.util.ArrayList;

public class Règle {
    
    public int id;
    private ArrayList<Faits> faits;
    private Faits conclusion;
    private int count;

    public Règle (int id, ArrayList<Faits> faits, Faits conclusion) {
        this.id = id; 
        this.faits = faits;
        this.conclusion = conclusion;
        this.count = 0;
    }

    /**
     * @function isTrue
     * @param BaseConnue base
     * @return vrai si tous les prédicats font partie de la base de faits, faux sinon
     * 
     * Parcours la liste des prédicats, vérifie leur présence dans la base de faits
     */
    public boolean isTrue (BaseConnue base) {
        boolean res = false;
        this.faits.forEach ((f) -> {
            if (base.isTrueFait(f) == true) {
                this.count ++;
            }
        });
        
        if (this.count == this.faits.size()) {
            res = true;
        }

        this.count = 0;        //réinitialisation du compteur
        return res;
    }


    //retourn le modèle d'affichage des règles
    public String toString(){
        String resultat="";
         resultat="R" + this.id + ":\n";
            for (int i=0; i<this.faits.size()-1; ++i) {
              resultat+=faits.get(i).getFait();
              if(faits.size()>1) //s'il y a plusieurs prémice
                resultat+=" Et ";
            }
          resultat+= " Alors "+ this.conclusion;
          return resultat;
    }
  
}
