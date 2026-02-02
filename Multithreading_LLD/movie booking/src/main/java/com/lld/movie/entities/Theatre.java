package com.lld.movie.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Theatre {


    private String name;
    private String location;

    // map of screenId vs Screen
    private Map<Integer, Screen> screenMap = new HashMap<>();

    public Theatre( String name , String location )
    {
        this.name = name;
        this.location = location;
    }



    // to add , remove screen
    public void addScreen(Screen screen){
        screenMap.put(screen.getScreenId() , screen);
    }

    public void removeScreen(Integer screenId){
        screenMap.remove(screenId);
    }

    // utility function to get all screens
    public List<Screen> getAllScreens(){
        return List.copyOf(screenMap.values());
    }




}
