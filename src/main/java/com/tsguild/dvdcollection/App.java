/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.dvdcollection;

import com.tsguild.dvdCollection.dao.DvdCollectionDao;
import com.tsguild.dvdCollection.dao.DvdCollectionDaoImpl;
import com.tsguild.dvdcollection.controller.DvdCollectionController;
import com.tsguild.dvdcollection.ui.DvdCollectionView;
import com.tsguild.dvdcollection.ui.UserIO;
import com.tsguild.dvdcollection.ui.UserIOConsoleImpl;

/**
 *
 * @author Craig
 */
public class App {
        
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        DvdCollectionView myView = new DvdCollectionView(myIo);
        DvdCollectionDao myDao = new DvdCollectionDaoImpl();
        DvdCollectionController controller = 
            new DvdCollectionController(myDao, myView);
        controller.run();
    }
}
