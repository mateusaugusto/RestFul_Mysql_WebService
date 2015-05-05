package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import dto.FeedObjects;


public class Project {
	
	
	public ArrayList<FeedObjects> GetFeeds(Connection connection) throws Exception
	{
		ArrayList<FeedObjects> feedData = new ArrayList<FeedObjects>();
		String caminho = "http://10.0.2.2/Dropbox/TCC/painel_web/painel/adm/fotos/";
		String logo;
		Date date = new Date();
		SimpleDateFormat formatter5=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");			
		String data = formatter5.format(date);
		try
		{
			
			//PreparedStatement ps = connection.prepareStatement("SELECT * FROM party WHERE date_end between"+data+" and date_end;");
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM party");			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				FeedObjects feedObject = new FeedObjects();
				feedObject.setId(rs.getString("id"));
				feedObject.setNome(rs.getString("name"));
				feedObject.setLocal(rs.getString("local"));
				feedObject.setDate_start(rs.getString("date_start"));				
				feedObject.setDescricao(rs.getString("description"));
				logo = (rs.getString("picture"));
				feedObject.setLogo(caminho+logo);				
				feedData.add(feedObject);
			}
			connection.close();
			rs.close();
			ps.close();
			return feedData;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
}
