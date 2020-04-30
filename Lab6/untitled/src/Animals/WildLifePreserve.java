package Animals;

public class WildLifePreserve {
    int numOfAnimals = 50;
    Animals[] wildlife = new Animals[numOfAnimals];


    public void fillAnimalsArr(Animals[] animARR){
        Elk elk1 = new Elk("Duke", 19, 'M', 5.0, 1 );
        Elk elk2 = new Elk("Mary", 14,'F', 3.4, 2);
        Elk elk3 = new Elk("Lisa", 3, 'F', 2.6, 3);
        Bear bear1 = new Bear("Ted", 8, 'M', "Grizzly",
                true, 2);
        Bear bear2 = new Bear("Grace", 5, 'F', "Grizzly",
                false, 2);
        Bear bear3 = new Bear("Suzie", 3, 'F', "Black",
                false, 0);
        Beaver beaver1 = new Beaver("Buck", 6, 'M', "North American",
                "Clark Fork", 4);
        Beaver beaver2 = new Beaver("Betsy", 6, 'F', "North American",
                "Clark Fork", 4);
        Beaver beaver3 = new Beaver("Woody", 2, 'M', "North American",
                "Clark Fork", 4);
        Beaver beaver4 = new Beaver("Ophella", 1, 'F', "North American",
                "Clark Fork", 4);
        Animals[] wildlife = {elk1, elk2, elk3, bear1, bear2, beaver1, beaver2, beaver3, beaver4};

    }


    public void wildLifeReport(Animals[] wildlife){
        String bioDiv = "";
        int bear_count = 0;
        int elk_count = 0;
        int beaver_count = 0;
        System.out.println("MT WildLife Preserve Report");
        System.out.println("Number of Animals: "+wildlife.length);
        for (int i=0; i <wildlife.length; i++){
            System.out.println();
        }



    }
}
