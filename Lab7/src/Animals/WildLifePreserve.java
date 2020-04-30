package Animals;

// "Zoo" class
public class WildLifePreserve {

        // "Zoo" array - What is the best way to declare the length?
        int numOfAnimals = 11;
        Animals[] wildlife = new Animals[numOfAnimals];

        // constructor
        WildLifePreserve(){}

    // Manually Filling each Array index with animal data - What is a better way to do it?
    public void fillAnimalsArr(Animals[] animalArr){
        animalArr[0] = new Bear("Ted", 8, 'M', "Grizzly",
                true, 2);
        animalArr[1]= new Bear("Grace", 5, 'F', "Grizzly",
                false, 2);
        animalArr[2] = new Bear("Suzie", 3, 'F', "Black",
                false, 0);
        animalArr[3] = new Beaver("Buck", 6, 'M', "North American",
                "Clark Fork", 4);
        animalArr[4] = new Beaver("Betsy", 6, 'F', "North American",
                "Clark Fork", 4);
        animalArr[5] = new Beaver("Woody", 2, 'M', "North American",
                "Clark Fork", 4);
        animalArr[6] = new Beaver("Ophella", 1, 'F', "North American",
                "Clark Fork", 4);
        animalArr[7] = new Elk( "Duke", 19, 'M', 5.0, 1 );
        animalArr[8] = new Elk("Mary", 14,'F', 3.4, 2);
        animalArr[9] = new Elk("Lisa", 3, 'F', 2.6, 3);
        animalArr[10] = new Bear("Delilah", 7, 'F', "Black",
                true, 0);
    }

    // Method to get count of each animal
    public int bearcount(Animals[] wildlife){
            int bear_count =0;
        for (int i=0; i <wildlife.length; i++){
            if (wildlife[i].species.equals("Bear"))
                bear_count+=1;
        }
        return bear_count;
    }
    public int beavercount(Animals[]wildlife){
        int beaver_count = 0;
        for (int i=0; i <wildlife.length; i++){
            if (wildlife[i].species.equals("Beaver"))
                beaver_count+=1;
        }
        return beaver_count;
    }
    public int elkcount(Animals[]wildlife){
            int elk_count = 0;
        for (int i=0; i <wildlife.length; i++){
            if (wildlife[i].species.equals("Elk"))
                elk_count+=1;
        }
        return elk_count;
    }

    // Report Method to get/display Animal pop.
    public void wildLifeReport(Animals[] wildlife){
        String bioDiv = "";
        System.out.println("~~ MT WildLife Preserve Report ~~");
        System.out.println("Number of Animals: "+wildlife.length);
        int elk_count = elkcount(wildlife);
        int bear_count = bearcount(wildlife);
        int beaver_count= beavercount(wildlife);
        System.out.println("Bear Population: "+bear_count);
        System.out.println("Elk population: "+elk_count);
        System.out.println("Beaver Population: "+beaver_count);

        // Biodiversity is just making sure there are not more bears than other animals
        if (bear_count>beaver_count || bear_count > elk_count)
            System.out.println("Biodiversity: WARNING! Too many Bears");
        else
            System.out.println("Biodiversity: Healthy");
        System.out.println();
    }

    // Report on just bears - I didn't feel like the wildlife report was extensive enough
    public void bearReport(Animals[] animArr){

            // variables for average age, total bears, and type count
            int averageAge = 0;
            int bearcount = bearcount(wildlife);
            int typeBlack = 0;
            int typeGrizzly = 0;
        System.out.println("~~ Bear Report ~~");

        // Loop through animal array to filter only bears
        for (int i=0; i <animArr.length; i++){
            if (animArr[i].species.equals("Bear")){

                // creating new bear object from array index
                Bear bear = (Bear)animArr[i];

                // Printing each Bear's info
                System.out.println("Name: "+ bear.name);
                System.out.println("Type: " + bear.type);

                // counting type
                if(bear.type.equals("Black"))
                    typeBlack+=1;
                if (bear.type.equals("Grizzly"))
                    typeGrizzly+=1;
                System.out.println("Age: "+ bear.age);

                // totaling age
                averageAge+=bear.age;
                System.out.println("Gender: "+ bear.gender);
                System.out.println("Sleuth size: "+ bear.sleuthSize);
                System.out.println("History of danger: "+ bear.historyOfDanger);
                System.out.println();
                }
            }

        // Report summary
        System.out.println("~ Bear Report Summary ~");
        System.out.println("Bear Population:" + bearcount);
        System.out.printf("Black Bear pop.: %s -- %.1f%%\n" , typeBlack, (((typeBlack*1.0)/bearcount)*100));
        System.out.printf("Grizzly Bear pop.: %s -- %.1f%%\n" , typeGrizzly, (((typeGrizzly*1.0)/bearcount)*100));
        System.out.printf("Average age: %.2f\n", (averageAge*1.0)/bearcount(wildlife));
        }
    }

