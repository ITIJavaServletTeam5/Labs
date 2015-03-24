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
public class AssistancequeueCmp implements Comparator<Assistancequeue>{

    @Override
    public int compare(Assistancequeue o1, Assistancequeue o2) {
        return (o1.getRequestDate()).compareTo(o2.getRequestDate());
    }

    
}
