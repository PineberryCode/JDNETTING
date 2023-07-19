package model;

import java.util.ArrayList;
import java.util.List;

public class VLSM extends Subnetting {

    public List<Integer> listQuantityHost;
    public List<Integer> listHostRequired;
    public List<Integer> listPrefix;
    public List<Integer> listJump;
    
    public VLSM () {

        listIPAddress = new ArrayList<>();
        listQuantityHost = new ArrayList<>();
        listHostRequired = new ArrayList<>();
        listPrefix = new ArrayList<>();
        listJump = new ArrayList<>();

    }

}
