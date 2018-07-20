package com.hisen.service;

import com.hisen.entity.Mountaineering;

public interface MountaineeringService {



    Mountaineering queryLately();


    int addMountaineering(Mountaineering mountaineering);



    int updateMountaineering(Mountaineering mountaineering);



}
