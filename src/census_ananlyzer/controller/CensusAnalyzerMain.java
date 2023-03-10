package census_ananlyzer.controller;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import census_ananlyzer.exceptions.CustomExceptions;
import census_ananlyzer.model.CensusData;
import census_ananlyzer.model.StateCSVFile;
import census_ananlyzer.utility.ExceptionType;

public class CensusAnalyzerMain {
    
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<CensusData> censusList = new ArrayList<>();
    public static List<StateCSVFile> stateList = new ArrayList<>();
    public static int i = 0;
    
    
    private static void createFile(File file) {
        try {
            if (file.createNewFile()) {
                System.out.println("File Created");
            } else {
                System.out.println("File Already Exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static int loadStateData(String filePath) throws Exception {
        try {
            i = 0;
            stateList = new ArrayList<>();
            CSVReader reader = new CSVReader(new FileReader(filePath));
            List<String[]> data = reader.readAll();
            data.stream().forEach(n -> {
                Iterator<String> iterate = Arrays.stream(n).iterator();
                String srNo = iterate.next();
                String state = iterate.next();
                String TIN = iterate.next();
                String stateCode = iterate.next();
                if (i == 0)
                    i = 1;
                else
                    stateList.add(new StateCSVFile(Integer.valueOf(srNo), state, Integer.valueOf(TIN), stateCode));
            });
            reader.close();
        } catch (FileNotFoundException e) {
            throw new CustomExceptions(e.getMessage(), ExceptionType.File_Not_Found);
        } catch (IllegalStateException e) {
            throw new CustomExceptions(e.getMessage(), ExceptionType.Parse_Error);
        }
        return stateList.size();
    }
    
    
    public static int loadCensusData(String filePath) throws Exception {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> data = reader.readAll();
            data.stream().forEach(n -> {
                Iterator<String> iterate = Arrays.stream(n).iterator();
                String state = iterate.next();
                String population = iterate.next();
                String areaInSqKm = iterate.next();
                String densityPerSqKm = iterate.next();
                if (!population.equals("Population")) {
                    censusList.add(new CensusData(state, Long.parseLong(population), Long.parseLong(areaInSqKm), Integer.parseInt(densityPerSqKm)));
                }
            });
        } catch (IOException e)
        {
            throw new CustomExceptions(e.getMessage(), ExceptionType.File_Not_Found);
        } catch (IllegalStateException | NumberFormatException e) 
        {
            throw new CustomExceptions(e.getMessage(), ExceptionType.Parse_Error);
        }
        return censusList.size();
    }
    
    public static void main(String[] args) throws Exception {
        
        final String filePath = "StateCensus.csv";
        File file = new File(filePath);
        
        int choice=0;
        do {
        System.out.println("Choose an option:");
        System.out.println("1. Create file");
        System.out.println("2. Load census data");
        System.out.println("3. Load State Data");
        System.out.println("4. Exit");
        
        int userchoice = scanner.nextInt();
        switch (userchoice) {
            case 1:
                createFile(file);
                break;
            case 2:
                int count = loadCensusData(filePath);
                System.out.println("Number of entries loaded: " + count);
                break;
            case 3:
    			loadStateData(filePath);
    			break;
            case 4:
                System.exit(0);
            default:
                System.out.println("Invalid choice");
        }
    } while (choice != 4);
    
    }
    
}
