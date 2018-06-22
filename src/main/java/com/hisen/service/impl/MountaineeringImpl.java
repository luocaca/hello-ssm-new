package com.hisen.service.impl;

import com.hisen.dao.BookDao;
import com.hisen.dao.MountaineeringDao;
import com.hisen.entity.Book;
import com.hisen.entity.Mountaineering;
import com.hisen.service.MountaineeringService;
import org.springframework.beans.factory.annotation.Autowired;

public class MountaineeringImpl implements MountaineeringService {

    @Autowired
    private MountaineeringDao mountaineeringDao;




    @Override
    public Mountaineering queryLately() {
        return mountaineeringDao.queryLately();
    }






}
