import java.util.ArrayList;
import java.util.List;

/**
 * Classe App
 * 
 * Classe principale où l'application est lancée
 * 
 * @author: Loana MOTTAIS, Himidati BOINAIDI
 */

public class Test {
    public static void main(String[] args) throws Exception {
       
        /* --- TOUS LES FAITS --- */
        Fait f1 = new Fait(1, "Est un oiseau");
        Fait f2 = new Fait(2, "Peut voler");
        Fait f3 = new Fait(3, "Est noir et blanc");
        Fait f4 = new Fait(4, "Ne peut pas voler");
        Fait f5 = new Fait(5, "Est un pingouin");
        Fait f6 = new Fait(6, "Est une pie");
        Fait f7 = new Fait(7, "Vit en groupe");
        Fait f8 = new Fait(8, "Vit en couple");
        Fait f9= new Fait(9, "est un Manchot");
        Fait f10= new Fait(10, "sont de la même famille");

        // Non utilisée pour l'instant donc commentée pour ne pas avoir de warning sur le fichier
        ArrayList<Fait> baseFaitsComplete = new ArrayList<Fait>(
            List.of(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10)
        );
        


        /* --- TOUTES LES REGLES --- */
        
        Regle r1 = new Regle(1, new ArrayList<Fait>(List.of(f1)), f3);
        Regle r2 = new Regle(2, new ArrayList<Fait>(List.of(f1, f3, f4)), f5);
        Regle r3 = new Regle(3, new ArrayList<Fait>(List.of(f1, f3, f2)), f6);
        Regle r11=new Regle(3, new ArrayList<Fait>(List.of(f9, f10)), f7); //règle qui n'a pas de sens, mais juste pour le test
        Regle r4 = new Regle(4, new ArrayList<Fait>(List.of(f7)), f5);
        Regle r5 = new Regle(5, new ArrayList<Fait>(List.of(f8, f7)), f5);
        Regle r6 = new Regle(6, new ArrayList<Fait>(List.of(f8)), f6);
        Regle r7 = new Regle(7, new ArrayList<Fait>(List.of(f1,f3)), f4);
        Regle r8= new Regle(8, new ArrayList<Fait>(List.of(f1,f3)), f9);
        Regle r9= new Regle(9, new ArrayList<Fait>(List.of(f5, f9)), f10);

        //règle qui n'a pas de sens mais c'est juste pour tester
        Regle r10=new Regle(10, new ArrayList<Fait>(List.of(f6, f9)), f8);

        BaseRegle baseRegle = new BaseRegle(new ArrayList<Regle>(List.of(r1, r2, r3,r11, r4, r5, r6, r7, r8, r9, r10)));


        /* --- TEST DE L'APPLICATION --- */

        /* chainage avant */

        /*
        BaseConnue base = new BaseConnue();
        base.addFait(f1);
        base.addFait(f4);
        */

        /*
        System.out.println();
        System.out.println(" ### CHAINAGE ARRIERE ###");

        BaseConnue baseArriere = new BaseConnue();
        baseArriere.addFait(f6);

        ChainageArriere moteur = new ChainageArriere(baseArriere, baseRegle);

        System.out.println();
        System.out.println(" --- CHAINAGE SIMPLE --- ");

        System.out.println("Avant chainage arrière, base : " + baseArriere.getFaits());
        moteur.chainageSimple();
        System.out.println("Après chainage arrière, base : " + baseArriere.getFaits());

    
        System.out.println();
        System.out.println(" --- CHAINAGE PLUS --- ");
        baseArriere.removeAllFaits();
        baseArriere.addFait(f6);
        System.out.println("Avant chainage arrière, base : " + baseArriere.getFaits());
        moteur.chainagePlusRecursif();
        System.out.println("Après chainage arrière, base : " + baseArriere.getFaits());
        
        System.out.println();
        System.out.println(" --- CHAINAGE RECENT --- ");
        baseArriere.removeAllFaits();
        baseArriere.addFait(f6);
        System.out.println("Avant chainage arrière, base : " + baseArriere.getFaits());
        moteur.chainageRecentRecursif();
        System.out.println("Après chainage arrière, base : " + baseArriere.getFaits());

        */


        /*BaseConnue baseAvant= new BaseConnue();

        baseAvant.addFait(f1);
        baseAvant.addFait(f2);
        baseAvant.addFait(f3);
        baseAvant.addFait(f4);

        System.out.println(baseAvant.getFaits()+"\n");
        ChainageAvant moteurChainageAvant=new ChainageAvant(baseAvant, baseRegle);
        System.out.println("n'importe quel règle applicable \n");
        moteurChainageAvant.chainageSimple(); /*ok */
       /* System.out.println(baseAvant.getFaits()+"\n");
        System.out.println("le plus récent\n");
        moteurChainageAvant.appliqueRegleRecent();
        System.out.println(baseAvant.getFaits()+"\n");
        System.out.println("avec le plus de prémices\n");
        moteurChainageAvant.chainagePlusPremicesRecursive(); /*ok*/
        /*System.out.println(baseAvant.getFaits()+"\n");*/
        


        Interface view = new Interface(baseRegle, baseFaitsComplete);
      
        //Gui view=new Gui();
        ReadFile readfile=new ReadFile("ressource/faits.txt");
        readfile.lireRegle("ressource/regles.txt");

        //System.out.println(readfile.getBasefaits());
        System.out.println(readfile.getBaseregle());

    }
}