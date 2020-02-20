/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.dvdCollection.dao;

import com.tsguild.dvdcollection.dto.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class DvdCollectionDaoImpl implements DvdCollectionDao {
    
    public static final String COLLECTION_FILE = "collection.txt";
    public static final String DELIMITER = "::";
    
    private Map<String, Dvd> dvds = new HashMap<>();

    @Override
    public Dvd addDvd(String title, Dvd dvd) 
     throws DvdCollectionDaoException {
        Dvd newDvd = dvds.put(title, dvd);
        writeCollection();
        return newDvd;
    }

    @Override
    public Dvd removeDvd(String title)
     throws DvdCollectionDaoException {
        Dvd removedDvd = dvds.remove(title);
        writeCollection();
        return removedDvd;
    }

    @Override
    public Dvd editDvd(String title) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Dvd> getAllDvds()
     throws DvdCollectionDaoException {
        loadCollection();
        return new ArrayList<Dvd>(dvds.values());
    }

    @Override
    public Dvd getDvd(String title) 
     throws DvdCollectionDaoException {
        loadCollection();
        return dvds.get(title);
    }
    
    private void loadCollection() throws DvdCollectionDaoException {
        Scanner scanner;
	    
        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(COLLECTION_FILE)));
        } catch (FileNotFoundException e) {
	        throw new DvdCollectionDaoException(
	                "-_- Could not load collection data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentTokens holds each of the parts of the currentLine after it has
        // been split on our DELIMITER
        // CurrentTokens will be a string array that looks like this:
        //
        // _____________________________________________________________
        // |     |           |          |            |      |          |
        // |Title|releaseDate|mpaaRating|directorName|studio|userRating|
        // |     |           |          |            |      |          |
        // -------------------------------------------------------------
        //  [0]       [1]         [2]         [3]       (4)     (5)
        String[] currentTokens;
        // Go through COLLECTION_FILE line by line, decoding each line into a 
        // DVD object.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // break up the line into tokens
            currentTokens = currentLine.split(DELIMITER);
            // Create a new DVD object and put it into the map of DVDs
            // Use title which is currentTokens[0] as the map key for our DVD object.
            // Pass the title into the DVD constructor
	    Dvd currentDvd = new Dvd(currentTokens[0]);
            // Set the remaining vlaues on currentDvd manually
            currentDvd.setReleaseDate(currentTokens[1]);
            currentDvd.setMpaaRating(currentTokens[2]);
            currentDvd.setDirectorName(currentTokens[3]);
            currentDvd.setStudio(currentTokens[4]);
            currentDvd.setUserRating(currentTokens[5]);
	        
            // Put currentDvd into the map using title as the key
            dvds.put(currentDvd.getTitle(), currentDvd);
        }
        // close scanner
        scanner.close();
    }
    
    /**
    * Writes all DVDs in the collection out to a COLLECTION_FILE.  See loadRoster
    * for file format.
    * 
    * @throws DvdCollectionDaoException if an error occurs writing to the file
    */
    private void writeCollection() throws DvdCollectionDaoException {
        // NOTE FOR APPRENTICES: We are not handling the IOException - but
        // we are translating it to an application specific exception and 
        // then simple throwing it (i.e. 'reporting' it) to the code that
        // called us.  It is the responsibility of the calling code to 
        // handle any errors that occur.
        PrintWriter out;
	    
        try {
            out = new PrintWriter(new FileWriter(COLLECTION_FILE));
        } catch (IOException e) {
            throw new DvdCollectionDaoException(
                    "Could not save DVD Collection data.", e);
        }
	    
        // Write out the DVD objects to the collection file.
        List<Dvd> dvdList = this.getAllDvds();
        for (Dvd currentDvd : dvdList) {
        // write the DVD object to the file
            out.println(currentDvd.getTitle() + DELIMITER
                    + currentDvd.getReleaseDate() + DELIMITER 
                    + currentDvd.getMpaaRating() + DELIMITER
                    + currentDvd.getDirectorName() + DELIMITER 
                    + currentDvd.getStudio() + DELIMITER
                    + currentDvd.getUserRating());
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }
}
