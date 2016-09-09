package com.example.adityalaksana.elepark;

/**
 * Created by raufimusaddiq on 09/09/16.
 */
public class Position {
    int _id;
    String _floor;
    String _block;
    String _longitude;

    public Position(){

    }

    public Position (int id, String floor, String block, String longitude){
        this._id = id;
        this._floor = floor;
        this._block = block;
        this._longitude = longitude;
    }

    public Position(String floor, String  block, String longitude){
        this._floor = floor;
        this._block = block;
        this._longitude = longitude;
    }

    public int getID(){
        return this._id;
    }

    public void setID(int id){
        this._id = id;
    }

    public String getFloor(){
        return this._floor;
    }

    public void setFloor(String floor){
        this._floor = floor;
    }

    public String getBlock(){
        return this._block;
    }

    public void setBlock(String block){
        this._block = block;
    }

    public String getLongitude(){
        return this._longitude;
    }

    public void setLongitude(String longitude){
        this._longitude = longitude;
    }

}