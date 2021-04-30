public class city implements Comparable<city> {
    public String code;
    public String name;
    public int population;


    @Override
    public int compareTo(city otherCity) {
        return -1 * Integer.compare(getPopulation(), otherCity.getPopulation());
    }

    public city(String code, String name, int population){
        this.code = code;
        this.name = name;
        this.population = population;
    }

    public int getPopulation(){
        return this.population;
    }
}