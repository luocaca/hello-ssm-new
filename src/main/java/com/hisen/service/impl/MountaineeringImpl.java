package com.hisen.service.impl;

import com.hisen.dao.MountaineeringDao;
import com.hisen.entity.Mountaineering;
import com.hisen.service.MountaineeringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MountaineeringImpl implements MountaineeringService {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private MountaineeringDao mountaineeringDao;


    @Override
    public Mountaineering queryLately() {
        return mountaineeringDao.queryLately();
    }

    @Override
    public int addMountaineering(Mountaineering mountaineering) {
        return mountaineeringDao.addMountaineering(mountaineering);
    }

    @Override
    public int updateMountaineering(Mountaineering mountaineering) {
        return mountaineeringDao.updateMountaineering(mountaineering);
    }


}
