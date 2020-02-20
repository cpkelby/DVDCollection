/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.dvdcollection.ui;

import com.tsguild.dvdcollection.dto.Dvd;
import java.util.List;

/**
 *
 * @author Craig
 */
public class DvdCollectionView {
    
   // UserIO io = new UserIOConsoleImpl();
    private UserIO io;
    
    public DvdCollectionView(UserIO io) {
        this.io = io;
}
    
    public int printMenuAndGetSelection() {
        io.print("");
        io.print("    DVD Collection");
        io.print("      MAIN MENU");
        io.print("");
        io.print("    1. Add a DVD");
        io.print("    2. Remove a DVD");
        io.print("    3. Edit a DVD");
        io.print("    4. List all DVDs");
        io.print("    5. View a DVD");
        io.print("    6. Search for a DVD by title");
        io.print("    7. Exit");
        io.print("");
	            
        return io.readInt("    ENTER choice ", 1, 7);
    }
    
    public Dvd getNewDvdInfo() {
        io.print("");
        String title = io.readString("Please enter Title");
        String releaseDate = io.readString("Please enter Release Date");
        String mpaaRating = io.readString("Please enter MPAA Rating");
        String directorName = io.readString("Please enter Director's Name");
        String studio = io.readString("Please enter Studio");
        String userRating = io.readString("Please enter User Rating");
        Dvd currentDvd = new Dvd(title);
        currentDvd.setReleaseDate(releaseDate);
        currentDvd.setMpaaRating(mpaaRating);
        currentDvd.setDirectorName(directorName);
        currentDvd.setStudio(studio);
        currentDvd.setUserRating(userRating);
        return currentDvd;
    }
    
    public void displayAddDvdBanner() {
        io.print("");
        io.print("=== ADD DVD ===");
    }

    public void displaySuccessBanner() {
        io.print("");
        io.readString("Success!  Press <ENTER> to continue");
    }

    public void displayDvdList(List<Dvd> dvdList) {
        for (Dvd currentDvd : dvdList) {
            io.print("");
            io.print(currentDvd.getTitle() + ": "
                    + currentDvd.getReleaseDate() + ": "
                    + currentDvd.getMpaaRating() + ": "
                    + currentDvd.getDirectorName() + ": "
                    + currentDvd.getStudio() + ": "
                    + currentDvd.getUserRating());
        }
    }
    
    public void displayDisplayAllBanner() {
        io.print("");
        io.print("=== Display All DVDs ===");
    }
    
    public void displayDisplayDvdBanner () {
        io.print("");
        io.print("=== Display DVD ===");
    }
    
    public String getDvdTitleChoice() {
        return io.readString("Please enter the DVD Title.");
    }
    
    public void displayDvd(Dvd dvd) {
        if (dvd != null) {
            io.print("");
            io.print(dvd.getTitle());
            io.print(dvd.getReleaseDate());
            io.print(dvd.getMpaaRating());
            io.print(dvd.getDirectorName());
            io.print(dvd.getStudio());
            io.print(dvd.getUserRating());
        } else {
            io.print("");
            io.print("No such DVD Title.");
        }
     }
    
    public void displayRemoveDvdBanner () {
        io.print("");
        io.print("=== Remove DVD ===");
    }
        
    public String displayConfirmationBanner() {
        io.print("");
        return io.readString("Are You Sure (Y/N)");
    }
    
    public String displayContinueBanner() {
        io.print("");
        return io.readString("Press <ENTER> to continue");
    }
        
            
    public void displayNotRemovedDvdBanner () {
        io.print("");
        io.print("=== DVD Not Removed ===");
    }
    
    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
    
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
    
    public void displayEditDvdBanner() {
        io.print("");
        io.print("    EDIT DVD Collection Menu:");
    }

    public Dvd editDvdInfo(Dvd dvd) {       
        Dvd currentDvd = new Dvd(dvd.getTitle());
       
        String releaseDate = io.readString("      Change Release Date to");
        if (releaseDate.trim().isEmpty()) {
            currentDvd.setReleaseDate(dvd.getReleaseDate());
        } else {
            currentDvd.setReleaseDate(releaseDate);
        }
        String mpaaRating = io.readString("      Change MPAA Rating to");
        if (mpaaRating.trim().isEmpty()) {
            currentDvd.setMpaaRating(dvd.getMpaaRating());
        } else {
            currentDvd.setMpaaRating(mpaaRating);
        }

        String directorName = io.readString("      Change Directors Name to");
        if (directorName.trim().isEmpty()) {
            currentDvd.setDirectorName(dvd.getDirectorName());
        } else {
            currentDvd.setDirectorName(directorName);
        }

        String studio = io.readString("      Change Studio Name to");
        if (studio.trim().isEmpty()) {
            currentDvd.setStudio(dvd.getStudio());
        } else {
            currentDvd.setStudio(studio);
        }
        
        String userRating = io.readString("      Change User Rating to");
        if (userRating.trim().isEmpty()) {
            currentDvd.setUserRating(dvd.getUserRating());
        } else {
            currentDvd.setUserRating(userRating);
        }      
        return currentDvd;

    }
        
    public void displaySearchDvdBanner () {
        io.print("");
        io.print("=== Search DVD By Title ===");
    }
    
    public void searchDvd(List<Dvd> dvdList,String search) {
        boolean notFound = true;
        for (Dvd currentDvd : dvdList) {
            String title = currentDvd.getTitle();
            if (title.contains(search)) {
                io.print("");
                io.print(title);
                notFound = false;
            }
        }
        if (notFound) {
            io.print("");
            io.print("    DVD Title Not Found");
        }
    }
}
