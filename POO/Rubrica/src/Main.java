public class Main {
    public static void main(String[] args) {
        Rubrica r = new Rubrica();

        r.addContatto(new Contatto("Mistress", "Stellina", "Stellinosa", "Zucchina", "12345", "stelline@boh.it"));
        r.addContatto(new Contatto("Mister", "MaoMao", "Gattino", "Isola dei mao", "666balbuziente", "maomao@boh.it"));
        r.addContatto(new Contatto("Mister", "Principino", "Panzarottino", "Lettino", "Sono il re",
                                   "panzarotto@boh.it"));
        //System.out.println(r);

        //System.out.println(r.searchCognome("Panzarottino"));
        System.out.println(r.searchNomeCognome("MaoMao", "Gatto"));




    }
}
