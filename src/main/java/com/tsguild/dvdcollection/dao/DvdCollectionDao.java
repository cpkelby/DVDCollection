package com.tsguild.dvdCollection.dao;

import com.tsguild.dvdcollection.dto.Dvd;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Craig
 */
public interface DvdCollectionDao { 
    /**
     * Adds the given DVD to the collection and associates it with the given 
     * title. If there is already a DVD associated with the given 
     * title it will return that DVD object, otherwise it will 
     * return null.
     * 
     * @param title with which DVD is to be associated
     * @param dvd DVD to be added to the roster
     * @return the DVD object previously associated with the given  
     * title if it exists, null otherwise
    */
    Dvd addDvd(String title, Dvd dvd)
     throws DvdCollectionDaoException;
    
    /**
     * Removes from the collection the DVD associated with the given title. 
     * Returns the DVD object that is being removed or null if 
     * there is no DVD associated with the given title
     *  
     * @param title of DVD to be removed
     * @return DVD object that was removed or null if no DVD 
     * was associated with the given title
    */
    Dvd removeDvd(String title)
     throws DvdCollectionDaoException;
    
    /**
     * Returns the DVD object associated with the given title.
     * Returns null if no such title exists
     * Then Replaces the given DVD to the collection and associates it with the given 
     * title. 
     * 
     * @param title of the DVD to retrieve
     * @return the DVD object associated with the given title,  
     * null if no such DVD exists
    */
    Dvd editDvd(String title)
     throws DvdCollectionDaoException;
	    
    /**
     * Returns a String array containing the DVD titles of all 
     * DVDs in the collection.
     * 
     * @return String array containing the titles of all the DVDs 
     * in the collection
    */
    List<Dvd> getAllDvds()
     throws DvdCollectionDaoException;
	    
    /**
    * Returns the DVD object associated with the given title.
    * Returns null if no such title exists
    * 
    * @param title of the DVD to retrieve
    * @return the DVD object associated with the given title,  
    * null if no such DVD exists
    */
    Dvd getDvd(String title)
     throws DvdCollectionDaoException;
	    

}
