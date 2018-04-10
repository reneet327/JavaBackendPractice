package com.musicbuddy.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.musicbuddy.model.Album;

@Controller
@RequestMapping("/music")
public class MusicController {
	
	@GetMapping()
	public String showMusic(Model model) {
		
		//create an array list to put all the albums into
		ArrayList<Album> lists = new ArrayList<Album>();
		// connection to the database
        Connection con;

        // connecting to the database can potentially result in an error, so a try-catch block is used to catch this
        try {
            // connect to the "chinook.db" database
            // the last two empty strings in the method are for username and password, which aren't necessary here
            con = DriverManager.getConnection("jdbc:sqlite:./chinook.db", "", "");

            // prepare a Statement object for SQL queries
            Statement stmt = con.createStatement();

            // get all columns from the table "Album"
            ResultSet rs = stmt.executeQuery("SELECT albums.Title, artists.Name FROM albums INNER JOIN artists ON albums.ArtistId = artists.ArtistId");

            // variables for each column in the database
            
            String albumTitle;
            String artistName;

            // access each row in the table
            while (rs.next()) {
                // get the values from each column of the current row
                albumTitle = rs.getString("Title");
                artistName = rs.getString("Name");
                
                lists.add(new Album(albumTitle, artistName));
                
            }
        } catch (SQLException e) {
            // print the stack trace of the error
            e.printStackTrace();
        }
        model.addAttribute("lists", lists);
		return "view";
		
	}
}
