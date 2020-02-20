/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.dvdcollection.controller;

import com.tsguild.dvdCollection.dao.DvdCollectionDao;
import com.tsguild.dvdCollection.dao.DvdCollectionDaoException;
import com.tsguild.dvdCollection.dao.DvdCollectionDaoImpl;
import com.tsguild.dvdcollection.dto.Dvd;
import com.tsguild.dvdcollection.ui.DvdCollectionView;
import java.util.List;
/**
 *
 * @author Craig
 */
public class DvdCollectionController {
    
    DvdCollectionView view;
    DvdCollectionDao dao;

    public void run() {
        boolean keepGoing = true;
        int menuSelection;
        try {
            while (keepGoing) {
                
                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        addDvd();
                        break;
                    case 2:
                        removeDvd();
                        break;
                    case 3:
                        editDvd();
                        break;
                    case 4:
                        listDvds();
                        break;
                    case 5:
                        viewDvd();
                        break;
                    case 6:
                        searchDvd();
                        break;
                    case 7:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        } catch (DvdCollectionDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }
    public DvdCollectionController(DvdCollectionDao dao, DvdCollectionView view) {
        this.dao = dao;
        this.view = view;
}
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
        
    private void addDvd() throws DvdCollectionDaoException {
        view.displayAddDvdBanner();
        Dvd newDvd = view.getNewDvdInfo();
        dao.addDvd(newDvd.getTitle(), newDvd);
        view.displaySuccessBanner();
    }
    
    private void listDvds() throws DvdCollectionDaoException {
        view.displayDisplayAllBanner();
        List<Dvd> dvdList = dao.getAllDvds();
        view.displayDvdList(dvdList);
        view.displaySuccessBanner();
    }

    private void viewDvd() throws DvdCollectionDaoException {
        view.displayDisplayDvdBanner();
        String title = view.getDvdTitleChoice();
        Dvd dvd = dao.getDvd(title);
        view.displayDvd(dvd);
        view.displaySuccessBanner();
    }
    
    private void removeDvd() throws DvdCollectionDaoException {
        view.displayRemoveDvdBanner();
        String title = view.getDvdTitleChoice();
        Dvd dvd = dao.getDvd(title);
        view.displayDvd(dvd);
        if (dvd != null) {
            String remove = view.displayConfirmationBanner();
            if ("Y".equals(remove)) {
                dao.removeDvd(title);
                view.displaySuccessBanner();
            } else {
                view.displayNotRemovedDvdBanner();
            }
        } else {
            view.displayContinueBanner();
        }
    }
    
    private void editDvd() throws DvdCollectionDaoException {
        view.displayEditDvdBanner();
        String title = view.getDvdTitleChoice();
        Dvd dvd = dao.getDvd(title);
        view.displayDvd(dvd);
        if (dvd != null) {
            Dvd newDvd = view.editDvdInfo(dvd);
            dao.addDvd(newDvd.getTitle(), newDvd);
            view.displaySuccessBanner();
        } else {
            view.displayContinueBanner();
        }
    }
    
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
        
    private void searchDvd() throws DvdCollectionDaoException {
        view.displaySearchDvdBanner();
        String searchTitle = view.getDvdTitleChoice();
        List<Dvd> dvdList = dao.getAllDvds();
        view.searchDvd(dvdList, searchTitle);
        view.displayContinueBanner();
    }
}
