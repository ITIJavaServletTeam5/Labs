/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.util.Comparator;

/**
 *
 * @author root
 */
public class DeliveryqueueCmp implements Comparator <Deliveryqueue> {

    @Override
    public int compare(Deliveryqueue o1, Deliveryqueue o2) {
        return o1.getRequestDate().compareTo(o2.getRequestDate());
    }


}
