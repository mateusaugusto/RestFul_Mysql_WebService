package model;

import java.sql.Connection;
import java.util.ArrayList;

import dao.Database;

import dao.ProjectChat;

import dto.FeedObjectsChat;

public class ProjectManagerChaT {
	
	
	public ArrayList<FeedObjectsChat> GetFeeds()throws Exception {
		ArrayList<FeedObjectsChat> feedsChat = null;
		try {
			    Database database= new Database();
			    Connection connection = database.Get_Connection();
				ProjectChat project= new ProjectChat();
				feedsChat = project.GetFeeds(connection);
			
		
		} catch (Exception e) {
			throw e;
		}
		return feedsChat;
	}
	
	
}
