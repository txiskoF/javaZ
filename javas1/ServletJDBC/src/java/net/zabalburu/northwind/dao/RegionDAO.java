/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.northwind.dao;

import java.util.List;
import net.zabalburu.northwind.modelo.Region;

/**
 *
 * @author ichueca
 */
public interface RegionDAO {
    Region getRegion(Integer id);
    List<Region> getRegiones();
}
