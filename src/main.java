import java.io.*;
import java.util.Scanner;

import java.util.*;

public class main {
public static void main(String args[]) throws IOException
{


// store cities and countries in lists.
List<city> cities = get_cities();
List<String> country_codes = get_countries();


// make the hashtable 
Hashtable<String, List<city> > country_city_ht = new Hashtable<>();

for(String s: country_codes){
    List<city> cities_in_country = new ArrayList<city>(); 
    for(city c: cities){      
        if(s.equals(c.code) ){     
            cities_in_country.add(c);
        }
    }
            country_city_ht.put(s, cities_in_country);
}



// traverse the hashtable and sort the list of cities and get the highest populated city
highest_pop_cities(country_city_ht);


System.out.println("success!!");

}

public static void highest_pop_cities(Hashtable<String, List<city>> country_city_ht){


            for (Map.Entry mapElement : country_city_ht.entrySet()) {

            List<city> temp_list = (List<city>)mapElement.getValue();
            Collections.sort(temp_list);
            

            try{
                System.out.print("country code: " + mapElement.getKey());
                 System.out.print( " highest populated city: " + temp_list.get(0).name);
             }
             catch(Exception e){

             }

            System.out.println();
            System.out.println();

        }
}

public static List<String> get_countries()throws IOException
{ 
// countriesssss
File f_countries = new File("Countries.txt");
Scanner myObj = new Scanner(f_countries);  // Create a Scanner object

List<String> countries = new ArrayList<String>();

while(myObj.hasNextLine() ){
String line = myObj.nextLine();
String[] country_attributes = line.split(", ");
 
countries.add(country_attributes[0]);
}

myObj.close();
return countries;

}

public static List<city> get_cities  () throws IOException
{
// citiesssssss

File f_cities = new File("Cities.txt");
Scanner myObj = new Scanner(f_cities);  // Create a Scanner object


List<city> cities = new ArrayList<city>();

while(myObj.hasNextLine() ){
String line = myObj.nextLine();
String[] attributes = line.split(", ");
cities.add(new city(attributes[3], attributes[1], Integer.parseInt(attributes[2]) ));
}

myObj.close();
return cities;
}

}


