import java.util.Scanner;

public class BACKUP {
    public class Animals {
        protected String name;
        protected int age;
        protected char gender;

        public String getName(){
            return name;
        }
        public void setName(String newName){
            this.name = newName;
        }
        public int getAge(){
            return age;
        }

        public void setAge(int newAge){
            this.age = newAge;
        }
        public char getGender(){
            return gender;
        }
        public void setGender(char newGender){
            this.gender = newGender;
        }

        class Beaver extends Animals {
            String type;
            String lodgelocation;
            int familySize;
            Scanner scan = new Scanner(System.in);
            public String getType(){
                return this.type;
            }
            public void setType(String newType){
                type = newType;
            }
            public String getLodgelocation(){
                return this.lodgelocation;
            }
            public void setLodgelocation(String newLocation){
                this.lodgelocation = newLocation;
            }
            public int getFamilySize(){
                return this.familySize;
            }
            public void setFamilySize(int newSize){
                this.familySize = newSize;
            }
            public void awesomeness(){
                System.out.println("How awesome are beaver?" );
                System.out.println("Enter a number 1-5. 1 = Not Awesome, 5 = SOOOOO AWESOME");
                int opinion = scan.nextInt();
                if (opinion !=5)
                    System.out.println("Wrong Answer. Beavers are SOOOOO AWESOME");
            }
        }

        class Elk extends Animals {
            String type;
            double antlerSize;
            int rankInPack;
            public String getType(){
                return this.type;
            }
            public void setType(String newType){
                type = newType;
            }
            public double getAntlerSize(){
                return this.antlerSize;
            }
            public void setAntlerSize(double newSize){
                antlerSize = newSize;
            }
            public int getRankInPack(){
                return this.rankInPack;
            }
            public void setRankInPack(int newPlace){
                rankInPack = newPlace;
            }
            public void huntingRegulations(){
                System.out.println("Archer season: Sept 5 - Oct 18");
                System.out.println("General: Oct 24 - Nov 29");
            }
        }

        class Bear extends Animals {
            String type;
            Boolean historyOfDanger;
            int sleuthSize;

            public String getType(){
                return this.type;
            }
            public void setType(String newType){
                type = newType;
            }
            public Boolean getHistoryOfDanger(){
                return this.historyOfDanger;
            }
            public void setHistoryOfDanger(Boolean newDanger){
                historyOfDanger = newDanger;
            }
            public int getSleuthSize(){
                return this.sleuthSize;
            }
            public void setSleuthSize(int newSize){
                sleuthSize = newSize;
            }
            public void bearProtocol(){
                System.out.println("1. Speak firmly to the bear");
                System.out.println("2. Back away slowly");
                System.out.println("3. Keep eye on bear");
            }

        }
    }
}
