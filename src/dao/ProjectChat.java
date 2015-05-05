package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import dto.FeedObjectsChat;


public class ProjectChat {
	
	
	public ArrayList<FeedObjectsChat> GetFeeds(Connection connection) throws Exception
	{
		ArrayList<FeedObjectsChat> feedDataChat = new ArrayList<FeedObjectsChat>();
		
		try
		{
			
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM mensagens");			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				FeedObjectsChat feedObject = new FeedObjectsChat();
				feedObject.setId(rs.getString("id"));
				feedObject.setNome(rs.getString("name_user"));
				feedObject.setMsg(rs.getString("msg"));
				feedObject.setId_festa(rs.getString("party_id"));			
				feedDataChat.add(feedObject);
				
			}
			connection.close();
			rs.close();
			ps.close();
			return feedDataChat;
			
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
}
