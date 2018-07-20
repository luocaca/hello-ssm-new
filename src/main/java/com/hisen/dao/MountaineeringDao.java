package com.hisen.dao;

import com.hisen.entity.Book;
import com.hisen.entity.Mountaineering;

public interface MountaineeringDao {


    /*  */
    Mountaineering queryLately();



    /*   */

    int addMountaineering(Mountaineering mountaineering);


    int updateMountaineering(Mountaineering mountaineering);


}
